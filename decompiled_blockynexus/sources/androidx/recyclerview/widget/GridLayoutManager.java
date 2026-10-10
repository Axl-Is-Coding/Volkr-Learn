package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int[] f1791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View[] f1792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final SparseIntArray f1793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final SparseIntArray f1794f;
    b g;
    final Rect h;
    private boolean i;

    public static final class a extends b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int a(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int d(int i, int i2) {
            return i % i2;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f1797a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseIntArray f1798b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1799c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1800d = false;

        public abstract int a(int i);

        public void a() {
            this.f1798b.clear();
        }

        public void b() {
            this.f1797a.clear();
        }

        public int c(int i, int i2) {
            int iA;
            int i3;
            int i4;
            int iA2;
            if (!this.f1800d || (iA2 = a(this.f1798b, i)) == -1) {
                iA = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i3 = this.f1798b.get(iA2);
                i4 = iA2 + 1;
                iA = a(iA2) + b(iA2, i2);
                if (iA == i2) {
                    i3++;
                    iA = 0;
                }
            }
            int iA3 = a(i);
            while (i4 < i) {
                int iA4 = a(i4);
                iA += iA4;
                if (iA == i2) {
                    i3++;
                    iA = 0;
                } else if (iA > i2) {
                    i3++;
                    iA = iA4;
                }
                i4++;
            }
            return iA + iA3 > i2 ? i3 + 1 : i3;
        }

        public abstract int d(int i, int i2);

        int a(int i, int i2) {
            if (!this.f1800d) {
                return c(i, i2);
            }
            int i3 = this.f1798b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iC = c(i, i2);
            this.f1798b.put(i, iC);
            return iC;
        }

        int b(int i, int i2) {
            if (!this.f1799c) {
                return d(i, i2);
            }
            int i3 = this.f1797a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iD = d(i, i2);
            this.f1797a.put(i, iD);
            return iD;
        }

        static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1789a = false;
        this.f1790b = -1;
        this.f1793e = new SparseIntArray();
        this.f1794f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(RecyclerView.i.getProperties(context, attributeSet, i, i2).f1859b);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    private void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int iA = layoutParams.a();
            this.f1793e.put(iA, layoutParams.h());
            this.f1794f.put(iA, layoutParams.f());
        }
    }

    private void c() {
        this.f1793e.clear();
        this.f1794f.clear();
    }

    private void d() {
        View[] viewArr = this.f1792d;
        if (viewArr == null || viewArr.length != this.f1790b) {
            this.f1792d = new View[this.f1790b];
        }
    }

    private void e() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        b(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.t tVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int iA = this.f1790b;
        for (int i = 0; i < this.f1790b && cVar.a(tVar) && iA > 0; i++) {
            int i2 = cVar.f1833d;
            aVar.a(i2, Math.max(0, cVar.g));
            iA -= this.g.a(i2);
            cVar.f1833d += cVar.f1834e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollOffset(RecyclerView.t tVar) {
        return this.i ? a(tVar) : super.computeHorizontalScrollOffset(tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollRange(RecyclerView.t tVar) {
        return this.i ? b(tVar) : super.computeHorizontalScrollRange(tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollOffset(RecyclerView.t tVar) {
        return this.i ? a(tVar) : super.computeVerticalScrollOffset(tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollRange(RecyclerView.t tVar) {
        return this.i ? b(tVar) : super.computeVerticalScrollRange(tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.o oVar, RecyclerView.t tVar, int i, int i2, int i3) {
        ensureLayoutState();
        int iF = this.mOrientationHelper.f();
        int iB = this.mOrientationHelper.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && b(oVar, tVar, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.d(childAt) < iB && this.mOrientationHelper.a(childAt) >= iF) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getColumnCountForAccessibility(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.mOrientation == 1) {
            return this.f1790b;
        }
        if (tVar.a() < 1) {
            return 0;
        }
        return a(oVar, tVar, tVar.a() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getRowCountForAccessibility(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.mOrientation == 0) {
            return this.f1790b;
        }
        if (tVar.a() < 1) {
            return 0;
        }
        return a(oVar, tVar, tVar.a() - 1) + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v28 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.o oVar, RecyclerView.t tVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iC;
        int i5;
        int iC2;
        int iC3;
        int childMeasureSpec;
        int childMeasureSpec2;
        View viewA;
        int iE = this.mOrientationHelper.e();
        ?? r5 = 0;
        boolean z = iE != 1073741824;
        int i6 = getChildCount() > 0 ? this.f1791c[this.f1790b] : 0;
        if (z) {
            e();
        }
        boolean z2 = cVar.f1834e == 1;
        int iB = this.f1790b;
        if (!z2) {
            iB = b(oVar, tVar, cVar.f1833d) + c(oVar, tVar, cVar.f1833d);
        }
        int i7 = iB;
        int i8 = 0;
        while (i8 < this.f1790b && cVar.a(tVar) && i7 > 0) {
            int i9 = cVar.f1833d;
            int iC4 = c(oVar, tVar, i9);
            if (iC4 > this.f1790b) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + iC4 + " spans but GridLayoutManager has only " + this.f1790b + " spans.");
            }
            i7 -= iC4;
            if (i7 < 0 || (viewA = cVar.a(oVar)) == null) {
                break;
            }
            this.f1792d[i8] = viewA;
            i8++;
        }
        if (i8 == 0) {
            bVar.f1827b = true;
            return;
        }
        float f2 = WheelView.DividerConfig.FILL;
        a(oVar, tVar, i8, z2);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            View view = this.f1792d[i10];
            if (cVar.l == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.h);
            a(view, iE, (boolean) r5);
            int iB2 = this.mOrientationHelper.b(view);
            if (iB2 > i11) {
                i11 = iB2;
            }
            float fC = (this.mOrientationHelper.c(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).f1796f;
            if (fC > f2) {
                f2 = fC;
            }
            i10++;
            r5 = 0;
        }
        if (z) {
            a(f2, i6);
            i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                View view2 = this.f1792d[i12];
                a(view2, FileTypeUtils.GIGABYTE, true);
                int iB3 = this.mOrientationHelper.b(view2);
                if (iB3 > i11) {
                    i11 = iB3;
                }
            }
        }
        for (int i13 = 0; i13 < i8; i13++) {
            View view3 = this.f1792d[i13];
            if (this.mOrientationHelper.b(view3) != i11) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f1844b;
                int i14 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i15 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int iA = a(layoutParams.f1795e, layoutParams.f1796f);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView.i.getChildMeasureSpec(iA, FileTypeUtils.GIGABYTE, i15, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i14, FileTypeUtils.GIGABYTE);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i15, FileTypeUtils.GIGABYTE);
                    childMeasureSpec = RecyclerView.i.getChildMeasureSpec(iA, FileTypeUtils.GIGABYTE, i14, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                a(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        int i16 = 0;
        bVar.f1826a = i11;
        if (this.mOrientation == 1) {
            if (cVar.f1835f == -1) {
                int i17 = cVar.f1831b;
                i = i17 - i11;
                i2 = i17;
            } else {
                int i18 = cVar.f1831b;
                i2 = i18 + i11;
                i = i18;
            }
            i4 = 0;
            i3 = 0;
        } else if (cVar.f1835f == -1) {
            i3 = cVar.f1831b;
            i4 = i3 - i11;
            i = 0;
            i2 = 0;
        } else {
            int i19 = cVar.f1831b;
            int i20 = i19 + i11;
            i = 0;
            i2 = 0;
            i3 = i20;
            i4 = i19;
        }
        while (i16 < i8) {
            View view4 = this.f1792d[i16];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.f1791c[layoutParams2.f1795e];
                iC = i4;
                i5 = paddingTop;
                iC2 = this.mOrientationHelper.c(view4) + paddingTop;
                iC3 = i3;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.f1791c[this.f1790b - layoutParams2.f1795e];
                iC3 = paddingLeft;
                i5 = i;
                iC2 = i2;
                iC = paddingLeft - this.mOrientationHelper.c(view4);
            } else {
                int paddingLeft2 = getPaddingLeft() + this.f1791c[layoutParams2.f1795e];
                iC = paddingLeft2;
                i5 = i;
                iC2 = i2;
                iC3 = this.mOrientationHelper.c(view4) + paddingLeft2;
            }
            layoutDecoratedWithMargins(view4, iC, i5, iC3, iC2);
            if (layoutParams2.c() || layoutParams2.b()) {
                bVar.f1828c = true;
            }
            bVar.f1829d |= view4.hasFocusable();
            i16++;
            i4 = iC;
            i = i5;
            i3 = iC3;
            i2 = iC2;
        }
        Arrays.fill(this.f1792d, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.o oVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        super.onAnchorReady(oVar, tVar, aVar, i);
        e();
        if (tVar.a() > 0 && !tVar.d()) {
            a(oVar, tVar, aVar, i);
        }
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d7, code lost:
    
        if (r13 == (r2 > r8)) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.o r26, androidx.recyclerview.widget.RecyclerView.t r27) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$t):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.o oVar, RecyclerView.t tVar, View view, androidx.core.view.accessibility.b bVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, bVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int iA = a(oVar, tVar, layoutParams2.a());
        if (this.mOrientation == 0) {
            bVar.b(b.c.a(layoutParams2.f(), layoutParams2.h(), iA, 1, false, false));
        } else {
            bVar.b(b.c.a(iA, 1, layoutParams2.f(), layoutParams2.h(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.g.b();
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsChanged(RecyclerView recyclerView) {
        this.g.b();
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.b();
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.g.b();
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.b();
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutChildren(RecyclerView.o oVar, RecyclerView.t tVar) {
        if (tVar.d()) {
            b();
        }
        super.onLayoutChildren(oVar, tVar);
        c();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutCompleted(RecyclerView.t tVar) {
        super.onLayoutCompleted(tVar);
        this.f1789a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int scrollHorizontallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        e();
        d();
        return super.scrollHorizontallyBy(i, oVar, tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int scrollVerticallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        e();
        d();
        return super.scrollVerticallyBy(i, oVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.f1791c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.i.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f1791c;
            iChooseSize = RecyclerView.i.chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.i.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f1791c;
            iChooseSize2 = RecyclerView.i.chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f1789a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1795e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1796f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1795e = -1;
            this.f1796f = 0;
        }

        public int f() {
            return this.f1795e;
        }

        public int h() {
            return this.f1796f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1795e = -1;
            this.f1796f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1795e = -1;
            this.f1796f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1795e = -1;
            this.f1796f = 0;
        }
    }

    private int c(RecyclerView.o oVar, RecyclerView.t tVar, int i) {
        if (!tVar.d()) {
            return this.g.a(i);
        }
        int i2 = this.f1793e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iA = oVar.a(i);
        if (iA == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.g.a(iA);
    }

    private void b(int i) {
        this.f1791c = a(this.f1791c, this.f1790b, i);
    }

    private int b(RecyclerView.o oVar, RecyclerView.t tVar, int i) {
        if (!tVar.d()) {
            return this.g.b(i, this.f1790b);
        }
        int i2 = this.f1794f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iA = oVar.a(i);
        if (iA == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.g.b(iA, this.f1790b);
    }

    int a(int i, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.f1791c;
            int i3 = this.f1790b;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.f1791c;
        return iArr2[i2 + i] - iArr2[i];
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f1789a = false;
        this.f1790b = -1;
        this.f1793e = new SparseIntArray();
        this.f1794f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(i);
    }

    private void a(RecyclerView.o oVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iB = b(oVar, tVar, aVar.f1822b);
        if (z) {
            while (iB > 0) {
                int i2 = aVar.f1822b;
                if (i2 <= 0) {
                    return;
                }
                aVar.f1822b = i2 - 1;
                iB = b(oVar, tVar, aVar.f1822b);
            }
            return;
        }
        int iA = tVar.a() - 1;
        int i3 = aVar.f1822b;
        while (i3 < iA) {
            int i4 = i3 + 1;
            int iB2 = b(oVar, tVar, i4);
            if (iB2 <= iB) {
                break;
            }
            i3 = i4;
            iB = iB2;
        }
        aVar.f1822b = i3;
    }

    private int b(RecyclerView.t tVar) {
        if (getChildCount() != 0 && tVar.a() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.g.a(tVar.a() - 1, this.f1790b) + 1;
                }
                return (int) (((this.mOrientationHelper.a(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.d(viewFindFirstVisibleChildClosestToStart)) / ((this.g.a(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f1790b) - this.g.a(getPosition(viewFindFirstVisibleChildClosestToStart), this.f1790b)) + 1)) * (this.g.a(tVar.a() - 1, this.f1790b) + 1));
            }
        }
        return 0;
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f1789a = false;
        this.f1790b = -1;
        this.f1793e = new SparseIntArray();
        this.f1794f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(i);
    }

    private int a(RecyclerView.o oVar, RecyclerView.t tVar, int i) {
        if (!tVar.d()) {
            return this.g.a(i, this.f1790b);
        }
        int iA = oVar.a(i);
        if (iA == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.g.a(iA, this.f1790b);
    }

    private void a(View view, int i, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f1844b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int iA = a(layoutParams.f1795e, layoutParams.f1796f);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView.i.getChildMeasureSpec(iA, i, i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            childMeasureSpec = RecyclerView.i.getChildMeasureSpec(this.mOrientationHelper.g(), getHeightMode(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView.i.getChildMeasureSpec(iA, i, i2, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec4 = RecyclerView.i.getChildMeasureSpec(this.mOrientationHelper.g(), getWidthMode(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        a(view, childMeasureSpec2, childMeasureSpec, z);
    }

    private void a(float f2, int i) {
        b(Math.max(Math.round(f2 * this.f1790b), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean zShouldMeasureChild;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            zShouldMeasureChild = shouldReMeasureChild(view, i, i2, layoutParams);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, i, i2, layoutParams);
        }
        if (zShouldMeasureChild) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.o oVar, RecyclerView.t tVar, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.f1792d[i2];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f1796f = c(oVar, tVar, getPosition(view));
            layoutParams.f1795e = i4;
            i4 += layoutParams.f1796f;
            i2 += i3;
        }
    }

    public int a() {
        return this.f1790b;
    }

    public void a(int i) {
        if (i == this.f1790b) {
            return;
        }
        this.f1789a = true;
        if (i >= 1) {
            this.f1790b = i;
            this.g.b();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    private int a(RecyclerView.t tVar) {
        int iMax;
        if (getChildCount() != 0 && tVar.a() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int iA = this.g.a(getPosition(viewFindFirstVisibleChildClosestToStart), this.f1790b);
                int iA2 = this.g.a(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f1790b);
                int iMin = Math.min(iA, iA2);
                int iMax2 = Math.max(iA, iA2);
                int iA3 = this.g.a(tVar.a() - 1, this.f1790b) + 1;
                if (this.mShouldReverseLayout) {
                    iMax = Math.max(0, (iA3 - iMax2) - 1);
                } else {
                    iMax = Math.max(0, iMin);
                }
                if (zIsSmoothScrollbarEnabled) {
                    return Math.round((iMax * (Math.abs(this.mOrientationHelper.a(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.d(viewFindFirstVisibleChildClosestToStart)) / ((this.g.a(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f1790b) - this.g.a(getPosition(viewFindFirstVisibleChildClosestToStart), this.f1790b)) + 1))) + (this.mOrientationHelper.f() - this.mOrientationHelper.d(viewFindFirstVisibleChildClosestToStart)));
                }
                return iMax;
            }
        }
        return 0;
    }
}
