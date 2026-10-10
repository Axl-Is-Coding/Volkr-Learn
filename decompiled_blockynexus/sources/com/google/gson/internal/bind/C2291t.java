package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.google.gson.internal.bind.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class C2291t extends com.google.gson.x<String> {
    C2291t() {
    }

    @Override // com.google.gson.x
    public String a(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonTokenPeek == JsonToken.BOOLEAN) {
            return Boolean.toString(jsonReader.nextBoolean());
        }
        return jsonReader.nextString();
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, String str) throws IOException {
        jsonWriter.value(str);
    }
}
