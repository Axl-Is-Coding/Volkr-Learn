package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface Authenticator {
    public static final Authenticator NONE = new C2937b();

    C authenticate(K k, H h) throws IOException;
}
