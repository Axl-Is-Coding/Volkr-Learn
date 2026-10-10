package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzelp<T> implements zzemf<T> {
    private final zzelj zzils;
    private final boolean zzilt;
    private final zzemx<?, ?> zzimc;
    private final zzejo<?> zzimd;

    private zzelp(zzemx<?, ?> zzemxVar, zzejo<?> zzejoVar, zzelj zzeljVar) {
        this.zzimc = zzemxVar;
        this.zzilt = zzejoVar.zzj(zzeljVar);
        this.zzimd = zzejoVar;
        this.zzils = zzeljVar;
    }

    static <T> zzelp<T> zza(zzemx<?, ?> zzemxVar, zzejo<?> zzejoVar, zzelj zzeljVar) {
        return new zzelp<>(zzemxVar, zzejoVar, zzeljVar);
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final boolean equals(T t, T t2) {
        if (!this.zzimc.zzax(t).equals(this.zzimc.zzax(t2))) {
            return false;
        }
        if (this.zzilt) {
            return this.zzimd.zzah(t).equals(this.zzimd.zzah(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final int hashCode(T t) {
        int iHashCode = this.zzimc.zzax(t).hashCode();
        return this.zzilt ? (iHashCode * 53) + this.zzimd.zzah(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final T newInstance() {
        return (T) this.zzils.zzbgm().zzbgs();
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final void zzaj(T t) {
        this.zzimc.zzaj(t);
        this.zzimd.zzaj(t);
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final int zzat(T t) {
        zzemx<?, ?> zzemxVar = this.zzimc;
        int iZzaz = zzemxVar.zzaz(zzemxVar.zzax(t)) + 0;
        return this.zzilt ? iZzaz + this.zzimd.zzah(t).zzbfz() : iZzaz;
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final boolean zzav(T t) {
        return this.zzimd.zzah(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final void zzg(T t, T t2) {
        zzemh.zza(this.zzimc, t, t2);
        if (this.zzilt) {
            zzemh.zza(this.zzimd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final void zza(T t, zzenu zzenuVar) throws IOException {
        for (T t2 : this.zzimd.zzah(t)) {
            zzeju zzejuVar = (zzeju) t2.getKey();
            if (zzejuVar.zzbgb() != zzenr.MESSAGE || zzejuVar.zzbgc() || zzejuVar.zzbgd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (t2 instanceof zzekq) {
                zzenuVar.zzc(zzejuVar.zzv(), ((zzekq) t2).zzbhi().zzbdw());
            } else {
                zzenuVar.zzc(zzejuVar.zzv(), t2.getValue());
            }
        }
        zzemx<?, ?> zzemxVar = this.zzimc;
        zzemxVar.zzc(zzemxVar.zzax(t), zzenuVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 BREAK  A[LOOP:1: B:18:0x0053->B:62:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.ads.zzeik r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.ads.zzejz r0 = (com.google.android.gms.internal.ads.zzejz) r0
            com.google.android.gms.internal.ads.zzena r1 = r0.zzijc
            com.google.android.gms.internal.ads.zzena r2 = com.google.android.gms.internal.ads.zzena.zzbiv()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.ads.zzena r1 = com.google.android.gms.internal.ads.zzena.zzbiw()
            r0.zzijc = r1
        L11:
            com.google.android.gms.internal.ads.zzejz$zzd r10 = (com.google.android.gms.internal.ads.zzejz.zzd) r10
            r10.zzbgu()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.ads.zzeil.zza(r11, r12, r14)
            int r2 = r14.zziek
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.ads.zzejo<?> r12 = r9.zzimd
            com.google.android.gms.internal.ads.zzejm r0 = r14.zzien
            com.google.android.gms.internal.ads.zzelj r3 = r9.zzils
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.ads.zzejz$zzf r0 = (com.google.android.gms.internal.ads.zzejz.zzf) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.ads.zzeil.zza(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.ads.zzely.zzbic()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.ads.zzeil.zza(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.ads.zzeil.zza(r11, r4, r14)
            int r5 = r14.zziek
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.ads.zzeil.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zziem
            com.google.android.gms.internal.ads.zzeip r2 = (com.google.android.gms.internal.ads.zzeip) r2
            goto L53
        L72:
            com.google.android.gms.internal.ads.zzely.zzbic()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.ads.zzeil.zza(r11, r4, r14)
            int r12 = r14.zziek
            com.google.android.gms.internal.ads.zzejo<?> r0 = r9.zzimd
            com.google.android.gms.internal.ads.zzejm r5 = r14.zzien
            com.google.android.gms.internal.ads.zzelj r6 = r9.zzils
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.ads.zzejz$zzf r0 = (com.google.android.gms.internal.ads.zzejz.zzf) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.ads.zzeil.zza(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzd(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.ads.zzekj r10 = com.google.android.gms.internal.ads.zzekj.zzbhe()
            goto Lad
        Lac:
            throw r10
        Lad:
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelp.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzeik):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[LOOP:0: B:46:0x000c->B:54:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r11, com.google.android.gms.internal.ads.zzelz r12, com.google.android.gms.internal.ads.zzejm r13) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzemx<?, ?> r0 = r10.zzimc
            com.google.android.gms.internal.ads.zzejo<?> r1 = r10.zzimd
            java.lang.Object r2 = r0.zzay(r11)
            com.google.android.gms.internal.ads.zzejs r3 = r1.zzai(r11)
        Lc:
            int r4 = r12.zzbfn()     // Catch: java.lang.Throwable -> L8e
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.zzj(r11, r2)
            return
        L19:
            int r4 = r12.getTag()     // Catch: java.lang.Throwable -> L8e
            r6 = 11
            if (r4 == r6) goto L3e
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L39
            com.google.android.gms.internal.ads.zzelj r5 = r10.zzils     // Catch: java.lang.Throwable -> L8e
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.zza(r13, r5, r4)     // Catch: java.lang.Throwable -> L8e
            if (r4 == 0) goto L34
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L8e
            goto L82
        L34:
            boolean r4 = r0.zza(r2, r12)     // Catch: java.lang.Throwable -> L8e
            goto L83
        L39:
            boolean r4 = r12.zzbfo()     // Catch: java.lang.Throwable -> L8e
            goto L83
        L3e:
            r4 = 0
            r6 = 0
            r7 = r6
        L41:
            int r8 = r12.zzbfn()     // Catch: java.lang.Throwable -> L8e
            if (r8 == r5) goto L6f
            int r8 = r12.getTag()     // Catch: java.lang.Throwable -> L8e
            r9 = 16
            if (r8 != r9) goto L5a
            int r4 = r12.zzbey()     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.ads.zzelj r6 = r10.zzils     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r6 = r1.zza(r13, r6, r4)     // Catch: java.lang.Throwable -> L8e
            goto L41
        L5a:
            r9 = 26
            if (r8 != r9) goto L69
            if (r6 == 0) goto L64
            r1.zza(r12, r6, r13, r3)     // Catch: java.lang.Throwable -> L8e
            goto L41
        L64:
            com.google.android.gms.internal.ads.zzeip r7 = r12.zzbex()     // Catch: java.lang.Throwable -> L8e
            goto L41
        L69:
            boolean r8 = r12.zzbfo()     // Catch: java.lang.Throwable -> L8e
            if (r8 != 0) goto L41
        L6f:
            int r5 = r12.getTag()     // Catch: java.lang.Throwable -> L8e
            r8 = 12
            if (r5 != r8) goto L89
            if (r7 == 0) goto L82
            if (r6 == 0) goto L7f
            r1.zza(r7, r6, r13, r3)     // Catch: java.lang.Throwable -> L8e
            goto L82
        L7f:
            r0.zza(r2, r4, r7)     // Catch: java.lang.Throwable -> L8e
        L82:
            r4 = 1
        L83:
            if (r4 != 0) goto Lc
            r0.zzj(r11, r2)
            return
        L89:
            com.google.android.gms.internal.ads.zzekj r12 = com.google.android.gms.internal.ads.zzekj.zzbhb()     // Catch: java.lang.Throwable -> L8e
            throw r12     // Catch: java.lang.Throwable -> L8e
        L8e:
            r12 = move-exception
            r0.zzj(r11, r2)
            goto L94
        L93:
            throw r12
        L94:
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelp.zza(java.lang.Object, com.google.android.gms.internal.ads.zzelz, com.google.android.gms.internal.ads.zzejm):void");
    }
}
