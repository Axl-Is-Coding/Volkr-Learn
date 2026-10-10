package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: ExtendedFloatingActionButton.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends Property<View, Float> {
    i(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(View view, Float f2) {
        view.getLayoutParams().height = f2.intValue();
        view.requestLayout();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(View view) {
        return Float.valueOf(view.getLayoutParams().height);
    }
}
