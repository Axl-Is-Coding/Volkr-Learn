package com.twitter.sdk.android.tweetui.internal;

import android.widget.SeekBar;

/* JADX INFO: compiled from: VideoControlView.java */
/* JADX INFO: loaded from: classes5.dex */
class n implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoControlView f20424a;

    n(VideoControlView videoControlView) {
        this.f20424a = videoControlView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            int duration = (int) (((long) (this.f20424a.player.getDuration() * i)) / 1000);
            this.f20424a.player.seekTo(duration);
            this.f20424a.setCurrentTime(duration);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f20424a.handler.removeMessages(1001);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f20424a.handler.sendEmptyMessage(1001);
    }
}
