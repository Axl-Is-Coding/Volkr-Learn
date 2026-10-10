package com.youth.banner;

import android.content.Context;
import android.widget.Scroller;
import com.sandboxol.vip.entity.VipDiamond;

/* JADX INFO: compiled from: BannerScroller.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends Scroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21403a;

    public b(Context context) {
        super(context);
        this.f21403a = VipDiamond.MVP;
    }

    public void a(int i) {
        this.f21403a = i;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f21403a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f21403a);
    }
}
