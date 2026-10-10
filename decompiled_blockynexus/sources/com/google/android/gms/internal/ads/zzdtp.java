package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdtp {
    private final Executor executor;
    private final zzdtv zzhmq;
    private final zzdtv zzhmr;
    private Task<zzcf.zza> zzhms;
    private Task<zzcf.zza> zzhmt;
    private final Context zzvr;
    private final zzdtc zzvw;
    private final zzdtd zzyr;

    @VisibleForTesting
    private zzdtp(Context context, Executor executor, zzdtc zzdtcVar, zzdtd zzdtdVar, zzdtt zzdttVar, zzdtw zzdtwVar) {
        this.zzvr = context;
        this.executor = executor;
        this.zzvw = zzdtcVar;
        this.zzyr = zzdtdVar;
        this.zzhmq = zzdttVar;
        this.zzhmr = zzdtwVar;
    }

    public static zzdtp zza(Context context, Executor executor, zzdtc zzdtcVar, zzdtd zzdtdVar) {
        final zzdtp zzdtpVar = new zzdtp(context, executor, zzdtcVar, zzdtdVar, new zzdtt(), new zzdtw());
        if (zzdtpVar.zzyr.zzavu()) {
            zzdtpVar.zzhms = zzdtpVar.zzd(new Callable(zzdtpVar) { // from class: com.google.android.gms.internal.ads.zzdts
                private final zzdtp zzhmw;

                {
                    this.zzhmw = zzdtpVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzhmw.zzawc();
                }
            });
        } else {
            zzdtpVar.zzhms = Tasks.forResult(zzdtpVar.zzhmq.zzawe());
        }
        zzdtpVar.zzhmt = zzdtpVar.zzd(new Callable(zzdtpVar) { // from class: com.google.android.gms.internal.ads.zzdtr
            private final zzdtp zzhmw;

            {
                this.zzhmw = zzdtpVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhmw.zzawb();
            }
        });
        return zzdtpVar;
    }

    private final Task<zzcf.zza> zzd(Callable<zzcf.zza> callable) {
        return Tasks.call(this.executor, callable).addOnFailureListener(this.executor, new OnFailureListener(this) { // from class: com.google.android.gms.internal.ads.zzdtu
            private final zzdtp zzhmw;

            {
                this.zzhmw = this;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zzhmw.zzc(exc);
            }
        });
    }

    public final zzcf.zza zzawa() {
        return zza(this.zzhms, this.zzhmq.zzawe());
    }

    final /* synthetic */ zzcf.zza zzawb() throws Exception {
        return this.zzhmr.zzck(this.zzvr);
    }

    final /* synthetic */ zzcf.zza zzawc() throws Exception {
        return this.zzhmq.zzck(this.zzvr);
    }

    final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvw.zza(2025, -1L, exc);
    }

    public final zzcf.zza zzco() {
        return zza(this.zzhmt, this.zzhmr.zzawe());
    }

    private static zzcf.zza zza(Task<zzcf.zza> task, zzcf.zza zzaVar) {
        return !task.isSuccessful() ? zzaVar : task.getResult();
    }
}
