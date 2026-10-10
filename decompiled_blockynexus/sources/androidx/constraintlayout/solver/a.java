package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;

/* JADX INFO: compiled from: ArrayLinkedVariables.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f809c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f812f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private boolean k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f807a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f810d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SolverVariable f811e = null;

    a(b bVar, c cVar) {
        int i = this.f810d;
        this.f812f = new int[i];
        this.g = new int[i];
        this.h = new float[i];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f808b = bVar;
        this.f809c = cVar;
    }

    public final void a(SolverVariable solverVariable, float f2) {
        if (f2 == WheelView.DividerConfig.FILL) {
            a(solverVariable, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i2 = this.i;
            fArr[i2] = f2;
            this.f812f[i2] = solverVariable.f803c;
            this.g[i2] = -1;
            solverVariable.k++;
            solverVariable.a(this.f808b);
            this.f807a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i3 = this.j;
            int[] iArr = this.f812f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f807a; i5++) {
            int[] iArr2 = this.f812f;
            int i6 = iArr2[i];
            int i7 = solverVariable.f803c;
            if (i6 == i7) {
                this.h[i] = f2;
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.g[i];
        }
        int length = this.j;
        int i8 = length + 1;
        if (this.k) {
            int[] iArr3 = this.f812f;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i8;
        }
        int[] iArr4 = this.f812f;
        if (length >= iArr4.length && this.f807a < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.f812f;
                if (i9 >= iArr5.length) {
                    break;
                }
                if (iArr5[i9] == -1) {
                    length = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr6 = this.f812f;
        if (length >= iArr6.length) {
            length = iArr6.length;
            this.f810d *= 2;
            this.k = false;
            this.j = length - 1;
            this.h = Arrays.copyOf(this.h, this.f810d);
            this.f812f = Arrays.copyOf(this.f812f, this.f810d);
            this.g = Arrays.copyOf(this.g, this.f810d);
        }
        this.f812f[length] = solverVariable.f803c;
        this.h[length] = f2;
        if (i4 != -1) {
            int[] iArr7 = this.g;
            iArr7[length] = iArr7[i4];
            iArr7[i4] = length;
        } else {
            this.g[length] = this.i;
            this.i = length;
        }
        solverVariable.k++;
        solverVariable.a(this.f808b);
        this.f807a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f807a >= this.f812f.length) {
            this.k = true;
        }
        int i10 = this.j;
        int[] iArr8 = this.f812f;
        if (i10 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    void b() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.g[i];
        }
    }

    public String toString() {
        int i = this.i;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            str = ((str + " -> ") + this.h[i] + " : ") + this.f809c.f820c[this.f812f[i]];
            i = this.g[i];
        }
        return str;
    }

    final float b(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f807a; i3++) {
            if (i3 == i) {
                return this.h[i2];
            }
            i2 = this.g[i2];
        }
        return WheelView.DividerConfig.FILL;
    }

    public final float b(SolverVariable solverVariable) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            if (this.f812f[i] == solverVariable.f803c) {
                return this.h[i];
            }
            i = this.g[i];
        }
        return WheelView.DividerConfig.FILL;
    }

    final void a(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 == WheelView.DividerConfig.FILL) {
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i2 = this.i;
            fArr[i2] = f2;
            this.f812f[i2] = solverVariable.f803c;
            this.g[i2] = -1;
            solverVariable.k++;
            solverVariable.a(this.f808b);
            this.f807a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i3 = this.j;
            int[] iArr = this.f812f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f807a; i5++) {
            int[] iArr2 = this.f812f;
            int i6 = iArr2[i];
            int i7 = solverVariable.f803c;
            if (i6 == i7) {
                float[] fArr2 = this.h;
                fArr2[i] = fArr2[i] + f2;
                if (fArr2[i] == WheelView.DividerConfig.FILL) {
                    if (i == this.i) {
                        this.i = this.g[i];
                    } else {
                        int[] iArr3 = this.g;
                        iArr3[i4] = iArr3[i];
                    }
                    if (z) {
                        solverVariable.b(this.f808b);
                    }
                    if (this.k) {
                        this.j = i;
                    }
                    solverVariable.k--;
                    this.f807a--;
                    return;
                }
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.g[i];
        }
        int length = this.j;
        int i8 = length + 1;
        if (this.k) {
            int[] iArr4 = this.f812f;
            if (iArr4[length] != -1) {
                length = iArr4.length;
            }
        } else {
            length = i8;
        }
        int[] iArr5 = this.f812f;
        if (length >= iArr5.length && this.f807a < iArr5.length) {
            int i9 = 0;
            while (true) {
                int[] iArr6 = this.f812f;
                if (i9 >= iArr6.length) {
                    break;
                }
                if (iArr6[i9] == -1) {
                    length = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr7 = this.f812f;
        if (length >= iArr7.length) {
            length = iArr7.length;
            this.f810d *= 2;
            this.k = false;
            this.j = length - 1;
            this.h = Arrays.copyOf(this.h, this.f810d);
            this.f812f = Arrays.copyOf(this.f812f, this.f810d);
            this.g = Arrays.copyOf(this.g, this.f810d);
        }
        this.f812f[length] = solverVariable.f803c;
        this.h[length] = f2;
        if (i4 != -1) {
            int[] iArr8 = this.g;
            iArr8[length] = iArr8[i4];
            iArr8[i4] = length;
        } else {
            this.g[length] = this.i;
            this.i = length;
        }
        solverVariable.k++;
        solverVariable.a(this.f808b);
        this.f807a++;
        if (!this.k) {
            this.j++;
        }
        int i10 = this.j;
        int[] iArr9 = this.f812f;
        if (i10 >= iArr9.length) {
            this.k = true;
            this.j = iArr9.length - 1;
        }
    }

    public final float a(SolverVariable solverVariable, boolean z) {
        if (this.f811e == solverVariable) {
            this.f811e = null;
        }
        int i = this.i;
        if (i == -1) {
            return WheelView.DividerConfig.FILL;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f807a) {
            if (this.f812f[i] == solverVariable.f803c) {
                if (i == this.i) {
                    this.i = this.g[i];
                } else {
                    int[] iArr = this.g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.b(this.f808b);
                }
                solverVariable.k--;
                this.f807a--;
                this.f812f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            i2++;
            i3 = i;
            i = this.g[i];
        }
        return WheelView.DividerConfig.FILL;
    }

    public final void a() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            SolverVariable solverVariable = this.f809c.f820c[this.f812f[i]];
            if (solverVariable != null) {
                solverVariable.b(this.f808b);
            }
            i = this.g[i];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f807a = 0;
    }

    final boolean a(SolverVariable solverVariable) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            if (this.f812f[i] == solverVariable.f803c) {
                return true;
            }
            i = this.g[i];
        }
        return false;
    }

    void a(float f2) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] / f2;
            i = this.g[i];
        }
    }

    private boolean a(SolverVariable solverVariable, e eVar) {
        return solverVariable.k <= 1;
    }

    SolverVariable a(e eVar) {
        int i = this.i;
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        float f2 = WheelView.DividerConfig.FILL;
        boolean z = false;
        float f3 = WheelView.DividerConfig.FILL;
        boolean z2 = false;
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            float[] fArr = this.h;
            float f4 = fArr[i];
            SolverVariable solverVariable3 = this.f809c.f820c[this.f812f[i]];
            if (f4 < WheelView.DividerConfig.FILL) {
                if (f4 > -0.001f) {
                    fArr[i] = 0.0f;
                    solverVariable3.b(this.f808b);
                    f4 = WheelView.DividerConfig.FILL;
                }
            } else if (f4 < 0.001f) {
                fArr[i] = 0.0f;
                solverVariable3.b(this.f808b);
                f4 = WheelView.DividerConfig.FILL;
            }
            if (f4 != WheelView.DividerConfig.FILL) {
                if (solverVariable3.h == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable2 == null || f2 > f4) {
                        boolean zA = a(solverVariable3, eVar);
                        z = zA;
                        f2 = f4;
                        solverVariable2 = solverVariable3;
                    } else if (!z && a(solverVariable3, eVar)) {
                        f2 = f4;
                        solverVariable2 = solverVariable3;
                        z = true;
                    }
                } else if (solverVariable2 == null && f4 < WheelView.DividerConfig.FILL) {
                    if (solverVariable == null || f3 > f4) {
                        boolean zA2 = a(solverVariable3, eVar);
                        z2 = zA2;
                        f3 = f4;
                        solverVariable = solverVariable3;
                    } else if (!z2 && a(solverVariable3, eVar)) {
                        f3 = f4;
                        solverVariable = solverVariable3;
                        z2 = true;
                    }
                }
            }
            i = this.g[i];
        }
        return solverVariable2 != null ? solverVariable2 : solverVariable;
    }

    final void a(b bVar, b bVar2, boolean z) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
                int i3 = this.f812f[i];
                SolverVariable solverVariable = bVar2.f813a;
                if (i3 == solverVariable.f803c) {
                    float f2 = this.h[i];
                    a(solverVariable, z);
                    a aVar = bVar2.f816d;
                    int i4 = aVar.i;
                    for (int i5 = 0; i4 != -1 && i5 < aVar.f807a; i5++) {
                        a(this.f809c.f820c[aVar.f812f[i4]], aVar.h[i4] * f2, z);
                        i4 = aVar.g[i4];
                    }
                    bVar.f814b += bVar2.f814b * f2;
                    if (z) {
                        bVar2.f813a.b(bVar);
                    }
                    i = this.i;
                } else {
                    i = this.g[i];
                }
            }
            return;
        }
    }

    void a(b bVar, b[] bVarArr) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
                SolverVariable solverVariable = this.f809c.f820c[this.f812f[i]];
                if (solverVariable.f804d != -1) {
                    float f2 = this.h[i];
                    a(solverVariable, true);
                    b bVar2 = bVarArr[solverVariable.f804d];
                    if (!bVar2.f817e) {
                        a aVar = bVar2.f816d;
                        int i3 = aVar.i;
                        for (int i4 = 0; i3 != -1 && i4 < aVar.f807a; i4++) {
                            a(this.f809c.f820c[aVar.f812f[i3]], aVar.h[i3] * f2, true);
                            i3 = aVar.g[i3];
                        }
                    }
                    bVar.f814b += bVar2.f814b * f2;
                    bVar2.f813a.b(bVar);
                    i = this.i;
                } else {
                    i = this.g[i];
                }
            }
            return;
        }
    }

    SolverVariable a(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int i = this.i;
        SolverVariable solverVariable2 = null;
        float f2 = WheelView.DividerConfig.FILL;
        for (int i2 = 0; i != -1 && i2 < this.f807a; i2++) {
            if (this.h[i] < WheelView.DividerConfig.FILL) {
                SolverVariable solverVariable3 = this.f809c.f820c[this.f812f[i]];
                if ((zArr == null || !zArr[solverVariable3.f803c]) && solverVariable3 != solverVariable && ((type = solverVariable3.h) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR)) {
                    float f3 = this.h[i];
                    if (f3 < f2) {
                        solverVariable2 = solverVariable3;
                        f2 = f3;
                    }
                }
            }
            i = this.g[i];
        }
        return solverVariable2;
    }

    final SolverVariable a(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f807a; i3++) {
            if (i3 == i) {
                return this.f809c.f820c[this.f812f[i2]];
            }
            i2 = this.g[i2];
        }
        return null;
    }
}
