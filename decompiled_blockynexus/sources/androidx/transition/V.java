package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.Slide;

/* JADX INFO: compiled from: Slide.java */
/* JADX INFO: loaded from: classes.dex */
class V extends Slide.b {
    V() {
        super(null);
    }

    @Override // androidx.transition.Slide.a
    public float b(ViewGroup viewGroup, View view) {
        return ViewCompat.m(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
    }
}
