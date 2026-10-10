package com.scwang.smartrefresh.layout.c;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.view.l;
import androidx.core.view.p;
import androidx.core.view.u;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: compiled from: SmartUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19137a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f19138b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static float f19139c = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f19140d = 1.0f / b(1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f19141e = 1.0f - (f19140d * b(1.0f));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19142f;

    public c(int i) {
        this.f19142f = i;
    }

    public static void a(AbsListView absListView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i);
            return;
        }
        if (!(absListView instanceof ListView)) {
            absListView.smoothScrollBy(i, 0);
            return;
        }
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }

    public static boolean b(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof u) || (view instanceof WebView) || (view instanceof l);
    }

    public static int c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, FileTypeUtils.GIGABYTE) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (this.f19142f == f19138b) {
            float f3 = 1.0f - f2;
            return 1.0f - (f3 * f3);
        }
        float fB = f19140d * b(f2);
        return fB > WheelView.DividerConfig.FILL ? fB + f19141e : fB;
    }

    public static void b(View view, int i) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i);
            return;
        }
        if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i);
        }
    }

    public static boolean a(View view) {
        return b(view) || (view instanceof ViewPager) || (view instanceof p);
    }

    public static boolean a(View view, PointF pointF) {
        if (a(view, -1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                if ("fixed".equals(childAt.getTag()) || "fixed-bottom".equals(childAt.getTag())) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean zA = a(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return zA;
            }
        }
        return true;
    }

    private static float b(float f2) {
        float f3 = f2 * 8.0f;
        if (f3 < 1.0f) {
            return f3 - (1.0f - ((float) Math.exp(-f3)));
        }
        return ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
    }

    public static boolean a(View view, PointF pointF, boolean z) {
        if (a(view, 1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !b(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ("fixed".equals(childAt.getTag()) || "fixed-top".equals(childAt.getTag())) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean zA = a(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return zA;
                }
            }
        }
        return z || a(view, -1);
    }

    public static boolean a(View view, int i) {
        int i2;
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return i > 0 ? view.getScrollY() < 0 : view.getScrollY() > 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            int childCount = viewGroup.getChildCount();
            return i > 0 ? childCount > 0 && (absListView.getLastVisiblePosition() < (i2 = childCount - 1) || viewGroup.getChildAt(i2).getBottom() > view.getPaddingBottom()) : childCount > 0 && (absListView.getFirstVisiblePosition() > 0 || viewGroup.getChildAt(0).getTop() < view.getPaddingTop());
        }
        return view.canScrollVertically(i);
    }

    public static boolean a(View view, View view2, float f2, float f3, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f2, f3};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z = fArr[0] >= WheelView.DividerConfig.FILL && fArr[1] >= WheelView.DividerConfig.FILL && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f2, fArr[1] - f3);
        }
        return z;
    }

    public static int a(float f2) {
        return (int) ((f2 * f19139c) + 0.5f);
    }

    public static float a(int i) {
        return i / f19139c;
    }
}
