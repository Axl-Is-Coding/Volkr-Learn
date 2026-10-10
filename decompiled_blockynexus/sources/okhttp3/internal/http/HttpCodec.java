package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.J;
import okio.Sink;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    Sink createRequestBody(C c2, long j);

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    J openResponseBody(H h) throws IOException;

    H.a readResponseHeaders(boolean z) throws IOException;

    void writeRequestHeaders(C c2) throws IOException;
}
