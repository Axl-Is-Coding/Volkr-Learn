package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgg extends zzgm {
    private long zzaar;
    private final zzfi zzxn;

    public zzgg(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2, zzfi zzfiVar) {
        super(zzexVar, str, str2, c0108zza, i, 53);
        this.zzxn = zzfiVar;
        if (zzfiVar != null) {
            this.zzaar = zzfiVar.zzcu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzxn != null) {
            this.zzabc.zzae(((Long) this.zzabm.invoke(null, Long.valueOf(this.zzaar))).longValue());
        }
    }
}
