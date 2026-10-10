package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ItemTouchUIUtilImpl.java */
/* JADX INFO: loaded from: classes.dex */
class B implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final A f1779a = new B();

    B() {
    }

    @Override // androidx.recyclerview.widget.A
    public void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float fValueOf = Float.valueOf(ViewCompat.i(view));
            ViewCompat.a(view, a(recyclerView, view) + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }

    @Override // androidx.recyclerview.widget.A
    public void b(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i, boolean z) {
    }

    @Override // androidx.recyclerview.widget.A
    public void b(View view) {
    }

    private static float a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f2 = WheelView.DividerConfig.FILL;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float fI = ViewCompat.i(childAt);
                if (fI > f2) {
                    f2 = fI;
                }
            }
        }
        return f2;
    }

    @Override // androidx.recyclerview.widget.A
    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                ViewCompat.a(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, null);
        }
        view.setTranslationX(WheelView.DividerConfig.FILL);
        view.setTranslationY(WheelView.DividerConfig.FILL);
    }
}
