package com.sandboxol.vip.a;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: BottomSheetViewBindingAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    static /* synthetic */ void a(View view, int i) {
        if (view.getParent() instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view.getParent();
            ViewPager viewPager = (ViewPager) coordinatorLayout.findViewById(R.id.vp_vip_type);
            view.setBackgroundColor(com.sandboxol.vip.c.b.a(i));
            BottomSheetBehavior.b(view).c(coordinatorLayout.getHeight() - viewPager.getHeight());
        }
    }

    public static void b(final View view, final int i) {
        if (view == null || view.getParent() == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.sandboxol.vip.a.a
            @Override // java.lang.Runnable
            public final void run() {
                b.a(view, i);
            }
        });
    }
}
