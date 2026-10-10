package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class x extends com.google.gson.x<Class> {
    x() {
    }

    @Override // com.google.gson.x
    public /* bridge */ /* synthetic */ Class a(JsonReader jsonReader) throws IOException {
        a(jsonReader);
        throw null;
    }

    @Override // com.google.gson.x
    public /* bridge */ /* synthetic */ void a(JsonWriter jsonWriter, Class cls) throws IOException {
        a2(jsonWriter, cls);
        throw null;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(JsonWriter jsonWriter, Class cls) throws IOException {
        throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public Class a(JsonReader jsonReader) throws IOException {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
}
