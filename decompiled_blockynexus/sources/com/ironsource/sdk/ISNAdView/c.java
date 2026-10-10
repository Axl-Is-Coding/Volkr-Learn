package com.ironsource.sdk.ISNAdView;

import b.f.d.b.c;

/* JADX INFO: compiled from: ISNAdView.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ISNAdView f15088b;

    c(ISNAdView iSNAdView, String str) {
        this.f15088b = iSNAdView;
        this.f15087a = str;
    }

    @Override // b.f.d.b.c.a
    public void a(String str) {
        this.f15088b.mIsnAdViewLogic.a(this.f15087a, str);
    }
}
