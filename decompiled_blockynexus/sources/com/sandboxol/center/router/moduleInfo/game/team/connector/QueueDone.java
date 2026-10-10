package com.sandboxol.center.router.moduleInfo.game.team.connector;

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
public final class QueueDone extends GeneratedMessageLite<QueueDone, Builder> implements QueueDoneOrBuilder {
    private static final QueueDone DEFAULT_INSTANCE = new QueueDone();
    public static final int GAMEADDR_FIELD_NUMBER = 1;
    private static volatile A<QueueDone> PARSER = null;
    public static final int USERNAME_FIELD_NUMBER = 2;
    public static final int USERTOKEN_FIELD_NUMBER = 3;
    private String gameaddr_ = "";
    private String username_ = "";
    private String usertoken_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDone$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<QueueDone, Builder> implements QueueDoneOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearGameaddr() {
            copyOnWrite();
            ((QueueDone) this.instance).clearGameaddr();
            return this;
        }

        public Builder clearUsername() {
            copyOnWrite();
            ((QueueDone) this.instance).clearUsername();
            return this;
        }

        public Builder clearUsertoken() {
            copyOnWrite();
            ((QueueDone) this.instance).clearUsertoken();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
        public String getGameaddr() {
            return ((QueueDone) this.instance).getGameaddr();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
        public ByteString getGameaddrBytes() {
            return ((QueueDone) this.instance).getGameaddrBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
        public String getUsername() {
            return ((QueueDone) this.instance).getUsername();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
        public ByteString getUsernameBytes() {
            return ((QueueDone) this.instance).getUsernameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
        public String getUsertoken() {
            return ((QueueDone) this.instance).getUsertoken();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
        public ByteString getUsertokenBytes() {
            return ((QueueDone) this.instance).getUsertokenBytes();
        }

        public Builder setGameaddr(String str) {
            copyOnWrite();
            ((QueueDone) this.instance).setGameaddr(str);
            return this;
        }

        public Builder setGameaddrBytes(ByteString byteString) {
            copyOnWrite();
            ((QueueDone) this.instance).setGameaddrBytes(byteString);
            return this;
        }

        public Builder setUsername(String str) {
            copyOnWrite();
            ((QueueDone) this.instance).setUsername(str);
            return this;
        }

        public Builder setUsernameBytes(ByteString byteString) {
            copyOnWrite();
            ((QueueDone) this.instance).setUsernameBytes(byteString);
            return this;
        }

        public Builder setUsertoken(String str) {
            copyOnWrite();
            ((QueueDone) this.instance).setUsertoken(str);
            return this;
        }

        public Builder setUsertokenBytes(ByteString byteString) {
            copyOnWrite();
            ((QueueDone) this.instance).setUsertokenBytes(byteString);
            return this;
        }

        private Builder() {
            super(QueueDone.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private QueueDone() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGameaddr() {
        this.gameaddr_ = getDefaultInstance().getGameaddr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsername() {
        this.username_ = getDefaultInstance().getUsername();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsertoken() {
        this.usertoken_ = getDefaultInstance().getUsertoken();
    }

    public static QueueDone getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static QueueDone parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (QueueDone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static QueueDone parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<QueueDone> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGameaddr(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.gameaddr_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGameaddrBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.gameaddr_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsername(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.username_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsernameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.username_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsertoken(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.usertoken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsertokenBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.usertoken_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new QueueDone();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                QueueDone queueDone = (QueueDone) obj2;
                this.gameaddr_ = iVar.a(!this.gameaddr_.isEmpty(), this.gameaddr_, !queueDone.gameaddr_.isEmpty(), queueDone.gameaddr_);
                this.username_ = iVar.a(!this.username_.isEmpty(), this.username_, !queueDone.username_.isEmpty(), queueDone.username_);
                this.usertoken_ = iVar.a(!this.usertoken_.isEmpty(), this.usertoken_, true ^ queueDone.usertoken_.isEmpty(), queueDone.usertoken_);
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
                                this.gameaddr_ = c2301g.p();
                            } else if (iQ == 18) {
                                this.username_ = c2301g.p();
                            } else if (iQ == 26) {
                                this.usertoken_ = c2301g.p();
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
                    synchronized (QueueDone.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
    public String getGameaddr() {
        return this.gameaddr_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
    public ByteString getGameaddrBytes() {
        return ByteString.copyFromUtf8(this.gameaddr_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.gameaddr_.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, getGameaddr());
        if (!this.username_.isEmpty()) {
            iA += CodedOutputStream.a(2, getUsername());
        }
        if (!this.usertoken_.isEmpty()) {
            iA += CodedOutputStream.a(3, getUsertoken());
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
    public String getUsername() {
        return this.username_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
    public ByteString getUsernameBytes() {
        return ByteString.copyFromUtf8(this.username_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
    public String getUsertoken() {
        return this.usertoken_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDoneOrBuilder
    public ByteString getUsertokenBytes() {
        return ByteString.copyFromUtf8(this.usertoken_);
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.gameaddr_.isEmpty()) {
            codedOutputStream.b(1, getGameaddr());
        }
        if (!this.username_.isEmpty()) {
            codedOutputStream.b(2, getUsername());
        }
        if (this.usertoken_.isEmpty()) {
            return;
        }
        codedOutputStream.b(3, getUsertoken());
    }

    public static Builder newBuilder(QueueDone queueDone) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(queueDone);
    }

    public static QueueDone parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (QueueDone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static QueueDone parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static QueueDone parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static QueueDone parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static QueueDone parseFrom(InputStream inputStream) throws IOException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static QueueDone parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static QueueDone parseFrom(C2301g c2301g) throws IOException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static QueueDone parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (QueueDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
