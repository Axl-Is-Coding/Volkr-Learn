package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.transition.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CircularPropagation.java */
/* JADX INFO: loaded from: classes.dex */
public class C0402t extends Da {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2296b = 3.0f;

    @Override // androidx.transition.AbstractC0385ea
    public long a(ViewGroup viewGroup, Transition transition, ha haVar, ha haVar2) {
        int i;
        int iRound;
        int iCenterX;
        if (haVar == null && haVar2 == null) {
            return 0L;
        }
        if (haVar2 == null || b(haVar) == 0) {
            i = -1;
        } else {
            haVar = haVar2;
            i = 1;
        }
        int iC = c(haVar);
        int iD = d(haVar);
        Rect rectD = transition.d();
        if (rectD != null) {
            iCenterX = rectD.centerX();
            iRound = rectD.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int iRound2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fA = a(iC, iD, iCenterX, iRound) / a(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, viewGroup.getWidth(), viewGroup.getHeight());
        long jC = transition.c();
        if (jC < 0) {
            jC = 300;
        }
        return Math.round(((jC * ((long) i)) / this.f2296b) * fA);
    }

    private static float a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }
}
