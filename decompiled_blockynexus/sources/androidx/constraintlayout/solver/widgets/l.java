package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: Optimizer.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean[] f863a = new boolean[3];

    static void a(g gVar, androidx.constraintlayout.solver.e eVar, ConstraintWidget constraintWidget) {
        if (gVar.F[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.v.f839e;
            int iS = gVar.s() - constraintWidget.x.f839e;
            ConstraintAnchor constraintAnchor = constraintWidget.v;
            constraintAnchor.j = eVar.a(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.x;
            constraintAnchor2.j = eVar.a(constraintAnchor2);
            eVar.a(constraintWidget.v.j, i);
            eVar.a(constraintWidget.x.j, iS);
            constraintWidget.f842b = 2;
            constraintWidget.a(i, iS);
        }
        if (gVar.F[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.F[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i2 = constraintWidget.w.f839e;
        int i3 = gVar.i() - constraintWidget.y.f839e;
        ConstraintAnchor constraintAnchor3 = constraintWidget.w;
        constraintAnchor3.j = eVar.a(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.y;
        constraintAnchor4.j = eVar.a(constraintAnchor4);
        eVar.a(constraintWidget.w.j, i2);
        eVar.a(constraintWidget.y.j, i3);
        if (constraintWidget.V > 0 || constraintWidget.r() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.z;
            constraintAnchor5.j = eVar.a(constraintAnchor5);
            eVar.a(constraintWidget.z.j, constraintWidget.V + i2);
        }
        constraintWidget.f843c = 2;
        constraintWidget.e(i2, i3);
    }

    private static boolean a(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.F;
        if (dimensionBehaviourArr[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.J != WheelView.DividerConfig.FILL) {
            if (dimensionBehaviourArr[i != 0 ? (char) 0 : (char) 1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (constraintWidget.f846f != 0 || constraintWidget.i != 0 || constraintWidget.j != 0) {
                return false;
            }
        } else if (constraintWidget.g != 0 || constraintWidget.l != 0 || constraintWidget.m != 0) {
            return false;
        }
        return true;
    }

    static void a(int i, ConstraintWidget constraintWidget) {
        constraintWidget.I();
        n nVarD = constraintWidget.v.d();
        n nVarD2 = constraintWidget.w.d();
        n nVarD3 = constraintWidget.x.d();
        n nVarD4 = constraintWidget.y.d();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(constraintWidget, 0);
        if (nVarD.i != 4 && nVarD3.i != 4) {
            if (constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.r() == 8)) {
                if (constraintWidget.v.f838d == null && constraintWidget.x.f838d == null) {
                    nVarD.b(1);
                    nVarD3.b(1);
                    if (z) {
                        nVarD3.a(nVarD, 1, constraintWidget.m());
                    } else {
                        nVarD3.a(nVarD, constraintWidget.s());
                    }
                } else if (constraintWidget.v.f838d != null && constraintWidget.x.f838d == null) {
                    nVarD.b(1);
                    nVarD3.b(1);
                    if (z) {
                        nVarD3.a(nVarD, 1, constraintWidget.m());
                    } else {
                        nVarD3.a(nVarD, constraintWidget.s());
                    }
                } else if (constraintWidget.v.f838d == null && constraintWidget.x.f838d != null) {
                    nVarD.b(1);
                    nVarD3.b(1);
                    nVarD.a(nVarD3, -constraintWidget.s());
                    if (z) {
                        nVarD.a(nVarD3, -1, constraintWidget.m());
                    } else {
                        nVarD.a(nVarD3, -constraintWidget.s());
                    }
                } else if (constraintWidget.v.f838d != null && constraintWidget.x.f838d != null) {
                    nVarD.b(2);
                    nVarD3.b(2);
                    if (z) {
                        constraintWidget.m().a(nVarD);
                        constraintWidget.m().a(nVarD3);
                        nVarD.b(nVarD3, -1, constraintWidget.m());
                        nVarD3.b(nVarD, 1, constraintWidget.m());
                    } else {
                        nVarD.b(nVarD3, -constraintWidget.s());
                        nVarD3.b(nVarD, constraintWidget.s());
                    }
                }
            } else if (z2) {
                int iS = constraintWidget.s();
                nVarD.b(1);
                nVarD3.b(1);
                if (constraintWidget.v.f838d == null && constraintWidget.x.f838d == null) {
                    if (z) {
                        nVarD3.a(nVarD, 1, constraintWidget.m());
                    } else {
                        nVarD3.a(nVarD, iS);
                    }
                } else if (constraintWidget.v.f838d == null || constraintWidget.x.f838d != null) {
                    if (constraintWidget.v.f838d != null || constraintWidget.x.f838d == null) {
                        if (constraintWidget.v.f838d != null && constraintWidget.x.f838d != null) {
                            if (z) {
                                constraintWidget.m().a(nVarD);
                                constraintWidget.m().a(nVarD3);
                            }
                            if (constraintWidget.J == WheelView.DividerConfig.FILL) {
                                nVarD.b(3);
                                nVarD3.b(3);
                                nVarD.b(nVarD3, WheelView.DividerConfig.FILL);
                                nVarD3.b(nVarD, WheelView.DividerConfig.FILL);
                            } else {
                                nVarD.b(2);
                                nVarD3.b(2);
                                nVarD.b(nVarD3, -iS);
                                nVarD3.b(nVarD, iS);
                                constraintWidget.o(iS);
                            }
                        }
                    } else if (z) {
                        nVarD.a(nVarD3, -1, constraintWidget.m());
                    } else {
                        nVarD.a(nVarD3, -iS);
                    }
                } else if (z) {
                    nVarD3.a(nVarD, 1, constraintWidget.m());
                } else {
                    nVarD3.a(nVarD, iS);
                }
            }
        }
        boolean z3 = constraintWidget.F[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(constraintWidget, 1);
        if (nVarD2.i == 4 || nVarD4.i == 4) {
            return;
        }
        if (constraintWidget.F[1] != ConstraintWidget.DimensionBehaviour.FIXED && (!z3 || constraintWidget.r() != 8)) {
            if (z3) {
                int i2 = constraintWidget.i();
                nVarD2.b(1);
                nVarD4.b(1);
                if (constraintWidget.w.f838d == null && constraintWidget.y.f838d == null) {
                    if (z) {
                        nVarD4.a(nVarD2, 1, constraintWidget.l());
                        return;
                    } else {
                        nVarD4.a(nVarD2, i2);
                        return;
                    }
                }
                if (constraintWidget.w.f838d != null && constraintWidget.y.f838d == null) {
                    if (z) {
                        nVarD4.a(nVarD2, 1, constraintWidget.l());
                        return;
                    } else {
                        nVarD4.a(nVarD2, i2);
                        return;
                    }
                }
                if (constraintWidget.w.f838d == null && constraintWidget.y.f838d != null) {
                    if (z) {
                        nVarD2.a(nVarD4, -1, constraintWidget.l());
                        return;
                    } else {
                        nVarD2.a(nVarD4, -i2);
                        return;
                    }
                }
                if (constraintWidget.w.f838d == null || constraintWidget.y.f838d == null) {
                    return;
                }
                if (z) {
                    constraintWidget.l().a(nVarD2);
                    constraintWidget.m().a(nVarD4);
                }
                if (constraintWidget.J == WheelView.DividerConfig.FILL) {
                    nVarD2.b(3);
                    nVarD4.b(3);
                    nVarD2.b(nVarD4, WheelView.DividerConfig.FILL);
                    nVarD4.b(nVarD2, WheelView.DividerConfig.FILL);
                    return;
                }
                nVarD2.b(2);
                nVarD4.b(2);
                nVarD2.b(nVarD4, -i2);
                nVarD4.b(nVarD2, i2);
                constraintWidget.g(i2);
                if (constraintWidget.V > 0) {
                    constraintWidget.z.d().a(1, nVarD2, constraintWidget.V);
                    return;
                }
                return;
            }
            return;
        }
        if (constraintWidget.w.f838d == null && constraintWidget.y.f838d == null) {
            nVarD2.b(1);
            nVarD4.b(1);
            if (z) {
                nVarD4.a(nVarD2, 1, constraintWidget.l());
            } else {
                nVarD4.a(nVarD2, constraintWidget.i());
            }
            ConstraintAnchor constraintAnchor = constraintWidget.z;
            if (constraintAnchor.f838d != null) {
                constraintAnchor.d().b(1);
                nVarD2.a(1, constraintWidget.z.d(), -constraintWidget.V);
                return;
            }
            return;
        }
        if (constraintWidget.w.f838d != null && constraintWidget.y.f838d == null) {
            nVarD2.b(1);
            nVarD4.b(1);
            if (z) {
                nVarD4.a(nVarD2, 1, constraintWidget.l());
            } else {
                nVarD4.a(nVarD2, constraintWidget.i());
            }
            if (constraintWidget.V > 0) {
                constraintWidget.z.d().a(1, nVarD2, constraintWidget.V);
                return;
            }
            return;
        }
        if (constraintWidget.w.f838d == null && constraintWidget.y.f838d != null) {
            nVarD2.b(1);
            nVarD4.b(1);
            if (z) {
                nVarD2.a(nVarD4, -1, constraintWidget.l());
            } else {
                nVarD2.a(nVarD4, -constraintWidget.i());
            }
            if (constraintWidget.V > 0) {
                constraintWidget.z.d().a(1, nVarD2, constraintWidget.V);
                return;
            }
            return;
        }
        if (constraintWidget.w.f838d == null || constraintWidget.y.f838d == null) {
            return;
        }
        nVarD2.b(2);
        nVarD4.b(2);
        if (z) {
            nVarD2.b(nVarD4, -1, constraintWidget.l());
            nVarD4.b(nVarD2, 1, constraintWidget.l());
            constraintWidget.l().a(nVarD2);
            constraintWidget.m().a(nVarD4);
        } else {
            nVarD2.b(nVarD4, -constraintWidget.i());
            nVarD4.b(nVarD2, constraintWidget.i());
        }
        if (constraintWidget.V > 0) {
            constraintWidget.z.d().a(1, nVarD2, constraintWidget.V);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[PHI: r11 r12
      0x0034: PHI (r11v14 boolean) = (r11v2 boolean), (r11v17 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x0034: PHI (r12v8 boolean) = (r12v2 boolean), (r12v11 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[PHI: r11 r12
      0x0036: PHI (r11v4 boolean) = (r11v2 boolean), (r11v17 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x0036: PHI (r12v4 boolean) = (r12v2 boolean), (r12v11 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0319 A[PHI: r3
      0x0319: PHI (r3v20 float) = (r3v16 float), (r3v14 float) binds: [B:201:0x0371, B:191:0x0316] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(androidx.constraintlayout.solver.widgets.g r24, androidx.constraintlayout.solver.e r25, int r26, int r27, androidx.constraintlayout.solver.widgets.d r28) {
        /*
            Method dump skipped, instruction units count: 900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.l.a(androidx.constraintlayout.solver.widgets.g, androidx.constraintlayout.solver.e, int, int, androidx.constraintlayout.solver.widgets.d):boolean");
    }

    static void a(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.D[i3].d().g = constraintWidget.k().v.d();
        constraintWidget.D[i3].d().h = i2;
        constraintWidget.D[i3].d().f870b = 1;
        constraintWidget.D[i4].d().g = constraintWidget.D[i3].d();
        constraintWidget.D[i4].d().h = constraintWidget.d(i);
        constraintWidget.D[i4].d().f870b = 1;
    }
}
