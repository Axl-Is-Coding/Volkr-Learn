package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: StandardMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
class o implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StandardMenuPopup f479a;

    o(StandardMenuPopup standardMenuPopup) {
        this.f479a = standardMenuPopup;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f479a.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f479a.q = view.getViewTreeObserver();
            }
            StandardMenuPopup standardMenuPopup = this.f479a;
            standardMenuPopup.q.removeGlobalOnLayoutListener(standardMenuPopup.k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
