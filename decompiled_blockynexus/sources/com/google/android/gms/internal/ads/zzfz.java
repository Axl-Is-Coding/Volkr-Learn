package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfz extends zzgm {
    public zzfz(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zzabc.zzd(((Boolean) this.zzabm.invoke(null, this.zzwg.getContext())).booleanValue() ? zzcn.ENUM_TRUE : zzcn.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zzabc.zzd(zzcn.ENUM_FAILURE);
        }
    }
}
