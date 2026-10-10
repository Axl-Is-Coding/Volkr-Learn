package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.google.gson.internal.bind.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class C2287o extends com.google.gson.x<Number> {
    C2287o() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public Number a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return Long.valueOf(jsonReader.nextLong());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
