package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.T;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: Streams.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z {
    public static com.google.gson.p a(JsonReader jsonReader) throws JsonParseException {
        boolean z;
        try {
            try {
                jsonReader.peek();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return T.X.a(jsonReader);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return com.google.gson.q.f14259a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    /* JADX INFO: compiled from: Streams.java */
    private static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f14242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0137a f14243b = new C0137a();

        /* JADX INFO: renamed from: com.google.gson.internal.z$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Streams.java */
        static class C0137a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            char[] f14244a;

            C0137a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f14244a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f14244a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f14244a, i, i2 - i);
            }
        }

        a(Appendable appendable) {
            this.f14242a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            C0137a c0137a = this.f14243b;
            c0137a.f14244a = cArr;
            this.f14242a.append(c0137a, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f14242a.append((char) i);
        }
    }

    public static void a(com.google.gson.p pVar, JsonWriter jsonWriter) throws IOException {
        T.X.a(jsonWriter, pVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
