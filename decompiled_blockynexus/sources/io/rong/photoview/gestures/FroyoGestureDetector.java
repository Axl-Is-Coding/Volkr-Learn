package io.rong.photoview.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(8)
public class FroyoGestureDetector extends EclairGestureDetector {
    protected final ScaleGestureDetector mDetector;

    public FroyoGestureDetector(Context context) {
        super(context);
        this.mDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: io.rong.photoview.gestures.FroyoGestureDetector.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                FroyoGestureDetector.this.mListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    @Override // io.rong.photoview.gestures.CupcakeGestureDetector, io.rong.photoview.gestures.GestureDetector
    public boolean isScaling() {
        return this.mDetector.isInProgress();
    }

    @Override // io.rong.photoview.gestures.EclairGestureDetector, io.rong.photoview.gestures.CupcakeGestureDetector, io.rong.photoview.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mDetector.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
