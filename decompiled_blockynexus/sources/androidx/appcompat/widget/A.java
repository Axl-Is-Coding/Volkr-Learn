package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
class A implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f481a;

    A(AppCompatSpinner.b bVar) {
        this.f481a = bVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        AppCompatSpinner.b bVar = this.f481a;
        if (!bVar.b(AppCompatSpinner.this)) {
            this.f481a.dismiss();
        } else {
            this.f481a.l();
            super/*androidx.appcompat.widget.ListPopupWindow*/.show();
        }
    }
}
