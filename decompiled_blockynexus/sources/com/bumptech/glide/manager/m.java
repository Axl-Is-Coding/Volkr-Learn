package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: RequestManagerRetriever.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4758a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.bumptech.glide.k f4759b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f4762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f4763f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<FragmentManager, RequestManagerFragment> f4760c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Map<AbstractC0336n, p> f4761d = new HashMap();
    private final a.a.b<View, Fragment> g = new a.a.b<>();
    private final a.a.b<View, android.app.Fragment> h = new a.a.b<>();
    private final Bundle i = new Bundle();

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    public interface a {
        com.bumptech.glide.k a(com.bumptech.glide.c cVar, i iVar, n nVar, Context context);
    }

    public m(a aVar) {
        this.f4763f = aVar == null ? f4758a : aVar;
        this.f4762e = new Handler(Looper.getMainLooper(), this);
    }

    @Deprecated
    private void b(FragmentManager fragmentManager, a.a.b<View, android.app.Fragment> bVar) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.i.putInt("key", i);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.i, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                bVar.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    a(fragment.getChildFragmentManager(), bVar);
                }
            }
            i = i2;
        }
    }

    private com.bumptech.glide.k c(Context context) {
        if (this.f4759b == null) {
            synchronized (this) {
                if (this.f4759b == null) {
                    this.f4759b = this.f4763f.a(com.bumptech.glide.c.a(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.f4759b;
    }

    private static boolean d(Context context) {
        Activity activityB = b(context);
        return activityB == null || !activityB.isFinishing();
    }

    public com.bumptech.glide.k a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.e.n.d() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return a(contextWrapper.getBaseContext());
                }
            }
        }
        return c(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks componentCallbacksRemove;
        int i = message.what;
        Object obj = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            componentCallbacksRemove = this.f4760c.remove(obj);
        } else if (i != 2) {
            z = false;
            componentCallbacksRemove = null;
        } else {
            obj = (AbstractC0336n) message.obj;
            componentCallbacksRemove = this.f4761d.remove(obj);
        }
        if (z && componentCallbacksRemove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }

    private static Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(17)
    private static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public com.bumptech.glide.k a(FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.e.n.c()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c((Activity) fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    @Deprecated
    RequestManagerFragment b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    public com.bumptech.glide.k a(Fragment fragment) {
        com.bumptech.glide.e.l.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.e.n.c()) {
            return a(fragment.getContext().getApplicationContext());
        }
        return a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public com.bumptech.glide.k a(Activity activity) {
        if (com.bumptech.glide.e.n.c()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a(activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    public com.bumptech.glide.k a(View view) {
        if (com.bumptech.glide.e.n.c()) {
            return a(view.getContext().getApplicationContext());
        }
        com.bumptech.glide.e.l.a(view);
        com.bumptech.glide.e.l.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityB = b(view.getContext());
        if (activityB == null) {
            return a(view.getContext().getApplicationContext());
        }
        if (activityB instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activityB;
            Fragment fragmentA = a(view, fragmentActivity);
            return fragmentA != null ? a(fragmentA) : a(fragmentActivity);
        }
        android.app.Fragment fragmentA2 = a(view, activityB);
        if (fragmentA2 == null) {
            return a(activityB);
        }
        return a(fragmentA2);
    }

    private static void a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager().e(), map);
            }
        }
    }

    private Fragment a(View view, FragmentActivity fragmentActivity) {
        this.g.clear();
        a(fragmentActivity.getSupportFragmentManager().e(), this.g);
        View viewFindViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.g.clear();
        return fragment;
    }

    @Deprecated
    private android.app.Fragment a(View view, Activity activity) {
        this.h.clear();
        a(activity.getFragmentManager(), this.h);
        View viewFindViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.h.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.h.clear();
        return fragment;
    }

    @TargetApi(26)
    @Deprecated
    private void a(FragmentManager fragmentManager, a.a.b<View, android.app.Fragment> bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    bVar.put(fragment.getView(), fragment);
                    a(fragment.getChildFragmentManager(), bVar);
                }
            }
            return;
        }
        b(fragmentManager, bVar);
    }

    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.k a(android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!com.bumptech.glide.e.n.c() && Build.VERSION.SDK_INT >= 17) {
                return a(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return a(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    private RequestManagerFragment a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.f4760c.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.a(fragment);
            if (z) {
                requestManagerFragment.b().b();
            }
            this.f4760c.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f4762e.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @Deprecated
    private com.bumptech.glide.k a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragmentA = a(fragmentManager, fragment, z);
        com.bumptech.glide.k kVarC = requestManagerFragmentA.c();
        if (kVarC != null) {
            return kVarC;
        }
        com.bumptech.glide.k kVarA = this.f4763f.a(com.bumptech.glide.c.a(context), requestManagerFragmentA.b(), requestManagerFragmentA.d(), context);
        requestManagerFragmentA.a(kVarA);
        return kVarA;
    }

    p a(Context context, AbstractC0336n abstractC0336n) {
        return a(abstractC0336n, (Fragment) null, d(context));
    }

    private p a(AbstractC0336n abstractC0336n, Fragment fragment, boolean z) {
        p pVar = (p) abstractC0336n.a("com.bumptech.glide.manager");
        if (pVar == null && (pVar = this.f4761d.get(abstractC0336n)) == null) {
            pVar = new p();
            pVar.a(fragment);
            if (z) {
                pVar.h().b();
            }
            this.f4761d.put(abstractC0336n, pVar);
            F fA = abstractC0336n.a();
            fA.a(pVar, "com.bumptech.glide.manager");
            fA.b();
            this.f4762e.obtainMessage(2, abstractC0336n).sendToTarget();
        }
        return pVar;
    }

    private com.bumptech.glide.k a(Context context, AbstractC0336n abstractC0336n, Fragment fragment, boolean z) {
        p pVarA = a(abstractC0336n, fragment, z);
        com.bumptech.glide.k kVarI = pVarA.i();
        if (kVarI != null) {
            return kVarI;
        }
        com.bumptech.glide.k kVarA = this.f4763f.a(com.bumptech.glide.c.a(context), pVarA.h(), pVarA.j(), context);
        pVarA.a(kVarA);
        return kVarA;
    }
}
