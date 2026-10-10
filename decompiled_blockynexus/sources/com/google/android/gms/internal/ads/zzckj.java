package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public final class zzckj {
    private PopupWindow zzgfs;
    private Context zzvr;

    private static PopupWindow zzd(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzbbq.zzef("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void zzaoc() {
        Context context = this.zzvr;
        if (context == null || this.zzgfs == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            this.zzvr = null;
            this.zzgfs = null;
        } else {
            if (this.zzgfs.isShowing()) {
                this.zzgfs.dismiss();
            }
            this.zzvr = null;
            this.zzgfs = null;
        }
    }

    public final void zzc(Context context, View view) {
        if (!PlatformVersion.isAtLeastKitKat() || PlatformVersion.isAtLeastLollipop()) {
            return;
        }
        this.zzgfs = zzd(context, view);
        if (this.zzgfs == null) {
            context = null;
        }
        this.zzvr = context;
    }
}
