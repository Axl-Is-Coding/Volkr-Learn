package androidx.constraintlayout.solver.widgets;

/* JADX INFO: compiled from: Chain.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    static void a(g gVar, androidx.constraintlayout.solver.e eVar, int i) {
        int i2;
        int i3;
        d[] dVarArr;
        if (i == 0) {
            int i4 = gVar.Da;
            dVarArr = gVar.Ga;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = gVar.Ea;
            dVarArr = gVar.Fa;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            d dVar = dVarArr[i5];
            dVar.a();
            if (!gVar.t(4)) {
                a(gVar, eVar, i, i2, dVar);
            } else if (!l.a(gVar, eVar, i, i2, dVar)) {
                a(gVar, eVar, i, i2, dVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a A[PHI: r8 r14
      0x004a: PHI (r8v4 boolean) = (r8v2 boolean), (r8v42 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r14v4 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004c A[PHI: r8 r14
      0x004c: PHI (r8v39 boolean) = (r8v2 boolean), (r8v42 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r14v16 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(androidx.constraintlayout.solver.widgets.g r36, androidx.constraintlayout.solver.e r37, int r38, int r39, androidx.constraintlayout.solver.widgets.d r40) {
        /*
            Method dump skipped, instruction units count: 1279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.c.a(androidx.constraintlayout.solver.widgets.g, androidx.constraintlayout.solver.e, int, int, androidx.constraintlayout.solver.widgets.d):void");
    }
}
