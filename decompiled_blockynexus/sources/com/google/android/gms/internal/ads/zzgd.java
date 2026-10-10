package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgd extends zzgm {
    public zzgd(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzabc) {
            zzey zzeyVar = new zzey((String) this.zzabm.invoke(null, new Object[0]));
            this.zzabc.zzac(zzeyVar.zzzi.longValue());
            this.zzabc.zzad(zzeyVar.zzzj.longValue());
        }
    }
}
