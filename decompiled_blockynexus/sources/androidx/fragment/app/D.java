package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentStatePagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class D extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0336n f1410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private F f1412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<Fragment.c> f1413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f1414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Fragment f1415f;

    @Deprecated
    public D(AbstractC0336n abstractC0336n) {
        this(abstractC0336n, 0);
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f1412c == null) {
            this.f1412c = this.f1410a.a();
        }
        while (this.f1413d.size() <= i) {
            this.f1413d.add(null);
        }
        this.f1413d.set(i, fragment.isAdded() ? this.f1410a.a(fragment) : null);
        this.f1414e.set(i, null);
        this.f1412c.d(fragment);
        if (fragment == this.f1415f) {
            this.f1415f = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup) {
        F f2 = this.f1412c;
        if (f2 != null) {
            f2.d();
            this.f1412c = null;
        }
    }

    public abstract Fragment getItem(int i);

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.c cVar;
        Fragment fragment;
        if (this.f1414e.size() > i && (fragment = this.f1414e.get(i)) != null) {
            return fragment;
        }
        if (this.f1412c == null) {
            this.f1412c = this.f1410a.a();
        }
        Fragment item = getItem(i);
        if (this.f1413d.size() > i && (cVar = this.f1413d.get(i)) != null) {
            item.setInitialSavedState(cVar);
        }
        while (this.f1414e.size() <= i) {
            this.f1414e.add(null);
        }
        item.setMenuVisibility(false);
        if (this.f1411b == 0) {
            item.setUserVisibleHint(false);
        }
        this.f1414e.set(i, item);
        this.f1412c.a(viewGroup.getId(), item);
        if (this.f1411b == 1) {
            this.f1412c.a(item, Lifecycle.State.STARTED);
        }
        return item;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f1413d.clear();
            this.f1414e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f1413d.add((Fragment.c) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragmentA = this.f1410a.a(bundle, str);
                    if (fragmentA != null) {
                        while (this.f1414e.size() <= i) {
                            this.f1414e.add(null);
                        }
                        fragmentA.setMenuVisibility(false);
                        this.f1414e.set(i, fragmentA);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f1413d.size() > 0) {
            bundle = new Bundle();
            Fragment.c[] cVarArr = new Fragment.c[this.f1413d.size()];
            this.f1413d.toArray(cVarArr);
            bundle.putParcelableArray("states", cVarArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.f1414e.size(); i++) {
            Fragment fragment = this.f1414e.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f1410a.a(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f1415f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f1411b == 1) {
                    if (this.f1412c == null) {
                        this.f1412c = this.f1410a.a();
                    }
                    this.f1412c.a(this.f1415f, Lifecycle.State.STARTED);
                } else {
                    this.f1415f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f1411b == 1) {
                if (this.f1412c == null) {
                    this.f1412c = this.f1410a.a();
                }
                this.f1412c.a(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f1415f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public D(AbstractC0336n abstractC0336n, int i) {
        this.f1412c = null;
        this.f1413d = new ArrayList<>();
        this.f1414e = new ArrayList<>();
        this.f1415f = null;
        this.f1410a = abstractC0336n;
        this.f1411b = i;
    }
}
