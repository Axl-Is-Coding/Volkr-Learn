package com.google.android.gms.common.api.internal;

import a.a.d;
import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class zaae extends zal {
    private GoogleApiManager zabm;
    private final d<zai<?>> zafp;

    private zaae(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.zafp = new d<>();
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public static void zaa(Activity activity, GoogleApiManager googleApiManager, zai<?> zaiVar) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaae zaaeVar = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
        if (zaaeVar == null) {
            zaaeVar = new zaae(fragment);
        }
        zaaeVar.zabm = googleApiManager;
        Preconditions.checkNotNull(zaiVar, "ApiKey cannot be null");
        zaaeVar.zafp.add(zaiVar);
        googleApiManager.zaa(zaaeVar);
    }

    private final void zaak() {
        if (this.zafp.isEmpty()) {
            return;
        }
        this.zabm.zaa(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onResume() {
        super.onResume();
        zaak();
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        zaak();
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zabm.zab(this);
    }

    final d<zai<?>> zaaj() {
        return this.zafp;
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void zao() {
        this.zabm.zao();
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void zaa(ConnectionResult connectionResult, int i) {
        this.zabm.zaa(connectionResult, i);
    }
}
