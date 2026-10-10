package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: ConstraintWidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends r {
    int Aa;
    int Ba;
    int Ca;
    private q ya;
    int za;
    private boolean wa = false;
    protected androidx.constraintlayout.solver.e xa = new androidx.constraintlayout.solver.e();
    int Da = 0;
    int Ea = 0;
    d[] Fa = new d[4];
    d[] Ga = new d[4];
    public List<h> Ha = new ArrayList();
    public boolean Ia = false;
    public boolean Ja = false;
    public boolean Ka = false;
    public int La = 0;
    public int Ma = 0;
    private int Na = 7;
    public boolean Oa = false;
    private boolean Pa = false;
    private boolean Qa = false;
    int Ra = 0;

    private void V() {
        this.Da = 0;
        this.Ea = 0;
    }

    private void e(ConstraintWidget constraintWidget) {
        int i = this.Ea + 1;
        d[] dVarArr = this.Fa;
        if (i >= dVarArr.length) {
            this.Fa = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.Fa[this.Ea] = new d(constraintWidget, 1, P());
        this.Ea++;
    }

    @Override // androidx.constraintlayout.solver.widgets.r, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void D() {
        this.xa.g();
        this.za = 0;
        this.Ba = 0;
        this.Aa = 0;
        this.Ca = 0;
        this.Ha.clear();
        this.Oa = false;
        super.D();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02d0 A[PHI: r0 r9
      0x02d0: PHI (r0v34 boolean) = (r0v33 boolean), (r0v36 boolean), (r0v36 boolean), (r0v36 boolean) binds: [B:115:0x0291, B:123:0x02b8, B:124:0x02ba, B:126:0x02c0] A[DONT_GENERATE, DONT_INLINE]
      0x02d0: PHI (r9v14 boolean) = (r9v13 boolean), (r9v16 boolean), (r9v16 boolean), (r9v16 boolean) binds: [B:115:0x0291, B:123:0x02b8, B:124:0x02ba, B:126:0x02c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018f  */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v22 */
    @Override // androidx.constraintlayout.solver.widgets.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void K() {
        /*
            Method dump skipped, instruction units count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.g.K():void");
    }

    public int M() {
        return this.Na;
    }

    public boolean N() {
        return false;
    }

    public boolean O() {
        return this.Qa;
    }

    public boolean P() {
        return this.wa;
    }

    public boolean Q() {
        return this.Pa;
    }

    public void R() {
        if (!t(8)) {
            a(this.Na);
        }
        U();
    }

    public void S() {
        int size = this.va.size();
        F();
        for (int i = 0; i < size; i++) {
            this.va.get(i).F();
        }
    }

    public void T() {
        S();
        a(this.Na);
    }

    public void U() {
        n nVarD = a(ConstraintAnchor.Type.LEFT).d();
        n nVarD2 = a(ConstraintAnchor.Type.TOP).d();
        nVarD.a((n) null, WheelView.DividerConfig.FILL);
        nVarD2.a((n) null, WheelView.DividerConfig.FILL);
    }

    public void a(androidx.constraintlayout.solver.f fVar) {
        this.xa.a(fVar);
    }

    public void c(boolean z) {
        this.wa = z;
    }

    public boolean d(androidx.constraintlayout.solver.e eVar) {
        a(eVar);
        int size = this.va.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.va.get(i);
            if (constraintWidget instanceof g) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.F;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.a(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.b(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.a(eVar);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.a(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.b(dimensionBehaviour2);
                }
            } else {
                l.a(this, eVar, constraintWidget);
                constraintWidget.a(eVar);
            }
        }
        if (this.Da > 0) {
            c.a(this, eVar, 0);
        }
        if (this.Ea > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public void f(int i, int i2) {
        o oVar;
        o oVar2;
        if (this.F[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (oVar2 = this.f844d) != null) {
            oVar2.a(i);
        }
        if (this.F[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (oVar = this.f845e) == null) {
            return;
        }
        oVar.a(i2);
    }

    public boolean t(int i) {
        return (this.Na & i) == i;
    }

    public void u(int i) {
        this.Na = i;
    }

    public void a(androidx.constraintlayout.solver.e eVar, boolean[] zArr) {
        zArr[2] = false;
        c(eVar);
        int size = this.va.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.va.get(i);
            constraintWidget.c(eVar);
            if (constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.s() < constraintWidget.u()) {
                zArr[2] = true;
            }
            if (constraintWidget.F[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.i() < constraintWidget.t()) {
                zArr[2] = true;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(int i) {
        super.a(i);
        int size = this.va.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.va.get(i2).a(i);
        }
    }

    void a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            d(constraintWidget);
        } else if (i == 1) {
            e(constraintWidget);
        }
    }

    private void d(ConstraintWidget constraintWidget) {
        int i = this.Da + 1;
        d[] dVarArr = this.Ga;
        if (i >= dVarArr.length) {
            this.Ga = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.Ga[this.Da] = new d(constraintWidget, 0, P());
        this.Da++;
    }
}
