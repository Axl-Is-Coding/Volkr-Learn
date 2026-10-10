package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Build;
import java.util.Comparator;

/* JADX INFO: renamed from: c.t.m.g.za, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class C0484za implements Comparator<Object> {
    C0484za() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ScanResult scanResult = (ScanResult) obj;
        ScanResult scanResult2 = (ScanResult) obj2;
        int i = Build.VERSION.SDK_INT >= 17 ? (int) (((scanResult2.timestamp / 1000) / 1000) - ((scanResult.timestamp / 1000) / 1000)) : 0;
        return i == 0 ? scanResult2.level - scanResult.level : i;
    }
}
