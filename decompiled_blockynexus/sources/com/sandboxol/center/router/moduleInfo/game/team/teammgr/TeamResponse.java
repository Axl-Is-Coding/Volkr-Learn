package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDone;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamError;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoing;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class TeamResponse extends GeneratedMessageLite<TeamResponse, Builder> implements TeamResponseOrBuilder {
    private static final TeamResponse DEFAULT_INSTANCE = new TeamResponse();
    public static final int DONE_FIELD_NUMBER = 2;
    public static final int ERR_FIELD_NUMBER = 3;
    public static final int GOING_FIELD_NUMBER = 1;
    private static volatile A<TeamResponse> PARSER = null;
    public static final int STARTGAME_FIELD_NUMBER = 4;
    private int stateCase_ = 0;
    private Object state_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase;

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
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase = new int[StateCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[StateCase.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[StateCase.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[StateCase.ERR.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[StateCase.STARTGAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[StateCase.STATE_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<TeamResponse, Builder> implements TeamResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDone() {
            copyOnWrite();
            ((TeamResponse) this.instance).clearDone();
            return this;
        }

        public Builder clearErr() {
            copyOnWrite();
            ((TeamResponse) this.instance).clearErr();
            return this;
        }

        public Builder clearGoing() {
            copyOnWrite();
            ((TeamResponse) this.instance).clearGoing();
            return this;
        }

        public Builder clearStartGame() {
            copyOnWrite();
            ((TeamResponse) this.instance).clearStartGame();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((TeamResponse) this.instance).clearState();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
        public TeamDone getDone() {
            return ((TeamResponse) this.instance).getDone();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
        public TeamError getErr() {
            return ((TeamResponse) this.instance).getErr();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
        public TeamGoing getGoing() {
            return ((TeamResponse) this.instance).getGoing();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
        public boolean getStartGame() {
            return ((TeamResponse) this.instance).getStartGame();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
        public StateCase getStateCase() {
            return ((TeamResponse) this.instance).getStateCase();
        }

        public Builder mergeDone(TeamDone teamDone) {
            copyOnWrite();
            ((TeamResponse) this.instance).mergeDone(teamDone);
            return this;
        }

        public Builder mergeErr(TeamError teamError) {
            copyOnWrite();
            ((TeamResponse) this.instance).mergeErr(teamError);
            return this;
        }

        public Builder mergeGoing(TeamGoing teamGoing) {
            copyOnWrite();
            ((TeamResponse) this.instance).mergeGoing(teamGoing);
            return this;
        }

        public Builder setDone(TeamDone teamDone) {
            copyOnWrite();
            ((TeamResponse) this.instance).setDone(teamDone);
            return this;
        }

        public Builder setErr(TeamError teamError) {
            copyOnWrite();
            ((TeamResponse) this.instance).setErr(teamError);
            return this;
        }

        public Builder setGoing(TeamGoing teamGoing) {
            copyOnWrite();
            ((TeamResponse) this.instance).setGoing(teamGoing);
            return this;
        }

        public Builder setStartGame(boolean z) {
            copyOnWrite();
            ((TeamResponse) this.instance).setStartGame(z);
            return this;
        }

        private Builder() {
            super(TeamResponse.DEFAULT_INSTANCE);
        }

        public Builder setDone(TeamDone.Builder builder) {
            copyOnWrite();
            ((TeamResponse) this.instance).setDone(builder);
            return this;
        }

        public Builder setErr(TeamError.Builder builder) {
            copyOnWrite();
            ((TeamResponse) this.instance).setErr(builder);
            return this;
        }

        public Builder setGoing(TeamGoing.Builder builder) {
            copyOnWrite();
            ((TeamResponse) this.instance).setGoing(builder);
            return this;
        }
    }

    public enum StateCase implements r.c {
        GOING(1),
        DONE(2),
        ERR(3),
        STARTGAME(4),
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
            if (i == 3) {
                return ERR;
            }
            if (i != 4) {
                return null;
            }
            return STARTGAME;
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

    private TeamResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDone() {
        if (this.stateCase_ == 2) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErr() {
        if (this.stateCase_ == 3) {
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
    public void clearStartGame() {
        if (this.stateCase_ == 4) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.stateCase_ = 0;
        this.state_ = null;
    }

    public static TeamResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDone(TeamDone teamDone) {
        if (this.stateCase_ != 2 || this.state_ == TeamDone.getDefaultInstance()) {
            this.state_ = teamDone;
        } else {
            this.state_ = TeamDone.newBuilder((TeamDone) this.state_).mergeFrom(teamDone).m64buildPartial();
        }
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeErr(TeamError teamError) {
        if (this.stateCase_ != 3 || this.state_ == TeamError.getDefaultInstance()) {
            this.state_ = teamError;
        } else {
            this.state_ = TeamError.newBuilder((TeamError) this.state_).mergeFrom(teamError).m64buildPartial();
        }
        this.stateCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGoing(TeamGoing teamGoing) {
        if (this.stateCase_ != 1 || this.state_ == TeamGoing.getDefaultInstance()) {
            this.state_ = teamGoing;
        } else {
            this.state_ = TeamGoing.newBuilder((TeamGoing) this.state_).mergeFrom(teamGoing).m64buildPartial();
        }
        this.stateCase_ = 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(TeamDone teamDone) {
        if (teamDone == null) {
            throw new NullPointerException();
        }
        this.state_ = teamDone;
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErr(TeamError teamError) {
        if (teamError == null) {
            throw new NullPointerException();
        }
        this.state_ = teamError;
        this.stateCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoing(TeamGoing teamGoing) {
        if (teamGoing == null) {
            throw new NullPointerException();
        }
        this.state_ = teamGoing;
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartGame(boolean z) {
        this.stateCase_ = 4;
        this.state_ = Boolean.valueOf(z);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamResponse teamResponse = (TeamResponse) obj2;
                int i2 = AnonymousClass1.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamResponse$StateCase[teamResponse.getStateCase().ordinal()];
                if (i2 == 1) {
                    this.state_ = iVar.b(this.stateCase_ == 1, this.state_, teamResponse.state_);
                } else if (i2 == 2) {
                    this.state_ = iVar.b(this.stateCase_ == 2, this.state_, teamResponse.state_);
                } else if (i2 == 3) {
                    this.state_ = iVar.b(this.stateCase_ == 3, this.state_, teamResponse.state_);
                } else if (i2 == 4) {
                    this.state_ = iVar.a(this.stateCase_ == 4, this.state_, teamResponse.state_);
                } else if (i2 == 5) {
                    iVar.a(this.stateCase_ != 0);
                }
                if (iVar == GeneratedMessageLite.h.f14297a && (i = teamResponse.stateCase_) != 0) {
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
                                TeamGoing.Builder builder = this.stateCase_ == 1 ? ((TeamGoing) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(TeamGoing.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom((TeamGoing) this.state_);
                                    this.state_ = builder.m64buildPartial();
                                }
                                this.stateCase_ = 1;
                            } else if (iQ == 18) {
                                TeamDone.Builder builder2 = this.stateCase_ == 2 ? ((TeamDone) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(TeamDone.parser(), c2306l);
                                if (builder2 != null) {
                                    builder2.mergeFrom((TeamDone) this.state_);
                                    this.state_ = builder2.m64buildPartial();
                                }
                                this.stateCase_ = 2;
                            } else if (iQ == 26) {
                                TeamError.Builder builder3 = this.stateCase_ == 3 ? ((TeamError) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(TeamError.parser(), c2306l);
                                if (builder3 != null) {
                                    builder3.mergeFrom((TeamError) this.state_);
                                    this.state_ = builder3.m64buildPartial();
                                }
                                this.stateCase_ = 3;
                            } else if (iQ == 32) {
                                this.stateCase_ = 4;
                                this.state_ = Boolean.valueOf(c2301g.c());
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
                    synchronized (TeamResponse.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
    public TeamDone getDone() {
        return this.stateCase_ == 2 ? (TeamDone) this.state_ : TeamDone.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
    public TeamError getErr() {
        return this.stateCase_ == 3 ? (TeamError) this.state_ : TeamError.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
    public TeamGoing getGoing() {
        return this.stateCase_ == 1 ? (TeamGoing) this.state_ : TeamGoing.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.stateCase_ == 1 ? 0 + CodedOutputStream.a(1, (TeamGoing) this.state_) : 0;
        if (this.stateCase_ == 2) {
            iA += CodedOutputStream.a(2, (TeamDone) this.state_);
        }
        if (this.stateCase_ == 3) {
            iA += CodedOutputStream.a(3, (TeamError) this.state_);
        }
        if (this.stateCase_ == 4) {
            iA += CodedOutputStream.a(4, ((Boolean) this.state_).booleanValue());
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
    public boolean getStartGame() {
        if (this.stateCase_ == 4) {
            return ((Boolean) this.state_).booleanValue();
        }
        return false;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponseOrBuilder
    public StateCase getStateCase() {
        return StateCase.forNumber(this.stateCase_);
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.stateCase_ == 1) {
            codedOutputStream.b(1, (TeamGoing) this.state_);
        }
        if (this.stateCase_ == 2) {
            codedOutputStream.b(2, (TeamDone) this.state_);
        }
        if (this.stateCase_ == 3) {
            codedOutputStream.b(3, (TeamError) this.state_);
        }
        if (this.stateCase_ == 4) {
            codedOutputStream.b(4, ((Boolean) this.state_).booleanValue());
        }
    }

    public static Builder newBuilder(TeamResponse teamResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamResponse);
    }

    public static TeamResponse parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamResponse parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamResponse parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(TeamDone.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErr(TeamError.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoing(TeamGoing.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 1;
    }

    public static TeamResponse parseFrom(InputStream inputStream) throws IOException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamResponse parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamResponse parseFrom(C2301g c2301g) throws IOException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamResponse parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
