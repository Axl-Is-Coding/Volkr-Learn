package b.d.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: AbstractContainerBox.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends e implements b.b.a.a.b {
    b.b.a.a.d j;
    protected String k;
    protected boolean l;

    public b(String str) {
        this.k = str;
    }

    protected ByteBuffer g() {
        ByteBuffer byteBufferWrap;
        if (this.l || getSize() >= 4294967296L) {
            byte[] bArr = new byte[16];
            bArr[3] = 1;
            bArr[4] = this.k.getBytes()[0];
            bArr[5] = this.k.getBytes()[1];
            bArr[6] = this.k.getBytes()[2];
            bArr[7] = this.k.getBytes()[3];
            byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.position(8);
            b.b.a.e.b(byteBufferWrap, getSize());
        } else {
            byteBufferWrap = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, this.k.getBytes()[0], this.k.getBytes()[1], this.k.getBytes()[2], this.k.getBytes()[3]});
            b.b.a.e.a(byteBufferWrap, getSize());
        }
        byteBufferWrap.rewind();
        return byteBufferWrap;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(g());
        a(writableByteChannel);
    }

    public long getSize() {
        long jD = d();
        return jD + ((long) ((this.l || 8 + jD >= 4294967296L) ? 16 : 8));
    }

    @Override // b.b.a.a.b
    public void setParent(b.b.a.a.d dVar) {
        this.j = dVar;
    }
}
