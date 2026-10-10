package com.twitter.sdk.android.tweetui.internal;

import android.view.ScaleGestureDetector;

/* JADX INFO: compiled from: MultiTouchImageView.java */
/* JADX INFO: loaded from: classes5.dex */
class i extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MultiTouchImageView f20416a;

    i(MultiTouchImageView multiTouchImageView) {
        this.f20416a = multiTouchImageView;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.f20416a.setScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        this.f20416a.setImageMatrix();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        if (this.f20416a.getScale() < 1.0f) {
            this.f20416a.reset();
            this.f20416a.setImageMatrix();
        }
    }
}
