package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatn {
    private WeakHashMap<Context, zzatp> zzdvm = new WeakHashMap<>();

    public final Future<zzatl> zzy(Context context) {
        return zzbbz.zzeep.submit(new zzatm(this, context));
    }
}
