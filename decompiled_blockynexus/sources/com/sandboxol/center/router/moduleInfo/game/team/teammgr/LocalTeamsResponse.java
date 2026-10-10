package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeams;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeams;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeams;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalTeamsResponse extends GeneratedMessageLite<LocalTeamsResponse, Builder> implements LocalTeamsResponseOrBuilder {
    private static final LocalTeamsResponse DEFAULT_INSTANCE = new LocalTeamsResponse();
    private static volatile A<LocalTeamsResponse> PARSER = null;
    public static final int RMVTEAMS_FIELD_NUMBER = 2;
    public static final int TEAMS_FIELD_NUMBER = 1;
    public static final int UPDATETEAMS_FIELD_NUMBER = 3;
    private int stateCase_ = 0;
    private Object state_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$LocalTeamsResponse$StateCase;

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
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$LocalTeamsResponse$StateCase = new int[StateCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$LocalTeamsResponse$StateCase[StateCase.TEAMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$LocalTeamsResponse$StateCase[StateCase.RMVTEAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$LocalTeamsResponse$StateCase[StateCase.UPDATETEAMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$LocalTeamsResponse$StateCase[StateCase.STATE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<LocalTeamsResponse, Builder> implements LocalTeamsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRmvteams() {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).clearRmvteams();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).clearState();
            return this;
        }

        public Builder clearTeams() {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).clearTeams();
            return this;
        }

        public Builder clearUpdateteams() {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).clearUpdateteams();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
        public RemoveLocalTeams getRmvteams() {
            return ((LocalTeamsResponse) this.instance).getRmvteams();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
        public StateCase getStateCase() {
            return ((LocalTeamsResponse) this.instance).getStateCase();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
        public LocalTeams getTeams() {
            return ((LocalTeamsResponse) this.instance).getTeams();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
        public UpdateLocalTeams getUpdateteams() {
            return ((LocalTeamsResponse) this.instance).getUpdateteams();
        }

        public Builder mergeRmvteams(RemoveLocalTeams removeLocalTeams) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).mergeRmvteams(removeLocalTeams);
            return this;
        }

        public Builder mergeTeams(LocalTeams localTeams) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).mergeTeams(localTeams);
            return this;
        }

        public Builder mergeUpdateteams(UpdateLocalTeams updateLocalTeams) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).mergeUpdateteams(updateLocalTeams);
            return this;
        }

        public Builder setRmvteams(RemoveLocalTeams removeLocalTeams) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).setRmvteams(removeLocalTeams);
            return this;
        }

        public Builder setTeams(LocalTeams localTeams) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).setTeams(localTeams);
            return this;
        }

        public Builder setUpdateteams(UpdateLocalTeams updateLocalTeams) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).setUpdateteams(updateLocalTeams);
            return this;
        }

        private Builder() {
            super(LocalTeamsResponse.DEFAULT_INSTANCE);
        }

        public Builder setRmvteams(RemoveLocalTeams.Builder builder) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).setRmvteams(builder);
            return this;
        }

        public Builder setTeams(LocalTeams.Builder builder) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).setTeams(builder);
            return this;
        }

        public Builder setUpdateteams(UpdateLocalTeams.Builder builder) {
            copyOnWrite();
            ((LocalTeamsResponse) this.instance).setUpdateteams(builder);
            return this;
        }
    }

    public enum StateCase implements r.c {
        TEAMS(1),
        RMVTEAMS(2),
        UPDATETEAMS(3),
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
                return TEAMS;
            }
            if (i == 2) {
                return RMVTEAMS;
            }
            if (i != 3) {
                return null;
            }
            return UPDATETEAMS;
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

    private LocalTeamsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRmvteams() {
        if (this.stateCase_ == 2) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.stateCase_ = 0;
        this.state_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeams() {
        if (this.stateCase_ == 1) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateteams() {
        if (this.stateCase_ == 3) {
            this.stateCase_ = 0;
            this.state_ = null;
        }
    }

    public static LocalTeamsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRmvteams(RemoveLocalTeams removeLocalTeams) {
        if (this.stateCase_ != 2 || this.state_ == RemoveLocalTeams.getDefaultInstance()) {
            this.state_ = removeLocalTeams;
        } else {
            this.state_ = RemoveLocalTeams.newBuilder((RemoveLocalTeams) this.state_).mergeFrom(removeLocalTeams).m64buildPartial();
        }
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTeams(LocalTeams localTeams) {
        if (this.stateCase_ != 1 || this.state_ == LocalTeams.getDefaultInstance()) {
            this.state_ = localTeams;
        } else {
            this.state_ = LocalTeams.newBuilder((LocalTeams) this.state_).mergeFrom(localTeams).m64buildPartial();
        }
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateteams(UpdateLocalTeams updateLocalTeams) {
        if (this.stateCase_ != 3 || this.state_ == UpdateLocalTeams.getDefaultInstance()) {
            this.state_ = updateLocalTeams;
        } else {
            this.state_ = UpdateLocalTeams.newBuilder((UpdateLocalTeams) this.state_).mergeFrom(updateLocalTeams).m64buildPartial();
        }
        this.stateCase_ = 3;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static LocalTeamsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalTeamsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<LocalTeamsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRmvteams(RemoveLocalTeams removeLocalTeams) {
        if (removeLocalTeams == null) {
            throw new NullPointerException();
        }
        this.state_ = removeLocalTeams;
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeams(LocalTeams localTeams) {
        if (localTeams == null) {
            throw new NullPointerException();
        }
        this.state_ = localTeams;
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateteams(UpdateLocalTeams updateLocalTeams) {
        if (updateLocalTeams == null) {
            throw new NullPointerException();
        }
        this.state_ = updateLocalTeams;
        this.stateCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new LocalTeamsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                LocalTeamsResponse localTeamsResponse = (LocalTeamsResponse) obj2;
                int i2 = AnonymousClass1.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$LocalTeamsResponse$StateCase[localTeamsResponse.getStateCase().ordinal()];
                if (i2 == 1) {
                    this.state_ = iVar.b(this.stateCase_ == 1, this.state_, localTeamsResponse.state_);
                } else if (i2 == 2) {
                    this.state_ = iVar.b(this.stateCase_ == 2, this.state_, localTeamsResponse.state_);
                } else if (i2 == 3) {
                    this.state_ = iVar.b(this.stateCase_ == 3, this.state_, localTeamsResponse.state_);
                } else if (i2 == 4) {
                    iVar.a(this.stateCase_ != 0);
                }
                if (iVar == GeneratedMessageLite.h.f14297a && (i = localTeamsResponse.stateCase_) != 0) {
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
                                LocalTeams.Builder builder = this.stateCase_ == 1 ? ((LocalTeams) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(LocalTeams.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom((LocalTeams) this.state_);
                                    this.state_ = builder.m64buildPartial();
                                }
                                this.stateCase_ = 1;
                            } else if (iQ == 18) {
                                RemoveLocalTeams.Builder builder2 = this.stateCase_ == 2 ? ((RemoveLocalTeams) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(RemoveLocalTeams.parser(), c2306l);
                                if (builder2 != null) {
                                    builder2.mergeFrom((RemoveLocalTeams) this.state_);
                                    this.state_ = builder2.m64buildPartial();
                                }
                                this.stateCase_ = 2;
                            } else if (iQ == 26) {
                                UpdateLocalTeams.Builder builder3 = this.stateCase_ == 3 ? ((UpdateLocalTeams) this.state_).toBuilder() : null;
                                this.state_ = c2301g.a(UpdateLocalTeams.parser(), c2306l);
                                if (builder3 != null) {
                                    builder3.mergeFrom((UpdateLocalTeams) this.state_);
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
                    synchronized (LocalTeamsResponse.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
    public RemoveLocalTeams getRmvteams() {
        return this.stateCase_ == 2 ? (RemoveLocalTeams) this.state_ : RemoveLocalTeams.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.stateCase_ == 1 ? 0 + CodedOutputStream.a(1, (LocalTeams) this.state_) : 0;
        if (this.stateCase_ == 2) {
            iA += CodedOutputStream.a(2, (RemoveLocalTeams) this.state_);
        }
        if (this.stateCase_ == 3) {
            iA += CodedOutputStream.a(3, (UpdateLocalTeams) this.state_);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
    public StateCase getStateCase() {
        return StateCase.forNumber(this.stateCase_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
    public LocalTeams getTeams() {
        return this.stateCase_ == 1 ? (LocalTeams) this.state_ : LocalTeams.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponseOrBuilder
    public UpdateLocalTeams getUpdateteams() {
        return this.stateCase_ == 3 ? (UpdateLocalTeams) this.state_ : UpdateLocalTeams.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.stateCase_ == 1) {
            codedOutputStream.b(1, (LocalTeams) this.state_);
        }
        if (this.stateCase_ == 2) {
            codedOutputStream.b(2, (RemoveLocalTeams) this.state_);
        }
        if (this.stateCase_ == 3) {
            codedOutputStream.b(3, (UpdateLocalTeams) this.state_);
        }
    }

    public static Builder newBuilder(LocalTeamsResponse localTeamsResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(localTeamsResponse);
    }

    public static LocalTeamsResponse parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static LocalTeamsResponse parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static LocalTeamsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LocalTeamsResponse parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRmvteams(RemoveLocalTeams.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeams(LocalTeams.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateteams(UpdateLocalTeams.Builder builder) {
        this.state_ = builder.build();
        this.stateCase_ = 3;
    }

    public static LocalTeamsResponse parseFrom(InputStream inputStream) throws IOException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalTeamsResponse parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static LocalTeamsResponse parseFrom(C2301g c2301g) throws IOException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static LocalTeamsResponse parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (LocalTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
