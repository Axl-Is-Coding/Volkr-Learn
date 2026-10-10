package c.t.m.g;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: renamed from: c.t.m.g.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0451o implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3320a;

    public C0451o(String str) {
        this.f3320a = str;
    }

    public final boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f3320a) || !(obj instanceof C0451o)) {
            return false;
        }
        String str = ((C0451o) obj).f3320a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f3320a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f3320a, sSLSession);
    }
}
