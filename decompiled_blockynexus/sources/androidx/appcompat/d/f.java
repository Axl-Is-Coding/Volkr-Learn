package androidx.appcompat.d;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.l;
import java.util.ArrayList;

/* JADX INFO: compiled from: SupportActionModeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f369b;

    public f(Context context, b bVar) {
        this.f368a = context;
        this.f369b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f369b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f369b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new l(this.f368a, (androidx.core.b.a.a) this.f369b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f369b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f369b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f369b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f369b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f369b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f369b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f369b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f369b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f369b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f369b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f369b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f369b.a(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f369b.a(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f369b.b(i);
    }

    /* JADX INFO: compiled from: SupportActionModeWrapper.java */
    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<f> f372c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final a.a.i<Menu, Menu> f373d = new a.a.i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f371b = context;
            this.f370a = callback;
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f370a.onCreateActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.d.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f370a.onPrepareActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f370a.onActionItemClicked(b(bVar), new androidx.appcompat.view.menu.h(this.f371b, (androidx.core.b.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f372c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f372c.get(i);
                if (fVar != null && fVar.f369b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f371b, bVar);
            this.f372c.add(fVar2);
            return fVar2;
        }

        @Override // androidx.appcompat.d.b.a
        public void a(b bVar) {
            this.f370a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f373d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            l lVar = new l(this.f371b, (androidx.core.b.a.a) menu);
            this.f373d.put(menu, lVar);
            return lVar;
        }
    }
}
