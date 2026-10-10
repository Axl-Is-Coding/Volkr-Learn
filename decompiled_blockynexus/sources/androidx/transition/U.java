package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

/* JADX INFO: compiled from: Slide.java */
/* JADX INFO: loaded from: classes.dex */
class U extends Slide.b {
    U() {
        super(null);
    }

    @Override // androidx.transition.Slide.a
    public float b(ViewGroup viewGroup, View view) {
        return view.getTranslationX() + viewGroup.getWidth();
    }
}
