package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class ScrollEventAdapter extends RecyclerView.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager2.e f2410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewPager2 f2411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f2412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayoutManager f2413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2415f;
    private a g = new a();
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f2417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2418c;

        a() {
        }

        void a() {
            this.f2416a = -1;
            this.f2417b = WheelView.DividerConfig.FILL;
            this.f2418c = 0;
        }
    }

    ScrollEventAdapter(ViewPager2 viewPager2) {
        this.f2411b = viewPager2;
        this.f2412c = this.f2411b.mRecyclerView;
        this.f2413d = (LinearLayoutManager) this.f2412c.getLayoutManager();
        k();
    }

    private void a(boolean z) {
        this.m = z;
        this.f2414e = z ? 4 : 1;
        int i = this.i;
        if (i != -1) {
            this.h = i;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = i();
        }
        b(1);
    }

    private int i() {
        return this.f2413d.findFirstVisibleItemPosition();
    }

    private boolean j() {
        int i = this.f2414e;
        return i == 1 || i == 4;
    }

    private void k() {
        this.f2414e = 0;
        this.f2415f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    private void l() {
        int top;
        a aVar = this.g;
        aVar.f2416a = this.f2413d.findFirstVisibleItemPosition();
        int i = aVar.f2416a;
        if (i == -1) {
            aVar.a();
            return;
        }
        View viewFindViewByPosition = this.f2413d.findViewByPosition(i);
        if (viewFindViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.f2413d.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.f2413d.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.f2413d.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.f2413d.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + viewFindViewByPosition.getWidth() + leftDecorationWidth;
        if (this.f2413d.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f2412c.getPaddingLeft();
            if (this.f2411b.isRtl()) {
                top = -top;
            }
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f2412c.getPaddingTop();
            width = height;
        }
        aVar.f2418c = -top;
        int i2 = aVar.f2418c;
        if (i2 >= 0) {
            aVar.f2417b = width == 0 ? WheelView.DividerConfig.FILL : i2 / width;
        } else {
            if (!new b(this.f2413d).a()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f2418c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    int b() {
        return this.f2415f;
    }

    boolean c() {
        return this.f2415f == 1;
    }

    boolean d() {
        return this.m;
    }

    boolean e() {
        return this.f2415f == 0;
    }

    void f() {
        this.f2414e = 4;
        a(true);
    }

    void g() {
        this.l = true;
    }

    void h() {
        if (!c() || this.m) {
            this.m = false;
            l();
            a aVar = this.g;
            if (aVar.f2418c != 0) {
                b(2);
                return;
            }
            int i = aVar.f2416a;
            if (i != this.h) {
                a(i);
            }
            b(0);
            k();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.f2414e == 1 && this.f2415f == 1) && i == 1) {
            a(false);
            return;
        }
        if (j() && i == 2) {
            if (this.k) {
                b(2);
                this.j = true;
                return;
            }
            return;
        }
        if (j() && i == 0) {
            l();
            if (this.k) {
                a aVar = this.g;
                if (aVar.f2418c == 0) {
                    int i2 = this.h;
                    int i3 = aVar.f2416a;
                    if (i2 != i3) {
                        a(i3);
                    }
                } else {
                    z = false;
                }
            } else {
                int i4 = this.g.f2416a;
                if (i4 != -1) {
                    a(i4, WheelView.DividerConfig.FILL, 0);
                }
            }
            if (z) {
                b(0);
                k();
            }
        }
        if (this.f2414e == 2 && i == 0 && this.l) {
            l();
            a aVar2 = this.g;
            if (aVar2.f2418c == 0) {
                int i5 = this.i;
                int i6 = aVar2.f2416a;
                if (i5 != i6) {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    a(i6);
                }
                b(0);
                k();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    @Override // androidx.recyclerview.widget.RecyclerView.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.k = r4
            r3.l()
            boolean r0 = r3.j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3f
            r3.j = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f2411b
            boolean r6 = r6.isRtl()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            androidx.viewpager2.widget.ScrollEventAdapter$a r5 = r3.g
            int r6 = r5.f2418c
            if (r6 == 0) goto L2f
            int r5 = r5.f2416a
            int r5 = r5 + r4
            goto L33
        L2f:
            androidx.viewpager2.widget.ScrollEventAdapter$a r5 = r3.g
            int r5 = r5.f2416a
        L33:
            r3.i = r5
            int r5 = r3.h
            int r6 = r3.i
            if (r5 == r6) goto L4d
            r3.a(r6)
            goto L4d
        L3f:
            int r5 = r3.f2414e
            if (r5 != 0) goto L4d
            androidx.viewpager2.widget.ScrollEventAdapter$a r5 = r3.g
            int r5 = r5.f2416a
            if (r5 != r1) goto L4a
            r5 = 0
        L4a:
            r3.a(r5)
        L4d:
            androidx.viewpager2.widget.ScrollEventAdapter$a r5 = r3.g
            int r5 = r5.f2416a
            if (r5 != r1) goto L54
            r5 = 0
        L54:
            androidx.viewpager2.widget.ScrollEventAdapter$a r6 = r3.g
            float r0 = r6.f2417b
            int r6 = r6.f2418c
            r3.a(r5, r0, r6)
            androidx.viewpager2.widget.ScrollEventAdapter$a r5 = r3.g
            int r5 = r5.f2416a
            int r6 = r3.i
            if (r5 == r6) goto L67
            if (r6 != r1) goto L77
        L67:
            androidx.viewpager2.widget.ScrollEventAdapter$a r5 = r3.g
            int r5 = r5.f2418c
            if (r5 != 0) goto L77
            int r5 = r3.f2415f
            if (r5 == r4) goto L77
            r3.b(r2)
            r3.k()
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    void setOnPageChangeCallback(ViewPager2.e eVar) {
        this.f2410a = eVar;
    }

    private void b(int i) {
        if ((this.f2414e == 3 && this.f2415f == 0) || this.f2415f == i) {
            return;
        }
        this.f2415f = i;
        ViewPager2.e eVar = this.f2410a;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    void a(int i, boolean z) {
        this.f2414e = z ? 2 : 3;
        this.m = false;
        boolean z2 = this.i != i;
        this.i = i;
        b(2);
        if (z2) {
            a(i);
        }
    }

    double a() {
        l();
        a aVar = this.g;
        double d2 = aVar.f2416a;
        double d3 = aVar.f2417b;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 + d3;
    }

    private void a(int i) {
        ViewPager2.e eVar = this.f2410a;
        if (eVar != null) {
            eVar.b(i);
        }
    }

    private void a(int i, float f2, int i2) {
        ViewPager2.e eVar = this.f2410a;
        if (eVar != null) {
            eVar.a(i, f2, i2);
        }
    }
}
