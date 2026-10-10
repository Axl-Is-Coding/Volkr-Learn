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
public final class LocalTeamsRequest extends GeneratedMessageLite<LocalTeamsRequest, Builder> implements LocalTeamsRequestOrBuilder {
    private static final LocalTeamsRequest DEFAULT_INSTANCE = new LocalTeamsRequest();
    public static final int GAMETYPE_FIELD_NUMBER = 2;
    private static volatile A<LocalTeamsRequest> PARSER;
    private String gametype_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<LocalTeamsRequest, Builder> implements LocalTeamsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearGametype() {
            copyOnWrite();
            ((LocalTeamsRequest) this.instance).clearGametype();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsRequestOrBuilder
        public String getGametype() {
            return ((LocalTeamsRequest) this.instance).getGametype();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsRequestOrBuilder
        public ByteString getGametypeBytes() {
            return ((LocalTeamsRequest) this.instance).getGametypeBytes();
        }

        public Builder setGametype(String str) {
            copyOnWrite();
            ((LocalTeamsRequest) this.instance).setGametype(str);
            return this;
        }

        public Builder setGametypeBytes(ByteString byteString) {
            copyOnWrite();
            ((LocalTeamsRequest) this.instance).setGametypeBytes(byteString);
            return this;
        }

        private Builder() {
            super(LocalTeamsRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private LocalTeamsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGametype() {
        this.gametype_ = getDefaultInstance().getGametype();
    }

    public static LocalTeamsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static LocalTeamsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalTeamsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<LocalTeamsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new LocalTeamsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                LocalTeamsRequest localTeamsRequest = (LocalTeamsRequest) obj2;
                this.gametype_ = ((GeneratedMessageLite.i) obj).a(!this.gametype_.isEmpty(), this.gametype_, true ^ localTeamsRequest.gametype_.isEmpty(), localTeamsRequest.gametype_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 18) {
                                this.gametype_ = c2301g.p();
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
                    synchronized (LocalTeamsRequest.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsRequestOrBuilder
    public String getGametype() {
        return this.gametype_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsRequestOrBuilder
    public ByteString getGametypeBytes() {
        return ByteString.copyFromUtf8(this.gametype_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.gametype_.isEmpty() ? 0 : 0 + CodedOutputStream.a(2, getGametype());
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.gametype_.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, getGametype());
    }

    public static Builder newBuilder(LocalTeamsRequest localTeamsRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(localTeamsRequest);
    }

    public static LocalTeamsRequest parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static LocalTeamsRequest parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static LocalTeamsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LocalTeamsRequest parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static LocalTeamsRequest parseFrom(InputStream inputStream) throws IOException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalTeamsRequest parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static LocalTeamsRequest parseFrom(C2301g c2301g) throws IOException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static LocalTeamsRequest parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (LocalTeamsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
