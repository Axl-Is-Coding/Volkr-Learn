package com.twitter.sdk.android.tweetui.internal;

import android.media.MediaPlayer;
import android.util.Log;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class s implements MediaPlayer.OnErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20429a;

    s(VideoView videoView) {
        this.f20429a = videoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Log.d(this.f20429a.TAG, "Error: " + i + "," + i2);
        this.f20429a.mCurrentState = -1;
        this.f20429a.mTargetState = -1;
        if (this.f20429a.mMediaController != null) {
            this.f20429a.mMediaController.hide();
        }
        if (this.f20429a.mOnErrorListener == null || this.f20429a.mOnErrorListener.onError(this.f20429a.mMediaPlayer, i, i2)) {
        }
        return true;
    }
}
