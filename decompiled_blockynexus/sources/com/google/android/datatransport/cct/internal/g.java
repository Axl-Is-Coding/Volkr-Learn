package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* JADX INFO: compiled from: AutoValue_ClientInfo.java */
/* JADX INFO: loaded from: classes.dex */
final class g extends ClientInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClientInfo.ClientType f12764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.cct.internal.a f12765b;

    /* JADX INFO: compiled from: AutoValue_ClientInfo.java */
    static final class a extends ClientInfo.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ClientInfo.ClientType f12766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.google.android.datatransport.cct.internal.a f12767b;

        a() {
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a a(ClientInfo.ClientType clientType) {
            this.f12766a = clientType;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a a(com.google.android.datatransport.cct.internal.a aVar) {
            this.f12767b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new g(this.f12766a, this.f12767b);
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public com.google.android.datatransport.cct.internal.a b() {
        return this.f12765b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType c() {
        return this.f12764a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f12764a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            com.google.android.datatransport.cct.internal.a aVar = this.f12765b;
            if (aVar == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (aVar.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f12764a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        com.google.android.datatransport.cct.internal.a aVar = this.f12765b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f12764a + ", androidClientInfo=" + this.f12765b + "}";
    }

    private g(ClientInfo.ClientType clientType, com.google.android.datatransport.cct.internal.a aVar) {
        this.f12764a = clientType;
        this.f12765b = aVar;
    }
}
