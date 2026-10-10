package com.google.android.gms.internal.gcm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class zzi extends WeakReference<Throwable> {
    private final int zzdh;

    public zzi(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzdh = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzi.class) {
            if (this == obj) {
                return true;
            }
            zzi zziVar = (zzi) obj;
            if (this.zzdh == zziVar.zzdh && get() == zziVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzdh;
    }
}
