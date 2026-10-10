package androidx.appcompat.widget;

import android.os.Build;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC0311y implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner f721a;

    ViewTreeObserverOnGlobalLayoutListenerC0311y(AppCompatSpinner appCompatSpinner) {
        this.f721a = appCompatSpinner;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f721a.getInternalPopup().c()) {
            this.f721a.showPopup();
        }
        ViewTreeObserver viewTreeObserver = this.f721a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }
}
