package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.L;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.C0316d;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CascadingMenuPopup extends i implements View.OnKeyListener, PopupWindow.OnDismissListener, MenuPresenter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f405b = R.layout.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f409f;
    private final boolean g;
    final Handler h;
    private View p;
    View q;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean x;
    private MenuPresenter.a y;
    ViewTreeObserver z;
    private final List<MenuBuilder> i = new ArrayList();
    final List<a> j = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener k = new c(this);
    private final View.OnAttachStateChangeListener l = new d(this);
    private final L m = new f(this);
    private int n = 0;
    private int o = 0;
    private boolean w = false;
    private int r = h();

    /* JADX INFO: Access modifiers changed from: private */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MenuBuilder f411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f412c;

        public a(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.f410a = menuPopupWindow;
            this.f411b = menuBuilder;
            this.f412c = i;
        }

        public ListView a() {
            return this.f410a.f();
        }
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.f406c = context;
        this.p = view;
        this.f408e = i;
        this.f409f = i2;
        this.g = z;
        Resources resources = context.getResources();
        this.f407d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    private int d(int i) {
        List<a> list = this.j;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        return this.r == 1 ? (iArr[0] + listViewA.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private MenuPopupWindow g() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f406c, null, this.f408e, this.f409f);
        menuPopupWindow.a(this.m);
        menuPopupWindow.a((AdapterView.OnItemClickListener) this);
        menuPopupWindow.a((PopupWindow.OnDismissListener) this);
        menuPopupWindow.a(this.p);
        menuPopupWindow.f(this.o);
        menuPopupWindow.a(true);
        menuPopupWindow.h(2);
        return menuPopupWindow;
    }

    private int h() {
        return ViewCompat.m(this.p) == 1 ? 0 : 1;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable a() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(MenuBuilder menuBuilder) {
        menuBuilder.a(this, this.f406c);
        if (c()) {
            d(menuBuilder);
        } else {
            this.i.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(boolean z) {
        this.w = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean c() {
        return this.j.size() > 0 && this.j.get(0).f410a.c();
    }

    @Override // androidx.appcompat.view.menu.i
    protected boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.j.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.f410a.c()) {
                    aVar.f410a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public ListView f() {
        if (this.j.isEmpty()) {
            return null;
        }
        return this.j.get(r0.size() - 1).a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.j.get(i);
            if (!aVar.f410a.c()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.f411b.a(false);
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
        this.y = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void show() {
        if (c()) {
            return;
        }
        Iterator<MenuBuilder> it = this.i.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
        this.i.clear();
        this.q = this.p;
        if (this.q != null) {
            boolean z = this.z == null;
            this.z = this.q.getViewTreeObserver();
            if (z) {
                this.z.addOnGlobalLayoutListener(this.k);
            }
            this.q.addOnAttachStateChangeListener(this.l);
        }
    }

    private int c(MenuBuilder menuBuilder) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.j.get(i).f411b) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(int i) {
        this.s = true;
        this.u = i;
    }

    private MenuItem a(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.i
    public void c(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.i
    public void c(boolean z) {
        this.x = z;
    }

    private View a(a aVar, MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemA = a(aVar.f411b, menuBuilder);
        if (menuItemA == null) {
            return null;
        }
        ListView listViewA = aVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            headersCount = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemA == menuAdapter.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private void d(MenuBuilder menuBuilder) {
        a aVar;
        View viewA;
        int i;
        int i2;
        int i3;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f406c);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, layoutInflaterFrom, this.g, f405b);
        if (!c() && this.w) {
            menuAdapter.setForceShowIcon(true);
        } else if (c()) {
            menuAdapter.setForceShowIcon(i.b(menuBuilder));
        }
        int iA = i.a(menuAdapter, null, this.f406c, this.f407d);
        MenuPopupWindow menuPopupWindowG = g();
        menuPopupWindowG.a((ListAdapter) menuAdapter);
        menuPopupWindowG.e(iA);
        menuPopupWindowG.f(this.o);
        if (this.j.size() > 0) {
            List<a> list = this.j;
            aVar = list.get(list.size() - 1);
            viewA = a(aVar, menuBuilder);
        } else {
            aVar = null;
            viewA = null;
        }
        if (viewA != null) {
            menuPopupWindowG.c(false);
            menuPopupWindowG.a((Object) null);
            int iD = d(iA);
            boolean z = iD == 1;
            this.r = iD;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindowG.a(viewA);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewA.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + viewA.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (!z) {
                    iA = viewA.getWidth();
                    i3 = i - iA;
                }
                i3 = i + iA;
            } else {
                if (z) {
                    iA = viewA.getWidth();
                    i3 = i + iA;
                }
                i3 = i - iA;
            }
            menuPopupWindowG.a(i3);
            menuPopupWindowG.b(true);
            menuPopupWindowG.b(i2);
        } else {
            if (this.s) {
                menuPopupWindowG.a(this.u);
            }
            if (this.t) {
                menuPopupWindowG.b(this.v);
            }
            menuPopupWindowG.a(e());
        }
        this.j.add(new a(menuPopupWindowG, menuBuilder, this.r));
        menuPopupWindowG.show();
        ListView listViewF = menuPopupWindowG.f();
        listViewF.setOnKeyListener(this);
        if (aVar == null && this.x && menuBuilder.h() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewF, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.h());
            listViewF.addHeaderView(frameLayout, null, false);
            menuPopupWindowG.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(boolean z) {
        Iterator<a> it = this.j.iterator();
        while (it.hasNext()) {
            i.a(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(SubMenuBuilder subMenuBuilder) {
        for (a aVar : this.j) {
            if (subMenuBuilder == aVar.f411b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        a((MenuBuilder) subMenuBuilder);
        MenuPresenter.a aVar2 = this.y;
        if (aVar2 != null) {
            aVar2.a(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z) {
        int iC = c(menuBuilder);
        if (iC < 0) {
            return;
        }
        int i = iC + 1;
        if (i < this.j.size()) {
            this.j.get(i).f411b.a(false);
        }
        a aVarRemove = this.j.remove(iC);
        aVarRemove.f411b.b(this);
        if (this.B) {
            aVarRemove.f410a.b((Object) null);
            aVarRemove.f410a.d(0);
        }
        aVarRemove.f410a.dismiss();
        int size = this.j.size();
        if (size > 0) {
            this.r = this.j.get(size - 1).f412c;
        } else {
            this.r = h();
        }
        if (size != 0) {
            if (z) {
                this.j.get(0).f411b.a(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.a aVar = this.y;
        if (aVar != null) {
            aVar.a(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.z.removeGlobalOnLayoutListener(this.k);
            }
            this.z = null;
        }
        this.q.removeOnAttachStateChangeListener(this.l);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = C0316d.a(i, ViewCompat.m(this.p));
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = C0316d.a(this.n, ViewCompat.m(this.p));
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }
}
