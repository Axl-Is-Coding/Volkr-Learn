package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class StandardMenuPopup extends i implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, MenuPresenter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f443b = R.layout.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MenuBuilder f445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MenuAdapter f446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f447f;
    private final int g;
    private final int h;
    private final int i;
    final MenuPopupWindow j;
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private MenuPresenter.a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean v;
    final ViewTreeObserver.OnGlobalLayoutListener k = new n(this);
    private final View.OnAttachStateChangeListener l = new o(this);
    private int u = 0;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.f444c = context;
        this.f445d = menuBuilder;
        this.f447f = z;
        this.f446e = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.f447f, f443b);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new MenuPopupWindow(this.f444c, null, this.h, this.i);
        menuBuilder.a(this, context);
    }

    private boolean g() {
        View view;
        if (c()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.j.a((PopupWindow.OnDismissListener) this);
        this.j.a((AdapterView.OnItemClickListener) this);
        this.j.a(true);
        View view2 = this.o;
        boolean z = this.q == null;
        this.q = view2.getViewTreeObserver();
        if (z) {
            this.q.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.j.a(view2);
        this.j.f(this.u);
        if (!this.s) {
            this.t = i.a(this.f446e, null, this.f444c, this.g);
            this.s = true;
        }
        this.j.e(this.t);
        this.j.h(2);
        this.j.a(e());
        this.j.show();
        ListView listViewF = this.j.f();
        listViewF.setOnKeyListener(this);
        if (this.v && this.f445d.h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f444c).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewF, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f445d.h());
            }
            frameLayout.setEnabled(false);
            listViewF.addHeaderView(frameLayout, null, false);
        }
        this.j.a((ListAdapter) this.f446e);
        this.j.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable a() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(int i) {
        this.u = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(boolean z) {
        this.f446e.setForceShowIcon(z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean c() {
        return !this.r && this.j.c();
    }

    @Override // androidx.appcompat.view.menu.m
    public void dismiss() {
        if (c()) {
            this.j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public ListView f() {
        return this.j.f();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.f445d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void show() {
        if (!g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(boolean z) {
        this.s = false;
        MenuAdapter menuAdapter = this.f446e;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(int i) {
        this.j.a(i);
    }

    @Override // androidx.appcompat.view.menu.i
    public void c(int i) {
        this.j.b(i);
    }

    @Override // androidx.appcompat.view.menu.i
    public void c(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f444c, subMenuBuilder, this.o, this.f447f, this.h, this.i);
            menuPopupHelper.setPresenterCallback(this.p);
            menuPopupHelper.a(i.b(subMenuBuilder));
            menuPopupHelper.a(this.m);
            this.m = null;
            this.f445d.a(false);
            int iA = this.j.a();
            int iE = this.j.e();
            if ((Gravity.getAbsoluteGravity(this.u, ViewCompat.m(this.n)) & 7) == 5) {
                iA += this.n.getWidth();
            }
            if (menuPopupHelper.a(iA, iE)) {
                MenuPresenter.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.f445d) {
            return;
        }
        dismiss();
        MenuPresenter.a aVar = this.p;
        if (aVar != null) {
            aVar.a(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(View view) {
        this.n = view;
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }
}
