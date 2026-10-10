package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends x<Number> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f14092a;

    e(j jVar) {
        this.f14092a = jVar;
    }

    @Override // com.google.gson.x
    public Number a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return Double.valueOf(jsonReader.nextDouble());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Number number) throws IOException {
        if (number == null) {
            jsonWriter.nullValue();
        } else {
            j.a(number.doubleValue());
            jsonWriter.value(number);
        }
    }
}
