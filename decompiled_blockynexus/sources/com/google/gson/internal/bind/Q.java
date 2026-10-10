package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class Q extends com.google.gson.x<AtomicInteger> {
    Q() {
    }

    @Override // com.google.gson.x
    public AtomicInteger a(JsonReader jsonReader) throws IOException {
        try {
            return new AtomicInteger(jsonReader.nextInt());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
        jsonWriter.value(atomicInteger.get());
    }
}
