package com.twitter.sdk.android.core.internal.a;

import com.twitter.sdk.android.core.g;
import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.C;
import okhttp3.H;
import okhttp3.K;
import okhttp3.u;

/* JADX INFO: compiled from: GuestAuthenticator.java */
/* JADX INFO: loaded from: classes5.dex */
public class c implements Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g f20152a;

    public c(g gVar) {
        this.f20152a = gVar;
    }

    C a(C c2, com.twitter.sdk.android.core.internal.oauth.b bVar) {
        C.a aVarF = c2.f();
        a.a(aVarF, bVar);
        return aVarF.a();
    }

    @Override // okhttp3.Authenticator
    public C authenticate(K k, H h) throws IOException {
        return c(h);
    }

    com.twitter.sdk.android.core.e b(H h) {
        u uVarC = h.y().c();
        String strB = uVarC.b("Authorization");
        String strB2 = uVarC.b("x-guest-token");
        if (strB == null || strB2 == null) {
            return null;
        }
        return new com.twitter.sdk.android.core.e(new com.twitter.sdk.android.core.internal.oauth.b("bearer", strB.replace("bearer ", ""), strB2));
    }

    C c(H h) {
        if (a(h)) {
            com.twitter.sdk.android.core.e eVarB = this.f20152a.b(b(h));
            com.twitter.sdk.android.core.internal.oauth.b bVarA = eVarB == null ? null : eVarB.a();
            if (bVarA != null) {
                return a(h.y(), bVarA);
            }
        }
        return null;
    }

    boolean a(H h) {
        int i = 1;
        while (true) {
            h = h.v();
            if (h == null) {
                break;
            }
            i++;
        }
        return i < 2;
    }
}
