package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.google.gson.internal.bind.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: JsonTreeReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2276d extends JsonReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Reader f14188a = new C2275c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14189b = new Object();
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;

    public C2276d(com.google.gson.p pVar) {
        super(f14188a);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        a(pVar);
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    private Object d() {
        return this.stack[this.stackSize - 1];
    }

    private Object g() {
        Object[] objArr = this.stack;
        int i = this.stackSize - 1;
        this.stackSize = i;
        Object obj = objArr[i];
        objArr[this.stackSize] = null;
        return obj;
    }

    private String locationString() {
        return " at path " + getPath();
    }

    public void b() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) d()).next();
        a(entry.getValue());
        a(new com.google.gson.t((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        a(((com.google.gson.m) d()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        a(((com.google.gson.r) d()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack = new Object[]{f14189b};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        g();
        g();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        g();
        g();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.stackSize) {
            Object[] objArr = this.stack;
            if (objArr[i] instanceof com.google.gson.m) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.pathIndices[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof com.google.gson.r) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.pathNames;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken jsonTokenPeek = peek();
        return (jsonTokenPeek == JsonToken.END_OBJECT || jsonTokenPeek == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean zM = ((com.google.gson.t) g()).m();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zM;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != JsonToken.NUMBER && jsonTokenPeek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonTokenPeek + locationString());
        }
        double dO = ((com.google.gson.t) d()).o();
        if (!isLenient() && (Double.isNaN(dO) || Double.isInfinite(dO))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dO);
        }
        g();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dO;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != JsonToken.NUMBER && jsonTokenPeek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonTokenPeek + locationString());
        }
        int iA = ((com.google.gson.t) d()).a();
        g();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iA;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != JsonToken.NUMBER && jsonTokenPeek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonTokenPeek + locationString());
        }
        long jP = ((com.google.gson.t) d()).p();
        g();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jP;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) d()).next();
        String str = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        g();
        int i = this.stackSize;
        if (i > 0) {
            int[] iArr = this.pathIndices;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek == JsonToken.STRING || jsonTokenPeek == JsonToken.NUMBER) {
            String strH = ((com.google.gson.t) g()).h();
            int i = this.stackSize;
            if (i > 0) {
                int[] iArr = this.pathIndices;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return strH;
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + jsonTokenPeek + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object objD = d();
        if (objD instanceof Iterator) {
            boolean z = this.stack[this.stackSize - 2] instanceof com.google.gson.r;
            Iterator it = (Iterator) objD;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            a(it.next());
            return peek();
        }
        if (objD instanceof com.google.gson.r) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (objD instanceof com.google.gson.m) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(objD instanceof com.google.gson.t)) {
            if (objD instanceof com.google.gson.q) {
                return JsonToken.NULL;
            }
            if (objD == f14189b) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        com.google.gson.t tVar = (com.google.gson.t) objD;
        if (tVar.t()) {
            return JsonToken.STRING;
        }
        if (tVar.r()) {
            return JsonToken.BOOLEAN;
        }
        if (tVar.s()) {
            return JsonToken.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.pathNames[this.stackSize - 2] = "null";
        } else {
            g();
            int i = this.stackSize;
            if (i > 0) {
                this.pathNames[i - 1] = "null";
            }
        }
        int i2 = this.stackSize;
        if (i2 > 0) {
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return C2276d.class.getSimpleName();
    }

    private void a(Object obj) {
        int i = this.stackSize;
        Object[] objArr = this.stack;
        if (i == objArr.length) {
            Object[] objArr2 = new Object[i * 2];
            int[] iArr = new int[i * 2];
            String[] strArr = new String[i * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.pathIndices, 0, iArr, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = objArr2;
            this.pathIndices = iArr;
            this.pathNames = strArr;
        }
        Object[] objArr3 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        objArr3[i2] = obj;
    }
}
