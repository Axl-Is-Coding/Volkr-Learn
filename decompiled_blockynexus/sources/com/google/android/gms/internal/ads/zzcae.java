package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcae extends zzbyr<zzqu> implements zzqu {
    private final zzdnv zzeot;
    private Map<View, zzqq> zzfwm;
    private final Context zzvr;

    public zzcae(Context context, Set<zzcab<zzqu>> set, zzdnv zzdnvVar) {
        super(set);
        this.zzfwm = new WeakHashMap(1);
        this.zzvr = context;
        this.zzeot = zzdnvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final synchronized void zza(final zzqr zzqrVar) {
        zza(new zzbyt(zzqrVar) { // from class: com.google.android.gms.internal.ads.zzcad
            private final zzqr zzfwl;

            {
                this.zzfwl = zzqrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzqu) obj).zza(this.zzfwl);
            }
        });
    }

    public final synchronized void zzv(View view) {
        zzqq zzqqVar = this.zzfwm.get(view);
        if (zzqqVar == null) {
            zzqqVar = new zzqq(this.zzvr, view);
            zzqqVar.zza(this);
            this.zzfwm.put(view, zzqqVar);
        }
        if (this.zzeot != null && this.zzeot.zzdtq) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcpw)).booleanValue()) {
                zzqqVar.zzen(((Long) zzwm.zzpx().zzd(zzabb.zzcpv)).longValue());
                return;
            }
        }
        zzqqVar.zzlw();
    }

    public final synchronized void zzw(View view) {
        if (this.zzfwm.containsKey(view)) {
            this.zzfwm.get(view).zzb(this);
            this.zzfwm.remove(view);
        }
    }
}
