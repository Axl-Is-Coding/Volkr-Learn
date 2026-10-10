package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetui.AbstractTweetView;

/* JADX INFO: loaded from: classes5.dex */
public class TweetView extends BaseTweetView {
    private static final double DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER = 1.5d;
    private static final double SQUARE_ASPECT_RATIO = 1.0d;
    private static final String VIEW_TYPE_NAME = "default";

    public TweetView(Context context, com.twitter.sdk.android.core.models.m mVar) {
        super(context, mVar);
    }

    private void setVerifiedCheck(com.twitter.sdk.android.core.models.m mVar) {
        User user;
        if (mVar == null || (user = mVar.D) == null || !user.verified) {
            this.fullNameView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            this.fullNameView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tw__ic_tweet_verified, 0);
        }
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected double getAspectRatioForPhotoEntity(int i) {
        return i == 4 ? SQUARE_ASPECT_RATIO : DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER;
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected int getLayout() {
        return R.layout.tw__tweet;
    }

    @Override // com.twitter.sdk.android.tweetui.BaseTweetView, com.twitter.sdk.android.tweetui.AbstractTweetView
    void render() {
        super.render();
        setVerifiedCheck(this.tweet);
    }

    public TweetView(Context context, com.twitter.sdk.android.core.models.m mVar, int i) {
        super(context, mVar, i);
    }

    TweetView(Context context, com.twitter.sdk.android.core.models.m mVar, int i, AbstractTweetView.a aVar) {
        super(context, mVar, i, aVar);
    }

    public TweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
