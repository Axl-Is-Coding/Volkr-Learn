package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.AbstractC2295a;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdateRequest extends GeneratedMessageLite<UpdateRequest, Builder> implements UpdateRequestOrBuilder {
    public static final int CAPTAINID_FIELD_NUMBER = 2;
    private static final UpdateRequest DEFAULT_INSTANCE = new UpdateRequest();
    public static final int GAMETYPE_FIELD_NUMBER = 1;
    private static volatile A<UpdateRequest> PARSER = null;
    public static final int USER_FIELD_NUMBER = 3;
    private long captainid_;
    private String gametype_ = "";
    private TeamMember user_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<UpdateRequest, Builder> implements UpdateRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCaptainid() {
            copyOnWrite();
            ((UpdateRequest) this.instance).clearCaptainid();
            return this;
        }

        public Builder clearGametype() {
            copyOnWrite();
            ((UpdateRequest) this.instance).clearGametype();
            return this;
        }

        public Builder clearUser() {
            copyOnWrite();
            ((UpdateRequest) this.instance).clearUser();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
        public long getCaptainid() {
            return ((UpdateRequest) this.instance).getCaptainid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
        public String getGametype() {
            return ((UpdateRequest) this.instance).getGametype();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
        public ByteString getGametypeBytes() {
            return ((UpdateRequest) this.instance).getGametypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
        public TeamMember getUser() {
            return ((UpdateRequest) this.instance).getUser();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
        public boolean hasUser() {
            return ((UpdateRequest) this.instance).hasUser();
        }

        public Builder mergeUser(TeamMember teamMember) {
            copyOnWrite();
            ((UpdateRequest) this.instance).mergeUser(teamMember);
            return this;
        }

        public Builder setCaptainid(long j) {
            copyOnWrite();
            ((UpdateRequest) this.instance).setCaptainid(j);
            return this;
        }

        public Builder setGametype(String str) {
            copyOnWrite();
            ((UpdateRequest) this.instance).setGametype(str);
            return this;
        }

        public Builder setGametypeBytes(ByteString byteString) {
            copyOnWrite();
            ((UpdateRequest) this.instance).setGametypeBytes(byteString);
            return this;
        }

        public Builder setUser(TeamMember teamMember) {
            copyOnWrite();
            ((UpdateRequest) this.instance).setUser(teamMember);
            return this;
        }

        private Builder() {
            super(UpdateRequest.DEFAULT_INSTANCE);
        }

        public Builder setUser(TeamMember.Builder builder) {
            copyOnWrite();
            ((UpdateRequest) this.instance).setUser(builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private UpdateRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainid() {
        this.captainid_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGametype() {
        this.gametype_ = getDefaultInstance().getGametype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUser() {
        this.user_ = null;
    }

    public static UpdateRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUser(TeamMember teamMember) {
        TeamMember teamMember2 = this.user_;
        if (teamMember2 == null || teamMember2 == TeamMember.getDefaultInstance()) {
            this.user_ = teamMember;
        } else {
            this.user_ = TeamMember.newBuilder(this.user_).mergeFrom(teamMember).m64buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static UpdateRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UpdateRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<UpdateRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainid(long j) {
        this.captainid_ = j;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(TeamMember teamMember) {
        if (teamMember == null) {
            throw new NullPointerException();
        }
        this.user_ = teamMember;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UpdateRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                UpdateRequest updateRequest = (UpdateRequest) obj2;
                this.gametype_ = iVar.a(!this.gametype_.isEmpty(), this.gametype_, !updateRequest.gametype_.isEmpty(), updateRequest.gametype_);
                this.captainid_ = iVar.a(this.captainid_ != 0, this.captainid_, updateRequest.captainid_ != 0, updateRequest.captainid_);
                this.user_ = (TeamMember) iVar.a(this.user_, updateRequest.user_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                C2306l c2306l = (C2306l) obj2;
                while (!z) {
                    try {
                        try {
                            int iQ = c2301g.q();
                            if (iQ != 0) {
                                if (iQ == 10) {
                                    this.gametype_ = c2301g.p();
                                } else if (iQ == 16) {
                                    this.captainid_ = c2301g.r();
                                } else if (iQ == 26) {
                                    TeamMember.Builder builder = this.user_ != null ? this.user_.toBuilder() : null;
                                    this.user_ = (TeamMember) c2301g.a(TeamMember.parser(), c2306l);
                                    if (builder != null) {
                                        builder.mergeFrom(this.user_);
                                        this.user_ = builder.m64buildPartial();
                                    }
                                } else if (!c2301g.e(iQ)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (UpdateRequest.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
    public long getCaptainid() {
        return this.captainid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
    public String getGametype() {
        return this.gametype_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
    public ByteString getGametypeBytes() {
        return ByteString.copyFromUtf8(this.gametype_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.gametype_.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, getGametype());
        long j = this.captainid_;
        if (j != 0) {
            iA += CodedOutputStream.b(2, j);
        }
        if (this.user_ != null) {
            iA += CodedOutputStream.a(3, getUser());
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
    public TeamMember getUser() {
        TeamMember teamMember = this.user_;
        return teamMember == null ? TeamMember.getDefaultInstance() : teamMember;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateRequestOrBuilder
    public boolean hasUser() {
        return this.user_ != null;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.gametype_.isEmpty()) {
            codedOutputStream.b(1, getGametype());
        }
        long j = this.captainid_;
        if (j != 0) {
            codedOutputStream.d(2, j);
        }
        if (this.user_ != null) {
            codedOutputStream.b(3, getUser());
        }
    }

    public static Builder newBuilder(UpdateRequest updateRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(updateRequest);
    }

    public static UpdateRequest parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (UpdateRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static UpdateRequest parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static UpdateRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(TeamMember.Builder builder) {
        this.user_ = builder.build();
    }

    public static UpdateRequest parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static UpdateRequest parseFrom(InputStream inputStream) throws IOException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateRequest parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static UpdateRequest parseFrom(C2301g c2301g) throws IOException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static UpdateRequest parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (UpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
