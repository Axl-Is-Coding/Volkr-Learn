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
public final class RemoveRequest extends GeneratedMessageLite<RemoveRequest, Builder> implements RemoveRequestOrBuilder {
    public static final int CAPTAINID_FIELD_NUMBER = 2;
    private static final RemoveRequest DEFAULT_INSTANCE = new RemoveRequest();
    public static final int GAMETYPE_FIELD_NUMBER = 1;
    private static volatile A<RemoveRequest> PARSER = null;
    public static final int USERID_FIELD_NUMBER = 3;
    private long captainid_;
    private String gametype_ = "";
    private long userid_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<RemoveRequest, Builder> implements RemoveRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCaptainid() {
            copyOnWrite();
            ((RemoveRequest) this.instance).clearCaptainid();
            return this;
        }

        public Builder clearGametype() {
            copyOnWrite();
            ((RemoveRequest) this.instance).clearGametype();
            return this;
        }

        public Builder clearUserid() {
            copyOnWrite();
            ((RemoveRequest) this.instance).clearUserid();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
        public long getCaptainid() {
            return ((RemoveRequest) this.instance).getCaptainid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
        public String getGametype() {
            return ((RemoveRequest) this.instance).getGametype();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
        public ByteString getGametypeBytes() {
            return ((RemoveRequest) this.instance).getGametypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
        public long getUserid() {
            return ((RemoveRequest) this.instance).getUserid();
        }

        public Builder setCaptainid(long j) {
            copyOnWrite();
            ((RemoveRequest) this.instance).setCaptainid(j);
            return this;
        }

        public Builder setGametype(String str) {
            copyOnWrite();
            ((RemoveRequest) this.instance).setGametype(str);
            return this;
        }

        public Builder setGametypeBytes(ByteString byteString) {
            copyOnWrite();
            ((RemoveRequest) this.instance).setGametypeBytes(byteString);
            return this;
        }

        public Builder setUserid(long j) {
            copyOnWrite();
            ((RemoveRequest) this.instance).setUserid(j);
            return this;
        }

        private Builder() {
            super(RemoveRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private RemoveRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainid() {
        this.captainid_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGametype() {
        this.gametype_ = getDefaultInstance().getGametype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserid() {
        this.userid_ = 0L;
    }

    public static RemoveRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RemoveRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RemoveRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoveRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<RemoveRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainid(long j) {
        this.captainid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGametype(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.gametype_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGametypeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.gametype_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserid(long j) {
        this.userid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoveRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                RemoveRequest removeRequest = (RemoveRequest) obj2;
                this.gametype_ = iVar.a(!this.gametype_.isEmpty(), this.gametype_, !removeRequest.gametype_.isEmpty(), removeRequest.gametype_);
                this.captainid_ = iVar.a(this.captainid_ != 0, this.captainid_, removeRequest.captainid_ != 0, removeRequest.captainid_);
                this.userid_ = iVar.a(this.userid_ != 0, this.userid_, removeRequest.userid_ != 0, removeRequest.userid_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 10) {
                                this.gametype_ = c2301g.p();
                            } else if (iQ == 16) {
                                this.captainid_ = c2301g.r();
                            } else if (iQ == 24) {
                                this.userid_ = c2301g.r();
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
                    synchronized (RemoveRequest.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
    public long getCaptainid() {
        return this.captainid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
    public String getGametype() {
        return this.gametype_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
    public ByteString getGametypeBytes() {
        return ByteString.copyFromUtf8(this.gametype_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.gametype_.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, getGametype());
        long j = this.captainid_;
        if (j != 0) {
            iA += CodedOutputStream.b(2, j);
        }
        long j2 = this.userid_;
        if (j2 != 0) {
            iA += CodedOutputStream.b(3, j2);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveRequestOrBuilder
    public long getUserid() {
        return this.userid_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.gametype_.isEmpty()) {
            codedOutputStream.b(1, getGametype());
        }
        long j = this.captainid_;
        if (j != 0) {
            codedOutputStream.d(2, j);
        }
        long j2 = this.userid_;
        if (j2 != 0) {
            codedOutputStream.d(3, j2);
        }
    }

    public static Builder newBuilder(RemoveRequest removeRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(removeRequest);
    }

    public static RemoveRequest parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemoveRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemoveRequest parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static RemoveRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RemoveRequest parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static RemoveRequest parseFrom(InputStream inputStream) throws IOException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoveRequest parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemoveRequest parseFrom(C2301g c2301g) throws IOException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static RemoveRequest parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (RemoveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
