package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.AbstractC2295a;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class TeamInQueue extends GeneratedMessageLite<TeamInQueue, Builder> implements TeamInQueueOrBuilder {
    public static final int CNTORADDR_FIELD_NUMBER = 1;
    private static final TeamInQueue DEFAULT_INSTANCE = new TeamInQueue();
    private static volatile A<TeamInQueue> PARSER;
    private String cntoraddr_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamInQueue$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamInQueue, Builder> implements TeamInQueueOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCntoraddr() {
            copyOnWrite();
            ((TeamInQueue) this.instance).clearCntoraddr();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamInQueueOrBuilder
        public String getCntoraddr() {
            return ((TeamInQueue) this.instance).getCntoraddr();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamInQueueOrBuilder
        public ByteString getCntoraddrBytes() {
            return ((TeamInQueue) this.instance).getCntoraddrBytes();
        }

        public Builder setCntoraddr(String str) {
            copyOnWrite();
            ((TeamInQueue) this.instance).setCntoraddr(str);
            return this;
        }

        public Builder setCntoraddrBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamInQueue) this.instance).setCntoraddrBytes(byteString);
            return this;
        }

        private Builder() {
            super(TeamInQueue.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamInQueue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCntoraddr() {
        this.cntoraddr_ = getDefaultInstance().getCntoraddr();
    }

    public static TeamInQueue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamInQueue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamInQueue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamInQueue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamInQueue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCntoraddr(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.cntoraddr_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCntoraddrBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.cntoraddr_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamInQueue();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                TeamInQueue teamInQueue = (TeamInQueue) obj2;
                this.cntoraddr_ = ((GeneratedMessageLite.i) obj).a(!this.cntoraddr_.isEmpty(), this.cntoraddr_, true ^ teamInQueue.cntoraddr_.isEmpty(), teamInQueue.cntoraddr_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 10) {
                                this.cntoraddr_ = c2301g.p();
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
                    synchronized (TeamInQueue.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamInQueueOrBuilder
    public String getCntoraddr() {
        return this.cntoraddr_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamInQueueOrBuilder
    public ByteString getCntoraddrBytes() {
        return ByteString.copyFromUtf8(this.cntoraddr_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.cntoraddr_.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, getCntoraddr());
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.cntoraddr_.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, getCntoraddr());
    }

    public static Builder newBuilder(TeamInQueue teamInQueue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamInQueue);
    }

    public static TeamInQueue parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamInQueue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamInQueue parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamInQueue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamInQueue parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamInQueue parseFrom(InputStream inputStream) throws IOException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamInQueue parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamInQueue parseFrom(C2301g c2301g) throws IOException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamInQueue parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamInQueue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
