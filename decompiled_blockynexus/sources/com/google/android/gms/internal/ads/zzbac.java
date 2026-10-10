package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbac {
    private final String[] zzece;
    private final double[] zzecf;
    private final double[] zzecg;
    private final int[] zzech;
    private int zzeci;

    private zzbac(zzbah zzbahVar) {
        int size = zzbahVar.zzecq.size();
        this.zzece = (String[]) zzbahVar.zzecp.toArray(new String[size]);
        this.zzecf = zzg(zzbahVar.zzecq);
        this.zzecg = zzg(zzbahVar.zzecr);
        this.zzech = new int[size];
        this.zzeci = 0;
    }

    private static double[] zzg(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d2) {
        this.zzeci++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzecg;
            if (i >= dArr.length) {
                return;
            }
            if (dArr[i] <= d2 && d2 < this.zzecf[i]) {
                int[] iArr = this.zzech;
                iArr[i] = iArr[i] + 1;
            }
            if (d2 < this.zzecg[i]) {
                return;
            } else {
                i++;
            }
        }
    }

    public final List<zzbae> zzyh() {
        ArrayList arrayList = new ArrayList(this.zzece.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzece;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d2 = this.zzecg[i];
            double d3 = this.zzecf[i];
            int[] iArr = this.zzech;
            double d4 = iArr[i];
            double d5 = this.zzeci;
            Double.isNaN(d4);
            Double.isNaN(d5);
            arrayList.add(new zzbae(str, d2, d3, d4 / d5, iArr[i]));
            i++;
        }
    }
}
