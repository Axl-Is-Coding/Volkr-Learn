package okhttp3;

import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(C c2, L l);
    }

    void cancel();

    boolean close(int i, String str);

    long queueSize();

    C request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
