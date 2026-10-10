package com.google.ads.mediation.facebook;

import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.google.ads.mediation.facebook.FacebookAdapter;

/* JADX INFO: compiled from: FacebookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class g implements MediaViewListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter.g f12605a;

    g(FacebookAdapter.g gVar) {
        this.f12605a = gVar;
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onComplete(MediaView mediaView) {
        if (FacebookAdapter.this.mNativeListener != null) {
            FacebookAdapter.this.mNativeListener.onVideoEnd(FacebookAdapter.this);
        }
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onEnterFullscreen(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onExitFullscreen(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onFullscreenBackground(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onFullscreenForeground(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onPause(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onPlay(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onVolumeChange(MediaView mediaView, float f2) {
    }
}
