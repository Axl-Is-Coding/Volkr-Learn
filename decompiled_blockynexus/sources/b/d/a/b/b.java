package b.d.a.b;

/* JADX INFO: compiled from: CastUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        throw new RuntimeException("A cast to int has gone wrong. Please contact the mp4parser discussion group (" + j + ")");
    }
}
