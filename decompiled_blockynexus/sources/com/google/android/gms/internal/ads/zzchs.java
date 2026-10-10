package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchs {
    private final Executor zzfoc;
    private final zzcae zzfxz;
    private final zzbnd zzgdy;

    zzchs(Executor executor, zzbnd zzbndVar, zzcae zzcaeVar) {
        this.zzfoc = executor;
        this.zzfxz = zzcaeVar;
        this.zzgdy = zzbndVar;
    }

    final /* synthetic */ void zzf(zzbgj zzbgjVar, Map map) {
        this.zzgdy.disable();
    }

    final /* synthetic */ void zzg(zzbgj zzbgjVar, Map map) {
        this.zzgdy.enable();
    }

    public final void zzl(final zzbgj zzbgjVar) {
        if (zzbgjVar == null) {
            return;
        }
        this.zzfxz.zzv(zzbgjVar.getView());
        this.zzfxz.zza(new zzqu(zzbgjVar) { // from class: com.google.android.gms.internal.ads.zzchr
            private final zzbgj zzeqk;

            {
                this.zzeqk = zzbgjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqu
            public final void zza(zzqr zzqrVar) {
                zzbhv zzbhvVarZzabw = this.zzeqk.zzabw();
                Rect rect = zzqrVar.zzbru;
                zzbhvVarZzabw.zza(rect.left, rect.top, false);
            }
        }, this.zzfoc);
        this.zzfxz.zza(new zzqu(zzbgjVar) { // from class: com.google.android.gms.internal.ads.zzchu
            private final zzbgj zzeqk;

            {
                this.zzeqk = zzbgjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqu
            public final void zza(zzqr zzqrVar) {
                zzbgj zzbgjVar2 = this.zzeqk;
                HashMap map = new HashMap();
                map.put("isVisible", zzqrVar.zzbro ? "1" : "0");
                zzbgjVar2.zza("onAdVisibilityChanged", map);
            }
        }, this.zzfoc);
        this.zzfxz.zza(this.zzgdy, this.zzfoc);
        this.zzgdy.zzg(zzbgjVar);
        zzbgjVar.zza("/trackActiveViewUnit", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzcht
            private final zzchs zzgdz;

            {
                this.zzgdz = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgdz.zzg((zzbgj) obj, map);
            }
        });
        zzbgjVar.zza("/untrackActiveViewUnit", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzchw
            private final zzchs zzgdz;

            {
                this.zzgdz = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgdz.zzf((zzbgj) obj, map);
            }
        });
    }
}
