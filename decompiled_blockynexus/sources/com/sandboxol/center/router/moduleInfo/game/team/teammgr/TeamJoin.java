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
public final class TeamJoin extends GeneratedMessageLite<TeamJoin, Builder> implements TeamJoinOrBuilder {
    private static final TeamJoin DEFAULT_INSTANCE = new TeamJoin();
    public static final int DISPURL_FIELD_NUMBER = 6;
    public static final int GAMETYPE_FIELD_NUMBER = 1;
    private static volatile A<TeamJoin> PARSER = null;
    public static final int REGIONID_FIELD_NUMBER = 4;
    public static final int TEAMID_FIELD_NUMBER = 2;
    public static final int USER_FIELD_NUMBER = 3;
    private int regionId_;
    private TeamMember user_;
    private String gametype_ = "";
    private String teamId_ = "";
    private String dispUrl_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoin$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamJoin, Builder> implements TeamJoinOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDispUrl() {
            copyOnWrite();
            ((TeamJoin) this.instance).clearDispUrl();
            return this;
        }

        public Builder clearGametype() {
            copyOnWrite();
            ((TeamJoin) this.instance).clearGametype();
            return this;
        }

        public Builder clearRegionId() {
            copyOnWrite();
            ((TeamJoin) this.instance).clearRegionId();
            return this;
        }

        public Builder clearTeamId() {
            copyOnWrite();
            ((TeamJoin) this.instance).clearTeamId();
            return this;
        }

        public Builder clearUser() {
            copyOnWrite();
            ((TeamJoin) this.instance).clearUser();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public String getDispUrl() {
            return ((TeamJoin) this.instance).getDispUrl();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public ByteString getDispUrlBytes() {
            return ((TeamJoin) this.instance).getDispUrlBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public String getGametype() {
            return ((TeamJoin) this.instance).getGametype();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public ByteString getGametypeBytes() {
            return ((TeamJoin) this.instance).getGametypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public int getRegionId() {
            return ((TeamJoin) this.instance).getRegionId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public String getTeamId() {
            return ((TeamJoin) this.instance).getTeamId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public ByteString getTeamIdBytes() {
            return ((TeamJoin) this.instance).getTeamIdBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public TeamMember getUser() {
            return ((TeamJoin) this.instance).getUser();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
        public boolean hasUser() {
            return ((TeamJoin) this.instance).hasUser();
        }

        public Builder mergeUser(TeamMember teamMember) {
            copyOnWrite();
            ((TeamJoin) this.instance).mergeUser(teamMember);
            return this;
        }

        public Builder setDispUrl(String str) {
            copyOnWrite();
            ((TeamJoin) this.instance).setDispUrl(str);
            return this;
        }

        public Builder setDispUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamJoin) this.instance).setDispUrlBytes(byteString);
            return this;
        }

        public Builder setGametype(String str) {
            copyOnWrite();
            ((TeamJoin) this.instance).setGametype(str);
            return this;
        }

        public Builder setGametypeBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamJoin) this.instance).setGametypeBytes(byteString);
            return this;
        }

        public Builder setRegionId(int i) {
            copyOnWrite();
            ((TeamJoin) this.instance).setRegionId(i);
            return this;
        }

        public Builder setTeamId(String str) {
            copyOnWrite();
            ((TeamJoin) this.instance).setTeamId(str);
            return this;
        }

        public Builder setTeamIdBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamJoin) this.instance).setTeamIdBytes(byteString);
            return this;
        }

        public Builder setUser(TeamMember teamMember) {
            copyOnWrite();
            ((TeamJoin) this.instance).setUser(teamMember);
            return this;
        }

        private Builder() {
            super(TeamJoin.DEFAULT_INSTANCE);
        }

        public Builder setUser(TeamMember.Builder builder) {
            copyOnWrite();
            ((TeamJoin) this.instance).setUser(builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamJoin() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispUrl() {
        this.dispUrl_ = getDefaultInstance().getDispUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGametype() {
        this.gametype_ = getDefaultInstance().getGametype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegionId() {
        this.regionId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamId() {
        this.teamId_ = getDefaultInstance().getTeamId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUser() {
        this.user_ = null;
    }

    public static TeamJoin getDefaultInstance() {
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

    public static TeamJoin parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamJoin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamJoin parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamJoin> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.dispUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.dispUrl_ = byteString.toStringUtf8();
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
    public void setRegionId(int i) {
        this.regionId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.teamId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.teamId_ = byteString.toStringUtf8();
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
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamJoin();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamJoin teamJoin = (TeamJoin) obj2;
                this.gametype_ = iVar.a(!this.gametype_.isEmpty(), this.gametype_, !teamJoin.gametype_.isEmpty(), teamJoin.gametype_);
                this.teamId_ = iVar.a(!this.teamId_.isEmpty(), this.teamId_, !teamJoin.teamId_.isEmpty(), teamJoin.teamId_);
                this.user_ = (TeamMember) iVar.a(this.user_, teamJoin.user_);
                this.regionId_ = iVar.a(this.regionId_ != 0, this.regionId_, teamJoin.regionId_ != 0, teamJoin.regionId_);
                this.dispUrl_ = iVar.a(!this.dispUrl_.isEmpty(), this.dispUrl_, !teamJoin.dispUrl_.isEmpty(), teamJoin.dispUrl_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                C2306l c2306l = (C2306l) obj2;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 10) {
                                this.gametype_ = c2301g.p();
                            } else if (iQ == 18) {
                                this.teamId_ = c2301g.p();
                            } else if (iQ == 26) {
                                TeamMember.Builder builder = this.user_ != null ? this.user_.toBuilder() : null;
                                this.user_ = (TeamMember) c2301g.a(TeamMember.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom(this.user_);
                                    this.user_ = builder.m64buildPartial();
                                }
                            } else if (iQ == 32) {
                                this.regionId_ = c2301g.h();
                            } else if (iQ == 50) {
                                this.dispUrl_ = c2301g.p();
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
                    synchronized (TeamJoin.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public String getDispUrl() {
        return this.dispUrl_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public ByteString getDispUrlBytes() {
        return ByteString.copyFromUtf8(this.dispUrl_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public String getGametype() {
        return this.gametype_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public ByteString getGametypeBytes() {
        return ByteString.copyFromUtf8(this.gametype_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public int getRegionId() {
        return this.regionId_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.gametype_.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, getGametype());
        if (!this.teamId_.isEmpty()) {
            iA += CodedOutputStream.a(2, getTeamId());
        }
        if (this.user_ != null) {
            iA += CodedOutputStream.a(3, getUser());
        }
        int i2 = this.regionId_;
        if (i2 != 0) {
            iA += CodedOutputStream.b(4, i2);
        }
        if (!this.dispUrl_.isEmpty()) {
            iA += CodedOutputStream.a(6, getDispUrl());
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public String getTeamId() {
        return this.teamId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public ByteString getTeamIdBytes() {
        return ByteString.copyFromUtf8(this.teamId_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public TeamMember getUser() {
        TeamMember teamMember = this.user_;
        return teamMember == null ? TeamMember.getDefaultInstance() : teamMember;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoinOrBuilder
    public boolean hasUser() {
        return this.user_ != null;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.gametype_.isEmpty()) {
            codedOutputStream.b(1, getGametype());
        }
        if (!this.teamId_.isEmpty()) {
            codedOutputStream.b(2, getTeamId());
        }
        if (this.user_ != null) {
            codedOutputStream.b(3, getUser());
        }
        int i = this.regionId_;
        if (i != 0) {
            codedOutputStream.d(4, i);
        }
        if (this.dispUrl_.isEmpty()) {
            return;
        }
        codedOutputStream.b(6, getDispUrl());
    }

    public static Builder newBuilder(TeamJoin teamJoin) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamJoin);
    }

    public static TeamJoin parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamJoin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamJoin parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamJoin parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(TeamMember.Builder builder) {
        this.user_ = builder.build();
    }

    public static TeamJoin parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamJoin parseFrom(InputStream inputStream) throws IOException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamJoin parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamJoin parseFrom(C2301g c2301g) throws IOException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamJoin parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamJoin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
