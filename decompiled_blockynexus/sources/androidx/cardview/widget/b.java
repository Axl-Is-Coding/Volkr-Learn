package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.j;

/* JADX INFO: compiled from: CardViewApi17Impl.java */
/* JADX INFO: loaded from: classes.dex */
class b implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f786a;

    b(c cVar) {
        this.f786a = cVar;
    }

    @Override // androidx.cardview.widget.j.a
    public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
        canvas.drawRoundRect(rectF, f2, f2, paint);
    }
}
