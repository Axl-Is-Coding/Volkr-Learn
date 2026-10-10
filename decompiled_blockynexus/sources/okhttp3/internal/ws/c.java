package okhttp3.internal.ws;

import com.sandboxol.center.config.VipSubscribeStatus;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.C;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.H;
import okhttp3.L;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okhttp3.z;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: RealWebSocket.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements WebSocket, WebSocketReader.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Protocol> f23397a = Collections.singletonList(Protocol.HTTP_1_1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C f23398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final L f23399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Random f23400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f23401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23402f;
    private Call g;
    private final Runnable h;
    private WebSocketReader i;
    private okhttp3.internal.ws.e j;
    private ScheduledExecutorService k;
    private e l;
    private long o;
    private boolean p;
    private ScheduledFuture<?> q;
    private String s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private final ArrayDeque<ByteString> m = new ArrayDeque<>();
    private final ArrayDeque<Object> n = new ArrayDeque<>();
    private int r = -1;

    /* JADX INFO: compiled from: RealWebSocket.java */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.cancel();
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f23404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ByteString f23405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f23406c;

        b(int i, ByteString byteString, long j) {
            this.f23404a = i;
            this.f23405b = byteString;
            this.f23406c = j;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.ws.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RealWebSocket.java */
    static final class C0252c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f23407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ByteString f23408b;

        C0252c(int i, ByteString byteString) {
            this.f23407a = i;
            this.f23408b = byteString;
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.java */
    private final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.c();
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.java */
    public static abstract class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f23410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f23411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BufferedSink f23412c;

        public e(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f23410a = z;
            this.f23411b = bufferedSource;
            this.f23412c = bufferedSink;
        }
    }

    public c(C c2, L l, Random random, long j) {
        if (!"GET".equals(c2.e())) {
            throw new IllegalArgumentException("Request must be GET: " + c2.e());
        }
        this.f23398b = c2;
        this.f23399c = l;
        this.f23400d = random;
        this.f23401e = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f23402f = ByteString.of(bArr).base64();
        this.h = new okhttp3.internal.ws.a(this);
    }

    private void d() {
        ScheduledExecutorService scheduledExecutorService = this.k;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.h);
        }
    }

    public void a(z zVar) {
        z.a aVarR = zVar.r();
        aVarR.a(EventListener.f23030a);
        aVarR.a(f23397a);
        z zVarA = aVarR.a();
        C.a aVarF = this.f23398b.f();
        aVarF.b("Upgrade", "websocket");
        aVarF.b("Connection", "Upgrade");
        aVarF.b("Sec-WebSocket-Key", this.f23402f);
        aVarF.b("Sec-WebSocket-Version", VipSubscribeStatus.SUBSCRIPTION_EXPIRED);
        C cA = aVarF.a();
        this.g = okhttp3.a.a.f23061a.a(zVarA, cA);
        this.g.timeout().clearTimeout();
        this.g.enqueue(new okhttp3.internal.ws.b(this, cA));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[Catch: all -> 0x00a5, TRY_ENTER, TryCatch #1 {all -> 0x00a5, blocks: (B:23:0x0052, B:24:0x0056, B:26:0x005a, B:27:0x0076, B:33:0x0085, B:34:0x0086, B:36:0x008a, B:38:0x0095, B:41:0x009f, B:42:0x00a4, B:28:0x0077, B:29:0x0081), top: B:51:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056 A[Catch: all -> 0x00a5, TryCatch #1 {all -> 0x00a5, blocks: (B:23:0x0052, B:24:0x0056, B:26:0x005a, B:27:0x0076, B:33:0x0085, B:34:0x0086, B:36:0x008a, B:38:0x0095, B:41:0x009f, B:42:0x00a4, B:28:0x0077, B:29:0x0081), top: B:51:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean b() throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.t     // Catch: java.lang.Throwable -> Laa
            r1 = 0
            if (r0 == 0) goto L8
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Laa
            return r1
        L8:
            okhttp3.internal.ws.e r0 = r11.j     // Catch: java.lang.Throwable -> Laa
            java.util.ArrayDeque<okio.ByteString> r2 = r11.m     // Catch: java.lang.Throwable -> Laa
            java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> Laa
            okio.ByteString r2 = (okio.ByteString) r2     // Catch: java.lang.Throwable -> Laa
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L4c
            java.util.ArrayDeque<java.lang.Object> r5 = r11.n     // Catch: java.lang.Throwable -> Laa
            java.lang.Object r5 = r5.poll()     // Catch: java.lang.Throwable -> Laa
            boolean r6 = r5 instanceof okhttp3.internal.ws.c.b     // Catch: java.lang.Throwable -> Laa
            if (r6 == 0) goto L46
            int r1 = r11.r     // Catch: java.lang.Throwable -> Laa
            java.lang.String r6 = r11.s     // Catch: java.lang.Throwable -> Laa
            if (r1 == r3) goto L31
            okhttp3.internal.ws.c$e r3 = r11.l     // Catch: java.lang.Throwable -> Laa
            r11.l = r4     // Catch: java.lang.Throwable -> Laa
            java.util.concurrent.ScheduledExecutorService r4 = r11.k     // Catch: java.lang.Throwable -> Laa
            r4.shutdown()     // Catch: java.lang.Throwable -> Laa
            r4 = r3
            goto L4f
        L31:
            java.util.concurrent.ScheduledExecutorService r3 = r11.k     // Catch: java.lang.Throwable -> Laa
            okhttp3.internal.ws.c$a r7 = new okhttp3.internal.ws.c$a     // Catch: java.lang.Throwable -> Laa
            r7.<init>()     // Catch: java.lang.Throwable -> Laa
            r8 = r5
            okhttp3.internal.ws.c$b r8 = (okhttp3.internal.ws.c.b) r8     // Catch: java.lang.Throwable -> Laa
            long r8 = r8.f23406c     // Catch: java.lang.Throwable -> Laa
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> Laa
            java.util.concurrent.ScheduledFuture r3 = r3.schedule(r7, r8, r10)     // Catch: java.lang.Throwable -> Laa
            r11.q = r3     // Catch: java.lang.Throwable -> Laa
            goto L4f
        L46:
            if (r5 != 0) goto L4a
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Laa
            return r1
        L4a:
            r6 = r4
            goto L4e
        L4c:
            r5 = r4
            r6 = r5
        L4e:
            r1 = -1
        L4f:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Laa
            if (r2 == 0) goto L56
            r0.b(r2)     // Catch: java.lang.Throwable -> La5
            goto L9a
        L56:
            boolean r2 = r5 instanceof okhttp3.internal.ws.c.C0252c     // Catch: java.lang.Throwable -> La5
            if (r2 == 0) goto L86
            r1 = r5
            okhttp3.internal.ws.c$c r1 = (okhttp3.internal.ws.c.C0252c) r1     // Catch: java.lang.Throwable -> La5
            okio.ByteString r1 = r1.f23408b     // Catch: java.lang.Throwable -> La5
            okhttp3.internal.ws.c$c r5 = (okhttp3.internal.ws.c.C0252c) r5     // Catch: java.lang.Throwable -> La5
            int r2 = r5.f23407a     // Catch: java.lang.Throwable -> La5
            int r3 = r1.size()     // Catch: java.lang.Throwable -> La5
            long r5 = (long) r3     // Catch: java.lang.Throwable -> La5
            okio.Sink r0 = r0.a(r2, r5)     // Catch: java.lang.Throwable -> La5
            okio.BufferedSink r0 = okio.Okio.buffer(r0)     // Catch: java.lang.Throwable -> La5
            r0.write(r1)     // Catch: java.lang.Throwable -> La5
            r0.close()     // Catch: java.lang.Throwable -> La5
            monitor-enter(r11)     // Catch: java.lang.Throwable -> La5
            long r2 = r11.o     // Catch: java.lang.Throwable -> L83
            int r0 = r1.size()     // Catch: java.lang.Throwable -> L83
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L83
            long r2 = r2 - r0
            r11.o = r2     // Catch: java.lang.Throwable -> L83
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L83
            goto L9a
        L83:
            r0 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L83
            throw r0     // Catch: java.lang.Throwable -> La5
        L86:
            boolean r2 = r5 instanceof okhttp3.internal.ws.c.b     // Catch: java.lang.Throwable -> La5
            if (r2 == 0) goto L9f
            okhttp3.internal.ws.c$b r5 = (okhttp3.internal.ws.c.b) r5     // Catch: java.lang.Throwable -> La5
            int r2 = r5.f23404a     // Catch: java.lang.Throwable -> La5
            okio.ByteString r3 = r5.f23405b     // Catch: java.lang.Throwable -> La5
            r0.a(r2, r3)     // Catch: java.lang.Throwable -> La5
            if (r4 == 0) goto L9a
            okhttp3.L r0 = r11.f23399c     // Catch: java.lang.Throwable -> La5
            r0.a(r11, r1, r6)     // Catch: java.lang.Throwable -> La5
        L9a:
            r0 = 1
            okhttp3.a.e.a(r4)
            return r0
        L9f:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> La5
            r0.<init>()     // Catch: java.lang.Throwable -> La5
            throw r0     // Catch: java.lang.Throwable -> La5
        La5:
            r0 = move-exception
            okhttp3.a.e.a(r4)
            throw r0
        Laa:
            r0 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Laa
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.c.b():boolean");
    }

    void c() {
        synchronized (this) {
            if (this.t) {
                return;
            }
            okhttp3.internal.ws.e eVar = this.j;
            int i = this.x ? this.u : -1;
            this.u++;
            this.x = true;
            if (i == -1) {
                try {
                    eVar.a(ByteString.EMPTY);
                    return;
                } catch (IOException e2) {
                    a(e2, (H) null);
                    return;
                }
            }
            a(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f23401e + "ms (after " + (i - 1) + " successful ping/pongs)"), (H) null);
        }
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.g.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return a(i, str, 60000L);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        e eVar;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.r != -1) {
                throw new IllegalStateException("already closed");
            }
            this.r = i;
            this.s = str;
            if (this.p && this.n.isEmpty()) {
                eVar = this.l;
                this.l = null;
                if (this.q != null) {
                    this.q.cancel(false);
                }
                this.k.shutdown();
            } else {
                eVar = null;
            }
        }
        try {
            this.f23399c.b(this, i, str);
            if (eVar != null) {
                this.f23399c.a(this, i, str);
            }
        } finally {
            okhttp3.a.e.a(eVar);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.f23399c.a(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        if (!this.t && (!this.p || !this.n.isEmpty())) {
            this.m.add(byteString);
            d();
            this.v++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.w++;
        this.x = false;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.o;
    }

    @Override // okhttp3.WebSocket
    public C request() {
        return this.f23398b;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        if (str != null) {
            return a(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        this.f23399c.a(this, byteString);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return a(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    void a(H h) throws ProtocolException {
        if (h.g() == 101) {
            String strA = h.a("Connection");
            if ("Upgrade".equalsIgnoreCase(strA)) {
                String strA2 = h.a("Upgrade");
                if ("websocket".equalsIgnoreCase(strA2)) {
                    String strA3 = h.a("Sec-WebSocket-Accept");
                    String strBase64 = ByteString.encodeUtf8(this.f23402f + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (strBase64.equals(strA3)) {
                        return;
                    }
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strA3 + "'");
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strA2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strA + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + h.g() + " " + h.r() + "'");
    }

    public void a(String str, e eVar) throws IOException {
        synchronized (this) {
            this.l = eVar;
            this.j = new okhttp3.internal.ws.e(eVar.f23410a, eVar.f23412c, this.f23400d);
            this.k = new ScheduledThreadPoolExecutor(1, okhttp3.a.e.a(str, false));
            if (this.f23401e != 0) {
                this.k.scheduleAtFixedRate(new d(), this.f23401e, this.f23401e, TimeUnit.MILLISECONDS);
            }
            if (!this.n.isEmpty()) {
                d();
            }
        }
        this.i = new WebSocketReader(eVar.f23410a, eVar.f23411b, this);
    }

    public void a() throws IOException {
        while (this.r == -1) {
            this.i.a();
        }
    }

    private synchronized boolean a(ByteString byteString, int i) {
        if (!this.t && !this.p) {
            if (this.o + ((long) byteString.size()) > 16777216) {
                close(1001, null);
                return false;
            }
            this.o += (long) byteString.size();
            this.n.add(new C0252c(i, byteString));
            d();
            return true;
        }
        return false;
    }

    synchronized boolean a(int i, String str, long j) {
        okhttp3.internal.ws.d.b(i);
        ByteString byteStringEncodeUtf8 = null;
        if (str != null) {
            byteStringEncodeUtf8 = ByteString.encodeUtf8(str);
            if (byteStringEncodeUtf8.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.t && !this.p) {
            this.p = true;
            this.n.add(new b(i, byteStringEncodeUtf8, j));
            d();
            return true;
        }
        return false;
    }

    public void a(Exception exc, H h) {
        synchronized (this) {
            if (this.t) {
                return;
            }
            this.t = true;
            e eVar = this.l;
            this.l = null;
            if (this.q != null) {
                this.q.cancel(false);
            }
            if (this.k != null) {
                this.k.shutdown();
            }
            try {
                this.f23399c.a(this, exc, h);
            } finally {
                okhttp3.a.e.a(eVar);
            }
        }
    }
}
