package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.internal.s;

/* JADX INFO: compiled from: ViewUtilsLollipop.java */
/* JADX INFO: loaded from: classes2.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13138a = {R.attr.stateListAnimator};

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void a(View view, AttributeSet attributeSet, int i, int i2) {
        Context context = view.getContext();
        TypedArray typedArrayA = s.a(context, attributeSet, f13138a, i, i2, new int[0]);
        try {
            if (typedArrayA.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayA.getResourceId(0, 0)));
            }
        } finally {
            typedArrayA.recycle();
        }
    }

    static void a(View view, float f2) {
        int integer = view.getResources().getInteger(com.google.android.material.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, com.google.android.material.R.attr.state_liftable, -com.google.android.material.R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", WheelView.DividerConfig.FILL).setDuration(j));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f2).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", WheelView.DividerConfig.FILL).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
