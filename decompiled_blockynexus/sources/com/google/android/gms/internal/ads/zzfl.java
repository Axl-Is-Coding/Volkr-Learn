package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfl extends zzgm {
    private static zzgl<String> zzaau = new zzgl<>();
    private final Context zzaav;

    public zzfl(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2, Context context) {
        super(zzexVar, str, str2, c0108zza, i, 29);
        this.zzaav = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zzx("E");
        AtomicReference<String> atomicReferenceZzat = zzaau.zzat(this.zzaav.getPackageName());
        if (atomicReferenceZzat.get() == null) {
            synchronized (atomicReferenceZzat) {
                if (atomicReferenceZzat.get() == null) {
                    atomicReferenceZzat.set((String) this.zzabm.invoke(null, this.zzaav));
                }
            }
        }
        String str = atomicReferenceZzat.get();
        synchronized (this.zzabc) {
            this.zzabc.zzx(zzcv.zza(str.getBytes(), true));
        }
    }
}
