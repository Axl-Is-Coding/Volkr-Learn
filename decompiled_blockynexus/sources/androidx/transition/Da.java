package androidx.transition;

import android.view.View;

/* JADX INFO: compiled from: VisibilityPropagation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Da extends AbstractC0385ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2159a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    @Override // androidx.transition.AbstractC0385ea
    public void a(ha haVar) {
        View view = haVar.f2247b;
        Integer numValueOf = (Integer) haVar.f2246a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        haVar.f2246a.put("android:visibilityPropagation:visibility", numValueOf);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        haVar.f2246a.put("android:visibilityPropagation:center", iArr);
    }

    public int b(ha haVar) {
        Integer num;
        if (haVar == null || (num = (Integer) haVar.f2246a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int c(ha haVar) {
        return a(haVar, 0);
    }

    public int d(ha haVar) {
        return a(haVar, 1);
    }

    @Override // androidx.transition.AbstractC0385ea
    public String[] a() {
        return f2159a;
    }

    private static int a(ha haVar, int i) {
        int[] iArr;
        if (haVar == null || (iArr = (int[]) haVar.f2246a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }
}
