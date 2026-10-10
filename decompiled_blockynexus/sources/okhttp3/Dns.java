package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface Dns {
    public static final Dns SYSTEM = new p();

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
