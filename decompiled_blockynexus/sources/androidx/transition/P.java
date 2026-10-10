package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: compiled from: SidePropagation.java */
/* JADX INFO: loaded from: classes.dex */
public class P extends Da {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2184b = 3.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2185c = 80;

    public void a(int i) {
        this.f2185c = i;
    }

    @Override // androidx.transition.AbstractC0385ea
    public long a(ViewGroup viewGroup, Transition transition, ha haVar, ha haVar2) {
        int i;
        int iCenterX;
        int iCenterY;
        ha haVar3 = haVar;
        if (haVar3 == null && haVar2 == null) {
            return 0L;
        }
        Rect rectD = transition.d();
        if (haVar2 == null || b(haVar3) == 0) {
            i = -1;
        } else {
            haVar3 = haVar2;
            i = 1;
        }
        int iC = c(haVar3);
        int iD = d(haVar3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (rectD != null) {
            iCenterX = rectD.centerX();
            iCenterY = rectD.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fA = a(viewGroup, iC, iD, iCenterX, iCenterY, iRound, iRound2, width, height) / a(viewGroup);
        long jC = transition.c();
        if (jC < 0) {
            jC = 300;
        }
        return Math.round(((jC * ((long) i)) / this.f2184b) * fA);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(android.view.View r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        /*
            r6 = this;
            int r0 = r6.f2185c
            r1 = 5
            r2 = 3
            r3 = 0
            r4 = 1
            r5 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 != r5) goto L19
            int r7 = androidx.core.view.ViewCompat.m(r7)
            if (r7 != r4) goto L12
            goto L13
        L12:
            r4 = 0
        L13:
            if (r4 == 0) goto L17
        L15:
            r0 = 5
            goto L29
        L17:
            r0 = 3
            goto L29
        L19:
            r5 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r5) goto L29
            int r7 = androidx.core.view.ViewCompat.m(r7)
            if (r7 != r4) goto L25
            goto L26
        L25:
            r4 = 0
        L26:
            if (r4 == 0) goto L15
            goto L17
        L29:
            if (r0 == r2) goto L51
            if (r0 == r1) goto L48
            r7 = 48
            if (r0 == r7) goto L3f
            r7 = 80
            if (r0 == r7) goto L36
            goto L59
        L36:
            int r9 = r9 - r13
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r9 + r7
            goto L59
        L3f:
            int r15 = r15 - r9
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r15 + r7
            goto L59
        L48:
            int r8 = r8 - r12
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r8 + r7
            goto L59
        L51:
            int r14 = r14 - r8
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r14 + r7
        L59:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.P.a(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int a(ViewGroup viewGroup) {
        int i = this.f2185c;
        if (i != 3 && i != 5 && i != 8388611 && i != 8388613) {
            return viewGroup.getHeight();
        }
        return viewGroup.getWidth();
    }
}
