package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayi implements zzrh {
    private final zzayr zzdzr;

    @VisibleForTesting
    private final zzaye zzeaa;
    private final Object lock = new Object();

    @VisibleForTesting
    private final HashSet<zzaxw> zzeab = new HashSet<>();

    @VisibleForTesting
    private final HashSet<zzayj> zzeac = new HashSet<>();
    private final zzayg zzdzz = new zzayg();

    public zzayi(String str, zzayr zzayrVar) {
        this.zzeaa = new zzaye(str, zzayrVar);
        this.zzdzr = zzayrVar;
    }

    public final Bundle zza(Context context, zzayh zzayhVar) {
        HashSet<zzaxw> hashSet = new HashSet<>();
        synchronized (this.lock) {
            hashSet.addAll(this.zzeab);
            this.zzeab.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzeaa.zzp(context, this.zzdzz.zzwy()));
        Bundle bundle2 = new Bundle();
        Iterator<zzayj> it = this.zzeac.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<zzaxw> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBundle());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzayhVar.zza(hashSet);
        return bundle;
    }

    public final void zzb(zzaxw zzaxwVar) {
        synchronized (this.lock) {
            this.zzeab.add(zzaxwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrh
    public final void zzp(boolean z) {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
        if (!z) {
            this.zzdzr.zzez(jCurrentTimeMillis);
            this.zzdzr.zzdg(this.zzeaa.zzdzo);
            return;
        }
        if (jCurrentTimeMillis - this.zzdzr.zzxl() > ((Long) zzwm.zzpx().zzd(zzabb.zzcop)).longValue()) {
            this.zzeaa.zzdzo = -1;
        } else {
            this.zzeaa.zzdzo = this.zzdzr.zzxm();
        }
    }

    public final void zzwa() {
        synchronized (this.lock) {
            this.zzeaa.zzwa();
        }
    }

    public final void zzwb() {
        synchronized (this.lock) {
            this.zzeaa.zzwb();
        }
    }

    public final void zzb(HashSet<zzaxw> hashSet) {
        synchronized (this.lock) {
            this.zzeab.addAll(hashSet);
        }
    }

    public final void zza(zzvg zzvgVar, long j) {
        synchronized (this.lock) {
            this.zzeaa.zza(zzvgVar, j);
        }
    }

    public final zzaxw zza(Clock clock, String str) {
        return new zzaxw(clock, this, this.zzdzz.zzwx(), str);
    }
}
