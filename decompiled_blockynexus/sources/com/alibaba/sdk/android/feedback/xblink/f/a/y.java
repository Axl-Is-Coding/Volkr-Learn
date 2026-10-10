package com.alibaba.sdk.android.feedback.xblink.f.a;

/* JADX INFO: loaded from: classes.dex */
public class y extends com.alibaba.sdk.android.feedback.xblink.f.a {
    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"track".equals(str)) {
            return false;
        }
        com.alibaba.sdk.android.feedback.util.n.a(str2, null);
        com.alibaba.sdk.android.feedback.xblink.i.g.a("FeedbackAPI UT", str2);
        return true;
    }
}
