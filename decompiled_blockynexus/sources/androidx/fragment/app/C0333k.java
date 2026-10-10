package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentController.java */
/* JADX INFO: loaded from: classes.dex */
public class C0333k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0335m<?> f1507a;

    private C0333k(AbstractC0335m<?> abstractC0335m) {
        this.f1507a = abstractC0335m;
    }

    public static C0333k a(AbstractC0335m<?> abstractC0335m) {
        androidx.core.f.h.a(abstractC0335m, "callbacks == null");
        return new C0333k(abstractC0335m);
    }

    public void b() {
        this.f1507a.f1513e.j();
    }

    public void c() {
        this.f1507a.f1513e.k();
    }

    public void d() {
        this.f1507a.f1513e.m();
    }

    public void e() {
        this.f1507a.f1513e.n();
    }

    public void f() {
        this.f1507a.f1513e.p();
    }

    public void g() {
        this.f1507a.f1513e.q();
    }

    public void h() {
        this.f1507a.f1513e.r();
    }

    public boolean i() {
        return this.f1507a.f1513e.t();
    }

    public AbstractC0336n j() {
        return this.f1507a.f1513e;
    }

    public void k() {
        this.f1507a.f1513e.z();
    }

    public Parcelable l() {
        return this.f1507a.f1513e.B();
    }

    public Fragment a(String str) {
        return this.f1507a.f1513e.b(str);
    }

    public void b(boolean z) {
        this.f1507a.f1513e.b(z);
    }

    public void a(Fragment fragment) {
        AbstractC0335m<?> abstractC0335m = this.f1507a;
        abstractC0335m.f1513e.a(abstractC0335m, abstractC0335m, fragment);
    }

    public boolean b(Menu menu) {
        return this.f1507a.f1513e.b(menu);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1507a.f1513e.onCreateView(view, str, context, attributeSet);
    }

    public boolean b(MenuItem menuItem) {
        return this.f1507a.f1513e.b(menuItem);
    }

    public void a(Parcelable parcelable) {
        AbstractC0335m<?> abstractC0335m = this.f1507a;
        if (abstractC0335m instanceof androidx.lifecycle.s) {
            abstractC0335m.f1513e.a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void a() {
        this.f1507a.f1513e.i();
    }

    public void a(boolean z) {
        this.f1507a.f1513e.a(z);
    }

    public void a(Configuration configuration) {
        this.f1507a.f1513e.a(configuration);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f1507a.f1513e.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f1507a.f1513e.a(menuItem);
    }

    public void a(Menu menu) {
        this.f1507a.f1513e.a(menu);
    }
}
