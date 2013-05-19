package org.j4gae.mixins;

import com.google.appengine.api.datastore.Key;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.j4gae.deserializer.KeyDeserializer;
import org.j4gae.serializer.KeySerializer;

/**
 * Configures the serializer/deserializer for Key instances.
 * @author icoloma
 */
@JsonSerialize(using=KeySerializer.class)
@JsonDeserialize(using=KeyDeserializer.class, as=Key.class)
public class KeyMixIn {

	// empty on purpose
	
}
