package org.j4gae.deserializer;

import com.google.appengine.api.search.Cursor;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

public class SearchCursorDeserializer extends JsonDeserializer<Cursor> {

	@Override
	public Cursor deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        JsonToken curr = jp.getCurrentToken();
        if (curr == JsonToken.VALUE_STRING || curr.isScalarValue()) {
            return Cursor.newBuilder().build(jp.getText());
        }
        throw ctxt.mappingException(Cursor.class);
	}

}
