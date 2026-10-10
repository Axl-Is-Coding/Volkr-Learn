package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EventListener f23030a = new q();

    public interface Factory {
        EventListener create(Call call);
    }

    static Factory a(EventListener eventListener) {
        return new r(eventListener);
    }

    public void a(Call call) {
    }

    public void a(Call call, long j) {
    }

    public void a(Call call, IOException iOException) {
    }

    public void a(Call call, String str) {
    }

    public void a(Call call, String str, List<InetAddress> list) {
    }

    public void a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    public void a(Call call, C c2) {
    }

    public void a(Call call, Connection connection) {
    }

    public void a(Call call, H h) {
    }

    public void a(Call call, t tVar) {
    }

    public void b(Call call) {
    }

    public void b(Call call, long j) {
    }

    public void b(Call call, Connection connection) {
    }

    public void c(Call call) {
    }

    public void d(Call call) {
    }

    public void e(Call call) {
    }

    public void f(Call call) {
    }

    public void g(Call call) {
    }
}
