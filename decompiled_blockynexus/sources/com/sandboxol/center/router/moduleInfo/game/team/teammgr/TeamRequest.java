package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveMember;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembers;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreate;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamInQueue;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoin;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class TeamRequest extends GeneratedMessageLite<TeamRequest, Builder> implements TeamRequestOrBuilder {
    public static final int CREATE_FIELD_NUMBER = 1;
    private static final TeamRequest DEFAULT_INSTANCE = new TeamRequest();
    public static final int JOIN_FIELD_NUMBER = 2;
    private static volatile A<TeamRequest> PARSER = null;
    public static final int QUEUE_FIELD_NUMBER = 3;
    public static final int REMOVE_FIELD_NUMBER = 4;
    public static final int SYNC_FIELD_NUMBER = 5;
    private int operateCase_ = 0;
    private Object operate_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase;

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
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase = new int[OperateCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase[OperateCase.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase[OperateCase.JOIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase[OperateCase.QUEUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase[OperateCase.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase[OperateCase.SYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase[OperateCase.OPERATE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<TeamRequest, Builder> implements TeamRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCreate() {
            copyOnWrite();
            ((TeamRequest) this.instance).clearCreate();
            return this;
        }

        public Builder clearJoin() {
            copyOnWrite();
            ((TeamRequest) this.instance).clearJoin();
            return this;
        }

        public Builder clearOperate() {
            copyOnWrite();
            ((TeamRequest) this.instance).clearOperate();
            return this;
        }

        public Builder clearQueue() {
            copyOnWrite();
            ((TeamRequest) this.instance).clearQueue();
            return this;
        }

        public Builder clearRemove() {
            copyOnWrite();
            ((TeamRequest) this.instance).clearRemove();
            return this;
        }

        public Builder clearSync() {
            copyOnWrite();
            ((TeamRequest) this.instance).clearSync();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
        public TeamCreate getCreate() {
            return ((TeamRequest) this.instance).getCreate();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
        public TeamJoin getJoin() {
            return ((TeamRequest) this.instance).getJoin();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
        public OperateCase getOperateCase() {
            return ((TeamRequest) this.instance).getOperateCase();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
        public TeamInQueue getQueue() {
            return ((TeamRequest) this.instance).getQueue();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
        public RemoveMember getRemove() {
            return ((TeamRequest) this.instance).getRemove();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
        public SyncMembers getSync() {
            return ((TeamRequest) this.instance).getSync();
        }

        public Builder mergeCreate(TeamCreate teamCreate) {
            copyOnWrite();
            ((TeamRequest) this.instance).mergeCreate(teamCreate);
            return this;
        }

        public Builder mergeJoin(TeamJoin teamJoin) {
            copyOnWrite();
            ((TeamRequest) this.instance).mergeJoin(teamJoin);
            return this;
        }

        public Builder mergeQueue(TeamInQueue teamInQueue) {
            copyOnWrite();
            ((TeamRequest) this.instance).mergeQueue(teamInQueue);
            return this;
        }

        public Builder mergeRemove(RemoveMember removeMember) {
            copyOnWrite();
            ((TeamRequest) this.instance).mergeRemove(removeMember);
            return this;
        }

        public Builder mergeSync(SyncMembers syncMembers) {
            copyOnWrite();
            ((TeamRequest) this.instance).mergeSync(syncMembers);
            return this;
        }

        public Builder setCreate(TeamCreate teamCreate) {
            copyOnWrite();
            ((TeamRequest) this.instance).setCreate(teamCreate);
            return this;
        }

        public Builder setJoin(TeamJoin teamJoin) {
            copyOnWrite();
            ((TeamRequest) this.instance).setJoin(teamJoin);
            return this;
        }

        public Builder setQueue(TeamInQueue teamInQueue) {
            copyOnWrite();
            ((TeamRequest) this.instance).setQueue(teamInQueue);
            return this;
        }

        public Builder setRemove(RemoveMember removeMember) {
            copyOnWrite();
            ((TeamRequest) this.instance).setRemove(removeMember);
            return this;
        }

        public Builder setSync(SyncMembers syncMembers) {
            copyOnWrite();
            ((TeamRequest) this.instance).setSync(syncMembers);
            return this;
        }

        private Builder() {
            super(TeamRequest.DEFAULT_INSTANCE);
        }

        public Builder setCreate(TeamCreate.Builder builder) {
            copyOnWrite();
            ((TeamRequest) this.instance).setCreate(builder);
            return this;
        }

        public Builder setJoin(TeamJoin.Builder builder) {
            copyOnWrite();
            ((TeamRequest) this.instance).setJoin(builder);
            return this;
        }

        public Builder setQueue(TeamInQueue.Builder builder) {
            copyOnWrite();
            ((TeamRequest) this.instance).setQueue(builder);
            return this;
        }

        public Builder setRemove(RemoveMember.Builder builder) {
            copyOnWrite();
            ((TeamRequest) this.instance).setRemove(builder);
            return this;
        }

        public Builder setSync(SyncMembers.Builder builder) {
            copyOnWrite();
            ((TeamRequest) this.instance).setSync(builder);
            return this;
        }
    }

    public enum OperateCase implements r.c {
        CREATE(1),
        JOIN(2),
        QUEUE(3),
        REMOVE(4),
        SYNC(5),
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
                return CREATE;
            }
            if (i == 2) {
                return JOIN;
            }
            if (i == 3) {
                return QUEUE;
            }
            if (i == 4) {
                return REMOVE;
            }
            if (i != 5) {
                return null;
            }
            return SYNC;
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

    private TeamRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreate() {
        if (this.operateCase_ == 1) {
            this.operateCase_ = 0;
            this.operate_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJoin() {
        if (this.operateCase_ == 2) {
            this.operateCase_ = 0;
            this.operate_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperate() {
        this.operateCase_ = 0;
        this.operate_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQueue() {
        if (this.operateCase_ == 3) {
            this.operateCase_ = 0;
            this.operate_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemove() {
        if (this.operateCase_ == 4) {
            this.operateCase_ = 0;
            this.operate_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSync() {
        if (this.operateCase_ == 5) {
            this.operateCase_ = 0;
            this.operate_ = null;
        }
    }

    public static TeamRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreate(TeamCreate teamCreate) {
        if (this.operateCase_ != 1 || this.operate_ == TeamCreate.getDefaultInstance()) {
            this.operate_ = teamCreate;
        } else {
            this.operate_ = TeamCreate.newBuilder((TeamCreate) this.operate_).mergeFrom(teamCreate).m64buildPartial();
        }
        this.operateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeJoin(TeamJoin teamJoin) {
        if (this.operateCase_ != 2 || this.operate_ == TeamJoin.getDefaultInstance()) {
            this.operate_ = teamJoin;
        } else {
            this.operate_ = TeamJoin.newBuilder((TeamJoin) this.operate_).mergeFrom(teamJoin).m64buildPartial();
        }
        this.operateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeQueue(TeamInQueue teamInQueue) {
        if (this.operateCase_ != 3 || this.operate_ == TeamInQueue.getDefaultInstance()) {
            this.operate_ = teamInQueue;
        } else {
            this.operate_ = TeamInQueue.newBuilder((TeamInQueue) this.operate_).mergeFrom(teamInQueue).m64buildPartial();
        }
        this.operateCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRemove(RemoveMember removeMember) {
        if (this.operateCase_ != 4 || this.operate_ == RemoveMember.getDefaultInstance()) {
            this.operate_ = removeMember;
        } else {
            this.operate_ = RemoveMember.newBuilder((RemoveMember) this.operate_).mergeFrom(removeMember).m64buildPartial();
        }
        this.operateCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSync(SyncMembers syncMembers) {
        if (this.operateCase_ != 5 || this.operate_ == SyncMembers.getDefaultInstance()) {
            this.operate_ = syncMembers;
        } else {
            this.operate_ = SyncMembers.newBuilder((SyncMembers) this.operate_).mergeFrom(syncMembers).m64buildPartial();
        }
        this.operateCase_ = 5;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreate(TeamCreate teamCreate) {
        if (teamCreate == null) {
            throw new NullPointerException();
        }
        this.operate_ = teamCreate;
        this.operateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJoin(TeamJoin teamJoin) {
        if (teamJoin == null) {
            throw new NullPointerException();
        }
        this.operate_ = teamJoin;
        this.operateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQueue(TeamInQueue teamInQueue) {
        if (teamInQueue == null) {
            throw new NullPointerException();
        }
        this.operate_ = teamInQueue;
        this.operateCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemove(RemoveMember removeMember) {
        if (removeMember == null) {
            throw new NullPointerException();
        }
        this.operate_ = removeMember;
        this.operateCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSync(SyncMembers syncMembers) {
        if (syncMembers == null) {
            throw new NullPointerException();
        }
        this.operate_ = syncMembers;
        this.operateCase_ = 5;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamRequest teamRequest = (TeamRequest) obj2;
                switch (AnonymousClass1.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$TeamRequest$OperateCase[teamRequest.getOperateCase().ordinal()]) {
                    case 1:
                        this.operate_ = iVar.b(this.operateCase_ == 1, this.operate_, teamRequest.operate_);
                        break;
                    case 2:
                        this.operate_ = iVar.b(this.operateCase_ == 2, this.operate_, teamRequest.operate_);
                        break;
                    case 3:
                        this.operate_ = iVar.b(this.operateCase_ == 3, this.operate_, teamRequest.operate_);
                        break;
                    case 4:
                        this.operate_ = iVar.b(this.operateCase_ == 4, this.operate_, teamRequest.operate_);
                        break;
                    case 5:
                        this.operate_ = iVar.b(this.operateCase_ == 5, this.operate_, teamRequest.operate_);
                        break;
                    case 6:
                        iVar.a(this.operateCase_ != 0);
                        break;
                }
                if (iVar == GeneratedMessageLite.h.f14297a && (i = teamRequest.operateCase_) != 0) {
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
                                TeamCreate.Builder builder = this.operateCase_ == 1 ? ((TeamCreate) this.operate_).toBuilder() : null;
                                this.operate_ = c2301g.a(TeamCreate.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom((TeamCreate) this.operate_);
                                    this.operate_ = builder.m64buildPartial();
                                }
                                this.operateCase_ = 1;
                            } else if (iQ == 18) {
                                TeamJoin.Builder builder2 = this.operateCase_ == 2 ? ((TeamJoin) this.operate_).toBuilder() : null;
                                this.operate_ = c2301g.a(TeamJoin.parser(), c2306l);
                                if (builder2 != null) {
                                    builder2.mergeFrom((TeamJoin) this.operate_);
                                    this.operate_ = builder2.m64buildPartial();
                                }
                                this.operateCase_ = 2;
                            } else if (iQ == 26) {
                                TeamInQueue.Builder builder3 = this.operateCase_ == 3 ? ((TeamInQueue) this.operate_).toBuilder() : null;
                                this.operate_ = c2301g.a(TeamInQueue.parser(), c2306l);
                                if (builder3 != null) {
                                    builder3.mergeFrom((TeamInQueue) this.operate_);
                                    this.operate_ = builder3.m64buildPartial();
                                }
                                this.operateCase_ = 3;
                            } else if (iQ == 34) {
                                RemoveMember.Builder builder4 = this.operateCase_ == 4 ? ((RemoveMember) this.operate_).toBuilder() : null;
                                this.operate_ = c2301g.a(RemoveMember.parser(), c2306l);
                                if (builder4 != null) {
                                    builder4.mergeFrom((RemoveMember) this.operate_);
                                    this.operate_ = builder4.m64buildPartial();
                                }
                                this.operateCase_ = 4;
                            } else if (iQ == 42) {
                                SyncMembers.Builder builder5 = this.operateCase_ == 5 ? ((SyncMembers) this.operate_).toBuilder() : null;
                                this.operate_ = c2301g.a(SyncMembers.parser(), c2306l);
                                if (builder5 != null) {
                                    builder5.mergeFrom((SyncMembers) this.operate_);
                                    this.operate_ = builder5.m64buildPartial();
                                }
                                this.operateCase_ = 5;
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
                    synchronized (TeamRequest.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
    public TeamCreate getCreate() {
        return this.operateCase_ == 1 ? (TeamCreate) this.operate_ : TeamCreate.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
    public TeamJoin getJoin() {
        return this.operateCase_ == 2 ? (TeamJoin) this.operate_ : TeamJoin.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
    public OperateCase getOperateCase() {
        return OperateCase.forNumber(this.operateCase_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
    public TeamInQueue getQueue() {
        return this.operateCase_ == 3 ? (TeamInQueue) this.operate_ : TeamInQueue.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
    public RemoveMember getRemove() {
        return this.operateCase_ == 4 ? (RemoveMember) this.operate_ : RemoveMember.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.operateCase_ == 1 ? 0 + CodedOutputStream.a(1, (TeamCreate) this.operate_) : 0;
        if (this.operateCase_ == 2) {
            iA += CodedOutputStream.a(2, (TeamJoin) this.operate_);
        }
        if (this.operateCase_ == 3) {
            iA += CodedOutputStream.a(3, (TeamInQueue) this.operate_);
        }
        if (this.operateCase_ == 4) {
            iA += CodedOutputStream.a(4, (RemoveMember) this.operate_);
        }
        if (this.operateCase_ == 5) {
            iA += CodedOutputStream.a(5, (SyncMembers) this.operate_);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequestOrBuilder
    public SyncMembers getSync() {
        return this.operateCase_ == 5 ? (SyncMembers) this.operate_ : SyncMembers.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.operateCase_ == 1) {
            codedOutputStream.b(1, (TeamCreate) this.operate_);
        }
        if (this.operateCase_ == 2) {
            codedOutputStream.b(2, (TeamJoin) this.operate_);
        }
        if (this.operateCase_ == 3) {
            codedOutputStream.b(3, (TeamInQueue) this.operate_);
        }
        if (this.operateCase_ == 4) {
            codedOutputStream.b(4, (RemoveMember) this.operate_);
        }
        if (this.operateCase_ == 5) {
            codedOutputStream.b(5, (SyncMembers) this.operate_);
        }
    }

    public static Builder newBuilder(TeamRequest teamRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamRequest);
    }

    public static TeamRequest parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamRequest parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamRequest parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreate(TeamCreate.Builder builder) {
        this.operate_ = builder.build();
        this.operateCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJoin(TeamJoin.Builder builder) {
        this.operate_ = builder.build();
        this.operateCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQueue(TeamInQueue.Builder builder) {
        this.operate_ = builder.build();
        this.operateCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemove(RemoveMember.Builder builder) {
        this.operate_ = builder.build();
        this.operateCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSync(SyncMembers.Builder builder) {
        this.operate_ = builder.build();
        this.operateCase_ = 5;
    }

    public static TeamRequest parseFrom(InputStream inputStream) throws IOException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamRequest parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamRequest parseFrom(C2301g c2301g) throws IOException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamRequest parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
