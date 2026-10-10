package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
class y extends ViewCompat.a<CharSequence> {
    y(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.view.ViewCompat.a
    public CharSequence a(View view) {
        return view.getAccessibilityPaneTitle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.ViewCompat.a
    public void a(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.ViewCompat.a
    public boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
