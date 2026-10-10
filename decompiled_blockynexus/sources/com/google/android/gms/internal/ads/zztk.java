package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zztk {
    private final Object lock = new Object();
    private zztb zzbvb;
    private boolean zzbvm;
    private final Context zzvr;

    zztk(Context context) {
        this.zzvr = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbvb == null) {
                return;
            }
            this.zzbvb.disconnect();
            this.zzbvb = null;
            Binder.flushPendingCommands();
        }
    }

    final Future<InputStream> zzb(zzte zzteVar) {
        zztj zztjVar = new zztj(this);
        zztm zztmVar = new zztm(this, zzteVar, zztjVar);
        zztq zztqVar = new zztq(this, zztjVar);
        synchronized (this.lock) {
            this.zzbvb = new zztb(this.zzvr, com.google.android.gms.ads.internal.zzp.zzlf().zzyj(), zztmVar, zztqVar);
            this.zzbvb.checkAvailabilityAndConnect();
        }
        return zztjVar;
    }

    static /* synthetic */ boolean zza(zztk zztkVar, boolean z) {
        zztkVar.zzbvm = true;
        return true;
    }
}
