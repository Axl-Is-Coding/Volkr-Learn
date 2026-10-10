package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.H;

/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
class F extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WindowDecorActionBar f254a;

    F(WindowDecorActionBar windowDecorActionBar) {
        this.f254a = windowDecorActionBar;
    }

    @Override // androidx.core.view.G
    public void b(View view) {
        WindowDecorActionBar windowDecorActionBar = this.f254a;
        windowDecorActionBar.C = null;
        windowDecorActionBar.h.requestLayout();
    }
}
