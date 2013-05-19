package org.j4gae.deserializer;

import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

public class KeyDeserializer extends JsonDeserializer<Key> {

	@Override
	public Key deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        JsonToken curr = jp.getCurrentToken();
        if (curr == JsonToken.VALUE_STRING || curr.isScalarValue()) {
            String s = jp.getText();
            int pos = s.indexOf('(');
            String kind = s.substring(0, pos);
            String value = s.substring(pos + 1, s.length() - 1);
            return value.charAt(0) == '\''? KeyFactory.createKey(kind, value.substring(1, value.length() - 1)) : KeyFactory.createKey(kind, Long.valueOf(value, 10));
        }
        throw ctxt.mappingException(Cursor.class);
	}

}
