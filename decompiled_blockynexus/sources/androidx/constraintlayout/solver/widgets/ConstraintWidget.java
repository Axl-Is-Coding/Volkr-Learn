package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f841a = 0.5f;
    protected DimensionBehaviour[] F;
    ConstraintWidget G;
    int H;
    int I;
    protected float J;
    protected int K;
    protected int L;
    protected int M;
    int N;
    int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    protected int T;
    protected int U;
    int V;
    protected int W;
    protected int X;
    private int Y;
    private int Z;
    float aa;
    float ba;
    private Object ca;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    o f844d;
    private int da;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    o f845e;
    private int ea;
    private String fa;
    private String ga;
    boolean ha;
    boolean ia;
    boolean ja;
    boolean ka;
    boolean la;
    int ma;
    int na;
    boolean o;
    boolean oa;
    boolean p;
    boolean pa;
    float[] qa;
    protected ConstraintWidget[] ra;
    protected ConstraintWidget[] sa;
    ConstraintWidget ta;
    ConstraintWidget ua;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f842b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f843c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f846f = 0;
    int g = 0;
    int[] h = new int[2];
    int i = 0;
    int j = 0;
    float k = 1.0f;
    int l = 0;
    int m = 0;
    float n = 1.0f;
    int q = -1;
    float r = 1.0f;
    h s = null;
    private int[] t = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float u = WheelView.DividerConfig.FILL;
    ConstraintAnchor v = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    ConstraintAnchor w = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    ConstraintAnchor x = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor y = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor z = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor A = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor B = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    ConstraintAnchor C = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    protected ConstraintAnchor[] D = {this.v, this.x, this.w, this.y, this.z, this.C};
    protected ArrayList<ConstraintAnchor> E = new ArrayList<>();

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.F = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.G = null;
        this.H = 0;
        this.I = 0;
        this.J = WheelView.DividerConfig.FILL;
        this.K = -1;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        float f2 = f841a;
        this.aa = f2;
        this.ba = f2;
        this.da = 0;
        this.ea = 0;
        this.fa = null;
        this.ga = null;
        this.ja = false;
        this.ka = false;
        this.la = false;
        this.ma = 0;
        this.na = 0;
        this.qa = new float[]{-1.0f, -1.0f};
        this.ra = new ConstraintWidget[]{null, null};
        this.sa = new ConstraintWidget[]{null, null};
        this.ta = null;
        this.ua = null;
        J();
    }

    private void J() {
        this.E.add(this.v);
        this.E.add(this.w);
        this.E.add(this.x);
        this.E.add(this.y);
        this.E.add(this.A);
        this.E.add(this.B);
        this.E.add(this.C);
        this.E.add(this.z);
    }

    public boolean A() {
        ConstraintAnchor constraintAnchor = this.w;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f838d;
        if (constraintAnchor2 != null && constraintAnchor2.f838d == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.y;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f838d;
        return constraintAnchor4 != null && constraintAnchor4.f838d == constraintAnchor3;
    }

    public boolean B() {
        return this.g == 0 && this.J == WheelView.DividerConfig.FILL && this.l == 0 && this.m == 0 && this.F[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean C() {
        return this.f846f == 0 && this.J == WheelView.DividerConfig.FILL && this.i == 0 && this.j == 0 && this.F[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void D() {
        this.v.j();
        this.w.j();
        this.x.j();
        this.y.j();
        this.z.j();
        this.A.j();
        this.B.j();
        this.C.j();
        this.G = null;
        this.u = WheelView.DividerConfig.FILL;
        this.H = 0;
        this.I = 0;
        this.J = WheelView.DividerConfig.FILL;
        this.K = -1;
        this.L = 0;
        this.M = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        float f2 = f841a;
        this.aa = f2;
        this.ba = f2;
        DimensionBehaviour[] dimensionBehaviourArr = this.F;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.ca = null;
        this.da = 0;
        this.ea = 0;
        this.ga = null;
        this.ha = false;
        this.ia = false;
        this.ma = 0;
        this.na = 0;
        this.oa = false;
        this.pa = false;
        float[] fArr = this.qa;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f842b = -1;
        this.f843c = -1;
        int[] iArr = this.t;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f846f = 0;
        this.g = 0;
        this.k = 1.0f;
        this.n = 1.0f;
        this.j = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.i = 0;
        this.l = 0;
        this.q = -1;
        this.r = 1.0f;
        o oVar = this.f844d;
        if (oVar != null) {
            oVar.d();
        }
        o oVar2 = this.f845e;
        if (oVar2 != null) {
            oVar2.d();
        }
        this.s = null;
        this.ja = false;
        this.ka = false;
        this.la = false;
    }

    public void E() {
        ConstraintWidget constraintWidgetK = k();
        if (constraintWidgetK != null && (constraintWidgetK instanceof g) && ((g) k()).N()) {
            return;
        }
        int size = this.E.size();
        for (int i = 0; i < size; i++) {
            this.E.get(i).j();
        }
    }

    public void F() {
        for (int i = 0; i < 6; i++) {
            this.D[i].d().d();
        }
    }

    public void G() {
    }

    public void H() {
        int i = this.L;
        int i2 = this.M;
        int i3 = this.H + i;
        int i4 = this.I + i2;
        this.P = i;
        this.Q = i2;
        this.R = i3 - i;
        this.S = i4 - i2;
    }

    public void I() {
        for (int i = 0; i < 6; i++) {
            this.D[i].d().g();
        }
    }

    public void a(int i) {
        l.a(i, this);
    }

    public void b(boolean z) {
        this.o = z;
    }

    public int c() {
        return this.V;
    }

    public int d(int i) {
        if (i == 0) {
            return s();
        }
        if (i == 1) {
            return i();
        }
        return 0;
    }

    public Object e() {
        return this.ca;
    }

    public String f() {
        return this.fa;
    }

    public int g() {
        return this.P + this.T;
    }

    public int h() {
        return this.Q + this.U;
    }

    public void i(int i) {
        this.t[1] = i;
    }

    public void j(int i) {
        this.t[0] = i;
    }

    public ConstraintWidget k() {
        return this.G;
    }

    public o l() {
        if (this.f845e == null) {
            this.f845e = new o();
        }
        return this.f845e;
    }

    public o m() {
        if (this.f844d == null) {
            this.f844d = new o();
        }
        return this.f844d;
    }

    public void n(int i) {
        this.ea = i;
    }

    protected int o() {
        return this.L + this.T;
    }

    protected int p() {
        return this.M + this.U;
    }

    public void q(int i) {
        this.Y = i;
    }

    public int r() {
        return this.ea;
    }

    public int s() {
        if (this.ea == 8) {
            return 0;
        }
        return this.H;
    }

    public int t() {
        return this.Z;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.ga != null) {
            str = "type: " + this.ga + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.fa != null) {
            str2 = "id: " + this.fa + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.L);
        sb.append(", ");
        sb.append(this.M);
        sb.append(") - (");
        sb.append(this.H);
        sb.append(" x ");
        sb.append(this.I);
        sb.append(") wrap: (");
        sb.append(this.Y);
        sb.append(" x ");
        sb.append(this.Z);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.Y;
    }

    public int v() {
        return this.L;
    }

    public int w() {
        return this.M;
    }

    public boolean x() {
        return this.V > 0;
    }

    public boolean y() {
        return this.v.d().f870b == 1 && this.x.d().f870b == 1 && this.w.d().f870b == 1 && this.y.d().f870b == 1;
    }

    public boolean z() {
        ConstraintAnchor constraintAnchor = this.v;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f838d;
        if (constraintAnchor2 != null && constraintAnchor2.f838d == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.x;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f838d;
        return constraintAnchor4 != null && constraintAnchor4.f838d == constraintAnchor3;
    }

    private boolean t(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.D;
        if (constraintAnchorArr[i2].f838d != null && constraintAnchorArr[i2].f838d.f838d != constraintAnchorArr[i2]) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].f838d != null && constraintAnchorArr[i3].f838d.f838d == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public void a(androidx.constraintlayout.solver.c cVar) {
        this.v.a(cVar);
        this.w.a(cVar);
        this.x.a(cVar);
        this.y.a(cVar);
        this.z.a(cVar);
        this.C.a(cVar);
        this.A.a(cVar);
        this.B.a(cVar);
    }

    public void b(androidx.constraintlayout.solver.e eVar) {
        eVar.a(this.v);
        eVar.a(this.w);
        eVar.a(this.x);
        eVar.a(this.y);
        if (this.V > 0) {
            eVar.a(this.z);
        }
    }

    public void c(int i, int i2) {
        this.L = i;
        this.M = i2;
    }

    public void e(int i, int i2) {
        this.M = i;
        this.I = i2 - i;
        int i3 = this.I;
        int i4 = this.X;
        if (i3 < i4) {
            this.I = i4;
        }
    }

    public void f(int i) {
        this.V = i;
    }

    public void g(int i) {
        this.I = i;
        int i2 = this.I;
        int i3 = this.X;
        if (i2 < i3) {
            this.I = i3;
        }
    }

    public void h(int i) {
        this.ma = i;
    }

    public int i() {
        if (this.ea == 8) {
            return 0;
        }
        return this.I;
    }

    public DimensionBehaviour j() {
        return this.F[0];
    }

    public void k(int i) {
        if (i < 0) {
            this.X = 0;
        } else {
            this.X = i;
        }
    }

    public int n() {
        return v() + this.H;
    }

    public void o(int i) {
        this.H = i;
        int i2 = this.H;
        int i3 = this.W;
        if (i2 < i3) {
            this.H = i3;
        }
    }

    public void p(int i) {
        this.Z = i;
    }

    public DimensionBehaviour q() {
        return this.F[1];
    }

    public void r(int i) {
        this.L = i;
    }

    public int d() {
        return w() + this.I;
    }

    public void s(int i) {
        this.M = i;
    }

    public void c(float f2) {
        this.ba = f2;
    }

    void d(int i, int i2) {
        if (i2 == 0) {
            this.N = i;
        } else if (i2 == 1) {
            this.O = i;
        }
    }

    public void l(int i) {
        if (i < 0) {
            this.W = 0;
        } else {
            this.W = i;
        }
    }

    public void m(int i) {
        this.na = i;
    }

    public DimensionBehaviour c(int i) {
        if (i == 0) {
            return j();
        }
        if (i == 1) {
            return q();
        }
        return null;
    }

    public void d(float f2) {
        this.qa[1] = f2;
    }

    int e(int i) {
        if (i == 0) {
            return this.N;
        }
        if (i == 1) {
            return this.O;
        }
        return 0;
    }

    public void c(androidx.constraintlayout.solver.e eVar) {
        int iB = eVar.b(this.v);
        int iB2 = eVar.b(this.w);
        int iB3 = eVar.b(this.x);
        int iB4 = eVar.b(this.y);
        int i = iB4 - iB2;
        if (iB3 - iB < 0 || i < 0 || iB == Integer.MIN_VALUE || iB == Integer.MAX_VALUE || iB2 == Integer.MIN_VALUE || iB2 == Integer.MAX_VALUE || iB3 == Integer.MIN_VALUE || iB3 == Integer.MAX_VALUE || iB4 == Integer.MIN_VALUE || iB4 == Integer.MAX_VALUE) {
            iB4 = 0;
            iB = 0;
            iB2 = 0;
            iB3 = 0;
        }
        a(iB, iB2, iB3, iB4);
    }

    public float b(int i) {
        if (i == 0) {
            return this.aa;
        }
        if (i == 1) {
            return this.ba;
        }
        return -1.0f;
    }

    public void a(ConstraintWidget constraintWidget) {
        this.G = constraintWidget;
    }

    public ArrayList<ConstraintAnchor> b() {
        return this.E;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void b(int i, int i2) {
        this.T = i;
        this.U = i2;
    }

    public void a(ConstraintWidget constraintWidget, float f2, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        a(type, constraintWidget, type, i, 0);
        this.u = f2;
    }

    public void b(int i, int i2, int i3, float f2) {
        this.g = i;
        this.l = i2;
        this.m = i3;
        this.n = f2;
        if (f2 >= 1.0f || this.g != 0) {
            return;
        }
        this.g = 2;
    }

    public void a(String str) {
        this.fa = str;
    }

    public void a(int i, int i2, int i3, float f2) {
        this.f846f = i;
        this.i = i2;
        this.j = i3;
        this.k = f2;
        if (f2 >= 1.0f || this.f846f != 0) {
            return;
        }
        this.f846f = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0084 A[PHI: r0
      0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:45:0x0084, B:35:0x007d, B:23:0x004f, B:25:0x0055, B:27:0x0061, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L8e
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L8e
        Lb:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L37
            int r6 = r2 + (-1)
            if (r3 >= r6) goto L37
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2c
            r1 = 0
            goto L35
        L2c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L35
            r1 = 1
        L35:
            int r4 = r3 + 1
        L37:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L75
            int r2 = r2 - r5
            if (r3 >= r2) goto L75
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L84
            int r3 = r9.length()
            if (r3 <= 0) goto L84
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.NumberFormatException -> L84
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L84
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L84
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L84
            if (r1 != r5) goto L6f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L6f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L75:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L84
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L84:
            r9 = 0
        L85:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8d
            r8.J = r9
            r8.K = r1
        L8d:
            return
        L8e:
            r8.J = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.b(java.lang.String):void");
    }

    public void a(float f2) {
        this.aa = f2;
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.L = i;
        this.M = i2;
        if (this.ea == 8) {
            this.H = 0;
            this.I = 0;
            return;
        }
        if (this.F[0] != DimensionBehaviour.FIXED || i7 >= (i5 = this.H)) {
            i5 = i7;
        }
        if (this.F[1] != DimensionBehaviour.FIXED || i8 >= (i6 = this.I)) {
            i6 = i8;
        }
        this.H = i5;
        this.I = i6;
        int i9 = this.I;
        int i10 = this.X;
        if (i9 < i10) {
            this.I = i10;
        }
        int i11 = this.H;
        int i12 = this.W;
        if (i11 < i12) {
            this.H = i12;
        }
        this.ka = true;
    }

    public void a(int i, int i2, int i3) {
        if (i3 == 0) {
            a(i, i2);
        } else if (i3 == 1) {
            e(i, i2);
        }
        this.ka = true;
    }

    public void a(int i, int i2) {
        this.L = i;
        this.H = i2 - i;
        int i3 = this.H;
        int i4 = this.W;
        if (i3 < i4) {
            this.H = i4;
        }
    }

    public void b(float f2) {
        this.qa[0] = f2;
    }

    public void b(DimensionBehaviour dimensionBehaviour) {
        this.F[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            g(this.Z);
        }
    }

    public void a(Object obj) {
        this.ca = obj;
    }

    public boolean a() {
        return this.ea != 8;
    }

    public void a(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        a(type).a(constraintWidget.a(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (f.f854a[type.ordinal()]) {
            case 1:
                return this.v;
            case 2:
                return this.w;
            case 3:
                return this.x;
            case 4:
                return this.y;
            case 5:
                return this.z;
            case 6:
                return this.C;
            case 7:
                return this.A;
            case 8:
                return this.B;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public void a(DimensionBehaviour dimensionBehaviour) {
        this.F[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            o(this.Y);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0254 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.constraintlayout.solver.e r39) {
        /*
            Method dump skipped, instruction units count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.a(androidx.constraintlayout.solver.e):void");
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.q == -1) {
            if (z3 && !z4) {
                this.q = 0;
            } else if (!z3 && z4) {
                this.q = 1;
                if (this.K == -1) {
                    this.r = 1.0f / this.r;
                }
            }
        }
        if (this.q == 0 && (!this.w.i() || !this.y.i())) {
            this.q = 1;
        } else if (this.q == 1 && (!this.v.i() || !this.x.i())) {
            this.q = 0;
        }
        if (this.q == -1 && (!this.w.i() || !this.y.i() || !this.v.i() || !this.x.i())) {
            if (this.w.i() && this.y.i()) {
                this.q = 0;
            } else if (this.v.i() && this.x.i()) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1) {
            if (z && !z2) {
                this.q = 0;
            } else if (!z && z2) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1) {
            if (this.i > 0 && this.l == 0) {
                this.q = 0;
            } else if (this.i == 0 && this.l > 0) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1 && z && z2) {
            this.r = 1.0f / this.r;
            this.q = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0301 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0303 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x030e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0310 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.constraintlayout.solver.e r26, boolean r27, androidx.constraintlayout.solver.SolverVariable r28, androidx.constraintlayout.solver.SolverVariable r29, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r30, boolean r31, androidx.constraintlayout.solver.widgets.ConstraintAnchor r32, androidx.constraintlayout.solver.widgets.ConstraintAnchor r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instruction units count: 836
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.a(androidx.constraintlayout.solver.e, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }
}
