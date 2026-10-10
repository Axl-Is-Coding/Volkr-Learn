package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.C0317e;

/* JADX INFO: compiled from: AppCompatDialog.java */
/* JADX INFO: loaded from: classes.dex */
class w implements C0317e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f324a;

    w(x xVar) {
        this.f324a = xVar;
    }

    @Override // androidx.core.view.C0317e.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f324a.a(keyEvent);
    }
}
