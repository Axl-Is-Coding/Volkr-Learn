package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.adnet.face.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: BasicNetwork.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.sdk.adnet.face.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f5476a = o.f5544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final IHttpStack f5477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final b f5478c;

    public a(IHttpStack iHttpStack) {
        this(iHttpStack, new b(4096));
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
    
        throw new java.io.IOException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0150, code lost:
    
        throw new com.bytedance.sdk.adnet.err.f(r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.bytedance.sdk.adnet.core.a] */
    @Override // com.bytedance.sdk.adnet.face.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.adnet.core.i a(com.bytedance.sdk.adnet.core.Request<?> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.a.a(com.bytedance.sdk.adnet.core.Request):com.bytedance.sdk.adnet.core.i");
    }

    public a(IHttpStack iHttpStack, b bVar) {
        this.f5477b = iHttpStack;
        this.f5478c = bVar;
    }

    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (f5476a || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().b());
            o.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VAdError vAdError) throws VAdError {
        com.bytedance.sdk.adnet.face.d retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.a(vAdError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VAdError e2) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e2;
        }
    }

    private Map<String, String> a(a.C0073a c0073a) {
        if (c0073a == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String str = c0073a.f5568c;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j = c0073a.f5570e;
        if (j > 0) {
            map.put("If-Modified-Since", com.bytedance.sdk.adnet.d.b.a(j));
        }
        return map;
    }

    protected byte[] a(Request<?> request, HttpResponse httpResponse) throws IOException, com.bytedance.sdk.adnet.err.f {
        if (request instanceof com.bytedance.sdk.adnet.b.c) {
            return ((com.bytedance.sdk.adnet.b.c) request).a(httpResponse);
        }
        InputStream content = httpResponse.getContent();
        if (content != null) {
            return a(content, httpResponse.getContentLength());
        }
        return new byte[0];
    }

    private byte[] a(InputStream inputStream, int i) throws IOException, com.bytedance.sdk.adnet.err.f {
        c cVar = new c(this.f5478c, i);
        try {
            if (inputStream != null) {
                byte[] bArrA = this.f5478c.a(1024);
                while (true) {
                    int i2 = inputStream.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    cVar.write(bArrA, 0, i2);
                }
                byte[] byteArray = cVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        o.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f5478c.a(bArrA);
                cVar.close();
                return byteArray;
            }
            throw new com.bytedance.sdk.adnet.err.f();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    o.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f5478c.a((byte[]) null);
            cVar.close();
            throw th;
        }
    }

    private static List<Header> a(List<Header> list, a.C0073a c0073a) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (list != null && !list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.getName());
                arrayList.add(header);
            }
        }
        if (c0073a != null) {
            List<Header> list2 = c0073a.i;
            if (list2 != null) {
                if (!list2.isEmpty()) {
                    for (Header header2 : c0073a.i) {
                        if (!treeSet.contains(header2.getName())) {
                            arrayList.add(header2);
                        }
                    }
                }
            } else if (!c0073a.h.isEmpty()) {
                for (Map.Entry<String, String> entry : c0073a.h.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new Header(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return arrayList;
    }
}
