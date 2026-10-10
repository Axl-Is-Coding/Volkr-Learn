package com.squareup.wire;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoWriter {
    private final BufferedSink sink;

    public ProtoWriter(BufferedSink bufferedSink) {
        this.sink = bufferedSink;
    }

    static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    static int int32Size(int i) {
        if (i >= 0) {
            return varint32Size(i);
        }
        return 10;
    }

    private static int makeTag(int i, FieldEncoding fieldEncoding) {
        return (i << 3) | fieldEncoding.value;
    }

    static int tagSize(int i) {
        return varint32Size(makeTag(i, FieldEncoding.VARINT));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int utf8Length(java.lang.String r7) {
        /*
            int r0 = r7.length()
            r1 = 0
            r2 = 0
        L6:
            if (r1 >= r0) goto L46
            char r3 = r7.charAt(r1)
            r4 = 128(0x80, float:1.8E-43)
            if (r3 >= r4) goto L13
        L10:
            int r2 = r2 + 1
            goto L43
        L13:
            r4 = 2048(0x800, float:2.87E-42)
            if (r3 >= r4) goto L1a
            int r2 = r2 + 2
            goto L43
        L1a:
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r4) goto L41
            r4 = 57343(0xdfff, float:8.0355E-41)
            if (r3 <= r4) goto L25
            goto L41
        L25:
            r5 = 56319(0xdbff, float:7.892E-41)
            if (r3 > r5) goto L10
            int r3 = r1 + 1
            if (r3 >= r0) goto L10
            char r5 = r7.charAt(r3)
            r6 = 56320(0xdc00, float:7.8921E-41)
            if (r5 < r6) goto L10
            char r5 = r7.charAt(r3)
            if (r5 > r4) goto L10
            int r2 = r2 + 4
            r1 = r3
            goto L43
        L41:
            int r2 = r2 + 3
        L43:
            int r1 = r1 + 1
            goto L6
        L46:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.ProtoWriter.utf8Length(java.lang.String):int");
    }

    static int varint32Size(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    static int varint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public void writeBytes(ByteString byteString) throws IOException {
        this.sink.write(byteString);
    }

    public void writeFixed32(int i) throws IOException {
        this.sink.writeIntLe(i);
    }

    public void writeFixed64(long j) throws IOException {
        this.sink.writeLongLe(j);
    }

    void writeSignedVarint32(int i) throws IOException {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    public void writeString(String str) throws IOException {
        this.sink.writeUtf8(str);
    }

    public void writeTag(int i, FieldEncoding fieldEncoding) throws IOException {
        writeVarint32(makeTag(i, fieldEncoding));
    }

    public void writeVarint32(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.sink.writeByte((i & 127) | 128);
            i >>>= 7;
        }
        this.sink.writeByte(i);
    }

    public void writeVarint64(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.sink.writeByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.sink.writeByte((int) j);
    }
}
