package com.twitter.sdk.android.core.models;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.x;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeMapAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class l<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f20235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TypeToken f20236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SafeMapAdapter f20237c;

    l(SafeMapAdapter safeMapAdapter, x xVar, TypeToken typeToken) {
        this.f20237c = safeMapAdapter;
        this.f20235a = xVar;
        this.f20236b = typeToken;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, T t) throws IOException {
        this.f20235a.a(jsonWriter, t);
    }

    @Override // com.google.gson.x
    public T a(JsonReader jsonReader) throws IOException {
        T t = (T) this.f20235a.a(jsonReader);
        return Map.class.isAssignableFrom(this.f20236b.getRawType()) ? t == null ? (T) Collections.EMPTY_MAP : (T) Collections.unmodifiableMap((Map) t) : t;
    }
}
