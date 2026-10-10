package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbyr<ListenerT> {
    private final Map<ListenerT, Executor> zzfvr = new HashMap();

    protected zzbyr(Set<zzcab<ListenerT>> set) {
        zzb(set);
    }

    private final synchronized void zzb(Set<zzcab<ListenerT>> set) {
        Iterator<zzcab<ListenerT>> it = set.iterator();
        while (it.hasNext()) {
            zza(it.next());
        }
    }

    public final synchronized void zza(zzcab<ListenerT> zzcabVar) {
        zza(zzcabVar.zzfwk, zzcabVar.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfvr.put(listenert, executor);
    }

    protected final synchronized void zza(final zzbyt<ListenerT> zzbytVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.zzfvr.entrySet()) {
            final ListenerT key = entry.getKey();
            entry.getValue().execute(new Runnable(zzbytVar, key) { // from class: com.google.android.gms.internal.ads.zzbyq
                private final Object zzdjf;
                private final zzbyt zzfvq;

                {
                    this.zzfvq = zzbytVar;
                    this.zzdjf = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zzfvq.zzp(this.zzdjf);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzp.zzkv().zzb(th, "EventEmitter.notify");
                        zzayp.zza("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
