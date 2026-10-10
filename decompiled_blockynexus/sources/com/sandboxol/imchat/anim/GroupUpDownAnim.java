package com.sandboxol.imchat.anim;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes4.dex */
public class GroupUpDownAnim extends Animation {
    private boolean mIsVisibleAfter;
    private int mMarginEnd;
    private int mMarginStart;
    private LinearLayout.LayoutParams mViewLayoutParams;
    private boolean mWasEndedAlready = false;
    private View view;

    public GroupUpDownAnim(View view, long j) {
        this.mIsVisibleAfter = false;
        setDuration(j);
        this.view = view;
        this.mViewLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        this.mIsVisibleAfter = this.mViewLayoutParams.bottomMargin == 0;
        this.mMarginStart = this.mViewLayoutParams.bottomMargin;
        view.measure(0, 0);
        this.mMarginEnd = this.mMarginStart == 0 ? 0 - view.getMeasuredHeight() : 0;
        view.setVisibility(0);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        Log.i("info", "mMarginStart-->>" + this.mMarginStart + ", mMarginEnd-->>" + this.mMarginEnd + ", interpolatedTime-->>" + f2);
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            this.mViewLayoutParams.bottomMargin = this.mMarginStart + ((int) ((this.mMarginEnd - r0) * f2));
            this.view.requestLayout();
            return;
        }
        if (this.mWasEndedAlready) {
            return;
        }
        this.mViewLayoutParams.bottomMargin = this.mMarginEnd;
        this.view.requestLayout();
        if (this.mIsVisibleAfter) {
            this.view.setVisibility(8);
        }
        this.mWasEndedAlready = true;
    }
}
