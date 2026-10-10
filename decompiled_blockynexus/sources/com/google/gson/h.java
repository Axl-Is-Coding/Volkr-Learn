package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends x<AtomicLong> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f14094a;

    h(x xVar) {
        this.f14094a = xVar;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
        this.f14094a.a(jsonWriter, Long.valueOf(atomicLong.get()));
    }

    @Override // com.google.gson.x
    public AtomicLong a(JsonReader jsonReader) throws IOException {
        return new AtomicLong(((Number) this.f14094a.a(jsonReader)).longValue());
    }
}
