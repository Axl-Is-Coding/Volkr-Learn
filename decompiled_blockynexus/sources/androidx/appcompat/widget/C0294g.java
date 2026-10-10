package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0314b;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
class C0294g extends BaseMenuPresenter implements AbstractC0314b.a {
    c A;
    private b B;
    final f C;
    int D;
    d k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private final SparseBooleanArray x;
    e y;
    a z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.g$a */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class a extends MenuPopupHelper {
        public a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).h()) {
                View view2 = C0294g.this.k;
                a(view2 == null ? (View) ((BaseMenuPresenter) C0294g.this).i : view2);
            }
            setPresenterCallback(C0294g.this.C);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void d() {
            C0294g c0294g = C0294g.this;
            c0294g.z = null;
            c0294g.D = 0;
            super.d();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.g$b */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.m a() {
            a aVar = C0294g.this.z;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: androidx.appcompat.widget.g$c */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f648a;

        public c(e eVar) {
            this.f648a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((BaseMenuPresenter) C0294g.this).f401c != null) {
                ((BaseMenuPresenter) C0294g.this).f401c.a();
            }
            View view = (View) ((BaseMenuPresenter) C0294g.this).i;
            if (view != null && view.getWindowToken() != null && this.f648a.f()) {
                C0294g.this.y = this.f648a;
            }
            C0294g.this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: androidx.appcompat.widget.g$d */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    class d extends AppCompatImageView implements ActionMenuView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float[] f650a;

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            this.f650a = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            na.a(this, getContentDescription());
            setOnTouchListener(new C0295h(this, this, C0294g.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0294g.this.j();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: androidx.appcompat.widget.g$e */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    class e extends MenuPopupHelper {
        public e(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, R.attr.actionOverflowMenuStyle);
            a(8388613);
            setPresenterCallback(C0294g.this.C);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void d() {
            if (((BaseMenuPresenter) C0294g.this).f401c != null) {
                ((BaseMenuPresenter) C0294g.this).f401c.close();
            }
            C0294g.this.y = null;
            super.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: androidx.appcompat.widget.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    @SuppressLint({"BanParcelableUsage"})
    static class C0005g implements Parcelable {
        public static final Parcelable.Creator<C0005g> CREATOR = new C0296i();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f653a;

        C0005g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f653a);
        }

        C0005g(Parcel parcel) {
            this.f653a = parcel.readInt();
        }
    }

    public C0294g(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.C = new f();
    }

    public boolean g() {
        return this.A != null || h();
    }

    public boolean h() {
        e eVar = this.y;
        return eVar != null && eVar.c();
    }

    public boolean i() {
        return this.n;
    }

    public boolean j() {
        MenuBuilder menuBuilder;
        if (!this.n || h() || (menuBuilder = this.f401c) == null || this.i == null || this.A != null || menuBuilder.j().isEmpty()) {
            return false;
        }
        this.A = new c(new e(this.f400b, this.f401c, this.k, true));
        ((View) this.i).post(this.A);
        super.a((SubMenuBuilder) null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void a(Context context, MenuBuilder menuBuilder) {
        super.a(context, menuBuilder);
        Resources resources = context.getResources();
        androidx.appcompat.d.a aVarA = androidx.appcompat.d.a.a(context);
        if (!this.o) {
            this.n = aVarA.g();
        }
        if (!this.u) {
            this.p = aVarA.b();
        }
        if (!this.s) {
            this.r = aVarA.c();
        }
        int measuredWidth = this.p;
        if (this.n) {
            if (this.k == null) {
                this.k = new d(this.f399a);
                if (this.m) {
                    this.k.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.q = measuredWidth;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public androidx.appcompat.view.menu.k b(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.i;
        androidx.appcompat.view.menu.k kVarB = super.b(viewGroup);
        if (kVar != kVarB) {
            ((ActionMenuView) kVarB).setPresenter(this);
        }
        return kVarB;
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void d(boolean z) {
        this.n = z;
        this.o = true;
    }

    public boolean e() {
        Object obj;
        c cVar = this.A;
        if (cVar != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        e eVar = this.y;
        if (eVar == null) {
            return false;
        }
        eVar.a();
        return true;
    }

    public boolean f() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.g$f */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class f implements MenuPresenter.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public boolean a(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            C0294g.this.D = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.a callback = C0294g.this.getCallback();
            if (callback != null) {
                return callback.a(menuBuilder);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public void a(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.m().a(false);
            }
            MenuPresenter.a callback = C0294g.this.getCallback();
            if (callback != null) {
                callback.a(menuBuilder, z);
            }
        }
    }

    public boolean c() {
        return e() | f();
    }

    public Drawable d() {
        d dVar = this.k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.m) {
            return this.l;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean b() {
        ArrayList<MenuItemImpl> arrayListN;
        int size;
        int i;
        int iMeasureChildForCells;
        int i2;
        boolean z;
        C0294g c0294g = this;
        MenuBuilder menuBuilder = c0294g.f401c;
        View view = null;
        int i3 = 0;
        if (menuBuilder != null) {
            arrayListN = menuBuilder.n();
            size = arrayListN.size();
        } else {
            arrayListN = null;
            size = 0;
        }
        int i4 = c0294g.r;
        int i5 = c0294g.q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0294g.i;
        int i6 = i4;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = arrayListN.get(i9);
            if (menuItemImpl.k()) {
                i7++;
            } else if (menuItemImpl.j()) {
                i8++;
            } else {
                z2 = true;
            }
            if (c0294g.v && menuItemImpl.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (c0294g.n && (z2 || i8 + i7 > i6)) {
            i6--;
        }
        int i10 = i6 - i7;
        SparseBooleanArray sparseBooleanArray = c0294g.x;
        sparseBooleanArray.clear();
        if (c0294g.t) {
            int i11 = c0294g.w;
            iMeasureChildForCells = i5 / i11;
            i = i11 + ((i5 % i11) / iMeasureChildForCells);
        } else {
            i = 0;
            iMeasureChildForCells = 0;
        }
        int i12 = i5;
        int i13 = 0;
        int i14 = 0;
        while (i13 < size) {
            MenuItemImpl menuItemImpl2 = arrayListN.get(i13);
            if (menuItemImpl2.k()) {
                View viewA = c0294g.a(menuItemImpl2, view, viewGroup);
                if (c0294g.t) {
                    iMeasureChildForCells -= ActionMenuView.measureChildForCells(viewA, i, iMeasureChildForCells, iMakeMeasureSpec, i3);
                } else {
                    viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewA.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i14 != 0) {
                    measuredWidth = i14;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                menuItemImpl2.d(z);
                i14 = measuredWidth;
                i2 = size;
            } else if (menuItemImpl2.j()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i12 > 0 && (!c0294g.t || iMeasureChildForCells > 0);
                if (z4) {
                    boolean z5 = z4;
                    i2 = size;
                    View viewA2 = c0294g.a(menuItemImpl2, null, viewGroup);
                    if (c0294g.t) {
                        int iMeasureChildForCells2 = ActionMenuView.measureChildForCells(viewA2, i, iMeasureChildForCells, iMakeMeasureSpec, 0);
                        iMeasureChildForCells -= iMeasureChildForCells2;
                        z5 = iMeasureChildForCells2 == 0 ? false : z5;
                    } else {
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z4 = z5 & (!c0294g.t ? i12 + i14 <= 0 : i12 < 0);
                } else {
                    i2 = size;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        MenuItemImpl menuItemImpl3 = arrayListN.get(i15);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.h()) {
                                i10++;
                            }
                            menuItemImpl3.d(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                menuItemImpl2.d(z4);
            } else {
                i2 = size;
                menuItemImpl2.d(false);
                i13++;
                size = i2;
                view = null;
                i3 = 0;
                c0294g = this;
            }
            i13++;
            size = i2;
            view = null;
            i3 = 0;
            c0294g = this;
        }
        return true;
    }

    public void a(Configuration configuration) {
        if (!this.s) {
            this.r = androidx.appcompat.d.a.a(this.f400b).c();
        }
        MenuBuilder menuBuilder = this.f401c;
        if (menuBuilder != null) {
            menuBuilder.b(true);
        }
    }

    public void a(Drawable drawable) {
        d dVar = this.k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.m = true;
            this.l = drawable;
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.f()) {
            actionView = super.a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void a(MenuItemImpl menuItemImpl, k.a aVar) {
        aVar.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean a(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.h();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void a(boolean z) {
        super.a(z);
        ((View) this.i).requestLayout();
        MenuBuilder menuBuilder = this.f401c;
        boolean z2 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> arrayListC = menuBuilder.c();
            int size = arrayListC.size();
            for (int i = 0; i < size; i++) {
                AbstractC0314b abstractC0314bA = arrayListC.get(i).a();
                if (abstractC0314bA != null) {
                    abstractC0314bA.a(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f401c;
        ArrayList<MenuItemImpl> arrayListJ = menuBuilder2 != null ? menuBuilder2.j() : null;
        if (this.n && arrayListJ != null) {
            int size2 = arrayListJ.size();
            if (size2 == 1) {
                z2 = !arrayListJ.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.k == null) {
                this.k = new d(this.f399a);
            }
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.k, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            d dVar = this.k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.k);
                }
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.n);
    }

    @Override // androidx.core.view.AbstractC0314b.a
    public void b(boolean z) {
        if (z) {
            super.a((SubMenuBuilder) null);
            return;
        }
        MenuBuilder menuBuilder = this.f401c;
        if (menuBuilder != null) {
            menuBuilder.a(false);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean a(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.t() != this.f401c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.t();
        }
        View viewA = a(subMenuBuilder2.getItem());
        if (viewA == null) {
            return false;
        }
        this.D = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.z = new a(this.f400b, subMenuBuilder, viewA);
        this.z.a(z);
        this.z.e();
        super.a(subMenuBuilder);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z) {
        c();
        super.a(menuBuilder, z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable a() {
        C0005g c0005g = new C0005g();
        c0005g.f653a = this.D;
        return c0005g;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof C0005g) && (i = ((C0005g) parcelable).f653a) > 0 && (menuItemFindItem = this.f401c.findItem(i)) != null) {
            a((SubMenuBuilder) menuItemFindItem.getSubMenu());
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.initialize(this.f401c);
    }
}
