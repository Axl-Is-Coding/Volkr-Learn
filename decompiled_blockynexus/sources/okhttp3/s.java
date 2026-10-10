package okhttp3;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: compiled from: FormBody.java */
/* JADX INFO: loaded from: classes5.dex */
public final class s extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final w f23454a = w.a("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f23455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f23456c;

    /* JADX INFO: compiled from: FormBody.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f23457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f23458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Charset f23459c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f23457a.add(v.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f23459c));
            this.f23458b.add(v.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f23459c));
            return this;
        }

        public a b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f23457a.add(v.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f23459c));
            this.f23458b.add(v.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f23459c));
            return this;
        }

        public a(Charset charset) {
            this.f23457a = new ArrayList();
            this.f23458b = new ArrayList();
            this.f23459c = charset;
        }

        public s a() {
            return new s(this.f23457a, this.f23458b);
        }
    }

    s(List<String> list, List<String> list2) {
        this.f23455b = okhttp3.a.e.a(list);
        this.f23456c = okhttp3.a.e.a(list2);
    }

    public int a() {
        return this.f23455b.size();
    }

    public String b(int i) {
        return this.f23456c.get(i);
    }

    public String c(int i) {
        return v.a(b(i), true);
    }

    @Override // okhttp3.G
    public long contentLength() {
        return a(null, true);
    }

    @Override // okhttp3.G
    public w contentType() {
        return f23454a;
    }

    @Override // okhttp3.G
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        a(bufferedSink, false);
    }

    public String a(int i) {
        return this.f23455b.get(i);
    }

    private long a(BufferedSink bufferedSink, boolean z) throws EOFException {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.f23455b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f23455b.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f23456c.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }
}
