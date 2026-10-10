package io.rong.rtlog;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RtFullListener {
    protected ByteBuffer byteBuffer = ByteBuffer.allocateDirect(65536);

    public abstract void NotifyFull();

    public abstract void NotifyFullEnd(int i);

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }
}
