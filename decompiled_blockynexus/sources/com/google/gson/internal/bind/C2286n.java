package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: renamed from: com.google.gson.internal.bind.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class C2286n extends com.google.gson.x<AtomicIntegerArray> {
    C2286n() {
    }

    @Override // com.google.gson.x
    public AtomicIntegerArray a(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            try {
                arrayList.add(Integer.valueOf(jsonReader.nextInt()));
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }
        jsonReader.endArray();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
        jsonWriter.beginArray();
        int length = atomicIntegerArray.length();
        for (int i = 0; i < length; i++) {
            jsonWriter.value(atomicIntegerArray.get(i));
        }
        jsonWriter.endArray();
    }
}
