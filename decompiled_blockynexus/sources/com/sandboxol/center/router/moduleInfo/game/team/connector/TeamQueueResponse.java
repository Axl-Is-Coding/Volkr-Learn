package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamGameStarting;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueDone;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueGoing;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class TeamQueueResponse extends GeneratedMessageLite<TeamQueueResponse, Builder> implements TeamQueueResponseOrBuilder {
    private static final TeamQueueResponse DEFAULT_INSTANCE = new TeamQueueResponse();
    public static final int DONE_FIELD_NUMBER = 2;
    public static final int GOING_FIELD_NUMBER = 1;
    private static volatile A<TeamQueueResponse> PARSER = null;
    public static final int STARTING_FIELD_NUMBER = 3;
    private int stateCase_ = 0;
    private Object state_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueResponse$StateCase;

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
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueResponse$StateCase = new int[StateCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueResponse$StateCase[StateCase.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueResponse$StateCase[StateCase.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueResponse$StateCase[StateCase.STARTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueResponse$StateCase[StateCase.STATE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<TeamQueueResponse, Builder> implements TeamQueueResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDone() {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).clearDone();
            return this;
        }

        public Builder clearGoing() {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).clearGoing();
            return this;
        }

        public Builder clearStarting() {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).clearStarting();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).clearState();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
        public TeamQueueDone getDone() {
            return ((TeamQueueResponse) this.instance).getDone();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
        public TeamQueueGoing getGoing() {
            return ((TeamQueueResponse) this.instance).getGoing();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
        public TeamGameStarting getStarting() {
            return ((TeamQueueResponse) this.instance).getStarting();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
        public StateCase getStateCase() {
            return ((TeamQueueResponse) this.instance).getStateCase();
        }

        public Builder mergeDone(TeamQueueDone teamQueueDone) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).mergeDone(teamQueueDone);
            return this;
        }

        public Builder mergeGoing(TeamQueueGoing teamQueueGoing) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).mergeGoing(teamQueueGoing);
            return this;
        }

        public Builder mergeStarting(TeamGameStarting teamGameStarting) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).mergeStarting(teamGameStarting);
            return this;
        }

        public Builder setDone(TeamQueueDone teamQueueDone) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).setDone(teamQueueDone);
            return this;
        }

        public Builder setGoing(TeamQueueGoing teamQueueGoing) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).setGoing(teamQueueGoing);
            return this;
        }

        public Builder setStarting(TeamGameStarting teamGameStarting) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).setStarting(teamGameStarting);
            return this;
        }

        private Builder() {
            super(TeamQueueResponse.DEFAULT_INSTANCE);
        }

        public Builder setDone(TeamQueueDone.Builder builder) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).setDone(builder);
            return this;
        }

        public Builder setGoing(TeamQueueGoing.Builder builder) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).setGoing(builder);
            return this;
        }

        public Builder setStarting(TeamGameStarting.Builder builder) {
            copyOnWrite();
            ((TeamQueueResponse) this.instance).setStarting(builder);
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

    private TeamQueueResponse() {
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

    public static TeamQueueResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDone(TeamQueueDone teamQueueDone) {
        if (this.stateCase_ != 2 || this.state_ == TeamQueueDone.getDefaultInstance()) {
            this.state_ = teamQueueDone;
        } else {
            this.state_ = TeamQueueDone.newBuilder((TeamQueueDone) this.state_).mergeFrom(teamQueueDone).m64buildPartial();
        }
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGoing(TeamQueueGoing teamQueueGoing) {
        if (this.stateCase_ != 1 || this.state_ == TeamQueueGoing.getDefaultInstance()) {
            this.state_ = teamQueueGoing;
        } else {
            this.state_ = TeamQueueGoing.newBuilder((TeamQueueGoing) this.state_).mergeFrom(teamQueueGoing).m64buildPartial();
        }
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStarting(TeamGameStarting teamGameStarting) {
        if (this.stateCase_ != 3 || this.state_ == TeamGameStarting.getDefaultInstance()) {
            this.state_ = teamGameStarting;
        } else {
            this.state_ = TeamGameStarting.newBuilder((TeamGameStarting) this.state_).mergeFrom(teamGameStarting).m64buildPartial();
        }
        this.stateCase_ = 3;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamQueueResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamQueueResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamQueueResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(TeamQueueDone teamQueueDone) {
        if (teamQueueDone == null) {
            throw new NullPointerException();
        }
        this.state_ = teamQueueDone;
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoing(TeamQueueGoing teamQueueGoing) {
        if (teamQueueGoing == null) {
            throw new NullPointerException();
        }
        this.state_ = teamQueueGoing;
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStarting(TeamGameStarting teamGameStarting) {
        if (teamGameStarting == null) {
            throw new NullPointerException();
        }
        this.state_ = teamGameStarting;
        this.stateCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamQueueResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamQueueResponse teamQueueResponse = (TeamQueueResponse) obj2;
                int i2 = AnonymousClass1.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueResponse$StateCase[teamQueueResponse.getStateCase().ordinal()];
                if (i2 == 1) {
                    this.state_ = iVar.b(this.stateCase_ == 1, this.state_, teamQueueResponse.state_);
                } else if (i2 == 2) {
                    this.state_ = iVar.b(this.stateCase_ == 2, this.state_, teamQueueResponse.state_);
                } else if (i2 == 3) {
                    this.state_ = iVar.b(this.stateCase_ == 3, this.state_, teamQueueResponse.state_);
                } else if (i2 == 4) {
                    iVar.a(this.stateCase_ != 0);
                }
                if (iVar == GeneratedMessageLite.h.f14297a && (i = teamQueueResponse.stateCase_) != 0) {
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
                                TeamQueueGoing.Builder builder = this.stateCase_ == 1 ? ((TeamQueueGoing) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(TeamQueueGoing.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom((TeamQueueGoing) this.state_);
                                    this.state_ = builder.m64buildPartial();
                                }
                                this.stateCase_ = 1;
                            } else if (iQ == 18) {
                                TeamQueueDone.Builder builder2 = this.stateCase_ == 2 ? ((TeamQueueDone) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(TeamQueueDone.parser(), c2306l);
                                if (builder2 != null) {
                                    builder2.mergeFrom((TeamQueueDone) this.state_);
                                    this.state_ = builder2.m64buildPartial();
                                }
                                this.stateCase_ = 2;
                            } else if (iQ == 26) {
                                TeamGameStarting.Builder builder3 = this.stateCase_ == 3 ? ((TeamGameStarting) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(TeamGameStarting.parser(), c2306l);
                                if (builder3 != null) {
                                    builder3.mergeFrom((TeamGameStarting) this.state_);
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
                    synchronized (TeamQueueResponse.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
    public TeamQueueDone getDone() {
        return this.stateCase_ == 2 ? (TeamQueueDone) this.state_ : TeamQueueDone.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
    public TeamQueueGoing getGoing() {
        return this.stateCase_ == 1 ? (TeamQueueGoing) this.state_ : TeamQueueGoing.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.stateCase_ == 1 ? 0 + CodedOutputStream.a(1, (TeamQueueGoing) this.state_) : 0;
        if (this.stateCase_ == 2) {
            iA += CodedOutputStream.a(2, (TeamQueueDone) this.state_);
        }
        if (this.stateCase_ == 3) {
            iA += CodedOutputStream.a(3, (TeamGameStarting) this.state_);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
    public TeamGameStarting getStarting() {
        return this.stateCase_ == 3 ? (TeamGameStarting) this.state_ : TeamGameStarting.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponseOrBuilder
    public StateCase getStateCase() {
        return StateCase.forNumber(this.stateCase_);
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.stateCase_ == 1) {
            codedOutputStream.b(1, (TeamQueueGoing) this.state_);
        }
        if (this.stateCase_ == 2) {
            codedOutputStream.b(2, (TeamQueueDone) this.state_);
        }
        if (this.stateCase_ == 3) {
            codedOutputStream.b(3, (TeamGameStarting) this.state_);
        }
    }

    public static Builder newBuilder(TeamQueueResponse teamQueueResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamQueueResponse);
    }

    public static TeamQueueResponse parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueResponse parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamQueueResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamQueueResponse parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(TeamQueueDone.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoing(TeamQueueGoing.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStarting(TeamGameStarting.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 3;
    }

    public static TeamQueueResponse parseFrom(InputStream inputStream) throws IOException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueResponse parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueResponse parseFrom(C2301g c2301g) throws IOException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamQueueResponse parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamQueueResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
