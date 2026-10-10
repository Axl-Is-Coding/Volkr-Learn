package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.y;
import java.io.IOException;

/* JADX INFO: compiled from: TwitterSessionVerifier.java */
/* JADX INFO: loaded from: classes5.dex */
public class n implements k<y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f20183a;

    /* JADX INFO: compiled from: TwitterSessionVerifier.java */
    protected static class a {
        protected a() {
        }

        public AccountService a(y yVar) {
            return new com.twitter.sdk.android.core.o(yVar).a();
        }
    }

    public n() {
        this(new a());
    }

    n(a aVar) {
        this.f20183a = aVar;
    }

    @Override // com.twitter.sdk.android.core.internal.k
    public void a(y yVar) {
        try {
            this.f20183a.a(yVar).verifyCredentials(true, false, false).execute();
        } catch (IOException | RuntimeException unused) {
        }
    }
}
