package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: AnimateLayoutChangeDetector.java */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f2434a = new ViewGroup.MarginLayoutParams(-1, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayoutManager f2435b;

    static {
        f2434a.setMargins(0, 0, 0, 0);
    }

    b(LinearLayoutManager linearLayoutManager) {
        this.f2435b = linearLayoutManager;
    }

    private boolean b() {
        int top;
        int i;
        int bottom;
        int i2;
        int childCount = this.f2435b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f2435b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, childCount, 2);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f2435b.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f2434a;
            int[] iArr2 = iArr[i3];
            if (z) {
                top = childAt.getLeft();
                i = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i;
            int[] iArr3 = iArr[i3];
            if (z) {
                bottom = childAt.getRight();
                i2 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i2 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i2;
        }
        Arrays.sort(iArr, new a(this));
        for (int i4 = 1; i4 < childCount; i4++) {
            if (iArr[i4 - 1][1] != iArr[i4][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    private boolean c() {
        int childCount = this.f2435b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(this.f2435b.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    boolean a() {
        return (!b() || this.f2435b.getChildCount() <= 1) && c();
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
