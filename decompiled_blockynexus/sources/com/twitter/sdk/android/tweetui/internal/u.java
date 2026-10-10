package com.twitter.sdk.android.tweetui.internal;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: VideoView.java */
/* JADX INFO: loaded from: classes5.dex */
class u extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f20431a;

    u(VideoView videoView) {
        this.f20431a = videoView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.f20431a.isInPlaybackState() || this.f20431a.mMediaController == null) {
            return false;
        }
        this.f20431a.toggleMediaControlsVisiblity();
        return false;
    }
}
