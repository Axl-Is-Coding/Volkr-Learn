package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfs extends zzgm {
    private long startTime;

    public zzfs(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, long j, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 25);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zzabm.invoke(null, new Object[0])).longValue();
        synchronized (this.zzabc) {
            this.zzabc.zzak(jLongValue);
            if (this.startTime != 0) {
                this.zzabc.zzm(jLongValue - this.startTime);
                this.zzabc.zzp(this.startTime);
            }
        }
    }
}
