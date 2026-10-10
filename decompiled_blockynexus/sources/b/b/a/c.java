package b.b.a;

import b.d.a.b.g;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: IsoFile.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b.d.a.e implements Closeable {
    private static g j = g.a(c.class);

    public static byte[] a(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }

    @Override // b.d.a.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2538d.close();
    }

    @Override // b.d.a.e
    public String toString() {
        return "model(" + this.f2538d.toString() + ")";
    }
}
