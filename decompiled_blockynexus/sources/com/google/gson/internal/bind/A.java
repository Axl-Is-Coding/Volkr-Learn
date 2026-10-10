package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class A extends com.google.gson.x<URI> {
    A() {
    }

    @Override // com.google.gson.x
    public URI a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            String strNextString = jsonReader.nextString();
            if ("null".equals(strNextString)) {
                return null;
            }
            return new URI(strNextString);
        } catch (URISyntaxException e2) {
            throw new JsonIOException(e2);
        }
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, URI uri) throws IOException {
        jsonWriter.value(uri == null ? null : uri.toASCIIString());
    }
}
