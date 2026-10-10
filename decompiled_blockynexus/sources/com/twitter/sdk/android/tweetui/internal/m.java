package com.twitter.sdk.android.tweetui.internal;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: VideoControlView.java */
/* JADX INFO: loaded from: classes5.dex */
class m extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoControlView f20423a;

    m(VideoControlView videoControlView) {
        this.f20423a = videoControlView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1001) {
            VideoControlView videoControlView = this.f20423a;
            if (videoControlView.player == null) {
                return;
            }
            videoControlView.updateProgress();
            this.f20423a.updateStateControl();
            if (this.f20423a.isShowing() && this.f20423a.player.isPlaying()) {
                sendMessageDelayed(obtainMessage(1001), 500L);
            }
        }
    }
}
