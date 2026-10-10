package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
class B implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f518b;

    B(AppCompatSpinner.b bVar, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f518b = bVar;
        this.f517a = onGlobalLayoutListener;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f517a);
        }
    }
}
