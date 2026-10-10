package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfp extends zzgm {
    private static volatile Long zzaaz;
    private static final Object zzaba = new Object();

    public zzfp(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 44);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (zzaaz == null) {
            synchronized (zzaba) {
                if (zzaaz == null) {
                    zzaaz = (Long) this.zzabm.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabc) {
            this.zzabc.zzaa(zzaaz.longValue());
        }
    }
}
