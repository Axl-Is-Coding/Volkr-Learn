package com.google.gson;

import com.google.gson.internal.z;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: JsonElement.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public m c() {
        if (i()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public r e() {
        if (k()) {
            return (r) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public t f() {
        if (l()) {
            return (t) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean i() {
        return this instanceof m;
    }

    public boolean j() {
        return this instanceof q;
    }

    public boolean k() {
        return this instanceof r;
    }

    public boolean l() {
        return this instanceof t;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            z.a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
