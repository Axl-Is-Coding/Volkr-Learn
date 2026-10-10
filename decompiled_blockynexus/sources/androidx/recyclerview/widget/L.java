package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: PagerSnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class L extends ba {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private J f1819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private J f1820e;

    private J d(RecyclerView.i iVar) {
        J j = this.f1820e;
        if (j == null || j.f1815a != iVar) {
            this.f1820e = J.a(iVar);
        }
        return this.f1820e;
    }

    private J e(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return f(iVar);
        }
        if (iVar.canScrollHorizontally()) {
            return d(iVar);
        }
        return null;
    }

    private J f(RecyclerView.i iVar) {
        J j = this.f1819d;
        if (j == null || j.f1815a != iVar) {
            this.f1819d = J.b(iVar);
        }
        return this.f1819d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean g(RecyclerView.i iVar) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = iVar.getItemCount();
        if (!(iVar instanceof RecyclerView.s.b) || (pointFComputeScrollVectorForPosition = ((RecyclerView.s.b) iVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return pointFComputeScrollVectorForPosition.x < WheelView.DividerConfig.FILL || pointFComputeScrollVectorForPosition.y < WheelView.DividerConfig.FILL;
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
            iArr[1] = a(iVar, view, f(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.ba
    protected E b(RecyclerView.i iVar) {
        if (iVar instanceof RecyclerView.s.b) {
            return new K(this, this.f1951a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.ba
    public View c(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return a(iVar, f(iVar));
        }
        if (iVar.canScrollHorizontally()) {
            return a(iVar, d(iVar));
        }
        return null;
    }

    private boolean c(RecyclerView.i iVar, int i, int i2) {
        return iVar.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    @Override // androidx.recyclerview.widget.ba
    public int a(RecyclerView.i iVar, int i, int i2) {
        J jE;
        int itemCount = iVar.getItemCount();
        if (itemCount == 0 || (jE = e(iVar)) == null) {
            return -1;
        }
        int childCount = iVar.getChildCount();
        View view = null;
        View view2 = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = iVar.getChildAt(i5);
            if (childAt != null) {
                int iA = a(iVar, childAt, jE);
                if (iA <= 0 && iA > i3) {
                    view2 = childAt;
                    i3 = iA;
                }
                if (iA >= 0 && iA < i4) {
                    view = childAt;
                    i4 = iA;
                }
            }
        }
        boolean zC = c(iVar, i, i2);
        if (zC && view != null) {
            return iVar.getPosition(view);
        }
        if (!zC && view2 != null) {
            return iVar.getPosition(view2);
        }
        if (!zC) {
            view2 = view;
        }
        if (view2 == null) {
            return -1;
        }
        int position = iVar.getPosition(view2) + (g(iVar) == zC ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    private int a(RecyclerView.i iVar, View view, J j) {
        return (j.d(view) + (j.b(view) / 2)) - (j.f() + (j.g() / 2));
    }

    private View a(RecyclerView.i iVar, J j) {
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
}
