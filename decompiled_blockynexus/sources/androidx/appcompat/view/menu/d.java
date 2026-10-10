package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
class d implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CascadingMenuPopup f458a;

    d(CascadingMenuPopup cascadingMenuPopup) {
        this.f458a = cascadingMenuPopup;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f458a.z;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f458a.z = view.getViewTreeObserver();
            }
            CascadingMenuPopup cascadingMenuPopup = this.f458a;
            cascadingMenuPopup.z.removeGlobalOnLayoutListener(cascadingMenuPopup.k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
