package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.google.gson.internal.bind.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class C2289q extends com.google.gson.x<Number> {
    C2289q() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public Number a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return Double.valueOf(jsonReader.nextDouble());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
