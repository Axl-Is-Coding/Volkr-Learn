package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.gson.internal.bind.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DateTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2274b extends com.google.gson.x<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.y f14186a = new com.google.gson.y() { // from class: com.google.gson.internal.bind.DateTypeAdapter$1
        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new C2274b();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f14187b = new ArrayList();

    public C2274b() {
        this.f14187b.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f14187b.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.r.b()) {
            this.f14187b.add(com.google.gson.internal.x.a(2, 2));
        }
    }

    @Override // com.google.gson.x
    public Date a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return a(jsonReader.nextString());
    }

    private synchronized Date a(String str) {
        Iterator<DateFormat> it = this.f14187b.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return com.google.gson.internal.bind.a.a.a(str, new ParsePosition(0));
        } catch (ParseException e2) {
            throw new JsonSyntaxException(str, e2);
        }
    }

    @Override // com.google.gson.x
    public synchronized void a(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.f14187b.get(0).format(date));
        }
    }
}
