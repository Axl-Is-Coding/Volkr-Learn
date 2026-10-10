package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdwm<E> {
    zzdwm() {
    }

    public zzdwm<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }

    public abstract zzdwm<E> zzaa(E e2);

    public zzdwm<E> zzg(Iterable<? extends E> iterable) {
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }
}
