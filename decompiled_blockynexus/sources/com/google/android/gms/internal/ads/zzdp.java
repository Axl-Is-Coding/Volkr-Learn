package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdp implements zzdw {
    private static zzdp zzvq;
    private final Context zzvr;
    private final zzdur zzvs;
    private final zzdva zzvt;
    private final zzdvb zzvu;
    private final zzew zzvv;
    private final zzdtc zzvw;
    private final Executor zzvx;
    private final zzgo zzvy;
    private final zzdux zzvz;
    private volatile long zzwa = 0;
    private final Object zzwb = new Object();
    private volatile boolean zzwc;

    private zzdp(Context context, zzdtc zzdtcVar, zzdur zzdurVar, zzdva zzdvaVar, zzdvb zzdvbVar, zzew zzewVar, Executor executor, zzdta zzdtaVar, zzgo zzgoVar) {
        this.zzvr = context;
        this.zzvw = zzdtcVar;
        this.zzvs = zzdurVar;
        this.zzvt = zzdvaVar;
        this.zzvu = zzdvbVar;
        this.zzvv = zzewVar;
        this.zzvx = executor;
        this.zzvy = zzgoVar;
        this.zzvz = new zzds(this, zzdtaVar);
    }

    public static synchronized zzdp zza(String str, Context context, boolean z) {
        if (zzvq == null) {
            zzdtd zzdtdVarZzavw = zzdtd.zzavv().zzhb(str).zzbq(z).zzavw();
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
            zzdp zzdpVarZza = zza(context, zzdtc.zza(context, executorServiceNewCachedThreadPool), zzdtdVarZzavw, executorServiceNewCachedThreadPool);
            zzvq = zzdpVarZza;
            zzdpVarZza.zzbq();
            zzvq.zzbt();
        }
        return zzvq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbs() throws Throwable {
        String str;
        String strZzdh;
        zzdus zzdusVarZzp;
        zzgr zzgrVarZzawv;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzdus zzdusVarZzp2 = zzp(zzduz.zzhof);
        if (zzdusVarZzp2 != null) {
            String strZzdg = zzdusVarZzp2.zzawv().zzdg();
            strZzdh = zzdusVarZzp2.zzawv().zzdh();
            str = strZzdg;
        } else {
            str = null;
            strZzdh = null;
        }
        try {
            zzduv zzduvVarZza = zzdtl.zza(this.zzvr, 1, this.zzvy, str, strZzdh, "1", this.zzvw);
            if (zzduvVarZza.zzhoe != null && zzduvVarZza.zzhoe.length != 0) {
                zzgq zzgqVarZza = zzgq.zza(zzeip.zzu(zzduvVarZza.zzhoe), zzejm.zzbfu());
                boolean z = true;
                boolean zZza = false;
                if (zzgqVarZza.zzdc().zzdg().isEmpty() || zzgqVarZza.zzdc().zzdh().isEmpty() || zzgqVarZza.zzde().toByteArray().length == 0 || ((zzdusVarZzp = zzp(zzduz.zzhof)) != null && (zzgrVarZzawv = zzdusVarZzp.zzawv()) != null && zzgqVarZza.zzdc().zzdg().equals(zzgrVarZzawv.zzdg()) && zzgqVarZza.zzdc().zzdh().equals(zzgrVarZzawv.zzdh()))) {
                    z = false;
                }
                if (!z) {
                    this.zzvw.zzg(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                    return;
                }
                zzdux zzduxVar = this.zzvz;
                int i = zzduvVarZza.status;
                if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcqp)).booleanValue()) {
                    zZza = this.zzvs.zza(zzgqVarZza, zzduxVar);
                } else if (i == 3) {
                    zZza = this.zzvt.zza(zzgqVarZza);
                } else if (i == 4) {
                    zZza = this.zzvt.zza(zzgqVarZza, zzduxVar);
                }
                if (!zZza) {
                    this.zzvw.zzg(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                    return;
                } else {
                    this.zzvu.zzb(zzp(zzduz.zzhof));
                    this.zzwa = System.currentTimeMillis() / 1000;
                    return;
                }
            }
            this.zzvw.zzg(5009, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (zzekj e2) {
            this.zzvw.zza(4002, System.currentTimeMillis() - jCurrentTimeMillis, e2);
        }
    }

    private final void zzbt() {
        if (this.zzwc) {
            return;
        }
        synchronized (this.zzwb) {
            if (!this.zzwc) {
                if ((System.currentTimeMillis() / 1000) - this.zzwa < 3600) {
                    return;
                }
                zzdus zzdusVarZzaxa = this.zzvu.zzaxa();
                if (zzdusVarZzaxa == null || zzdusVarZzaxa.zzfg(3600L)) {
                    zzbr();
                }
            }
        }
    }

    private final zzdus zzp(int i) {
        return ((Boolean) zzwm.zzpx().zzd(zzabb.zzcqp)).booleanValue() ? this.zzvt.zzp(i) : this.zzvs.zzp(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(int i, int i2, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zzb(View view) {
        this.zzvv.zzc(view);
    }

    final synchronized void zzbq() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzdus zzdusVarZzp = zzp(zzduz.zzhof);
        if (zzdusVarZzp == null || zzdusVarZzp.zza()) {
            this.zzvw.zzg(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else {
            this.zzvu.zzb(zzdusVarZzp);
        }
    }

    public final void zzbr() {
        this.zzvx.execute(new zzdr(this));
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zzb(Context context) {
        zzbt();
        zzdtf zzdtfVarZzawz = this.zzvu.zzawz();
        if (zzdtfVarZzawz == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzv = zzdtfVarZzawz.zzv(context, null);
        this.zzvw.zza(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzv, null);
        return strZzv;
    }

    static zzdp zza(Context context, zzdtc zzdtcVar, zzdtd zzdtdVar) {
        return zza(context, zzdtcVar, zzdtdVar, Executors.newCachedThreadPool());
    }

    private static zzdp zza(Context context, zzdtc zzdtcVar, zzdtd zzdtdVar, Executor executor) {
        zzdtp zzdtpVarZza = zzdtp.zza(context, executor, zzdtcVar, zzdtdVar);
        zzev zzevVar = new zzev(context);
        zzew zzewVar = new zzew(zzdtdVar, zzdtpVarZza, new zzfi(context, zzevVar), zzevVar);
        zzgo zzgoVarZzawl = new zzduf(context, zzdtcVar).zzawl();
        zzdta zzdtaVar = new zzdta();
        return new zzdp(context, zzdtcVar, new zzdur(context, zzgoVarZzawl), new zzdva(context, zzgoVarZzawl), new zzdvb(context, zzewVar, zzdtcVar, zzdtaVar), zzewVar, executor, zzdtaVar, zzgoVarZzawl);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(MotionEvent motionEvent) {
        zzdtf zzdtfVarZzawz = this.zzvu.zzawz();
        if (zzdtfVarZzawz != null) {
            try {
                zzdtfVarZzawz.zza(null, motionEvent);
            } catch (zzdvc e2) {
                this.zzvw.zza(e2.zzaxb(), -1L, e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view, Activity activity) {
        zzbt();
        zzdtf zzdtfVarZzawz = this.zzvu.zzawz();
        if (zzdtfVarZzawz == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzdtfVarZzawz.zza(context, null, str, view, activity);
        this.zzvw.zza(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, View view, Activity activity) {
        zzbt();
        zzdtf zzdtfVarZzawz = this.zzvu.zzawz();
        if (zzdtfVarZzawz == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzdtfVarZzawz.zzb(context, null, view, activity);
        this.zzvw.zza(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }
}
