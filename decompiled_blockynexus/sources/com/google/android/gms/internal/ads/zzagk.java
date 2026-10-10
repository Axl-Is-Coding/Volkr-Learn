package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagk {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzded;
    private final NativeCustomTemplateAd.OnCustomClickListener zzdee;
    private NativeCustomTemplateAd zzdef;

    public zzagk(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzded = onCustomTemplateAdLoadedListener;
        this.zzdee = onCustomClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzb(zzafa zzafaVar) {
        if (this.zzdef != null) {
            return this.zzdef;
        }
        zzafb zzafbVar = new zzafb(zzafaVar);
        this.zzdef = zzafbVar;
        return zzafbVar;
    }

    public final zzafl zzsx() {
        return new zzagl(this);
    }

    public final zzafk zzsy() {
        zzagj zzagjVar = null;
        if (this.zzdee == null) {
            return null;
        }
        return new zzagm(this);
    }
}
