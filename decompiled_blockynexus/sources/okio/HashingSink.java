package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: HashingSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* JADX INFO: compiled from: HashingSink.kt */
    public static final class Companion {
        private Companion() {
        }

        public final HashingSink hmacSha1(Sink sink, ByteString byteString) {
            i.b(sink, "sink");
            i.b(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA1");
        }

        public final HashingSink hmacSha256(Sink sink, ByteString byteString) {
            i.b(sink, "sink");
            i.b(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA256");
        }

        public final HashingSink hmacSha512(Sink sink, ByteString byteString) {
            i.b(sink, "sink");
            i.b(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA512");
        }

        public final HashingSink md5(Sink sink) {
            i.b(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        public final HashingSink sha1(Sink sink) {
            i.b(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        public final HashingSink sha256(Sink sink) {
            i.b(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        public final HashingSink sha512(Sink sink) {
            i.b(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, String str) {
        super(sink);
        i.b(sink, "sink");
        i.b(str, "algorithm");
        this.messageDigest = MessageDigest.getInstance(str);
        this.mac = null;
    }

    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m141deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        byte[] bArrDoFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            bArrDoFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            if (mac == null) {
                i.a();
                throw null;
            }
            bArrDoFinal = mac.doFinal();
        }
        i.a((Object) bArrDoFinal, "result");
        return new ByteString(bArrDoFinal);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        i.b(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0L, j);
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        long j2 = 0;
        while (j2 < j) {
            int iMin = (int) Math.min(j - j2, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                Mac mac = this.mac;
                if (mac == null) {
                    i.a();
                    throw null;
                }
                mac.update(segment.data, segment.pos, iMin);
            }
            j2 += (long) iMin;
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
        }
        super.write(buffer, j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, ByteString byteString, String str) throws NoSuchAlgorithmException {
        super(sink);
        i.b(sink, "sink");
        i.b(byteString, "key");
        i.b(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
