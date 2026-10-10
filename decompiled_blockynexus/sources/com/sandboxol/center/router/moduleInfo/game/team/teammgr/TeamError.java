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
public final class TeamError extends GeneratedMessageLite<TeamError, Builder> implements TeamErrorOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final TeamError DEFAULT_INSTANCE = new TeamError();
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile A<TeamError> PARSER;
    private int code_;
    private String message_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamError$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamError, Builder> implements TeamErrorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCode() {
            copyOnWrite();
            ((TeamError) this.instance).clearCode();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((TeamError) this.instance).clearMessage();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamErrorOrBuilder
        public int getCode() {
            return ((TeamError) this.instance).getCode();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamErrorOrBuilder
        public String getMessage() {
            return ((TeamError) this.instance).getMessage();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamErrorOrBuilder
        public ByteString getMessageBytes() {
            return ((TeamError) this.instance).getMessageBytes();
        }

        public Builder setCode(int i) {
            copyOnWrite();
            ((TeamError) this.instance).setCode(i);
            return this;
        }

        public Builder setMessage(String str) {
            copyOnWrite();
            ((TeamError) this.instance).setMessage(str);
            return this;
        }

        public Builder setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamError) this.instance).setMessageBytes(byteString);
            return this;
        }

        private Builder() {
            super(TeamError.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    public static TeamError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamError parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamError parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamError> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(int i) {
        this.code_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamError();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamError teamError = (TeamError) obj2;
                this.code_ = iVar.a(this.code_ != 0, this.code_, teamError.code_ != 0, teamError.code_);
                this.message_ = iVar.a(!this.message_.isEmpty(), this.message_, !teamError.message_.isEmpty(), teamError.message_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 8) {
                                this.code_ = c2301g.h();
                            } else if (iQ == 18) {
                                this.message_ = c2301g.p();
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
                    synchronized (TeamError.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamErrorOrBuilder
    public int getCode() {
        return this.code_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamErrorOrBuilder
    public String getMessage() {
        return this.message_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamErrorOrBuilder
    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.code_;
        int iB = i2 != 0 ? 0 + CodedOutputStream.b(1, i2) : 0;
        if (!this.message_.isEmpty()) {
            iB += CodedOutputStream.a(2, getMessage());
        }
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.code_;
        if (i != 0) {
            codedOutputStream.d(1, i);
        }
        if (this.message_.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, getMessage());
    }

    public static Builder newBuilder(TeamError teamError) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamError);
    }

    public static TeamError parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamError parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamError parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamError parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamError parseFrom(InputStream inputStream) throws IOException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamError parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamError parseFrom(C2301g c2301g) throws IOException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamError parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
