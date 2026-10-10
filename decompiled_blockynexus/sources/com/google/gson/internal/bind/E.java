package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class E extends com.google.gson.x<Timestamp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.gson.x f14128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TypeAdapters$26 f14129b;

    E(TypeAdapters$26 typeAdapters$26, com.google.gson.x xVar) {
        this.f14129b = typeAdapters$26;
        this.f14128a = xVar;
    }

    @Override // com.google.gson.x
    public Timestamp a(JsonReader jsonReader) throws IOException {
        Date date = (Date) this.f14128a.a(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.f14128a.a(jsonWriter, timestamp);
    }
}
