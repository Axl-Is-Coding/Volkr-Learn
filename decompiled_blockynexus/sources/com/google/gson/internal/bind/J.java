package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T1] */
/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class J<T1> extends com.google.gson.x<T1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Class f14130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TypeAdapters$35 f14131b;

    J(TypeAdapters$35 typeAdapters$35, Class cls) {
        this.f14131b = typeAdapters$35;
        this.f14130a = cls;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, T1 t1) throws IOException {
        this.f14131b.f14181b.a(jsonWriter, t1);
    }

    @Override // com.google.gson.x
    public T1 a(JsonReader jsonReader) throws IOException {
        T1 t1 = (T1) this.f14131b.f14181b.a(jsonReader);
        if (t1 == null || this.f14130a.isInstance(t1)) {
            return t1;
        }
        throw new JsonSyntaxException("Expected a " + this.f14130a.getName() + " but was " + t1.getClass().getName());
    }
}
