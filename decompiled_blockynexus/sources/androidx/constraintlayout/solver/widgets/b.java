package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;

/* JADX INFO: compiled from: Barrier.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends k {
    private int xa = 0;
    private ArrayList<n> ya = new ArrayList<>(4);
    private boolean za = true;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void F() {
        super.F();
        this.ya.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void G() {
        n nVarD;
        float f2;
        n nVar;
        int i = this.xa;
        float f3 = Float.MAX_VALUE;
        if (i != 0) {
            if (i == 1) {
                nVarD = this.x.d();
            } else if (i == 2) {
                nVarD = this.w.d();
            } else if (i != 3) {
                return;
            } else {
                nVarD = this.y.d();
            }
            f3 = WheelView.DividerConfig.FILL;
        } else {
            nVarD = this.v.d();
        }
        int size = this.ya.size();
        n nVar2 = null;
        for (int i2 = 0; i2 < size; i2++) {
            n nVar3 = this.ya.get(i2);
            if (nVar3.f870b != 1) {
                return;
            }
            int i3 = this.xa;
            if (i3 == 0 || i3 == 2) {
                f2 = nVar3.h;
                if (f2 < f3) {
                    nVar = nVar3.g;
                    nVar2 = nVar;
                    f3 = f2;
                }
            } else {
                f2 = nVar3.h;
                if (f2 > f3) {
                    nVar = nVar3.g;
                    nVar2 = nVar;
                    f3 = f2;
                }
            }
        }
        if (androidx.constraintlayout.solver.e.e() != null) {
            androidx.constraintlayout.solver.e.e().y++;
        }
        nVarD.g = nVar2;
        nVarD.h = f3;
        nVarD.a();
        int i4 = this.xa;
        if (i4 == 0) {
            this.x.d().a(nVar2, f3);
            return;
        }
        if (i4 == 1) {
            this.v.d().a(nVar2, f3);
        } else if (i4 == 2) {
            this.y.d().a(nVar2, f3);
        } else {
            if (i4 != 3) {
                return;
            }
            this.w.d().a(nVar2, f3);
        }
    }

    public boolean K() {
        return this.za;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(int i) {
        n nVarD;
        ConstraintWidget constraintWidget = this.G;
        if (constraintWidget != null && ((g) constraintWidget).t(2)) {
            int i2 = this.xa;
            if (i2 == 0) {
                nVarD = this.v.d();
            } else if (i2 == 1) {
                nVarD = this.x.d();
            } else if (i2 == 2) {
                nVarD = this.w.d();
            } else if (i2 != 3) {
                return;
            } else {
                nVarD = this.y.d();
            }
            nVarD.b(5);
            int i3 = this.xa;
            if (i3 == 0 || i3 == 1) {
                this.w.d().a((n) null, WheelView.DividerConfig.FILL);
                this.y.d().a((n) null, WheelView.DividerConfig.FILL);
            } else {
                this.v.d().a((n) null, WheelView.DividerConfig.FILL);
                this.x.d().a((n) null, WheelView.DividerConfig.FILL);
            }
            this.ya.clear();
            for (int i4 = 0; i4 < this.wa; i4++) {
                ConstraintWidget constraintWidget2 = this.va[i4];
                if (this.za || constraintWidget2.a()) {
                    int i5 = this.xa;
                    n nVarD2 = i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? null : constraintWidget2.y.d() : constraintWidget2.w.d() : constraintWidget2.x.d() : constraintWidget2.v.d();
                    if (nVarD2 != null) {
                        this.ya.add(nVarD2);
                        nVarD2.a(nVarD);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    public void c(boolean z) {
        this.za = z;
    }

    public void t(int i) {
        this.xa = i;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(androidx.constraintlayout.solver.e eVar) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z;
        int i;
        int i2;
        ConstraintAnchor[] constraintAnchorArr2 = this.D;
        constraintAnchorArr2[0] = this.v;
        constraintAnchorArr2[2] = this.w;
        constraintAnchorArr2[1] = this.x;
        constraintAnchorArr2[3] = this.y;
        int i3 = 0;
        while (true) {
            constraintAnchorArr = this.D;
            if (i3 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i3].j = eVar.a(constraintAnchorArr[i3]);
            i3++;
        }
        int i4 = this.xa;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i4];
        for (int i5 = 0; i5 < this.wa; i5++) {
            ConstraintWidget constraintWidget = this.va[i5];
            if ((this.za || constraintWidget.a()) && ((((i = this.xa) == 0 || i == 1) && constraintWidget.j() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((i2 = this.xa) == 2 || i2 == 3) && constraintWidget.q() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i6 = this.xa;
        if (i6 == 0 || i6 == 1 ? k().j() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : k().q() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.wa; i7++) {
            ConstraintWidget constraintWidget2 = this.va[i7];
            if (this.za || constraintWidget2.a()) {
                SolverVariable solverVariableA = eVar.a(constraintWidget2.D[this.xa]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.D;
                int i8 = this.xa;
                constraintAnchorArr3[i8].j = solverVariableA;
                if (i8 != 0 && i8 != 2) {
                    eVar.a(constraintAnchor.j, solverVariableA, z);
                } else {
                    eVar.b(constraintAnchor.j, solverVariableA, z);
                }
            }
        }
        int i9 = this.xa;
        if (i9 == 0) {
            eVar.a(this.x.j, this.v.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.v.j, this.G.x.j, 0, 5);
            return;
        }
        if (i9 == 1) {
            eVar.a(this.v.j, this.x.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.v.j, this.G.v.j, 0, 5);
            return;
        }
        if (i9 == 2) {
            eVar.a(this.y.j, this.w.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.w.j, this.G.y.j, 0, 5);
            return;
        }
        if (i9 == 3) {
            eVar.a(this.w.j, this.y.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.w.j, this.G.w.j, 0, 5);
        }
    }
}
