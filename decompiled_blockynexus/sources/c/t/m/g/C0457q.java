package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: c.t.m.g.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0457q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3346c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f3347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f3348e;

    public C0457q(int i, String str) {
        this.f3344a = i;
        this.f3345b = str;
    }

    public final String a(String str) {
        if (this.f3348e == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = this.f3348e.get(str.toLowerCase());
        return !TextUtils.isEmpty(str2) ? str2 : "";
    }

    public final void a(Map<String, String> map) {
        this.f3348e = new HashMap();
        if (map.size() > 0) {
            for (String str : map.keySet()) {
                this.f3348e.put(str.toLowerCase(), map.get(str));
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("errorCode:");
        sb.append(this.f3344a);
        sb.append(",errorInfo:");
        sb.append(this.f3345b);
        sb.append(",httpStatus:");
        sb.append(this.f3346c);
        sb.append(",headers:");
        sb.append(this.f3348e);
        sb.append(",body:");
        byte[] bArr = this.f3347d;
        sb.append(bArr != null ? Integer.valueOf(bArr.length) : "null");
        return sb.toString();
    }
}
