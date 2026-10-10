package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class C extends com.google.gson.x<UUID> {
    C() {
    }

    @Override // com.google.gson.x
    public UUID a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return UUID.fromString(jsonReader.nextString());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, UUID uuid) throws IOException {
        jsonWriter.value(uuid == null ? null : uuid.toString());
    }
}
