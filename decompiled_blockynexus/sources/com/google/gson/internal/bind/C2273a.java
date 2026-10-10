package com.google.gson.internal.bind;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.google.gson.internal.bind.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ArrayTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2273a<E> extends com.google.gson.x<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.y f14182a = new com.google.gson.y() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter$1
        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeD = C$Gson$Types.d(type);
            return new C2273a(jVar, jVar.a((TypeToken) TypeToken.get(typeD)), C$Gson$Types.e(typeD));
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<E> f14183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.x<E> f14184c;

    public C2273a(com.google.gson.j jVar, com.google.gson.x<E> xVar, Class<E> cls) {
        this.f14184c = new C2285m(jVar, xVar, cls);
        this.f14183b = cls;
    }

    @Override // com.google.gson.x
    public Object a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f14184c.a(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f14183b, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f14184c.a(jsonWriter, (E) Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}
