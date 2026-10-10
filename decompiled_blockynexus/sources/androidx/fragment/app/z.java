package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.C0344r;
import androidx.lifecycle.q;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: FragmentManagerViewModel.java */
/* JADX INFO: loaded from: classes.dex */
class z extends androidx.lifecycle.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final q.a f1557c = new y();
    private final boolean g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<Fragment> f1558d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, z> f1559e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<String, C0344r> f1560f = new HashMap<>();
    private boolean h = false;
    private boolean i = false;

    z(boolean z) {
        this.g = z;
    }

    static z a(C0344r c0344r) {
        return (z) new androidx.lifecycle.q(c0344r, f1557c).a(z.class);
    }

    @Override // androidx.lifecycle.p
    protected void b() {
        if (LayoutInflaterFactory2C0343v.f1531c) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.h = true;
    }

    Collection<Fragment> c() {
        return this.f1558d;
    }

    boolean d() {
        return this.h;
    }

    boolean e(Fragment fragment) {
        return this.f1558d.remove(fragment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f1558d.equals(zVar.f1558d) && this.f1559e.equals(zVar.f1559e) && this.f1560f.equals(zVar.f1560f);
    }

    boolean f(Fragment fragment) {
        if (this.f1558d.contains(fragment)) {
            return this.g ? this.h : !this.i;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f1558d.hashCode() * 31) + this.f1559e.hashCode()) * 31) + this.f1560f.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1558d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1559e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1560f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    z c(Fragment fragment) {
        z zVar = this.f1559e.get(fragment.mWho);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this.g);
        this.f1559e.put(fragment.mWho, zVar2);
        return zVar2;
    }

    C0344r d(Fragment fragment) {
        C0344r c0344r = this.f1560f.get(fragment.mWho);
        if (c0344r != null) {
            return c0344r;
        }
        C0344r c0344r2 = new C0344r();
        this.f1560f.put(fragment.mWho, c0344r2);
        return c0344r2;
    }

    boolean a(Fragment fragment) {
        return this.f1558d.add(fragment);
    }

    void b(Fragment fragment) {
        if (LayoutInflaterFactory2C0343v.f1531c) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        z zVar = this.f1559e.get(fragment.mWho);
        if (zVar != null) {
            zVar.b();
            this.f1559e.remove(fragment.mWho);
        }
        C0344r c0344r = this.f1560f.get(fragment.mWho);
        if (c0344r != null) {
            c0344r.a();
            this.f1560f.remove(fragment.mWho);
        }
    }
}
