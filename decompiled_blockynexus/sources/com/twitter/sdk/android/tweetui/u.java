package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

/* JADX INFO: compiled from: PlayerActivity.java */
/* JADX INFO: loaded from: classes5.dex */
class u implements SwipeToDismissTouchListener.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PlayerActivity f20456a;

    u(PlayerActivity playerActivity) {
        this.f20456a = playerActivity;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.a
    public void a(float f2) {
    }

    @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.a
    public void onDismiss() {
        this.f20456a.finish();
        this.f20456a.overridePendingTransition(0, R.anim.tw__slide_out);
    }
}
