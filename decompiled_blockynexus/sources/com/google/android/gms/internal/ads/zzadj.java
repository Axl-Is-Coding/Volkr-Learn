package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadj {
    private static final AtomicReference<zzadk> zzdcw = new AtomicReference<>();
    static final AtomicBoolean zzdcx = new AtomicBoolean();

    public static void zza(zzadk zzadkVar) {
        zzdcw.set(zzadkVar);
    }

    static zzadk zzsa() {
        return zzdcw.get();
    }
}
