package b.b.a;

import com.umeng.analytics.pro.ci;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: IsoTypeReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static int a(byte b2) {
        return b2 < 0 ? b2 + ci.f20834a : b2;
    }

    public static String a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return f.a(bArr);
    }

    public static double b(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d2 = 0 | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << ci.n) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255);
        Double.isNaN(d2);
        return d2 / 1.073741824E9d;
    }

    public static double c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d2 = 0 | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << ci.n) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255);
        Double.isNaN(d2);
        return d2 / 65536.0d;
    }

    public static float d(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[2]);
        return ((short) (((short) (0 | ((r0[0] << 8) & 65280))) | (r0[1] & 255))) / 256.0f;
    }

    public static String e(ByteBuffer byteBuffer) {
        int iF = f(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((iF >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    public static int f(ByteBuffer byteBuffer) {
        return (a(byteBuffer.get()) << 8) + 0 + a(byteBuffer.get());
    }

    public static int g(ByteBuffer byteBuffer) {
        return (f(byteBuffer) << 8) + 0 + a(byteBuffer.get());
    }

    public static long h(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static long i(ByteBuffer byteBuffer) {
        long jH = (h(byteBuffer) << 32) + 0;
        if (jH >= 0) {
            return jH + h(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static int j(ByteBuffer byteBuffer) {
        return a(byteBuffer.get());
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }
}
