package com.twitter.sdk.android.core.internal.oauth;

/* JADX INFO: compiled from: GuestAuthToken.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.a.c("guest_token")
    private final String f20188d;

    public b(String str, String str2, String str3) {
        super(str, str2);
        this.f20188d = str3;
    }

    public String c() {
        return this.f20188d;
    }

    public boolean e() {
        return System.currentTimeMillis() >= this.f20118a + 10800000;
    }

    @Override // com.twitter.sdk.android.core.internal.oauth.j
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f20188d;
        return str == null ? bVar.f20188d == null : str.equals(bVar.f20188d);
    }

    @Override // com.twitter.sdk.android.core.internal.oauth.j
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f20188d;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
