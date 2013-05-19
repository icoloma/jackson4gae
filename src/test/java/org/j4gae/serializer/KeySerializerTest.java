package org.j4gae.serializer;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class KeySerializerTest extends AbstractTest {

    @Test
    public void testSerialize() throws Exception {
        MyClass c = new MyClass();
        c.longKey = KeyFactory.createKey("foo", 23);
        c.stringKey = KeyFactory.createKey("foo", "bar");
        String s = objectMapper.writeValueAsString(c);
        assertEquals("{\"longKey\":\"foo(23)\",\"stringKey\":\"foo('bar')\",\"nullKey\":null}", s);
        MyClass deserialized = objectMapper.readValue(s, MyClass.class);
        assertEquals(c.longKey, deserialized.longKey);
        assertEquals(c.stringKey, deserialized.stringKey);
        assertNull(deserialized.nullKey);
    }

    private static class MyClass {

        private Key longKey;
        private Key stringKey;
        private Key nullKey;

        public Key getStringKey() {
            return stringKey;
        }

        public Key getNullKey() {
            return nullKey;
        }

        public void setNullKey(Key nullKey) {
            this.nullKey = nullKey;
        }
    }

}
