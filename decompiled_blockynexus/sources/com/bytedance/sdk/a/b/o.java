package com.bytedance.sdk.a.b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Dns.java */
/* JADX INFO: loaded from: classes.dex */
public interface o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f5280a = new o() { // from class: com.bytedance.sdk.a.b.o.1
        @Override // com.bytedance.sdk.a.b.o
        public List<InetAddress> a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e2) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e2);
                throw unknownHostException;
            }
        }
    };

    List<InetAddress> a(String str) throws UnknownHostException;
}
