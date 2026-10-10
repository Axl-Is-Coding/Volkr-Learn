package c.t.m.g;

import com.google.android.gms.gcm.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Sa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Sa f3008a = new Sa();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Comparator<byte[]> f3009b = new Ra();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<byte[]> f3010c = new ArrayList(32);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<byte[]> f3011d = new ArrayList(32);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3012e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3013f = Task.EXTRAS_LIMIT_BYTES;

    private Sa() {
    }

    public static Sa a() {
        return f3008a;
    }

    private synchronized void b() {
        while (this.f3012e > this.f3013f) {
            byte[] bArrRemove = this.f3010c.remove(0);
            this.f3011d.remove(bArrRemove);
            this.f3012e -= bArrRemove.length;
        }
    }

    public final synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f3011d.size(); i2++) {
            byte[] bArr = this.f3011d.get(i2);
            if (bArr.length == i) {
                this.f3012e -= bArr.length;
                this.f3011d.remove(i2);
                this.f3010c.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public final synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f3013f) {
                this.f3010c.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f3011d, bArr, f3009b);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f3011d.add(iBinarySearch, bArr);
                this.f3012e += bArr.length;
                b();
            }
        }
    }
}
