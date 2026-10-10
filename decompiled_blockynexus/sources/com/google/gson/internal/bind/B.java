package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class B extends com.google.gson.x<InetAddress> {
    B() {
    }

    @Override // com.google.gson.x
    public InetAddress a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return InetAddress.getByName(jsonReader.nextString());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
        jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
