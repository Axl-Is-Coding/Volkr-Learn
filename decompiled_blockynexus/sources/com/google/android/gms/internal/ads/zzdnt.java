package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnt {
    private final Clock zzbqa;
    private final Object lock = new Object();
    private volatile int zzhdg = zzdns.zzhdc;
    private volatile long zzdzj = 0;

    public zzdnt(Clock clock) {
        this.zzbqa = clock;
    }

    private final void zzatd() {
        long jCurrentTimeMillis = this.zzbqa.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhdg == zzdns.zzhde) {
                if (this.zzdzj + ((Long) zzwm.zzpx().zzd(zzabb.zzcvx)).longValue() <= jCurrentTimeMillis) {
                    this.zzhdg = zzdns.zzhdc;
                }
            }
        }
    }

    private final void zzr(int i, int i2) {
        zzatd();
        long jCurrentTimeMillis = this.zzbqa.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhdg != i) {
                return;
            }
            this.zzhdg = i2;
            if (this.zzhdg == zzdns.zzhde) {
                this.zzdzj = jCurrentTimeMillis;
            }
        }
    }

    public final boolean zzate() {
        boolean z;
        synchronized (this.lock) {
            zzatd();
            z = this.zzhdg == zzdns.zzhdd;
        }
        return z;
    }

    public final boolean zzatf() {
        boolean z;
        synchronized (this.lock) {
            zzatd();
            z = this.zzhdg == zzdns.zzhde;
        }
        return z;
    }

    public final void zzbn(boolean z) {
        if (z) {
            zzr(zzdns.zzhdc, zzdns.zzhdd);
        } else {
            zzr(zzdns.zzhdd, zzdns.zzhdc);
        }
    }

    public final void zzwp() {
        zzr(zzdns.zzhdd, zzdns.zzhde);
    }
}
