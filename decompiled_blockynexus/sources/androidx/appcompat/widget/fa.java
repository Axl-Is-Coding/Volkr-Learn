package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: TintContextWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class fa extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f643a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ArrayList<WeakReference<fa>> f644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resources f645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Resources.Theme f646d;

    private fa(Context context) {
        super(context);
        if (!sa.b()) {
            this.f645c = new ha(this, context.getResources());
            this.f646d = null;
        } else {
            this.f645c = new sa(this, context.getResources());
            this.f646d = this.f645c.newTheme();
            this.f646d.setTo(context.getTheme());
        }
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f643a) {
            if (f644b == null) {
                f644b = new ArrayList<>();
            } else {
                for (int size = f644b.size() - 1; size >= 0; size--) {
                    WeakReference<fa> weakReference = f644b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f644b.remove(size);
                    }
                }
                for (int size2 = f644b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<fa> weakReference2 = f644b.get(size2);
                    fa faVar = weakReference2 != null ? weakReference2.get() : null;
                    if (faVar != null && faVar.getBaseContext() == context) {
                        return faVar;
                    }
                }
            }
            fa faVar2 = new fa(context);
            f644b.add(new WeakReference<>(faVar2));
            return faVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof fa) || (context.getResources() instanceof ha) || (context.getResources() instanceof sa)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || sa.b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f645c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f645c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f646d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f646d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
