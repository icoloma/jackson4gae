package org.j4gae.serializer;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.repackaged.com.google.common.io.ByteStreams;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;

import static org.junit.Assert.*;

public class BlobKeySerializerTest extends AbstractTest {

    @Test
    public void testSerialize() throws Exception {
        MyClass c = new MyClass();
        c.blobKey = createBlob();
        String s = objectMapper.writeValueAsString(c);
        MyClass deserialized = objectMapper.readValue(s, MyClass.class);
        assertEquals(c.blobKey, deserialized.blobKey);
        assertNull(deserialized.nullKey);
    }

    public static  BlobKey createBlob() throws IOException, InterruptedException {
        FileService fileService = FileServiceFactory.getFileService();
        AppEngineFile file = fileService.createNewBlobFile("application/octet-stream", "README.md");
        FileWriteChannel writeChannel = fileService.openWriteChannel(file, true);
        OutputStream output = Channels.newOutputStream(writeChannel);

        InputStream input = new FileInputStream("README.md");
        assertNotNull(input);
        ByteStreams.copy(input, output);
        input.close();
        output.close();
        writeChannel.closeFinally();
        BlobKey blobKey = fileService.getBlobKey(file);
        assertNotNull(blobKey);
        return blobKey;
    }

    private static class MyClass {

        private BlobKey blobKey;
        private BlobKey nullKey;

    }

}
