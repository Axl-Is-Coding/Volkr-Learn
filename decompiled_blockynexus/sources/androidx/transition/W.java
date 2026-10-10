package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

/* JADX INFO: compiled from: Slide.java */
/* JADX INFO: loaded from: classes.dex */
class W extends Slide.c {
    W() {
        super(null);
    }

    @Override // androidx.transition.Slide.a
    public float a(ViewGroup viewGroup, View view) {
        return view.getTranslationY() + viewGroup.getHeight();
    }
}
