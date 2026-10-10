package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0336n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C0334l f1514a = new C0334l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0334l f1515b = null;

    /* JADX INFO: renamed from: androidx.fragment.app.n$a */
    /* JADX INFO: compiled from: FragmentManager.java */
    public interface a {
        String getName();
    }

    /* JADX INFO: renamed from: androidx.fragment.app.n$b */
    /* JADX INFO: compiled from: FragmentManager.java */
    public static abstract class b {
        public abstract void a(AbstractC0336n abstractC0336n, Fragment fragment);

        public abstract void a(AbstractC0336n abstractC0336n, Fragment fragment, Context context);

        public abstract void a(AbstractC0336n abstractC0336n, Fragment fragment, Bundle bundle);

        public abstract void a(AbstractC0336n abstractC0336n, Fragment fragment, View view, Bundle bundle);

        public abstract void b(AbstractC0336n abstractC0336n, Fragment fragment);

        public abstract void b(AbstractC0336n abstractC0336n, Fragment fragment, Context context);

        public abstract void b(AbstractC0336n abstractC0336n, Fragment fragment, Bundle bundle);

        public abstract void c(AbstractC0336n abstractC0336n, Fragment fragment);

        public abstract void c(AbstractC0336n abstractC0336n, Fragment fragment, Bundle bundle);

        public abstract void d(AbstractC0336n abstractC0336n, Fragment fragment);

        public abstract void d(AbstractC0336n abstractC0336n, Fragment fragment, Bundle bundle);

        public abstract void e(AbstractC0336n abstractC0336n, Fragment fragment);

        public abstract void f(AbstractC0336n abstractC0336n, Fragment fragment);

        public abstract void g(AbstractC0336n abstractC0336n, Fragment fragment);
    }

    /* JADX INFO: renamed from: androidx.fragment.app.n$c */
    /* JADX INFO: compiled from: FragmentManager.java */
    public interface c {
        void onBackStackChanged();
    }

    public abstract F a();

    public abstract Fragment.c a(Fragment fragment);

    public abstract Fragment a(int i);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract void a(int i, int i2);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public void a(C0334l c0334l) {
        this.f1515b = c0334l;
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract a b(int i);

    public abstract boolean b();

    public abstract int c();

    public C0334l d() {
        if (this.f1515b == null) {
            this.f1515b = f1514a;
        }
        return this.f1515b;
    }

    public abstract List<Fragment> e();

    public abstract void f();

    public abstract boolean g();
}
