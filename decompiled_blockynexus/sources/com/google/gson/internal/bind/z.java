package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class z extends com.google.gson.x<URL> {
    z() {
    }

    @Override // com.google.gson.x
    public URL a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        if ("null".equals(strNextString)) {
            return null;
        }
        return new URL(strNextString);
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, URL url) throws IOException {
        jsonWriter.value(url == null ? null : url.toExternalForm());
    }
}
