package com.google.gson.internal;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Excluder.java */
/* JADX INFO: loaded from: classes2.dex */
class q<T> extends com.google.gson.x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.gson.x<T> f14231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f14232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f14233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.google.gson.j f14234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ TypeToken f14235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Excluder f14236f;

    q(Excluder excluder, boolean z, boolean z2, com.google.gson.j jVar, TypeToken typeToken) {
        this.f14236f = excluder;
        this.f14232b = z;
        this.f14233c = z2;
        this.f14234d = jVar;
        this.f14235e = typeToken;
    }

    private com.google.gson.x<T> b() {
        com.google.gson.x<T> xVar = this.f14231a;
        if (xVar != null) {
            return xVar;
        }
        com.google.gson.x<T> xVarA = this.f14234d.a(this.f14236f, this.f14235e);
        this.f14231a = xVarA;
        return xVarA;
    }

    @Override // com.google.gson.x
    public T a(JsonReader jsonReader) throws IOException {
        if (!this.f14232b) {
            return b().a(jsonReader);
        }
        jsonReader.skipValue();
        return null;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, T t) throws IOException {
        if (this.f14233c) {
            jsonWriter.nullValue();
        } else {
            b().a(jsonWriter, t);
        }
    }
}
