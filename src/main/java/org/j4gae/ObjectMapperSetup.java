package org.j4gae;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import org.codehaus.jackson.map.ObjectMapper;
import org.j4gae.mixins.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Registers serializers/deserializers of Google AppEngine classes.
 */
public class ObjectMapperSetup {

    private static Map<Class<?>, Class<?>> MIXINS;

    static {
        MIXINS = new HashMap<Class<?>, Class<?>>();
        MIXINS.put(Key.class, KeyMixIn.class);
        MIXINS.put(BlobKey.class, BlobKeyMixIn.class);
        MIXINS.put(GeoPt.class, GeoPtMixIn.class);
        MIXINS.put(Text.class, TextMixIn.class);
        MIXINS.put(com.google.appengine.api.datastore.Cursor.class, CursorMixIn.class);
        MIXINS.put(com.google.appengine.api.search.Cursor.class, SearchCursorMixIn.class);
    }

    /**
     * Uses the provided mixin class to indicate the serializer/deserializer of a Google Appengine class
     * @param clazz
     * @param mixinClass
     */
    public static void addMixin(ObjectMapper objectMapper, Class<?> clazz, Class<?> mixinClass) {
        objectMapper.getSerializationConfig().addMixInAnnotations(clazz, mixinClass);
        objectMapper.getDeserializationConfig().addMixInAnnotations(clazz, mixinClass);
    }

    /**
     * Adds mixins for the provided set of AppEngine classes.
     * @param objectMapper
     * @param classes the list of AppEngine classes to register Jackson serializers/deserializers.
     */
    public static void addMixins(ObjectMapper objectMapper, Class<?>... classes) {
        for (Class<?> clazz : classes) {
            Class<?> mixinClass = MIXINS.get(clazz);
            addMixin(objectMapper, clazz, mixinClass);
        }
    }

}
