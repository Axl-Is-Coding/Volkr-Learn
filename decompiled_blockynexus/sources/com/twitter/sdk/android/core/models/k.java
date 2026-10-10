package com.twitter.sdk.android.core.models;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.x;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeListAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class k<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f20232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TypeToken f20233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SafeListAdapter f20234c;

    k(SafeListAdapter safeListAdapter, x xVar, TypeToken typeToken) {
        this.f20234c = safeListAdapter;
        this.f20232a = xVar;
        this.f20233b = typeToken;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, T t) throws IOException {
        this.f20232a.a(jsonWriter, t);
    }

    @Override // com.google.gson.x
    public T a(JsonReader jsonReader) throws IOException {
        T t = (T) this.f20232a.a(jsonReader);
        return List.class.isAssignableFrom(this.f20233b.getRawType()) ? t == null ? (T) Collections.EMPTY_LIST : (T) Collections.unmodifiableList((List) t) : t;
    }
}
