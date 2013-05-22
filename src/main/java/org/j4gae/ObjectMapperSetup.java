package org.j4gae;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Registers serializers/deserializers of Google AppEngine classes.
 */
public class ObjectMapperSetup {

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
     * @deprecated use {@code ObjectMapper.registerModule(new GaeJacksonModule())} instead
     * @param objectMapper
     * @param classes the list of AppEngine classes to register Jackson serializers/deserializers.
     */
    public static void addMixins(ObjectMapper objectMapper, Class<?>... classes) {
        objectMapper.registerModule(new GaeJacksonModule());
    }

}
