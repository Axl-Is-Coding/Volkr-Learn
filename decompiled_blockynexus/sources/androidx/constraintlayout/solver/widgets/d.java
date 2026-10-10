package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;

/* JADX INFO: compiled from: ChainHead.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ConstraintWidget f847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ConstraintWidget f848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ConstraintWidget f849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ConstraintWidget f850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ConstraintWidget f851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ConstraintWidget f852f;
    protected ConstraintWidget g;
    protected ArrayList<ConstraintWidget> h;
    protected int i;
    protected int j;
    protected float k = WheelView.DividerConfig.FILL;
    private int l;
    private boolean m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    private boolean q;

    public d(ConstraintWidget constraintWidget, int i, boolean z) {
        this.m = false;
        this.f847a = constraintWidget;
        this.l = i;
        this.m = z;
    }

    private static boolean a(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.r() != 8 && constraintWidget.F[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.h;
            if (iArr[i] == 0 || iArr[i] == 3) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        int i = this.l * 2;
        boolean z = false;
        ConstraintWidget constraintWidget = this.f847a;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.sa;
            int i2 = this.l;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i2] = null;
            constraintWidget.ra[i2] = null;
            if (constraintWidget.r() != 8) {
                if (this.f848b == null) {
                    this.f848b = constraintWidget;
                }
                this.f850d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.F;
                int i3 = this.l;
                if (dimensionBehaviourArr[i3] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int[] iArr = constraintWidget.h;
                    if (iArr[i3] == 0 || iArr[i3] == 3 || iArr[i3] == 2) {
                        this.j++;
                        float[] fArr = constraintWidget.qa;
                        int i4 = this.l;
                        float f2 = fArr[i4];
                        if (f2 > WheelView.DividerConfig.FILL) {
                            this.k += fArr[i4];
                        }
                        if (a(constraintWidget, this.l)) {
                            if (f2 < WheelView.DividerConfig.FILL) {
                                this.n = true;
                            } else {
                                this.o = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(constraintWidget);
                        }
                        if (this.f852f == null) {
                            this.f852f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.ra[this.l] = constraintWidget;
                        }
                        this.g = constraintWidget;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.sa[this.l] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.D[i + 1].f838d;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f836b;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.D;
                if (constraintAnchorArr[i].f838d != null && constraintAnchorArr[i].f838d.f836b == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        this.f849c = constraintWidget;
        if (this.l == 0 && this.m) {
            this.f851e = this.f849c;
        } else {
            this.f851e = this.f847a;
        }
        if (this.o && this.n) {
            z = true;
        }
        this.p = z;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
