package okhttp3.internal.http2;

import okhttp3.u;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class Header {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteString f23258a = ByteString.encodeUtf8(":");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f23259b = ByteString.encodeUtf8(":status");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ByteString f23260c = ByteString.encodeUtf8(":method");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteString f23261d = ByteString.encodeUtf8(":path");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f23262e = ByteString.encodeUtf8(":scheme");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f23263f = ByteString.encodeUtf8(":authority");
    public final ByteString g;
    public final ByteString h;
    final int i;

    interface Listener {
        void onHeaders(u uVar);
    }

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.g.equals(header.g) && this.h.equals(header.h);
    }

    public int hashCode() {
        return ((527 + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return okhttp3.a.e.a("%s: %s", this.g.utf8(), this.h.utf8());
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.g = byteString;
        this.h = byteString2;
        this.i = byteString.size() + 32 + byteString2.size();
    }
}
