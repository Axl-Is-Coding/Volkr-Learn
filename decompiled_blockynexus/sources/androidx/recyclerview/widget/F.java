package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: LinearSnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class F extends ba {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private J f1786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private J f1787e;

    private View b(RecyclerView.i iVar, J j) {
        int childCount = iVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int iF = j.f() + (j.g() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = iVar.getChildAt(i2);
            int iAbs = Math.abs((j.d(childAt) + (j.b(childAt) / 2)) - iF);
            if (iAbs < i) {
                view = childAt;
                i = iAbs;
            }
        }
        return view;
    }

    private J d(RecyclerView.i iVar) {
        J j = this.f1787e;
        if (j == null || j.f1815a != iVar) {
            this.f1787e = J.a(iVar);
        }
        return this.f1787e;
    }

    private J e(RecyclerView.i iVar) {
        J j = this.f1786d;
        if (j == null || j.f1815a != iVar) {
            this.f1786d = J.b(iVar);
        }
        return this.f1786d;
    }

    @Override // androidx.recyclerview.widget.ba
    public int[] a(RecyclerView.i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = a(iVar, view, d(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = a(iVar, view, e(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.ba
    public View c(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return b(iVar, e(iVar));
        }
        if (iVar.canScrollHorizontally()) {
            return b(iVar, d(iVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ba
    public int a(RecyclerView.i iVar, int i, int i2) {
        int itemCount;
        View viewC;
        int position;
        int i3;
        PointF pointFComputeScrollVectorForPosition;
        int iA;
        int iA2;
        if (!(iVar instanceof RecyclerView.s.b) || (itemCount = iVar.getItemCount()) == 0 || (viewC = c(iVar)) == null || (position = iVar.getPosition(viewC)) == -1 || (pointFComputeScrollVectorForPosition = ((RecyclerView.s.b) iVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (iVar.canScrollHorizontally()) {
            iA = a(iVar, d(iVar), i, 0);
            if (pointFComputeScrollVectorForPosition.x < WheelView.DividerConfig.FILL) {
                iA = -iA;
            }
        } else {
            iA = 0;
        }
        if (iVar.canScrollVertically()) {
            iA2 = a(iVar, e(iVar), 0, i2);
            if (pointFComputeScrollVectorForPosition.y < WheelView.DividerConfig.FILL) {
                iA2 = -iA2;
            }
        } else {
            iA2 = 0;
        }
        if (iVar.canScrollVertically()) {
            iA = iA2;
        }
        if (iA == 0) {
            return -1;
        }
        int i4 = position + iA;
        if (i4 < 0) {
            i4 = 0;
        }
        return i4 >= itemCount ? i3 : i4;
    }

    private int a(RecyclerView.i iVar, View view, J j) {
        return (j.d(view) + (j.b(view) / 2)) - (j.f() + (j.g() / 2));
    }

    private int a(RecyclerView.i iVar, J j, int i, int i2) {
        int[] iArrB = b(i, i2);
        float fA = a(iVar, j);
        if (fA <= WheelView.DividerConfig.FILL) {
            return 0;
        }
        return Math.round((Math.abs(iArrB[0]) > Math.abs(iArrB[1]) ? iArrB[0] : iArrB[1]) / fA);
    }

    private float a(RecyclerView.i iVar, J j) {
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = iVar.getChildAt(i3);
            int position = iVar.getPosition(childAt);
            if (position != -1) {
                if (position < i) {
                    view = childAt;
                    i = position;
                }
                if (position > i2) {
                    view2 = childAt;
                    i2 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(j.a(view), j.a(view2)) - Math.min(j.d(view), j.d(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i2 - i) + 1);
    }
}
