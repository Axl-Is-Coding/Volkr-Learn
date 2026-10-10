package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.I;

/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
class G implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WindowDecorActionBar f255a;

    G(WindowDecorActionBar windowDecorActionBar) {
        this.f255a = windowDecorActionBar;
    }

    @Override // androidx.core.view.I
    public void a(View view) {
        ((View) this.f255a.h.getParent()).invalidate();
    }
}
