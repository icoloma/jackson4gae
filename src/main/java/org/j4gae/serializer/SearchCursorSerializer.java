package org.j4gae.serializer;

import com.google.appengine.api.search.Cursor;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class SearchCursorSerializer extends JsonSerializer<Cursor> {
	
	@Override
	public void serialize(Cursor cursor, JsonGenerator jgen,
			SerializerProvider serializerProvider) throws IOException,
			JsonProcessingException {
		jgen.writeString(cursor.toWebSafeString());
	}

}
