package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class TN implements InterfaceC1727Kj {
    @Override // com.facebook.ads.redexgen.X.InterfaceC1727Kj
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Window.Callback callback = activity.getWindow() != null ? activity.getWindow().getCallback() : null;
        if (callback != null) {
            WindowCallbackC1723Kf windowCallbackC1723Kf = new WindowCallbackC1723Kf(callback, activity);
            WindowCallbackC1723Kf.A00(new TM(this));
            activity.getWindow().setCallback(windowCallbackC1723Kf);
        }
    }
}
