package com.sandboxol.common.anim;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalMoveAnimation extends Animation {
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    private int direction;
    private boolean enter;
    private int width = 0;

    public HorizontalMoveAnimation(int i, boolean z, long j) {
        this.direction = i;
        this.enter = z;
        setDuration(j);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (this.enter) {
            f2 -= 1.0f;
        }
        if (this.direction == 2) {
            f2 *= -1.0f;
        }
        transformation.getMatrix().postTranslate((-f2) * this.width, WheelView.DividerConfig.FILL);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.width = i;
    }
}
