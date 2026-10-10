package okhttp3;

import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public interface Connection {
    t handshake();

    Protocol protocol();

    K route();

    Socket socket();
}
