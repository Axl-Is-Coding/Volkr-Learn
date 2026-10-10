package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlj implements zzjv, zzke {
    private static final zzka zzapj = new zzlm();
    private static final int zzayu = zzpq.zzbl("qt  ");
    private long zzaih;
    private int zzarf;
    private int zzarg;
    private zzjx zzarj;
    private int zzaxx;
    private int zzaxy;
    private long zzaxz;
    private int zzaya;
    private zzpk zzayb;
    private zzll[] zzayv;
    private boolean zzayw;
    private final zzpk zzaxt = new zzpk(16);
    private final Stack<zzku> zzaxv = new Stack<>();
    private final zzpk zzapq = new zzpk(zzpf.zzbjr);
    private final zzpk zzapr = new zzpk(4);

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzeb(long r20) throws com.google.android.gms.internal.ads.zzhv {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlj.zzeb(long):void");
    }

    private final void zzhb() {
        this.zzaxx = 0;
        this.zzaya = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long getDurationUs() {
        return this.zzaih;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final boolean zza(zzjy zzjyVar) throws InterruptedException, IOException {
        return zzlo.zze(zzjyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzc(long j, long j2) {
        this.zzaxv.clear();
        this.zzaya = 0;
        this.zzarg = 0;
        this.zzarf = 0;
        if (j == 0) {
            zzhb();
            return;
        }
        zzll[] zzllVarArr = this.zzayv;
        if (zzllVarArr != null) {
            for (zzll zzllVar : zzllVarArr) {
                zzls zzlsVar = zzllVar.zzbab;
                int iZzec = zzlsVar.zzec(j2);
                if (iZzec == -1) {
                    iZzec = zzlsVar.zzed(j2);
                }
                zzllVar.zzaxe = iZzec;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long zzdz(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzll zzllVar : this.zzayv) {
            zzls zzlsVar = zzllVar.zzbab;
            int iZzec = zzlsVar.zzec(j);
            if (iZzec == -1) {
                iZzec = zzlsVar.zzed(j);
            }
            long j3 = zzlsVar.zzaoo[iZzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zza(zzjx zzjxVar) {
        this.zzarj = zzjxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x018c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x029b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01bd  */
    @Override // com.google.android.gms.internal.ads.zzjv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzjy r24, com.google.android.gms.internal.ads.zzkb r25) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlj.zza(com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzkb):int");
    }
}
