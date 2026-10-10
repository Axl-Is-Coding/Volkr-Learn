package androidx.appcompat.view.menu;

import androidx.core.view.AbstractC0314b;

/* JADX INFO: compiled from: MenuItemImpl.java */
/* JADX INFO: loaded from: classes.dex */
class g implements AbstractC0314b.InterfaceC0017b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MenuItemImpl f464a;

    g(MenuItemImpl menuItemImpl) {
        this.f464a = menuItemImpl;
    }

    @Override // androidx.core.view.AbstractC0314b.InterfaceC0017b
    public void onActionProviderVisibilityChanged(boolean z) {
        MenuItemImpl menuItemImpl = this.f464a;
        menuItemImpl.n.d(menuItemImpl);
    }
}
