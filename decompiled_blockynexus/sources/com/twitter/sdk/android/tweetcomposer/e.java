package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.User;

/* JADX INFO: compiled from: ComposerController.java */
/* JADX INFO: loaded from: classes5.dex */
class e extends com.twitter.sdk.android.core.c<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f20300a;

    e(f fVar) {
        this.f20300a = fVar;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<User> kVar) {
        this.f20300a.f20301a.setProfilePhotoView(kVar.f20217a);
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        this.f20300a.f20301a.setProfilePhotoView(null);
    }
}
