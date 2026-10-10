package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfe {
    private final Executor executor;
    private final zzadu zzdly;
    private final zzayr zzdzr;
    private final Executor zzfoc;
    private final zzdok zzfsk;
    private final zzcei zzfxu;
    private final zzcem zzfyv;
    private final zzced zzfze;
    private final zzcfm zzgbi;
    private final zzcfu zzgbj;

    public zzcfe(zzayr zzayrVar, zzdok zzdokVar, zzcem zzcemVar, zzcei zzceiVar, zzcfm zzcfmVar, zzcfu zzcfuVar, Executor executor, Executor executor2, zzced zzcedVar) {
        this.zzdzr = zzayrVar;
        this.zzfsk = zzdokVar;
        this.zzdly = zzdokVar.zzdly;
        this.zzfyv = zzcemVar;
        this.zzfxu = zzceiVar;
        this.zzgbi = zzcfmVar;
        this.zzgbj = zzcfuVar;
        this.zzfoc = executor;
        this.executor = executor2;
        this.zzfze = zzcedVar;
    }

    public final void zza(final zzcgc zzcgcVar) {
        this.zzfoc.execute(new Runnable(this, zzcgcVar) { // from class: com.google.android.gms.internal.ads.zzcfd
            private final zzcfe zzgbg;
            private final zzcgc zzgbh;

            {
                this.zzgbg = this;
                this.zzgbh = zzcgcVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgbg.zze(this.zzgbh);
            }
        });
    }

    final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzfxu.zzame() != null) {
            if (2 == this.zzfxu.zzama() || 1 == this.zzfxu.zzama()) {
                this.zzdzr.zza(this.zzfsk.zzhfb, String.valueOf(this.zzfxu.zzama()), z);
            } else if (6 == this.zzfxu.zzama()) {
                this.zzdzr.zza(this.zzfsk.zzhfb, "2", z);
                this.zzdzr.zza(this.zzfsk.zzhfb, "1", z);
            }
        }
    }

    public final void zzc(zzcgc zzcgcVar) {
        if (zzcgcVar == null || this.zzgbi == null || zzcgcVar.zzana() == null || !this.zzfyv.zzamm()) {
            return;
        }
        try {
            zzcgcVar.zzana().addView(this.zzgbi.zzanl());
        } catch (zzbgv e2) {
            zzayp.zza("web view can not be obtained", e2);
        }
    }

    public final void zzd(zzcgc zzcgcVar) {
        if (zzcgcVar == null) {
            return;
        }
        Context context = zzcgcVar.zzahx().getContext();
        if (zzbau.zza(this.zzfyv.zzgah)) {
            if (!(context instanceof Activity)) {
                zzbbq.zzef("Activity context is needed for policy validator.");
                return;
            }
            if (this.zzgbj == null || zzcgcVar.zzana() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(this.zzgbj.zza(zzcgcVar.zzana(), windowManager), zzbau.zzyk());
            } catch (zzbgv e2) {
                zzayp.zza("web view can not be obtained", e2);
            }
        }
    }

    final /* synthetic */ void zze(zzcgc zzcgcVar) {
        ViewGroup viewGroup;
        View viewZzamb;
        final ViewGroup viewGroup2;
        IObjectWrapper iObjectWrapperZzsg;
        Drawable drawable;
        int i = 0;
        if (this.zzfyv.zzamo() || this.zzfyv.zzamn()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            for (int i2 = 0; i2 < 2; i2++) {
                View viewZzgf = zzcgcVar.zzgf(strArr[i2]);
                if (viewZzgf != null && (viewZzgf instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) viewZzgf;
                    break;
                }
            }
            viewGroup = null;
        } else {
            viewGroup = null;
        }
        boolean z = viewGroup != null;
        Context context = zzcgcVar.zzahx().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzfxu.zzamb() != null) {
            viewZzamb = this.zzfxu.zzamb();
            zzadu zzaduVar = this.zzdly;
            if (zzaduVar != null && !z) {
                zza(layoutParams, zzaduVar.zzbnq);
                viewZzamb.setLayoutParams(layoutParams);
            }
        } else if (this.zzfxu.zzsm() instanceof zzadl) {
            zzadl zzadlVar = (zzadl) this.zzfxu.zzsm();
            if (!z) {
                zza(layoutParams, zzadlVar.zzse());
            }
            View zzadoVar = new zzado(context, zzadlVar, layoutParams);
            zzadoVar.setContentDescription((CharSequence) zzwm.zzpx().zzd(zzabb.zzcsd));
            viewZzamb = zzadoVar;
        } else {
            viewZzamb = null;
        }
        if (viewZzamb != null) {
            if (viewZzamb.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewZzamb.getParent()).removeView(viewZzamb);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(viewZzamb);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcgcVar.zzahx().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(viewZzamb);
                FrameLayout frameLayoutZzana = zzcgcVar.zzana();
                if (frameLayoutZzana != null) {
                    frameLayoutZzana.addView(adChoicesView);
                }
            }
            zzcgcVar.zza(zzcgcVar.zzanf(), viewZzamb, true);
        }
        String[] strArr2 = zzcfc.zzgba;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                viewGroup2 = null;
                break;
            }
            View viewZzgf2 = zzcgcVar.zzgf(strArr2[i]);
            if (viewZzgf2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewZzgf2;
                break;
            }
            i++;
        }
        this.executor.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.zzcfg
            private final zzcfe zzgbg;
            private final ViewGroup zzgbn;

            {
                this.zzgbg = this;
                this.zzgbn = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgbg.zzb(this.zzgbn);
            }
        });
        if (viewGroup2 != null) {
            if (zza(viewGroup2)) {
                if (this.zzfxu.zzamf() != null) {
                    this.zzfxu.zzamf().zza(new zzcff(this, zzcgcVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View viewZzahx = zzcgcVar.zzahx();
            Context context2 = viewZzahx != null ? viewZzahx.getContext() : null;
            if (context2 != null) {
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsc)).booleanValue()) {
                    zzadz zzadzVarZzsw = this.zzfze.zzsw();
                    if (zzadzVarZzsw == null) {
                        return;
                    }
                    try {
                        iObjectWrapperZzsg = zzadzVarZzsw.zzsj();
                    } catch (RemoteException unused) {
                        zzbbq.zzfe("Could not get main image drawable");
                        return;
                    }
                } else {
                    zzaee zzaeeVarZzamc = this.zzfxu.zzamc();
                    if (zzaeeVarZzamc == null) {
                        return;
                    }
                    try {
                        iObjectWrapperZzsg = zzaeeVarZzamc.zzsg();
                    } catch (RemoteException unused2) {
                        zzbbq.zzfe("Could not get drawable from image");
                        return;
                    }
                }
                if (iObjectWrapperZzsg == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzsg)) == null) {
                    return;
                }
                ImageView imageView = new ImageView(context2);
                imageView.setImageDrawable(drawable);
                IObjectWrapper iObjectWrapperZzang = zzcgcVar != null ? zzcgcVar.zzang() : null;
                if (iObjectWrapperZzang == null || !((Boolean) zzwm.zzpx().zzd(zzabb.zzcwj)).booleanValue()) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                } else {
                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzang));
                }
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                viewGroup2.addView(imageView);
            }
        }
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(zzcgc zzcgcVar, String[] strArr) {
        Map<String, WeakReference<View>> mapZzand = zzcgcVar.zzand();
        if (mapZzand == null) {
            return false;
        }
        for (String str : strArr) {
            if (mapZzand.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View viewZzame = this.zzfxu.zzame();
        if (viewZzame == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzame.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzame.getParent()).removeView(viewZzame);
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsg)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(viewZzame, layoutParams);
        return true;
    }
}
