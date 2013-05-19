package org.j4gae.deserializer;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.google.appengine.api.datastore.GeoPt;

public class GeoPtDeserializer extends JsonDeserializer<GeoPt> {
	
	@Override
	public GeoPt deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonToken token = jp.getCurrentToken();
		if (token != JsonToken.START_OBJECT) {
			throw new IllegalArgumentException("Expected {\"lat\": X,\"lng\": Y}");
		}
		token = jp.nextToken();
		float[] data = new float[2];
		while (token != JsonToken.END_OBJECT) {
			if ("lat".equals(jp.getCurrentName())) {
				jp.nextToken();
				data[0] = (float) jp.getValueAsDouble();
			} else if ("lng".equals(jp.getCurrentName())) {
				jp.nextToken();
				data[1] = (float) jp.getValueAsDouble();
			} else {
				throw new IllegalArgumentException("Unknown attribute: " + jp.getCurrentName());
			}
			token = jp.nextToken();
		}
		return new GeoPt(data[0], data[1]);
	}
	
}
