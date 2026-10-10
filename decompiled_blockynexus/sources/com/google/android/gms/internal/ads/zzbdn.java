package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbdn {
    private final Context zzclo;
    private final zzbdu zzegh;
    private final ViewGroup zzehc;
    private zzbdh zzehd;

    public zzbdn(Context context, ViewGroup viewGroup, zzbgj zzbgjVar) {
        this(context, viewGroup, zzbgjVar, null);
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbdh zzbdhVar = this.zzehd;
        if (zzbdhVar != null) {
            zzbdhVar.destroy();
            this.zzehc.removeView(this.zzehd);
            this.zzehd = null;
        }
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbdh zzbdhVar = this.zzehd;
        if (zzbdhVar != null) {
            zzbdhVar.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbdv zzbdvVar) {
        if (this.zzehd != null) {
            return;
        }
        zzabj.zza(this.zzegh.zzzw().zzrp(), this.zzegh.zzzt(), "vpr2");
        Context context = this.zzclo;
        zzbdu zzbduVar = this.zzegh;
        this.zzehd = new zzbdh(context, zzbduVar, i5, z, zzbduVar.zzzw().zzrp(), zzbdvVar);
        this.zzehc.addView(this.zzehd, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzehd.zzd(i, i2, i3, i4);
        this.zzegh.zzav(false);
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbdh zzbdhVar = this.zzehd;
        if (zzbdhVar != null) {
            zzbdhVar.zzd(i, i2, i3, i4);
        }
    }

    public final zzbdh zzzn() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzehd;
    }

    @VisibleForTesting
    private zzbdn(Context context, ViewGroup viewGroup, zzbdu zzbduVar, zzbdh zzbdhVar) {
        this.zzclo = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzehc = viewGroup;
        this.zzegh = zzbduVar;
        this.zzehd = null;
    }
}
