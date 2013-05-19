package org.j4gae.serializer;

import com.google.appengine.api.datastore.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CursorSerializerTest extends AbstractTest {

    @Test
    public void testSerialize() throws Exception {
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity e = new Entity(KeyFactory.createKey("foo", 1));
        ds.put(e);
        Query q = new Query("foo");
        QueryResultIterator<Entity> iterator = ds.prepare(q).asQueryResultIterator();
        iterator.next();
        Cursor cursor = iterator.getCursor();
        assertTrue(cursor.toWebSafeString().length() > 0);

        MyClass c = new MyClass();
        c.cursor = cursor;
        String s = objectMapper.writeValueAsString(c);
        MyClass deserialized = objectMapper.readValue(s, MyClass.class);
        assertEquals(cursor, deserialized.cursor);
        assertNull(deserialized.nullCursor);
    }

    private static class MyClass {

        private Cursor cursor;
        private Cursor nullCursor;

    }

}
