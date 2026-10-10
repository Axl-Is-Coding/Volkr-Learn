package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class ua extends Property<View, Rect> {
    ua(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect get(View view) {
        return ViewCompat.g(view);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(View view, Rect rect) {
        ViewCompat.a(view, rect);
    }
}
