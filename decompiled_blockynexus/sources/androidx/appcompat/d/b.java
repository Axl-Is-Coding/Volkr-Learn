package androidx.appcompat.d;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: ActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f358b;

    /* JADX INFO: compiled from: ActionMode.java */
    public interface a {
        void a(b bVar);

        boolean a(b bVar, Menu menu);

        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);
    }

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public void a(Object obj) {
        this.f357a = obj;
    }

    public abstract View b();

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.f357a;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.f358b;
    }

    public abstract void i();

    public abstract boolean j();

    public void a(boolean z) {
        this.f358b = z;
    }
}
