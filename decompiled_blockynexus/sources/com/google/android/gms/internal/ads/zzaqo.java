package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqo extends zzaqn implements zzahq<zzbgj> {
    private float density;
    private int maxHeight;
    private int maxWidth;
    private int rotation;
    private final WindowManager zzbrj;
    private final zzbgj zzdgy;
    private final zzaam zzdob;
    private int zzdoc;
    private int zzdod;
    private int zzdoe;
    private int zzdof;
    private final Context zzvr;
    private DisplayMetrics zzxd;

    public zzaqo(zzbgj zzbgjVar, Context context, zzaam zzaamVar) {
        super(zzbgjVar);
        this.zzdoc = -1;
        this.zzdod = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.zzdoe = -1;
        this.zzdof = -1;
        this.zzdgy = zzbgjVar;
        this.zzvr = context;
        this.zzdob = zzaamVar;
        this.zzbrj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        this.zzxd = new DisplayMetrics();
        Display defaultDisplay = this.zzbrj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzxd);
        this.density = this.zzxd.density;
        this.rotation = defaultDisplay.getRotation();
        zzwm.zzpt();
        DisplayMetrics displayMetrics = this.zzxd;
        this.zzdoc = zzbbg.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwm.zzpt();
        DisplayMetrics displayMetrics2 = this.zzxd;
        this.zzdod = zzbbg.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityZzzu = this.zzdgy.zzzu();
        if (activityZzzu == null || activityZzzu.getWindow() == null) {
            this.maxWidth = this.zzdoc;
            this.maxHeight = this.zzdod;
        } else {
            com.google.android.gms.ads.internal.zzp.zzkr();
            int[] iArrZzd = zzayu.zzd(activityZzzu);
            zzwm.zzpt();
            this.maxWidth = zzbbg.zzb(this.zzxd, iArrZzd[0]);
            zzwm.zzpt();
            this.maxHeight = zzbbg.zzb(this.zzxd, iArrZzd[1]);
        }
        if (this.zzdgy.zzabu().zzadb()) {
            this.zzdoe = this.zzdoc;
            this.zzdof = this.zzdod;
        } else {
            this.zzdgy.measure(0, 0);
        }
        zza(this.zzdoc, this.zzdod, this.maxWidth, this.maxHeight, this.density, this.rotation);
        this.zzdgy.zza("onDeviceFeaturesReceived", new zzaqj(new zzaql().zzae(this.zzdob.zzrb()).zzad(this.zzdob.zzrc()).zzaf(this.zzdob.zzre()).zzag(this.zzdob.zzrd()).zzah(true)).zzdp());
        int[] iArr = new int[2];
        this.zzdgy.getLocationOnScreen(iArr);
        zzj(zzwm.zzpt().zzb(this.zzvr, iArr[0]), zzwm.zzpt().zzb(this.zzvr, iArr[1]));
        if (zzbbq.isLoggable(2)) {
            zzbbq.zzfd("Dispatching Ready Event.");
        }
        zzdy(this.zzdgy.zzzx().zzbre);
    }

    public final void zzj(int i, int i2) {
        int i3 = this.zzvr instanceof Activity ? com.google.android.gms.ads.internal.zzp.zzkr().zzf((Activity) this.zzvr)[0] : 0;
        if (this.zzdgy.zzabu() == null || !this.zzdgy.zzabu().zzadb()) {
            int width = this.zzdgy.getWidth();
            int height = this.zzdgy.getHeight();
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcnc)).booleanValue()) {
                if (width == 0 && this.zzdgy.zzabu() != null) {
                    width = this.zzdgy.zzabu().widthPixels;
                }
                if (height == 0 && this.zzdgy.zzabu() != null) {
                    height = this.zzdgy.zzabu().heightPixels;
                }
            }
            this.zzdoe = zzwm.zzpt().zzb(this.zzvr, width);
            this.zzdof = zzwm.zzpt().zzb(this.zzvr, height);
        }
        zzb(i, i2 - i3, this.zzdoe, this.zzdof);
        this.zzdgy.zzabw().zzi(i, i2);
    }
}
