package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: compiled from: ListPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListPopupWindow f541a;

    J(ListPopupWindow listPopupWindow) {
        this.f541a = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        View viewH = this.f541a.h();
        if (viewH == null || viewH.getWindowToken() == null) {
            return;
        }
        this.f541a.show();
    }
}
