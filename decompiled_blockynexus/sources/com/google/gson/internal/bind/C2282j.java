package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: renamed from: com.google.gson.internal.bind.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SqlDateTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2282j extends com.google.gson.x<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.y f14200a = new com.google.gson.y() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter$1
        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new C2282j();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f14201b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.gson.x
    public synchronized Date a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Date(this.f14201b.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.x
    public synchronized void a(JsonWriter jsonWriter, Date date) throws IOException {
        jsonWriter.value(date == null ? null : this.f14201b.format((java.util.Date) date));
    }
}
