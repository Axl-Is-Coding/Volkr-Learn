package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.VideoInfo;
import com.twitter.sdk.android.tweetui.R;

/* JADX INFO: loaded from: classes5.dex */
public class MediaBadgeView extends FrameLayout {
    ImageView badge;
    TextView videoDuration;

    public MediaBadgeView(Context context) {
        this(context, null);
    }

    void initSubViews(Context context) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tw__media_badge, (ViewGroup) this, true);
        this.videoDuration = (TextView) viewInflate.findViewById(R.id.tw__video_duration);
        this.badge = (ImageView) viewInflate.findViewById(R.id.tw__gif_badge);
    }

    void setBadge(Drawable drawable) {
        this.badge.setVisibility(0);
        this.videoDuration.setVisibility(8);
        this.badge.setImageDrawable(drawable);
    }

    public void setCard(com.twitter.sdk.android.core.models.d dVar) {
        if (com.twitter.sdk.android.core.internal.p.c(dVar)) {
            setBadge(getResources().getDrawable(R.drawable.tw__vine_badge));
        } else {
            setEmpty();
        }
    }

    void setEmpty() {
        this.videoDuration.setVisibility(8);
        this.badge.setVisibility(8);
    }

    public void setMediaEntity(MediaEntity mediaEntity) {
        if ("animated_gif".equals(mediaEntity.type)) {
            setBadge(getResources().getDrawable(R.drawable.tw__gif_badge));
        } else if (!"video".equals(mediaEntity.type)) {
            setEmpty();
        } else {
            VideoInfo videoInfo = mediaEntity.videoInfo;
            setText(videoInfo == null ? 0L : videoInfo.durationMillis);
        }
    }

    void setText(long j) {
        this.videoDuration.setVisibility(0);
        this.badge.setVisibility(8);
        this.videoDuration.setText(h.a(j));
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initSubViews(context);
    }
}
