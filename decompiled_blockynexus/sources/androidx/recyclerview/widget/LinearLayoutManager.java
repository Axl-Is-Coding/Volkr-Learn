package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.analytics.pro.m;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.i implements ItemTouchHelper.d, RecyclerView.s.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    J mOrientationHelper;
    d mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1829d;

        protected b() {
        }

        void a() {
            this.f1826a = 0;
            this.f1827b = false;
            this.f1828c = false;
            this.f1829d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1834e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1835f;
        int g;
        int k;
        boolean m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1830a = true;
        int h = 0;
        int i = 0;
        boolean j = false;
        List<RecyclerView.w> l = null;

        c() {
        }

        private View b() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = this.l.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.f1833d == layoutParams.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        boolean a(RecyclerView.t tVar) {
            int i = this.f1833d;
            return i >= 0 && i < tVar.a();
        }

        View a(RecyclerView.o oVar) {
            if (this.l != null) {
                return b();
            }
            View viewD = oVar.d(this.f1833d);
            this.f1833d += this.f1834e;
            return viewD;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View viewB = b(view);
            if (viewB == null) {
                this.f1833d = -1;
            } else {
                this.f1833d = ((RecyclerView.LayoutParams) viewB.getLayoutParams()).a();
            }
        }

        public View b(View view) {
            int iA;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.l.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (iA = (layoutParams.a() - this.f1833d) * this.f1834e) >= 0 && iA < i) {
                    if (iA == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = iA;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new D();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1838c;

        public d() {
        }

        boolean a() {
            return this.f1836a >= 0;
        }

        void b() {
            this.f1836a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1836a);
            parcel.writeInt(this.f1837b);
            parcel.writeInt(this.f1838c ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f1836a = parcel.readInt();
            this.f1837b = parcel.readInt();
            this.f1838c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f1836a = dVar.f1836a;
            this.f1837b = dVar.f1837b;
            this.f1838c = dVar.f1838c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return X.a(tVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return X.a(tVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return X.b(tVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.o oVar, RecyclerView.t tVar) {
        return findReferenceChild(oVar, tVar, 0, getChildCount(), tVar.a());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.o oVar, RecyclerView.t tVar) {
        return findReferenceChild(oVar, tVar, getChildCount() - 1, -1, tVar.a());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.o oVar, RecyclerView.t tVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(oVar, tVar) : findLastReferenceChild(oVar, tVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.o oVar, RecyclerView.t tVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(oVar, tVar) : findFirstReferenceChild(oVar, tVar);
    }

    private int fixLayoutEndGap(int i, RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int iB;
        int iB2 = this.mOrientationHelper.b() - i;
        if (iB2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-iB2, oVar, tVar);
        int i3 = i + i2;
        if (!z || (iB = this.mOrientationHelper.b() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.a(iB);
        return iB + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.o oVar, RecyclerView.t tVar, boolean z) {
        int iF;
        int iF2 = i - this.mOrientationHelper.f();
        if (iF2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(iF2, oVar, tVar);
        int i3 = i + i2;
        if (!z || (iF = i3 - this.mOrientationHelper.f()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.a(-iF);
        return i2 - iF;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.o oVar, RecyclerView.t tVar, int i, int i2) {
        if (!tVar.e() || getChildCount() == 0 || tVar.d() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.w> listF = oVar.f();
        int size = listF.size();
        int position = getPosition(getChildAt(0));
        int iB = 0;
        int iB2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.w wVar = listF.get(i3);
            if (!wVar.isRemoved()) {
                if (((wVar.getLayoutPosition() < position) != this.mShouldReverseLayout ? (byte) -1 : (byte) 1) == -1) {
                    iB += this.mOrientationHelper.b(wVar.itemView);
                } else {
                    iB2 += this.mOrientationHelper.b(wVar.itemView);
                }
            }
        }
        this.mLayoutState.l = listF;
        if (iB > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            c cVar = this.mLayoutState;
            cVar.h = iB;
            cVar.f1832c = 0;
            cVar.a();
            fill(oVar, this.mLayoutState, tVar, false);
        }
        if (iB2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            c cVar2 = this.mLayoutState;
            cVar2.h = iB2;
            cVar2.f1832c = 0;
            cVar2.a();
            fill(oVar, this.mLayoutState, tVar, false);
        }
        this.mLayoutState.l = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.d(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.o oVar, c cVar) {
        if (!cVar.f1830a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f1835f == -1) {
            recycleViewsFromEnd(oVar, i, i2);
        } else {
            recycleViewsFromStart(oVar, i, i2);
        }
    }

    private void recycleChildren(RecyclerView.o oVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, oVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, oVar);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.o oVar, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int iA = (this.mOrientationHelper.a() - i) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.d(childAt) < iA || this.mOrientationHelper.f(childAt) < iA) {
                    recycleChildren(oVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.d(childAt2) < iA || this.mOrientationHelper.f(childAt2) < iA) {
                recycleChildren(oVar, i4, i5);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.o oVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.a(childAt) > i3 || this.mOrientationHelper.e(childAt) > i3) {
                    recycleChildren(oVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.a(childAt2) > i3 || this.mOrientationHelper.e(childAt2) > i3) {
                recycleChildren(oVar, i5, i6);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.o oVar, RecyclerView.t tVar, a aVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.a(focusedChild, tVar)) {
            aVar.b(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        View viewFindReferenceChildClosestToEnd = aVar.f1824d ? findReferenceChildClosestToEnd(oVar, tVar) : findReferenceChildClosestToStart(oVar, tVar);
        if (viewFindReferenceChildClosestToEnd == null) {
            return false;
        }
        aVar.a(viewFindReferenceChildClosestToEnd, getPosition(viewFindReferenceChildClosestToEnd));
        if (!tVar.d() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.d(viewFindReferenceChildClosestToEnd) >= this.mOrientationHelper.b() || this.mOrientationHelper.a(viewFindReferenceChildClosestToEnd) < this.mOrientationHelper.f()) {
                aVar.f1823c = aVar.f1824d ? this.mOrientationHelper.b() : this.mOrientationHelper.f();
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.t tVar, a aVar) {
        int i;
        if (!tVar.d() && (i = this.mPendingScrollPosition) != -1) {
            if (i >= 0 && i < tVar.a()) {
                aVar.f1822b = this.mPendingScrollPosition;
                d dVar = this.mPendingSavedState;
                if (dVar != null && dVar.a()) {
                    aVar.f1824d = this.mPendingSavedState.f1838c;
                    if (aVar.f1824d) {
                        aVar.f1823c = this.mOrientationHelper.b() - this.mPendingSavedState.f1837b;
                    } else {
                        aVar.f1823c = this.mOrientationHelper.f() + this.mPendingSavedState.f1837b;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z = this.mShouldReverseLayout;
                    aVar.f1824d = z;
                    if (z) {
                        aVar.f1823c = this.mOrientationHelper.b() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f1823c = this.mOrientationHelper.f() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        aVar.f1824d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    aVar.a();
                } else {
                    if (this.mOrientationHelper.b(viewFindViewByPosition) > this.mOrientationHelper.g()) {
                        aVar.a();
                        return true;
                    }
                    if (this.mOrientationHelper.d(viewFindViewByPosition) - this.mOrientationHelper.f() < 0) {
                        aVar.f1823c = this.mOrientationHelper.f();
                        aVar.f1824d = false;
                        return true;
                    }
                    if (this.mOrientationHelper.b() - this.mOrientationHelper.a(viewFindViewByPosition) < 0) {
                        aVar.f1823c = this.mOrientationHelper.b();
                        aVar.f1824d = true;
                        return true;
                    }
                    aVar.f1823c = aVar.f1824d ? this.mOrientationHelper.a(viewFindViewByPosition) + this.mOrientationHelper.h() : this.mOrientationHelper.d(viewFindViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.o oVar, RecyclerView.t tVar, a aVar) {
        if (updateAnchorFromPendingData(tVar, aVar) || updateAnchorFromChildren(oVar, tVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1822b = this.mStackFromEnd ? tVar.a() - 1 : 0;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.t tVar) {
        int iF;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f1835f = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(tVar, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i == 1;
        this.mLayoutState.h = z2 ? iMax2 : iMax;
        c cVar = this.mLayoutState;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.i = iMax;
        if (z2) {
            this.mLayoutState.h += this.mOrientationHelper.c();
            View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.f1834e = this.mShouldReverseLayout ? -1 : 1;
            c cVar2 = this.mLayoutState;
            int position = getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.f1833d = position + cVar3.f1834e;
            cVar3.f1831b = this.mOrientationHelper.a(childClosestToEnd);
            iF = this.mOrientationHelper.a(childClosestToEnd) - this.mOrientationHelper.b();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.h += this.mOrientationHelper.f();
            this.mLayoutState.f1834e = this.mShouldReverseLayout ? 1 : -1;
            c cVar4 = this.mLayoutState;
            int position2 = getPosition(childClosestToStart);
            c cVar5 = this.mLayoutState;
            cVar4.f1833d = position2 + cVar5.f1834e;
            cVar5.f1831b = this.mOrientationHelper.d(childClosestToStart);
            iF = (-this.mOrientationHelper.d(childClosestToStart)) + this.mOrientationHelper.f();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f1832c = i2;
        if (z) {
            cVar6.f1832c -= iF;
        }
        this.mLayoutState.g = iF;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f1822b, aVar.f1823c);
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f1822b, aVar.f1823c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    protected void calculateExtraLayoutSpace(RecyclerView.t tVar, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(tVar);
        if (this.mLayoutState.f1835f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, tVar);
        collectPrefetchPositionsForLayoutState(tVar, this.mLayoutState, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void collectInitialPrefetchPositions(int i, RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        d dVar = this.mPendingSavedState;
        if (dVar == null || !dVar.a()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.mPendingSavedState;
            z = dVar2.f1838c;
            i2 = dVar2.f1836a;
        }
        int i3 = z ? -1 : 1;
        int i4 = i2;
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i4 >= 0 && i4 < i; i5++) {
            aVar.a(i4, 0);
            i4 += i3;
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.t tVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.f1833d;
        if (i < 0 || i >= tVar.a()) {
            return;
        }
        aVar.a(i, Math.max(0, cVar.g));
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
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i2, WheelView.DividerConfig.FILL) : new PointF(WheelView.DividerConfig.FILL, i2);
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

    int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    c createLayoutState() {
        return new c();
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    int fill(RecyclerView.o oVar, c cVar, RecyclerView.t tVar, boolean z) {
        int i = cVar.f1832c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            recycleByLayoutState(oVar, cVar);
        }
        int i3 = cVar.f1832c + cVar.h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.a(tVar)) {
                break;
            }
            bVar.a();
            layoutChunk(oVar, tVar, cVar, bVar);
            if (!bVar.f1827b) {
                cVar.f1831b += bVar.f1826a * cVar.f1835f;
                if (!bVar.f1828c || cVar.l != null || !tVar.d()) {
                    int i4 = cVar.f1832c;
                    int i5 = bVar.f1826a;
                    cVar.f1832c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    cVar.g = i6 + bVar.f1826a;
                    int i7 = cVar.f1832c;
                    if (i7 < 0) {
                        cVar.g += i7;
                    }
                    recycleByLayoutState(oVar, cVar);
                }
                if (z && bVar.f1829d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f1832c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z, z2) : findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z, z2) : findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? (byte) 1 : i2 < i ? (byte) -1 : (byte) 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.d(getChildAt(i)) < this.mOrientationHelper.f()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = m.a.f20899a;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i, i2, i3, i4) : this.mVerticalBoundCheck.a(i, i2, i3, i4);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i, i2, i3, i4) : this.mVerticalBoundCheck.a(i, i2, i3, i4);
    }

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
            if (position >= 0 && position < i3) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.t tVar) {
        if (tVar.c()) {
            return this.mOrientationHelper.g();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.o oVar, RecyclerView.t tVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int paddingLeft;
        int iC;
        View viewA = cVar.a(oVar);
        if (viewA == null) {
            bVar.f1827b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewA.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f1835f == -1)) {
                addView(viewA);
            } else {
                addView(viewA, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f1835f == -1)) {
                addDisappearingView(viewA);
            } else {
                addDisappearingView(viewA, 0);
            }
        }
        measureChildWithMargins(viewA, 0, 0);
        bVar.f1826a = this.mOrientationHelper.b(viewA);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iC = getWidth() - getPaddingRight();
                paddingLeft = iC - this.mOrientationHelper.c(viewA);
            } else {
                paddingLeft = getPaddingLeft();
                iC = this.mOrientationHelper.c(viewA) + paddingLeft;
            }
            if (cVar.f1835f == -1) {
                int i4 = cVar.f1831b;
                i3 = i4;
                i2 = iC;
                i = i4 - bVar.f1826a;
            } else {
                int i5 = cVar.f1831b;
                i = i5;
                i2 = iC;
                i3 = bVar.f1826a + i5;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iC2 = this.mOrientationHelper.c(viewA) + paddingTop;
            if (cVar.f1835f == -1) {
                int i6 = cVar.f1831b;
                i2 = i6;
                i = paddingTop;
                i3 = iC2;
                paddingLeft = i6 - bVar.f1826a;
            } else {
                int i7 = cVar.f1831b;
                i = paddingTop;
                i2 = bVar.f1826a + i7;
                i3 = iC2;
                paddingLeft = i7;
            }
        }
        layoutDecoratedWithMargins(viewA, paddingLeft, i, i2, i3);
        if (layoutParams.c() || layoutParams.b()) {
            bVar.f1828c = true;
        }
        bVar.f1829d = viewA.hasFocusable();
    }

    void onAnchorReady(RecyclerView.o oVar, RecyclerView.t tVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.onDetachedFromWindow(recyclerView, oVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(oVar);
            oVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View onFocusSearchFailed(View view, int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        int iConvertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.g() * MAX_SCROLL_FACTOR), false, tVar);
        c cVar = this.mLayoutState;
        cVar.g = Integer.MIN_VALUE;
        cVar.f1830a = false;
        fill(oVar, cVar, tVar, true);
        View viewFindPartiallyOrCompletelyInvisibleChildClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutChildren(RecyclerView.o oVar, RecyclerView.t tVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iFixLayoutEndGap;
        int i5;
        View viewFindViewByPosition;
        int iD;
        int iB;
        int i6 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && tVar.a() == 0) {
            removeAndRecycleAllViews(oVar);
            return;
        }
        d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f1836a;
        }
        ensureLayoutState();
        this.mLayoutState.f1830a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.f1825e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.b();
            a aVar = this.mAnchorInfo;
            aVar.f1824d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(oVar, tVar, aVar);
            this.mAnchorInfo.f1825e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.d(focusedChild) >= this.mOrientationHelper.b() || this.mOrientationHelper.a(focusedChild) <= this.mOrientationHelper.f())) {
            this.mAnchorInfo.b(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f1835f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(tVar, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.f();
        int iMax2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.c();
        if (tVar.d() && (i5 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i5)) != null) {
            if (this.mShouldReverseLayout) {
                iB = this.mOrientationHelper.b() - this.mOrientationHelper.a(viewFindViewByPosition);
                iD = this.mPendingScrollPositionOffset;
            } else {
                iD = this.mOrientationHelper.d(viewFindViewByPosition) - this.mOrientationHelper.f();
                iB = this.mPendingScrollPositionOffset;
            }
            int i7 = iB - iD;
            if (i7 > 0) {
                iMax += i7;
            } else {
                iMax2 -= i7;
            }
        }
        if (!this.mAnchorInfo.f1824d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i6 = 1;
        }
        onAnchorReady(oVar, tVar, this.mAnchorInfo, i6);
        detachAndScrapAttachedViews(oVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.j = tVar.d();
        this.mLayoutState.i = 0;
        a aVar2 = this.mAnchorInfo;
        if (aVar2.f1824d) {
            updateLayoutStateToFillStart(aVar2);
            c cVar2 = this.mLayoutState;
            cVar2.h = iMax;
            fill(oVar, cVar2, tVar, false);
            c cVar3 = this.mLayoutState;
            i2 = cVar3.f1831b;
            int i8 = cVar3.f1833d;
            int i9 = cVar3.f1832c;
            if (i9 > 0) {
                iMax2 += i9;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.h = iMax2;
            cVar4.f1833d += cVar4.f1834e;
            fill(oVar, cVar4, tVar, false);
            c cVar5 = this.mLayoutState;
            i = cVar5.f1831b;
            int i10 = cVar5.f1832c;
            if (i10 > 0) {
                updateLayoutStateToFillStart(i8, i2);
                c cVar6 = this.mLayoutState;
                cVar6.h = i10;
                fill(oVar, cVar6, tVar, false);
                i2 = this.mLayoutState.f1831b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar2);
            c cVar7 = this.mLayoutState;
            cVar7.h = iMax2;
            fill(oVar, cVar7, tVar, false);
            c cVar8 = this.mLayoutState;
            i = cVar8.f1831b;
            int i11 = cVar8.f1833d;
            int i12 = cVar8.f1832c;
            if (i12 > 0) {
                iMax += i12;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.h = iMax;
            cVar9.f1833d += cVar9.f1834e;
            fill(oVar, cVar9, tVar, false);
            c cVar10 = this.mLayoutState;
            i2 = cVar10.f1831b;
            int i13 = cVar10.f1832c;
            if (i13 > 0) {
                updateLayoutStateToFillEnd(i11, i);
                c cVar11 = this.mLayoutState;
                cVar11.h = i13;
                fill(oVar, cVar11, tVar, false);
                i = this.mLayoutState.f1831b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i, oVar, tVar, true);
                i3 = i2 + iFixLayoutEndGap2;
                i4 = i + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i3, oVar, tVar, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i2, oVar, tVar, true);
                i3 = i2 + iFixLayoutStartGap;
                i4 = i + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i4, oVar, tVar, false);
            }
            i2 = i3 + iFixLayoutEndGap;
            i = i4 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(oVar, tVar, i2, i);
        if (tVar.d()) {
            this.mAnchorInfo.b();
        } else {
            this.mOrientationHelper.i();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutCompleted(RecyclerView.t tVar) {
        super.onLayoutCompleted(tVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.mPendingSavedState = (d) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable onSaveInstanceState() {
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            dVar2.f1838c = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                dVar2.f1837b = this.mOrientationHelper.b() - this.mOrientationHelper.a(childClosestToEnd);
                dVar2.f1836a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                dVar2.f1836a = getPosition(childClosestToStart);
                dVar2.f1837b = this.mOrientationHelper.d(childClosestToStart) - this.mOrientationHelper.f();
            }
        } else {
            dVar2.b();
        }
        return dVar2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.d
    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        byte b2 = position < position2 ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            if (b2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.b() - (this.mOrientationHelper.d(view2) + this.mOrientationHelper.b(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.b() - this.mOrientationHelper.a(view2));
                return;
            }
        }
        if (b2 == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.a(view2) - this.mOrientationHelper.b(view));
        }
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.d() == 0 && this.mOrientationHelper.a() == 0;
    }

    int scrollBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f1830a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        updateLayoutState(i2, iAbs, true, tVar);
        c cVar = this.mLayoutState;
        int iFill = cVar.g + fill(oVar, cVar, tVar, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i = i2 * iFill;
        }
        this.mOrientationHelper.a(-i);
        this.mLayoutState.k = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollHorizontallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, oVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollVerticallyBy(int i, RecyclerView.o oVar, RecyclerView.t tVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, oVar, tVar);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            this.mOrientationHelper = J.a(this, i);
            this.mAnchorInfo.f1821a = this.mOrientationHelper;
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        E e2 = new E(recyclerView.getContext());
        e2.setTargetPosition(i);
        startSmoothScroll(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iD = this.mOrientationHelper.d(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int iD2 = this.mOrientationHelper.d(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(iD2 < iD);
                    throw new RuntimeException(sb.toString());
                }
                if (iD2 > iD) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int iD3 = this.mOrientationHelper.d(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(iD3 < iD);
                throw new RuntimeException(sb2.toString());
            }
            if (iD3 < iD) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.f1832c = this.mOrientationHelper.b() - i2;
        this.mLayoutState.f1834e = this.mShouldReverseLayout ? -1 : 1;
        c cVar = this.mLayoutState;
        cVar.f1833d = i;
        cVar.f1835f = 1;
        cVar.f1831b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.f1832c = i2 - this.mOrientationHelper.f();
        c cVar = this.mLayoutState;
        cVar.f1833d = i;
        cVar.f1834e = this.mShouldReverseLayout ? 1 : -1;
        c cVar2 = this.mLayoutState;
        cVar2.f1835f = -1;
        cVar2.f1831b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        J f1821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1824d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1825e;

        a() {
            b();
        }

        void a() {
            this.f1823c = this.f1824d ? this.f1821a.b() : this.f1821a.f();
        }

        void b() {
            this.f1822b = -1;
            this.f1823c = Integer.MIN_VALUE;
            this.f1824d = false;
            this.f1825e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1822b + ", mCoordinate=" + this.f1823c + ", mLayoutFromEnd=" + this.f1824d + ", mValid=" + this.f1825e + '}';
        }

        boolean a(View view, RecyclerView.t tVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < tVar.a();
        }

        public void b(View view, int i) {
            int iH = this.f1821a.h();
            if (iH >= 0) {
                a(view, i);
                return;
            }
            this.f1822b = i;
            if (this.f1824d) {
                int iB = (this.f1821a.b() - iH) - this.f1821a.a(view);
                this.f1823c = this.f1821a.b() - iB;
                if (iB > 0) {
                    int iB2 = this.f1823c - this.f1821a.b(view);
                    int iF = this.f1821a.f();
                    int iMin = iB2 - (iF + Math.min(this.f1821a.d(view) - iF, 0));
                    if (iMin < 0) {
                        this.f1823c += Math.min(iB, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iD = this.f1821a.d(view);
            int iF2 = iD - this.f1821a.f();
            this.f1823c = iD;
            if (iF2 > 0) {
                int iB3 = (this.f1821a.b() - Math.min(0, (this.f1821a.b() - iH) - this.f1821a.a(view))) - (iD + this.f1821a.b(view));
                if (iB3 < 0) {
                    this.f1823c -= Math.min(iF2, -iB3);
                }
            }
        }

        public void a(View view, int i) {
            if (this.f1824d) {
                this.f1823c = this.f1821a.a(view) + this.f1821a.h();
            } else {
                this.f1823c = this.f1821a.d(view);
            }
            this.f1822b = i;
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.i.b properties = RecyclerView.i.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f1858a);
        setReverseLayout(properties.f1860c);
        setStackFromEnd(properties.f1861d);
    }
}
