package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
final class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Stack<ByteString> f14326a;

        private a() {
            this.f14326a = new Stack<>();
        }

        private void b(ByteString byteString) {
            int iA = a(byteString.size());
            int i = RopeByteString.minLengthByDepth[iA + 1];
            if (this.f14326a.isEmpty() || this.f14326a.peek().size() >= i) {
                this.f14326a.push(byteString);
                return;
            }
            int i2 = RopeByteString.minLengthByDepth[iA];
            ByteString byteStringPop = this.f14326a.pop();
            while (true) {
                if (this.f14326a.isEmpty() || this.f14326a.peek().size() >= i2) {
                    break;
                } else {
                    byteStringPop = new RopeByteString(this.f14326a.pop(), byteStringPop);
                }
            }
            RopeByteString ropeByteString = new RopeByteString(byteStringPop, byteString);
            while (!this.f14326a.isEmpty()) {
                if (this.f14326a.peek().size() >= RopeByteString.minLengthByDepth[a(ropeByteString.size()) + 1]) {
                    break;
                } else {
                    ropeByteString = new RopeByteString(this.f14326a.pop(), ropeByteString);
                }
            }
            this.f14326a.push(ropeByteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString a(ByteString byteString, ByteString byteString2) {
            a(byteString);
            a(byteString2);
            ByteString byteStringPop = this.f14326a.pop();
            while (!this.f14326a.isEmpty()) {
                byteStringPop = new RopeByteString(this.f14326a.pop(), byteStringPop);
            }
            return byteStringPop;
        }

        private void a(ByteString byteString) {
            if (byteString.isBalanced()) {
                b(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                a(ropeByteString.left);
                a(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int a(int i) {
            int iBinarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }
    }

    private static class b implements Iterator<ByteString.LeafByteString> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Stack<RopeByteString> f14327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteString.LeafByteString f14328b;

        private ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f14327a.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14328b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b(ByteString byteString) {
            this.f14327a = new Stack<>();
            this.f14328b = a(byteString);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f14328b;
            if (leafByteString == null) {
                throw new NoSuchElementException();
            }
            this.f14328b = a();
            return leafByteString;
        }

        private ByteString.LeafByteString a() {
            while (!this.f14327a.isEmpty()) {
                ByteString.LeafByteString leafByteStringA = a(this.f14327a.pop().right);
                if (!leafByteStringA.isEmpty()) {
                    return leafByteStringA;
                }
            }
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return concatenateBytes(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            }
            if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        return size >= minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1] ? new RopeByteString(byteString, byteString2) : new a().a(byteString, byteString2);
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        b bVar = new b(this);
        ByteString.LeafByteString next = bVar.next();
        b bVar2 = new b(byteString);
        ByteString.LeafByteString next2 = bVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? next.equalsRange(next2, i2, iMin) : next2.equalsRange(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.totalLength;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = bVar.next();
                i = 0;
            } else {
                i += iMin;
                next = next;
            }
            if (iMin == size2) {
                next2 = bVar2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b(this);
        while (bVar.hasNext()) {
            arrayList.add(bVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        ByteString.checkIndex(i, this.totalLength);
        int i2 = this.leftLength;
        return i < i2 ? this.left.byteAt(i) : this.right.byteAt(i - i2);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            this.left.copyToInternal(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.right.copyToInternal(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.left.copyToInternal(bArr, i, i2, i6);
            this.right.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int iPeekCachedHashCode = peekCachedHashCode();
        int iPeekCachedHashCode2 = byteString.peekCachedHashCode();
        if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
            return equalsFragments(byteString);
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    protected boolean isBalanced() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int iPartialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(iPartialIsValidUtf8, 0, byteString.size()) == 0;
    }

    @Override // com.google.protobuf.ByteString
    public C2301g newCodedInput() {
        return C2301g.a(new c());
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new c();
    }

    @Override // com.google.protobuf.ByteString
    protected int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialHash(this.left.partialHash(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.protobuf.ByteString
    protected int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        int iCheckRange = ByteString.checkRange(i, i2, this.totalLength);
        if (iCheckRange == 0) {
            return ByteString.EMPTY;
        }
        if (iCheckRange == this.totalLength) {
            return this;
        }
        int i3 = this.leftLength;
        return i2 <= i3 ? this.left.substring(i, i2) : i >= i3 ? this.right.substring(i - i3, i2 - i3) : new RopeByteString(this.left.substring(i), this.right.substring(0, i2 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.google.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.leftLength;
        if (i3 <= i4) {
            this.left.writeToInternal(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.right.writeToInternal(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.left.writeToInternal(outputStream, i, i5);
            this.right.writeToInternal(outputStream, 0, i2 - i5);
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        this.leftLength = byteString.size();
        this.totalLength = this.leftLength + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    @Override // com.google.protobuf.ByteString
    void writeTo(AbstractC2299e abstractC2299e) throws IOException {
        this.left.writeTo(abstractC2299e);
        this.right.writeTo(abstractC2299e);
    }

    private class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f14329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteString.LeafByteString f14330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f14331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f14332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14333e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f14334f;

        public c() {
            d();
        }

        private int a(byte[] bArr, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                b();
                if (this.f14330b != null) {
                    int iMin = Math.min(this.f14331c - this.f14332d, i4);
                    if (bArr != null) {
                        this.f14330b.copyTo(bArr, this.f14332d, i3, iMin);
                        i3 += iMin;
                    }
                    this.f14332d += iMin;
                    i4 -= iMin;
                } else if (i4 == i2) {
                    return -1;
                }
            }
            return i2 - i4;
        }

        private void b() {
            if (this.f14330b != null) {
                int i = this.f14332d;
                int i2 = this.f14331c;
                if (i == i2) {
                    this.f14333e += i2;
                    this.f14332d = 0;
                    if (this.f14329a.hasNext()) {
                        this.f14330b = this.f14329a.next();
                        this.f14331c = this.f14330b.size();
                    } else {
                        this.f14330b = null;
                        this.f14331c = 0;
                    }
                }
            }
        }

        private void d() {
            this.f14329a = new b(RopeByteString.this);
            this.f14330b = this.f14329a.next();
            this.f14331c = this.f14330b.size();
            this.f14332d = 0;
            this.f14333e = 0;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return RopeByteString.this.size() - (this.f14333e + this.f14332d);
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.f14334f = this.f14333e + this.f14332d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            return a(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            d();
            a(null, 0, this.f14334f);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return a(null, 0, (int) j);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            b();
            ByteString.LeafByteString leafByteString = this.f14330b;
            if (leafByteString == null) {
                return -1;
            }
            int i = this.f14332d;
            this.f14332d = i + 1;
            return leafByteString.byteAt(i) & 255;
        }
    }
}
