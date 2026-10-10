package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStart;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStop;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class TeamQueueRequest extends GeneratedMessageLite<TeamQueueRequest, Builder> implements TeamQueueRequestOrBuilder {
    private static final TeamQueueRequest DEFAULT_INSTANCE = new TeamQueueRequest();
    private static volatile A<TeamQueueRequest> PARSER = null;
    public static final int START_FIELD_NUMBER = 1;
    public static final int STOP_FIELD_NUMBER = 2;
    private int operateCase_ = 0;
    private Object operate_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueRequest$OperateCase;

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
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueRequest$OperateCase = new int[OperateCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueRequest$OperateCase[OperateCase.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueRequest$OperateCase[OperateCase.STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueRequest$OperateCase[OperateCase.OPERATE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<TeamQueueRequest, Builder> implements TeamQueueRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearOperate() {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).clearOperate();
            return this;
        }

        public Builder clearStart() {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).clearStart();
            return this;
        }

        public Builder clearStop() {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).clearStop();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequestOrBuilder
        public OperateCase getOperateCase() {
            return ((TeamQueueRequest) this.instance).getOperateCase();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequestOrBuilder
        public TeamQueueStart getStart() {
            return ((TeamQueueRequest) this.instance).getStart();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequestOrBuilder
        public TeamQueueStop getStop() {
            return ((TeamQueueRequest) this.instance).getStop();
        }

        public Builder mergeStart(TeamQueueStart teamQueueStart) {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).mergeStart(teamQueueStart);
            return this;
        }

        public Builder mergeStop(TeamQueueStop teamQueueStop) {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).mergeStop(teamQueueStop);
            return this;
        }

        public Builder setStart(TeamQueueStart teamQueueStart) {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).setStart(teamQueueStart);
            return this;
        }

        public Builder setStop(TeamQueueStop teamQueueStop) {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).setStop(teamQueueStop);
            return this;
        }

        private Builder() {
            super(TeamQueueRequest.DEFAULT_INSTANCE);
        }

        public Builder setStart(TeamQueueStart.Builder builder) {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).setStart(builder);
            return this;
        }

        public Builder setStop(TeamQueueStop.Builder builder) {
            copyOnWrite();
            ((TeamQueueRequest) this.instance).setStop(builder);
            return this;
        }
    }

    public enum OperateCase implements r.c {
        START(1),
        STOP(2),
        OPERATE_NOT_SET(0);

        private final int value;

        OperateCase(int i) {
            this.value = i;
        }

        public static OperateCase forNumber(int i) {
            if (i == 0) {
                return OPERATE_NOT_SET;
            }
            if (i == 1) {
                return START;
            }
            if (i != 2) {
                return null;
            }
            return STOP;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static OperateCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamQueueRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperate() {
        this.operateCase_ = 0;
        this.operate_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStart() {
        if (this.operateCase_ == 1) {
            this.operateCase_ = 0;
            this.operate_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStop() {
        if (this.operateCase_ == 2) {
            this.operateCase_ = 0;
            this.operate_ = null;
        }
    }

    public static TeamQueueRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStart(TeamQueueStart teamQueueStart) {
        if (this.operateCase_ != 1 || this.operate_ == TeamQueueStart.getDefaultInstance()) {
            this.operate_ = teamQueueStart;
        } else {
            this.operate_ = TeamQueueStart.newBuilder((TeamQueueStart) this.operate_).mergeFrom(teamQueueStart).m64buildPartial();
        }
        this.operateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStop(TeamQueueStop teamQueueStop) {
        if (this.operateCase_ != 2 || this.operate_ == TeamQueueStop.getDefaultInstance()) {
            this.operate_ = teamQueueStop;
        } else {
            this.operate_ = TeamQueueStop.newBuilder((TeamQueueStop) this.operate_).mergeFrom(teamQueueStop).m64buildPartial();
        }
        this.operateCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamQueueRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamQueueRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamQueueRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStart(TeamQueueStart teamQueueStart) {
        if (teamQueueStart == null) {
            throw new NullPointerException();
        }
        this.operate_ = teamQueueStart;
        this.operateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStop(TeamQueueStop teamQueueStop) {
        if (teamQueueStop == null) {
            throw new NullPointerException();
        }
        this.operate_ = teamQueueStop;
        this.operateCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamQueueRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamQueueRequest teamQueueRequest = (TeamQueueRequest) obj2;
                int i2 = AnonymousClass1.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$connector$TeamQueueRequest$OperateCase[teamQueueRequest.getOperateCase().ordinal()];
                if (i2 == 1) {
                    this.operate_ = iVar.b(this.operateCase_ == 1, this.operate_, teamQueueRequest.operate_);
                } else if (i2 == 2) {
                    this.operate_ = iVar.b(this.operateCase_ == 2, this.operate_, teamQueueRequest.operate_);
                } else if (i2 == 3) {
                    iVar.a(this.operateCase_ != 0);
                }
                if (iVar == GeneratedMessageLite.h.f14297a && (i = teamQueueRequest.operateCase_) != 0) {
                    this.operateCase_ = i;
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
                                TeamQueueStart.Builder builder = this.operateCase_ == 1 ? ((TeamQueueStart) this.operate_).toBuilder() : null;
                                this.operate_ = c2301g.a(TeamQueueStart.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom((TeamQueueStart) this.operate_);
                                    this.operate_ = builder.m64buildPartial();
                                }
                                this.operateCase_ = 1;
                            } else if (iQ == 18) {
                                TeamQueueStop.Builder builder2 = this.operateCase_ == 2 ? ((TeamQueueStop) this.operate_).toBuilder() : null;
                                this.operate_ = c2301g.a(TeamQueueStop.parser(), c2306l);
                                if (builder2 != null) {
                                    builder2.mergeFrom((TeamQueueStop) this.operate_);
                                    this.operate_ = builder2.m64buildPartial();
                                }
                                this.operateCase_ = 2;
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
                    synchronized (TeamQueueRequest.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequestOrBuilder
    public OperateCase getOperateCase() {
        return OperateCase.forNumber(this.operateCase_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.operateCase_ == 1 ? 0 + CodedOutputStream.a(1, (TeamQueueStart) this.operate_) : 0;
        if (this.operateCase_ == 2) {
            iA += CodedOutputStream.a(2, (TeamQueueStop) this.operate_);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequestOrBuilder
    public TeamQueueStart getStart() {
        return this.operateCase_ == 1 ? (TeamQueueStart) this.operate_ : TeamQueueStart.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequestOrBuilder
    public TeamQueueStop getStop() {
        return this.operateCase_ == 2 ? (TeamQueueStop) this.operate_ : TeamQueueStop.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.operateCase_ == 1) {
            codedOutputStream.b(1, (TeamQueueStart) this.operate_);
        }
        if (this.operateCase_ == 2) {
            codedOutputStream.b(2, (TeamQueueStop) this.operate_);
        }
    }

    public static Builder newBuilder(TeamQueueRequest teamQueueRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamQueueRequest);
    }

    public static TeamQueueRequest parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueRequest parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamQueueRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamQueueRequest parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStart(TeamQueueStart.Builder builder) {
        this.operate_ = builder.build();
        this.operateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStop(TeamQueueStop.Builder builder) {
        this.operate_ = builder.build();
        this.operateCase_ = 2;
    }

    public static TeamQueueRequest parseFrom(InputStream inputStream) throws IOException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueRequest parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueRequest parseFrom(C2301g c2301g) throws IOException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamQueueRequest parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamQueueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
