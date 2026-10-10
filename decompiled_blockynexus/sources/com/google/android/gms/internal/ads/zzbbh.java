package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbh {
    private final View view;
    private boolean zzbrs;
    private boolean zzbvy;
    private Activity zzeea;
    private boolean zzeeb;
    private ViewTreeObserver.OnGlobalLayoutListener zzeec;
    private ViewTreeObserver.OnScrollChangedListener zzeed = null;

    public zzbbh(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzeea = activity;
        this.view = view;
        this.zzeec = onGlobalLayoutListener;
    }

    private static ViewTreeObserver zzi(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void zzyr() {
        ViewTreeObserver viewTreeObserverZzi;
        if (this.zzeeb) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzeec;
        if (onGlobalLayoutListener != null) {
            Activity activity = this.zzeea;
            if (activity != null && (viewTreeObserverZzi = zzi(activity)) != null) {
                viewTreeObserverZzi.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            com.google.android.gms.ads.internal.zzp.zzlo();
            zzbco.zza(this.view, this.zzeec);
        }
        this.zzeeb = true;
    }

    private final void zzys() {
        ViewTreeObserver viewTreeObserverZzi;
        Activity activity = this.zzeea;
        if (activity != null && this.zzeeb) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzeec;
            if (onGlobalLayoutListener != null && (viewTreeObserverZzi = zzi(activity)) != null) {
                com.google.android.gms.ads.internal.zzp.zzkt();
                viewTreeObserverZzi.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzeeb = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzbrs = true;
        if (this.zzbvy) {
            zzyr();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbrs = false;
        zzys();
    }

    public final void zzh(Activity activity) {
        this.zzeea = activity;
    }

    public final void zzyp() {
        this.zzbvy = true;
        if (this.zzbrs) {
            zzyr();
        }
    }

    public final void zzyq() {
        this.zzbvy = false;
        zzys();
    }
}
