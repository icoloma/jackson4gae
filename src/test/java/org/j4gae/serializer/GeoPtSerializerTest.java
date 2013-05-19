package org.j4gae.serializer;

import com.google.appengine.api.datastore.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeoPtSerializerTest extends AbstractTest {

    @Test
    public void testSerialize() throws Exception {
        MyClass c = new MyClass();
        c.pt = new GeoPt(10, 5);
        String s = objectMapper.writeValueAsString(c);
        MyClass deserialized = objectMapper.readValue(s, MyClass.class);
        assertEquals(c.pt, deserialized.pt);
        assertNull(deserialized.nullPoint);
    }

    private static class MyClass {

        private GeoPt pt;
        private GeoPt nullPoint;

    }

}
