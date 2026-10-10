package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAnchor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ConstraintWidget f836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Type f837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ConstraintAnchor f838d;
    SolverVariable j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f835a = new n(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f839e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f840f = -1;
    private Strength g = Strength.NONE;
    private ConnectionType h = ConnectionType.RELAXED;
    private int i = 0;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f836b = constraintWidget;
        this.f837c = type;
    }

    public void a(androidx.constraintlayout.solver.c cVar) {
        SolverVariable solverVariable = this.j;
        if (solverVariable == null) {
            this.j = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.b();
        }
    }

    public int b() {
        ConstraintAnchor constraintAnchor;
        if (this.f836b.r() == 8) {
            return 0;
        }
        return (this.f840f <= -1 || (constraintAnchor = this.f838d) == null || constraintAnchor.f836b.r() != 8) ? this.f839e : this.f840f;
    }

    public ConstraintWidget c() {
        return this.f836b;
    }

    public n d() {
        return this.f835a;
    }

    public SolverVariable e() {
        return this.j;
    }

    public Strength f() {
        return this.g;
    }

    public ConstraintAnchor g() {
        return this.f838d;
    }

    public Type h() {
        return this.f837c;
    }

    public boolean i() {
        return this.f838d != null;
    }

    public void j() {
        this.f838d = null;
        this.f839e = 0;
        this.f840f = -1;
        this.g = Strength.STRONG;
        this.i = 0;
        this.h = ConnectionType.RELAXED;
        this.f835a.d();
    }

    public String toString() {
        return this.f836b.f() + ":" + this.f837c.toString();
    }

    public int a() {
        return this.i;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return a(constraintAnchor, i, -1, strength, i2, false);
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.f838d = null;
            this.f839e = 0;
            this.f840f = -1;
            this.g = Strength.NONE;
            this.i = 2;
            return true;
        }
        if (!z && !a(constraintAnchor)) {
            return false;
        }
        this.f838d = constraintAnchor;
        if (i > 0) {
            this.f839e = i;
        } else {
            this.f839e = 0;
        }
        this.f840f = i2;
        this.g = strength;
        this.i = i3;
        return true;
    }

    public boolean a(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type typeH = constraintAnchor.h();
        Type type = this.f837c;
        if (typeH == type) {
            return type != Type.BASELINE || (constraintAnchor.c().x() && c().x());
        }
        switch (e.f853a[type.ordinal()]) {
            case 1:
                return (typeH == Type.BASELINE || typeH == Type.CENTER_X || typeH == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = typeH == Type.LEFT || typeH == Type.RIGHT;
                return constraintAnchor.c() instanceof j ? z || typeH == Type.CENTER_X : z;
            case 4:
            case 5:
                boolean z2 = typeH == Type.TOP || typeH == Type.BOTTOM;
                return constraintAnchor.c() instanceof j ? z2 || typeH == Type.CENTER_Y : z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f837c.name());
        }
    }
}
