package org.j4gae.serializer;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.google.appengine.api.datastore.GeoPt;

public class GeoPtSerializer extends JsonSerializer<GeoPt> {

	@Override
	public void serialize(GeoPt value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeFieldName("lat");
		jgen.writeNumber(value.getLatitude());
		jgen.writeFieldName("lng");
		jgen.writeNumber(value.getLongitude());
		jgen.writeEndObject();
	}

}