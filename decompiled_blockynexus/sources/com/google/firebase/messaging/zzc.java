package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class zzc {
    private final Context zzag;
    private final Bundle zzcm;
    private final Executor zzdy;
    private final zzb zzdz;

    public zzc(Context context, Bundle bundle, Executor executor) {
        this.zzdy = executor;
        this.zzag = context;
        this.zzcm = bundle;
        this.zzdz = new zzb(context, context.getPackageName());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[EDGE_INSN: B:41:0x005e->B:20:0x005e BREAK  A[LOOP:0: B:13:0x0046->B:42:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean zzas() {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.zzas():boolean");
    }
}
