package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class y extends com.google.gson.x<StringBuffer> {
    y() {
    }

    @Override // com.google.gson.x
    public StringBuffer a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return new StringBuffer(jsonReader.nextString());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
        jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
    }
}
