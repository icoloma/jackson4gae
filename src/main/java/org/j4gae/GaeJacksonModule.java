package org.j4gae;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.j4gae.deserializer.*;
import org.j4gae.serializer.*;

/**
 * Invoke {@code ObjectMapper.registerModule(new JacksonModule())} to register serializers and deserializers to Jackson
 */
public class GaeJacksonModule extends SimpleModule {

    /**
     * Adds serializers/deserializers for AppEngine.
     */
    public GaeJacksonModule() {
        super("Jackson4Gae", Version.unknownVersion());
        addSerializer(Key.class, new KeySerializer());
        addDeserializer(Key.class, new KeyDeserializer());

        addSerializer(BlobKey.class, new BlobKeySerializer());
        addDeserializer(BlobKey.class, new BlobKeyDeserializer());

        addSerializer(GeoPt.class, new GeoPtSerializer());
        addDeserializer(GeoPt.class, new GeoPtDeserializer());

        addSerializer(Text.class, new TextSerializer());
        addDeserializer(Text.class, new TextDeserializer());

        addSerializer(com.google.appengine.api.datastore.Cursor.class, new CursorSerializer());
        addDeserializer(com.google.appengine.api.datastore.Cursor.class, new CursorDeserializer());

        addSerializer(com.google.appengine.api.search.Cursor.class, new SearchCursorSerializer());
        addDeserializer(com.google.appengine.api.search.Cursor.class, new SearchCursorDeserializer());
    }

}
