package com.alibaba.sdk.android.feedback.util;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface FeedbackErrorCallback {
    void onError(Context context, String str, ErrorCode errorCode);
}
