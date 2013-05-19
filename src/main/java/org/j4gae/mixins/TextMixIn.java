package org.j4gae.mixins;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.appengine.api.datastore.Text;
import org.j4gae.deserializer.TextDeserializer;
import org.j4gae.serializer.TextSerializer;

/**
 * Configures the serializer/deserializer for Text instances.
 * @author icoloma
 */
@JsonSerialize(using=TextSerializer.class)
@JsonDeserialize(using=TextDeserializer.class, as=Text.class)
public class TextMixIn {

	// empty on purpose
	
}
