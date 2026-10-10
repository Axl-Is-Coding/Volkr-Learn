package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.Fragment;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SupportRequestManagerFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f4767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f4768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<p> f4769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p f4770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.k f4771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Fragment f4772f;

    /* JADX INFO: compiled from: SupportRequestManagerFragment.java */
    private class a implements n {
        a() {
        }

        @Override // com.bumptech.glide.manager.n
        public Set<com.bumptech.glide.k> a() {
            Set<p> setG = p.this.g();
            HashSet hashSet = new HashSet(setG.size());
            for (p pVar : setG) {
                if (pVar.i() != null) {
                    hashSet.add(pVar.i());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + p.this + "}";
        }
    }

    public p() {
        this(new com.bumptech.glide.manager.a());
    }

    private void b(p pVar) {
        this.f4769c.remove(pVar);
    }

    private boolean c(Fragment fragment) {
        Fragment fragmentK = k();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(fragmentK)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private Fragment k() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f4772f;
    }

    private void l() {
        p pVar = this.f4770d;
        if (pVar != null) {
            pVar.b(this);
            this.f4770d = null;
        }
    }

    public void a(com.bumptech.glide.k kVar) {
        this.f4771e = kVar;
    }

    Set<p> g() {
        p pVar = this.f4770d;
        if (pVar == null) {
            return Collections.emptySet();
        }
        if (equals(pVar)) {
            return Collections.unmodifiableSet(this.f4769c);
        }
        HashSet hashSet = new HashSet();
        for (p pVar2 : this.f4770d.g()) {
            if (c(pVar2.k())) {
                hashSet.add(pVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    com.bumptech.glide.manager.a h() {
        return this.f4767a;
    }

    public com.bumptech.glide.k i() {
        return this.f4771e;
    }

    public n j() {
        return this.f4768b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        AbstractC0336n abstractC0336nB = b((Fragment) this);
        if (abstractC0336nB == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                a(getContext(), abstractC0336nB);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f4767a.a();
        l();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f4772f = null;
        l();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4767a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f4767a.c();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + k() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public p(com.bumptech.glide.manager.a aVar) {
        this.f4768b = new a();
        this.f4769c = new HashSet();
        this.f4767a = aVar;
    }

    private void a(p pVar) {
        this.f4769c.add(pVar);
    }

    private static AbstractC0336n b(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    void a(Fragment fragment) {
        AbstractC0336n abstractC0336nB;
        this.f4772f = fragment;
        if (fragment == null || fragment.getContext() == null || (abstractC0336nB = b(fragment)) == null) {
            return;
        }
        a(fragment.getContext(), abstractC0336nB);
    }

    private void a(Context context, AbstractC0336n abstractC0336n) {
        l();
        this.f4770d = com.bumptech.glide.c.a(context).h().a(context, abstractC0336n);
        if (equals(this.f4770d)) {
            return;
        }
        this.f4770d.a(this);
    }
}
