package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Db extends Cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Db f2897a = new Db(Collections.emptyList(), 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ScanResult> f2898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2900d;

    public Db(List<ScanResult> list, long j, int i) {
        this.f2899c = j;
        this.f2900d = i;
        this.f2898b = new ArrayList(list);
    }
}
