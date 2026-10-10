package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends x<AtomicLongArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f14095a;

    i(x xVar) {
        this.f14095a = xVar;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
        jsonWriter.beginArray();
        int length = atomicLongArray.length();
        for (int i = 0; i < length; i++) {
            this.f14095a.a(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
        }
        jsonWriter.endArray();
    }

    @Override // com.google.gson.x
    public AtomicLongArray a(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(Long.valueOf(((Number) this.f14095a.a(jsonReader)).longValue()));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; i++) {
            atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
        }
        return atomicLongArray;
    }
}
