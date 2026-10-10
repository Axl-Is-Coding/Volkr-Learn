package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OL extends RelativeLayout {
    public final Paint A00;
    public final RectF A01;

    public OL(C2026Wb c2026Wb, String str) {
        super(c2026Wb);
        float f2 = c2026Wb.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(c2026Wb);
        textView.setTextColor(-16777216);
        textView.setTextSize(16.0f);
        textView.setText(str);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        int i = (int) (6.0f * f2);
        textView.setPadding(i, i, i, i);
        addView(textView);
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        this.A00.setColor(-1);
        this.A01 = new RectF();
        LX.A0P(this, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f2 = getContext().getResources().getDisplayMetrics().density;
        this.A01.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getWidth(), getHeight());
        canvas.drawRoundRect(this.A01, f2 * 10.0f, 10.0f * f2, this.A00);
        super.onDraw(canvas);
    }
}
