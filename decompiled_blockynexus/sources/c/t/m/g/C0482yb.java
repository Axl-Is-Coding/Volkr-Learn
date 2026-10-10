package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* JADX INFO: renamed from: c.t.m.g.yb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class C0482yb implements Comparator<ScanResult> {
    C0482yb() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
