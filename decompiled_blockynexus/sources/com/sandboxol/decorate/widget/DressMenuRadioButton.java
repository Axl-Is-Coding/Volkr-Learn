package com.sandboxol.decorate.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes3.dex */
public class DressMenuRadioButton extends AppCompatRadioButton {
    public DressMenuRadioButton(Context context) {
        super(context);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && (drawable = compoundDrawables[0]) != null) {
            canvas.translate((getWidth() - ((getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth()) + getCompoundDrawablePadding())) / 2.0f, WheelView.DividerConfig.FILL);
        }
        super.onDraw(canvas);
    }

    public DressMenuRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DressMenuRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
