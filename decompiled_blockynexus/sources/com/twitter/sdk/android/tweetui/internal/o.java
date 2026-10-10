package com.twitter.sdk.android.tweetui.internal;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class o implements MediaPlayer.OnVideoSizeChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20425a;

    o(VideoView videoView) {
        this.f20425a = videoView;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f20425a.mVideoWidth = mediaPlayer.getVideoWidth();
        this.f20425a.mVideoHeight = mediaPlayer.getVideoHeight();
        if (this.f20425a.mVideoWidth == 0 || this.f20425a.mVideoHeight == 0) {
            return;
        }
        this.f20425a.getHolder().setFixedSize(this.f20425a.mVideoWidth, this.f20425a.mVideoHeight);
        this.f20425a.requestLayout();
    }
}
