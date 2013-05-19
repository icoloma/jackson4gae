package org.j4gae.serializer;

import com.google.appengine.api.blobstore.BlobKey;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class BlobKeySerializer extends JsonSerializer<BlobKey> {
	
	@Override
	public void serialize(BlobKey key, JsonGenerator jgen,
			SerializerProvider serializerProvider) throws IOException,
			JsonProcessingException {
        String s = key.getKeyString();
		jgen.writeString(s);
	}

}
