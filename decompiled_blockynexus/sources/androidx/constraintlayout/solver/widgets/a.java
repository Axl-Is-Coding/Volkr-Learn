package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Analyzer.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(g gVar) {
        if ((gVar.M() & 32) != 32) {
            b(gVar);
            return;
        }
        gVar.Oa = true;
        gVar.Ia = false;
        gVar.Ja = false;
        gVar.Ka = false;
        ArrayList<ConstraintWidget> arrayList = gVar.va;
        List<h> list = gVar.Ha;
        boolean z = gVar.j() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = gVar.q() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.s = null;
            constraintWidget.la = false;
            constraintWidget.F();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.s == null && !a(constraintWidget2, list, z3)) {
                b(gVar);
                gVar.Oa = false;
                return;
            }
        }
        int iMax = 0;
        int iMax2 = 0;
        for (h hVar : list) {
            iMax = Math.max(iMax, a(hVar, 0));
            iMax2 = Math.max(iMax2, a(hVar, 1));
        }
        if (z) {
            gVar.a(ConstraintWidget.DimensionBehaviour.FIXED);
            gVar.o(iMax);
            gVar.Ia = true;
            gVar.Ja = true;
            gVar.La = iMax;
        }
        if (z2) {
            gVar.b(ConstraintWidget.DimensionBehaviour.FIXED);
            gVar.g(iMax2);
            gVar.Ia = true;
            gVar.Ka = true;
            gVar.Ma = iMax2;
        }
        a(list, 0, gVar.s());
        a(list, 1, gVar.i());
    }

    private static void b(g gVar) {
        gVar.Ha.clear();
        gVar.Ha.add(0, new h(gVar.va));
    }

    private static boolean a(ConstraintWidget constraintWidget, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return a(constraintWidget, hVar, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(androidx.constraintlayout.solver.widgets.ConstraintWidget r8, androidx.constraintlayout.solver.widgets.h r9, java.util.List<androidx.constraintlayout.solver.widgets.h> r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.a.a(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.h, java.util.List, boolean):boolean");
    }

    private static void a(g gVar, ConstraintWidget constraintWidget, h hVar) {
        hVar.f859d = false;
        gVar.Oa = false;
        constraintWidget.ja = false;
    }

    private static int a(h hVar, int i) {
        int i2 = i * 2;
        List<ConstraintWidget> listA = hVar.a(i);
        int size = listA.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = listA.get(i3);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
            int i4 = i2 + 1;
            iMax = Math.max(iMax, a(constraintWidget, i, constraintAnchorArr[i4].f838d == null || !(constraintAnchorArr[i2].f838d == null || constraintAnchorArr[i4].f838d == null), 0));
        }
        hVar.f860e[i] = iMax;
        return iMax;
    }

    private static int a(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        int i3;
        int iC;
        int i4;
        int i5;
        int i6;
        int i7;
        int iS;
        int i8;
        int i9;
        int i10;
        int iMax = 0;
        if (!constraintWidget.ja) {
            return 0;
        }
        boolean z2 = constraintWidget.z.f838d != null && i == 1;
        if (z) {
            i3 = constraintWidget.c();
            iC = constraintWidget.i() - constraintWidget.c();
            i5 = i * 2;
            i4 = i5 + 1;
        } else {
            i3 = constraintWidget.i() - constraintWidget.c();
            iC = constraintWidget.c();
            i4 = i * 2;
            i5 = i4 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
        if (constraintAnchorArr[i4].f838d == null || constraintAnchorArr[i5].f838d != null) {
            i6 = i4;
            i7 = 1;
        } else {
            i6 = i5;
            i5 = i4;
            i7 = -1;
        }
        int i11 = z2 ? i2 - i3 : i2;
        int iB = (constraintWidget.D[i5].b() * i7) + a(constraintWidget, i);
        int i12 = i11 + iB;
        int iS2 = (i == 0 ? constraintWidget.s() : constraintWidget.i()) * i7;
        Iterator<p> it = constraintWidget.D[i5].d().f869a.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, a(((n) it.next()).f864c.f836b, i, z, i12));
        }
        int iMax2 = 0;
        for (Iterator<p> it2 = constraintWidget.D[i6].d().f869a.iterator(); it2.hasNext(); it2 = it2) {
            iMax2 = Math.max(iMax2, a(((n) it2.next()).f864c.f836b, i, z, iS2 + i12));
        }
        if (z2) {
            iMax -= i3;
            iS = iMax2 + iC;
        } else {
            iS = iMax2 + ((i == 0 ? constraintWidget.s() : constraintWidget.i()) * i7);
        }
        int i13 = 1;
        if (i == 1) {
            Iterator<p> it3 = constraintWidget.z.d().f869a.iterator();
            int iMax3 = 0;
            while (it3.hasNext()) {
                Iterator<p> it4 = it3;
                n nVar = (n) it3.next();
                if (i7 == i13) {
                    iMax3 = Math.max(iMax3, a(nVar.f864c.f836b, i, z, i3 + i12));
                    i10 = i6;
                } else {
                    i10 = i6;
                    iMax3 = Math.max(iMax3, a(nVar.f864c.f836b, i, z, (iC * i7) + i12));
                }
                it3 = it4;
                i6 = i10;
                i13 = 1;
            }
            i8 = i6;
            int i14 = iMax3;
            i9 = (constraintWidget.z.d().f869a.size() <= 0 || z2) ? i14 : i7 == 1 ? i14 + i3 : i14 - iC;
        } else {
            i8 = i6;
            i9 = 0;
        }
        int iMax4 = iB + Math.max(iMax, Math.max(iS, i9));
        int i15 = i12 + iS2;
        if (i7 != -1) {
            i12 = i15;
            i15 = i12;
        }
        if (z) {
            l.a(constraintWidget, i, i15);
            constraintWidget.a(i15, i12, i);
        } else {
            constraintWidget.s.a(constraintWidget, i);
            constraintWidget.d(i15, i);
        }
        if (constraintWidget.c(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.J != WheelView.DividerConfig.FILL) {
            constraintWidget.s.a(constraintWidget, i);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.D;
        if (constraintAnchorArr2[i5].f838d != null && constraintAnchorArr2[i8].f838d != null) {
            ConstraintWidget constraintWidgetK = constraintWidget.k();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.D;
            if (constraintAnchorArr3[i5].f838d.f836b == constraintWidgetK && constraintAnchorArr3[i8].f838d.f836b == constraintWidgetK) {
                constraintWidget.s.a(constraintWidget, i);
            }
        }
        return iMax4;
    }

    private static void a(ConstraintAnchor constraintAnchor) {
        n nVarD = constraintAnchor.d();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f838d;
        if (constraintAnchor2 == null || constraintAnchor2.f838d == constraintAnchor) {
            return;
        }
        constraintAnchor2.d().a(nVarD);
    }

    public static void a(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget constraintWidget : list.get(i3).b(i)) {
                if (constraintWidget.ja) {
                    a(constraintWidget, i, i2);
                }
            }
        }
    }

    private static void a(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3 + 1];
        if ((constraintAnchor.f838d == null || constraintAnchor2.f838d == null) ? false : true) {
            l.a(constraintWidget, i, a(constraintWidget, i) + constraintAnchor.b());
            return;
        }
        if (constraintWidget.J != WheelView.DividerConfig.FILL && constraintWidget.c(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int iA = a(constraintWidget);
            int i4 = (int) constraintWidget.D[i3].d().h;
            constraintAnchor2.d().g = constraintAnchor.d();
            constraintAnchor2.d().h = iA;
            constraintAnchor2.d().f870b = 1;
            constraintWidget.a(i4, i4 + iA, i);
            return;
        }
        int iE = i2 - constraintWidget.e(i);
        int iD = iE - constraintWidget.d(i);
        constraintWidget.a(iD, iE, i);
        l.a(constraintWidget, i, iD);
    }

    private static int a(ConstraintWidget constraintWidget, int i) {
        ConstraintAnchor constraintAnchor;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.f838d;
        if (constraintAnchor4 == null) {
            return 0;
        }
        ConstraintWidget constraintWidget2 = constraintAnchor4.f836b;
        ConstraintWidget constraintWidget3 = constraintWidget.G;
        if (constraintWidget2 != constraintWidget3 || (constraintAnchor = constraintAnchor3.f838d) == null || constraintAnchor.f836b != constraintWidget3) {
            return 0;
        }
        return (int) ((((constraintWidget3.d(i) - constraintAnchor2.b()) - constraintAnchor3.b()) - constraintWidget.d(i)) * (i == 0 ? constraintWidget.aa : constraintWidget.ba));
    }

    private static int a(ConstraintWidget constraintWidget) {
        float fS;
        float fI;
        if (constraintWidget.j() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.K == 0) {
                fI = constraintWidget.i() * constraintWidget.J;
            } else {
                fI = constraintWidget.i() / constraintWidget.J;
            }
            int i = (int) fI;
            constraintWidget.o(i);
            return i;
        }
        if (constraintWidget.q() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return -1;
        }
        if (constraintWidget.K == 1) {
            fS = constraintWidget.s() * constraintWidget.J;
        } else {
            fS = constraintWidget.s() / constraintWidget.J;
        }
        int i2 = (int) fS;
        constraintWidget.g(i2);
        return i2;
    }
}
