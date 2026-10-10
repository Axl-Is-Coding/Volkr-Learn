package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransaction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1421f;
    int g;
    boolean h;
    String j;
    int k;
    CharSequence l;
    int m;
    CharSequence n;
    ArrayList<String> o;
    ArrayList<String> p;
    ArrayList<Runnable> r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<a> f1416a = new ArrayList<>();
    boolean i = true;
    boolean q = false;

    /* JADX INFO: compiled from: FragmentTransaction.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Fragment f1423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1426e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1427f;
        Lifecycle.State g;
        Lifecycle.State h;

        a() {
        }

        a(int i, Fragment fragment) {
            this.f1422a = i;
            this.f1423b = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.g = state;
            this.h = state;
        }

        a(int i, Fragment fragment, Lifecycle.State state) {
            this.f1422a = i;
            this.f1423b = fragment;
            this.g = fragment.mMaxState;
            this.h = state;
        }
    }

    public abstract int a();

    void a(a aVar) {
        this.f1416a.add(aVar);
        aVar.f1424c = this.f1417b;
        aVar.f1425d = this.f1418c;
        aVar.f1426e = this.f1419d;
        aVar.f1427f = this.f1420e;
    }

    public abstract int b();

    public F b(int i, Fragment fragment) {
        b(i, fragment, null);
        return this;
    }

    public F c(Fragment fragment) {
        a(new a(4, fragment));
        return this;
    }

    public abstract void c();

    public F d(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public abstract void d();

    public F e(Fragment fragment) {
        a(new a(5, fragment));
        return this;
    }

    public abstract boolean f();

    public F b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, 2);
        return this;
    }

    public F e() {
        if (this.h) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.i = false;
        return this;
    }

    public F b(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public F a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public F a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public F a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = fragment.mTag;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
                }
                fragment.mTag = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = fragment.mFragmentId;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                    }
                    fragment.mFragmentId = i;
                    fragment.mContainerId = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            a(new a(i2, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public F a(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public F a(Fragment fragment, Lifecycle.State state) {
        a(new a(10, fragment, state));
        return this;
    }

    public F a(int i) {
        this.f1421f = i;
        return this;
    }

    public F a(String str) {
        if (this.i) {
            this.h = true;
            this.j = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
}
