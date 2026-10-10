package c.t.m.g;

import c.t.m.g.C0412b;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: c.t.m.g.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0421e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3143a = "info.3g.qq.com";

    public static boolean a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean[] zArr = {false};
        C0412b.a.f3093a.f3092a.execute(new RunnableC0424f(zArr, countDownLatch));
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return zArr[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.Socket] */
    private static boolean a(String str) throws Throwable {
        ?? socket;
        boolean zIsConnected;
        ?? r0 = 0;
        ?? r02 = 0;
        try {
            try {
                socket = new Socket();
            } catch (Throwable th) {
                th = th;
                socket = r0;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, 80);
            socket.connect(inetSocketAddress, 5000);
            zIsConnected = socket.isConnected();
            try {
                socket.close();
                r0 = inetSocketAddress;
            } catch (Throwable th3) {
                th3.printStackTrace();
                r0 = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            if (socket != 0) {
                try {
                    socket.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            throw th;
        }
        return zIsConnected;
    }

    public static boolean b() {
        return a(f3143a);
    }
}
