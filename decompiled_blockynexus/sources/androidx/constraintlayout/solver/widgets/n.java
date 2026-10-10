package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ResolutionAnchor.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ConstraintAnchor f864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    n f866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f867f;
    n g;
    float h;
    private n j;
    private float k;
    int i = 0;
    private o l = null;
    private int m = 1;
    private o n = null;
    private int o = 1;

    public n(ConstraintAnchor constraintAnchor) {
        this.f864c = constraintAnchor;
    }

    String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(n nVar, float f2) {
        if (this.f870b == 0 || !(this.g == nVar || this.h == f2)) {
            this.g = nVar;
            this.h = f2;
            if (this.f870b == 1) {
                b();
            }
            a();
        }
    }

    public void b(int i) {
        this.i = i;
    }

    @Override // androidx.constraintlayout.solver.widgets.p
    public void d() {
        super.d();
        this.f866e = null;
        this.f867f = WheelView.DividerConfig.FILL;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.g = null;
        this.h = WheelView.DividerConfig.FILL;
        this.f865d = WheelView.DividerConfig.FILL;
        this.j = null;
        this.k = WheelView.DividerConfig.FILL;
        this.i = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.p
    public void e() {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        n nVar6;
        float f2;
        float f3;
        float fS;
        float f4;
        n nVar7;
        boolean z = true;
        if (this.f870b == 1 || this.i == 4) {
            return;
        }
        o oVar = this.l;
        if (oVar != null) {
            if (oVar.f870b != 1) {
                return;
            } else {
                this.f867f = this.m * oVar.f868c;
            }
        }
        o oVar2 = this.n;
        if (oVar2 != null) {
            if (oVar2.f870b != 1) {
                return;
            } else {
                this.k = this.o * oVar2.f868c;
            }
        }
        if (this.i == 1 && ((nVar7 = this.f866e) == null || nVar7.f870b == 1)) {
            n nVar8 = this.f866e;
            if (nVar8 == null) {
                this.g = this;
                this.h = this.f867f;
            } else {
                this.g = nVar8.g;
                this.h = nVar8.h + this.f867f;
            }
            a();
            return;
        }
        if (this.i != 2 || (nVar4 = this.f866e) == null || nVar4.f870b != 1 || (nVar5 = this.j) == null || (nVar6 = nVar5.f866e) == null || nVar6.f870b != 1) {
            if (this.i != 3 || (nVar = this.f866e) == null || nVar.f870b != 1 || (nVar2 = this.j) == null || (nVar3 = nVar2.f866e) == null || nVar3.f870b != 1) {
                if (this.i == 5) {
                    this.f864c.f836b.G();
                    return;
                }
                return;
            }
            if (androidx.constraintlayout.solver.e.e() != null) {
                androidx.constraintlayout.solver.e.e().w++;
            }
            n nVar9 = this.f866e;
            this.g = nVar9.g;
            n nVar10 = this.j;
            n nVar11 = nVar10.f866e;
            nVar10.g = nVar11.g;
            this.h = nVar9.h + this.f867f;
            nVar10.h = nVar11.h + nVar10.f867f;
            a();
            this.j.a();
            return;
        }
        if (androidx.constraintlayout.solver.e.e() != null) {
            androidx.constraintlayout.solver.e.e().v++;
        }
        this.g = this.f866e.g;
        n nVar12 = this.j;
        nVar12.g = nVar12.f866e.g;
        ConstraintAnchor.Type type = this.f864c.f837c;
        int i = 0;
        if (type != ConstraintAnchor.Type.RIGHT && type != ConstraintAnchor.Type.BOTTOM) {
            z = false;
        }
        if (z) {
            f2 = this.f866e.h;
            f3 = this.j.f866e.h;
        } else {
            f2 = this.j.f866e.h;
            f3 = this.f866e.h;
        }
        float f5 = f2 - f3;
        ConstraintAnchor.Type type2 = this.f864c.f837c;
        if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
            fS = f5 - this.f864c.f836b.s();
            f4 = this.f864c.f836b.aa;
        } else {
            fS = f5 - r2.f836b.i();
            f4 = this.f864c.f836b.ba;
        }
        int iB = this.f864c.b();
        int iB2 = this.j.f864c.b();
        if (this.f864c.g() == this.j.f864c.g()) {
            f4 = 0.5f;
            iB2 = 0;
        } else {
            i = iB;
        }
        float f6 = i;
        float f7 = iB2;
        float f8 = (fS - f6) - f7;
        if (z) {
            n nVar13 = this.j;
            nVar13.h = nVar13.f866e.h + f7 + (f8 * f4);
            this.h = (this.f866e.h - f6) - (f8 * (1.0f - f4));
        } else {
            this.h = this.f866e.h + f6 + (f8 * f4);
            n nVar14 = this.j;
            nVar14.h = (nVar14.f866e.h - f7) - (f8 * (1.0f - f4));
        }
        a();
        this.j.a();
    }

    public float f() {
        return this.h;
    }

    public void g() {
        ConstraintAnchor constraintAnchorG = this.f864c.g();
        if (constraintAnchorG == null) {
            return;
        }
        if (constraintAnchorG.g() == this.f864c) {
            this.i = 4;
            constraintAnchorG.d().i = 4;
        }
        int iB = this.f864c.b();
        ConstraintAnchor.Type type = this.f864c.f837c;
        if (type == ConstraintAnchor.Type.RIGHT || type == ConstraintAnchor.Type.BOTTOM) {
            iB = -iB;
        }
        a(constraintAnchorG.d(), iB);
    }

    public String toString() {
        if (this.f870b != 1) {
            return "{ " + this.f864c + " UNRESOLVED} type: " + a(this.i);
        }
        if (this.g == this) {
            return "[" + this.f864c + ", RESOLVED: " + this.h + "]  type: " + a(this.i);
        }
        return "[" + this.f864c + ", RESOLVED: " + this.g + ":" + this.h + "] type: " + a(this.i);
    }

    public void b(n nVar, float f2) {
        this.j = nVar;
        this.k = f2;
    }

    public void b(n nVar, int i, o oVar) {
        this.j = nVar;
        this.n = oVar;
        this.o = i;
    }

    public void a(int i, n nVar, int i2) {
        this.i = i;
        this.f866e = nVar;
        this.f867f = i2;
        this.f866e.a(this);
    }

    public void a(n nVar, int i) {
        this.f866e = nVar;
        this.f867f = i;
        this.f866e.a(this);
    }

    public void a(n nVar, int i, o oVar) {
        this.f866e = nVar;
        this.f866e.a(this);
        this.l = oVar;
        this.m = i;
        this.l.a(this);
    }

    void a(androidx.constraintlayout.solver.e eVar) {
        SolverVariable solverVariableE = this.f864c.e();
        n nVar = this.g;
        if (nVar == null) {
            eVar.a(solverVariableE, (int) (this.h + 0.5f));
        } else {
            eVar.a(solverVariableE, eVar.a(nVar.f864c), (int) (this.h + 0.5f), 6);
        }
    }
}
