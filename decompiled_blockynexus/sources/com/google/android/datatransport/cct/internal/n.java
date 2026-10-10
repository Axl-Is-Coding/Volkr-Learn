package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

/* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes.dex */
final class n extends NetworkConnectionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkConnectionInfo.NetworkType f12793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NetworkConnectionInfo.MobileSubtype f12794b;

    /* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
    static final class a extends NetworkConnectionInfo.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private NetworkConnectionInfo.NetworkType f12795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NetworkConnectionInfo.MobileSubtype f12796b;

        a() {
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a a(NetworkConnectionInfo.NetworkType networkType) {
            this.f12795a = networkType;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a a(NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f12796b = mobileSubtype;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo a() {
            return new n(this.f12795a, this.f12796b);
        }
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public NetworkConnectionInfo.MobileSubtype b() {
        return this.f12794b;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public NetworkConnectionInfo.NetworkType c() {
        return this.f12793a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.f12793a;
        if (networkType != null ? networkType.equals(networkConnectionInfo.c()) : networkConnectionInfo.c() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f12794b;
            if (mobileSubtype == null) {
                if (networkConnectionInfo.b() == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(networkConnectionInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.f12793a;
        int iHashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f12794b;
        return iHashCode ^ (mobileSubtype != null ? mobileSubtype.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f12793a + ", mobileSubtype=" + this.f12794b + "}";
    }

    private n(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f12793a = networkType;
        this.f12794b = mobileSubtype;
    }
}
