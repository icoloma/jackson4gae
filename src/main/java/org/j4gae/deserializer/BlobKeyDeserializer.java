package org.j4gae.deserializer;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Cursor;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

public class BlobKeyDeserializer extends JsonDeserializer<BlobKey> {

	@Override
	public BlobKey deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        JsonToken curr = jp.getCurrentToken();
        if (curr == JsonToken.VALUE_STRING || curr.isScalarValue()) {
            String s = jp.getText();
            return new BlobKey(s);
        }
        throw ctxt.mappingException(Cursor.class);
	}

}
