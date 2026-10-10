package androidx.appcompat.d;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: StandaloneActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends b implements MenuBuilder.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActionBarContextView f365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.a f366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference<View> f367f;
    private boolean g;
    private boolean h;
    private MenuBuilder i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f364c = context;
        this.f365d = actionBarContextView;
        this.f366e = aVar;
        this.i = new MenuBuilder(actionBarContextView.getContext()).c(1);
        this.i.setCallback(this);
        this.h = z;
    }

    @Override // androidx.appcompat.d.b
    public void a(CharSequence charSequence) {
        this.f365d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.d.b
    public void b(CharSequence charSequence) {
        this.f365d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.d.b
    public Menu c() {
        return this.i;
    }

    @Override // androidx.appcompat.d.b
    public MenuInflater d() {
        return new g(this.f365d.getContext());
    }

    @Override // androidx.appcompat.d.b
    public CharSequence e() {
        return this.f365d.getSubtitle();
    }

    @Override // androidx.appcompat.d.b
    public CharSequence g() {
        return this.f365d.getTitle();
    }

    @Override // androidx.appcompat.d.b
    public void i() {
        this.f366e.b(this, this.i);
    }

    @Override // androidx.appcompat.d.b
    public boolean j() {
        return this.f365d.isTitleOptional();
    }

    @Override // androidx.appcompat.d.b
    public void a(int i) {
        a((CharSequence) this.f364c.getString(i));
    }

    @Override // androidx.appcompat.d.b
    public void b(int i) {
        b(this.f364c.getString(i));
    }

    @Override // androidx.appcompat.d.b
    public void a(boolean z) {
        super.a(z);
        this.f365d.setTitleOptional(z);
    }

    @Override // androidx.appcompat.d.b
    public View b() {
        WeakReference<View> weakReference = this.f367f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.d.b
    public void a(View view) {
        this.f365d.setCustomView(view);
        this.f367f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.d.b
    public void a() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.f365d.sendAccessibilityEvent(32);
        this.f366e.a(this);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f366e.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public void a(MenuBuilder menuBuilder) {
        i();
        this.f365d.showOverflowMenu();
    }
}
