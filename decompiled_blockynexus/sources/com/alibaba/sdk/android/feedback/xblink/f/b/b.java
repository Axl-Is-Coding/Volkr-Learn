package com.alibaba.sdk.android.feedback.xblink.f.b;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.xblink.f.b f3838d = null;

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        return true;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public void b() {
        d().a("WXPage.onPaused", "{}");
        super.b();
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public void c() {
        super.c();
        d().a("WXPage.onResumed", "{}");
    }

    public synchronized com.alibaba.sdk.android.feedback.xblink.f.b d() {
        if (this.f3838d == null) {
            this.f3838d = new com.alibaba.sdk.android.feedback.xblink.f.b(this.f3803b, "");
        }
        return this.f3838d;
    }
}
