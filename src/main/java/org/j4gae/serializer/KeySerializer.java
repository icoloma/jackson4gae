package org.j4gae.serializer;

import com.google.appengine.api.datastore.Key;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Serializes a Key concatenating the kind and the key value. Knows the difference between
 * names (String-based) and id (long-based) keys. It does not support child keys.
 */
public class KeySerializer extends JsonSerializer<Key> {
	
	@Override
	public void serialize(Key key, JsonGenerator jgen,
			SerializerProvider serializerProvider) throws IOException,
			JsonProcessingException {
        if (key.getParent() != null) {
            throw new IllegalArgumentException("Child keys are not supported");
        }
        String s = key.getName() == null? String.valueOf(key.getId()) : "'" + key.getName() + "'";
		jgen.writeString(key.getKind() + "(" + s + ")");
	}

}
