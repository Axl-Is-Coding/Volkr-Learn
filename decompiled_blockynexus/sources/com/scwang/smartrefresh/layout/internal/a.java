package com.scwang.smartrefresh.layout.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ArrowDrawable.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19181b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19182c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f19183d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (this.f19181b != iWidth || this.f19182c != iHeight) {
            this.f19183d.reset();
            float f2 = (iWidth * 30) / 225;
            float f3 = f2 * 0.70710677f;
            float f4 = f2 / 0.70710677f;
            float f5 = iWidth;
            float f6 = f5 / 2.0f;
            float f7 = iHeight;
            this.f19183d.moveTo(f6, f7);
            float f8 = f7 / 2.0f;
            this.f19183d.lineTo(WheelView.DividerConfig.FILL, f8);
            float f9 = f8 - f3;
            this.f19183d.lineTo(f3, f9);
            float f10 = f2 / 2.0f;
            float f11 = f6 - f10;
            float f12 = (f7 - f4) - f10;
            this.f19183d.lineTo(f11, f12);
            this.f19183d.lineTo(f11, WheelView.DividerConfig.FILL);
            float f13 = f6 + f10;
            this.f19183d.lineTo(f13, WheelView.DividerConfig.FILL);
            this.f19183d.lineTo(f13, f12);
            this.f19183d.lineTo(f5 - f3, f9);
            this.f19183d.lineTo(f5, f8);
            this.f19183d.close();
            this.f19181b = iWidth;
            this.f19182c = iHeight;
        }
        canvas.drawPath(this.f19183d, this.f19184a);
    }
}
