package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzge extends zzgm {
    private final StackTraceElement[] zzabh;

    public zzge(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzexVar, str, str2, c0108zza, i, 45);
        this.zzabh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzabh;
        if (stackTraceElementArr != null) {
            zzet zzetVar = new zzet((String) this.zzabm.invoke(null, stackTraceElementArr));
            synchronized (this.zzabc) {
                this.zzabc.zzab(zzetVar.zzyn.longValue());
                if (zzetVar.zzyo.booleanValue()) {
                    this.zzabc.zzc(zzetVar.zzyp.booleanValue() ? zzcn.ENUM_FALSE : zzcn.ENUM_TRUE);
                } else {
                    this.zzabc.zzc(zzcn.ENUM_FAILURE);
                }
            }
        }
    }
}
