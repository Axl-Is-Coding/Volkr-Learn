package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: DefaultDateTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends x<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends Date> f14089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f14090b = new ArrayList();

    a(Class<? extends Date> cls, String str) {
        a(cls);
        this.f14089a = cls;
        this.f14090b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f14090b.add(new SimpleDateFormat(str));
    }

    public String toString() {
        DateFormat dateFormat = this.f14090b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.f14090b) {
            jsonWriter.value(this.f14090b.get(0).format(date));
        }
    }

    public a(Class<? extends Date> cls, int i, int i2) {
        a(cls);
        this.f14089a = cls;
        this.f14090b.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f14090b.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (com.google.gson.internal.r.b()) {
            this.f14090b.add(com.google.gson.internal.x.a(i, i2));
        }
    }

    @Override // com.google.gson.x
    public Date a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Date dateA = a(jsonReader.nextString());
        Class<? extends Date> cls = this.f14089a;
        if (cls == Date.class) {
            return dateA;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(dateA.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(dateA.getTime());
        }
        throw new AssertionError();
    }

    private Date a(String str) {
        synchronized (this.f14090b) {
            Iterator<DateFormat> it = this.f14090b.iterator();
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
    }
}
