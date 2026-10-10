package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfu implements Callable {
    private final zzcf.zza.C0108zza zzabc;
    private final zzex zzwg;

    public zzfu(zzex zzexVar, zzcf.zza.C0108zza c0108zza) {
        this.zzwg = zzexVar;
        this.zzabc = c0108zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        if (this.zzwg.zzcp() != null) {
            this.zzwg.zzcp().get();
        }
        zzcf.zza zzaVarZzco = this.zzwg.zzco();
        if (zzaVarZzco == null) {
            return null;
        }
        try {
            synchronized (this.zzabc) {
                zzcf.zza.C0108zza c0108zza = this.zzabc;
                byte[] byteArray = zzaVarZzco.toByteArray();
                c0108zza.zza(byteArray, 0, byteArray.length, zzejm.zzbfu());
            }
            return null;
        } catch (zzekj unused) {
            return null;
        }
    }
}
