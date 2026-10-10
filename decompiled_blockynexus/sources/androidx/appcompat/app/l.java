package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.C0281a;
import androidx.appcompat.d.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.sa;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: AppCompatDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f311a = -100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a.a.d<WeakReference<l>> f312b = new a.a.d<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f313c = new Object();

    l() {
    }

    public static l a(Activity activity, k kVar) {
        return new AppCompatDelegateImpl(activity, kVar);
    }

    static void b(l lVar) {
        synchronized (f313c) {
            c(lVar);
        }
    }

    private static void c(l lVar) {
        synchronized (f313c) {
            Iterator<WeakReference<l>> it = f312b.iterator();
            while (it.hasNext()) {
                l lVar2 = it.next().get();
                if (lVar2 == lVar || lVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract <T extends View> T a(int i);

    public abstract androidx.appcompat.d.b a(b.a aVar);

    public void a(Context context) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public abstract C0281a.InterfaceC0002a b();

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean b(int i);

    public int c() {
        return -100;
    }

    public abstract void c(int i);

    public abstract void c(Bundle bundle);

    public abstract MenuInflater d();

    public void d(int i) {
    }

    public abstract ActionBar e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public static l a(Dialog dialog, k kVar) {
        return new AppCompatDelegateImpl(dialog, kVar);
    }

    public static int a() {
        return f311a;
    }

    public static void a(boolean z) {
        sa.a(z);
    }

    static void a(l lVar) {
        synchronized (f313c) {
            c(lVar);
            f312b.add(new WeakReference<>(lVar));
        }
    }
}
