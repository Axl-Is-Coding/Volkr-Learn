package io.rong.imkit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes5.dex */
public class RoundCornerLinearLayout extends LinearLayout {
    private Path path;
    private RectF rect;

    public RoundCornerLinearLayout(Context context) {
        super(context);
        this.path = new Path();
        this.rect = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.path.reset();
        this.rect.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, i, i2);
        this.path.addRoundRect(this.rect, 15.0f, 15.0f, Path.Direction.CW);
        this.path.close();
    }

    public RoundCornerLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.path = new Path();
        this.rect = new RectF();
    }
}
