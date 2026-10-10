package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.e;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.appevents.UserDataStore;

/* JADX INFO: compiled from: ArrayRow.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f816d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SolverVariable f813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f814b = WheelView.DividerConfig.FILL;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f815c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f817e = false;

    public b(c cVar) {
        this.f816d = new a(this, cVar);
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f814b = i;
        }
        if (z) {
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable2, -1.0f);
        } else {
            this.f816d.a(solverVariable, -1.0f);
            this.f816d.a(solverVariable2, 1.0f);
        }
        return this;
    }

    boolean b() {
        SolverVariable solverVariable = this.f813a;
        return solverVariable != null && (solverVariable.h == SolverVariable.Type.UNRESTRICTED || this.f814b >= WheelView.DividerConfig.FILL);
    }

    public b c(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.f814b = i * (-1);
            this.f816d.a(solverVariable, 1.0f);
        } else {
            this.f814b = i;
            this.f816d.a(solverVariable, -1.0f);
        }
        return this;
    }

    @Override // androidx.constraintlayout.solver.e.a
    public void clear() {
        this.f816d.a();
        this.f813a = null;
        this.f814b = WheelView.DividerConfig.FILL;
    }

    public void d() {
        this.f813a = null;
        this.f816d.a();
        this.f814b = WheelView.DividerConfig.FILL;
        this.f817e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String e() {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.b.e():java.lang.String");
    }

    @Override // androidx.constraintlayout.solver.e.a
    public SolverVariable getKey() {
        return this.f813a;
    }

    public String toString() {
        return e();
    }

    boolean b(SolverVariable solverVariable) {
        return this.f816d.a(solverVariable);
    }

    b b(SolverVariable solverVariable, int i) {
        this.f813a = solverVariable;
        float f2 = i;
        solverVariable.f806f = f2;
        this.f814b = f2;
        this.f817e = true;
        return this;
    }

    SolverVariable c(SolverVariable solverVariable) {
        return this.f816d.a((boolean[]) null, solverVariable);
    }

    void d(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f813a;
        if (solverVariable2 != null) {
            this.f816d.a(solverVariable2, -1.0f);
            this.f813a = null;
        }
        float fA = this.f816d.a(solverVariable, true) * (-1.0f);
        this.f813a = solverVariable;
        if (fA == 1.0f) {
            return;
        }
        this.f814b /= fA;
        this.f816d.a(fA);
    }

    b a(SolverVariable solverVariable, int i) {
        this.f816d.a(solverVariable, i);
        return this;
    }

    public boolean c() {
        return this.f813a == null && this.f814b == WheelView.DividerConfig.FILL && this.f816d.f807a == 0;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f814b = i;
        }
        if (!z) {
            this.f816d.a(solverVariable, -1.0f);
            this.f816d.a(solverVariable2, 1.0f);
            this.f816d.a(solverVariable3, 1.0f);
        } else {
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable2, -1.0f);
            this.f816d.a(solverVariable3, -1.0f);
        }
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f814b = i;
        }
        if (!z) {
            this.f816d.a(solverVariable, -1.0f);
            this.f816d.a(solverVariable2, 1.0f);
            this.f816d.a(solverVariable3, -1.0f);
        } else {
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable2, -1.0f);
            this.f816d.a(solverVariable3, 1.0f);
        }
        return this;
    }

    public b a(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f814b = WheelView.DividerConfig.FILL;
        if (f3 == WheelView.DividerConfig.FILL || f2 == f4) {
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable2, -1.0f);
            this.f816d.a(solverVariable4, 1.0f);
            this.f816d.a(solverVariable3, -1.0f);
        } else if (f2 == WheelView.DividerConfig.FILL) {
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable2, -1.0f);
        } else if (f4 == WheelView.DividerConfig.FILL) {
            this.f816d.a(solverVariable3, 1.0f);
            this.f816d.a(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable2, -1.0f);
            this.f816d.a(solverVariable4, f5);
            this.f816d.a(solverVariable3, -f5);
        }
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f816d.a(solverVariable3, 0.5f);
        this.f816d.a(solverVariable4, 0.5f);
        this.f816d.a(solverVariable, -0.5f);
        this.f816d.a(solverVariable2, -0.5f);
        this.f814b = -f2;
        return this;
    }

    b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable4, 1.0f);
            this.f816d.a(solverVariable2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f816d.a(solverVariable, 1.0f);
            this.f816d.a(solverVariable2, -1.0f);
            this.f816d.a(solverVariable3, -1.0f);
            this.f816d.a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f814b = (-i) + i2;
            }
        } else if (f2 <= WheelView.DividerConfig.FILL) {
            this.f816d.a(solverVariable, -1.0f);
            this.f816d.a(solverVariable2, 1.0f);
            this.f814b = i;
        } else if (f2 >= 1.0f) {
            this.f816d.a(solverVariable3, -1.0f);
            this.f816d.a(solverVariable4, 1.0f);
            this.f814b = i2;
        } else {
            float f3 = 1.0f - f2;
            this.f816d.a(solverVariable, f3 * 1.0f);
            this.f816d.a(solverVariable2, f3 * (-1.0f));
            this.f816d.a(solverVariable3, (-1.0f) * f2);
            this.f816d.a(solverVariable4, 1.0f * f2);
            if (i > 0 || i2 > 0) {
                this.f814b = ((-i) * f3) + (i2 * f2);
            }
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.f816d.a(eVar.a(i, "ep"), 1.0f);
        this.f816d.a(eVar.a(i, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2) {
        this.f816d.a(solverVariable, -1.0f);
        this.f816d.a(solverVariable2, 1.0f - f2);
        this.f816d.a(solverVariable3, f2);
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f816d.a(solverVariable, -1.0f);
        this.f816d.a(solverVariable2, 1.0f);
        this.f816d.a(solverVariable3, f2);
        this.f816d.a(solverVariable4, -f2);
        return this;
    }

    void a() {
        float f2 = this.f814b;
        if (f2 < WheelView.DividerConfig.FILL) {
            this.f814b = f2 * (-1.0f);
            this.f816d.b();
        }
    }

    boolean a(e eVar) {
        boolean z;
        SolverVariable solverVariableA = this.f816d.a(eVar);
        if (solverVariableA == null) {
            z = true;
        } else {
            d(solverVariableA);
            z = false;
        }
        if (this.f816d.f807a == 0) {
            this.f817e = true;
        }
        return z;
    }

    @Override // androidx.constraintlayout.solver.e.a
    public SolverVariable a(e eVar, boolean[] zArr) {
        return this.f816d.a(zArr, (SolverVariable) null);
    }

    @Override // androidx.constraintlayout.solver.e.a
    public void a(e.a aVar) {
        if (!(aVar instanceof b)) {
            return;
        }
        b bVar = (b) aVar;
        this.f813a = null;
        this.f816d.a();
        int i = 0;
        while (true) {
            a aVar2 = bVar.f816d;
            if (i >= aVar2.f807a) {
                return;
            }
            this.f816d.a(aVar2.a(i), bVar.f816d.b(i), true);
            i++;
        }
    }

    @Override // androidx.constraintlayout.solver.e.a
    public void a(SolverVariable solverVariable) {
        int i = solverVariable.f805e;
        float f2 = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f2 = 1000.0f;
            } else if (i == 3) {
                f2 = 1000000.0f;
            } else if (i == 4) {
                f2 = 1.0E9f;
            } else if (i == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f816d.a(solverVariable, f2);
    }
}
