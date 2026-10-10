package io.grpc.internal;

import com.google.common.base.d;
import com.google.common.io.BaseEncoding;
import io.grpc.Metadata;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public final class TransportFrameUtil {
    private static final Logger logger = Logger.getLogger(TransportFrameUtil.class.getName());
    private static final byte[] binaryHeaderSuffixBytes = Metadata.BINARY_HEADER_SUFFIX.getBytes(d.f13739a);

    private TransportFrameUtil() {
    }

    private static boolean endsWith(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i = length; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i - length]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSpecCompliantAscii(byte[] bArr) {
        for (byte b2 : bArr) {
            if (b2 < 32 || b2 > 126) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] toHttp2Headers(Metadata metadata) {
        byte[][] bArrSerialize = metadata.serialize();
        int i = 0;
        for (int i2 = 0; i2 < bArrSerialize.length; i2 += 2) {
            byte[] bArr = bArrSerialize[i2];
            byte[] bArr2 = bArrSerialize[i2 + 1];
            if (endsWith(bArr, binaryHeaderSuffixBytes)) {
                bArrSerialize[i] = bArr;
                bArrSerialize[i + 1] = BaseEncoding.a().a(bArr2).getBytes(d.f13739a);
            } else if (isSpecCompliantAscii(bArr2)) {
                bArrSerialize[i] = bArr;
                bArrSerialize[i + 1] = bArr2;
            } else {
                String str = new String(bArr, d.f13739a);
                logger.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i += 2;
        }
        return i == bArrSerialize.length ? bArrSerialize : (byte[][]) Arrays.copyOfRange(bArrSerialize, 0, i);
    }

    public static byte[][] toRawSerializedHeaders(byte[][] bArr) {
        for (int i = 0; i < bArr.length; i += 2) {
            byte[] bArr2 = bArr[i];
            int i2 = i + 1;
            byte[] bArr3 = bArr[i2];
            bArr[i] = bArr2;
            if (endsWith(bArr2, binaryHeaderSuffixBytes)) {
                bArr[i2] = BaseEncoding.a().a(new String(bArr3, d.f13739a));
            }
        }
        return bArr;
    }
}
