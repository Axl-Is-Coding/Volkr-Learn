package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: TypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class w<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f14263a;

    w(x xVar) {
        this.f14263a = xVar;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, T t) throws IOException {
        if (t == null) {
            jsonWriter.nullValue();
        } else {
            this.f14263a.a(jsonWriter, t);
        }
    }

    @Override // com.google.gson.x
    public T a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return (T) this.f14263a.a(jsonReader);
    }
}
