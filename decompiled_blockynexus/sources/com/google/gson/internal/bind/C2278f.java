package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.gson.internal.bind.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: JsonTreeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2278f extends JsonWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Writer f14190a = new C2277e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.gson.t f14191b = new com.google.gson.t("closed");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.gson.p f14193d;
    private final List<com.google.gson.p> stack;

    public C2278f() {
        super(f14190a);
        this.stack = new ArrayList();
        this.f14193d = com.google.gson.q.f14259a;
    }

    private void a(com.google.gson.p pVar) {
        if (this.f14192c != null) {
            if (!pVar.j() || getSerializeNulls()) {
                ((com.google.gson.r) peek()).a(this.f14192c, pVar);
            }
            this.f14192c = null;
            return;
        }
        if (this.stack.isEmpty()) {
            this.f14193d = pVar;
            return;
        }
        com.google.gson.p pVarPeek = peek();
        if (!(pVarPeek instanceof com.google.gson.m)) {
            throw new IllegalStateException();
        }
        ((com.google.gson.m) pVarPeek).a(pVar);
    }

    private com.google.gson.p peek() {
        return this.stack.get(r0.size() - 1);
    }

    public com.google.gson.p b() {
        if (this.stack.isEmpty()) {
            return this.f14193d;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.stack);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        com.google.gson.m mVar = new com.google.gson.m();
        a(mVar);
        this.stack.add(mVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        com.google.gson.r rVar = new com.google.gson.r();
        a(rVar);
        this.stack.add(rVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(f14191b);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty() || this.f14192c != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof com.google.gson.m)) {
            throw new IllegalStateException();
        }
        this.stack.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty() || this.f14192c != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof com.google.gson.r)) {
            throw new IllegalStateException();
        }
        this.stack.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) throws IOException {
        if (this.stack.isEmpty() || this.f14192c != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof com.google.gson.r)) {
            throw new IllegalStateException();
        }
        this.f14192c = str;
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        a(com.google.gson.q.f14259a);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            nullValue();
            return this;
        }
        a(new com.google.gson.t(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z) throws IOException {
        a(new com.google.gson.t(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            nullValue();
            return this;
        }
        a(new com.google.gson.t(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d2) throws IOException {
        if (!isLenient() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
        a(new com.google.gson.t((Number) Double.valueOf(d2)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j) throws IOException {
        a(new com.google.gson.t((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            nullValue();
            return this;
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new com.google.gson.t(number));
        return this;
    }
}
