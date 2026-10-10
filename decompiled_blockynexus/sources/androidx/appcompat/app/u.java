package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.H;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class u extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl.c f322a;

    u(AppCompatDelegateImpl.c cVar) {
        this.f322a = cVar;
    }

    @Override // androidx.core.view.G
    public void b(View view) {
        AppCompatDelegateImpl.this.u.setVisibility(8);
        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
        PopupWindow popupWindow = appCompatDelegateImpl.v;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (appCompatDelegateImpl.u.getParent() instanceof View) {
            ViewCompat.H((View) AppCompatDelegateImpl.this.u.getParent());
        }
        AppCompatDelegateImpl.this.u.removeAllViews();
        AppCompatDelegateImpl.this.x.a((androidx.core.view.G) null);
        AppCompatDelegateImpl.this.x = null;
    }
}
