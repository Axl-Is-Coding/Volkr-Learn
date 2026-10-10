package androidx.core.view;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
class z extends ViewCompat.a<Boolean> {
    z(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.ViewCompat.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.view.ViewCompat.a
    public Boolean a(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.ViewCompat.a
    public void a(View view, Boolean bool) {
        view.setAccessibilityHeading(bool.booleanValue());
    }
}
