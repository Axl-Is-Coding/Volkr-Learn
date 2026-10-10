package androidx.constraintlayout.solver.widgets;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ResolutionDimension.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f868c = WheelView.DividerConfig.FILL;

    public void a(int i) {
        if (this.f870b == 0 || this.f868c != i) {
            this.f868c = i;
            if (this.f870b == 1) {
                b();
            }
            a();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.p
    public void d() {
        super.d();
        this.f868c = WheelView.DividerConfig.FILL;
    }

    public void f() {
        this.f870b = 2;
    }
}
