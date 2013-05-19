package org.j4gae.serializer;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.tools.development.testing.*;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.j4gae.ObjectMapperSetup;
import org.junit.Before;

public class AbstractTest {

    protected ObjectMapper objectMapper;

    @Before
    public void helperSetup() {
        LocalServiceTestHelper helper = new LocalServiceTestHelper(
                new LocalDatastoreServiceTestConfig()
                        .setNoStorage(true),
                new LocalSearchServiceTestConfig()
                        .setPersistent(false),
                new LocalBlobstoreServiceTestConfig()
                        .setNoStorage(true),
                new LocalFileServiceTestConfig()
        );
        helper
            .setEnvAppId("jackson4gae-tests")
            .setEnvVersionId("1")
            .setEnvRequestNamespace("")
            .setUp()
            ;
    }

    @Before
    public void objectMapperSetup() {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        ObjectMapperSetup.addMixins(objectMapper,
                Key.class,
                BlobKey.class,
                GeoPt.class,
                Text.class,
                com.google.appengine.api.datastore.Cursor.class,
                com.google.appengine.api.search.Cursor.class
        );
    }

}

