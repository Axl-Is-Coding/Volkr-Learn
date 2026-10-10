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
public final class TeamCreate extends GeneratedMessageLite<TeamCreate, Builder> implements TeamCreateOrBuilder {
    public static final int CAPTAIN_FIELD_NUMBER = 2;
    public static final int CHATGROUPID_FIELD_NUMBER = 12;
    private static final TeamCreate DEFAULT_INSTANCE = new TeamCreate();
    public static final int DISPURL_FIELD_NUMBER = 5;
    public static final int ENGINEVERSION_FIELD_NUMBER = 4;
    public static final int GAMENAME_FIELD_NUMBER = 7;
    public static final int GAMETYPE_FIELD_NUMBER = 1;
    public static final int ISNEWENGINE_FIELD_NUMBER = 13;
    public static final int MAXMEMBERS_FIELD_NUMBER = 9;
    private static volatile A<TeamCreate> PARSER = null;
    public static final int REGIONID_FIELD_NUMBER = 3;
    public static final int TEAMCOUNT_FIELD_NUMBER = 10;
    public static final int TEAMMEMBERCOUNT_FIELD_NUMBER = 11;
    public static final int TEAMTYPE_FIELD_NUMBER = 8;
    public static final int TITLE_FIELD_NUMBER = 6;
    public static final int VERSION_FIELD_NUMBER = 14;
    private TeamMember captain_;
    private int engineVersion_;
    private boolean isNewEngine_;
    private int maxMembers_;
    private int regionId_;
    private int teamCount_;
    private int teamMemberCount_;
    private int teamType_;
    private int version_;
    private String gametype_ = "";
    private String dispUrl_ = "";
    private String title_ = "";
    private String gameName_ = "";
    private String chatGroupId_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreate$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamCreate, Builder> implements TeamCreateOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCaptain() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearCaptain();
            return this;
        }

        public Builder clearChatGroupId() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearChatGroupId();
            return this;
        }

        public Builder clearDispUrl() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearDispUrl();
            return this;
        }

        public Builder clearEngineVersion() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearEngineVersion();
            return this;
        }

        public Builder clearGameName() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearGameName();
            return this;
        }

        public Builder clearGametype() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearGametype();
            return this;
        }

        public Builder clearIsNewEngine() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearIsNewEngine();
            return this;
        }

        public Builder clearMaxMembers() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearMaxMembers();
            return this;
        }

        public Builder clearRegionId() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearRegionId();
            return this;
        }

        public Builder clearTeamCount() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearTeamCount();
            return this;
        }

        public Builder clearTeamMemberCount() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearTeamMemberCount();
            return this;
        }

        public Builder clearTeamType() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearTeamType();
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearTitle();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((TeamCreate) this.instance).clearVersion();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public TeamMember getCaptain() {
            return ((TeamCreate) this.instance).getCaptain();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public String getChatGroupId() {
            return ((TeamCreate) this.instance).getChatGroupId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public ByteString getChatGroupIdBytes() {
            return ((TeamCreate) this.instance).getChatGroupIdBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public String getDispUrl() {
            return ((TeamCreate) this.instance).getDispUrl();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public ByteString getDispUrlBytes() {
            return ((TeamCreate) this.instance).getDispUrlBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public int getEngineVersion() {
            return ((TeamCreate) this.instance).getEngineVersion();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public String getGameName() {
            return ((TeamCreate) this.instance).getGameName();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public ByteString getGameNameBytes() {
            return ((TeamCreate) this.instance).getGameNameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public String getGametype() {
            return ((TeamCreate) this.instance).getGametype();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public ByteString getGametypeBytes() {
            return ((TeamCreate) this.instance).getGametypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public boolean getIsNewEngine() {
            return ((TeamCreate) this.instance).getIsNewEngine();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public int getMaxMembers() {
            return ((TeamCreate) this.instance).getMaxMembers();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public int getRegionId() {
            return ((TeamCreate) this.instance).getRegionId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public int getTeamCount() {
            return ((TeamCreate) this.instance).getTeamCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public int getTeamMemberCount() {
            return ((TeamCreate) this.instance).getTeamMemberCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public TeamType getTeamType() {
            return ((TeamCreate) this.instance).getTeamType();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public int getTeamTypeValue() {
            return ((TeamCreate) this.instance).getTeamTypeValue();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public String getTitle() {
            return ((TeamCreate) this.instance).getTitle();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public ByteString getTitleBytes() {
            return ((TeamCreate) this.instance).getTitleBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public VersionType getVersion() {
            return ((TeamCreate) this.instance).getVersion();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public int getVersionValue() {
            return ((TeamCreate) this.instance).getVersionValue();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
        public boolean hasCaptain() {
            return ((TeamCreate) this.instance).hasCaptain();
        }

        public Builder mergeCaptain(TeamMember teamMember) {
            copyOnWrite();
            ((TeamCreate) this.instance).mergeCaptain(teamMember);
            return this;
        }

        public Builder setCaptain(TeamMember teamMember) {
            copyOnWrite();
            ((TeamCreate) this.instance).setCaptain(teamMember);
            return this;
        }

        public Builder setChatGroupId(String str) {
            copyOnWrite();
            ((TeamCreate) this.instance).setChatGroupId(str);
            return this;
        }

        public Builder setChatGroupIdBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamCreate) this.instance).setChatGroupIdBytes(byteString);
            return this;
        }

        public Builder setDispUrl(String str) {
            copyOnWrite();
            ((TeamCreate) this.instance).setDispUrl(str);
            return this;
        }

        public Builder setDispUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamCreate) this.instance).setDispUrlBytes(byteString);
            return this;
        }

        public Builder setEngineVersion(int i) {
            copyOnWrite();
            ((TeamCreate) this.instance).setEngineVersion(i);
            return this;
        }

        public Builder setGameName(String str) {
            copyOnWrite();
            ((TeamCreate) this.instance).setGameName(str);
            return this;
        }

        public Builder setGameNameBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamCreate) this.instance).setGameNameBytes(byteString);
            return this;
        }

        public Builder setGametype(String str) {
            copyOnWrite();
            ((TeamCreate) this.instance).setGametype(str);
            return this;
        }

        public Builder setGametypeBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamCreate) this.instance).setGametypeBytes(byteString);
            return this;
        }

        public Builder setIsNewEngine(boolean z) {
            copyOnWrite();
            ((TeamCreate) this.instance).setIsNewEngine(z);
            return this;
        }

        public Builder setMaxMembers(int i) {
            copyOnWrite();
            ((TeamCreate) this.instance).setMaxMembers(i);
            return this;
        }

        public Builder setRegionId(int i) {
            copyOnWrite();
            ((TeamCreate) this.instance).setRegionId(i);
            return this;
        }

        public Builder setTeamCount(int i) {
            copyOnWrite();
            ((TeamCreate) this.instance).setTeamCount(i);
            return this;
        }

        public Builder setTeamMemberCount(int i) {
            copyOnWrite();
            ((TeamCreate) this.instance).setTeamMemberCount(i);
            return this;
        }

        public Builder setTeamType(TeamType teamType) {
            copyOnWrite();
            ((TeamCreate) this.instance).setTeamType(teamType);
            return this;
        }

        public Builder setTeamTypeValue(int i) {
            copyOnWrite();
            ((TeamCreate) this.instance).setTeamTypeValue(i);
            return this;
        }

        public Builder setTitle(String str) {
            copyOnWrite();
            ((TeamCreate) this.instance).setTitle(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamCreate) this.instance).setTitleBytes(byteString);
            return this;
        }

        public Builder setVersion(VersionType versionType) {
            copyOnWrite();
            ((TeamCreate) this.instance).setVersion(versionType);
            return this;
        }

        public Builder setVersionValue(int i) {
            copyOnWrite();
            ((TeamCreate) this.instance).setVersionValue(i);
            return this;
        }

        private Builder() {
            super(TeamCreate.DEFAULT_INSTANCE);
        }

        public Builder setCaptain(TeamMember.Builder builder) {
            copyOnWrite();
            ((TeamCreate) this.instance).setCaptain(builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamCreate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptain() {
        this.captain_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChatGroupId() {
        this.chatGroupId_ = getDefaultInstance().getChatGroupId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispUrl() {
        this.dispUrl_ = getDefaultInstance().getDispUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEngineVersion() {
        this.engineVersion_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGameName() {
        this.gameName_ = getDefaultInstance().getGameName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGametype() {
        this.gametype_ = getDefaultInstance().getGametype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsNewEngine() {
        this.isNewEngine_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxMembers() {
        this.maxMembers_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegionId() {
        this.regionId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamCount() {
        this.teamCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamMemberCount() {
        this.teamMemberCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamType() {
        this.teamType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static TeamCreate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCaptain(TeamMember teamMember) {
        TeamMember teamMember2 = this.captain_;
        if (teamMember2 == null || teamMember2 == TeamMember.getDefaultInstance()) {
            this.captain_ = teamMember;
        } else {
            this.captain_ = TeamMember.newBuilder(this.captain_).mergeFrom(teamMember).m64buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamCreate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamCreate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamCreate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamCreate> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptain(TeamMember teamMember) {
        if (teamMember == null) {
            throw new NullPointerException();
        }
        this.captain_ = teamMember;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChatGroupId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.chatGroupId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChatGroupIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.chatGroupId_ = byteString.toStringUtf8();
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
    public void setEngineVersion(int i) {
        this.engineVersion_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGameName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.gameName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGameNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.gameName_ = byteString.toStringUtf8();
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
    public void setIsNewEngine(boolean z) {
        this.isNewEngine_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxMembers(int i) {
        this.maxMembers_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionId(int i) {
        this.regionId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamCount(int i) {
        this.teamCount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamMemberCount(int i) {
        this.teamMemberCount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamType(TeamType teamType) {
        if (teamType == null) {
            throw new NullPointerException();
        }
        this.teamType_ = teamType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamTypeValue(int i) {
        this.teamType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(VersionType versionType) {
        if (versionType == null) {
            throw new NullPointerException();
        }
        this.version_ = versionType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionValue(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamCreate();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamCreate teamCreate = (TeamCreate) obj2;
                this.gametype_ = iVar.a(!this.gametype_.isEmpty(), this.gametype_, !teamCreate.gametype_.isEmpty(), teamCreate.gametype_);
                this.captain_ = (TeamMember) iVar.a(this.captain_, teamCreate.captain_);
                this.regionId_ = iVar.a(this.regionId_ != 0, this.regionId_, teamCreate.regionId_ != 0, teamCreate.regionId_);
                this.engineVersion_ = iVar.a(this.engineVersion_ != 0, this.engineVersion_, teamCreate.engineVersion_ != 0, teamCreate.engineVersion_);
                this.dispUrl_ = iVar.a(!this.dispUrl_.isEmpty(), this.dispUrl_, !teamCreate.dispUrl_.isEmpty(), teamCreate.dispUrl_);
                this.title_ = iVar.a(!this.title_.isEmpty(), this.title_, !teamCreate.title_.isEmpty(), teamCreate.title_);
                this.gameName_ = iVar.a(!this.gameName_.isEmpty(), this.gameName_, !teamCreate.gameName_.isEmpty(), teamCreate.gameName_);
                this.teamType_ = iVar.a(this.teamType_ != 0, this.teamType_, teamCreate.teamType_ != 0, teamCreate.teamType_);
                this.maxMembers_ = iVar.a(this.maxMembers_ != 0, this.maxMembers_, teamCreate.maxMembers_ != 0, teamCreate.maxMembers_);
                this.teamCount_ = iVar.a(this.teamCount_ != 0, this.teamCount_, teamCreate.teamCount_ != 0, teamCreate.teamCount_);
                this.teamMemberCount_ = iVar.a(this.teamMemberCount_ != 0, this.teamMemberCount_, teamCreate.teamMemberCount_ != 0, teamCreate.teamMemberCount_);
                this.chatGroupId_ = iVar.a(!this.chatGroupId_.isEmpty(), this.chatGroupId_, !teamCreate.chatGroupId_.isEmpty(), teamCreate.chatGroupId_);
                boolean z = this.isNewEngine_;
                boolean z2 = teamCreate.isNewEngine_;
                this.isNewEngine_ = iVar.a(z, z, z2, z2);
                this.version_ = iVar.a(this.version_ != 0, this.version_, teamCreate.version_ != 0, teamCreate.version_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                C2306l c2306l = (C2306l) obj2;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        switch (iQ) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                this.gametype_ = c2301g.p();
                                break;
                            case 18:
                                TeamMember.Builder builder = this.captain_ != null ? this.captain_.toBuilder() : null;
                                this.captain_ = (TeamMember) c2301g.a(TeamMember.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom(this.captain_);
                                    this.captain_ = builder.m64buildPartial();
                                }
                                break;
                            case 24:
                                this.regionId_ = c2301g.h();
                                break;
                            case 32:
                                this.engineVersion_ = c2301g.h();
                                break;
                            case 42:
                                this.dispUrl_ = c2301g.p();
                                break;
                            case 50:
                                this.title_ = c2301g.p();
                                break;
                            case 58:
                                this.gameName_ = c2301g.p();
                                break;
                            case 64:
                                this.teamType_ = c2301g.e();
                                break;
                            case 72:
                                this.maxMembers_ = c2301g.h();
                                break;
                            case 80:
                                this.teamCount_ = c2301g.h();
                                break;
                            case 88:
                                this.teamMemberCount_ = c2301g.h();
                                break;
                            case 98:
                                this.chatGroupId_ = c2301g.p();
                                break;
                            case 104:
                                this.isNewEngine_ = c2301g.c();
                                break;
                            case 112:
                                this.version_ = c2301g.e();
                                break;
                            default:
                                if (!c2301g.e(iQ)) {
                                    z = true;
                                }
                                break;
                        }
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
                    synchronized (TeamCreate.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public TeamMember getCaptain() {
        TeamMember teamMember = this.captain_;
        return teamMember == null ? TeamMember.getDefaultInstance() : teamMember;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public String getChatGroupId() {
        return this.chatGroupId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public ByteString getChatGroupIdBytes() {
        return ByteString.copyFromUtf8(this.chatGroupId_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public String getDispUrl() {
        return this.dispUrl_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public ByteString getDispUrlBytes() {
        return ByteString.copyFromUtf8(this.dispUrl_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public int getEngineVersion() {
        return this.engineVersion_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public String getGameName() {
        return this.gameName_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public ByteString getGameNameBytes() {
        return ByteString.copyFromUtf8(this.gameName_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public String getGametype() {
        return this.gametype_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public ByteString getGametypeBytes() {
        return ByteString.copyFromUtf8(this.gametype_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public boolean getIsNewEngine() {
        return this.isNewEngine_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public int getMaxMembers() {
        return this.maxMembers_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
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
        if (this.captain_ != null) {
            iA += CodedOutputStream.a(2, getCaptain());
        }
        int i2 = this.regionId_;
        if (i2 != 0) {
            iA += CodedOutputStream.b(3, i2);
        }
        int i3 = this.engineVersion_;
        if (i3 != 0) {
            iA += CodedOutputStream.b(4, i3);
        }
        if (!this.dispUrl_.isEmpty()) {
            iA += CodedOutputStream.a(5, getDispUrl());
        }
        if (!this.title_.isEmpty()) {
            iA += CodedOutputStream.a(6, getTitle());
        }
        if (!this.gameName_.isEmpty()) {
            iA += CodedOutputStream.a(7, getGameName());
        }
        if (this.teamType_ != TeamType.NONE.getNumber()) {
            iA += CodedOutputStream.a(8, this.teamType_);
        }
        int i4 = this.maxMembers_;
        if (i4 != 0) {
            iA += CodedOutputStream.b(9, i4);
        }
        int i5 = this.teamCount_;
        if (i5 != 0) {
            iA += CodedOutputStream.b(10, i5);
        }
        int i6 = this.teamMemberCount_;
        if (i6 != 0) {
            iA += CodedOutputStream.b(11, i6);
        }
        if (!this.chatGroupId_.isEmpty()) {
            iA += CodedOutputStream.a(12, getChatGroupId());
        }
        boolean z = this.isNewEngine_;
        if (z) {
            iA += CodedOutputStream.a(13, z);
        }
        if (this.version_ != VersionType.VERSION_ZERO.getNumber()) {
            iA += CodedOutputStream.a(14, this.version_);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public int getTeamCount() {
        return this.teamCount_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public int getTeamMemberCount() {
        return this.teamMemberCount_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public TeamType getTeamType() {
        TeamType teamTypeForNumber = TeamType.forNumber(this.teamType_);
        return teamTypeForNumber == null ? TeamType.UNRECOGNIZED : teamTypeForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public int getTeamTypeValue() {
        return this.teamType_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public VersionType getVersion() {
        VersionType versionTypeForNumber = VersionType.forNumber(this.version_);
        return versionTypeForNumber == null ? VersionType.UNRECOGNIZED : versionTypeForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public int getVersionValue() {
        return this.version_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreateOrBuilder
    public boolean hasCaptain() {
        return this.captain_ != null;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.gametype_.isEmpty()) {
            codedOutputStream.b(1, getGametype());
        }
        if (this.captain_ != null) {
            codedOutputStream.b(2, getCaptain());
        }
        int i = this.regionId_;
        if (i != 0) {
            codedOutputStream.d(3, i);
        }
        int i2 = this.engineVersion_;
        if (i2 != 0) {
            codedOutputStream.d(4, i2);
        }
        if (!this.dispUrl_.isEmpty()) {
            codedOutputStream.b(5, getDispUrl());
        }
        if (!this.title_.isEmpty()) {
            codedOutputStream.b(6, getTitle());
        }
        if (!this.gameName_.isEmpty()) {
            codedOutputStream.b(7, getGameName());
        }
        if (this.teamType_ != TeamType.NONE.getNumber()) {
            codedOutputStream.c(8, this.teamType_);
        }
        int i3 = this.maxMembers_;
        if (i3 != 0) {
            codedOutputStream.d(9, i3);
        }
        int i4 = this.teamCount_;
        if (i4 != 0) {
            codedOutputStream.d(10, i4);
        }
        int i5 = this.teamMemberCount_;
        if (i5 != 0) {
            codedOutputStream.d(11, i5);
        }
        if (!this.chatGroupId_.isEmpty()) {
            codedOutputStream.b(12, getChatGroupId());
        }
        boolean z = this.isNewEngine_;
        if (z) {
            codedOutputStream.b(13, z);
        }
        if (this.version_ != VersionType.VERSION_ZERO.getNumber()) {
            codedOutputStream.c(14, this.version_);
        }
    }

    public static Builder newBuilder(TeamCreate teamCreate) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamCreate);
    }

    public static TeamCreate parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamCreate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamCreate parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamCreate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptain(TeamMember.Builder builder) {
        this.captain_ = builder.build();
    }

    public static TeamCreate parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamCreate parseFrom(InputStream inputStream) throws IOException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamCreate parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamCreate parseFrom(C2301g c2301g) throws IOException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamCreate parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamCreate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
