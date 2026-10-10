package androidx.appcompat.view.menu;

import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.widget.L;

/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
class f implements L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CascadingMenuPopup f463a;

    f(CascadingMenuPopup cascadingMenuPopup) {
        this.f463a = cascadingMenuPopup;
    }

    @Override // androidx.appcompat.widget.L
    public void a(MenuBuilder menuBuilder, MenuItem menuItem) {
        this.f463a.h.removeCallbacksAndMessages(null);
        int size = this.f463a.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == this.f463a.j.get(i).f411b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        this.f463a.h.postAtTime(new e(this, i2 < this.f463a.j.size() ? this.f463a.j.get(i2) : null, menuItem, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.L
    public void b(MenuBuilder menuBuilder, MenuItem menuItem) {
        this.f463a.h.removeCallbacksAndMessages(menuBuilder);
    }
}
