package com.twitter.sdk.android.tweetui.internal;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class q implements MediaPlayer.OnCompletionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20427a;

    q(VideoView videoView) {
        this.f20427a = videoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f20427a.mCurrentState = 5;
        this.f20427a.mTargetState = 5;
        if (this.f20427a.mOnCompletionListener != null) {
            this.f20427a.mOnCompletionListener.onCompletion(this.f20427a.mMediaPlayer);
        }
    }
}
