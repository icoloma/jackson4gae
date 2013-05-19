package org.j4gae.mixins;

import com.google.appengine.api.search.Cursor;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.j4gae.deserializer.SearchCursorDeserializer;
import org.j4gae.serializer.SearchCursorSerializer;

/**
 * Configures the serializer/deserializer for Search Cursor instances.
 * @author icoloma
 */
@JsonSerialize(using=SearchCursorSerializer.class)
@JsonDeserialize(using=SearchCursorDeserializer.class, as=Cursor.class)
public class SearchCursorMixIn {

	// empty on purpose
	
}
