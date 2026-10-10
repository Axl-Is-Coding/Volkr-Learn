package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.b;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.s.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d[] f1896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    J f1897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    J f1898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1900f;
    private final C g;
    private BitSet j;
    private boolean o;
    private boolean p;
    private c q;
    private int r;
    private int[] w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1895a = -1;
    boolean h = false;
    boolean i = false;
    int k = -1;
    int l = Integer.MIN_VALUE;
    b m = new b();
    private int n = 2;
    private final Rect s = new Rect();
    private final a t = new a();
    private boolean u = false;
    private boolean v = true;
    private final Runnable x = new ca(this);

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        d f1901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1902f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void a(boolean z) {
            this.f1902f = z;
        }

        public final int f() {
            d dVar = this.f1901e;
            if (dVar == null) {
                return -1;
            }
            return dVar.f1925e;
        }

        public boolean h() {
            return this.f1902f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new ea();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int[] f1918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1919e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f1920f;
        List<b.a> g;
        boolean h;
        boolean i;
        boolean j;

        public c() {
        }

        void a() {
            this.f1918d = null;
            this.f1917c = 0;
            this.f1915a = -1;
            this.f1916b = -1;
        }

        void b() {
            this.f1918d = null;
            this.f1917c = 0;
            this.f1919e = 0;
            this.f1920f = null;
            this.g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1915a);
            parcel.writeInt(this.f1916b);
            parcel.writeInt(this.f1917c);
            if (this.f1917c > 0) {
                parcel.writeIntArray(this.f1918d);
            }
            parcel.writeInt(this.f1919e);
            if (this.f1919e > 0) {
                parcel.writeIntArray(this.f1920f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }

        c(Parcel parcel) {
            this.f1915a = parcel.readInt();
            this.f1916b = parcel.readInt();
            this.f1917c = parcel.readInt();
            int i = this.f1917c;
            if (i > 0) {
                this.f1918d = new int[i];
                parcel.readIntArray(this.f1918d);
            }
            this.f1919e = parcel.readInt();
            int i2 = this.f1919e;
            if (i2 > 0) {
                this.f1920f = new int[i2];
                parcel.readIntArray(this.f1920f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(b.a.class.getClassLoader());
        }

        public c(c cVar) {
            this.f1917c = cVar.f1917c;
            this.f1915a = cVar.f1915a;
            this.f1916b = cVar.f1916b;
            this.f1918d = cVar.f1918d;
            this.f1919e = cVar.f1919e;
            this.f1920f = cVar.f1920f;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.g = cVar.g;
        }
    }

    class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<View> f1921a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1922b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1923c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1924d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f1925e;

        d(int i) {
            this.f1925e = i;
        }

        int a(int i) {
            int i2 = this.f1923c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1921a.size() == 0) {
                return i;
            }
            a();
            return this.f1923c;
        }

        int b(int i) {
            int i2 = this.f1922b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1921a.size() == 0) {
                return i;
            }
            b();
            return this.f1922b;
        }

        void c(View view) {
            LayoutParams layoutParamsB = b(view);
            layoutParamsB.f1901e = this;
            this.f1921a.add(0, view);
            this.f1922b = Integer.MIN_VALUE;
            if (this.f1921a.size() == 1) {
                this.f1923c = Integer.MIN_VALUE;
            }
            if (layoutParamsB.c() || layoutParamsB.b()) {
                this.f1924d += StaggeredGridLayoutManager.this.f1897c.b(view);
            }
        }

        void d(int i) {
            this.f1922b = i;
            this.f1923c = i;
        }

        public int e() {
            return StaggeredGridLayoutManager.this.h ? b(this.f1921a.size() - 1, -1, false) : b(0, this.f1921a.size(), false);
        }

        public int f() {
            return StaggeredGridLayoutManager.this.h ? a(0, this.f1921a.size(), true) : a(this.f1921a.size() - 1, -1, true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.h ? b(0, this.f1921a.size(), false) : b(this.f1921a.size() - 1, -1, false);
        }

        public int h() {
            return this.f1924d;
        }

        int i() {
            int i = this.f1923c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.f1923c;
        }

        int j() {
            int i = this.f1922b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            b();
            return this.f1922b;
        }

        void k() {
            this.f1922b = Integer.MIN_VALUE;
            this.f1923c = Integer.MIN_VALUE;
        }

        void l() {
            int size = this.f1921a.size();
            View viewRemove = this.f1921a.remove(size - 1);
            LayoutParams layoutParamsB = b(viewRemove);
            layoutParamsB.f1901e = null;
            if (layoutParamsB.c() || layoutParamsB.b()) {
                this.f1924d -= StaggeredGridLayoutManager.this.f1897c.b(viewRemove);
            }
            if (size == 1) {
                this.f1922b = Integer.MIN_VALUE;
            }
            this.f1923c = Integer.MIN_VALUE;
        }

        void m() {
            View viewRemove = this.f1921a.remove(0);
            LayoutParams layoutParamsB = b(viewRemove);
            layoutParamsB.f1901e = null;
            if (this.f1921a.size() == 0) {
                this.f1923c = Integer.MIN_VALUE;
            }
            if (layoutParamsB.c() || layoutParamsB.b()) {
                this.f1924d -= StaggeredGridLayoutManager.this.f1897c.b(viewRemove);
            }
            this.f1922b = Integer.MIN_VALUE;
        }

        public int d() {
            return StaggeredGridLayoutManager.this.h ? a(this.f1921a.size() - 1, -1, true) : a(0, this.f1921a.size(), true);
        }

        void a() {
            b.a aVarC;
            ArrayList<View> arrayList = this.f1921a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParamsB = b(view);
            this.f1923c = StaggeredGridLayoutManager.this.f1897c.a(view);
            if (layoutParamsB.f1902f && (aVarC = StaggeredGridLayoutManager.this.m.c(layoutParamsB.a())) != null && aVarC.f1912b == 1) {
                this.f1923c += aVarC.b(this.f1925e);
            }
        }

        void b() {
            b.a aVarC;
            View view = this.f1921a.get(0);
            LayoutParams layoutParamsB = b(view);
            this.f1922b = StaggeredGridLayoutManager.this.f1897c.d(view);
            if (layoutParamsB.f1902f && (aVarC = StaggeredGridLayoutManager.this.m.c(layoutParamsB.a())) != null && aVarC.f1912b == -1) {
                this.f1922b -= aVarC.b(this.f1925e);
            }
        }

        void c() {
            this.f1921a.clear();
            k();
            this.f1924d = 0;
        }

        void c(int i) {
            int i2 = this.f1922b;
            if (i2 != Integer.MIN_VALUE) {
                this.f1922b = i2 + i;
            }
            int i3 = this.f1923c;
            if (i3 != Integer.MIN_VALUE) {
                this.f1923c = i3 + i;
            }
        }

        void a(View view) {
            LayoutParams layoutParamsB = b(view);
            layoutParamsB.f1901e = this;
            this.f1921a.add(view);
            this.f1923c = Integer.MIN_VALUE;
            if (this.f1921a.size() == 1) {
                this.f1922b = Integer.MIN_VALUE;
            }
            if (layoutParamsB.c() || layoutParamsB.b()) {
                this.f1924d += StaggeredGridLayoutManager.this.f1897c.b(view);
            }
        }

        LayoutParams b(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int b(int i, int i2, boolean z) {
            return a(i, i2, z, true, false);
        }

        void a(boolean z, int i) {
            int iB;
            if (z) {
                iB = a(Integer.MIN_VALUE);
            } else {
                iB = b(Integer.MIN_VALUE);
            }
            c();
            if (iB == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iB >= StaggeredGridLayoutManager.this.f1897c.b()) {
                if (z || iB <= StaggeredGridLayoutManager.this.f1897c.f()) {
                    if (i != Integer.MIN_VALUE) {
                        iB += i;
                    }
                    this.f1923c = iB;
                    this.f1922b = iB;
                }
            }
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iF = StaggeredGridLayoutManager.this.f1897c.f();
            int iB = StaggeredGridLayoutManager.this.f1897c.b();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f1921a.get(i);
                int iD = StaggeredGridLayoutManager.this.f1897c.d(view);
                int iA = StaggeredGridLayoutManager.this.f1897c.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iD >= iB : iD > iB;
                if (!z3 ? iA > iF : iA >= iF) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iD >= iF && iA <= iB) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (iD < iF || iA > iB) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f1921a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f1921a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.h && staggeredGridLayoutManager.getPosition(view2) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.h && staggeredGridLayoutManager2.getPosition(view2) >= i) || !view2.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f1921a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f1921a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.h && staggeredGridLayoutManager3.getPosition(view3) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.h && staggeredGridLayoutManager4.getPosition(view3) <= i) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b properties = RecyclerView.i.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f1858a);
        b(properties.f1859b);
        setReverseLayout(properties.f1860c);
        this.g = new C();
        j();
    }

    private boolean a(d dVar) {
        if (this.i) {
            if (dVar.i() < this.f1897c.b()) {
                ArrayList<View> arrayList = dVar.f1921a;
                return !dVar.b(arrayList.get(arrayList.size() - 1)).f1902f;
            }
        } else if (dVar.j() > this.f1897c.f()) {
            return !dVar.b(dVar.f1921a.get(0)).f1902f;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return X.a(tVar, this.f1897c, b(!this.v), a(!this.v), this, this.v);
    }

    private int computeScrollOffset(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return X.a(tVar, this.f1897c, b(!this.v), a(!this.v), this, this.v, this.i);
    }

    private int computeScrollRange(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return X.b(tVar, this.f1897c, b(!this.v), a(!this.v), this, this.v);
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f1899e == 1) ? 1 : Integer.MIN_VALUE : this.f1899e == 0 ? 1 : Integer.MIN_VALUE : this.f1899e == 1 ? -1 : Integer.MIN_VALUE : this.f1899e == 0 ? -1 : Integer.MIN_VALUE : (this.f1899e != 1 && isLayoutRTL()) ? -1 : 1 : (this.f1899e != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private b.a e(int i) {
        b.a aVar = new b.a();
        aVar.f1913c = new int[this.f1895a];
        for (int i2 = 0; i2 < this.f1895a; i2++) {
            aVar.f1913c[i2] = i - this.f1896b[i2].a(i);
        }
        return aVar;
    }

    private b.a f(int i) {
        b.a aVar = new b.a();
        aVar.f1913c = new int[this.f1895a];
        for (int i2 = 0; i2 < this.f1895a; i2++) {
            aVar.f1913c[i2] = this.f1896b[i2].b(i) - i;
        }
        return aVar;
    }

    private void j() {
        this.f1897c = J.a(this, this.f1899e);
        this.f1898d = J.a(this, 1 - this.f1899e);
    }

    private void k() {
        if (this.f1898d.d() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float fMax = WheelView.DividerConfig.FILL;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float fB = this.f1898d.b(childAt);
            if (fB >= fMax) {
                if (((LayoutParams) childAt.getLayoutParams()).h()) {
                    fB = (fB * 1.0f) / this.f1895a;
                }
                fMax = Math.max(fMax, fB);
            }
        }
        int i2 = this.f1900f;
        int iRound = Math.round(fMax * this.f1895a);
        if (this.f1898d.d() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f1898d.g());
        }
        c(iRound);
        if (this.f1900f == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.f1902f) {
                if (isLayoutRTL() && this.f1899e == 1) {
                    int i4 = this.f1895a;
                    int i5 = layoutParams.f1901e.f1925e;
                    childAt2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.f1900f) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.f1901e.f1925e;
                    int i7 = this.f1900f * i6;
                    int i8 = i6 * i2;
                    if (this.f1899e == 1) {
                        childAt2.offsetLeftAndRight(i7 - i8);
                    } else {
                        childAt2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    private int l(int i) {
        int iB = this.f1896b[0].b(i);
        for (int i2 = 1; i2 < this.f1895a; i2++) {
            int iB2 = this.f1896b[i2].b(i);
            if (iB2 < iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private boolean m(int i) {
        if (this.f1899e == 0) {
            return (i == -1) != this.i;
        }
        return ((i == -1) == this.i) == isLayoutRTL();
    }

    private void n(int i) {
        C c2 = this.g;
        c2.f1784e = i;
        c2.f1783d = this.i != (i == -1) ? -1 : 1;
    }

    private void resolveShouldLayoutReverse() {
        if (this.f1899e == 1 || !isLayoutRTL()) {
            this.i = this.h;
        } else {
            this.i = !this.h;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void b(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.f1895a) {
            i();
            this.f1895a = i;
            this.j = new BitSet(this.f1895a);
            this.f1896b = new d[this.f1895a];
            for (int i2 = 0; i2 < this.f1895a; i2++) {
                this.f1896b[i2] = new d(i2);
            }
            requestLayout();
        }
    }

    boolean c() {
        int iE;
        int iF;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.i) {
            iE = f();
            iF = e();
        } else {
            iE = e();
            iF = f();
        }
        if (iE == 0 && h() != null) {
            this.m.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.u) {
            return false;
        }
        int i = this.i ? -1 : 1;
        int i2 = iF + 1;
        b.a aVarA = this.m.a(iE, i2, i, true);
        if (aVarA == null) {
            this.u = false;
            this.m.b(i2);
            return false;
        }
        b.a aVarA2 = this.m.a(iE, aVarA.f1911a, i * (-1), true);
        if (aVarA2 == null) {
            this.m.b(aVarA.f1911a);
        } else {
            this.m.b(aVarA2.f1911a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollHorizontally() {
        return this.f1899e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollVertically() {
        return this.f1899e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        int iA;
        int iB;
        if (this.f1899e != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        a(i, tVar);
        int[] iArr = this.w;
        if (iArr == null || iArr.length < this.f1895a) {
            this.w = new int[this.f1895a];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1895a; i4++) {
            C c2 = this.g;
            if (c2.f1783d == -1) {
                iA = c2.f1785f;
                iB = this.f1896b[i4].b(iA);
            } else {
                iA = this.f1896b[i4].a(c2.g);
                iB = this.g.g;
            }
            int i5 = iA - iB;
            if (i5 >= 0) {
                this.w[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.w, 0, i3);
        for (int i6 = 0; i6 < i3 && this.g.a(tVar); i6++) {
            aVar.a(this.g.f1782c, this.w[i6]);
            C c3 = this.g;
            c3.f1782c += c3.f1783d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollExtent(RecyclerView.t tVar) {
        return computeScrollExtent(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollOffset(RecyclerView.t tVar) {
        return computeScrollOffset(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollRange(RecyclerView.t tVar) {
        return computeScrollRange(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s.b
    public PointF computeScrollVectorForPosition(int i) {
        int iD = d(i);
        PointF pointF = new PointF();
        if (iD == 0) {
            return null;
        }
        if (this.f1899e == 0) {
            pointF.x = iD;
            pointF.y = WheelView.DividerConfig.FILL;
        } else {
            pointF.x = WheelView.DividerConfig.FILL;
            pointF.y = iD;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollExtent(RecyclerView.t tVar) {
        return computeScrollExtent(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollOffset(RecyclerView.t tVar) {
        return computeScrollOffset(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollRange(RecyclerView.t tVar) {
        return computeScrollRange(tVar);
    }

    int d() {
        View viewA = this.i ? a(true) : b(true);
        if (viewA == null) {
            return -1;
        }
        return getPosition(viewA);
    }

    public int g() {
        return this.f1895a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.f1899e == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getColumnCountForAccessibility(RecyclerView.o oVar, RecyclerView.t tVar) {
        return this.f1899e == 1 ? this.f1895a : super.getColumnCountForAccessibility(oVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getRowCountForAccessibility(RecyclerView.o oVar, RecyclerView.t tVar) {
        return this.f1899e == 0 ? this.f1895a : super.getRowCountForAccessibility(oVar, tVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View h() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f1895a
            r2.<init>(r3)
            int r3 = r12.f1895a
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f1899e
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.i
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f1901e
            int r9 = r9.f1925e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f1901e
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f1901e
            int r9 = r9.f1925e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f1902f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.i
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.J r10 = r12.f1897c
            int r10 = r10.a(r7)
            androidx.recyclerview.widget.J r11 = r12.f1897c
            int r11 = r11.a(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.J r10 = r12.f1897c
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.J r11 = r12.f1897c
            int r11 = r11.d(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r8 = r8.f1901e
            int r8 = r8.f1925e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r9.f1901e
            int r9 = r9.f1925e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h():android.view.View");
    }

    public void i() {
        this.m.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f1895a; i2++) {
            this.f1896b[i2].c(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f1895a; i2++) {
            this.f1896b[i2].c(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.onDetachedFromWindow(recyclerView, oVar);
        removeCallbacks(this.x);
        for (int i = 0; i < this.f1895a; i++) {
            this.f1896b[i].c();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View onFocusSearchFailed(View view, int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        View viewFindContainingItemView;
        View viewA;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
        boolean z = layoutParams.f1902f;
        d dVar = layoutParams.f1901e;
        int iF = iConvertFocusDirectionToLayoutDirection == 1 ? f() : e();
        b(iF, tVar);
        n(iConvertFocusDirectionToLayoutDirection);
        C c2 = this.g;
        c2.f1782c = c2.f1783d + iF;
        c2.f1781b = (int) (this.f1897c.g() * 0.33333334f);
        C c3 = this.g;
        c3.h = true;
        c3.f1780a = false;
        a(oVar, c3, tVar);
        this.o = this.i;
        if (!z && (viewA = dVar.a(iF, iConvertFocusDirectionToLayoutDirection)) != null && viewA != viewFindContainingItemView) {
            return viewA;
        }
        if (m(iConvertFocusDirectionToLayoutDirection)) {
            for (int i2 = this.f1895a - 1; i2 >= 0; i2--) {
                View viewA2 = this.f1896b[i2].a(iF, iConvertFocusDirectionToLayoutDirection);
                if (viewA2 != null && viewA2 != viewFindContainingItemView) {
                    return viewA2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.f1895a; i3++) {
                View viewA3 = this.f1896b[i3].a(iF, iConvertFocusDirectionToLayoutDirection);
                if (viewA3 != null && viewA3 != viewFindContainingItemView) {
                    return viewA3;
                }
            }
        }
        boolean z2 = (this.h ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            View viewFindViewByPosition = findViewByPosition(z2 ? dVar.d() : dVar.f());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (m(iConvertFocusDirectionToLayoutDirection)) {
            for (int i4 = this.f1895a - 1; i4 >= 0; i4--) {
                if (i4 != dVar.f1925e) {
                    View viewFindViewByPosition2 = findViewByPosition(z2 ? this.f1896b[i4].d() : this.f1896b[i4].f());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f1895a; i5++) {
                View viewFindViewByPosition3 = findViewByPosition(z2 ? this.f1896b[i5].d() : this.f1896b[i5].f());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewB = b(false);
            View viewA = a(false);
            if (viewB == null || viewA == null) {
                return;
            }
            int position = getPosition(viewB);
            int position2 = getPosition(viewA);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.o oVar, RecyclerView.t tVar, View view, androidx.core.view.accessibility.b bVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, bVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f1899e == 0) {
            bVar.b(b.c.a(layoutParams2.f(), layoutParams2.f1902f ? this.f1895a : 1, -1, -1, false, false));
        } else {
            bVar.b(b.c.a(-1, -1, layoutParams2.f(), layoutParams2.f1902f ? this.f1895a : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        a(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsChanged(RecyclerView recyclerView) {
        this.m.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        a(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        a(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        a(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutChildren(RecyclerView.o oVar, RecyclerView.t tVar) {
        c(oVar, tVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutCompleted(RecyclerView.t tVar) {
        super.onLayoutCompleted(tVar);
        this.k = -1;
        this.l = Integer.MIN_VALUE;
        this.q = null;
        this.t.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof c) {
            this.q = (c) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable onSaveInstanceState() {
        int iB;
        int iF;
        int[] iArr;
        c cVar = this.q;
        if (cVar != null) {
            return new c(cVar);
        }
        c cVar2 = new c();
        cVar2.h = this.h;
        cVar2.i = this.o;
        cVar2.j = this.p;
        b bVar = this.m;
        if (bVar == null || (iArr = bVar.f1909a) == null) {
            cVar2.f1919e = 0;
        } else {
            cVar2.f1920f = iArr;
            cVar2.f1919e = cVar2.f1920f.length;
            cVar2.g = bVar.f1910b;
        }
        if (getChildCount() > 0) {
            cVar2.f1915a = this.o ? f() : e();
            cVar2.f1916b = d();
            int i = this.f1895a;
            cVar2.f1917c = i;
            cVar2.f1918d = new int[i];
            for (int i2 = 0; i2 < this.f1895a; i2++) {
                if (this.o) {
                    iB = this.f1896b[i2].a(Integer.MIN_VALUE);
                    if (iB != Integer.MIN_VALUE) {
                        iF = this.f1897c.b();
                        iB -= iF;
                    }
                } else {
                    iB = this.f1896b[i2].b(Integer.MIN_VALUE);
                    if (iB != Integer.MIN_VALUE) {
                        iF = this.f1897c.f();
                        iB -= iF;
                    }
                }
                cVar2.f1918d[i2] = iB;
            }
        } else {
            cVar2.f1915a = -1;
            cVar2.f1916b = -1;
            cVar2.f1917c = 0;
        }
        return cVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            c();
        }
    }

    int scrollBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i, tVar);
        int iA = a(oVar, this.g, tVar);
        if (this.g.f1781b >= iA) {
            i = i < 0 ? -iA : iA;
        }
        this.f1897c.a(-i);
        this.o = this.i;
        C c2 = this.g;
        c2.f1781b = 0;
        a(oVar, c2);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollHorizontallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        return scrollBy(i, oVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void scrollToPosition(int i) {
        c cVar = this.q;
        if (cVar != null && cVar.f1915a != i) {
            cVar.a();
        }
        this.k = i;
        this.l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollVerticallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        return scrollBy(i, oVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f1899e == 1) {
            iChooseSize2 = RecyclerView.i.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = RecyclerView.i.chooseSize(i, (this.f1900f * this.f1895a) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.i.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = RecyclerView.i.chooseSize(i2, (this.f1900f * this.f1895a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.f1899e) {
            return;
        }
        this.f1899e = i;
        J j = this.f1897c;
        this.f1897c = this.f1898d;
        this.f1898d = j;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        c cVar = this.q;
        if (cVar != null && cVar.h != z) {
            cVar.h = z;
        }
        this.h = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        E e2 = new E(recyclerView.getContext());
        e2.setTargetPosition(i);
        startSmoothScroll(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f1909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<a> f1910b;

        b() {
        }

        private void c(int i, int i2) {
            List<a> list = this.f1910b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1910b.get(size);
                int i3 = aVar.f1911a;
                if (i3 >= i) {
                    aVar.f1911a = i3 + i2;
                }
            }
        }

        private int g(int i) {
            if (this.f1910b == null) {
                return -1;
            }
            a aVarC = c(i);
            if (aVarC != null) {
                this.f1910b.remove(aVarC);
            }
            int size = this.f1910b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f1910b.get(i2).f1911a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = this.f1910b.get(i2);
            this.f1910b.remove(i2);
            return aVar.f1911a;
        }

        void a(int i, d dVar) {
            a(i);
            this.f1909a[i] = dVar.f1925e;
        }

        int b(int i) {
            List<a> list = this.f1910b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1910b.get(size).f1911a >= i) {
                        this.f1910b.remove(size);
                    }
                }
            }
            return e(i);
        }

        int d(int i) {
            int[] iArr = this.f1909a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int e(int i) {
            int[] iArr = this.f1909a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int iG = g(i);
            if (iG == -1) {
                int[] iArr2 = this.f1909a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f1909a.length;
            }
            int i2 = iG + 1;
            Arrays.fill(this.f1909a, i, i2, -1);
            return i2;
        }

        int f(int i) {
            int length = this.f1909a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        private void d(int i, int i2) {
            List<a> list = this.f1910b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1910b.get(size);
                int i4 = aVar.f1911a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f1910b.remove(size);
                    } else {
                        aVar.f1911a = i4 - i2;
                    }
                }
            }
        }

        void a(int i) {
            int[] iArr = this.f1909a;
            if (iArr == null) {
                this.f1909a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f1909a, -1);
            } else if (i >= iArr.length) {
                this.f1909a = new int[f(i)];
                System.arraycopy(iArr, 0, this.f1909a, 0, iArr.length);
                int[] iArr2 = this.f1909a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        public a c(int i) {
            List<a> list = this.f1910b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1910b.get(size);
                if (aVar.f1911a == i) {
                    return aVar;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new da();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f1911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f1912b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int[] f1913c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f1914d;

            a(Parcel parcel) {
                this.f1911a = parcel.readInt();
                this.f1912b = parcel.readInt();
                this.f1914d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    this.f1913c = new int[i];
                    parcel.readIntArray(this.f1913c);
                }
            }

            int b(int i) {
                int[] iArr = this.f1913c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1911a + ", mGapDir=" + this.f1912b + ", mHasUnwantedGapAfter=" + this.f1914d + ", mGapPerSpan=" + Arrays.toString(this.f1913c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1911a);
                parcel.writeInt(this.f1912b);
                parcel.writeInt(this.f1914d ? 1 : 0);
                int[] iArr = this.f1913c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1913c);
                }
            }

            a() {
            }
        }

        void b(int i, int i2) {
            int[] iArr = this.f1909a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.f1909a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f1909a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            d(i, i2);
        }

        void a() {
            int[] iArr = this.f1909a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1910b = null;
        }

        void a(int i, int i2) {
            int[] iArr = this.f1909a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.f1909a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f1909a, i, i3, -1);
            c(i, i2);
        }

        public void a(a aVar) {
            if (this.f1910b == null) {
                this.f1910b = new ArrayList();
            }
            int size = this.f1910b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f1910b.get(i);
                if (aVar2.f1911a == aVar.f1911a) {
                    this.f1910b.remove(i);
                }
                if (aVar2.f1911a >= aVar.f1911a) {
                    this.f1910b.add(i, aVar);
                    return;
                }
            }
            this.f1910b.add(aVar);
        }

        public a a(int i, int i2, int i3, boolean z) {
            List<a> list = this.f1910b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1910b.get(i4);
                int i5 = aVar.f1911a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.f1912b == i3 || (z && aVar.f1914d))) {
                    return aVar;
                }
            }
            return null;
        }
    }

    private int g(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    private int i(int i) {
        int iA = this.f1896b[0].a(i);
        for (int i2 = 1; i2 < this.f1895a; i2++) {
            int iA2 = this.f1896b[i2].a(i);
            if (iA2 > iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1905c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1906d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1907e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f1908f;

        a() {
            b();
        }

        void a(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f1908f;
            if (iArr == null || iArr.length < length) {
                this.f1908f = new int[StaggeredGridLayoutManager.this.f1896b.length];
            }
            for (int i = 0; i < length; i++) {
                this.f1908f[i] = dVarArr[i].b(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.f1903a = -1;
            this.f1904b = Integer.MIN_VALUE;
            this.f1905c = false;
            this.f1906d = false;
            this.f1907e = false;
            int[] iArr = this.f1908f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void a() {
            this.f1904b = this.f1905c ? StaggeredGridLayoutManager.this.f1897c.b() : StaggeredGridLayoutManager.this.f1897c.f();
        }

        void a(int i) {
            if (this.f1905c) {
                this.f1904b = StaggeredGridLayoutManager.this.f1897c.b() - i;
            } else {
                this.f1904b = StaggeredGridLayoutManager.this.f1897c.f() + i;
            }
        }
    }

    private int d(int i) {
        if (getChildCount() == 0) {
            return this.i ? 1 : -1;
        }
        return (i < e()) != this.i ? -1 : 1;
    }

    private int j(int i) {
        int iB = this.f1896b[0].b(i);
        for (int i2 = 1; i2 < this.f1895a; i2++) {
            int iB2 = this.f1896b[i2].b(i);
            if (iB2 > iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    int e() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    int f() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public void a(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.n) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.n = i;
        requestLayout();
    }

    void b(RecyclerView.t tVar, a aVar) {
        if (a(tVar, aVar) || c(tVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1903a = 0;
    }

    public int[] b(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f1895a];
        } else if (iArr.length < this.f1895a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f1895a + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f1895a; i++) {
            iArr[i] = this.f1896b[i].g();
        }
        return iArr;
    }

    private void a(a aVar) {
        int iF;
        c cVar = this.q;
        int i = cVar.f1917c;
        if (i > 0) {
            if (i == this.f1895a) {
                for (int i2 = 0; i2 < this.f1895a; i2++) {
                    this.f1896b[i2].c();
                    c cVar2 = this.q;
                    int i3 = cVar2.f1918d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        if (cVar2.i) {
                            iF = this.f1897c.b();
                        } else {
                            iF = this.f1897c.f();
                        }
                        i3 += iF;
                    }
                    this.f1896b[i2].d(i3);
                }
            } else {
                cVar.b();
                c cVar3 = this.q;
                cVar3.f1915a = cVar3.f1916b;
            }
        }
        c cVar4 = this.q;
        this.p = cVar4.j;
        setReverseLayout(cVar4.h);
        resolveShouldLayoutReverse();
        c cVar5 = this.q;
        int i4 = cVar5.f1915a;
        if (i4 != -1) {
            this.k = i4;
            aVar.f1905c = cVar5.i;
        } else {
            aVar.f1905c = this.i;
        }
        c cVar6 = this.q;
        if (cVar6.f1919e > 1) {
            b bVar = this.m;
            bVar.f1909a = cVar6.f1920f;
            bVar.f1910b = cVar6.g;
        }
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.f1899e = i2;
        b(i);
        this.g = new C();
        j();
    }

    private int h(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    View b(boolean z) {
        int iF = this.f1897c.f();
        int iB = this.f1897c.b();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int iD = this.f1897c.d(childAt);
            if (this.f1897c.a(childAt) > iF && iD < iB) {
                if (iD >= iF || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(androidx.recyclerview.widget.RecyclerView.o r9, androidx.recyclerview.widget.RecyclerView.t r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$t, boolean):void");
    }

    private int k(int i) {
        int iA = this.f1896b[0].a(i);
        for (int i2 = 1; i2 < this.f1895a; i2++) {
            int iA2 = this.f1896b[i2].a(i);
            if (iA2 < iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    private void b(RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int iF;
        int iL = l(Integer.MAX_VALUE);
        if (iL != Integer.MAX_VALUE && (iF = iL - this.f1897c.f()) > 0) {
            int iScrollBy = iF - scrollBy(iF, oVar, tVar);
            if (!z || iScrollBy <= 0) {
                return;
            }
            this.f1897c.a(-iScrollBy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.t r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.C r0 = r4.g
            r1 = 0
            r0.f1781b = r1
            r0.f1782c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.b()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.i
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.J r5 = r4.f1897c
            int r5 = r5.g()
            goto L2f
        L25:
            androidx.recyclerview.widget.J r5 = r4.f1897c
            int r5 = r5.g()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.C r0 = r4.g
            androidx.recyclerview.widget.J r3 = r4.f1897c
            int r3 = r3.f()
            int r3 = r3 - r6
            r0.f1785f = r3
            androidx.recyclerview.widget.C r6 = r4.g
            androidx.recyclerview.widget.J r0 = r4.f1897c
            int r0 = r0.b()
            int r0 = r0 + r5
            r6.g = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.C r0 = r4.g
            androidx.recyclerview.widget.J r3 = r4.f1897c
            int r3 = r3.a()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.C r5 = r4.g
            int r6 = -r6
            r5.f1785f = r6
        L5d:
            androidx.recyclerview.widget.C r5 = r4.g
            r5.h = r1
            r5.f1780a = r2
            androidx.recyclerview.widget.J r6 = r4.f1897c
            int r6 = r6.d()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.J r6 = r4.f1897c
            int r6 = r6.a()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$t):void");
    }

    boolean a(RecyclerView.t tVar, a aVar) {
        int i;
        int iF;
        if (!tVar.d() && (i = this.k) != -1) {
            if (i >= 0 && i < tVar.a()) {
                c cVar = this.q;
                if (cVar != null && cVar.f1915a != -1 && cVar.f1917c >= 1) {
                    aVar.f1904b = Integer.MIN_VALUE;
                    aVar.f1903a = this.k;
                } else {
                    View viewFindViewByPosition = findViewByPosition(this.k);
                    if (viewFindViewByPosition != null) {
                        aVar.f1903a = this.i ? f() : e();
                        if (this.l != Integer.MIN_VALUE) {
                            if (aVar.f1905c) {
                                aVar.f1904b = (this.f1897c.b() - this.l) - this.f1897c.a(viewFindViewByPosition);
                            } else {
                                aVar.f1904b = (this.f1897c.f() + this.l) - this.f1897c.d(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.f1897c.b(viewFindViewByPosition) > this.f1897c.g()) {
                            if (aVar.f1905c) {
                                iF = this.f1897c.b();
                            } else {
                                iF = this.f1897c.f();
                            }
                            aVar.f1904b = iF;
                            return true;
                        }
                        int iD = this.f1897c.d(viewFindViewByPosition) - this.f1897c.f();
                        if (iD < 0) {
                            aVar.f1904b = -iD;
                            return true;
                        }
                        int iB = this.f1897c.b() - this.f1897c.a(viewFindViewByPosition);
                        if (iB < 0) {
                            aVar.f1904b = iB;
                            return true;
                        }
                        aVar.f1904b = Integer.MIN_VALUE;
                    } else {
                        aVar.f1903a = this.k;
                        int i2 = this.l;
                        if (i2 == Integer.MIN_VALUE) {
                            aVar.f1905c = d(aVar.f1903a) == 1;
                            aVar.a();
                        } else {
                            aVar.a(i2);
                        }
                        aVar.f1906d = true;
                    }
                }
                return true;
            }
            this.k = -1;
            this.l = Integer.MIN_VALUE;
        }
        return false;
    }

    private void b(View view) {
        for (int i = this.f1895a - 1; i >= 0; i--) {
            this.f1896b[i].c(view);
        }
    }

    boolean b() {
        int iB = this.f1896b[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1895a; i++) {
            if (this.f1896b[i].b(Integer.MIN_VALUE) != iB) {
                return false;
            }
        }
        return true;
    }

    private void b(RecyclerView.o oVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f1897c.a(childAt) > i || this.f1897c.e(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f1902f) {
                for (int i2 = 0; i2 < this.f1895a; i2++) {
                    if (this.f1896b[i2].f1921a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f1895a; i3++) {
                    this.f1896b[i3].m();
                }
            } else if (layoutParams.f1901e.f1921a.size() == 1) {
                return;
            } else {
                layoutParams.f1901e.m();
            }
            removeAndRecycleView(childAt, oVar);
        }
    }

    public int[] a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f1895a];
        } else if (iArr.length < this.f1895a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f1895a + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f1895a; i++) {
            iArr[i] = this.f1896b[i].e();
        }
        return iArr;
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f1902f) {
            if (this.f1899e == 1) {
                a(view, this.r, RecyclerView.i.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
                return;
            } else {
                a(view, RecyclerView.i.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.r, z);
                return;
            }
        }
        if (this.f1899e == 1) {
            a(view, RecyclerView.i.getChildMeasureSpec(this.f1900f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.i.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
        } else {
            a(view, RecyclerView.i.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.i.getChildMeasureSpec(this.f1900f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z);
        }
    }

    private boolean c(RecyclerView.t tVar, a aVar) {
        int iG;
        if (this.o) {
            iG = h(tVar.a());
        } else {
            iG = g(tVar.a());
        }
        aVar.f1903a = iG;
        aVar.f1904b = Integer.MIN_VALUE;
        return true;
    }

    void c(int i) {
        this.f1900f = i / this.f1895a;
        this.r = View.MeasureSpec.makeMeasureSpec(i, this.f1898d.d());
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean zShouldMeasureChild;
        calculateItemDecorationsForChild(view, this.s);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.s;
        int iB = b(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.s;
        int iB2 = b(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z) {
            zShouldMeasureChild = shouldReMeasureChild(view, iB, iB2, layoutParams);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, iB, iB2, layoutParams);
        }
        if (zShouldMeasureChild) {
            view.measure(iB, iB2);
        }
    }

    View a(boolean z) {
        int iF = this.f1897c.f();
        int iB = this.f1897c.b();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iD = this.f1897c.d(childAt);
            int iA = this.f1897c.a(childAt);
            if (iA > iF && iD < iB) {
                if (iA <= iB || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void a(RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int iB;
        int i = i(Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE && (iB = this.f1897c.b() - i) > 0) {
            int i2 = iB - (-scrollBy(-iB, oVar, tVar));
            if (!z || i2 <= 0) {
                return;
            }
            this.f1897c.a(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.i
            if (r0 == 0) goto L9
            int r0 = r6.f()
            goto Ld
        L9:
            int r0 = r6.e()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r4 = r6.m
            r4.e(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r6.m
            r9.b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r7 = r6.m
            r7.a(r8, r4)
            goto L43
        L38:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r6.m
            r9.b(r7, r8)
            goto L43
        L3e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r6.m
            r9.a(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.i
            if (r7 == 0) goto L4f
            int r7 = r6.e()
            goto L53
        L4f:
            int r7 = r6.f()
        L53:
            if (r2 > r7) goto L58
            r6.requestLayout()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a(RecyclerView.o oVar, C c2, RecyclerView.t tVar) {
        int i;
        int i2;
        int iF;
        int i3;
        d dVarA;
        int iB;
        int i4;
        int iB2;
        int iB3;
        boolean zB;
        ?? r9 = 0;
        this.j.set(0, this.f1895a, true);
        if (this.g.i) {
            i2 = c2.f1784e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (c2.f1784e == 1) {
                i = c2.g + c2.f1781b;
            } else {
                i = c2.f1785f - c2.f1781b;
            }
            i2 = i;
        }
        a(c2.f1784e, i2);
        if (this.i) {
            iF = this.f1897c.b();
        } else {
            iF = this.f1897c.f();
        }
        int i5 = iF;
        boolean z = false;
        while (c2.a(tVar) && (this.g.i || !this.j.isEmpty())) {
            View viewA = c2.a(oVar);
            LayoutParams layoutParams = (LayoutParams) viewA.getLayoutParams();
            int iA = layoutParams.a();
            int iD = this.m.d(iA);
            boolean z2 = iD == -1;
            if (z2) {
                dVarA = layoutParams.f1902f ? this.f1896b[r9] : a(c2);
                this.m.a(iA, dVarA);
            } else {
                dVarA = this.f1896b[iD];
            }
            d dVar = dVarA;
            layoutParams.f1901e = dVar;
            if (c2.f1784e == 1) {
                addView(viewA);
            } else {
                addView(viewA, r9);
            }
            a(viewA, layoutParams, (boolean) r9);
            if (c2.f1784e == 1) {
                int i6 = layoutParams.f1902f ? i(i5) : dVar.a(i5);
                int iB4 = this.f1897c.b(viewA) + i6;
                if (z2 && layoutParams.f1902f) {
                    b.a aVarE = e(i6);
                    aVarE.f1912b = -1;
                    aVarE.f1911a = iA;
                    this.m.a(aVarE);
                }
                i4 = iB4;
                iB = i6;
            } else {
                int iL = layoutParams.f1902f ? l(i5) : dVar.b(i5);
                iB = iL - this.f1897c.b(viewA);
                if (z2 && layoutParams.f1902f) {
                    b.a aVarF = f(iL);
                    aVarF.f1912b = 1;
                    aVarF.f1911a = iA;
                    this.m.a(aVarF);
                }
                i4 = iL;
            }
            if (layoutParams.f1902f && c2.f1783d == -1) {
                if (z2) {
                    this.u = true;
                } else {
                    if (c2.f1784e == 1) {
                        zB = a();
                    } else {
                        zB = b();
                    }
                    if (!zB) {
                        b.a aVarC = this.m.c(iA);
                        if (aVarC != null) {
                            aVarC.f1914d = true;
                        }
                        this.u = true;
                    }
                }
            }
            a(viewA, layoutParams, c2);
            if (isLayoutRTL() && this.f1899e == 1) {
                int iB5 = layoutParams.f1902f ? this.f1898d.b() : this.f1898d.b() - (((this.f1895a - 1) - dVar.f1925e) * this.f1900f);
                iB3 = iB5;
                iB2 = iB5 - this.f1898d.b(viewA);
            } else {
                int iF2 = layoutParams.f1902f ? this.f1898d.f() : (dVar.f1925e * this.f1900f) + this.f1898d.f();
                iB2 = iF2;
                iB3 = this.f1898d.b(viewA) + iF2;
            }
            if (this.f1899e == 1) {
                layoutDecoratedWithMargins(viewA, iB2, iB, iB3, i4);
            } else {
                layoutDecoratedWithMargins(viewA, iB, iB2, i4, iB3);
            }
            if (layoutParams.f1902f) {
                a(this.g.f1784e, i2);
            } else {
                a(dVar, this.g.f1784e, i2);
            }
            a(oVar, this.g);
            if (this.g.h && viewA.hasFocusable()) {
                if (layoutParams.f1902f) {
                    this.j.clear();
                } else {
                    this.j.set(dVar.f1925e, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(oVar, this.g);
        }
        if (this.g.f1784e == -1) {
            i3 = this.f1897c.f() - l(this.f1897c.f());
        } else {
            i3 = i(this.f1897c.b()) - this.f1897c.b();
        }
        if (i3 > 0) {
            return Math.min(c2.f1781b, i3);
        }
        return 0;
    }

    private void a(View view, LayoutParams layoutParams, C c2) {
        if (c2.f1784e == 1) {
            if (layoutParams.f1902f) {
                a(view);
                return;
            } else {
                layoutParams.f1901e.a(view);
                return;
            }
        }
        if (layoutParams.f1902f) {
            b(view);
        } else {
            layoutParams.f1901e.c(view);
        }
    }

    private void a(RecyclerView.o oVar, C c2) {
        int iMin;
        int iMin2;
        if (!c2.f1780a || c2.i) {
            return;
        }
        if (c2.f1781b == 0) {
            if (c2.f1784e == -1) {
                a(oVar, c2.g);
                return;
            } else {
                b(oVar, c2.f1785f);
                return;
            }
        }
        if (c2.f1784e == -1) {
            int i = c2.f1785f;
            int iJ = i - j(i);
            if (iJ < 0) {
                iMin2 = c2.g;
            } else {
                iMin2 = c2.g - Math.min(iJ, c2.f1781b);
            }
            a(oVar, iMin2);
            return;
        }
        int iK = k(c2.g) - c2.g;
        if (iK < 0) {
            iMin = c2.f1785f;
        } else {
            iMin = Math.min(iK, c2.f1781b) + c2.f1785f;
        }
        b(oVar, iMin);
    }

    private void a(View view) {
        for (int i = this.f1895a - 1; i >= 0; i--) {
            this.f1896b[i].a(view);
        }
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.f1895a; i3++) {
            if (!this.f1896b[i3].f1921a.isEmpty()) {
                a(this.f1896b[i3], i, i2);
            }
        }
    }

    private void a(d dVar, int i, int i2) {
        int iH = dVar.h();
        if (i == -1) {
            if (dVar.j() + iH <= i2) {
                this.j.set(dVar.f1925e, false);
            }
        } else if (dVar.i() - iH >= i2) {
            this.j.set(dVar.f1925e, false);
        }
    }

    boolean a() {
        int iA = this.f1896b[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1895a; i++) {
            if (this.f1896b[i].a(Integer.MIN_VALUE) != iA) {
                return false;
            }
        }
        return true;
    }

    private void a(RecyclerView.o oVar, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f1897c.d(childAt) < i || this.f1897c.f(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f1902f) {
                for (int i2 = 0; i2 < this.f1895a; i2++) {
                    if (this.f1896b[i2].f1921a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f1895a; i3++) {
                    this.f1896b[i3].l();
                }
            } else if (layoutParams.f1901e.f1921a.size() == 1) {
                return;
            } else {
                layoutParams.f1901e.l();
            }
            removeAndRecycleView(childAt, oVar);
        }
    }

    private d a(C c2) {
        int i;
        int i2;
        int i3 = -1;
        if (m(c2.f1784e)) {
            i = this.f1895a - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.f1895a;
            i2 = 1;
        }
        d dVar = null;
        if (c2.f1784e == 1) {
            int i4 = Integer.MAX_VALUE;
            int iF = this.f1897c.f();
            while (i != i3) {
                d dVar2 = this.f1896b[i];
                int iA = dVar2.a(iF);
                if (iA < i4) {
                    dVar = dVar2;
                    i4 = iA;
                }
                i += i2;
            }
            return dVar;
        }
        int i5 = Integer.MIN_VALUE;
        int iB = this.f1897c.b();
        while (i != i3) {
            d dVar3 = this.f1896b[i];
            int iB2 = dVar3.b(iB);
            if (iB2 > i5) {
                dVar = dVar3;
                i5 = iB2;
            }
            i += i2;
        }
        return dVar;
    }

    void a(int i, RecyclerView.t tVar) {
        int iE;
        int i2;
        if (i > 0) {
            iE = f();
            i2 = 1;
        } else {
            iE = e();
            i2 = -1;
        }
        this.g.f1780a = true;
        b(iE, tVar);
        n(i2);
        C c2 = this.g;
        c2.f1782c = iE + c2.f1783d;
        c2.f1781b = Math.abs(i);
    }
}
