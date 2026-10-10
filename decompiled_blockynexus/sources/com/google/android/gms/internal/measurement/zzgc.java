package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgc extends WeakReference<Throwable> {
    private final int zza;

    public zzgc(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzgc.class) {
            if (this == obj) {
                return true;
            }
            zzgc zzgcVar = (zzgc) obj;
            if (this.zza == zzgcVar.zza && get() == zzgcVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }
}
