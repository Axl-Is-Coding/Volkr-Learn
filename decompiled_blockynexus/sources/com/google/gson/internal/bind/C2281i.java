package com.google.gson.internal.bind;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: com.google.gson.internal.bind.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
class C2281i extends ReflectiveTypeAdapterFactory.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Field f14197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f14198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.google.gson.x f14199f;
    final /* synthetic */ com.google.gson.j g;
    final /* synthetic */ TypeToken h;
    final /* synthetic */ boolean i;
    final /* synthetic */ ReflectiveTypeAdapterFactory j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2281i(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z, boolean z2, Field field, boolean z3, com.google.gson.x xVar, com.google.gson.j jVar, TypeToken typeToken, boolean z4) {
        super(str, z, z2);
        this.j = reflectiveTypeAdapterFactory;
        this.f14197d = field;
        this.f14198e = z3;
        this.f14199f = xVar;
        this.g = jVar;
        this.h = typeToken;
        this.i = z4;
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
    void a(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
        (this.f14198e ? this.f14199f : new C2285m(this.g, this.f14199f, this.h.getType())).a(jsonWriter, this.f14197d.get(obj));
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
    void a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException {
        Object objA = this.f14199f.a(jsonReader);
        if (objA == null && this.i) {
            return;
        }
        this.f14197d.set(obj, objA);
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
    public boolean a(Object obj) throws IllegalAccessException, IOException {
        return this.f14148b && this.f14197d.get(obj) != obj;
    }
}
