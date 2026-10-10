package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.FrameReader;
import com.squareup.okhttp.internal.framed.Hpack;
import io.rong.push.common.PushConst;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public final class Http2 implements Variant {
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    private static final Logger logger = Logger.getLogger(FrameLogger.class.getName());
    private static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int medium = Http2.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte b2 = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(true, this.streamId, this.length, b2, this.flags));
            }
            this.streamId = this.source.readInt() & Integer.MAX_VALUE;
            if (b2 != 9) {
                Http2.access$200("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(b2)});
                throw null;
            }
            if (this.streamId == i) {
                return;
            }
            Http2.access$200("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.left;
                if (i != 0) {
                    long j2 = this.source.read(buffer, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left = (int) (((long) this.left) - j2);
                    return j2;
                }
                this.source.skip(this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    static final class FrameLogger {
        private static final String[] TYPES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", PushConst.PING_STRING_EXTRA, "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] FLAGS = new String[64];
        private static final String[] BINARY = new String[256];

        static {
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = BINARY;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = String.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
                i2++;
            }
            String[] strArr2 = FLAGS;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i3 : iArr) {
                FLAGS[i3 | 8] = FLAGS[i3] + "|PADDED";
            }
            String[] strArr3 = FLAGS;
            strArr3[4] = "END_HEADERS";
            strArr3[32] = "PRIORITY";
            strArr3[36] = "END_HEADERS|PRIORITY";
            for (int i4 : new int[]{4, 32, 36}) {
                for (int i5 : iArr) {
                    int i6 = i5 | i4;
                    FLAGS[i6] = FLAGS[i5] + '|' + FLAGS[i4];
                    FLAGS[i6 | 8] = FLAGS[i5] + '|' + FLAGS[i4] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr4 = FLAGS;
                if (i >= strArr4.length) {
                    return;
                }
                if (strArr4[i] == null) {
                    strArr4[i] = BINARY[i];
                }
                i++;
            }
        }

        FrameLogger() {
        }

        static String formatFlags(byte b2, byte b3) {
            if (b3 == 0) {
                return "";
            }
            if (b2 != 2 && b2 != 3) {
                if (b2 == 4 || b2 == 6) {
                    return b3 == 1 ? "ACK" : BINARY[b3];
                }
                if (b2 != 7 && b2 != 8) {
                    String[] strArr = FLAGS;
                    String str = b3 < strArr.length ? strArr[b3] : BINARY[b3];
                    return (b2 != 5 || (b3 & 4) == 0) ? (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return BINARY[b3];
        }

        static String formatHeader(boolean z, int i, int i2, byte b2, byte b3) {
            String[] strArr = TYPES;
            String str = b2 < strArr.length ? strArr[b2] : String.format("0x%02x", Byte.valueOf(b2));
            String flags = formatFlags(b2, b3);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str;
            objArr[4] = flags;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    static /* synthetic */ IOException access$200(String str, Object[] objArr) throws IOException {
        ioException(str, objArr);
        throw null;
    }

    static /* synthetic */ IllegalArgumentException access$500(String str, Object[] objArr) {
        illegalArgument(str, objArr);
        throw null;
    }

    private static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    private static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lengthWithoutPadding(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeMedium(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader newReader(BufferedSource bufferedSource, boolean z) {
        return new Reader(bufferedSource, 4096, z);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z) {
        return new Writer(bufferedSink, z);
    }

    static final class Reader implements FrameReader {
        private final boolean client;
        private final ContinuationSource continuation;
        final Hpack.Reader hpackReader;
        private final BufferedSource source;

        Reader(BufferedSource bufferedSource, int i, boolean z) {
            this.source = bufferedSource;
            this.client = z;
            this.continuation = new ContinuationSource(this.source);
            this.hpackReader = new Hpack.Reader(i, this.continuation);
        }

        private void readData(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 32) != 0) {
                Http2.access$200("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                throw null;
            }
            short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
            handler.data(z, i2, this.source, Http2.lengthWithoutPadding(i, b2, s));
            this.source.skip(s);
        }

        private void readGoAway(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i < 8) {
                Http2.access$200("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 != 0) {
                Http2.access$200("TYPE_GOAWAY streamId != 0", new Object[0]);
                throw null;
            }
            int i3 = this.source.readInt();
            int i4 = this.source.readInt();
            int i5 = i - 8;
            ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i4);
            if (errorCodeFromHttp2 == null) {
                Http2.access$200("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(i4)});
                throw null;
            }
            ByteString byteString = ByteString.EMPTY;
            if (i5 > 0) {
                byteString = this.source.readByteString(i5);
            }
            handler.goAway(i3, errorCodeFromHttp2, byteString);
        }

        private List<Header> readHeaderBlock(int i, short s, byte b2, int i2) throws IOException {
            ContinuationSource continuationSource = this.continuation;
            continuationSource.left = i;
            continuationSource.length = i;
            continuationSource.padding = s;
            continuationSource.flags = b2;
            continuationSource.streamId = i2;
            this.hpackReader.readHeaders();
            return this.hpackReader.getAndResetHeaderList();
        }

        private void readHeaders(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i2 == 0) {
                Http2.access$200("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                throw null;
            }
            boolean z = (b2 & 1) != 0;
            short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
            if ((b2 & 32) != 0) {
                readPriority(handler, i2);
                i -= 5;
            }
            handler.headers(false, z, i2, -1, readHeaderBlock(Http2.lengthWithoutPadding(i, b2, s), s, b2, i2), HeadersMode.HTTP_20_HEADERS);
        }

        private void readPing(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i != 8) {
                Http2.access$200("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 != 0) {
                Http2.access$200("TYPE_PING streamId != 0", new Object[0]);
                throw null;
            }
            handler.ping((b2 & 1) != 0, this.source.readInt(), this.source.readInt());
        }

        private void readPriority(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i != 5) {
                Http2.access$200("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 != 0) {
                readPriority(handler, i2);
            } else {
                Http2.access$200("TYPE_PRIORITY streamId == 0", new Object[0]);
                throw null;
            }
        }

        private void readPushPromise(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i2 == 0) {
                Http2.access$200("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                throw null;
            }
            short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
            handler.pushPromise(i2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Http2.lengthWithoutPadding(i - 4, b2, s), s, b2, i2));
        }

        private void readRstStream(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i != 4) {
                Http2.access$200("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            if (i2 == 0) {
                Http2.access$200("TYPE_RST_STREAM streamId == 0", new Object[0]);
                throw null;
            }
            int i3 = this.source.readInt();
            ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i3);
            if (errorCodeFromHttp2 != null) {
                handler.rstStream(i2, errorCodeFromHttp2);
            } else {
                Http2.access$200("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(i3)});
                throw null;
            }
        }

        private void readSettings(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i2 != 0) {
                Http2.access$200("TYPE_SETTINGS streamId != 0", new Object[0]);
                throw null;
            }
            if ((b2 & 1) != 0) {
                if (i == 0) {
                    handler.ackSettings();
                    return;
                } else {
                    Http2.access$200("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    throw null;
                }
            }
            if (i % 6 != 0) {
                Http2.access$200("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short s = this.source.readShort();
                int i4 = this.source.readInt();
                switch (s) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (i4 != 0 && i4 != 1) {
                            Http2.access$200("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            throw null;
                        }
                        break;
                        break;
                    case 3:
                        s = 4;
                        break;
                    case 4:
                        s = 7;
                        if (i4 < 0) {
                            Http2.access$200("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                        break;
                        break;
                    case 5:
                        if (i4 < Http2.INITIAL_MAX_FRAME_SIZE || i4 > 16777215) {
                            Http2.access$200("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(i4)});
                            throw null;
                        }
                        break;
                        break;
                    default:
                        Http2.access$200("PROTOCOL_ERROR invalid settings id: %s", new Object[]{Short.valueOf(s)});
                        throw null;
                }
                settings.set(s, 0, i4);
            }
            handler.settings(false, settings);
            if (settings.getHeaderTableSize() >= 0) {
                this.hpackReader.headerTableSizeSetting(settings.getHeaderTableSize());
            }
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, byte b2, int i2) throws IOException {
            if (i != 4) {
                Http2.access$200("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            long j = ((long) this.source.readInt()) & 2147483647L;
            if (j != 0) {
                handler.windowUpdate(i2, j);
            } else {
                Http2.access$200("windowSizeIncrement was 0", new Object[]{Long.valueOf(j)});
                throw null;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.source.close();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                this.source.require(9L);
                int medium = Http2.readMedium(this.source);
                if (medium < 0 || medium > Http2.INITIAL_MAX_FRAME_SIZE) {
                    Http2.access$200("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(medium)});
                    throw null;
                }
                byte b2 = (byte) (this.source.readByte() & 255);
                byte b3 = (byte) (this.source.readByte() & 255);
                int i = this.source.readInt() & Integer.MAX_VALUE;
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(FrameLogger.formatHeader(true, i, medium, b2, b3));
                }
                switch (b2) {
                    case 0:
                        readData(handler, medium, b3, i);
                        return true;
                    case 1:
                        readHeaders(handler, medium, b3, i);
                        return true;
                    case 2:
                        readPriority(handler, medium, b3, i);
                        return true;
                    case 3:
                        readRstStream(handler, medium, b3, i);
                        return true;
                    case 4:
                        readSettings(handler, medium, b3, i);
                        return true;
                    case 5:
                        readPushPromise(handler, medium, b3, i);
                        return true;
                    case 6:
                        readPing(handler, medium, b3, i);
                        return true;
                    case 7:
                        readGoAway(handler, medium, b3, i);
                        return true;
                    case 8:
                        readWindowUpdate(handler, medium, b3, i);
                        return true;
                    default:
                        this.source.skip(medium);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void readConnectionPreface() throws IOException {
            if (this.client) {
                return;
            }
            ByteString byteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(String.format("<< CONNECTION %s", byteString.hex()));
            }
            if (Http2.CONNECTION_PREFACE.equals(byteString)) {
                return;
            }
            Http2.access$200("Expected a connection header but was %s", new Object[]{byteString.utf8()});
            throw null;
        }

        private void readPriority(FrameReader.Handler handler, int i) throws IOException {
            int i2 = this.source.readInt();
            handler.priority(i, i2 & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & i2) != 0);
        }
    }

    static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final Buffer hpackBuffer = new Buffer();
        private final Hpack.Writer hpackWriter = new Hpack.Writer(this.hpackBuffer);
        private int maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        private final BufferedSink sink;

        Writer(BufferedSink bufferedSink, boolean z) {
            this.sink = bufferedSink;
            this.client = z;
        }

        private void writeContinuationFrames(int i, long j) throws IOException {
            while (j > 0) {
                int iMin = (int) Math.min(this.maxFrameSize, j);
                long j2 = iMin;
                j -= j2;
                frameHeader(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.sink.write(this.hpackBuffer, j2);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ackSettings(Settings settings) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.closed = true;
            this.sink.close();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void connectionPreface() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(String.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            dataFrame(i, z ? (byte) 1 : (byte) 0, buffer, i2);
        }

        void dataFrame(int i, byte b2, Buffer buffer, int i2) throws IOException {
            frameHeader(i, i2, (byte) 0, b2);
            if (i2 > 0) {
                this.sink.write(buffer, i2);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
        }

        void frameHeader(int i, int i2, byte b2, byte b3) throws IOException {
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(false, i, i2, b2, b3));
            }
            int i3 = this.maxFrameSize;
            if (i2 > i3) {
                Http2.access$500("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                throw null;
            }
            if ((Integer.MIN_VALUE & i) != 0) {
                Http2.access$500("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
                throw null;
            }
            Http2.writeMedium(this.sink, i2);
            this.sink.writeByte(b2 & 255);
            this.sink.writeByte(b3 & 255);
            this.sink.writeInt(i & Integer.MAX_VALUE);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode == -1) {
                Http2.access$500("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.sink.writeInt(i);
            this.sink.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.sink.write(bArr);
            }
            this.sink.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void headers(int i, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            headers(false, i, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int maxDataLength() {
            return this.maxFrameSize;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ping(boolean z, int i, int i2) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.sink.writeInt(i);
            this.sink.writeInt(i2);
            this.sink.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int iMin = (int) Math.min(this.maxFrameSize - 4, size);
            long j = iMin;
            frameHeader(i, iMin + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
            this.sink.writeInt(i2 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j);
            if (size > j) {
                writeContinuationFrames(i, size - j);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode == -1) {
                throw new IllegalArgumentException();
            }
            frameHeader(i, 4, (byte) 3, (byte) 0);
            this.sink.writeInt(errorCode.httpCode);
            this.sink.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void settings(Settings settings) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            int i = 0;
            frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.isSet(i)) {
                    this.sink.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.sink.writeInt(settings.get(i));
                }
                i++;
            }
            this.sink.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            headers(z, i, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synStream(boolean z, boolean z2, int i, int i2, List<Header> list) throws IOException {
            try {
                if (z2) {
                    throw new UnsupportedOperationException();
                }
                if (this.closed) {
                    throw new IOException("closed");
                }
                headers(z, i, list);
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void windowUpdate(int i, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                Http2.access$500("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j)});
                throw null;
            }
            frameHeader(i, 4, (byte) 8, (byte) 0);
            this.sink.writeInt((int) j);
            this.sink.flush();
        }

        void headers(boolean z, int i, List<Header> list) throws IOException {
            if (!this.closed) {
                this.hpackWriter.writeHeaders(list);
                long size = this.hpackBuffer.size();
                int iMin = (int) Math.min(this.maxFrameSize, size);
                long j = iMin;
                byte b2 = size == j ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                frameHeader(i, iMin, (byte) 1, b2);
                this.sink.write(this.hpackBuffer, j);
                if (size > j) {
                    writeContinuationFrames(i, size - j);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }
}
