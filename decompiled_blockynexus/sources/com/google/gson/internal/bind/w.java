package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class w extends com.google.gson.x<StringBuilder> {
    w() {
    }

    @Override // com.google.gson.x
    public StringBuilder a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return new StringBuilder(jsonReader.nextString());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
        jsonWriter.value(sb == null ? null : sb.toString());
    }
}
