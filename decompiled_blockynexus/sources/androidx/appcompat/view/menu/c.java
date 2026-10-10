package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import java.util.Iterator;

/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CascadingMenuPopup f457a;

    c(CascadingMenuPopup cascadingMenuPopup) {
        this.f457a = cascadingMenuPopup;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f457a.c() || this.f457a.j.size() <= 0 || this.f457a.j.get(0).f410a.k()) {
            return;
        }
        View view = this.f457a.q;
        if (view == null || !view.isShown()) {
            this.f457a.dismiss();
            return;
        }
        Iterator<CascadingMenuPopup.a> it = this.f457a.j.iterator();
        while (it.hasNext()) {
            it.next().f410a.show();
        }
    }
}
