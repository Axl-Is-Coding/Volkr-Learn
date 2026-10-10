package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class QueueStop extends GeneratedMessageLite<QueueStop, Builder> implements QueueStopOrBuilder {
    private static final QueueStop DEFAULT_INSTANCE = new QueueStop();
    private static volatile A<QueueStop> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 1;
    private int reason_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.QueueStop$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<QueueStop, Builder> implements QueueStopOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearReason() {
            copyOnWrite();
            ((QueueStop) this.instance).clearReason();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueStopOrBuilder
        public Reason getReason() {
            return ((QueueStop) this.instance).getReason();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueStopOrBuilder
        public int getReasonValue() {
            return ((QueueStop) this.instance).getReasonValue();
        }

        public Builder setReason(Reason reason) {
            copyOnWrite();
            ((QueueStop) this.instance).setReason(reason);
            return this;
        }

        public Builder setReasonValue(int i) {
            copyOnWrite();
            ((QueueStop) this.instance).setReasonValue(i);
            return this;
        }

        private Builder() {
            super(QueueStop.DEFAULT_INSTANCE);
        }
    }

    public enum Reason implements r.c {
        Manually(0),
        Inactive(1),
        UNRECOGNIZED(-1);

        public static final int Inactive_VALUE = 1;
        public static final int Manually_VALUE = 0;
        private static final r.d<Reason> internalValueMap = new r.d<Reason>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.connector.QueueStop.Reason.1
            public Reason findValueByNumber(int i) {
                return Reason.forNumber(i);
            }
        };
        private final int value;

        Reason(int i) {
            this.value = i;
        }

        public static Reason forNumber(int i) {
            if (i == 0) {
                return Manually;
            }
            if (i != 1) {
                return null;
            }
            return Inactive;
        }

        public static r.d<Reason> internalGetValueMap() {
            return internalValueMap;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Reason valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private QueueStop() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = 0;
    }

    public static QueueStop getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static QueueStop parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (QueueStop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static QueueStop parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<QueueStop> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(Reason reason) {
        if (reason == null) {
            throw new NullPointerException();
        }
        this.reason_ = reason.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonValue(int i) {
        this.reason_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new QueueStop();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                QueueStop queueStop = (QueueStop) obj2;
                this.reason_ = ((GeneratedMessageLite.i) obj).a(this.reason_ != 0, this.reason_, queueStop.reason_ != 0, queueStop.reason_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 8) {
                                this.reason_ = c2301g.e();
                            } else if (!c2301g.e(iQ)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (QueueStop.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.b(DEFAULT_INSTANCE);
                        }
                        break;
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueStopOrBuilder
    public Reason getReason() {
        Reason reasonForNumber = Reason.forNumber(this.reason_);
        return reasonForNumber == null ? Reason.UNRECOGNIZED : reasonForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueStopOrBuilder
    public int getReasonValue() {
        return this.reason_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.reason_ != Reason.Manually.getNumber() ? 0 + CodedOutputStream.a(1, this.reason_) : 0;
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.reason_ != Reason.Manually.getNumber()) {
            codedOutputStream.c(1, this.reason_);
        }
    }

    public static Builder newBuilder(QueueStop queueStop) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(queueStop);
    }

    public static QueueStop parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (QueueStop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static QueueStop parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static QueueStop parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static QueueStop parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static QueueStop parseFrom(InputStream inputStream) throws IOException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static QueueStop parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static QueueStop parseFrom(C2301g c2301g) throws IOException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static QueueStop parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (QueueStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
