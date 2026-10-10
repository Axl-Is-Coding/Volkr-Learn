package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import io.rong.imkit.utils.FileTypeUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements androidx.appcompat.view.menu.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f547c;
    final e A;
    private final d B;
    private final c C;
    private final a D;
    private Runnable E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ListAdapter f549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    G f550f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    int s;
    private View t;
    private int u;
    private DataSetObserver v;
    private View w;
    private Drawable x;
    private AdapterView.OnItemClickListener y;
    private AdapterView.OnItemSelectedListener z;

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.g();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.c()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.j() || ListPopupWindow.this.J.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.F.removeCallbacks(listPopupWindow.A);
            ListPopupWindow.this.A.run();
        }
    }

    private class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.J) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.J.getWidth() && y >= 0 && y < ListPopupWindow.this.J.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.F.postDelayed(listPopupWindow.A, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.F.removeCallbacks(listPopupWindow2.A);
            return false;
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            G g = ListPopupWindow.this.f550f;
            if (g == null || !ViewCompat.B(g) || ListPopupWindow.this.f550f.getCount() <= ListPopupWindow.this.f550f.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f550f.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.s) {
                listPopupWindow.J.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f545a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f547c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f546b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    private int l() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        View view;
        int i2;
        if (this.f550f == null) {
            Context context = this.f548d;
            this.E = new J(this);
            this.f550f = a(context, !this.I);
            Drawable drawable = this.x;
            if (drawable != null) {
                this.f550f.setSelector(drawable);
            }
            this.f550f.setAdapter(this.f549e);
            this.f550f.setOnItemClickListener(this.y);
            this.f550f.setFocusable(true);
            this.f550f.setFocusableInTouchMode(true);
            this.f550f.setOnItemSelectedListener(new K(this));
            this.f550f.setOnScrollListener(this.C);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.z;
            if (onItemSelectedListener != null) {
                this.f550f.setOnItemSelectedListener(onItemSelectedListener);
            }
            G g = this.f550f;
            View view2 = this.t;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i3 = this.u;
                if (i3 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(g, layoutParams);
                } else if (i3 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.u);
                } else {
                    linearLayout.addView(g, layoutParams);
                    linearLayout.addView(view2);
                }
                int i4 = this.h;
                if (i4 >= 0) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i2 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i4, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = g;
            }
            this.J.setContentView(view);
        } else {
            View view3 = this.t;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            int i5 = rect.top;
            i = rect.bottom + i5;
            if (!this.l) {
                this.j = -i5;
            }
        } else {
            this.G.setEmpty();
            i = 0;
        }
        int iA = a(h(), this.j, this.J.getInputMethodMode() == 2);
        if (this.q || this.g == -1) {
            return iA + i;
        }
        int i6 = this.h;
        if (i6 == -2) {
            int i7 = this.f548d.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.G;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i6 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, FileTypeUtils.GIGABYTE);
        } else {
            int i8 = this.f548d.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.G;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect3.left + rect3.right), FileTypeUtils.GIGABYTE);
        }
        int iMeasureHeightOfChildrenCompat = this.f550f.measureHeightOfChildrenCompat(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iMeasureHeightOfChildrenCompat > 0) {
            measuredHeight += i + this.f550f.getPaddingTop() + this.f550f.getPaddingBottom();
        }
        return iMeasureHeightOfChildrenCompat + measuredHeight;
    }

    private void m() {
        View view = this.t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.v;
        if (dataSetObserver == null) {
            this.v = new b();
        } else {
            ListAdapter listAdapter2 = this.f549e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f549e = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.v);
        }
        G g = this.f550f;
        if (g != null) {
            g.setAdapter(this.f549e);
        }
    }

    public void b(int i) {
        this.j = i;
        this.l = true;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean c() {
        return this.J.isShowing();
    }

    public Drawable d() {
        return this.J.getBackground();
    }

    @Override // androidx.appcompat.view.menu.m
    public void dismiss() {
        this.J.dismiss();
        m();
        this.J.setContentView(null);
        this.f550f = null;
        this.F.removeCallbacks(this.A);
    }

    public int e() {
        if (this.l) {
            return this.j;
        }
        return 0;
    }

    public void f(int i) {
        this.p = i;
    }

    public void g(int i) {
        if (i < 0 && -2 != i && -1 != i) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.g = i;
    }

    public View h() {
        return this.w;
    }

    public void i(int i) {
        this.u = i;
    }

    public void j(int i) {
        G g = this.f550f;
        if (!c() || g == null) {
            return;
        }
        g.setListSelectionHidden(false);
        g.setSelection(i);
        if (g.getChoiceMode() != 0) {
            g.setItemChecked(i, true);
        }
    }

    public boolean k() {
        return this.I;
    }

    @Override // androidx.appcompat.view.menu.m
    public void show() {
        int iL = l();
        boolean zJ = j();
        androidx.core.widget.k.a(this.J, this.k);
        if (this.J.isShowing()) {
            if (ViewCompat.B(h())) {
                int width = this.h;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = h().getWidth();
                }
                int i = this.g;
                if (i == -1) {
                    if (!zJ) {
                        iL = -1;
                    }
                    if (zJ) {
                        this.J.setWidth(this.h == -1 ? -1 : 0);
                        this.J.setHeight(0);
                    } else {
                        this.J.setWidth(this.h == -1 ? -1 : 0);
                        this.J.setHeight(-1);
                    }
                } else if (i != -2) {
                    iL = i;
                }
                this.J.setOutsideTouchable((this.r || this.q) ? false : true);
                this.J.update(h(), this.i, this.j, width < 0 ? -1 : width, iL < 0 ? -1 : iL);
                return;
            }
            return;
        }
        int width2 = this.h;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = h().getWidth();
        }
        int i2 = this.g;
        if (i2 == -1) {
            iL = -1;
        } else if (i2 != -2) {
            iL = i2;
        }
        this.J.setWidth(width2);
        this.J.setHeight(iL);
        c(true);
        this.J.setOutsideTouchable((this.r || this.q) ? false : true);
        this.J.setTouchInterceptor(this.B);
        if (this.o) {
            androidx.core.widget.k.a(this.J, this.n);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f547c;
            if (method != null) {
                try {
                    method.invoke(this.J, this.H);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.J.setEpicenterBounds(this.H);
        }
        androidx.core.widget.k.a(this.J, h(), this.i, this.j, this.p);
        this.f550f.setSelection(-1);
        if (!this.I || this.f550f.isInTouchMode()) {
            g();
        }
        if (this.I) {
            return;
        }
        this.F.post(this.D);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    private void c(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.J.setIsClippedToScreen(z);
            return;
        }
        Method method = f545a;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void d(int i) {
        this.J.setAnimationStyle(i);
    }

    @Override // androidx.appcompat.view.menu.m
    public ListView f() {
        return this.f550f;
    }

    public void h(int i) {
        this.J.setInputMethodMode(i);
    }

    public int i() {
        return this.h;
    }

    public void k(int i) {
        this.h = i;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public void b(boolean z) {
        this.o = true;
        this.n = z;
    }

    public void e(int i) {
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            this.h = rect.left + rect.right + i;
            return;
        }
        k(i);
    }

    public void g() {
        G g = this.f550f;
        if (g != null) {
            g.setListSelectionHidden(true);
            g.requestLayout();
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.g = -2;
        this.h = -2;
        this.k = 1002;
        this.m = true;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = Integer.MAX_VALUE;
        this.u = 0;
        this.A = new e();
        this.B = new d();
        this.C = new c();
        this.D = new a();
        this.G = new Rect();
        this.f548d = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.j != 0) {
            this.l = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.J = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.J.setInputMethodMode(1);
    }

    public boolean j() {
        return this.J.getInputMethodMode() == 2;
    }

    public void a(boolean z) {
        this.I = z;
        this.J.setFocusable(z);
    }

    public void a(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public void a(View view) {
        this.w = view;
    }

    public int a() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.y = onItemClickListener;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    G a(Context context, boolean z) {
        return new G(context, z);
    }

    private int a(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f546b;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.J, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.J.getMaxAvailableHeight(view, i);
        }
        return this.J.getMaxAvailableHeight(view, i, z);
    }
}
