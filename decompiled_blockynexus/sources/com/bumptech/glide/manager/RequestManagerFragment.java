package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f4742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f4743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<RequestManagerFragment> f4744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.k f4745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RequestManagerFragment f4746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Fragment f4747f;

    private class a implements n {
        a() {
        }

        @Override // com.bumptech.glide.manager.n
        public Set<com.bumptech.glide.k> a() {
            Set<RequestManagerFragment> setA = RequestManagerFragment.this.a();
            HashSet hashSet = new HashSet(setA.size());
            for (RequestManagerFragment requestManagerFragment : setA) {
                if (requestManagerFragment.c() != null) {
                    hashSet.add(requestManagerFragment.c());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    @TargetApi(17)
    private Fragment e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f4747f;
    }

    private void f() {
        RequestManagerFragment requestManagerFragment = this.f4746e;
        if (requestManagerFragment != null) {
            requestManagerFragment.b(this);
            this.f4746e = null;
        }
    }

    public void a(com.bumptech.glide.k kVar) {
        this.f4745d = kVar;
    }

    com.bumptech.glide.manager.a b() {
        return this.f4742a;
    }

    public com.bumptech.glide.k c() {
        return this.f4745d;
    }

    public n d() {
        return this.f4743b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f4742a.a();
        f();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        f();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4742a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f4742a.c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(com.bumptech.glide.manager.a aVar) {
        this.f4743b = new a();
        this.f4744c = new HashSet();
        this.f4742a = aVar;
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f4744c.add(requestManagerFragment);
    }

    private void b(RequestManagerFragment requestManagerFragment) {
        this.f4744c.remove(requestManagerFragment);
    }

    @TargetApi(17)
    private boolean b(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @TargetApi(17)
    Set<RequestManagerFragment> a() {
        if (equals(this.f4746e)) {
            return Collections.unmodifiableSet(this.f4744c);
        }
        if (this.f4746e != null && Build.VERSION.SDK_INT >= 17) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f4746e.a()) {
                if (b(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    void a(Fragment fragment) {
        this.f4747f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private void a(Activity activity) {
        f();
        this.f4746e = com.bumptech.glide.c.a((Context) activity).h().b(activity);
        if (equals(this.f4746e)) {
            return;
        }
        this.f4746e.a(this);
    }
}
