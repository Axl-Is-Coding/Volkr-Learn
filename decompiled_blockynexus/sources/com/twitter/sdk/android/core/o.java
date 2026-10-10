package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.models.BindingValuesAdapter;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.z;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: TwitterApiClient.java */
/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ConcurrentHashMap<Class, Object> f20263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Retrofit f20264b;

    public o() {
        this(com.twitter.sdk.android.core.internal.a.e.a(w.g().e()), new com.twitter.sdk.android.core.internal.m());
    }

    private Retrofit a(z zVar, com.twitter.sdk.android.core.internal.m mVar) {
        return new Retrofit.Builder().client(zVar).baseUrl(mVar.a()).addConverterFactory(GsonConverterFactory.create(f())).build();
    }

    private ConcurrentHashMap e() {
        return new ConcurrentHashMap();
    }

    private com.google.gson.j f() {
        com.google.gson.k kVar = new com.google.gson.k();
        kVar.a(new SafeListAdapter());
        kVar.a(new SafeMapAdapter());
        kVar.a(com.twitter.sdk.android.core.models.c.class, new BindingValuesAdapter());
        return kVar.a();
    }

    public FavoriteService b() {
        return (FavoriteService) a(FavoriteService.class);
    }

    public MediaService c() {
        return (MediaService) a(MediaService.class);
    }

    public StatusesService d() {
        return (StatusesService) a(StatusesService.class);
    }

    public o(y yVar) {
        this(com.twitter.sdk.android.core.internal.a.e.a(yVar, w.g().c()), new com.twitter.sdk.android.core.internal.m());
    }

    o(z zVar, com.twitter.sdk.android.core.internal.m mVar) {
        this.f20263a = e();
        this.f20264b = a(zVar, mVar);
    }

    public AccountService a() {
        return (AccountService) a(AccountService.class);
    }

    protected <T> T a(Class<T> cls) {
        if (!this.f20263a.contains(cls)) {
            this.f20263a.putIfAbsent(cls, this.f20264b.create(cls));
        }
        return (T) this.f20263a.get(cls);
    }
}
