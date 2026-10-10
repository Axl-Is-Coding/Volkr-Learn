package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: GuestSessionProvider.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OAuth2Service f20123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<e> f20124b;

    public g(OAuth2Service oAuth2Service, m<e> mVar) {
        this.f20123a = oAuth2Service;
        this.f20124b = mVar;
    }

    public synchronized e b(e eVar) {
        e eVar2 = (e) this.f20124b.b();
        if (eVar != null && eVar.equals(eVar2)) {
            b();
        }
        return (e) this.f20124b.b();
    }

    public synchronized e a() {
        e eVar = (e) this.f20124b.b();
        if (a(eVar)) {
            return eVar;
        }
        b();
        return (e) this.f20124b.b();
    }

    void b() {
        n.e().d("GuestSessionProvider", "Refreshing expired guest session.");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f20123a.b(new f(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            this.f20124b.a(0L);
        }
    }

    boolean a(e eVar) {
        return (eVar == null || eVar.a() == null || eVar.a().e()) ? false : true;
    }
}
