package com.twitter.sdk.android.tweetui.internal;

import android.view.SurfaceHolder;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class v implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20432a;

    v(VideoView videoView) {
        this.f20432a = videoView;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f20432a.mSurfaceWidth = i2;
        this.f20432a.mSurfaceHeight = i3;
        boolean z = this.f20432a.mTargetState == 3;
        boolean z2 = this.f20432a.mVideoWidth == i2 && this.f20432a.mVideoHeight == i3;
        if (this.f20432a.mMediaPlayer != null && z && z2) {
            if (this.f20432a.mSeekWhenPrepared != 0) {
                VideoView videoView = this.f20432a;
                videoView.seekTo(videoView.mSeekWhenPrepared);
            }
            this.f20432a.start();
            if (this.f20432a.mMediaController != null) {
                this.f20432a.mMediaController.show();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f20432a.mSurfaceHolder = surfaceHolder;
        this.f20432a.openVideo();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f20432a.mSurfaceHolder = null;
        if (this.f20432a.mMediaController != null) {
            this.f20432a.mMediaController.hide();
        }
        this.f20432a.release(true);
    }
}
