package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
class w implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f1273a;

    w(r rVar) {
        this.f1273a = rVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return this.f1273a.a(view, J.a(windowInsets)).h();
    }
}
