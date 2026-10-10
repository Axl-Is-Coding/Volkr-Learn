package com.twitter.sdk.android.tweetui.internal;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class p implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20426a;

    p(VideoView videoView) {
        this.f20426a = videoView;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f20426a.mCurrentState = 2;
        if (this.f20426a.mOnPreparedListener != null) {
            this.f20426a.mOnPreparedListener.onPrepared(this.f20426a.mMediaPlayer);
        }
        if (this.f20426a.mMediaController != null) {
            this.f20426a.mMediaController.setEnabled(true);
        }
        this.f20426a.mVideoWidth = mediaPlayer.getVideoWidth();
        this.f20426a.mVideoHeight = mediaPlayer.getVideoHeight();
        int i = this.f20426a.mSeekWhenPrepared;
        if (i != 0) {
            this.f20426a.seekTo(i);
        }
        if (this.f20426a.mVideoWidth == 0 || this.f20426a.mVideoHeight == 0) {
            if (this.f20426a.mTargetState == 3) {
                this.f20426a.start();
                return;
            }
            return;
        }
        this.f20426a.getHolder().setFixedSize(this.f20426a.mVideoWidth, this.f20426a.mVideoHeight);
        if (this.f20426a.mSurfaceWidth == this.f20426a.mVideoWidth && this.f20426a.mSurfaceHeight == this.f20426a.mVideoHeight) {
            if (this.f20426a.mTargetState == 3) {
                this.f20426a.start();
                if (this.f20426a.mMediaController != null) {
                    this.f20426a.mMediaController.show();
                    return;
                }
                return;
            }
            if (this.f20426a.isPlaying()) {
                return;
            }
            if ((i != 0 || this.f20426a.getCurrentPosition() > 0) && this.f20426a.mMediaController != null) {
                this.f20426a.mMediaController.show();
            }
        }
    }
}
