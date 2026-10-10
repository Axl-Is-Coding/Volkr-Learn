package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.CascadingMenuPopup;

/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CascadingMenuPopup.a f459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MenuItem f460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MenuBuilder f461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ f f462d;

    e(f fVar, CascadingMenuPopup.a aVar, MenuItem menuItem, MenuBuilder menuBuilder) {
        this.f462d = fVar;
        this.f459a = aVar;
        this.f460b = menuItem;
        this.f461c = menuBuilder;
    }

    @Override // java.lang.Runnable
    public void run() {
        CascadingMenuPopup.a aVar = this.f459a;
        if (aVar != null) {
            this.f462d.f463a.B = true;
            aVar.f411b.a(false);
            this.f462d.f463a.B = false;
        }
        if (this.f460b.isEnabled() && this.f460b.hasSubMenu()) {
            this.f461c.a(this.f460b, 4);
        }
    }
}
