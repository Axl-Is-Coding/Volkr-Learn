package androidx.constraintlayout.solver;

import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f801a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f802b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f806f;
    Type h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f803c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f804d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f805e = 0;
    float[] g = new float[7];
    b[] i = new b[8];
    int j = 0;
    public int k = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.h = type;
    }

    static void a() {
        f801a++;
    }

    public final void b(b bVar) {
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.i[i2] == bVar) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    b[] bVarArr = this.i;
                    int i4 = i2 + i3;
                    bVarArr[i4] = bVarArr[i4 + 1];
                }
                this.j--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            b[] bVarArr = this.i;
            bVarArr[i2].f816d.a(bVarArr[i2], bVar, false);
        }
        this.j = 0;
    }

    public String toString() {
        return "" + this.f802b;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.j;
            if (i >= i2) {
                b[] bVarArr = this.i;
                if (i2 >= bVarArr.length) {
                    this.i = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.i;
                int i3 = this.j;
                bVarArr2[i3] = bVar;
                this.j = i3 + 1;
                return;
            }
            if (this.i[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public void b() {
        this.f802b = null;
        this.h = Type.UNKNOWN;
        this.f805e = 0;
        this.f803c = -1;
        this.f804d = -1;
        this.f806f = WheelView.DividerConfig.FILL;
        this.j = 0;
        this.k = 0;
    }

    public void a(Type type, String str) {
        this.h = type;
    }
}
