Jackson4GAE is a Java library of [Jackson](http://jackson.codehaus.org/) serializers and deserializers for common Google AppEngine data types.

Your class can be serialized as JSON including GAE-specific classes:

```JavaScript
{
   key: "Invoice(23)",
   geopt: { lat: 0.345, lng: 0.123 },
   cursor: "E-ABAIICHmoRamFja3NvbjRnYWUtdGVzdHNyCQsSA2ZvbxgBDBQ"
}
```

Currently the library supports Key, BlobKey, Text, GeoPt, Cursor and Search Cursors.

Maven
---

Group `org.extrema-sistemas`, package `jackson4gae`. 

Initialization
---

To use, just add the following to your ObjectMapper initialization code:

```Java
// replace the class list according to your needs
ObjectMapperSetup.addMixins(objectMapper,
  Key.class,
	BlobKey.class,
	GeoPt.class,
	Text.class,
	Cursor.class
);
```

ObjectMapper is not cheap to initialize, so you should keep the instance as a singleton somewhere, preferably in your Dependency Injection configuration.
