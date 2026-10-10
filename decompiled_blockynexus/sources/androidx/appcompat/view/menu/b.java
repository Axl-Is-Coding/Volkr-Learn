package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: BaseMenuWrapper.java */
/* JADX INFO: loaded from: classes.dex */
abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<androidx.core.b.a.b, MenuItem> f455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<androidx.core.b.a.c, SubMenu> f456c;

    b(Context context) {
        this.f454a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof androidx.core.b.a.b)) {
            return menuItem;
        }
        androidx.core.b.a.b bVar = (androidx.core.b.a.b) menuItem;
        if (this.f455b == null) {
            this.f455b = new a.a.b();
        }
        MenuItem menuItem2 = this.f455b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        h hVar = new h(this.f454a, bVar);
        this.f455b.put(bVar, hVar);
        return hVar;
    }

    final void b() {
        Map<androidx.core.b.a.b, MenuItem> map = this.f455b;
        if (map != null) {
            map.clear();
        }
        Map<androidx.core.b.a.c, SubMenu> map2 = this.f456c;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void b(int i) {
        Map<androidx.core.b.a.b, MenuItem> map = this.f455b;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof androidx.core.b.a.c)) {
            return subMenu;
        }
        androidx.core.b.a.c cVar = (androidx.core.b.a.c) subMenu;
        if (this.f456c == null) {
            this.f456c = new a.a.b();
        }
        SubMenu subMenu2 = this.f456c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        p pVar = new p(this.f454a, cVar);
        this.f456c.put(cVar, pVar);
        return pVar;
    }

    final void a(int i) {
        Map<androidx.core.b.a.b, MenuItem> map = this.f455b;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }
}
