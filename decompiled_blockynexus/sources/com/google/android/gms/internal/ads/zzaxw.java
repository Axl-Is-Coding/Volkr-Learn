package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxw {
    private final Clock zzbqa;
    private final String zzdrd;
    private final zzayi zzdyh;
    private final String zzdyj;
    private final Object lock = new Object();
    private long zzdsr = -1;
    private long zzdyk = -1;
    private boolean zzdsn = false;
    private long zzdyl = -1;
    private long zzdym = 0;
    private long zzdyn = -1;
    private long zzdyo = -1;
    private final LinkedList<zzaxz> zzdyi = new LinkedList<>();

    zzaxw(Clock clock, zzayi zzayiVar, String str, String str2) {
        this.zzbqa = clock;
        this.zzdyh = zzayiVar;
        this.zzdyj = str;
        this.zzdrd = str2;
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzdyj);
            bundle.putString("slotid", this.zzdrd);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzdyn);
            bundle.putLong("tresponse", this.zzdyo);
            bundle.putLong("timp", this.zzdyk);
            bundle.putLong("tload", this.zzdyl);
            bundle.putLong("pcc", this.zzdym);
            bundle.putLong("tfetch", this.zzdsr);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzaxz> it = this.zzdyi.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzan(boolean z) {
        synchronized (this.lock) {
            if (this.zzdyo != -1) {
                this.zzdyl = this.zzbqa.elapsedRealtime();
            }
        }
    }

    public final void zze(zzvg zzvgVar) {
        synchronized (this.lock) {
            this.zzdyn = this.zzbqa.elapsedRealtime();
            this.zzdyh.zza(zzvgVar, this.zzdyn);
        }
    }

    public final void zzey(long j) {
        synchronized (this.lock) {
            this.zzdyo = j;
            if (this.zzdyo != -1) {
                this.zzdyh.zzb(this);
            }
        }
    }

    public final void zzwa() {
        synchronized (this.lock) {
            if (this.zzdyo != -1 && this.zzdyk == -1) {
                this.zzdyk = this.zzbqa.elapsedRealtime();
                this.zzdyh.zzb(this);
            }
            this.zzdyh.zzwa();
        }
    }

    public final void zzwb() {
        synchronized (this.lock) {
            if (this.zzdyo != -1) {
                zzaxz zzaxzVar = new zzaxz(this);
                zzaxzVar.zzwm();
                this.zzdyi.add(zzaxzVar);
                this.zzdym++;
                this.zzdyh.zzwb();
                this.zzdyh.zzb(this);
            }
        }
    }

    public final void zzwc() {
        synchronized (this.lock) {
            if (this.zzdyo != -1 && !this.zzdyi.isEmpty()) {
                zzaxz last = this.zzdyi.getLast();
                if (last.zzwk() == -1) {
                    last.zzwl();
                    this.zzdyh.zzb(this);
                }
            }
        }
    }

    public final String zzwd() {
        return this.zzdyj;
    }
}
