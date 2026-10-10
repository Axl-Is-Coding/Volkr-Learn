package androidx.appcompat.widget;

import android.util.Property;

/* JADX INFO: compiled from: SwitchCompat.java */
/* JADX INFO: loaded from: classes.dex */
class ca extends Property<SwitchCompat, Float> {
    ca(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(SwitchCompat switchCompat) {
        return Float.valueOf(switchCompat.mThumbPosition);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(SwitchCompat switchCompat, Float f2) {
        switchCompat.setThumbPosition(f2.floatValue());
    }
}
