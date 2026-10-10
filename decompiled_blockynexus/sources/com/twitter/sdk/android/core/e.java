package com.twitter.sdk.android.core;

import android.text.TextUtils;

/* JADX INFO: compiled from: GuestSession.java */
/* JADX INFO: loaded from: classes5.dex */
public class e extends l<com.twitter.sdk.android.core.internal.oauth.b> {
    public e(com.twitter.sdk.android.core.internal.oauth.b bVar) {
        super(bVar, 0L);
    }

    /* JADX INFO: compiled from: GuestSession.java */
    public static class a implements com.twitter.sdk.android.core.internal.b.e<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.gson.j f20120a;

        public a() {
            com.google.gson.k kVar = new com.google.gson.k();
            kVar.a(com.twitter.sdk.android.core.internal.oauth.b.class, new AuthTokenAdapter());
            this.f20120a = kVar.a();
        }

        @Override // com.twitter.sdk.android.core.internal.b.e
        public String a(e eVar) {
            if (eVar == null || eVar.a() == null) {
                return "";
            }
            try {
                return this.f20120a.a(eVar);
            } catch (Exception e2) {
                n.e().d("Twitter", "Failed to serialize session " + e2.getMessage());
                return "";
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.twitter.sdk.android.core.internal.b.e
        public e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (e) this.f20120a.a(str, e.class);
            } catch (Exception e2) {
                n.e().d("Twitter", "Failed to deserialize session " + e2.getMessage());
                return null;
            }
        }
    }
}
