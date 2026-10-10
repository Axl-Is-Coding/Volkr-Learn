package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: ToolbarActionBar.java */
/* JADX INFO: loaded from: classes.dex */
class B implements Toolbar.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolbarActionBar f238a;

    B(ToolbarActionBar toolbarActionBar) {
        this.f238a = toolbarActionBar;
    }

    @Override // androidx.appcompat.widget.Toolbar.a
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f238a.f258c.onMenuItemSelected(0, menuItem);
    }
}
