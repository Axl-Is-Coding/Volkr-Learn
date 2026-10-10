package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: StandardMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
class n implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StandardMenuPopup f478a;

    n(StandardMenuPopup standardMenuPopup) {
        this.f478a = standardMenuPopup;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f478a.c() || this.f478a.j.k()) {
            return;
        }
        View view = this.f478a.o;
        if (view == null || !view.isShown()) {
            this.f478a.dismiss();
        } else {
            this.f478a.j.show();
        }
    }
}
