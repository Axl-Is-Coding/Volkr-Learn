package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgm implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzcf.zza.C0108zza zzabc;
    private final String zzabk;
    protected Method zzabm;
    private final int zzabq;
    private final int zzabr;
    protected final zzex zzwg;

    public zzgm(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        this.zzwg = zzexVar;
        this.className = str;
        this.zzabk = str2;
        this.zzabc = c0108zza;
        this.zzabq = i;
        this.zzabr = i2;
    }

    protected abstract void zzcw() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        try {
            long jNanoTime = System.nanoTime();
            this.zzabm = this.zzwg.zza(this.className, this.zzabk);
            if (this.zzabm == null) {
                return null;
            }
            zzcw();
            zzdu zzduVarZzcl = this.zzwg.zzcl();
            if (zzduVarZzcl != null && this.zzabq != Integer.MIN_VALUE) {
                zzduVarZzcl.zza(this.zzabr, this.zzabq, (System.nanoTime() - jNanoTime) / 1000);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }
}
