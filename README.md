Jackson4GAE
===

Jackson4GAE is a Java library of [Jackson](http://jackson.codehaus.org/) serializers and deserializers for common Google AppEngine data types.

Your class can be serialized as JSON including GAE-specific classes:

```JavaScript
{
   key: "Invoice(23)",
   geopt: { lat: 0.345, lng: 0.123 },
   cursor: "E-ABAIICHmoRamFja3NvbjRnYWUtdGVzdHNyCQsSA2ZvbxgBDBQ"
}
```

Currently the library supports `Key`, `BlobKey`, `Text`, `GeoPt`, `Cursor` and `Search Cursors`.

| Class | Serialized as  | Example
| ------------- | ------------- | ------------- |
| Key | `Key.getKind()` + <br> { `Key.getId()` or `Key.getName()` } | `"Invoice(20)"` <br> `"User('icoloma')"` |
| BlobKey | `BlobKey.getKeyString()` | `"H9gv9XtAEst7S9JaBoyDmA"` |
| Text | `Text.getValue()` | `"foobar"` |
| GeoPt | Json object with `lat` and `lng` | `{ lat: 0.234, lng: 0.345 }` |
| Cursor | `Cursor.toWebSafeString()` | `"E-ABAIICHmoRamFja3NvbjRnYWUtdGVzdHNyCQsSA2ZvbxgBDBQ"` |
| Search cursor | `Cursor.toWebSafeString()` | `"E-ABAIICHmoRamFja3NvbjRnYWUtdGVzdHNyCQsSA2ZvbxgBDBQ"` |

Maven
---

Include this in your pom.xml:

```XML
<dependency>
   <groupId>org.extrema-sistemas</groupId>
   <artifactId>jackson4gae</artifactId>
</dependency>
```

Initialization
---

To use, just add the following to your ObjectMapper initialization code:

```Java
// modify this list including what you need to serialize
ObjectMapperSetup.addMixins(objectMapper,
  Key.class, BlobKey.class, GeoPt.class, Text.class, Cursor.class
);
```

ObjectMapper is not cheap to initialize, so you should keep the instance as a singleton somewhere, preferably in your Dependency Injection configuration.
