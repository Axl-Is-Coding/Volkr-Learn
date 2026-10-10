package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ElfParser.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements c, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12509a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileChannel f12510b;

    public f(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f12510b = new FileInputStream(file).getChannel();
    }

    private long a(c.b bVar, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            c.AbstractC0098c abstractC0098cA = bVar.a(j3);
            if (abstractC0098cA.f12504a == 1) {
                long j4 = abstractC0098cA.f12506c;
                if (j4 <= j2 && j2 <= abstractC0098cA.f12507d + j4) {
                    return (j2 - j4) + abstractC0098cA.f12505b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public c.b b() throws IOException {
        this.f12510b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (e(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sA = a(byteBufferAllocate, 4L);
        boolean z = a(byteBufferAllocate, 5L) == 2;
        if (sA == 1) {
            return new d(z, this);
        }
        if (sA == 2) {
            return new e(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    protected long c(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12510b.close();
    }

    public List<String> d() throws IOException {
        long j;
        this.f12510b.position(0L);
        ArrayList arrayList = new ArrayList();
        c.b bVarB = b();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVarB.f12498a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = bVarB.f12503f;
        int i = 0;
        if (j2 == 65535) {
            j2 = bVarB.a(0).f12508a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            c.AbstractC0098c abstractC0098cA = bVarB.a(j3);
            if (abstractC0098cA.f12504a == 2) {
                j = abstractC0098cA.f12505b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j4 = 0;
        while (true) {
            c.a aVarA = bVarB.a(j, i);
            long j5 = j;
            long j6 = aVarA.f12496a;
            if (j6 == 1) {
                arrayList2.add(Long.valueOf(aVarA.f12497b));
            } else if (j6 == 5) {
                j4 = aVarA.f12497b;
            }
            i++;
            if (aVarA.f12496a == 0) {
                break;
            }
            j = j5;
        }
        if (j4 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(bVarB, j2, j4);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(d(byteBufferAllocate, ((Long) it.next()).longValue() + jA));
        }
        return arrayList;
    }

    protected long e(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    protected short a(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    protected void a(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int i2 = this.f12510b.read(byteBuffer, j + j2);
            if (i2 == -1) {
                throw new EOFException();
            }
            j2 += (long) i2;
        }
        byteBuffer.position(0);
    }

    protected int b(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    protected String d(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short sA = a(byteBuffer, j);
            if (sA != 0) {
                sb.append((char) sA);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }
}
