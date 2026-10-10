package androidx.appcompat.app;

import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f320a;

    s(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f320a = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f320a;
        appCompatDelegateImpl.v.showAtLocation(appCompatDelegateImpl.u, 55, 0, 0);
        this.f320a.n();
        if (!this.f320a.u()) {
            this.f320a.u.setAlpha(1.0f);
            this.f320a.u.setVisibility(0);
            return;
        }
        this.f320a.u.setAlpha(WheelView.DividerConfig.FILL);
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.f320a;
        androidx.core.view.F fA = ViewCompat.a(appCompatDelegateImpl2.u);
        fA.a(1.0f);
        appCompatDelegateImpl2.x = fA;
        this.f320a.x.a(new r(this));
    }
}
