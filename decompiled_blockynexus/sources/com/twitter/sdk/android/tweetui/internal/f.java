package com.twitter.sdk.android.tweetui.internal;

import android.view.View;
import android.view.ViewPropertyAnimator;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes5.dex */
class f {
    public static ViewPropertyAnimator a(View view, int i) {
        if (view.getVisibility() != 0) {
            view.setAlpha(WheelView.DividerConfig.FILL);
            view.setVisibility(0);
        }
        view.clearAnimation();
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(i).setListener(null);
        return viewPropertyAnimatorAnimate;
    }

    public static ViewPropertyAnimator b(View view, int i) {
        if (view.getVisibility() != 0) {
            return null;
        }
        view.clearAnimation();
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        viewPropertyAnimatorAnimate.alpha(WheelView.DividerConfig.FILL).setDuration(i).setListener(new e(view));
        return viewPropertyAnimatorAnimate;
    }
}
