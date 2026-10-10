package com.alibaba.sdk.android.feedback.xblink.f.a;

/* JADX INFO: loaded from: classes.dex */
public class i extends com.alibaba.sdk.android.feedback.xblink.f.a {
    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"log".equals(str)) {
            return false;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXLog", "FeedbackAPI log " + str2);
        return true;
    }
}
