package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbah {
    private final List<String> zzecp = new ArrayList();
    private final List<Double> zzecq = new ArrayList();
    private final List<Double> zzecr = new ArrayList();

    public final zzbah zza(String str, double d2, double d3) {
        int i = 0;
        while (i < this.zzecp.size()) {
            double dDoubleValue = this.zzecr.get(i).doubleValue();
            double dDoubleValue2 = this.zzecq.get(i).doubleValue();
            if (d2 < dDoubleValue || (dDoubleValue == d2 && d3 < dDoubleValue2)) {
                break;
            }
            i++;
        }
        this.zzecp.add(i, str);
        this.zzecr.add(i, Double.valueOf(d2));
        this.zzecq.add(i, Double.valueOf(d3));
        return this;
    }

    public final zzbac zzyi() {
        return new zzbac(this);
    }
}
