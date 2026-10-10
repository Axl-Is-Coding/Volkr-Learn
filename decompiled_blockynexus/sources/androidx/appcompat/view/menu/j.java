package androidx.appcompat.view.menu;

import android.widget.PopupWindow;

/* JADX INFO: compiled from: MenuPopupHelper.java */
/* JADX INFO: loaded from: classes.dex */
class j implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MenuPopupHelper f476a;

    j(MenuPopupHelper menuPopupHelper) {
        this.f476a = menuPopupHelper;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f476a.d();
    }
}
