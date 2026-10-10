package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.connector.GameStarting;
import com.sandboxol.center.router.moduleInfo.game.team.connector.QueueDone;
import com.sandboxol.center.router.moduleInfo.game.team.connector.QueueGoing;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class QueueResponse extends GeneratedMessageLite<QueueResponse, Builder> implements QueueResponseOrBuilder {
    private static final QueueResponse DEFAULT_INSTANCE = new QueueResponse();
    public static final int DONE_FIELD_NUMBER = 2;
    public static final int GOING_FIELD_NUMBER = 1;
    private static volatile A<QueueResponse> PARSER = null;
    public static final int STARTING_FIELD_NUMBER = 3;
    private int stateCase_ = 0;
    private Object state_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$QueueResponse$StateCase;

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
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$QueueResponse$StateCase = new int[StateCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$QueueResponse$StateCase[StateCase.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$QueueResponse$StateCase[StateCase.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$QueueResponse$StateCase[StateCase.STARTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$QueueResponse$StateCase[StateCase.STATE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<QueueResponse, Builder> implements QueueResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDone() {
            copyOnWrite();
            ((QueueResponse) this.instance).clearDone();
            return this;
        }

        public Builder clearGoing() {
            copyOnWrite();
            ((QueueResponse) this.instance).clearGoing();
            return this;
        }

        public Builder clearStarting() {
            copyOnWrite();
            ((QueueResponse) this.instance).clearStarting();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((QueueResponse) this.instance).clearState();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
        public QueueDone getDone() {
            return ((QueueResponse) this.instance).getDone();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
        public QueueGoing getGoing() {
            return ((QueueResponse) this.instance).getGoing();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
        public GameStarting getStarting() {
            return ((QueueResponse) this.instance).getStarting();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
        public StateCase getStateCase() {
            return ((QueueResponse) this.instance).getStateCase();
        }

        public Builder mergeDone(QueueDone queueDone) {
            copyOnWrite();
            ((QueueResponse) this.instance).mergeDone(queueDone);
            return this;
        }

        public Builder mergeGoing(QueueGoing queueGoing) {
            copyOnWrite();
            ((QueueResponse) this.instance).mergeGoing(queueGoing);
            return this;
        }

        public Builder mergeStarting(GameStarting gameStarting) {
            copyOnWrite();
            ((QueueResponse) this.instance).mergeStarting(gameStarting);
            return this;
        }

        public Builder setDone(QueueDone queueDone) {
            copyOnWrite();
            ((QueueResponse) this.instance).setDone(queueDone);
            return this;
        }

        public Builder setGoing(QueueGoing queueGoing) {
            copyOnWrite();
            ((QueueResponse) this.instance).setGoing(queueGoing);
            return this;
        }

        public Builder setStarting(GameStarting gameStarting) {
            copyOnWrite();
            ((QueueResponse) this.instance).setStarting(gameStarting);
            return this;
        }

        private Builder() {
            super(QueueResponse.DEFAULT_INSTANCE);
        }

        public Builder setDone(QueueDone.Builder builder) {
            copyOnWrite();
            ((QueueResponse) this.instance).setDone(builder);
            return this;
        }

        public Builder setGoing(QueueGoing.Builder builder) {
            copyOnWrite();
            ((QueueResponse) this.instance).setGoing(builder);
            return this;
        }

        public Builder setStarting(GameStarting.Builder builder) {
            copyOnWrite();
            ((QueueResponse) this.instance).setStarting(builder);
            return this;
        }
    }

    public enum StateCase implements r.c {
        GOING(1),
        DONE(2),
        STARTING(3),
        STATE_NOT_SET(0);

        private final int value;

        StateCase(int i) {
            this.value = i;
        }

        public static StateCase forNumber(int i) {
            if (i == 0) {
                return STATE_NOT_SET;
            }
            if (i == 1) {
                return GOING;
            }
            if (i == 2) {
                return DONE;
            }
            if (i != 3) {
                return null;
            }
            return STARTING;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static StateCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private QueueResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDone() {
        if (this.stateCase_ == 2) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGoing() {
        if (this.stateCase_ == 1) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStarting() {
        if (this.stateCase_ == 3) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.stateCase_ = 0;
        this.state_ = null;
    }

    public static QueueResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDone(QueueDone queueDone) {
        if (this.stateCase_ != 2 || this.state_ == QueueDone.getDefaultInstance()) {
            this.state_ = queueDone;
        } else {
            this.state_ = QueueDone.newBuilder((QueueDone) this.state_).mergeFrom(queueDone).m64buildPartial();
        }
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGoing(QueueGoing queueGoing) {
        if (this.stateCase_ != 1 || this.state_ == QueueGoing.getDefaultInstance()) {
            this.state_ = queueGoing;
        } else {
            this.state_ = QueueGoing.newBuilder((QueueGoing) this.state_).mergeFrom(queueGoing).m64buildPartial();
        }
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStarting(GameStarting gameStarting) {
        if (this.stateCase_ != 3 || this.state_ == GameStarting.getDefaultInstance()) {
            this.state_ = gameStarting;
        } else {
            this.state_ = GameStarting.newBuilder((GameStarting) this.state_).mergeFrom(gameStarting).m64buildPartial();
        }
        this.stateCase_ = 3;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static QueueResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (QueueResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static QueueResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<QueueResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(QueueDone queueDone) {
        if (queueDone == null) {
            throw new NullPointerException();
        }
        this.state_ = queueDone;
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoing(QueueGoing queueGoing) {
        if (queueGoing == null) {
            throw new NullPointerException();
        }
        this.state_ = queueGoing;
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStarting(GameStarting gameStarting) {
        if (gameStarting == null) {
            throw new NullPointerException();
        }
        this.state_ = gameStarting;
        this.stateCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new QueueResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                QueueResponse queueResponse = (QueueResponse) obj2;
                int i2 = AnonymousClass1.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$QueueResponse$StateCase[queueResponse.getStateCase().ordinal()];
                if (i2 == 1) {
                    this.state_ = iVar.b(this.stateCase_ == 1, this.state_, queueResponse.state_);
                } else if (i2 == 2) {
                    this.state_ = iVar.b(this.stateCase_ == 2, this.state_, queueResponse.state_);
                } else if (i2 == 3) {
                    this.state_ = iVar.b(this.stateCase_ == 3, this.state_, queueResponse.state_);
                } else if (i2 == 4) {
                    iVar.a(this.stateCase_ != 0);
                }
                if (iVar == GeneratedMessageLite.h.f14297a && (i = queueResponse.stateCase_) != 0) {
                    this.stateCase_ = i;
                }
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                C2306l c2306l = (C2306l) obj2;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 10) {
                                QueueGoing.Builder builder = this.stateCase_ == 1 ? ((QueueGoing) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(QueueGoing.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom((QueueGoing) this.state_);
                                    this.state_ = builder.m64buildPartial();
                                }
                                this.stateCase_ = 1;
                            } else if (iQ == 18) {
                                QueueDone.Builder builder2 = this.stateCase_ == 2 ? ((QueueDone) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(QueueDone.parser(), c2306l);
                                if (builder2 != null) {
                                    builder2.mergeFrom((QueueDone) this.state_);
                                    this.state_ = builder2.m64buildPartial();
                                }
                                this.stateCase_ = 2;
                            } else if (iQ == 26) {
                                GameStarting.Builder builder3 = this.stateCase_ == 3 ? ((GameStarting) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(GameStarting.parser(), c2306l);
                                if (builder3 != null) {
                                    builder3.mergeFrom((GameStarting) this.state_);
                                    this.state_ = builder3.m64buildPartial();
                                }
                                this.stateCase_ = 3;
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
                    synchronized (QueueResponse.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
    public QueueDone getDone() {
        return this.stateCase_ == 2 ? (QueueDone) this.state_ : QueueDone.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
    public QueueGoing getGoing() {
        return this.stateCase_ == 1 ? (QueueGoing) this.state_ : QueueGoing.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.stateCase_ == 1 ? 0 + CodedOutputStream.a(1, (QueueGoing) this.state_) : 0;
        if (this.stateCase_ == 2) {
            iA += CodedOutputStream.a(2, (QueueDone) this.state_);
        }
        if (this.stateCase_ == 3) {
            iA += CodedOutputStream.a(3, (GameStarting) this.state_);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
    public GameStarting getStarting() {
        return this.stateCase_ == 3 ? (GameStarting) this.state_ : GameStarting.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponseOrBuilder
    public StateCase getStateCase() {
        return StateCase.forNumber(this.stateCase_);
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.stateCase_ == 1) {
            codedOutputStream.b(1, (QueueGoing) this.state_);
        }
        if (this.stateCase_ == 2) {
            codedOutputStream.b(2, (QueueDone) this.state_);
        }
        if (this.stateCase_ == 3) {
            codedOutputStream.b(3, (GameStarting) this.state_);
        }
    }

    public static Builder newBuilder(QueueResponse queueResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(queueResponse);
    }

    public static QueueResponse parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (QueueResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static QueueResponse parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static QueueResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static QueueResponse parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(QueueDone.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoing(QueueGoing.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStarting(GameStarting.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 3;
    }

    public static QueueResponse parseFrom(InputStream inputStream) throws IOException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static QueueResponse parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static QueueResponse parseFrom(C2301g c2301g) throws IOException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static QueueResponse parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (QueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
