package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

/* JADX INFO: compiled from: GalleryActivity.java */
/* JADX INFO: loaded from: classes5.dex */
class q implements SwipeToDismissTouchListener.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GalleryActivity f20450a;

    q(GalleryActivity galleryActivity) {
        this.f20450a = galleryActivity;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.a
    public void a(float f2) {
    }

    @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.a
    public void onDismiss() {
        this.f20450a.finish();
        this.f20450a.overridePendingTransition(0, R.anim.tw__slide_out);
    }
}
