package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfx extends zzgm {
    private static final Object zzaba = new Object();
    private static volatile String zzabd;

    public zzfx(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zzu("E");
        if (zzabd == null) {
            synchronized (zzaba) {
                if (zzabd == null) {
                    zzabd = (String) this.zzabm.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabc) {
            this.zzabc.zzu(zzabd);
        }
    }
}
