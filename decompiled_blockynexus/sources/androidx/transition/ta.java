package androidx.transition;

import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class ta extends Property<View, Float> {
    ta(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(View view) {
        return Float.valueOf(va.c(view));
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(View view, Float f2) {
        va.a(view, f2.floatValue());
    }
}
