package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class S extends com.google.gson.x<AtomicBoolean> {
    S() {
    }

    @Override // com.google.gson.x
    public AtomicBoolean a(JsonReader jsonReader) throws IOException {
        return new AtomicBoolean(jsonReader.nextBoolean());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
        jsonWriter.value(atomicBoolean.get());
    }
}
