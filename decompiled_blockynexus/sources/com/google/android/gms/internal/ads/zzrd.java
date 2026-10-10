package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrd {

    @VisibleForTesting
    private int zzbsd;
    private final Object lock = new Object();
    private List<zzre> zzbse = new LinkedList();

    public final boolean zza(zzre zzreVar) {
        synchronized (this.lock) {
            return this.zzbse.contains(zzreVar);
        }
    }

    public final boolean zzb(zzre zzreVar) {
        synchronized (this.lock) {
            Iterator<zzre> it = this.zzbse.iterator();
            while (it.hasNext()) {
                zzre next = it.next();
                if (com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxe()) {
                    if (!com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxg() && zzreVar != next && next.zzmb().equals(zzreVar.zzmb())) {
                        it.remove();
                        return true;
                    }
                } else if (zzreVar != next && next.zzlz().equals(zzreVar.zzlz())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzre zzreVar) {
        synchronized (this.lock) {
            if (this.zzbse.size() >= 10) {
                int size = this.zzbse.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzbbq.zzef(sb.toString());
                this.zzbse.remove(0);
            }
            int i = this.zzbsd;
            this.zzbsd = i + 1;
            zzreVar.zzbw(i);
            zzreVar.zzmf();
            this.zzbse.add(zzreVar);
        }
    }

    public final zzre zzo(boolean z) {
        synchronized (this.lock) {
            zzre zzreVar = null;
            if (this.zzbse.size() == 0) {
                zzbbq.zzef("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzbse.size() < 2) {
                zzre zzreVar2 = this.zzbse.get(0);
                if (z) {
                    this.zzbse.remove(0);
                } else {
                    zzreVar2.zzmc();
                }
                return zzreVar2;
            }
            int i2 = Integer.MIN_VALUE;
            int i3 = 0;
            for (zzre zzreVar3 : this.zzbse) {
                int score = zzreVar3.getScore();
                if (score > i2) {
                    i = i3;
                    zzreVar = zzreVar3;
                    i2 = score;
                }
                i3++;
            }
            this.zzbse.remove(i);
            return zzreVar;
        }
    }
}
