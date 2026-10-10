package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: androidx.core.view.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionProvider.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0314b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f1245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0017b f1246c;

    /* JADX INFO: renamed from: androidx.core.view.b$a */
    /* JADX INFO: compiled from: ActionProvider.java */
    public interface a {
        void b(boolean z);
    }

    /* JADX INFO: renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionProvider.java */
    public interface InterfaceC0017b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public AbstractC0314b(Context context) {
        this.f1244a = context;
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public void a(SubMenu subMenu) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.f1246c = null;
        this.f1245b = null;
    }

    public void a(boolean z) {
        a aVar = this.f1245b;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void a(a aVar) {
        this.f1245b = aVar;
    }

    public void a(InterfaceC0017b interfaceC0017b) {
        if (this.f1246c != null && interfaceC0017b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1246c = interfaceC0017b;
    }
}
