package com.google.android.gms.common.api.internal;

import a.a.b;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class zas implements zabs {
    private final Context mContext;
    private final Looper zabj;
    private final zaaw zaee;
    private final zabe zaef;
    private final zabe zaeg;
    private final Map<Api.AnyClientKey<?>, zabe> zaeh;
    private final Api.Client zaej;
    private Bundle zaek;
    private final Lock zaeo;
    private final Set<SignInConnectionListener> zaei = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult zael = null;
    private ConnectionResult zaem = null;
    private boolean zaen = false;
    private int zaep = 0;

    private zas(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zad, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zaq> arrayList, ArrayList<zaq> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.mContext = context;
        this.zaee = zaawVar;
        this.zaeo = lock;
        this.zabj = looper;
        this.zaej = client;
        this.zaef = new zabe(context, this.zaee, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zau(this, null));
        this.zaeg = new zabe(context, this.zaee, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zav(this, null));
        b bVar = new b();
        Iterator<Api.AnyClientKey<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            bVar.put(it.next(), this.zaef);
        }
        Iterator<Api.AnyClientKey<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            bVar.put(it2.next(), this.zaeg);
        }
        this.zaeh = Collections.unmodifiableMap(bVar);
    }

    public static zas zaa(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList) {
        b bVar = new b();
        b bVar2 = new b();
        Api.Client client = null;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                bVar.put(entry.getKey(), value);
            } else {
                bVar2.put(entry.getKey(), value);
            }
        }
        Preconditions.checkState(!bVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        b bVar3 = new b();
        b bVar4 = new b();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = api.getClientKey();
            if (bVar.containsKey(clientKey)) {
                bVar3.put(api, map2.get(api));
            } else {
                if (!bVar2.containsKey(clientKey)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                bVar4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList.get(i);
            i++;
            zaq zaqVar2 = zaqVar;
            if (bVar3.containsKey(zaqVar2.mApi)) {
                arrayList2.add(zaqVar2);
            } else {
                if (!bVar4.containsKey(zaqVar2.mApi)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(zaqVar2);
            }
        }
        return new zas(context, zaawVar, lock, looper, googleApiAvailabilityLight, bVar, bVar2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, bVar3, bVar4);
    }

    private final PendingIntent zaaa() {
        if (this.zaej == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zaee), this.zaej.getSignInIntent(), 134217728);
    }

    private static boolean zab(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zax() {
        ConnectionResult connectionResult;
        if (!zab(this.zael)) {
            if (this.zael != null && zab(this.zaem)) {
                this.zaeg.disconnect();
                zaa(this.zael);
                return;
            }
            ConnectionResult connectionResult2 = this.zael;
            if (connectionResult2 == null || (connectionResult = this.zaem) == null) {
                return;
            }
            if (this.zaeg.zahs < this.zaef.zahs) {
                connectionResult2 = connectionResult;
            }
            zaa(connectionResult2);
            return;
        }
        if (zab(this.zaem) || zaz()) {
            int i = this.zaep;
            if (i == 1) {
                zay();
            } else if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                this.zaee.zab(this.zaek);
                zay();
            }
            this.zaep = 0;
            return;
        }
        ConnectionResult connectionResult3 = this.zaem;
        if (connectionResult3 != null) {
            if (this.zaep == 1) {
                zay();
            } else {
                zaa(connectionResult3);
                this.zaef.disconnect();
            }
        }
    }

    private final void zay() {
        Iterator<SignInConnectionListener> it = this.zaei.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.zaei.clear();
    }

    private final boolean zaz() {
        ConnectionResult connectionResult = this.zaem;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void connect() {
        this.zaep = 2;
        this.zaen = false;
        this.zaem = null;
        this.zael = null;
        this.zaef.connect();
        this.zaeg.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        this.zaem = null;
        this.zael = null;
        this.zaep = 0;
        this.zaef.disconnect();
        this.zaeg.disconnect();
        zay();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.zaeg.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.zaef.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        if (!zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return (T) this.zaef.enqueue(t);
        }
        if (!zaz()) {
            return (T) this.zaeg.enqueue(t);
        }
        t.setFailedResult(new Status(4, null, zaaa()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        if (!zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return (T) this.zaef.execute(t);
        }
        if (!zaz()) {
            return (T) this.zaeg.execute(t);
        }
        t.setFailedResult(new Status(4, null, zaaa()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult getConnectionResult(Api<?> api) {
        return this.zaeh.get(api.getClientKey()).equals(this.zaeg) ? zaz() ? new ConnectionResult(4, zaaa()) : this.zaeg.getConnectionResult(api) : this.zaef.getConnectionResult(api);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    @Override // com.google.android.gms.common.api.internal.zabs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isConnected() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.zaeo
            r0.lock()
            com.google.android.gms.common.api.internal.zabe r0 = r2.zaef     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r0 == 0) goto L21
            com.google.android.gms.common.api.internal.zabe r0 = r2.zaeg     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            boolean r0 = r2.zaz()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            int r0 = r2.zaep     // Catch: java.lang.Throwable -> L28
            if (r0 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            java.util.concurrent.locks.Lock r0 = r2.zaeo
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.zaeo
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zas.isConnected():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnecting() {
        this.zaeo.lock();
        try {
            return this.zaep == 2;
        } finally {
            this.zaeo.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zaeo.lock();
        try {
            if ((!isConnecting() && !isConnected()) || this.zaeg.isConnected()) {
                this.zaeo.unlock();
                return false;
            }
            this.zaei.add(signInConnectionListener);
            if (this.zaep == 0) {
                this.zaep = 1;
            }
            this.zaem = null;
            this.zaeg.connect();
            return true;
        } finally {
            this.zaeo.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void maybeSignOut() {
        this.zaeo.lock();
        try {
            boolean zIsConnecting = isConnecting();
            this.zaeg.disconnect();
            this.zaem = new ConnectionResult(4);
            if (zIsConnecting) {
                new com.google.android.gms.internal.base.zap(this.zabj).post(new zat(this));
            } else {
                zay();
            }
        } finally {
            this.zaeo.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void zaw() {
        this.zaef.zaw();
        this.zaeg.zaw();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    private final void zaa(ConnectionResult connectionResult) {
        int i = this.zaep;
        if (i == 1) {
            zay();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.zaee.zac(connectionResult);
            zay();
        }
        this.zaep = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaa(int i, boolean z) {
        this.zaee.zab(i, z);
        this.zaem = null;
        this.zael = null;
    }

    private final boolean zaa(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Object clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zaeh.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zaeh.get(clientKey).equals(this.zaeg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaa(Bundle bundle) {
        Bundle bundle2 = this.zaek;
        if (bundle2 == null) {
            this.zaek = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }
}
