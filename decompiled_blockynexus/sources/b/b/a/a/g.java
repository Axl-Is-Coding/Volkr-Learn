package b.b.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: DataReferenceBox.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends b.d.a.b implements i {
    private int m;
    private int n;

    public g() {
        super("dref");
    }

    @Override // b.d.a.b, b.b.a.a.b
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(g());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        b.b.a.e.c(byteBufferAllocate, this.m);
        b.b.a.e.b(byteBufferAllocate, this.n);
        b.b.a.e.a(byteBufferAllocate, b().size());
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        a(writableByteChannel);
    }

    @Override // b.d.a.b, b.b.a.a.b
    public long getSize() {
        long jD = d() + 8;
        return jD + ((long) ((this.l || 8 + jD >= 4294967296L) ? 16 : 8));
    }
}
