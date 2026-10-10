package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;

/* JADX INFO: loaded from: classes.dex */
public class TabRadioButton extends AppCompatRadioButton {
    private Drawable bottomDrawable;
    private Drawable leftDrawable;
    private Drawable rightDrawable;
    private Drawable topDrawable;

    public TabRadioButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        this.leftDrawable = compoundDrawables[0];
        this.topDrawable = compoundDrawables[1];
        this.rightDrawable = compoundDrawables[2];
        this.bottomDrawable = compoundDrawables[3];
        Drawable drawable = this.topDrawable;
        if (drawable != null && this.leftDrawable == null && this.rightDrawable == null && this.bottomDrawable == null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.topDrawable.getIntrinsicHeight();
            int height = (getHeight() - intrinsicHeight) / 2;
            this.topDrawable.setBounds(0, height, intrinsicWidth, intrinsicHeight + height);
        }
        setCompoundDrawables(this.leftDrawable, this.topDrawable, this.rightDrawable, this.bottomDrawable);
        super.onDraw(canvas);
    }

    public TabRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClickable(true);
        setFocusable(true);
    }
}
