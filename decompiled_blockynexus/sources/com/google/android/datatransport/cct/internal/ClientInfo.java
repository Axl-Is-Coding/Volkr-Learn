package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class ClientInfo {

    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i) {
            this.value = i;
        }
    }

    public static abstract class a {
        public abstract a a(ClientType clientType);

        public abstract a a(com.google.android.datatransport.cct.internal.a aVar);

        public abstract ClientInfo a();
    }

    public static a a() {
        return new g.a();
    }

    public abstract com.google.android.datatransport.cct.internal.a b();

    public abstract ClientType c();
}
