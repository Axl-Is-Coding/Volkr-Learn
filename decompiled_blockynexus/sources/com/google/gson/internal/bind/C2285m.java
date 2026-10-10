package com.google.gson.internal.bind;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: renamed from: com.google.gson.internal.bind.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2285m<T> extends com.google.gson.x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.j f14204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.x<T> f14205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f14206c;

    C2285m(com.google.gson.j jVar, com.google.gson.x<T> xVar, Type type) {
        this.f14204a = jVar;
        this.f14205b = xVar;
        this.f14206c = type;
    }

    @Override // com.google.gson.x
    public T a(JsonReader jsonReader) throws IOException {
        return this.f14205b.a(jsonReader);
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, T t) throws IOException {
        com.google.gson.x<T> xVarA = this.f14205b;
        Type typeA = a(this.f14206c, t);
        if (typeA != this.f14206c) {
            xVarA = this.f14204a.a((TypeToken) TypeToken.get(typeA));
            if (xVarA instanceof ReflectiveTypeAdapterFactory.a) {
                com.google.gson.x<T> xVar = this.f14205b;
                if (!(xVar instanceof ReflectiveTypeAdapterFactory.a)) {
                    xVarA = xVar;
                }
            }
        }
        xVarA.a(jsonWriter, t);
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
