package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgl<T> {
    private final Map<String, AtomicReference<T>> zzabp = new HashMap();

    public final AtomicReference<T> zzat(String str) {
        synchronized (this) {
            if (!this.zzabp.containsKey(str)) {
                this.zzabp.put(str, new AtomicReference<>());
            }
        }
        return this.zzabp.get(str);
    }
}
