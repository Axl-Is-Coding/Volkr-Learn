package androidx.core.d;

import android.util.Base64;
import java.util.List;

/* JADX INFO: compiled from: FontRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f1064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f1066f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        androidx.core.f.h.a(str);
        this.f1061a = str;
        androidx.core.f.h.a(str2);
        this.f1062b = str2;
        androidx.core.f.h.a(str3);
        this.f1063c = str3;
        androidx.core.f.h.a(list);
        this.f1064d = list;
        this.f1065e = 0;
        this.f1066f = this.f1061a + "-" + this.f1062b + "-" + this.f1063c;
    }

    public List<List<byte[]>> a() {
        return this.f1064d;
    }

    public int b() {
        return this.f1065e;
    }

    public String c() {
        return this.f1066f;
    }

    public String d() {
        return this.f1061a;
    }

    public String e() {
        return this.f1062b;
    }

    public String f() {
        return this.f1063c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1061a + ", mProviderPackage: " + this.f1062b + ", mQuery: " + this.f1063c + ", mCertificates:");
        for (int i = 0; i < this.f1064d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1064d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1065e);
        return sb.toString();
    }
}
