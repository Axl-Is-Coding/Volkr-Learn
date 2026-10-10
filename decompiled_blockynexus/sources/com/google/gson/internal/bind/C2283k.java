package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: renamed from: com.google.gson.internal.bind.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TimeTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2283k extends com.google.gson.x<Time> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.y f14202a = new com.google.gson.y() { // from class: com.google.gson.internal.bind.TimeTypeAdapter$1
        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new C2283k();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f14203b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.gson.x
    public synchronized Time a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Time(this.f14203b.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.x
    public synchronized void a(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.value(time == null ? null : this.f14203b.format((Date) time));
    }
}
