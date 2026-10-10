package io.grpc.internal;

import io.grpc.Compressor;
import io.grpc.Decompressor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface Stream {
    void flush();

    boolean isReady();

    void request(int i);

    void setCompressor(Compressor compressor);

    void setDecompressor(Decompressor decompressor);

    void setMessageCompression(boolean z);

    void writeMessage(InputStream inputStream);
}
