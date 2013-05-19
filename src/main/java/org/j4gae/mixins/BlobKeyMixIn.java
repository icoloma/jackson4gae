package org.j4gae.mixins;

import com.google.appengine.api.blobstore.BlobKey;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.j4gae.deserializer.BlobKeyDeserializer;
import org.j4gae.serializer.BlobKeySerializer;

/**
 * Configures the serializer/deserializer for BlobKey instances.
 * @author icoloma
 */
@JsonSerialize(using=BlobKeySerializer.class)
@JsonDeserialize(using=BlobKeyDeserializer.class, as=BlobKey.class)
public class BlobKeyMixIn {

	// empty on purpose
	
}
