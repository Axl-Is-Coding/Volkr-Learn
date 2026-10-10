package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.On, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1832On extends RelativeLayout {
    public static String[] A03;

    @Nullable
    public C7Q A00;
    public WeakReference<InterfaceC1831Om> A01;
    public final PZ A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"Z7YDROQZDOzGgLZ6JRzm0VB6SZj4zDor", "PEDxZ1hmcJv2HtokqPZuboN03zqPqfuu", "ZN3aiXgGzfL", "UoQOzdqMFdmvRVk6jZTbQbhJ01APWmUd", "BWydKlRDXGFiivyHlYlBLR13h8bygoZy", "calSGpe10AH6YV6oPZJsWkhcYoOFDSm8", "CqyCvSup05V", "6oqVw1T1HmkJfSZKyFG8rr7XXeYSScI0"};
    }

    public C1832On(C2026Wb c2026Wb, PZ pz) {
        super(c2026Wb);
        this.A02 = pz;
        LX.A0M((View) this.A02);
        addView(this.A02.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void A01(AbstractC1716Jx abstractC1716Jx) {
        addView(abstractC1716Jx, new RelativeLayout.LayoutParams(-1, -1));
        this.A00 = (C7Q) abstractC1716Jx;
    }

    public final void A02(AbstractC1716Jx abstractC1716Jx) {
        LX.A0M(abstractC1716Jx);
        this.A00 = null;
    }

    public final boolean A03() {
        return this.A02.A7T();
    }

    public final boolean A04(int i) {
        return this.A02.getCurrentPosition() > i;
    }

    public int getCurrentPosition() {
        return this.A02.getCurrentPosition();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ((View) this.A02).layout(0, 0, getWidth(), getHeight());
        C7Q c7q = this.A00;
        if (c7q != null) {
            c7q.layout(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
    @Override // android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1832On.onMeasure(int, int):void");
    }

    public void setViewImplInflationListener(InterfaceC1831Om interfaceC1831Om) {
        this.A01 = new WeakReference<>(interfaceC1831Om);
    }
}
