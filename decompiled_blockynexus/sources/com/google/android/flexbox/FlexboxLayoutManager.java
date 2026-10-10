package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.E;
import androidx.recyclerview.widget.J;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.flexbox.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.i implements RecyclerView.s.b, com.google.android.flexbox.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f13040a = new Rect();
    private e.a A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13045f;
    private boolean g;
    private boolean h;
    private List<com.google.android.flexbox.c> i;
    private final e j;
    private RecyclerView.o k;
    private RecyclerView.t l;
    private b m;
    private a n;
    private J o;
    private J p;
    private c q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private SparseArray<View> w;
    private final Context x;
    private View y;
    private int z;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f13052e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f13053f;
        private boolean g;

        private a() {
            this.f13051d = 0;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f13048a + ", mFlexLinePosition=" + this.f13049b + ", mCoordinate=" + this.f13050c + ", mPerpendicularCoordinate=" + this.f13051d + ", mLayoutFromEnd=" + this.f13052e + ", mValid=" + this.f13053f + ", mAssignedFromSavedState=" + this.g + '}';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f13048a = -1;
            this.f13049b = -1;
            this.f13050c = Integer.MIN_VALUE;
            this.f13053f = false;
            this.g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.f13042c == 0) {
                    this.f13052e = FlexboxLayoutManager.this.f13041b == 1;
                    return;
                } else {
                    this.f13052e = FlexboxLayoutManager.this.f13042c == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f13042c == 0) {
                this.f13052e = FlexboxLayoutManager.this.f13041b == 3;
            } else {
                this.f13052e = FlexboxLayoutManager.this.f13042c == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.g) {
                this.f13050c = this.f13052e ? FlexboxLayoutManager.this.o.b() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.o.f();
            } else {
                this.f13050c = this.f13052e ? FlexboxLayoutManager.this.o.b() : FlexboxLayoutManager.this.o.f();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view) {
            J j = FlexboxLayoutManager.this.f13042c == 0 ? FlexboxLayoutManager.this.p : FlexboxLayoutManager.this.o;
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.g) {
                if (this.f13052e) {
                    this.f13050c = j.d(view) + j.h();
                } else {
                    this.f13050c = j.a(view);
                }
            } else if (this.f13052e) {
                this.f13050c = j.a(view) + j.h();
            } else {
                this.f13050c = j.d(view);
            }
            this.f13048a = FlexboxLayoutManager.this.getPosition(view);
            this.g = false;
            int[] iArr = FlexboxLayoutManager.this.j.f13070c;
            int i = this.f13048a;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.f13049b = i2 != -1 ? i2 : 0;
            if (FlexboxLayoutManager.this.i.size() > this.f13049b) {
                this.f13048a = ((com.google.android.flexbox.c) FlexboxLayoutManager.this.i.get(this.f13049b)).o;
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f13058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f13059f;
        private int g;
        private int h;
        private int i;
        private boolean j;

        private b() {
            this.h = 1;
            this.i = 1;
        }

        static /* synthetic */ int e(b bVar) {
            int i = bVar.f13056c;
            bVar.f13056c = i + 1;
            return i;
        }

        static /* synthetic */ int f(b bVar) {
            int i = bVar.f13056c;
            bVar.f13056c = i - 1;
            return i;
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f13054a + ", mFlexLinePosition=" + this.f13056c + ", mPosition=" + this.f13057d + ", mOffset=" + this.f13058e + ", mScrollingOffset=" + this.f13059f + ", mLastScrollDelta=" + this.g + ", mItemDirection=" + this.h + ", mLayoutDirection=" + this.i + '}';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(RecyclerView.t tVar, List<com.google.android.flexbox.c> list) {
            int i;
            int i2 = this.f13057d;
            return i2 >= 0 && i2 < tVar.a() && (i = this.f13056c) >= 0 && i < list.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new i();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13061b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f13060a + ", mAnchorOffset=" + this.f13061b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f13060a);
            parcel.writeInt(this.f13061b);
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f13060a = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(int i) {
            int i2 = this.f13060a;
            return i2 >= 0 && i2 < i;
        }

        private c(Parcel parcel) {
            this.f13060a = parcel.readInt();
            this.f13061b = parcel.readInt();
        }

        private c(c cVar) {
            this.f13060a = cVar.f13060a;
            this.f13061b = cVar.f13061b;
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private int computeScrollExtent(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iA = tVar.a();
        b();
        View viewE = e(iA);
        View viewF = f(iA);
        if (tVar.a() == 0 || viewE == null || viewF == null) {
            return 0;
        }
        return Math.min(this.o.g(), this.o.a(viewF) - this.o.d(viewE));
    }

    private int computeScrollOffset(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iA = tVar.a();
        View viewE = e(iA);
        View viewF = f(iA);
        if (tVar.a() != 0 && viewE != null && viewF != null) {
            int position = getPosition(viewE);
            int position2 = getPosition(viewF);
            int iAbs = Math.abs(this.o.a(viewF) - this.o.d(viewE));
            int i = this.j.f13070c[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((r4[position2] - i) + 1))) + (this.o.f() - this.o.d(viewE)));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iA = tVar.a();
        View viewE = e(iA);
        View viewF = f(iA);
        if (tVar.a() == 0 || viewE == null || viewF == null) {
            return 0;
        }
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.o.a(viewF) - this.o.d(viewE)) / ((findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1)) * tVar.a());
    }

    private void ensureLayoutState() {
        if (this.m == null) {
            this.m = new b();
        }
    }

    private int fixLayoutEndGap(int i, RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int iA;
        int iB;
        if (!isMainAxisDirectionHorizontal() && this.g) {
            int iF = i - this.o.f();
            if (iF <= 0) {
                return 0;
            }
            iA = a(iF, oVar, tVar);
        } else {
            int iB2 = this.o.b() - i;
            if (iB2 <= 0) {
                return 0;
            }
            iA = -a(-iB2, oVar, tVar);
        }
        int i2 = i + iA;
        if (!z || (iB = this.o.b() - i2) <= 0) {
            return iA;
        }
        this.o.a(iB);
        return iB + iA;
    }

    private int fixLayoutStartGap(int i, RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int iA;
        int iF;
        if (isMainAxisDirectionHorizontal() || !this.g) {
            int iF2 = i - this.o.f();
            if (iF2 <= 0) {
                return 0;
            }
            iA = -a(iF2, oVar, tVar);
        } else {
            int iB = this.o.b() - i;
            if (iB <= 0) {
                return 0;
            }
            iA = a(-iB, oVar, tVar);
        }
        int i2 = i + iA;
        if (!z || (iF = i2 - this.o.f()) <= 0) {
            return iA;
        }
        this.o.a(-iF);
        return iA - iF;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private void h(int i) {
        if (i >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.j.b(childCount);
        this.j.c(childCount);
        this.j.a(childCount);
        if (i >= this.j.f13070c.length) {
            return;
        }
        this.z = i;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.r = getPosition(childClosestToStart);
        if (isMainAxisDirectionHorizontal() || !this.g) {
            this.s = this.o.d(childClosestToStart) - this.o.f();
        } else {
            this.s = this.o.a(childClosestToStart) + this.o.c();
        }
    }

    private void i(int i) {
        boolean z;
        int i2;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (isMainAxisDirectionHorizontal()) {
            int i3 = this.t;
            z = (i3 == Integer.MIN_VALUE || i3 == width) ? false : true;
            i2 = this.m.f13055b ? this.x.getResources().getDisplayMetrics().heightPixels : this.m.f13054a;
        } else {
            int i4 = this.u;
            z = (i4 == Integer.MIN_VALUE || i4 == height) ? false : true;
            i2 = this.m.f13055b ? this.x.getResources().getDisplayMetrics().widthPixels : this.m.f13054a;
        }
        int i5 = i2;
        this.t = width;
        this.u = height;
        if (this.z == -1 && (this.r != -1 || z)) {
            if (this.n.f13052e) {
                return;
            }
            this.i.clear();
            this.A.a();
            if (isMainAxisDirectionHorizontal()) {
                this.j.b(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i5, this.n.f13048a, this.i);
            } else {
                this.j.d(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i5, this.n.f13048a, this.i);
            }
            this.i = this.A.f13073a;
            this.j.a(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.j.a();
            a aVar = this.n;
            aVar.f13049b = this.j.f13070c[aVar.f13048a];
            this.m.f13056c = this.n.f13049b;
            return;
        }
        int i6 = this.z;
        int iMin = i6 != -1 ? Math.min(i6, this.n.f13048a) : this.n.f13048a;
        this.A.a();
        if (isMainAxisDirectionHorizontal()) {
            if (this.i.size() > 0) {
                this.j.a(this.i, iMin);
                this.j.a(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i5, iMin, this.n.f13048a, this.i);
            } else {
                this.j.a(i);
                this.j.a(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i5, 0, this.i);
            }
        } else if (this.i.size() > 0) {
            this.j.a(this.i, iMin);
            this.j.a(this.A, iMakeMeasureSpec2, iMakeMeasureSpec, i5, iMin, this.n.f13048a, this.i);
        } else {
            this.j.a(i);
            this.j.c(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i5, 0, this.i);
        }
        this.i = this.A.f13073a;
        this.j.b(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
        this.j.d(iMin);
    }

    private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    private void recycleChildren(RecyclerView.o oVar, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, oVar);
            i2--;
        }
    }

    private boolean shouldMeasureChild(View view, int i, int i2, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollHorizontally() {
        if (this.f13042c == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.y;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollVertically() {
        if (this.f13042c == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.y;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
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
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        return isMainAxisDirectionHorizontal() ? new PointF(WheelView.DividerConfig.FILL, i2) : new PointF(i2, WheelView.DividerConfig.FILL);
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

    public int findFirstVisibleItemPosition() {
        View viewA = a(0, getChildCount(), false);
        if (viewA == null) {
            return -1;
        }
        return getPosition(viewA);
    }

    public int findLastVisibleItemPosition() {
        View viewA = a(getChildCount() - 1, -1, false);
        if (viewA == null) {
            return -1;
        }
        return getPosition(viewA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f13044e;
    }

    @Override // com.google.android.flexbox.a
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.i.getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.i.getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthMainAxis(View view, int i, int i2) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f13041b;
    }

    @Override // com.google.android.flexbox.a
    public View getFlexItemAt(int i) {
        View view = this.w.get(i);
        return view != null ? view : this.k.d(i);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.l.a();
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.c> getFlexLinesInternal() {
        return this.i;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f13042c;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.i.size() == 0) {
            return 0;
        }
        int iMax = Integer.MIN_VALUE;
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, this.i.get(i).f13066e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f13045f;
    }

    @Override // com.google.android.flexbox.a
    public View getReorderedFlexItemAt(int i) {
        return getFlexItemAt(i);
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.i.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.i.get(i2).g;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.f13041b;
        return i == 0 || i == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onAdapterChanged(RecyclerView.a aVar, RecyclerView.a aVar2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.y = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.onDetachedFromWindow(recyclerView, oVar);
        if (this.v) {
            removeAndRecycleAllViews(oVar);
            oVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        h(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        h(Math.min(i, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        h(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        h(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutChildren(RecyclerView.o oVar, RecyclerView.t tVar) {
        int i;
        int i2;
        this.k = oVar;
        this.l = tVar;
        int iA = tVar.a();
        if (iA == 0 && tVar.d()) {
            return;
        }
        d();
        b();
        ensureLayoutState();
        this.j.b(iA);
        this.j.c(iA);
        this.j.a(iA);
        this.m.j = false;
        c cVar = this.q;
        if (cVar != null && cVar.b(iA)) {
            this.r = this.q.f13060a;
        }
        if (!this.n.f13053f || this.r != -1 || this.q != null) {
            this.n.b();
            b(tVar, this.n);
            this.n.f13053f = true;
        }
        detachAndScrapAttachedViews(oVar);
        if (this.n.f13052e) {
            b(this.n, false, true);
        } else {
            a(this.n, false, true);
        }
        i(iA);
        if (this.n.f13052e) {
            a(oVar, tVar, this.m);
            i2 = this.m.f13058e;
            a(this.n, true, false);
            a(oVar, tVar, this.m);
            i = this.m.f13058e;
        } else {
            a(oVar, tVar, this.m);
            i = this.m.f13058e;
            b(this.n, true, false);
            a(oVar, tVar, this.m);
            i2 = this.m.f13058e;
        }
        if (getChildCount() > 0) {
            if (this.n.f13052e) {
                fixLayoutStartGap(i2 + fixLayoutEndGap(i, oVar, tVar, true), oVar, tVar, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, oVar, tVar, true), oVar, tVar, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutCompleted(RecyclerView.t tVar) {
        super.onLayoutCompleted(tVar);
        this.q = null;
        this.r = -1;
        this.s = Integer.MIN_VALUE;
        this.z = -1;
        this.n.b();
        this.w.clear();
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexItemAdded(View view, int i, int i2, com.google.android.flexbox.c cVar) {
        calculateItemDecorationsForChild(view, f13040a);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            cVar.f13066e += leftDecorationWidth;
            cVar.f13067f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            cVar.f13066e += topDecorationHeight;
            cVar.f13067f += topDecorationHeight;
        }
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexLineAdded(com.google.android.flexbox.c cVar) {
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
        c cVar = this.q;
        if (cVar != null) {
            return new c(cVar);
        }
        c cVar2 = new c();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            cVar2.f13060a = getPosition(childClosestToStart);
            cVar2.f13061b = this.o.d(childClosestToStart) - this.o.f();
        } else {
            cVar2.a();
        }
        return cVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollHorizontallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (!isMainAxisDirectionHorizontal() || (this.f13042c == 0 && isMainAxisDirectionHorizontal())) {
            int iA = a(i, oVar, tVar);
            this.w.clear();
            return iA;
        }
        int iG = g(i);
        this.n.f13051d += iG;
        this.p.a(-iG);
        return iG;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void scrollToPosition(int i) {
        this.r = i;
        this.s = Integer.MIN_VALUE;
        c cVar = this.q;
        if (cVar != null) {
            cVar.a();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollVerticallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (isMainAxisDirectionHorizontal() || (this.f13042c == 0 && !isMainAxisDirectionHorizontal())) {
            int iA = a(i, oVar, tVar);
            this.w.clear();
            return iA;
        }
        int iG = g(i);
        this.n.f13051d += iG;
        this.p.a(-iG);
        return iG;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.c> list) {
        this.i = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        E e2 = new E(recyclerView.getContext());
        e2.setTargetPosition(i);
        startSmoothScroll(e2);
    }

    @Override // com.google.android.flexbox.a
    public void updateViewCache(int i, View view) {
        this.w.put(i, view);
    }

    public FlexboxLayoutManager(Context context, int i, int i2) {
        this.f13045f = -1;
        this.i = new ArrayList();
        this.j = new e(this);
        this.n = new a();
        this.r = -1;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.u = Integer.MIN_VALUE;
        this.w = new SparseArray<>();
        this.z = -1;
        this.A = new e.a();
        b(i);
        c(i2);
        a(4);
        setAutoMeasureEnabled(true);
        this.x = context;
    }

    private View e(int i) {
        View viewA = a(0, getChildCount(), i);
        if (viewA == null) {
            return null;
        }
        int i2 = this.j.f13070c[getPosition(viewA)];
        if (i2 == -1) {
            return null;
        }
        return a(viewA, this.i.get(i2));
    }

    private View f(int i) {
        View viewA = a(getChildCount() - 1, -1, i);
        if (viewA == null) {
            return null;
        }
        return b(viewA, this.i.get(this.j.f13070c[getPosition(viewA)]));
    }

    private int g(int i) {
        int iMin;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        b();
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int width = zIsMainAxisDirectionHorizontal ? this.y.getWidth() : this.y.getHeight();
        int width2 = zIsMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i);
            if (i < 0) {
                iMin = Math.min((width2 + this.n.f13051d) - width, iAbs);
            } else {
                if (this.n.f13051d + i <= 0) {
                    return i;
                }
                iMin = this.n.f13051d;
            }
        } else {
            if (i > 0) {
                return Math.min((width2 - this.n.f13051d) - width, i);
            }
            if (this.n.f13051d + i >= 0) {
                return i;
            }
            iMin = this.n.f13051d;
        }
        return -iMin;
    }

    public void a(int i) {
        int i2 = this.f13044e;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                removeAllViews();
                a();
            }
            this.f13044e = i;
            requestLayout();
        }
    }

    public void b(int i) {
        if (this.f13041b != i) {
            removeAllViews();
            this.f13041b = i;
            this.o = null;
            this.p = null;
            a();
            requestLayout();
        }
    }

    public void c(int i) {
        if (i == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i2 = this.f13042c;
        if (i2 != i) {
            if (i2 == 0 || i == 0) {
                removeAllViews();
                a();
            }
            this.f13042c = i;
            this.o = null;
            this.p = null;
            requestLayout();
        }
    }

    public void d(int i) {
        if (this.f13043d != i) {
            this.f13043d = i;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        h(i);
    }

    private void d() {
        int layoutDirection = getLayoutDirection();
        int i = this.f13041b;
        if (i == 0) {
            this.g = layoutDirection == 1;
            this.h = this.f13042c == 2;
            return;
        }
        if (i == 1) {
            this.g = layoutDirection != 1;
            this.h = this.f13042c == 2;
            return;
        }
        if (i == 2) {
            this.g = layoutDirection == 1;
            if (this.f13042c == 2) {
                this.g = !this.g;
            }
            this.h = false;
            return;
        }
        if (i != 3) {
            this.g = false;
            this.h = false;
        } else {
            this.g = layoutDirection == 1;
            if (this.f13042c == 2) {
                this.g = !this.g;
            }
            this.h = true;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements com.google.android.flexbox.b {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new h();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f13046e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f13047f;
        private int g;
        private float h;
        private int i;
        private int j;
        private int k;
        private int l;
        private boolean m;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13046e = WheelView.DividerConfig.FILL;
            this.f13047f = 1.0f;
            this.g = -1;
            this.h = -1.0f;
            this.k = 16777215;
            this.l = 16777215;
        }

        @Override // com.google.android.flexbox.b
        public void a(int i) {
            this.j = i;
        }

        @Override // com.google.android.flexbox.b
        public int d() {
            return this.g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.b
        public float g() {
            return this.f13047f;
        }

        @Override // com.google.android.flexbox.b
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.b
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.b
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.b
        public int n() {
            return this.i;
        }

        @Override // com.google.android.flexbox.b
        public int o() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.b
        public float q() {
            return this.f13046e;
        }

        @Override // com.google.android.flexbox.b
        public float r() {
            return this.h;
        }

        @Override // com.google.android.flexbox.b
        public boolean s() {
            return this.m;
        }

        @Override // com.google.android.flexbox.b
        public void setMinWidth(int i) {
            this.i = i;
        }

        @Override // com.google.android.flexbox.b
        public int t() {
            return this.k;
        }

        @Override // com.google.android.flexbox.b
        public int v() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.b
        public int w() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.f13046e);
            parcel.writeFloat(this.f13047f);
            parcel.writeInt(this.g);
            parcel.writeFloat(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.b
        public int x() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.b
        public int y() {
            return this.j;
        }

        @Override // com.google.android.flexbox.b
        public int z() {
            return this.l;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f13046e = WheelView.DividerConfig.FILL;
            this.f13047f = 1.0f;
            this.g = -1;
            this.h = -1.0f;
            this.k = 16777215;
            this.l = 16777215;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f13046e = WheelView.DividerConfig.FILL;
            this.f13047f = 1.0f;
            this.g = -1;
            this.h = -1.0f;
            this.k = 16777215;
            this.l = 16777215;
            this.f13046e = parcel.readFloat();
            this.f13047f = parcel.readFloat();
            this.g = parcel.readInt();
            this.h = parcel.readFloat();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.m = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    private boolean a(RecyclerView.t tVar, a aVar, c cVar) {
        int i;
        int iD;
        if (!tVar.d() && (i = this.r) != -1) {
            if (i >= 0 && i < tVar.a()) {
                aVar.f13048a = this.r;
                aVar.f13049b = this.j.f13070c[aVar.f13048a];
                c cVar2 = this.q;
                if (cVar2 != null && cVar2.b(tVar.a())) {
                    aVar.f13050c = this.o.f() + cVar.f13061b;
                    aVar.g = true;
                    aVar.f13049b = -1;
                    return true;
                }
                if (this.s == Integer.MIN_VALUE) {
                    View viewFindViewByPosition = findViewByPosition(this.r);
                    if (viewFindViewByPosition != null) {
                        if (this.o.b(viewFindViewByPosition) > this.o.g()) {
                            aVar.a();
                            return true;
                        }
                        if (this.o.d(viewFindViewByPosition) - this.o.f() < 0) {
                            aVar.f13050c = this.o.f();
                            aVar.f13052e = false;
                            return true;
                        }
                        if (this.o.b() - this.o.a(viewFindViewByPosition) >= 0) {
                            if (aVar.f13052e) {
                                iD = this.o.a(viewFindViewByPosition) + this.o.h();
                            } else {
                                iD = this.o.d(viewFindViewByPosition);
                            }
                            aVar.f13050c = iD;
                        } else {
                            aVar.f13050c = this.o.b();
                            aVar.f13052e = true;
                            return true;
                        }
                    } else {
                        if (getChildCount() > 0) {
                            aVar.f13052e = this.r < getPosition(getChildAt(0));
                        }
                        aVar.a();
                    }
                    return true;
                }
                if (isMainAxisDirectionHorizontal() || !this.g) {
                    aVar.f13050c = this.o.f() + this.s;
                } else {
                    aVar.f13050c = this.s - this.o.c();
                }
                return true;
            }
            this.r = -1;
            this.s = Integer.MIN_VALUE;
        }
        return false;
    }

    private void b(RecyclerView.t tVar, a aVar) {
        if (a(tVar, aVar, this.q) || a(tVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f13048a = 0;
        aVar.f13049b = 0;
    }

    private void c(RecyclerView.o oVar, b bVar) {
        int childCount;
        if (bVar.f13059f >= 0 && (childCount = getChildCount()) != 0) {
            int i = this.j.f13070c[getPosition(getChildAt(0))];
            if (i == -1) {
                return;
            }
            com.google.android.flexbox.c cVar = this.i.get(i);
            int i2 = i;
            int i3 = 0;
            int i4 = -1;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (!b(childAt, bVar.f13059f)) {
                    break;
                }
                if (cVar.p == getPosition(childAt)) {
                    if (i2 >= this.i.size() - 1) {
                        break;
                    }
                    i2 += bVar.i;
                    cVar = this.i.get(i2);
                    i4 = i3;
                }
                i3++;
            }
            i3 = i4;
            recycleChildren(oVar, 0, i3);
        }
    }

    private boolean b(View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.g) ? this.o.a(view) <= i : this.o.a() - this.o.d(view) <= i;
    }

    private void b(RecyclerView.o oVar, b bVar) {
        if (bVar.f13059f < 0) {
            return;
        }
        this.o.a();
        int unused = bVar.f13059f;
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        int i = childCount - 1;
        int i2 = this.j.f13070c[getPosition(getChildAt(i))];
        if (i2 == -1) {
            return;
        }
        com.google.android.flexbox.c cVar = this.i.get(i2);
        int i3 = childCount;
        int i4 = i;
        while (i4 >= 0) {
            View childAt = getChildAt(i4);
            if (!a(childAt, bVar.f13059f)) {
                break;
            }
            if (cVar.o == getPosition(childAt)) {
                if (i2 <= 0) {
                    break;
                }
                i2 += bVar.i;
                cVar = this.i.get(i2);
                i3 = i4;
            }
            i4--;
        }
        i4 = i3;
        recycleChildren(oVar, i4, i);
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f13045f = -1;
        this.i = new ArrayList();
        this.j = new e(this);
        this.n = new a();
        this.r = -1;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.u = Integer.MIN_VALUE;
        this.w = new SparseArray<>();
        this.z = -1;
        this.A = new e.a();
        RecyclerView.i.b properties = RecyclerView.i.getProperties(context, attributeSet, i, i2);
        int i3 = properties.f1858a;
        if (i3 != 0) {
            if (i3 == 1) {
                if (properties.f1860c) {
                    b(3);
                } else {
                    b(2);
                }
            }
        } else if (properties.f1860c) {
            b(1);
        } else {
            b(0);
        }
        c(1);
        a(4);
        setAutoMeasureEnabled(true);
        this.x = context;
    }

    private int d(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int c(com.google.android.flexbox.c r26, com.google.android.flexbox.FlexboxLayoutManager.b r27) {
        /*
            Method dump skipped, instruction units count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.c(com.google.android.flexbox.c, com.google.android.flexbox.FlexboxLayoutManager$b):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(com.google.android.flexbox.c r22, com.google.android.flexbox.FlexboxLayoutManager.b r23) {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.b(com.google.android.flexbox.c, com.google.android.flexbox.FlexboxLayoutManager$b):int");
    }

    private boolean a(RecyclerView.t tVar, a aVar) {
        View viewE;
        int iF;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.f13052e) {
            viewE = f(tVar.a());
        } else {
            viewE = e(tVar.a());
        }
        if (viewE == null) {
            return false;
        }
        aVar.a(viewE);
        if (!tVar.d() && supportsPredictiveItemAnimations()) {
            if (this.o.d(viewE) >= this.o.b() || this.o.a(viewE) < this.o.f()) {
                if (aVar.f13052e) {
                    iF = this.o.b();
                } else {
                    iF = this.o.f();
                }
                aVar.f13050c = iF;
            }
        }
        return true;
    }

    private View a(int i, int i2, int i3) {
        b();
        ensureLayoutState();
        int iF = this.o.f();
        int iB = this.o.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.o.d(childAt) >= iF && this.o.a(childAt) <= iB) {
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

    private int a(RecyclerView.o oVar, RecyclerView.t tVar, b bVar) {
        if (bVar.f13059f != Integer.MIN_VALUE) {
            if (bVar.f13054a < 0) {
                bVar.f13059f += bVar.f13054a;
            }
            a(oVar, bVar);
        }
        int i = bVar.f13054a;
        int iA = bVar.f13054a;
        int iA2 = 0;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        while (true) {
            if ((iA <= 0 && !this.m.f13055b) || !bVar.a(tVar, this.i)) {
                break;
            }
            com.google.android.flexbox.c cVar = this.i.get(bVar.f13056c);
            bVar.f13057d = cVar.o;
            iA2 += a(cVar, bVar);
            if (zIsMainAxisDirectionHorizontal || !this.g) {
                bVar.f13058e += cVar.a() * bVar.i;
            } else {
                bVar.f13058e -= cVar.a() * bVar.i;
            }
            iA -= cVar.a();
        }
        bVar.f13054a -= iA2;
        if (bVar.f13059f != Integer.MIN_VALUE) {
            bVar.f13059f += iA2;
            if (bVar.f13054a < 0) {
                bVar.f13059f += bVar.f13054a;
            }
            a(oVar, bVar);
        }
        return i - bVar.f13054a;
    }

    private void b(a aVar, boolean z, boolean z2) {
        if (!z2) {
            this.m.f13055b = false;
        } else {
            c();
        }
        if (!isMainAxisDirectionHorizontal() && this.g) {
            this.m.f13054a = (this.y.getWidth() - aVar.f13050c) - this.o.f();
        } else {
            this.m.f13054a = aVar.f13050c - this.o.f();
        }
        this.m.f13057d = aVar.f13048a;
        this.m.h = 1;
        this.m.i = -1;
        this.m.f13058e = aVar.f13050c;
        this.m.f13059f = Integer.MIN_VALUE;
        this.m.f13056c = aVar.f13049b;
        if (!z || aVar.f13049b <= 0 || this.i.size() <= aVar.f13049b) {
            return;
        }
        com.google.android.flexbox.c cVar = this.i.get(aVar.f13049b);
        b.f(this.m);
        this.m.f13057d -= cVar.b();
    }

    private void c() {
        int widthMode;
        if (isMainAxisDirectionHorizontal()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.m.f13055b = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private int c(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private void a(RecyclerView.o oVar, b bVar) {
        if (bVar.j) {
            if (bVar.i == -1) {
                b(oVar, bVar);
            } else {
                c(oVar, bVar);
            }
        }
    }

    private boolean a(View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.g) ? this.o.d(view) >= this.o.a() - i : this.o.a(view) <= i;
    }

    private int a(com.google.android.flexbox.c cVar, b bVar) {
        if (isMainAxisDirectionHorizontal()) {
            return b(cVar, bVar);
        }
        return c(cVar, bVar);
    }

    private void b() {
        if (this.o != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.f13042c == 0) {
                this.o = J.a(this);
                this.p = J.b(this);
                return;
            } else {
                this.o = J.b(this);
                this.p = J.a(this);
                return;
            }
        }
        if (this.f13042c == 0) {
            this.o = J.b(this);
            this.p = J.a(this);
        } else {
            this.o = J.a(this);
            this.p = J.b(this);
        }
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (!z2) {
            this.m.f13055b = false;
        } else {
            c();
        }
        if (!isMainAxisDirectionHorizontal() && this.g) {
            this.m.f13054a = aVar.f13050c - getPaddingRight();
        } else {
            this.m.f13054a = this.o.b() - aVar.f13050c;
        }
        this.m.f13057d = aVar.f13048a;
        this.m.h = 1;
        this.m.i = 1;
        this.m.f13058e = aVar.f13050c;
        this.m.f13059f = Integer.MIN_VALUE;
        this.m.f13056c = aVar.f13049b;
        if (!z || this.i.size() <= 1 || aVar.f13049b < 0 || aVar.f13049b >= this.i.size() - 1) {
            return;
        }
        com.google.android.flexbox.c cVar = this.i.get(aVar.f13049b);
        b.e(this.m);
        this.m.f13057d += cVar.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View b(android.view.View r6, com.google.android.flexbox.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.isMainAxisDirectionHorizontal()
            int r1 = r5.getChildCount()
            int r1 = r1 + (-2)
            int r2 = r5.getChildCount()
            int r7 = r7.h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.getChildAt(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.g
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.J r3 = r5.o
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.J r4 = r5.o
            int r4 = r4.d(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.J r3 = r5.o
            int r3 = r3.a(r6)
            androidx.recyclerview.widget.J r4 = r5.o
            int r4 = r4.a(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.b(android.view.View, com.google.android.flexbox.c):android.view.View");
    }

    private int b(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    private int a(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        b();
        int i2 = 1;
        this.m.j = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.g;
        if (!z ? i <= 0 : i >= 0) {
            i2 = -1;
        }
        int iAbs = Math.abs(i);
        a(i2, iAbs);
        int iA = this.m.f13059f + a(oVar, tVar, this.m);
        if (iA < 0) {
            return 0;
        }
        if (z) {
            if (iAbs > iA) {
                i = (-i2) * iA;
            }
        } else if (iAbs > iA) {
            i = i2 * iA;
        }
        this.o.a(-i);
        this.m.g = i;
        return i;
    }

    private void a(int i, int i2) {
        this.m.i = i;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !zIsMainAxisDirectionHorizontal && this.g;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.m.f13058e = this.o.a(childAt);
            int position = getPosition(childAt);
            View viewB = b(childAt, this.i.get(this.j.f13070c[position]));
            this.m.h = 1;
            b bVar = this.m;
            bVar.f13057d = position + bVar.h;
            if (this.j.f13070c.length <= this.m.f13057d) {
                this.m.f13056c = -1;
            } else {
                b bVar2 = this.m;
                bVar2.f13056c = this.j.f13070c[bVar2.f13057d];
            }
            if (z) {
                this.m.f13058e = this.o.d(viewB);
                this.m.f13059f = (-this.o.d(viewB)) + this.o.f();
                b bVar3 = this.m;
                bVar3.f13059f = bVar3.f13059f >= 0 ? this.m.f13059f : 0;
            } else {
                this.m.f13058e = this.o.a(viewB);
                this.m.f13059f = this.o.a(viewB) - this.o.b();
            }
            if ((this.m.f13056c == -1 || this.m.f13056c > this.i.size() - 1) && this.m.f13057d <= getFlexItemCount()) {
                int i3 = i2 - this.m.f13059f;
                this.A.a();
                if (i3 > 0) {
                    if (zIsMainAxisDirectionHorizontal) {
                        this.j.a(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i3, this.m.f13057d, this.i);
                    } else {
                        this.j.c(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i3, this.m.f13057d, this.i);
                    }
                    this.j.b(iMakeMeasureSpec, iMakeMeasureSpec2, this.m.f13057d);
                    this.j.d(this.m.f13057d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.m.f13058e = this.o.d(childAt2);
            int position2 = getPosition(childAt2);
            View viewA = a(childAt2, this.i.get(this.j.f13070c[position2]));
            this.m.h = 1;
            int i4 = this.j.f13070c[position2];
            if (i4 == -1) {
                i4 = 0;
            }
            if (i4 > 0) {
                this.m.f13057d = position2 - this.i.get(i4 - 1).b();
            } else {
                this.m.f13057d = -1;
            }
            this.m.f13056c = i4 > 0 ? i4 - 1 : 0;
            if (z) {
                this.m.f13058e = this.o.a(viewA);
                this.m.f13059f = this.o.a(viewA) - this.o.b();
                b bVar4 = this.m;
                bVar4.f13059f = bVar4.f13059f >= 0 ? this.m.f13059f : 0;
            } else {
                this.m.f13058e = this.o.d(viewA);
                this.m.f13059f = (-this.o.d(viewA)) + this.o.f();
            }
        }
        b bVar5 = this.m;
        bVar5.f13054a = i2 - bVar5.f13059f;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View a(android.view.View r6, com.google.android.flexbox.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.isMainAxisDirectionHorizontal()
            int r7 = r7.h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.getChildAt(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.g
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.J r3 = r5.o
            int r3 = r3.a(r6)
            androidx.recyclerview.widget.J r4 = r5.o
            int r4 = r4.a(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.J r3 = r5.o
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.J r4 = r5.o
            int r4 = r4.d(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.a(android.view.View, com.google.android.flexbox.c):android.view.View");
    }

    private void a() {
        this.i.clear();
        this.n.b();
        this.n.f13051d = 0;
    }

    private int a(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private boolean a(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iB = b(view);
        int iD = d(view);
        int iC = c(view);
        int iA = a(view);
        return z ? (paddingLeft <= iB && width >= iC) && (paddingTop <= iD && height >= iA) : (iB >= width || iC >= paddingLeft) && (iD >= height || iA >= paddingTop);
    }

    private View a(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            if (a(childAt, z)) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }
}
