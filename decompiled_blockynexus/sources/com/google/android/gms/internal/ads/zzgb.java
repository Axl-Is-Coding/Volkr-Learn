package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgb extends zzgm {
    private final boolean zzabf;

    public zzgb(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 61);
        this.zzabf = zzexVar.zzcb();
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zzabm.invoke(null, this.zzwg.getContext(), Boolean.valueOf(this.zzabf))).longValue();
        synchronized (this.zzabc) {
            this.zzabc.zzah(jLongValue);
        }
    }
}
