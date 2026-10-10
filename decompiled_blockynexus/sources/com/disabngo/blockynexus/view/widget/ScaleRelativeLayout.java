package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.disabngo.blockynexus.R;

/* JADX INFO: loaded from: classes.dex */
public class ScaleRelativeLayout extends RelativeLayout {
    public ScaleRelativeLayout(Context context) {
        this(context, null);
    }

    private synchronized void beginScale(int i) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        animationLoadAnimation.setDuration(10L);
        animationLoadAnimation.setFillAfter(true);
        startAnimation(animationLoadAnimation);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            beginScale(R.anim.anim_zoom_in);
        } else if (action == 1) {
            beginScale(R.anim.anim_zoom_out);
        } else if (action != 2 && action == 3) {
            beginScale(R.anim.anim_zoom_out);
        }
        return super.onTouchEvent(motionEvent);
    }

    public ScaleRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScaleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
