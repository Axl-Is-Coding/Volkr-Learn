package com.google.protobuf;

import com.google.protobuf.AbstractC2295a;
import com.google.protobuf.AbstractC2295a.AbstractC0138a;
import com.google.protobuf.ByteString;
import com.google.protobuf.x;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: com.google.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMessageLite.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2295a<MessageType extends AbstractC2295a<MessageType, BuilderType>, BuilderType extends AbstractC0138a<MessageType, BuilderType>> implements x {
    protected int memoizedHashCode = 0;

    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        AbstractC0138a.addAll(iterable, collection);
    }

    protected static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (!byteString.isValidUtf8()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    @Override // com.google.protobuf.x
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream codedOutputStreamA = CodedOutputStream.a(bArr);
            writeTo(codedOutputStreamA);
            codedOutputStreamA.c();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e2);
        }
    }

    public ByteString toByteString() {
        try {
            ByteString.d dVarNewCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(dVarNewCodedBuilder.b());
            return dVarNewCodedBuilder.a();
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e2);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream codedOutputStreamA = CodedOutputStream.a(outputStream, CodedOutputStream.d(CodedOutputStream.e(serializedSize) + serializedSize));
        codedOutputStreamA.h(serializedSize);
        writeTo(codedOutputStreamA);
        codedOutputStreamA.d();
    }

    @Override // com.google.protobuf.x
    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream codedOutputStreamA = CodedOutputStream.a(outputStream, CodedOutputStream.d(getSerializedSize()));
        writeTo(codedOutputStreamA);
        codedOutputStreamA.d();
    }

    /* JADX INFO: renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractMessageLite.java */
    public static abstract class AbstractC0138a<MessageType extends AbstractC2295a<MessageType, BuilderType>, BuilderType extends AbstractC0138a<MessageType, BuilderType>> implements x.a {
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            if (iterable == null) {
                throw new NullPointerException();
            }
            if (iterable instanceof v) {
                checkForNullValues(((v) iterable).g());
                collection.addAll((Collection) iterable);
            } else {
                if (iterable instanceof Collection) {
                    checkForNullValues(iterable);
                    collection.addAll((Collection) iterable);
                    return;
                }
                for (T t : iterable) {
                    if (t == null) {
                        throw new NullPointerException();
                    }
                    collection.add(t);
                }
            }
        }

        private static void checkForNullValues(Iterable<?> iterable) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new NullPointerException();
                }
            }
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException newUninitializedMessageException(x xVar) {
            return new UninitializedMessageException(xVar);
        }

        /* JADX INFO: renamed from: clone */
        public abstract BuilderType mo66clone();

        /* JADX INFO: renamed from: clone */
        public abstract /* bridge */ /* synthetic */ x.a mo67clone();

        /* JADX INFO: renamed from: clone */
        public abstract /* bridge */ /* synthetic */ Object mo67clone() throws CloneNotSupportedException;

        protected abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
            int i = inputStream.read();
            if (i == -1) {
                return false;
            }
            m73mergeFrom((InputStream) new C0139a(inputStream, C2301g.a(i, inputStream)), c2306l);
            return true;
        }

        /* JADX INFO: renamed from: mergeFrom */
        public abstract BuilderType mo68mergeFrom(C2301g c2301g, C2306l c2306l) throws IOException;

        /* JADX INFO: renamed from: mergeFrom */
        public abstract /* bridge */ /* synthetic */ x.a mo68mergeFrom(C2301g c2301g, C2306l c2306l) throws IOException;

        /* JADX INFO: renamed from: com.google.protobuf.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractMessageLite.java */
        static final class C0139a extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f14340a;

            C0139a(InputStream inputStream, int i) {
                super(inputStream);
                this.f14340a = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f14340a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f14340a <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.f14340a--;
                }
                return i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long jSkip = super.skip(Math.min(j, this.f14340a));
                if (jSkip >= 0) {
                    this.f14340a = (int) (((long) this.f14340a) - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.f14340a;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.f14340a -= i4;
                }
                return i4;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, C2306l.a());
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m71mergeFrom(C2301g c2301g) throws IOException {
            return (BuilderType) mo68mergeFrom(c2301g, C2306l.a());
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m69mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                C2301g c2301gNewCodedInput = byteString.newCodedInput();
                m71mergeFrom(c2301gNewCodedInput);
                c2301gNewCodedInput.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e3);
            }
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m70mergeFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
            try {
                C2301g c2301gNewCodedInput = byteString.newCodedInput();
                mo68mergeFrom(c2301gNewCodedInput, c2306l);
                c2301gNewCodedInput.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e3);
            }
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m74mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BuilderType) m75mergeFrom(bArr, 0, bArr.length);
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m75mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                C2301g c2301gA = C2301g.a(bArr, i, i2);
                m71mergeFrom(c2301gA);
                c2301gA.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e3);
            }
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m77mergeFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
            return (BuilderType) m76mergeFrom(bArr, 0, bArr.length, c2306l);
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m76mergeFrom(byte[] bArr, int i, int i2, C2306l c2306l) throws InvalidProtocolBufferException {
            try {
                C2301g c2301gA = C2301g.a(bArr, i, i2);
                mo68mergeFrom(c2301gA, c2306l);
                c2301gA.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e3);
            }
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m72mergeFrom(InputStream inputStream) throws IOException {
            C2301g c2301gA = C2301g.a(inputStream);
            m71mergeFrom(c2301gA);
            c2301gA.a(0);
            return this;
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType m73mergeFrom(InputStream inputStream, C2306l c2306l) throws IOException {
            C2301g c2301gA = C2301g.a(inputStream);
            mo68mergeFrom(c2301gA, c2306l);
            c2301gA.a(0);
            return this;
        }

        @Override // com.google.protobuf.x.a
        public BuilderType mergeFrom(x xVar) {
            if (getDefaultInstanceForType().getClass().isInstance(xVar)) {
                return (BuilderType) internalMergeFrom((AbstractC2295a) xVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }
}
