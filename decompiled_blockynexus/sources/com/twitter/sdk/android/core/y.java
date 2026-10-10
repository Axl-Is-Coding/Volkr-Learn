package com.twitter.sdk.android.core;

import android.text.TextUtils;

/* JADX INFO: compiled from: TwitterSession.java */
/* JADX INFO: loaded from: classes5.dex */
public class y extends l<s> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.a.c("user_name")
    private final String f20290c;

    public y(s sVar, long j, String str) {
        super(sVar, j);
        this.f20290c = str;
    }

    public long c() {
        return b();
    }

    public String d() {
        return this.f20290c;
    }

    @Override // com.twitter.sdk.android.core.l
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        y yVar = (y) obj;
        String str = this.f20290c;
        return str != null ? str.equals(yVar.f20290c) : yVar.f20290c == null;
    }

    @Override // com.twitter.sdk.android.core.l
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f20290c;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    /* JADX INFO: compiled from: TwitterSession.java */
    static class a implements com.twitter.sdk.android.core.internal.b.e<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.gson.j f20291a = new com.google.gson.j();

        a() {
        }

        @Override // com.twitter.sdk.android.core.internal.b.e
        public String a(y yVar) {
            if (yVar == null || yVar.a() == null) {
                return "";
            }
            try {
                return this.f20291a.a(yVar);
            } catch (Exception e2) {
                n.e().d("Twitter", e2.getMessage());
                return "";
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.twitter.sdk.android.core.internal.b.e
        public y a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (y) this.f20291a.a(str, y.class);
            } catch (Exception e2) {
                n.e().d("Twitter", e2.getMessage());
                return null;
            }
        }
    }
}
