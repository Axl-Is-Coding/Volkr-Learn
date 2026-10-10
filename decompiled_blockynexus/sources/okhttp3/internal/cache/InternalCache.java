package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.C;
import okhttp3.H;

/* JADX INFO: loaded from: classes5.dex */
public interface InternalCache {
    H get(C c2) throws IOException;

    CacheRequest put(H h) throws IOException;

    void remove(C c2) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(c cVar);

    void update(H h, H h2);
}
