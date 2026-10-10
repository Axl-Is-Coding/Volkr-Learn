package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import androidx.swiperefreshlayout.widget.d;

/* JADX INFO: compiled from: CircularProgressDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d.a f2091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f2092b;

    b(d dVar, d.a aVar) {
        this.f2092b = dVar;
        this.f2091a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f2092b.a(fFloatValue, this.f2091a);
        this.f2092b.a(fFloatValue, this.f2091a, false);
        this.f2092b.invalidateSelf();
    }
}
