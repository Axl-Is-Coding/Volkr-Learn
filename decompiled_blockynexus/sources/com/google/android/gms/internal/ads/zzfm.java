package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfm extends zzgm {
    public zzfm(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zzb(zzcn.ENUM_FAILURE);
        try {
            this.zzabc.zzb(((Boolean) this.zzabm.invoke(null, this.zzwg.getContext())).booleanValue() ? zzcn.ENUM_TRUE : zzcn.ENUM_FALSE);
        } catch (InvocationTargetException e2) {
            if (!(e2.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e2;
            }
        }
    }
}
