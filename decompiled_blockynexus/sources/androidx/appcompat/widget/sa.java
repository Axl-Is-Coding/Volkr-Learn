package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: VectorEnabledTintResources.java */
/* JADX INFO: loaded from: classes.dex */
public class sa extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f709b;

    public sa(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f709b = new WeakReference<>(context);
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.f709b.get();
        return context != null ? M.a().a(context, this, i) : super.getDrawable(i);
    }

    public static void a(boolean z) {
        f708a = z;
    }

    public static boolean a() {
        return f708a;
    }
}
