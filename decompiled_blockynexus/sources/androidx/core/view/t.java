package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* JADX INFO: compiled from: PointerIconCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f1272a;

    private t(Object obj) {
        this.f1272a = obj;
    }

    public Object a() {
        return this.f1272a;
    }

    public static t a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new t(PointerIcon.getSystemIcon(context, i)) : new t(null);
    }
}
