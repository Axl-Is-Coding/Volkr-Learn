package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import android.text.TextUtils;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;

/* JADX INFO: compiled from: TweetRepository.java */
/* JADX INFO: loaded from: classes5.dex */
class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.twitter.sdk.android.core.w f20335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f20336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.twitter.sdk.android.core.m<com.twitter.sdk.android.core.y> f20337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final a.a.g<Long, com.twitter.sdk.android.core.models.m> f20338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final a.a.g<Long, C2776n> f20339e;

    I(Handler handler, com.twitter.sdk.android.core.m<com.twitter.sdk.android.core.y> mVar) {
        this(handler, mVar, com.twitter.sdk.android.core.w.g());
    }

    void b(com.twitter.sdk.android.core.models.m mVar) {
        this.f20338d.put(Long.valueOf(mVar.i), mVar);
    }

    void c(long j, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        a(new H(this, cVar, com.twitter.sdk.android.core.n.e(), j, cVar));
    }

    I(Handler handler, com.twitter.sdk.android.core.m<com.twitter.sdk.android.core.y> mVar, com.twitter.sdk.android.core.w wVar) {
        this.f20335a = wVar;
        this.f20336b = handler;
        this.f20337c = mVar;
        this.f20338d = new a.a.g<>(20);
        this.f20339e = new a.a.g<>(20);
    }

    C2776n a(com.twitter.sdk.android.core.models.m mVar) {
        if (mVar == null) {
            return null;
        }
        C2776n c2776n = this.f20339e.get(Long.valueOf(mVar.i));
        if (c2776n != null) {
            return c2776n;
        }
        C2776n c2776nA = K.a(mVar);
        if (c2776nA != null && !TextUtils.isEmpty(c2776nA.f20437a)) {
            this.f20339e.put(Long.valueOf(mVar.i), c2776nA);
        }
        return c2776nA;
    }

    void b(long j, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        com.twitter.sdk.android.core.models.m mVar = this.f20338d.get(Long.valueOf(j));
        if (mVar != null) {
            a(mVar, cVar);
        } else {
            this.f20335a.b().d().show(Long.valueOf(j), null, null, null).enqueue(new a(cVar));
        }
    }

    /* JADX INFO: compiled from: TweetRepository.java */
    class a extends com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> f20340a;

        a(com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
            this.f20340a = cVar;
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.models.m> kVar) {
            com.twitter.sdk.android.core.models.m mVar = kVar.f20217a;
            I.this.b(mVar);
            com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar = this.f20340a;
            if (cVar != null) {
                cVar.a(new com.twitter.sdk.android.core.k<>(mVar, kVar.f20218b));
            }
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(TwitterException twitterException) {
            this.f20340a.a(twitterException);
        }
    }

    private void a(final com.twitter.sdk.android.core.models.m mVar, final com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        if (cVar == null) {
            return;
        }
        this.f20336b.post(new Runnable() { // from class: com.twitter.sdk.android.tweetui.i
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(new com.twitter.sdk.android.core.k(mVar, null));
            }
        });
    }

    void a(long j, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        a(new G(this, cVar, com.twitter.sdk.android.core.n.e(), j, cVar));
    }

    void a(com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.y> cVar) {
        com.twitter.sdk.android.core.y yVar = (com.twitter.sdk.android.core.y) this.f20337c.b();
        if (yVar == null) {
            cVar.a(new TwitterAuthException("User authorization required"));
        } else {
            cVar.a(new com.twitter.sdk.android.core.k<>(yVar, null));
        }
    }
}
