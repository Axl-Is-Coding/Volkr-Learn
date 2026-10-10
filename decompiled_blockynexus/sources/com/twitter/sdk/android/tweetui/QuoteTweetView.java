package com.twitter.sdk.android.tweetui;

import android.content.Context;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.AbstractTweetView;

/* JADX INFO: loaded from: classes5.dex */
public class QuoteTweetView extends AbstractTweetView {
    private static final double DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER = 1.6d;
    private static final double MAX_LANDSCAPE_ASPECT_RATIO = 3.0d;
    private static final double MIN_LANDSCAPE_ASPECT_RATIO = 1.3333333333333333d;
    private static final double SQUARE_ASPECT_RATIO = 1.0d;

    public QuoteTweetView(Context context) {
        this(context, new AbstractTweetView.a());
    }

    protected void applyStyles() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tw__media_view_radius);
        this.tweetMediaView.setRoundedCornersRadii(0, 0, dimensionPixelSize, dimensionPixelSize);
        setBackgroundResource(R.drawable.tw__quote_tweet_border);
        this.fullNameView.setTextColor(this.primaryTextColor);
        this.screenNameView.setTextColor(this.secondaryTextColor);
        this.contentView.setTextColor(this.primaryTextColor);
        this.tweetMediaView.setMediaBgColor(this.mediaBgColor);
        this.tweetMediaView.setPhotoErrorResId(this.photoErrorResId);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected double getAspectRatio(MediaEntity mediaEntity) {
        double aspectRatio = super.getAspectRatio(mediaEntity);
        return aspectRatio <= SQUARE_ASPECT_RATIO ? SQUARE_ASPECT_RATIO : aspectRatio > MAX_LANDSCAPE_ASPECT_RATIO ? MAX_LANDSCAPE_ASPECT_RATIO : aspectRatio < MIN_LANDSCAPE_ASPECT_RATIO ? MIN_LANDSCAPE_ASPECT_RATIO : aspectRatio;
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected double getAspectRatioForPhotoEntity(int i) {
        return DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER;
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    protected int getLayout() {
        return R.layout.tw__tweet_quote;
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ com.twitter.sdk.android.core.models.m getTweet() {
        return super.getTweet();
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ long getTweetId() {
        return super.getTweetId();
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    void render() {
        super.render();
        this.screenNameView.requestLayout();
    }

    public void setStyle(int i, int i2, int i3, int i4, int i5, int i6) {
        this.primaryTextColor = i;
        this.secondaryTextColor = i2;
        this.actionColor = i3;
        this.actionHighlightColor = i4;
        this.mediaBgColor = i5;
        this.photoErrorResId = i6;
        applyStyles();
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ void setTweet(com.twitter.sdk.android.core.models.m mVar) {
        super.setTweet(mVar);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ void setTweetLinkClickListener(E e2) {
        super.setTweetLinkClickListener(e2);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ void setTweetMediaClickListener(F f2) {
        super.setTweetMediaClickListener(f2);
    }

    QuoteTweetView(Context context, AbstractTweetView.a aVar) {
        super(context, null, 0, aVar);
    }
}
