package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: BasicNetwork.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.android.volley.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f4038a = com.android.volley.p.f4029b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    protected final j f4039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f4040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final e f4041d;

    @Deprecated
    public c(j jVar) {
        this(jVar, new e(4096));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        throw new java.io.IOException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0128, code lost:
    
        throw new com.android.volley.ServerError(r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.android.volley.toolbox.c] */
    @Override // com.android.volley.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.android.volley.j a(com.android.volley.Request<?> r29) throws com.android.volley.VolleyError {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.c.a(com.android.volley.Request):com.android.volley.j");
    }

    @Deprecated
    public c(j jVar, e eVar) {
        this.f4039b = jVar;
        this.f4040c = new a(jVar);
        this.f4041d = eVar;
    }

    public c(b bVar) {
        this(bVar, new e(4096));
    }

    public c(b bVar, e eVar) {
        this.f4040c = bVar;
        this.f4039b = bVar;
        this.f4041d = eVar;
    }

    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (f4038a || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.q().a());
            com.android.volley.p.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        com.android.volley.o oVarQ = request.q();
        int iR = request.r();
        try {
            oVarQ.a(volleyError);
            request.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iR)));
        } catch (VolleyError e2) {
            request.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iR)));
            throw e2;
        }
    }

    private Map<String, String> a(a.C0049a c0049a) {
        if (c0049a == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String str = c0049a.f3977b;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j = c0049a.f3979d;
        if (j > 0) {
            map.put("If-Modified-Since", h.a(j));
        }
        return map;
    }

    private byte[] a(InputStream inputStream, int i) throws ServerError, IOException {
        p pVar = new p(this.f4041d, i);
        try {
            if (inputStream != null) {
                byte[] bArrA = this.f4041d.a(1024);
                while (true) {
                    int i2 = inputStream.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    pVar.write(bArrA, 0, i2);
                }
                byte[] byteArray = pVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        com.android.volley.p.c("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f4041d.a(bArrA);
                pVar.close();
                return byteArray;
            }
            throw new ServerError();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    com.android.volley.p.c("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f4041d.a((byte[]) null);
            pVar.close();
            throw th;
        }
    }

    private static List<com.android.volley.g> a(List<com.android.volley.g> list, a.C0049a c0049a) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.android.volley.g> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.android.volley.g> list2 = c0049a.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.android.volley.g gVar : c0049a.h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!c0049a.g.isEmpty()) {
            for (Map.Entry<String, String> entry : c0049a.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.android.volley.g(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }
}
