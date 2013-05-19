package org.j4gae.serializer;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Text;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TextSerializerTest extends AbstractTest {

    @Test
    public void testSerialize() throws Exception {
        MyClass c = new MyClass();
        c.text = new Text("foobar");
        String s = objectMapper.writeValueAsString(c);
        MyClass deserialized = objectMapper.readValue(s, MyClass.class);
        assertEquals(c.text, deserialized.text);
        assertNull(deserialized.nullPoint);
    }

    private static class MyClass {

        private Text text;
        private Text nullPoint;

    }

}
