package androidx.databinding;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: DataBindingUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f1351a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f1352b = null;

    public static d a() {
        return f1352b;
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        return (T) a(layoutInflater, i, viewGroup, z, f1352b);
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, d dVar) {
        boolean z2 = viewGroup != null && z;
        int childCount = z2 ? viewGroup.getChildCount() : 0;
        View viewInflate = layoutInflater.inflate(i, viewGroup, z);
        if (z2) {
            return (T) a(dVar, viewGroup, childCount, i);
        }
        return (T) a(dVar, viewInflate, i);
    }

    static <T extends ViewDataBinding> T a(d dVar, View[] viewArr, int i) {
        return (T) f1351a.getDataBinder(dVar, viewArr, i);
    }

    static <T extends ViewDataBinding> T a(d dVar, View view, int i) {
        return (T) f1351a.getDataBinder(dVar, view, i);
    }

    public static <T extends ViewDataBinding> T a(View view) {
        return (T) ViewDataBinding.getBinding(view);
    }

    public static <T extends ViewDataBinding> T a(Activity activity, int i) {
        return (T) a(activity, i, f1352b);
    }

    public static <T extends ViewDataBinding> T a(Activity activity, int i, d dVar) {
        activity.setContentView(i);
        return (T) a(dVar, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i);
    }

    public static String a(int i) {
        return f1351a.convertBrIdToString(i);
    }

    private static <T extends ViewDataBinding> T a(d dVar, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return (T) a(dVar, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return (T) a(dVar, viewArr, i2);
    }
}
