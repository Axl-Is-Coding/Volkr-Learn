package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class G {
    public static G create(w wVar, String str) {
        Charset charsetA = okhttp3.a.e.j;
        if (wVar != null && (charsetA = wVar.a()) == null) {
            charsetA = okhttp3.a.e.j;
            wVar = w.b(wVar + "; charset=utf-8");
        }
        return create(wVar, str.getBytes(charsetA));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract w contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static G create(w wVar, ByteString byteString) {
        return new D(wVar, byteString);
    }

    public static G create(w wVar, byte[] bArr) {
        return create(wVar, bArr, 0, bArr.length);
    }

    public static G create(w wVar, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            okhttp3.a.e.a(bArr.length, i, i2);
            return new E(wVar, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    public static G create(w wVar, File file) {
        if (file != null) {
            return new F(wVar, file);
        }
        throw new NullPointerException("file == null");
    }
}
