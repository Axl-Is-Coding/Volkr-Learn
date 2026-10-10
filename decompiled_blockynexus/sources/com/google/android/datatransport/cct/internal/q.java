package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.k;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* JADX INFO: compiled from: LogRequest.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: compiled from: LogRequest.java */
    public static abstract class a {
        public a a(int i) {
            a(Integer.valueOf(i));
            return this;
        }

        public abstract a a(long j);

        public abstract a a(ClientInfo clientInfo);

        public abstract a a(QosTier qosTier);

        abstract a a(Integer num);

        abstract a a(String str);

        public abstract a a(List<p> list);

        public abstract q a();

        public abstract a b(long j);

        public a b(String str) {
            a(str);
            return this;
        }
    }

    public static a a() {
        return new k.a();
    }

    public abstract ClientInfo b();

    @Encodable.Field(name = "logEvent")
    public abstract List<p> c();

    public abstract Integer d();

    public abstract String e();

    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
