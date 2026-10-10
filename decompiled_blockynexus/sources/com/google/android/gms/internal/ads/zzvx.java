package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzvx {
    private final zzve zzcik;
    private final zzvf zzcil;
    private final zzzl zzcim;
    private final zzagi zzcin;
    private final zzauk zzcio;
    private final zzavo zzcip;
    private final zzaqz zzciq;
    private final zzagh zzcir;

    public zzvx(zzve zzveVar, zzvf zzvfVar, zzzl zzzlVar, zzagi zzagiVar, zzauk zzaukVar, zzavo zzavoVar, zzaqz zzaqzVar, zzagh zzaghVar) {
        this.zzcik = zzveVar;
        this.zzcil = zzvfVar;
        this.zzcim = zzzlVar;
        this.zzcin = zzagiVar;
        this.zzcio = zzaukVar;
        this.zzcip = zzavoVar;
        this.zzciq = zzaqzVar;
        this.zzcir = zzaghVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzwm.zzpt().zza(context, zzwm.zzpz().zzbre, "gmob-apps", bundle, true);
    }

    public final zzwz zzb(Context context, String str, zzanb zzanbVar) {
        return new zzwg(this, context, str, zzanbVar).zzd(context, false);
    }

    public final zzauy zzc(Context context, String str, zzanb zzanbVar) {
        return new zzvz(this, context, str, zzanbVar).zzd(context, false);
    }

    public final zzaqy zzb(Activity activity) {
        zzvy zzvyVar = new zzvy(this, activity);
        Intent intent = activity.getIntent();
        boolean booleanExtra = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbbq.zzfc("useClientJar flag not found in activity intent extras.");
        } else {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return zzvyVar.zzd(activity, booleanExtra);
    }

    public final zzxc zza(Context context, zzvn zzvnVar, String str, zzanb zzanbVar) {
        return new zzwf(this, context, zzvnVar, str, zzanbVar).zzd(context, false);
    }

    public final zzaei zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new zzwi(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzaqp zzb(Context context, zzanb zzanbVar) {
        return new zzwd(this, context, zzanbVar).zzd(context, false);
    }

    public final zzael zza(View view, HashMap<String, View> map, HashMap<String, View> map2) {
        return new zzwl(this, view, map, map2).zzd(view.getContext(), false);
    }

    public final zzaxl zza(Context context, zzanb zzanbVar) {
        return new zzwb(this, context, zzanbVar).zzd(context, false);
    }
}
