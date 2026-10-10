package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: androidx.appcompat.widget.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0305s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PorterDuff.Mode f705a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0305s f706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private M f707c;

    public static synchronized C0305s b() {
        if (f706b == null) {
            c();
        }
        return f706b;
    }

    public static synchronized void c() {
        if (f706b == null) {
            f706b = new C0305s();
            f706b.f707c = M.a();
            f706b.f707c.a(new r());
        }
    }

    public synchronized Drawable a(Context context, int i) {
        return this.f707c.a(context, i);
    }

    synchronized Drawable a(Context context, int i, boolean z) {
        return this.f707c.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.f707c.a(context);
    }

    synchronized ColorStateList b(Context context, int i) {
        return this.f707c.b(context, i);
    }

    static void a(Drawable drawable, ga gaVar, int[] iArr) {
        M.a(drawable, gaVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        return M.a(i, mode);
    }
}
