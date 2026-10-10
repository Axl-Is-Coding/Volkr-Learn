package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes.dex */
public interface TTAdDislike {

    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i, String str);
    }

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void showDislikeDialog();
}
