package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbos extends zzboq {
    private final View view;
    private final zzbgj zzdgy;
    private final Executor zzfoc;
    private final zzdnu zzfpe;
    private final zzbql zzfqb;
    private final zzcep zzfqc;
    private final zzcaf zzfqd;
    private final zzeos<zzczf> zzfqe;
    private zzvn zzfqf;
    private final Context zzvr;

    zzbos(zzbqn zzbqnVar, Context context, zzdnu zzdnuVar, View view, zzbgj zzbgjVar, zzbql zzbqlVar, zzcep zzcepVar, zzcaf zzcafVar, zzeos<zzczf> zzeosVar, Executor executor) {
        super(zzbqnVar);
        this.zzvr = context;
        this.view = view;
        this.zzdgy = zzbgjVar;
        this.zzfpe = zzdnuVar;
        this.zzfqb = zzbqlVar;
        this.zzfqc = zzcepVar;
        this.zzfqd = zzcafVar;
        this.zzfqe = zzeosVar;
        this.zzfoc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final zzyo getVideoController() {
        try {
            return this.zzfqb.getVideoController();
        } catch (zzdos unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final void zza(ViewGroup viewGroup, zzvn zzvnVar) {
        zzbgj zzbgjVar;
        if (viewGroup == null || (zzbgjVar = this.zzdgy) == null) {
            return;
        }
        zzbgjVar.zza(zzbhy.zzb(zzvnVar));
        viewGroup.setMinimumHeight(zzvnVar.heightPixels);
        viewGroup.setMinimumWidth(zzvnVar.widthPixels);
        this.zzfqf = zzvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final zzdnu zzahw() {
        boolean z;
        zzvn zzvnVar = this.zzfqf;
        if (zzvnVar != null) {
            return zzdoq.zzf(zzvnVar);
        }
        zzdnv zzdnvVar = this.zzeot;
        if (zzdnvVar.zzhee) {
            Iterator<String> it = zzdnvVar.zzhdi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdnu(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzdoq.zza(this.zzeot.zzhdq, this.zzfpe);
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final View zzahx() {
        return this.view;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final zzdnu zzaif() {
        return this.zzfpe;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final int zzaig() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxu)).booleanValue() && this.zzeot.zzhei) {
            if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcxv)).booleanValue()) {
                return 0;
            }
        }
        return this.zzfmw.zzhew.zzeou.zzhel;
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final void zzaih() {
        this.zzfoc.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbor
            private final zzbos zzfqa;

            {
                this.zzfqa = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfqa.zzaii();
            }
        });
        super.zzaih();
    }

    final /* synthetic */ void zzaii() {
        if (this.zzfqc.zzams() != null) {
            try {
                this.zzfqc.zzams().zza(this.zzfqe.get(), ObjectWrapper.wrap(this.zzvr));
            } catch (RemoteException e2) {
                zzbbq.zzc("RemoteException when notifyAdLoad is called", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final void zzkf() {
        this.zzfqd.zzakv();
    }
}
