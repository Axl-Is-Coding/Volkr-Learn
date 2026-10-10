package okhttp3;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new o();

    List<n> loadForRequest(v vVar);

    void saveFromResponse(v vVar, List<n> list);
}
