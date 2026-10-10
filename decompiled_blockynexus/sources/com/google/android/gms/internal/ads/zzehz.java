package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-base@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzehz extends WeakReference<Throwable> {
    private final int zzidx;

    public zzehz(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzidx = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzehz.class) {
            if (this == obj) {
                return true;
            }
            zzehz zzehzVar = (zzehz) obj;
            if (this.zzidx == zzehzVar.zzidx && get() == zzehzVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzidx;
    }
}
