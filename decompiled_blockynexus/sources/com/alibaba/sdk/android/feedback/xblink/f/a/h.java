package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.view.inputmethod.InputMethodManager;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.alibaba.sdk.android.feedback.xblink.f.a {
    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (com.alibaba.sdk.android.feedback.a.b.n() != null && "down".equals(str)) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) com.alibaba.sdk.android.feedback.a.b.n().getSystemService("input_method");
                if (FeedbackAPI.activity == null) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("WXKeyboard", "Feedback activity has not initialized");
                    return false;
                }
                inputMethodManager.hideSoftInputFromWindow(FeedbackAPI.activity.getWindow().getDecorView().getWindowToken(), 0);
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WXKeyboard", "hideSoftInputFromWindow ok");
                return true;
            } catch (Exception e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WXKeyboard", e2.getMessage());
            }
        }
        return false;
    }
}
