package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: Toolbar.java */
/* JADX INFO: loaded from: classes.dex */
class ja implements ActionMenuView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f664a;

    ja(Toolbar toolbar) {
        this.f664a = toolbar;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.d
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toolbar.a aVar = this.f664a.mOnMenuItemClickListener;
        if (aVar != null) {
            return aVar.onMenuItemClick(menuItem);
        }
        return false;
    }
}
