package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* JADX INFO: compiled from: PushObserver.java */
/* JADX INFO: loaded from: classes5.dex */
class r implements PushObserver {
    r() {
    }

    @Override // okhttp3.internal.http2.PushObserver
    public boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        bufferedSource.skip(i2);
        return true;
    }

    @Override // okhttp3.internal.http2.PushObserver
    public boolean onHeaders(int i, List<Header> list, boolean z) {
        return true;
    }

    @Override // okhttp3.internal.http2.PushObserver
    public boolean onRequest(int i, List<Header> list) {
        return true;
    }

    @Override // okhttp3.internal.http2.PushObserver
    public void onReset(int i, ErrorCode errorCode) {
    }
}
