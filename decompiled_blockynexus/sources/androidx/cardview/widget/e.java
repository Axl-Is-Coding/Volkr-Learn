package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.j;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: CardViewBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
class e implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f787a;

    e(f fVar) {
        this.f787a = fVar;
    }

    @Override // androidx.cardview.widget.j.a
    public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
        float f3 = 2.0f * f2;
        float fWidth = (rectF.width() - f3) - 1.0f;
        float fHeight = (rectF.height() - f3) - 1.0f;
        if (f2 >= 1.0f) {
            float f4 = f2 + 0.5f;
            float f5 = -f4;
            this.f787a.f788a.set(f5, f5, f4, f4);
            int iSave = canvas.save();
            canvas.translate(rectF.left + f4, rectF.top + f4);
            canvas.drawArc(this.f787a.f788a, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, WheelView.DividerConfig.FILL);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f787a.f788a, 180.0f, 90.0f, true, paint);
            canvas.translate(fHeight, WheelView.DividerConfig.FILL);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f787a.f788a, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, WheelView.DividerConfig.FILL);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f787a.f788a, 180.0f, 90.0f, true, paint);
            canvas.restoreToCount(iSave);
            float f6 = (rectF.left + f4) - 1.0f;
            float f7 = rectF.top;
            canvas.drawRect(f6, f7, (rectF.right - f4) + 1.0f, f7 + f4, paint);
            float f8 = (rectF.left + f4) - 1.0f;
            float f9 = rectF.bottom;
            canvas.drawRect(f8, f9 - f4, (rectF.right - f4) + 1.0f, f9, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
    }
}
