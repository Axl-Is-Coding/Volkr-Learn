package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpw extends zzboq {
    private final Executor zzfoc;
    private final zzafy zzfqz;
    private final Runnable zzfra;

    public zzbpw(zzbqn zzbqnVar, zzafy zzafyVar, Runnable runnable, Executor executor) {
        super(zzbqnVar);
        this.zzfqz = zzafyVar;
        this.zzfra = runnable;
        this.zzfoc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final zzyo getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final void zza(ViewGroup viewGroup, zzvn zzvnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final zzdnu zzahw() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final View zzahx() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final zzdnu zzaif() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final int zzaig() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final void zzaih() {
        final AtomicReference atomicReference = new AtomicReference(this.zzfra);
        final Runnable runnable = new Runnable(atomicReference) { // from class: com.google.android.gms.internal.ads.zzbpv
            private final AtomicReference zzfqy;

            {
                this.zzfqy = atomicReference;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = (Runnable) this.zzfqy.getAndSet(null);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        };
        this.zzfoc.execute(new Runnable(this, runnable) { // from class: com.google.android.gms.internal.ads.zzbpy
            private final Runnable zzfmg;
            private final zzbpw zzfrb;

            {
                this.zzfrb = this;
                this.zzfmg = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfrb.zze(this.zzfmg);
            }
        });
    }

    final /* synthetic */ void zze(Runnable runnable) {
        try {
            if (this.zzfqz.zzm(ObjectWrapper.wrap(runnable))) {
                return;
            }
            runnable.run();
        } catch (RemoteException unused) {
            runnable.run();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboq
    public final void zzkf() {
    }
}
