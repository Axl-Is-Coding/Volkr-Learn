package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: LinearSystem.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f821a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f822b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f825e;
    private int g;
    b[] h;
    public boolean i;
    private boolean[] j;
    int k;
    int l;
    private int m;
    final c n;
    private SolverVariable[] o;
    private int p;
    private b[] q;
    private final a r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f823c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, SolverVariable> f824d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f826f = 32;

    /* JADX INFO: compiled from: LinearSystem.java */
    interface a {
        SolverVariable a(e eVar, boolean[] zArr);

        void a(SolverVariable solverVariable);

        void a(a aVar);

        void clear();

        SolverVariable getKey();
    }

    public e() {
        int i = this.f826f;
        this.g = i;
        this.h = null;
        this.i = false;
        this.j = new boolean[i];
        this.k = 1;
        this.l = 0;
        this.m = i;
        this.o = new SolverVariable[f821a];
        this.p = 0;
        this.q = new b[i];
        this.h = new b[i];
        j();
        this.n = new c();
        this.f825e = new d(this.n);
        this.r = new b(this.n);
    }

    private final void d(b bVar) {
        if (this.l > 0) {
            bVar.f816d.a(bVar, this.h);
            if (bVar.f816d.f807a == 0) {
                bVar.f817e = true;
            }
        }
    }

    public static f e() {
        return f822b;
    }

    private void h() {
        for (int i = 0; i < this.l; i++) {
            b bVar = this.h[i];
            bVar.f813a.f806f = bVar.f814b;
        }
    }

    private void i() {
        this.f826f *= 2;
        this.h = (b[]) Arrays.copyOf(this.h, this.f826f);
        c cVar = this.n;
        cVar.f820c = (SolverVariable[]) Arrays.copyOf(cVar.f820c, this.f826f);
        int i = this.f826f;
        this.j = new boolean[i];
        this.g = i;
        this.m = i;
        f fVar = f822b;
        if (fVar != null) {
            fVar.f830d++;
            fVar.o = Math.max(fVar.o, i);
            f fVar2 = f822b;
            fVar2.A = fVar2.o;
        }
    }

    private void j() {
        int i = 0;
        while (true) {
            b[] bVarArr = this.h;
            if (i >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i];
            if (bVar != null) {
                this.n.f818a.a(bVar);
            }
            this.h[i] = null;
            i++;
        }
    }

    public void a(f fVar) {
        f822b = fVar;
    }

    public b b() {
        b bVarA = this.n.f818a.a();
        if (bVarA == null) {
            bVarA = new b(this.n);
        } else {
            bVarA.d();
        }
        SolverVariable.a();
        return bVarA;
    }

    public SolverVariable c() {
        f fVar = f822b;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, (String) null);
        this.f823c++;
        this.k++;
        int i = this.f823c;
        solverVariableA.f803c = i;
        this.n.f820c[i] = solverVariableA;
        return solverVariableA;
    }

    public void f() throws Exception {
        f fVar = f822b;
        if (fVar != null) {
            fVar.f831e++;
        }
        if (!this.i) {
            a(this.f825e);
            return;
        }
        f fVar2 = f822b;
        if (fVar2 != null) {
            fVar2.q++;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.l) {
                z = true;
                break;
            } else if (!this.h[i].f817e) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            a(this.f825e);
            return;
        }
        f fVar3 = f822b;
        if (fVar3 != null) {
            fVar3.p++;
        }
        h();
    }

    public void g() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.n;
            SolverVariable[] solverVariableArr = cVar.f820c;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.b();
            }
            i++;
        }
        cVar.f819b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.f820c, (Object) null);
        HashMap<String, SolverVariable> map = this.f824d;
        if (map != null) {
            map.clear();
        }
        this.f823c = 0;
        this.f825e.clear();
        this.k = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            this.h[i2].f815c = false;
        }
        j();
        this.l = 0;
    }

    public SolverVariable a(Object obj) {
        SolverVariable solverVariableE = null;
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariableE = constraintAnchor.e();
            if (solverVariableE == null) {
                constraintAnchor.a(this.n);
                solverVariableE = constraintAnchor.e();
            }
            int i = solverVariableE.f803c;
            if (i == -1 || i > this.f823c || this.n.f820c[i] == null) {
                if (solverVariableE.f803c != -1) {
                    solverVariableE.b();
                }
                this.f823c++;
                this.k++;
                int i2 = this.f823c;
                solverVariableE.f803c = i2;
                solverVariableE.h = SolverVariable.Type.UNRESTRICTED;
                this.n.f820c[i2] = solverVariableE;
            }
        }
        return solverVariableE;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    public c d() {
        return this.n;
    }

    public int b(Object obj) {
        SolverVariable solverVariableE = ((ConstraintAnchor) obj).e();
        if (solverVariableE != null) {
            return (int) (solverVariableE.f806f + 0.5f);
        }
        return 0;
    }

    private int b(a aVar) throws Exception {
        float f2;
        boolean z;
        int i = 0;
        while (true) {
            int i2 = this.l;
            f2 = WheelView.DividerConfig.FILL;
            if (i >= i2) {
                z = false;
                break;
            }
            b[] bVarArr = this.h;
            if (bVarArr[i].f813a.h != SolverVariable.Type.UNRESTRICTED && bVarArr[i].f814b < WheelView.DividerConfig.FILL) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar = f822b;
            if (fVar != null) {
                fVar.k++;
            }
            i3++;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            float f3 = Float.MAX_VALUE;
            int i7 = 0;
            while (i4 < this.l) {
                b bVar = this.h[i4];
                if (bVar.f813a.h != SolverVariable.Type.UNRESTRICTED && !bVar.f817e && bVar.f814b < f2) {
                    int i8 = 1;
                    while (i8 < this.k) {
                        SolverVariable solverVariable = this.n.f820c[i8];
                        float fB = bVar.f816d.b(solverVariable);
                        if (fB > f2) {
                            int i9 = i7;
                            float f4 = f3;
                            int i10 = i6;
                            int i11 = i5;
                            for (int i12 = 0; i12 < 7; i12++) {
                                float f5 = solverVariable.g[i12] / fB;
                                if ((f5 < f4 && i12 == i9) || i12 > i9) {
                                    i10 = i8;
                                    i11 = i4;
                                    f4 = f5;
                                    i9 = i12;
                                }
                            }
                            i5 = i11;
                            i6 = i10;
                            f3 = f4;
                            i7 = i9;
                        }
                        i8++;
                        f2 = WheelView.DividerConfig.FILL;
                    }
                }
                i4++;
                f2 = WheelView.DividerConfig.FILL;
            }
            if (i5 != -1) {
                b bVar2 = this.h[i5];
                bVar2.f813a.f804d = -1;
                f fVar2 = f822b;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.d(this.n.f820c[i6]);
                SolverVariable solverVariable2 = bVar2.f813a;
                solverVariable2.f804d = i5;
                solverVariable2.c(bVar2);
            } else {
                z2 = true;
            }
            if (i3 > this.k / 2) {
                z2 = true;
            }
            f2 = WheelView.DividerConfig.FILL;
        }
        return i3;
    }

    private final void c(b bVar) {
        b[] bVarArr = this.h;
        int i = this.l;
        if (bVarArr[i] != null) {
            this.n.f818a.a(bVarArr[i]);
        }
        b[] bVarArr2 = this.h;
        int i2 = this.l;
        bVarArr2[i2] = bVar;
        SolverVariable solverVariable = bVar.f813a;
        solverVariable.f804d = i2;
        this.l = i2 + 1;
        solverVariable.c(bVar);
    }

    public SolverVariable a() {
        f fVar = f822b;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, (String) null);
        this.f823c++;
        this.k++;
        int i = this.f823c;
        solverVariableA.f803c = i;
        this.n.f820c[i] = solverVariableA;
        return solverVariableA;
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b bVarB = b();
        SolverVariable solverVariableC = c();
        solverVariableC.f805e = 0;
        bVarB.b(solverVariable, solverVariable2, solverVariableC, i);
        if (i2 != 6) {
            a(bVarB, (int) (bVarB.f816d.b(solverVariableC) * (-1.0f)), i2);
        }
        a(bVarB);
    }

    void a(b bVar, int i, int i2) {
        bVar.a(a(i2, (String) null), i);
    }

    public SolverVariable a(int i, String str) {
        f fVar = f822b;
        if (fVar != null) {
            fVar.l++;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.ERROR, str);
        this.f823c++;
        this.k++;
        int i2 = this.f823c;
        solverVariableA.f803c = i2;
        solverVariableA.f805e = i;
        this.n.f820c[i2] = solverVariableA;
        this.f825e.a(solverVariableA);
        return solverVariableA;
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b bVarB = b();
        SolverVariable solverVariableC = c();
        solverVariableC.f805e = 0;
        bVarB.a(solverVariable, solverVariable2, solverVariableC, i);
        if (i2 != 6) {
            a(bVarB, (int) (bVarB.f816d.b(solverVariableC) * (-1.0f)), i2);
        }
        a(bVarB);
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariableA = this.n.f819b.a();
        if (solverVariableA == null) {
            solverVariableA = new SolverVariable(type, str);
            solverVariableA.a(type, str);
        } else {
            solverVariableA.b();
            solverVariableA.a(type, str);
        }
        int i = this.p;
        int i2 = f821a;
        if (i >= i2) {
            f821a = i2 * 2;
            this.o = (SolverVariable[]) Arrays.copyOf(this.o, f821a);
        }
        SolverVariable[] solverVariableArr = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        solverVariableArr[i3] = solverVariableA;
        return solverVariableA;
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        b bVarB = b();
        SolverVariable solverVariableC = c();
        solverVariableC.f805e = 0;
        bVarB.b(solverVariable, solverVariable2, solverVariableC, 0);
        if (z) {
            a(bVarB, (int) (bVarB.f816d.b(solverVariableC) * (-1.0f)), 1);
        }
        a(bVarB);
    }

    void a(a aVar) throws Exception {
        f fVar = f822b;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, this.k);
            f fVar2 = f822b;
            fVar2.u = Math.max(fVar2.u, this.l);
        }
        d((b) aVar);
        b(aVar);
        a(aVar, false);
        h();
    }

    public void a(b bVar) {
        SolverVariable solverVariableC;
        if (bVar == null) {
            return;
        }
        f fVar = f822b;
        if (fVar != null) {
            fVar.f832f++;
            if (bVar.f817e) {
                fVar.g++;
            }
        }
        if (this.l + 1 >= this.m || this.k + 1 >= this.g) {
            i();
        }
        boolean z = false;
        if (!bVar.f817e) {
            d(bVar);
            if (bVar.c()) {
                return;
            }
            bVar.a();
            if (bVar.a(this)) {
                SolverVariable solverVariableA = a();
                bVar.f813a = solverVariableA;
                c(bVar);
                this.r.a(bVar);
                a(this.r, true);
                if (solverVariableA.f804d == -1) {
                    if (bVar.f813a == solverVariableA && (solverVariableC = bVar.c(solverVariableA)) != null) {
                        f fVar2 = f822b;
                        if (fVar2 != null) {
                            fVar2.j++;
                        }
                        bVar.d(solverVariableC);
                    }
                    if (!bVar.f817e) {
                        bVar.f813a.c(bVar);
                    }
                    this.l--;
                }
                z = true;
            }
            if (!bVar.b()) {
                return;
            }
        }
        if (z) {
            return;
        }
        c(bVar);
    }

    private final int a(a aVar, boolean z) {
        f fVar = f822b;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i = 0; i < this.k; i++) {
            this.j[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar2 = f822b;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i2++;
            if (i2 >= this.k * 2) {
                return i2;
            }
            if (aVar.getKey() != null) {
                this.j[aVar.getKey().f803c] = true;
            }
            SolverVariable solverVariableA = aVar.a(this, this.j);
            if (solverVariableA != null) {
                boolean[] zArr = this.j;
                int i3 = solverVariableA.f803c;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (solverVariableA != null) {
                int i4 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i5 = 0; i5 < this.l; i5++) {
                    b bVar = this.h[i5];
                    if (bVar.f813a.h != SolverVariable.Type.UNRESTRICTED && !bVar.f817e && bVar.b(solverVariableA)) {
                        float fB = bVar.f816d.b(solverVariableA);
                        if (fB < WheelView.DividerConfig.FILL) {
                            float f3 = (-bVar.f814b) / fB;
                            if (f3 < f2) {
                                i4 = i5;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.h[i4];
                    bVar2.f813a.f804d = -1;
                    f fVar3 = f822b;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.d(solverVariableA);
                    SolverVariable solverVariable = bVar2.f813a;
                    solverVariable.f804d = i4;
                    solverVariable.c(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        b bVarB = b();
        SolverVariable solverVariableC = c();
        solverVariableC.f805e = 0;
        bVarB.a(solverVariable, solverVariable2, solverVariableC, 0);
        if (z) {
            a(bVarB, (int) (bVarB.f816d.b(solverVariableC) * (-1.0f)), 1);
        }
        a(bVarB);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        b bVarB = b();
        bVarB.a(solverVariable, solverVariable2, i, f2, solverVariable3, solverVariable4, i2);
        if (i3 != 6) {
            bVarB.a(this, i3);
        }
        a(bVarB);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i) {
        b bVarB = b();
        bVarB.a(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i != 6) {
            bVarB.a(this, i);
        }
        a(bVarB);
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b bVarB = b();
        bVarB.a(solverVariable, solverVariable2, i);
        if (i2 != 6) {
            bVarB.a(this, i2);
        }
        a(bVarB);
        return bVarB;
    }

    public void a(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.f804d;
        if (i2 != -1) {
            b bVar = this.h[i2];
            if (bVar.f817e) {
                bVar.f814b = i;
                return;
            }
            if (bVar.f816d.f807a == 0) {
                bVar.f817e = true;
                bVar.f814b = i;
                return;
            } else {
                b bVarB = b();
                bVarB.c(solverVariable, i);
                a(bVarB);
                return;
            }
        }
        b bVarB2 = b();
        bVarB2.b(solverVariable, i);
        a(bVarB2);
    }

    public static b a(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2, boolean z) {
        b bVarB = eVar.b();
        if (z) {
            eVar.b(bVarB);
        }
        bVarB.a(solverVariable, solverVariable2, solverVariable3, f2);
        return bVarB;
    }

    public void a(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i) {
        SolverVariable solverVariableA = a(constraintWidget.a(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariableA2 = a(constraintWidget.a(ConstraintAnchor.Type.TOP));
        SolverVariable solverVariableA3 = a(constraintWidget.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable solverVariableA4 = a(constraintWidget.a(ConstraintAnchor.Type.BOTTOM));
        SolverVariable solverVariableA5 = a(constraintWidget2.a(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariableA6 = a(constraintWidget2.a(ConstraintAnchor.Type.TOP));
        SolverVariable solverVariableA7 = a(constraintWidget2.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable solverVariableA8 = a(constraintWidget2.a(ConstraintAnchor.Type.BOTTOM));
        b bVarB = b();
        double d2 = f2;
        double dSin = Math.sin(d2);
        double d3 = i;
        Double.isNaN(d3);
        bVarB.b(solverVariableA2, solverVariableA4, solverVariableA6, solverVariableA8, (float) (dSin * d3));
        a(bVarB);
        b bVarB2 = b();
        double dCos = Math.cos(d2);
        Double.isNaN(d3);
        bVarB2.b(solverVariableA, solverVariableA3, solverVariableA5, solverVariableA7, (float) (dCos * d3));
        a(bVarB2);
    }
}
