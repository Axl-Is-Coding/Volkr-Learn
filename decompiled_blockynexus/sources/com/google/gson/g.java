package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends x<Number> {
    g() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public Number a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return Long.valueOf(jsonReader.nextLong());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Number number) throws IOException {
        if (number == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(number.toString());
        }
    }
}
