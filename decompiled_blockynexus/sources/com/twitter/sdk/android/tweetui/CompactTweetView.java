package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.AbstractTweetView;

/* JADX INFO: loaded from: classes5.dex */
public class CompactTweetView extends BaseTweetView {
    private static final double DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER = 1.6d;
    private static final double MAX_LANDSCAPE_ASPECT_RATIO = 3.0d;
    private static final double MIN_LANDSCAPE_ASPECT_RATIO = 1.3333333333333333d;
    private static final double SQUARE_ASPECT_RATIO = 1.0d;

    public CompactTweetView(Context context, com.twitter.sdk.android.core.models.m mVar) {
        super(context, mVar);
    }

    @Override // com.twitter.sdk.android.tweetui.BaseTweetView
    protected void applyStyles() {
        super.applyStyles();
        setPadding(0, getResources().getDimensionPixelSize(R.dimen.tw__compact_tweet_container_padding_top), 0, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tw__media_view_radius);
        this.tweetMediaView.setRoundedCornersRadii(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
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
        return R.layout.tw__tweet_compact;
    }

    @Override // com.twitter.sdk.android.tweetui.BaseTweetView, com.twitter.sdk.android.tweetui.AbstractTweetView
    void render() {
        super.render();
        this.screenNameView.requestLayout();
    }

    public CompactTweetView(Context context, com.twitter.sdk.android.core.models.m mVar, int i) {
        super(context, mVar, i);
    }

    CompactTweetView(Context context, com.twitter.sdk.android.core.models.m mVar, int i, AbstractTweetView.a aVar) {
        super(context, mVar, i, aVar);
    }

    public CompactTweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompactTweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
