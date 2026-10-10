package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class L extends com.google.gson.x<Boolean> {
    L() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public Boolean a(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonTokenPeek == JsonToken.STRING) {
            return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
        }
        return Boolean.valueOf(jsonReader.nextBoolean());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Boolean bool) throws IOException {
        jsonWriter.value(bool);
    }
}
