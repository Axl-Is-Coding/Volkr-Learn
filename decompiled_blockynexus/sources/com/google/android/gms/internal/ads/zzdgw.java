package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgw<T> {
    private final Executor executor;
    private final Set<zzdgx<? extends zzdgu<T>>> zzgyf;

    public zzdgw(Executor executor, Set<zzdgx<? extends zzdgu<T>>> set) {
        this.executor = executor;
        this.zzgyf = set;
    }

    public final zzdzc<T> zzt(final T t) {
        final ArrayList arrayList = new ArrayList(this.zzgyf.size());
        for (final zzdgx<? extends zzdgu<T>> zzdgxVar : this.zzgyf) {
            zzdzc<S> zzdzcVarZzarj = zzdgxVar.zzarj();
            if (zzacv.zzdbq.get().booleanValue()) {
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
                zzdzcVarZzarj.addListener(new Runnable(zzdgxVar, jElapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzdgz
                    private final zzdgx zzgyg;
                    private final long zzgyh;

                    {
                        this.zzgyg = zzdgxVar;
                        this.zzgyh = jElapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdgx zzdgxVar2 = this.zzgyg;
                        long j = this.zzgyh;
                        String canonicalName = zzdgxVar2.getClass().getCanonicalName();
                        long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - j;
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(jElapsedRealtime2);
                        zzayp.zzei(sb.toString());
                    }
                }, zzbbz.zzeeu);
            }
            arrayList.add(zzdzcVarZzarj);
        }
        return zzdyq.zzk(arrayList).zza(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.zzdgy
            private final Object zzdjf;
            private final List zzgxm;

            {
                this.zzgxm = arrayList;
                this.zzdjf = t;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List list = this.zzgxm;
                Object obj = this.zzdjf;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzdgu zzdguVar = (zzdgu) ((zzdzc) it.next()).get();
                    if (zzdguVar != null) {
                        zzdguVar.zzs(obj);
                    }
                }
                return obj;
            }
        }, this.executor);
    }
}
