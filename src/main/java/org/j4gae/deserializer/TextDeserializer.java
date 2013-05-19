package org.j4gae.deserializer;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

public class TextDeserializer extends JsonDeserializer<Text> {

    @Override
    public Text deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException
    {
        JsonToken curr = jp.getCurrentToken();
        if (curr == JsonToken.VALUE_STRING || curr.isScalarValue()) {
            return new Text(jp.getText());
        }
        throw ctxt.mappingException(Text.class);
    }

}
