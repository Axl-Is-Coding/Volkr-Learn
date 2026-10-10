package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: ResponseBody.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class J implements Closeable {
    private Reader reader;

    /* JADX INFO: compiled from: ResponseBody.java */
    static final class a extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f23048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Charset f23049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f23050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Reader f23051d;

        a(BufferedSource bufferedSource, Charset charset) {
            this.f23048a = bufferedSource;
            this.f23049b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f23050c = true;
            Reader reader = this.f23051d;
            if (reader != null) {
                reader.close();
            } else {
                this.f23048a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.f23050c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f23051d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f23048a.inputStream(), okhttp3.a.e.a(this.f23048a, this.f23049b));
                this.f23051d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }
    }

    private Charset charset() {
        w wVarContentType = contentType();
        return wVarContentType != null ? wVarContentType.a(okhttp3.a.e.j) : okhttp3.a.e.j;
    }

    public static J create(w wVar, String str) {
        Charset charsetA = okhttp3.a.e.j;
        if (wVar != null && (charsetA = wVar.a()) == null) {
            charsetA = okhttp3.a.e.j;
            wVar = w.b(wVar + "; charset=utf-8");
        }
        Buffer bufferWriteString = new Buffer().writeString(str, charsetA);
        return create(wVar, bufferWriteString.size(), bufferWriteString);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        BufferedSource bufferedSourceSource = source();
        try {
            byte[] byteArray = bufferedSourceSource.readByteArray();
            okhttp3.a.e.a(bufferedSourceSource);
            if (jContentLength == -1 || jContentLength == byteArray.length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + byteArray.length + ") disagree");
        } catch (Throwable th) {
            okhttp3.a.e.a(bufferedSourceSource);
            throw th;
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.a.e.a(source());
    }

    public abstract long contentLength();

    public abstract w contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource bufferedSourceSource = source();
        try {
            return bufferedSourceSource.readString(okhttp3.a.e.a(bufferedSourceSource, charset()));
        } finally {
            okhttp3.a.e.a(bufferedSourceSource);
        }
    }

    public static J create(w wVar, byte[] bArr) {
        return create(wVar, bArr.length, new Buffer().write(bArr));
    }

    public static J create(w wVar, ByteString byteString) {
        return create(wVar, byteString.size(), new Buffer().write(byteString));
    }

    public static J create(w wVar, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new I(wVar, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
}
