package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";
    b myConstraintSet;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void init(AttributeSet attributeSet) {
        Log.v(TAG, " ################# init");
    }

    public b getConstraintSet() {
        if (this.myConstraintSet == null) {
            this.myConstraintSet = new b();
        }
        this.myConstraintSet.a(this);
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float na;
        public boolean oa;
        public float pa;
        public float qa;
        public float ra;
        public float sa;
        public float ta;
        public float ua;
        public float va;
        public float wa;
        public float xa;
        public float ya;
        public float za;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.na = 1.0f;
            this.oa = false;
            this.pa = WheelView.DividerConfig.FILL;
            this.qa = WheelView.DividerConfig.FILL;
            this.ra = WheelView.DividerConfig.FILL;
            this.sa = WheelView.DividerConfig.FILL;
            this.ta = 1.0f;
            this.ua = 1.0f;
            this.va = WheelView.DividerConfig.FILL;
            this.wa = WheelView.DividerConfig.FILL;
            this.xa = WheelView.DividerConfig.FILL;
            this.ya = WheelView.DividerConfig.FILL;
            this.za = WheelView.DividerConfig.FILL;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.na = 1.0f;
            this.oa = false;
            this.pa = WheelView.DividerConfig.FILL;
            this.qa = WheelView.DividerConfig.FILL;
            this.ra = WheelView.DividerConfig.FILL;
            this.sa = WheelView.DividerConfig.FILL;
            this.ta = 1.0f;
            this.ua = 1.0f;
            this.va = WheelView.DividerConfig.FILL;
            this.wa = WheelView.DividerConfig.FILL;
            this.xa = WheelView.DividerConfig.FILL;
            this.ya = WheelView.DividerConfig.FILL;
            this.za = WheelView.DividerConfig.FILL;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.na = typedArrayObtainStyledAttributes.getFloat(index, this.na);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.pa = typedArrayObtainStyledAttributes.getFloat(index, this.pa);
                    this.oa = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.ra = typedArrayObtainStyledAttributes.getFloat(index, this.ra);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.sa = typedArrayObtainStyledAttributes.getFloat(index, this.sa);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.qa = typedArrayObtainStyledAttributes.getFloat(index, this.qa);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.ta = typedArrayObtainStyledAttributes.getFloat(index, this.ta);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.ua = typedArrayObtainStyledAttributes.getFloat(index, this.ua);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.va = typedArrayObtainStyledAttributes.getFloat(index, this.va);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.wa = typedArrayObtainStyledAttributes.getFloat(index, this.wa);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.xa = typedArrayObtainStyledAttributes.getFloat(index, this.xa);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.ya = typedArrayObtainStyledAttributes.getFloat(index, this.ya);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.xa = typedArrayObtainStyledAttributes.getFloat(index, this.za);
                }
            }
        }
    }
}
