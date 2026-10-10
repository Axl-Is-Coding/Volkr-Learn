package com.sandboxol.center.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.sandboxol.center.utils.CenterDrawableHelper;

/* JADX INFO: loaded from: classes3.dex */
public class CenterButton extends AppCompatButton {
    public CenterButton(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        CenterDrawableHelper.preDraw(this, canvas);
        super.onDraw(canvas);
    }

    public CenterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CenterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
