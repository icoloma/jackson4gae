package org.j4gae.mixins;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.j4gae.deserializer.GeoPtDeserializer;
import org.j4gae.serializer.GeoPtSerializer;

/**
 * Configures the serializer/deserializer for GeoPt instances.
 * @author icoloma
 */
@JsonDeserialize(using=GeoPtDeserializer.class)
@JsonSerialize(using=GeoPtSerializer.class)
public class GeoPtMixIn {
	
	// empty on purpose
	
}
