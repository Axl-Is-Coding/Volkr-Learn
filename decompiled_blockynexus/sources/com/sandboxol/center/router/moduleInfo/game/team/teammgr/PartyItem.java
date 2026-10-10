package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.AbstractC2295a;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PartyItem extends GeneratedMessageLite<PartyItem, Builder> implements PartyItemOrBuilder {
    public static final int CAPTAINID_FIELD_NUMBER = 1;
    public static final int CAPTAINNAME_FIELD_NUMBER = 2;
    public static final int CAPTAINPICURL_FIELD_NUMBER = 3;
    public static final int CAPTAINVIP_FIELD_NUMBER = 4;
    public static final int CHATGROUPID_FIELD_NUMBER = 13;
    public static final int CUR_FIELD_NUMBER = 5;
    private static final PartyItem DEFAULT_INSTANCE = new PartyItem();
    public static final int GAMENAME_FIELD_NUMBER = 10;
    public static final int GAMETYPE_FIELD_NUMBER = 9;
    public static final int ISNEWENGINE_FIELD_NUMBER = 16;
    public static final int LANG_FIELD_NUMBER = 17;
    public static final int MAX_FIELD_NUMBER = 6;
    private static volatile A<PartyItem> PARSER = null;
    public static final int PSID_FIELD_NUMBER = 14;
    public static final int TEAMCOUNT_FIELD_NUMBER = 11;
    public static final int TEAMID_FIELD_NUMBER = 7;
    public static final int TEAMMEMBERCOUNT_FIELD_NUMBER = 12;
    public static final int TEAMMEMBERS_FIELD_NUMBER = 18;
    public static final int TEAMTYPE_FIELD_NUMBER = 15;
    public static final int TITLE_FIELD_NUMBER = 8;
    private int bitField0_;
    private long captainId_;
    private int captainVip_;
    private int cur_;
    private boolean isNewEngine_;
    private int max_;
    private int teamCount_;
    private int teamMemberCount_;
    private int teamType_;
    private String captainName_ = "";
    private String captainPicUrl_ = "";
    private String teamId_ = "";
    private String title_ = "";
    private String gameType_ = "";
    private String gameName_ = "";
    private String chatGroupId_ = "";
    private String psid_ = "";
    private String lang_ = "";
    private r.h<TeamMember> teamMembers_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<PartyItem, Builder> implements PartyItemOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTeamMembers(Iterable<? extends TeamMember> iterable) {
            copyOnWrite();
            ((PartyItem) this.instance).addAllTeamMembers(iterable);
            return this;
        }

        public Builder addTeamMembers(TeamMember teamMember) {
            copyOnWrite();
            ((PartyItem) this.instance).addTeamMembers(teamMember);
            return this;
        }

        public Builder clearCaptainId() {
            copyOnWrite();
            ((PartyItem) this.instance).clearCaptainId();
            return this;
        }

        public Builder clearCaptainName() {
            copyOnWrite();
            ((PartyItem) this.instance).clearCaptainName();
            return this;
        }

        public Builder clearCaptainPicUrl() {
            copyOnWrite();
            ((PartyItem) this.instance).clearCaptainPicUrl();
            return this;
        }

        public Builder clearCaptainVip() {
            copyOnWrite();
            ((PartyItem) this.instance).clearCaptainVip();
            return this;
        }

        public Builder clearChatGroupId() {
            copyOnWrite();
            ((PartyItem) this.instance).clearChatGroupId();
            return this;
        }

        public Builder clearCur() {
            copyOnWrite();
            ((PartyItem) this.instance).clearCur();
            return this;
        }

        public Builder clearGameName() {
            copyOnWrite();
            ((PartyItem) this.instance).clearGameName();
            return this;
        }

        public Builder clearGameType() {
            copyOnWrite();
            ((PartyItem) this.instance).clearGameType();
            return this;
        }

        public Builder clearIsNewEngine() {
            copyOnWrite();
            ((PartyItem) this.instance).clearIsNewEngine();
            return this;
        }

        public Builder clearLang() {
            copyOnWrite();
            ((PartyItem) this.instance).clearLang();
            return this;
        }

        public Builder clearMax() {
            copyOnWrite();
            ((PartyItem) this.instance).clearMax();
            return this;
        }

        public Builder clearPsid() {
            copyOnWrite();
            ((PartyItem) this.instance).clearPsid();
            return this;
        }

        public Builder clearTeamCount() {
            copyOnWrite();
            ((PartyItem) this.instance).clearTeamCount();
            return this;
        }

        public Builder clearTeamId() {
            copyOnWrite();
            ((PartyItem) this.instance).clearTeamId();
            return this;
        }

        public Builder clearTeamMemberCount() {
            copyOnWrite();
            ((PartyItem) this.instance).clearTeamMemberCount();
            return this;
        }

        public Builder clearTeamMembers() {
            copyOnWrite();
            ((PartyItem) this.instance).clearTeamMembers();
            return this;
        }

        public Builder clearTeamType() {
            copyOnWrite();
            ((PartyItem) this.instance).clearTeamType();
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            ((PartyItem) this.instance).clearTitle();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public long getCaptainId() {
            return ((PartyItem) this.instance).getCaptainId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getCaptainName() {
            return ((PartyItem) this.instance).getCaptainName();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getCaptainNameBytes() {
            return ((PartyItem) this.instance).getCaptainNameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getCaptainPicUrl() {
            return ((PartyItem) this.instance).getCaptainPicUrl();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getCaptainPicUrlBytes() {
            return ((PartyItem) this.instance).getCaptainPicUrlBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public int getCaptainVip() {
            return ((PartyItem) this.instance).getCaptainVip();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getChatGroupId() {
            return ((PartyItem) this.instance).getChatGroupId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getChatGroupIdBytes() {
            return ((PartyItem) this.instance).getChatGroupIdBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public int getCur() {
            return ((PartyItem) this.instance).getCur();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getGameName() {
            return ((PartyItem) this.instance).getGameName();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getGameNameBytes() {
            return ((PartyItem) this.instance).getGameNameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getGameType() {
            return ((PartyItem) this.instance).getGameType();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getGameTypeBytes() {
            return ((PartyItem) this.instance).getGameTypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public boolean getIsNewEngine() {
            return ((PartyItem) this.instance).getIsNewEngine();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getLang() {
            return ((PartyItem) this.instance).getLang();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getLangBytes() {
            return ((PartyItem) this.instance).getLangBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public int getMax() {
            return ((PartyItem) this.instance).getMax();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getPsid() {
            return ((PartyItem) this.instance).getPsid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getPsidBytes() {
            return ((PartyItem) this.instance).getPsidBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public int getTeamCount() {
            return ((PartyItem) this.instance).getTeamCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getTeamId() {
            return ((PartyItem) this.instance).getTeamId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getTeamIdBytes() {
            return ((PartyItem) this.instance).getTeamIdBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public int getTeamMemberCount() {
            return ((PartyItem) this.instance).getTeamMemberCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public TeamMember getTeamMembers(int i) {
            return ((PartyItem) this.instance).getTeamMembers(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public int getTeamMembersCount() {
            return ((PartyItem) this.instance).getTeamMembersCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public List<TeamMember> getTeamMembersList() {
            return Collections.unmodifiableList(((PartyItem) this.instance).getTeamMembersList());
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public TeamType getTeamType() {
            return ((PartyItem) this.instance).getTeamType();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public int getTeamTypeValue() {
            return ((PartyItem) this.instance).getTeamTypeValue();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public String getTitle() {
            return ((PartyItem) this.instance).getTitle();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
        public ByteString getTitleBytes() {
            return ((PartyItem) this.instance).getTitleBytes();
        }

        public Builder removeTeamMembers(int i) {
            copyOnWrite();
            ((PartyItem) this.instance).removeTeamMembers(i);
            return this;
        }

        public Builder setCaptainId(long j) {
            copyOnWrite();
            ((PartyItem) this.instance).setCaptainId(j);
            return this;
        }

        public Builder setCaptainName(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setCaptainName(str);
            return this;
        }

        public Builder setCaptainNameBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setCaptainNameBytes(byteString);
            return this;
        }

        public Builder setCaptainPicUrl(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setCaptainPicUrl(str);
            return this;
        }

        public Builder setCaptainPicUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setCaptainPicUrlBytes(byteString);
            return this;
        }

        public Builder setCaptainVip(int i) {
            copyOnWrite();
            ((PartyItem) this.instance).setCaptainVip(i);
            return this;
        }

        public Builder setChatGroupId(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setChatGroupId(str);
            return this;
        }

        public Builder setChatGroupIdBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setChatGroupIdBytes(byteString);
            return this;
        }

        public Builder setCur(int i) {
            copyOnWrite();
            ((PartyItem) this.instance).setCur(i);
            return this;
        }

        public Builder setGameName(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setGameName(str);
            return this;
        }

        public Builder setGameNameBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setGameNameBytes(byteString);
            return this;
        }

        public Builder setGameType(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setGameType(str);
            return this;
        }

        public Builder setGameTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setGameTypeBytes(byteString);
            return this;
        }

        public Builder setIsNewEngine(boolean z) {
            copyOnWrite();
            ((PartyItem) this.instance).setIsNewEngine(z);
            return this;
        }

        public Builder setLang(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setLang(str);
            return this;
        }

        public Builder setLangBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setLangBytes(byteString);
            return this;
        }

        public Builder setMax(int i) {
            copyOnWrite();
            ((PartyItem) this.instance).setMax(i);
            return this;
        }

        public Builder setPsid(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setPsid(str);
            return this;
        }

        public Builder setPsidBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setPsidBytes(byteString);
            return this;
        }

        public Builder setTeamCount(int i) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamCount(i);
            return this;
        }

        public Builder setTeamId(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamId(str);
            return this;
        }

        public Builder setTeamIdBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamIdBytes(byteString);
            return this;
        }

        public Builder setTeamMemberCount(int i) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamMemberCount(i);
            return this;
        }

        public Builder setTeamMembers(int i, TeamMember teamMember) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamMembers(i, teamMember);
            return this;
        }

        public Builder setTeamType(TeamType teamType) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamType(teamType);
            return this;
        }

        public Builder setTeamTypeValue(int i) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamTypeValue(i);
            return this;
        }

        public Builder setTitle(String str) {
            copyOnWrite();
            ((PartyItem) this.instance).setTitle(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyItem) this.instance).setTitleBytes(byteString);
            return this;
        }

        private Builder() {
            super(PartyItem.DEFAULT_INSTANCE);
        }

        public Builder addTeamMembers(int i, TeamMember teamMember) {
            copyOnWrite();
            ((PartyItem) this.instance).addTeamMembers(i, teamMember);
            return this;
        }

        public Builder setTeamMembers(int i, TeamMember.Builder builder) {
            copyOnWrite();
            ((PartyItem) this.instance).setTeamMembers(i, builder);
            return this;
        }

        public Builder addTeamMembers(TeamMember.Builder builder) {
            copyOnWrite();
            ((PartyItem) this.instance).addTeamMembers(builder);
            return this;
        }

        public Builder addTeamMembers(int i, TeamMember.Builder builder) {
            copyOnWrite();
            ((PartyItem) this.instance).addTeamMembers(i, builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private PartyItem() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTeamMembers(Iterable<? extends TeamMember> iterable) {
        ensureTeamMembersIsMutable();
        AbstractC2295a.addAll(iterable, this.teamMembers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeamMembers(TeamMember teamMember) {
        if (teamMember == null) {
            throw new NullPointerException();
        }
        ensureTeamMembersIsMutable();
        this.teamMembers_.add(teamMember);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainId() {
        this.captainId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainName() {
        this.captainName_ = getDefaultInstance().getCaptainName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainPicUrl() {
        this.captainPicUrl_ = getDefaultInstance().getCaptainPicUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainVip() {
        this.captainVip_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChatGroupId() {
        this.chatGroupId_ = getDefaultInstance().getChatGroupId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCur() {
        this.cur_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGameName() {
        this.gameName_ = getDefaultInstance().getGameName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGameType() {
        this.gameType_ = getDefaultInstance().getGameType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsNewEngine() {
        this.isNewEngine_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLang() {
        this.lang_ = getDefaultInstance().getLang();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMax() {
        this.max_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPsid() {
        this.psid_ = getDefaultInstance().getPsid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamCount() {
        this.teamCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamId() {
        this.teamId_ = getDefaultInstance().getTeamId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamMemberCount() {
        this.teamMemberCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamMembers() {
        this.teamMembers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamType() {
        this.teamType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void ensureTeamMembersIsMutable() {
        if (this.teamMembers_.d()) {
            return;
        }
        this.teamMembers_ = GeneratedMessageLite.mutableCopy(this.teamMembers_);
    }

    public static PartyItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PartyItem parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PartyItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PartyItem parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<PartyItem> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTeamMembers(int i) {
        ensureTeamMembersIsMutable();
        this.teamMembers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainId(long j) {
        this.captainId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.captainName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.captainName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainPicUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.captainPicUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainPicUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.captainPicUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainVip(int i) {
        this.captainVip_ = i;
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
    public void setCur(int i) {
        this.cur_ = i;
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
    public void setGameType(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.gameType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGameTypeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.gameType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsNewEngine(boolean z) {
        this.isNewEngine_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLang(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.lang_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLangBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.lang_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMax(int i) {
        this.max_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPsid(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.psid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPsidBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.psid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamCount(int i) {
        this.teamCount_ = i;
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
    public void setTeamMemberCount(int i) {
        this.teamMemberCount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamMembers(int i, TeamMember teamMember) {
        if (teamMember == null) {
            throw new NullPointerException();
        }
        ensureTeamMembersIsMutable();
        this.teamMembers_.set(i, teamMember);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PartyItem();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.teamMembers_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                PartyItem partyItem = (PartyItem) obj2;
                this.captainId_ = iVar.a(this.captainId_ != 0, this.captainId_, partyItem.captainId_ != 0, partyItem.captainId_);
                this.captainName_ = iVar.a(!this.captainName_.isEmpty(), this.captainName_, !partyItem.captainName_.isEmpty(), partyItem.captainName_);
                this.captainPicUrl_ = iVar.a(!this.captainPicUrl_.isEmpty(), this.captainPicUrl_, !partyItem.captainPicUrl_.isEmpty(), partyItem.captainPicUrl_);
                this.captainVip_ = iVar.a(this.captainVip_ != 0, this.captainVip_, partyItem.captainVip_ != 0, partyItem.captainVip_);
                this.cur_ = iVar.a(this.cur_ != 0, this.cur_, partyItem.cur_ != 0, partyItem.cur_);
                this.max_ = iVar.a(this.max_ != 0, this.max_, partyItem.max_ != 0, partyItem.max_);
                this.teamId_ = iVar.a(!this.teamId_.isEmpty(), this.teamId_, !partyItem.teamId_.isEmpty(), partyItem.teamId_);
                this.title_ = iVar.a(!this.title_.isEmpty(), this.title_, !partyItem.title_.isEmpty(), partyItem.title_);
                this.gameType_ = iVar.a(!this.gameType_.isEmpty(), this.gameType_, !partyItem.gameType_.isEmpty(), partyItem.gameType_);
                this.gameName_ = iVar.a(!this.gameName_.isEmpty(), this.gameName_, !partyItem.gameName_.isEmpty(), partyItem.gameName_);
                this.teamCount_ = iVar.a(this.teamCount_ != 0, this.teamCount_, partyItem.teamCount_ != 0, partyItem.teamCount_);
                this.teamMemberCount_ = iVar.a(this.teamMemberCount_ != 0, this.teamMemberCount_, partyItem.teamMemberCount_ != 0, partyItem.teamMemberCount_);
                this.chatGroupId_ = iVar.a(!this.chatGroupId_.isEmpty(), this.chatGroupId_, !partyItem.chatGroupId_.isEmpty(), partyItem.chatGroupId_);
                this.psid_ = iVar.a(!this.psid_.isEmpty(), this.psid_, !partyItem.psid_.isEmpty(), partyItem.psid_);
                this.teamType_ = iVar.a(this.teamType_ != 0, this.teamType_, partyItem.teamType_ != 0, partyItem.teamType_);
                boolean z = this.isNewEngine_;
                boolean z2 = partyItem.isNewEngine_;
                this.isNewEngine_ = iVar.a(z, z, z2, z2);
                this.lang_ = iVar.a(!this.lang_.isEmpty(), this.lang_, !partyItem.lang_.isEmpty(), partyItem.lang_);
                this.teamMembers_ = iVar.a(this.teamMembers_, partyItem.teamMembers_);
                if (iVar == GeneratedMessageLite.h.f14297a) {
                    this.bitField0_ |= partyItem.bitField0_;
                }
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                C2306l c2306l = (C2306l) obj2;
                while (!z) {
                    try {
                        try {
                            int iQ = c2301g.q();
                            switch (iQ) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.captainId_ = c2301g.r();
                                    break;
                                case 18:
                                    this.captainName_ = c2301g.p();
                                    break;
                                case 26:
                                    this.captainPicUrl_ = c2301g.p();
                                    break;
                                case 32:
                                    this.captainVip_ = c2301g.h();
                                    break;
                                case 40:
                                    this.cur_ = c2301g.h();
                                    break;
                                case 48:
                                    this.max_ = c2301g.h();
                                    break;
                                case 58:
                                    this.teamId_ = c2301g.p();
                                    break;
                                case 66:
                                    this.title_ = c2301g.p();
                                    break;
                                case 74:
                                    this.gameType_ = c2301g.p();
                                    break;
                                case 82:
                                    this.gameName_ = c2301g.p();
                                    break;
                                case 88:
                                    this.teamCount_ = c2301g.h();
                                    break;
                                case 96:
                                    this.teamMemberCount_ = c2301g.h();
                                    break;
                                case 106:
                                    this.chatGroupId_ = c2301g.p();
                                    break;
                                case 114:
                                    this.psid_ = c2301g.p();
                                    break;
                                case 120:
                                    this.teamType_ = c2301g.e();
                                    break;
                                case 128:
                                    this.isNewEngine_ = c2301g.c();
                                    break;
                                case 138:
                                    this.lang_ = c2301g.p();
                                    break;
                                case 146:
                                    if (!this.teamMembers_.d()) {
                                        this.teamMembers_ = GeneratedMessageLite.mutableCopy(this.teamMembers_);
                                    }
                                    this.teamMembers_.add((TeamMember) c2301g.a(TeamMember.parser(), c2306l));
                                    break;
                                default:
                                    if (!c2301g.e(iQ)) {
                                        z = true;
                                    }
                                    break;
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw new RuntimeException(e3.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (PartyItem.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public long getCaptainId() {
        return this.captainId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getCaptainName() {
        return this.captainName_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getCaptainNameBytes() {
        return ByteString.copyFromUtf8(this.captainName_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getCaptainPicUrl() {
        return this.captainPicUrl_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getCaptainPicUrlBytes() {
        return ByteString.copyFromUtf8(this.captainPicUrl_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public int getCaptainVip() {
        return this.captainVip_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getChatGroupId() {
        return this.chatGroupId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getChatGroupIdBytes() {
        return ByteString.copyFromUtf8(this.chatGroupId_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public int getCur() {
        return this.cur_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getGameName() {
        return this.gameName_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getGameNameBytes() {
        return ByteString.copyFromUtf8(this.gameName_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getGameType() {
        return this.gameType_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getGameTypeBytes() {
        return ByteString.copyFromUtf8(this.gameType_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public boolean getIsNewEngine() {
        return this.isNewEngine_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getLang() {
        return this.lang_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getLangBytes() {
        return ByteString.copyFromUtf8(this.lang_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public int getMax() {
        return this.max_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getPsid() {
        return this.psid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getPsidBytes() {
        return ByteString.copyFromUtf8(this.psid_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        long j = this.captainId_;
        int iB = j != 0 ? CodedOutputStream.b(1, j) + 0 : 0;
        if (!this.captainName_.isEmpty()) {
            iB += CodedOutputStream.a(2, getCaptainName());
        }
        if (!this.captainPicUrl_.isEmpty()) {
            iB += CodedOutputStream.a(3, getCaptainPicUrl());
        }
        int i2 = this.captainVip_;
        if (i2 != 0) {
            iB += CodedOutputStream.b(4, i2);
        }
        int i3 = this.cur_;
        if (i3 != 0) {
            iB += CodedOutputStream.b(5, i3);
        }
        int i4 = this.max_;
        if (i4 != 0) {
            iB += CodedOutputStream.b(6, i4);
        }
        if (!this.teamId_.isEmpty()) {
            iB += CodedOutputStream.a(7, getTeamId());
        }
        if (!this.title_.isEmpty()) {
            iB += CodedOutputStream.a(8, getTitle());
        }
        if (!this.gameType_.isEmpty()) {
            iB += CodedOutputStream.a(9, getGameType());
        }
        if (!this.gameName_.isEmpty()) {
            iB += CodedOutputStream.a(10, getGameName());
        }
        int i5 = this.teamCount_;
        if (i5 != 0) {
            iB += CodedOutputStream.b(11, i5);
        }
        int i6 = this.teamMemberCount_;
        if (i6 != 0) {
            iB += CodedOutputStream.b(12, i6);
        }
        if (!this.chatGroupId_.isEmpty()) {
            iB += CodedOutputStream.a(13, getChatGroupId());
        }
        if (!this.psid_.isEmpty()) {
            iB += CodedOutputStream.a(14, getPsid());
        }
        if (this.teamType_ != TeamType.NONE.getNumber()) {
            iB += CodedOutputStream.a(15, this.teamType_);
        }
        boolean z = this.isNewEngine_;
        if (z) {
            iB += CodedOutputStream.a(16, z);
        }
        if (!this.lang_.isEmpty()) {
            iB += CodedOutputStream.a(17, getLang());
        }
        for (int i7 = 0; i7 < this.teamMembers_.size(); i7++) {
            iB += CodedOutputStream.a(18, this.teamMembers_.get(i7));
        }
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public int getTeamCount() {
        return this.teamCount_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getTeamId() {
        return this.teamId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getTeamIdBytes() {
        return ByteString.copyFromUtf8(this.teamId_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public int getTeamMemberCount() {
        return this.teamMemberCount_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public TeamMember getTeamMembers(int i) {
        return this.teamMembers_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public int getTeamMembersCount() {
        return this.teamMembers_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public List<TeamMember> getTeamMembersList() {
        return this.teamMembers_;
    }

    public TeamMemberOrBuilder getTeamMembersOrBuilder(int i) {
        return this.teamMembers_.get(i);
    }

    public List<? extends TeamMemberOrBuilder> getTeamMembersOrBuilderList() {
        return this.teamMembers_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public TeamType getTeamType() {
        TeamType teamTypeForNumber = TeamType.forNumber(this.teamType_);
        return teamTypeForNumber == null ? TeamType.UNRECOGNIZED : teamTypeForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public int getTeamTypeValue() {
        return this.teamType_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItemOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.captainId_;
        if (j != 0) {
            codedOutputStream.d(1, j);
        }
        if (!this.captainName_.isEmpty()) {
            codedOutputStream.b(2, getCaptainName());
        }
        if (!this.captainPicUrl_.isEmpty()) {
            codedOutputStream.b(3, getCaptainPicUrl());
        }
        int i = this.captainVip_;
        if (i != 0) {
            codedOutputStream.d(4, i);
        }
        int i2 = this.cur_;
        if (i2 != 0) {
            codedOutputStream.d(5, i2);
        }
        int i3 = this.max_;
        if (i3 != 0) {
            codedOutputStream.d(6, i3);
        }
        if (!this.teamId_.isEmpty()) {
            codedOutputStream.b(7, getTeamId());
        }
        if (!this.title_.isEmpty()) {
            codedOutputStream.b(8, getTitle());
        }
        if (!this.gameType_.isEmpty()) {
            codedOutputStream.b(9, getGameType());
        }
        if (!this.gameName_.isEmpty()) {
            codedOutputStream.b(10, getGameName());
        }
        int i4 = this.teamCount_;
        if (i4 != 0) {
            codedOutputStream.d(11, i4);
        }
        int i5 = this.teamMemberCount_;
        if (i5 != 0) {
            codedOutputStream.d(12, i5);
        }
        if (!this.chatGroupId_.isEmpty()) {
            codedOutputStream.b(13, getChatGroupId());
        }
        if (!this.psid_.isEmpty()) {
            codedOutputStream.b(14, getPsid());
        }
        if (this.teamType_ != TeamType.NONE.getNumber()) {
            codedOutputStream.c(15, this.teamType_);
        }
        boolean z = this.isNewEngine_;
        if (z) {
            codedOutputStream.b(16, z);
        }
        if (!this.lang_.isEmpty()) {
            codedOutputStream.b(17, getLang());
        }
        for (int i6 = 0; i6 < this.teamMembers_.size(); i6++) {
            codedOutputStream.b(18, this.teamMembers_.get(i6));
        }
    }

    public static Builder newBuilder(PartyItem partyItem) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(partyItem);
    }

    public static PartyItem parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (PartyItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static PartyItem parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static PartyItem parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeamMembers(int i, TeamMember teamMember) {
        if (teamMember != null) {
            ensureTeamMembersIsMutable();
            this.teamMembers_.add(i, teamMember);
            return;
        }
        throw new NullPointerException();
    }

    public static PartyItem parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamMembers(int i, TeamMember.Builder builder) {
        ensureTeamMembersIsMutable();
        this.teamMembers_.set(i, builder.build());
    }

    public static PartyItem parseFrom(InputStream inputStream) throws IOException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PartyItem parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeamMembers(TeamMember.Builder builder) {
        ensureTeamMembersIsMutable();
        this.teamMembers_.add(builder.build());
    }

    public static PartyItem parseFrom(C2301g c2301g) throws IOException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static PartyItem parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (PartyItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeamMembers(int i, TeamMember.Builder builder) {
        ensureTeamMembersIsMutable();
        this.teamMembers_.add(i, builder.build());
    }
}
