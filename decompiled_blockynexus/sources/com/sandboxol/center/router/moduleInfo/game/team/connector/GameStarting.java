package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class GameStarting extends GeneratedMessageLite<GameStarting, Builder> implements GameStartingOrBuilder {
    private static final GameStarting DEFAULT_INSTANCE = new GameStarting();
    public static final int GAMESTATUS_FIELD_NUMBER = 1;
    private static volatile A<GameStarting> PARSER;
    private int gamestatus_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.GameStarting$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<GameStarting, Builder> implements GameStartingOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearGamestatus() {
            copyOnWrite();
            ((GameStarting) this.instance).clearGamestatus();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.GameStartingOrBuilder
        public int getGamestatus() {
            return ((GameStarting) this.instance).getGamestatus();
        }

        public Builder setGamestatus(int i) {
            copyOnWrite();
            ((GameStarting) this.instance).setGamestatus(i);
            return this;
        }

        private Builder() {
            super(GameStarting.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private GameStarting() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGamestatus() {
        this.gamestatus_ = 0;
    }

    public static GameStarting getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static GameStarting parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameStarting) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GameStarting parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<GameStarting> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGamestatus(int i) {
        this.gamestatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GameStarting();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GameStarting gameStarting = (GameStarting) obj2;
                this.gamestatus_ = ((GeneratedMessageLite.i) obj).a(this.gamestatus_ != 0, this.gamestatus_, gameStarting.gamestatus_ != 0, gameStarting.gamestatus_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 8) {
                                this.gamestatus_ = c2301g.h();
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
                    synchronized (GameStarting.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.GameStartingOrBuilder
    public int getGamestatus() {
        return this.gamestatus_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.gamestatus_;
        int iB = i2 != 0 ? 0 + CodedOutputStream.b(1, i2) : 0;
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.gamestatus_;
        if (i != 0) {
            codedOutputStream.d(1, i);
        }
    }

    public static Builder newBuilder(GameStarting gameStarting) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(gameStarting);
    }

    public static GameStarting parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (GameStarting) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static GameStarting parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static GameStarting parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GameStarting parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static GameStarting parseFrom(InputStream inputStream) throws IOException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GameStarting parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static GameStarting parseFrom(C2301g c2301g) throws IOException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static GameStarting parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (GameStarting) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
