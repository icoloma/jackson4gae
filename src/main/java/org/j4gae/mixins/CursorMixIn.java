package org.j4gae.mixins;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.appengine.api.datastore.Cursor;
import org.j4gae.deserializer.CursorDeserializer;
import org.j4gae.serializer.CursorSerializer;

/**
 * Configures the serializer/deserializer for Cursor instances.
 * @author icoloma
 */
@JsonSerialize(using=CursorSerializer.class)
@JsonDeserialize(using=CursorDeserializer.class, as=Cursor.class)
public class CursorMixIn {

	// empty on purpose
	
}
