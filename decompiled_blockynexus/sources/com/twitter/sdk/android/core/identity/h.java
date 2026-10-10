package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.m;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.w;
import com.twitter.sdk.android.core.y;

/* JADX INFO: compiled from: TwitterAuthClient.java */
/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w f20143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.twitter.sdk.android.core.identity.a f20144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final m<y> f20145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final q f20146d;

    /* JADX INFO: compiled from: TwitterAuthClient.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.twitter.sdk.android.core.identity.a f20147a = new com.twitter.sdk.android.core.identity.a();
    }

    public h() {
        this(w.g(), w.g().c(), w.g().h(), a.f20147a);
    }

    private void b(Activity activity, com.twitter.sdk.android.core.c<y> cVar) {
        b bVar = new b(this.f20145c, cVar);
        if (b(activity, bVar) || a(activity, bVar)) {
            return;
        }
        bVar.a(new TwitterAuthException("Authorize failed."));
    }

    public int a() {
        return this.f20146d.c();
    }

    public void a(Activity activity, com.twitter.sdk.android.core.c<y> cVar) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null.");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback must not be null.");
        }
        if (activity.isFinishing()) {
            n.e().e("Twitter", "Cannot authorize, activity is finishing.", null);
        } else {
            b(activity, cVar);
        }
    }

    /* JADX INFO: compiled from: TwitterAuthClient.java */
    static class b extends com.twitter.sdk.android.core.c<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m<y> f20148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.twitter.sdk.android.core.c<y> f20149b;

        b(m<y> mVar, com.twitter.sdk.android.core.c<y> cVar) {
            this.f20148a = mVar;
            this.f20149b = cVar;
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(k<y> kVar) {
            n.e().d("Twitter", "Authorization completed successfully");
            this.f20148a.a(kVar.f20217a);
            this.f20149b.a(kVar);
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(TwitterException twitterException) {
            n.e().e("Twitter", "Authorization completed with an error", twitterException);
            this.f20149b.a(twitterException);
        }
    }

    h(w wVar, q qVar, m<y> mVar, com.twitter.sdk.android.core.identity.a aVar) {
        this.f20143a = wVar;
        this.f20144b = aVar;
        this.f20146d = qVar;
        this.f20145c = mVar;
    }

    private boolean b(Activity activity, b bVar) {
        if (!g.a((Context) activity)) {
            return false;
        }
        n.e().d("Twitter", "Using SSO");
        com.twitter.sdk.android.core.identity.a aVar = this.f20144b;
        q qVar = this.f20146d;
        return aVar.a(activity, new g(qVar, bVar, qVar.c()));
    }

    private boolean a(Activity activity, b bVar) {
        n.e().d("Twitter", "Using OAuth");
        com.twitter.sdk.android.core.identity.a aVar = this.f20144b;
        q qVar = this.f20146d;
        return aVar.a(activity, new d(qVar, bVar, qVar.c()));
    }

    public void a(int i, int i2, Intent intent) {
        n.e().d("Twitter", "onActivityResult called with " + i + " " + i2);
        if (!this.f20144b.c()) {
            n.e().e("Twitter", "Authorize not in progress", null);
            return;
        }
        AuthHandler authHandlerB = this.f20144b.b();
        if (authHandlerB == null || !authHandlerB.a(i, i2, intent)) {
            return;
        }
        this.f20144b.a();
    }
}
