package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzqb {
    private final zzqe zzbmg;
    private final boolean zzbmh;
    private final long zzbmi;
    private final long zzbmj;
    private long zzbmk;
    private long zzbml;
    private long zzbmm;
    private boolean zzbmn;
    private long zzbmo;
    private long zzbmp;
    private long zzbmq;

    public zzqb() {
        this(-1.0d);
    }

    private final boolean zzg(long j, long j2) {
        return Math.abs((j2 - this.zzbmo) - (j - this.zzbmp)) > 20000000;
    }

    public final void disable() {
        if (this.zzbmh) {
            this.zzbmg.zzjr();
        }
    }

    public final void enable() {
        this.zzbmn = false;
        if (this.zzbmh) {
            this.zzbmg.zzjq();
        }
    }

    public final long zzf(long j, long j2) {
        long j3;
        long j4;
        long j5;
        long j6 = 1000 * j;
        if (this.zzbmn) {
            if (j != this.zzbmk) {
                this.zzbmq++;
                this.zzbml = this.zzbmm;
            }
            long j7 = this.zzbmq;
            if (j7 >= 6) {
                j4 = this.zzbml + ((j6 - this.zzbmp) / j7);
                if (zzg(j4, j2)) {
                    this.zzbmn = false;
                } else {
                    j3 = (this.zzbmo + j4) - this.zzbmp;
                }
            } else if (zzg(j6, j2)) {
                this.zzbmn = false;
            }
            j3 = j2;
            j4 = j6;
        } else {
            j3 = j2;
            j4 = j6;
        }
        if (!this.zzbmn) {
            this.zzbmp = j6;
            this.zzbmo = j2;
            this.zzbmq = 0L;
            this.zzbmn = true;
        }
        this.zzbmk = j;
        this.zzbmm = j4;
        zzqe zzqeVar = this.zzbmg;
        if (zzqeVar == null || zzqeVar.zzbms == 0) {
            return j3;
        }
        long j8 = this.zzbmg.zzbms;
        long j9 = this.zzbmi;
        long j10 = j8 + (((j3 - j8) / j9) * j9);
        if (j3 <= j10) {
            j5 = j10 - j9;
        } else {
            j10 = j9 + j10;
            j5 = j10;
        }
        if (j10 - j3 >= j3 - j5) {
            j10 = j5;
        }
        return j10 - this.zzbmj;
    }

    public zzqb(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private zzqb(double d2) {
        this.zzbmh = d2 != -1.0d;
        if (this.zzbmh) {
            this.zzbmg = zzqe.zzjp();
            this.zzbmi = (long) (1.0E9d / d2);
            this.zzbmj = (this.zzbmi * 80) / 100;
        } else {
            this.zzbmg = null;
            this.zzbmi = -1L;
            this.zzbmj = -1L;
        }
    }
}
