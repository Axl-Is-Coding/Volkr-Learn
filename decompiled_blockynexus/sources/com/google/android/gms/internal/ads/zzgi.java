package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgi extends zzgm {
    public zzgi(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zza(zzcn.ENUM_FAILURE);
        boolean zBooleanValue = ((Boolean) this.zzabm.invoke(null, this.zzwg.getContext())).booleanValue();
        synchronized (this.zzabc) {
            if (zBooleanValue) {
                this.zzabc.zza(zzcn.ENUM_TRUE);
            } else {
                this.zzabc.zza(zzcn.ENUM_FALSE);
            }
        }
    }
}
