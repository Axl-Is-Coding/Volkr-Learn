package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface TTInteractionAd {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void showInteractionAd(Activity activity);
}
