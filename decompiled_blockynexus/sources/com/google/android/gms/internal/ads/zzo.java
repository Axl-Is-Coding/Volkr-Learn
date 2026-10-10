package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzo implements zzac {
    private final Map<String, List<zzaa<?>>> zzy = new HashMap();
    private final zzm zzz;

    zzo(zzm zzmVar) {
        this.zzz = zzmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean zzb(zzaa<?> zzaaVar) {
        String strZze = zzaaVar.zze();
        if (!this.zzy.containsKey(strZze)) {
            this.zzy.put(strZze, null);
            zzaaVar.zza((zzac) this);
            if (zzaq.DEBUG) {
                zzaq.d("new request, sending to network %s", strZze);
            }
            return false;
        }
        List<zzaa<?>> arrayList = this.zzy.get(strZze);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        zzaaVar.zzc("waiting-for-response");
        arrayList.add(zzaaVar);
        this.zzy.put(strZze, arrayList);
        if (zzaq.DEBUG) {
            zzaq.d("Request for cacheKey=%s is in flight, putting on hold.", strZze);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final void zza(zzaa<?> zzaaVar, zzaj<?> zzajVar) {
        List<zzaa<?>> listRemove;
        zzn zznVar = zzajVar.zzbs;
        if (zznVar == null || zznVar.zza()) {
            zza(zzaaVar);
            return;
        }
        String strZze = zzaaVar.zze();
        synchronized (this) {
            listRemove = this.zzy.remove(strZze);
        }
        if (listRemove != null) {
            if (zzaq.DEBUG) {
                zzaq.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), strZze);
            }
            Iterator<zzaa<?>> it = listRemove.iterator();
            while (it.hasNext()) {
                this.zzz.zzo.zzb(it.next(), zzajVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final synchronized void zza(zzaa<?> zzaaVar) {
        String strZze = zzaaVar.zze();
        List<zzaa<?>> listRemove = this.zzy.remove(strZze);
        if (listRemove != null && !listRemove.isEmpty()) {
            if (zzaq.DEBUG) {
                zzaq.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), strZze);
            }
            zzaa<?> zzaaVarRemove = listRemove.remove(0);
            this.zzy.put(strZze, listRemove);
            zzaaVarRemove.zza((zzac) this);
            try {
                this.zzz.zzm.put(zzaaVarRemove);
            } catch (InterruptedException e2) {
                zzaq.e("Couldn't add request to queue. %s", e2.toString());
                Thread.currentThread().interrupt();
                this.zzz.quit();
            }
        }
    }
}
