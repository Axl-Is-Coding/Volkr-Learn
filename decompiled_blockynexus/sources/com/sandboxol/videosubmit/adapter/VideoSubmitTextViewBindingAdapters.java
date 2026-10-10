package com.sandboxol.videosubmit.adapter;

import android.text.Html;
import android.text.TextUtils;
import android.widget.TextView;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes4.dex */
public class VideoSubmitTextViewBindingAdapters {
    public static void setHtmlText(TextView textView, int i) {
        textView.setText(Html.fromHtml(BaseApplication.getContext().getResources().getString(i)));
    }

    public static void setHtmlText(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(Html.fromHtml(str));
    }
}
