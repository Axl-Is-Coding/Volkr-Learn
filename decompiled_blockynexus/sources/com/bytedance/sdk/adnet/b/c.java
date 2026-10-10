package com.bytedance.sdk.adnet.b;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FileRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Request<File> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f5387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f5388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f5389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m.a<File> f5390f;

    /* JADX INFO: compiled from: FileRequest.java */
    public interface a extends m.a<File> {
        void a(long j, long j2);
    }

    public c(String str, String str2, m.a<File> aVar) {
        super(str2, aVar);
        this.f5389e = new Object();
        this.f5390f = aVar;
        this.f5387c = new File(str);
        this.f5388d = new File(str + ".tmp");
        try {
            if (this.f5387c != null && this.f5387c.getParentFile() != null && !this.f5387c.getParentFile().exists()) {
                this.f5387c.getParentFile().mkdirs();
            }
        } catch (Throwable unused) {
        }
        setRetryPolicy(new com.bytedance.sdk.adnet.core.e(25000, 1, 1.0f));
        setShouldCache(false);
    }

    private boolean b(HttpResponse httpResponse) {
        return TextUtils.equals(a(httpResponse, "Content-Encoding"), "gzip");
    }

    private boolean c(HttpResponse httpResponse) {
        if (TextUtils.equals(a(httpResponse, "Accept-Ranges"), "bytes")) {
            return true;
        }
        String strA = a(httpResponse, "Content-Range");
        return strA != null && strA.startsWith("bytes");
    }

    private void h() {
        try {
            this.f5387c.delete();
        } catch (Throwable unused) {
        }
        try {
            this.f5387c.delete();
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected m<File> a(com.bytedance.sdk.adnet.core.i iVar) {
        if (isCanceled()) {
            h();
            return m.a(new VAdError("Request was Canceled!"));
        }
        if (!this.f5388d.canRead() || this.f5388d.length() <= 0) {
            h();
            return m.a(new VAdError("Download temporary file was invalid!"));
        }
        if (this.f5388d.renameTo(this.f5387c)) {
            return m.a((Object) null, com.bytedance.sdk.adnet.d.b.a(iVar));
        }
        h();
        return m.a(new VAdError("Can't rename the download temporary file!"));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f5389e) {
            this.f5390f = null;
        }
    }

    public File f() {
        return this.f5387c;
    }

    public File g() {
        return this.f5388d;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        HashMap map = new HashMap();
        map.put("Range", "bytes=" + this.f5388d.length() + "-");
        map.put("Accept-Encoding", "identity");
        return map;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(com.bytedance.sdk.adnet.core.HttpResponse r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.b.c.a(com.bytedance.sdk.adnet.core.HttpResponse):byte[]");
    }

    private String a(HttpResponse httpResponse, String str) {
        if (httpResponse == null || httpResponse.getHeaders() == null || httpResponse.getHeaders().isEmpty()) {
            return null;
        }
        for (Header header : httpResponse.getHeaders()) {
            if (header != null && TextUtils.equals(header.getName(), str)) {
                return header.getValue();
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<File> mVar) {
        m.a<File> aVar;
        synchronized (this.f5389e) {
            aVar = this.f5390f;
        }
        if (aVar != null) {
            aVar.a(m.a(this.f5387c, mVar.f5539b));
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(long j, long j2) {
        m.a<File> aVar;
        synchronized (this.f5389e) {
            aVar = this.f5390f;
        }
        if (aVar instanceof a) {
            ((a) aVar).a(j, j2);
        }
    }
}
