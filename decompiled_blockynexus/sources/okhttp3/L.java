package okhttp3;

import okio.ByteString;

/* JADX INFO: compiled from: WebSocketListener.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class L {
    public abstract void a(WebSocket webSocket, int i, String str);

    public abstract void a(WebSocket webSocket, String str);

    public abstract void a(WebSocket webSocket, Throwable th, H h);

    public abstract void a(WebSocket webSocket, H h);

    public abstract void a(WebSocket webSocket, ByteString byteString);

    public abstract void b(WebSocket webSocket, int i, String str);
}
