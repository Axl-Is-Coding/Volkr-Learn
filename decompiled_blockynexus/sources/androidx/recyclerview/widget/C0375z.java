package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;

/* JADX INFO: renamed from: androidx.recyclerview.widget.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0375z implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ItemTouchHelper.c f2043a;

    C0375z(ItemTouchHelper.c cVar) {
        this.f2043a = cVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2043a.a(valueAnimator.getAnimatedFraction());
    }
}
