package com.sandboxol.vip.d.b.a;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ScalePageTransformer.java */
/* JADX INFO: loaded from: classes4.dex */
public class i implements ViewPager.f {
    @Override // androidx.viewpager.widget.ViewPager.f
    public void a(View view, float f2) {
        if (f2 < -1.0f) {
            f2 = -1.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        view.setScaleY(((f2 < WheelView.DividerConfig.FILL ? f2 + 1.0f : 1.0f - f2) * 0.125f) + 0.875f);
    }
}
