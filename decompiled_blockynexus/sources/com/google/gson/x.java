package com.google.gson;

import com.google.gson.internal.bind.C2278f;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: TypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x<T> {
    public final x<T> a() {
        return new w(this);
    }

    public abstract T a(JsonReader jsonReader) throws IOException;

    public abstract void a(JsonWriter jsonWriter, T t) throws IOException;

    public final p a(T t) {
        try {
            C2278f c2278f = new C2278f();
            a(c2278f, t);
            return c2278f.b();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }
}
