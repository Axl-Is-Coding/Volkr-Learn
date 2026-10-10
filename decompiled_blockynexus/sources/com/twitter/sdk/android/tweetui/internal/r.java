package com.twitter.sdk.android.tweetui.internal;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class r implements MediaPlayer.OnInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20428a;

    r(VideoView videoView) {
        this.f20428a = videoView;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f20428a.mOnInfoListener == null) {
            return true;
        }
        this.f20428a.mOnInfoListener.onInfo(mediaPlayer, i, i2);
        return true;
    }
}
