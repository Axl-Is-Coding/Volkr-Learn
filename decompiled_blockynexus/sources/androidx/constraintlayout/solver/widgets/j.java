package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: Guideline.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends ConstraintWidget {
    protected float va = -1.0f;
    protected int wa = -1;
    protected int xa = -1;
    private ConstraintAnchor ya = this.w;
    private int za = 0;
    private boolean Aa = false;
    private int Ba = 0;
    private m Ca = new m();
    private int Da = 8;

    public j() {
        this.E.clear();
        this.E.add(this.ya);
        int length = this.D.length;
        for (int i = 0; i < length; i++) {
            this.D[i] = this.ya;
        }
    }

    public int J() {
        return this.za;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (i.f862a[type.ordinal()]) {
            case 1:
            case 2:
                if (this.za == 1) {
                    return this.ya;
                }
                break;
            case 3:
            case 4:
                if (this.za == 0) {
                    return this.ya;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ArrayList<ConstraintAnchor> b() {
        return this.E;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void c(androidx.constraintlayout.solver.e eVar) {
        if (k() == null) {
            return;
        }
        int iB = eVar.b(this.ya);
        if (this.za == 1) {
            r(iB);
            s(0);
            g(k().i());
            o(0);
            return;
        }
        r(0);
        s(iB);
        o(k().s());
        g(0);
    }

    public void e(float f2) {
        if (f2 > -1.0f) {
            this.va = f2;
            this.wa = -1;
            this.xa = -1;
        }
    }

    public void t(int i) {
        if (i > -1) {
            this.va = -1.0f;
            this.wa = i;
            this.xa = -1;
        }
    }

    public void u(int i) {
        if (i > -1) {
            this.va = -1.0f;
            this.wa = -1;
            this.xa = i;
        }
    }

    public void v(int i) {
        if (this.za == i) {
            return;
        }
        this.za = i;
        this.E.clear();
        if (this.za == 1) {
            this.ya = this.v;
        } else {
            this.ya = this.w;
        }
        this.E.add(this.ya);
        int length = this.D.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.D[i2] = this.ya;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(int i) {
        ConstraintWidget constraintWidgetK = k();
        if (constraintWidgetK == null) {
            return;
        }
        if (J() == 1) {
            this.w.d().a(1, constraintWidgetK.w.d(), 0);
            this.y.d().a(1, constraintWidgetK.w.d(), 0);
            if (this.wa != -1) {
                this.v.d().a(1, constraintWidgetK.v.d(), this.wa);
                this.x.d().a(1, constraintWidgetK.v.d(), this.wa);
                return;
            } else if (this.xa != -1) {
                this.v.d().a(1, constraintWidgetK.x.d(), -this.xa);
                this.x.d().a(1, constraintWidgetK.x.d(), -this.xa);
                return;
            } else {
                if (this.va == -1.0f || constraintWidgetK.j() != ConstraintWidget.DimensionBehaviour.FIXED) {
                    return;
                }
                int i2 = (int) (constraintWidgetK.H * this.va);
                this.v.d().a(1, constraintWidgetK.v.d(), i2);
                this.x.d().a(1, constraintWidgetK.v.d(), i2);
                return;
            }
        }
        this.v.d().a(1, constraintWidgetK.v.d(), 0);
        this.x.d().a(1, constraintWidgetK.v.d(), 0);
        if (this.wa != -1) {
            this.w.d().a(1, constraintWidgetK.w.d(), this.wa);
            this.y.d().a(1, constraintWidgetK.w.d(), this.wa);
        } else if (this.xa != -1) {
            this.w.d().a(1, constraintWidgetK.y.d(), -this.xa);
            this.y.d().a(1, constraintWidgetK.y.d(), -this.xa);
        } else {
            if (this.va == -1.0f || constraintWidgetK.q() != ConstraintWidget.DimensionBehaviour.FIXED) {
                return;
            }
            int i3 = (int) (constraintWidgetK.I * this.va);
            this.w.d().a(1, constraintWidgetK.w.d(), i3);
            this.y.d().a(1, constraintWidgetK.w.d(), i3);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(androidx.constraintlayout.solver.e eVar) {
        g gVar = (g) k();
        if (gVar == null) {
            return;
        }
        ConstraintAnchor constraintAnchorA = gVar.a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorA2 = gVar.a(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.G;
        boolean z = constraintWidget != null && constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.za == 0) {
            constraintAnchorA = gVar.a(ConstraintAnchor.Type.TOP);
            constraintAnchorA2 = gVar.a(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.G;
            z = constraintWidget2 != null && constraintWidget2.F[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.wa != -1) {
            SolverVariable solverVariableA = eVar.a(this.ya);
            eVar.a(solverVariableA, eVar.a(constraintAnchorA), this.wa, 6);
            if (z) {
                eVar.b(eVar.a(constraintAnchorA2), solverVariableA, 0, 5);
                return;
            }
            return;
        }
        if (this.xa == -1) {
            if (this.va != -1.0f) {
                eVar.a(androidx.constraintlayout.solver.e.a(eVar, eVar.a(this.ya), eVar.a(constraintAnchorA), eVar.a(constraintAnchorA2), this.va, this.Aa));
                return;
            }
            return;
        }
        SolverVariable solverVariableA2 = eVar.a(this.ya);
        SolverVariable solverVariableA3 = eVar.a(constraintAnchorA2);
        eVar.a(solverVariableA2, solverVariableA3, -this.xa, 6);
        if (z) {
            eVar.b(solverVariableA2, eVar.a(constraintAnchorA), 0, 5);
            eVar.b(solverVariableA3, solverVariableA2, 0, 5);
        }
    }
}
