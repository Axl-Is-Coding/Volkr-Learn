package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbgj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public final class zzk {
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdpi;
    public final Context zzvr;

    public zzk(zzbgj zzbgjVar) throws zzi {
        this.zzdpi = zzbgjVar.getLayoutParams();
        ViewParent parent = zzbgjVar.getParent();
        this.zzvr = zzbgjVar.zzabr();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzi("Could not get the parent of the WebView for an overlay.");
        }
        this.parent = (ViewGroup) parent;
        this.index = this.parent.indexOfChild(zzbgjVar.getView());
        this.parent.removeView(zzbgjVar.getView());
        zzbgjVar.zzba(true);
    }
}
