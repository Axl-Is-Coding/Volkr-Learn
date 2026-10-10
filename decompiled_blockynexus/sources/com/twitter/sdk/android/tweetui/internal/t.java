package com.twitter.sdk.android.tweetui.internal;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class t implements MediaPlayer.OnBufferingUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20430a;

    t(VideoView videoView) {
        this.f20430a = videoView;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f20430a.mCurrentBufferPercentage = i;
    }
}
