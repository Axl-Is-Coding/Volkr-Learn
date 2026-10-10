package com.sandboxol.gamedetail.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.sandboxol.center.utils.CenterDrawableHelper;

/* JADX INFO: loaded from: classes3.dex */
public class CenterRadioButton extends AppCompatRadioButton {
    public CenterRadioButton(Context context) {
        super(context);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        CenterDrawableHelper.preDraw(this, canvas);
        super.onDraw(canvas);
    }

    public CenterRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CenterRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
