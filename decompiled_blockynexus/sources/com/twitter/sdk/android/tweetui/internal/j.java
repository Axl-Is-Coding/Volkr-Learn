package com.twitter.sdk.android.tweetui.internal;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: MultiTouchImageView.java */
/* JADX INFO: loaded from: classes5.dex */
class j extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MultiTouchImageView f20417a;

    j(MultiTouchImageView multiTouchImageView) {
        this.f20417a = multiTouchImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f20417a.getScale() > 1.0f) {
            MultiTouchImageView multiTouchImageView = this.f20417a;
            multiTouchImageView.animateScale(multiTouchImageView.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
            return true;
        }
        MultiTouchImageView multiTouchImageView2 = this.f20417a;
        multiTouchImageView2.animateScale(multiTouchImageView2.getScale(), 2.0f, motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f20417a.setTranslate(-f2, -f3);
        this.f20417a.setImageMatrix();
        MultiTouchImageView multiTouchImageView = this.f20417a;
        if (!multiTouchImageView.allowIntercept || multiTouchImageView.scaleGestureDetector.isInProgress()) {
            return true;
        }
        this.f20417a.requestDisallowInterceptTouchEvent(false);
        return true;
    }
}
