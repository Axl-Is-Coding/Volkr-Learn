package io.rong.rtlog;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RtCronListener {
    protected ByteBuffer byteBuffer = ByteBuffer.allocateDirect(65536);

    public abstract void NotifyCron();

    public abstract void NotifyCronEnd(int i, String str, String str2, int i2);

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }
}
