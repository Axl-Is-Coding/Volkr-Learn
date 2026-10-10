package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.AbstractC2295a;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class TeamMember extends GeneratedMessageLite<TeamMember, Builder> implements TeamMemberOrBuilder {
    public static final int APPVERSION_FIELD_NUMBER = 8;
    public static final int COUNTRY_FIELD_NUMBER = 9;
    private static final TeamMember DEFAULT_INSTANCE = new TeamMember();
    public static final int LANG_FIELD_NUMBER = 10;
    public static final int PACKAGENAME_FIELD_NUMBER = 7;
    private static volatile A<TeamMember> PARSER = null;
    public static final int PICURL_FIELD_NUMBER = 5;
    public static final int POSITION_FIELD_NUMBER = 6;
    public static final int SEX_FIELD_NUMBER = 13;
    public static final int STATUS_FIELD_NUMBER = 12;
    public static final int USERID_FIELD_NUMBER = 1;
    public static final int USERNAME_FIELD_NUMBER = 2;
    public static final int VIP_FIELD_NUMBER = 11;
    private int position_;
    private int sex_;
    private int status_;
    private long userid_;
    private int vip_;
    private String username_ = "";
    private String picurl_ = "";
    private String packageName_ = "";
    private String appVersion_ = "";
    private String country_ = "";
    private String lang_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamMember, Builder> implements TeamMemberOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAppVersion() {
            copyOnWrite();
            ((TeamMember) this.instance).clearAppVersion();
            return this;
        }

        public Builder clearCountry() {
            copyOnWrite();
            ((TeamMember) this.instance).clearCountry();
            return this;
        }

        public Builder clearLang() {
            copyOnWrite();
            ((TeamMember) this.instance).clearLang();
            return this;
        }

        public Builder clearPackageName() {
            copyOnWrite();
            ((TeamMember) this.instance).clearPackageName();
            return this;
        }

        public Builder clearPicurl() {
            copyOnWrite();
            ((TeamMember) this.instance).clearPicurl();
            return this;
        }

        public Builder clearPosition() {
            copyOnWrite();
            ((TeamMember) this.instance).clearPosition();
            return this;
        }

        public Builder clearSex() {
            copyOnWrite();
            ((TeamMember) this.instance).clearSex();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((TeamMember) this.instance).clearStatus();
            return this;
        }

        public Builder clearUserid() {
            copyOnWrite();
            ((TeamMember) this.instance).clearUserid();
            return this;
        }

        public Builder clearUsername() {
            copyOnWrite();
            ((TeamMember) this.instance).clearUsername();
            return this;
        }

        public Builder clearVip() {
            copyOnWrite();
            ((TeamMember) this.instance).clearVip();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public String getAppVersion() {
            return ((TeamMember) this.instance).getAppVersion();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public ByteString getAppVersionBytes() {
            return ((TeamMember) this.instance).getAppVersionBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public String getCountry() {
            return ((TeamMember) this.instance).getCountry();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public ByteString getCountryBytes() {
            return ((TeamMember) this.instance).getCountryBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public String getLang() {
            return ((TeamMember) this.instance).getLang();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public ByteString getLangBytes() {
            return ((TeamMember) this.instance).getLangBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public String getPackageName() {
            return ((TeamMember) this.instance).getPackageName();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public ByteString getPackageNameBytes() {
            return ((TeamMember) this.instance).getPackageNameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public String getPicurl() {
            return ((TeamMember) this.instance).getPicurl();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public ByteString getPicurlBytes() {
            return ((TeamMember) this.instance).getPicurlBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public int getPosition() {
            return ((TeamMember) this.instance).getPosition();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public int getSex() {
            return ((TeamMember) this.instance).getSex();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public MemberStatusType getStatus() {
            return ((TeamMember) this.instance).getStatus();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public int getStatusValue() {
            return ((TeamMember) this.instance).getStatusValue();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public long getUserid() {
            return ((TeamMember) this.instance).getUserid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public String getUsername() {
            return ((TeamMember) this.instance).getUsername();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public ByteString getUsernameBytes() {
            return ((TeamMember) this.instance).getUsernameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
        public int getVip() {
            return ((TeamMember) this.instance).getVip();
        }

        public Builder setAppVersion(String str) {
            copyOnWrite();
            ((TeamMember) this.instance).setAppVersion(str);
            return this;
        }

        public Builder setAppVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamMember) this.instance).setAppVersionBytes(byteString);
            return this;
        }

        public Builder setCountry(String str) {
            copyOnWrite();
            ((TeamMember) this.instance).setCountry(str);
            return this;
        }

        public Builder setCountryBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamMember) this.instance).setCountryBytes(byteString);
            return this;
        }

        public Builder setLang(String str) {
            copyOnWrite();
            ((TeamMember) this.instance).setLang(str);
            return this;
        }

        public Builder setLangBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamMember) this.instance).setLangBytes(byteString);
            return this;
        }

        public Builder setPackageName(String str) {
            copyOnWrite();
            ((TeamMember) this.instance).setPackageName(str);
            return this;
        }

        public Builder setPackageNameBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamMember) this.instance).setPackageNameBytes(byteString);
            return this;
        }

        public Builder setPicurl(String str) {
            copyOnWrite();
            ((TeamMember) this.instance).setPicurl(str);
            return this;
        }

        public Builder setPicurlBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamMember) this.instance).setPicurlBytes(byteString);
            return this;
        }

        public Builder setPosition(int i) {
            copyOnWrite();
            ((TeamMember) this.instance).setPosition(i);
            return this;
        }

        public Builder setSex(int i) {
            copyOnWrite();
            ((TeamMember) this.instance).setSex(i);
            return this;
        }

        public Builder setStatus(MemberStatusType memberStatusType) {
            copyOnWrite();
            ((TeamMember) this.instance).setStatus(memberStatusType);
            return this;
        }

        public Builder setStatusValue(int i) {
            copyOnWrite();
            ((TeamMember) this.instance).setStatusValue(i);
            return this;
        }

        public Builder setUserid(long j) {
            copyOnWrite();
            ((TeamMember) this.instance).setUserid(j);
            return this;
        }

        public Builder setUsername(String str) {
            copyOnWrite();
            ((TeamMember) this.instance).setUsername(str);
            return this;
        }

        public Builder setUsernameBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamMember) this.instance).setUsernameBytes(byteString);
            return this;
        }

        public Builder setVip(int i) {
            copyOnWrite();
            ((TeamMember) this.instance).setVip(i);
            return this;
        }

        private Builder() {
            super(TeamMember.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamMember() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppVersion() {
        this.appVersion_ = getDefaultInstance().getAppVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCountry() {
        this.country_ = getDefaultInstance().getCountry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLang() {
        this.lang_ = getDefaultInstance().getLang();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPackageName() {
        this.packageName_ = getDefaultInstance().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPicurl() {
        this.picurl_ = getDefaultInstance().getPicurl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPosition() {
        this.position_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSex() {
        this.sex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserid() {
        this.userid_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsername() {
        this.username_ = getDefaultInstance().getUsername();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVip() {
        this.vip_ = 0;
    }

    public static TeamMember getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamMember parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamMember) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamMember parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamMember> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppVersion(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.appVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppVersionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.appVersion_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountry(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.country_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountryBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.country_ = byteString.toStringUtf8();
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
    public void setPackageName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.packageName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.packageName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPicurl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.picurl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPicurlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.picurl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPosition(int i) {
        this.position_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSex(int i) {
        this.sex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(MemberStatusType memberStatusType) {
        if (memberStatusType == null) {
            throw new NullPointerException();
        }
        this.status_ = memberStatusType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i) {
        this.status_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserid(long j) {
        this.userid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsername(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.username_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsernameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.username_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVip(int i) {
        this.vip_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamMember();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamMember teamMember = (TeamMember) obj2;
                this.userid_ = iVar.a(this.userid_ != 0, this.userid_, teamMember.userid_ != 0, teamMember.userid_);
                this.username_ = iVar.a(!this.username_.isEmpty(), this.username_, !teamMember.username_.isEmpty(), teamMember.username_);
                this.picurl_ = iVar.a(!this.picurl_.isEmpty(), this.picurl_, !teamMember.picurl_.isEmpty(), teamMember.picurl_);
                this.position_ = iVar.a(this.position_ != 0, this.position_, teamMember.position_ != 0, teamMember.position_);
                this.packageName_ = iVar.a(!this.packageName_.isEmpty(), this.packageName_, !teamMember.packageName_.isEmpty(), teamMember.packageName_);
                this.appVersion_ = iVar.a(!this.appVersion_.isEmpty(), this.appVersion_, !teamMember.appVersion_.isEmpty(), teamMember.appVersion_);
                this.country_ = iVar.a(!this.country_.isEmpty(), this.country_, !teamMember.country_.isEmpty(), teamMember.country_);
                this.lang_ = iVar.a(!this.lang_.isEmpty(), this.lang_, !teamMember.lang_.isEmpty(), teamMember.lang_);
                this.vip_ = iVar.a(this.vip_ != 0, this.vip_, teamMember.vip_ != 0, teamMember.vip_);
                this.status_ = iVar.a(this.status_ != 0, this.status_, teamMember.status_ != 0, teamMember.status_);
                this.sex_ = iVar.a(this.sex_ != 0, this.sex_, teamMember.sex_ != 0, teamMember.sex_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        try {
                            int iQ = c2301g.q();
                            switch (iQ) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.userid_ = c2301g.r();
                                    break;
                                case 18:
                                    this.username_ = c2301g.p();
                                    break;
                                case 42:
                                    this.picurl_ = c2301g.p();
                                    break;
                                case 48:
                                    this.position_ = c2301g.h();
                                    break;
                                case 58:
                                    this.packageName_ = c2301g.p();
                                    break;
                                case 66:
                                    this.appVersion_ = c2301g.p();
                                    break;
                                case 74:
                                    this.country_ = c2301g.p();
                                    break;
                                case 82:
                                    this.lang_ = c2301g.p();
                                    break;
                                case 88:
                                    this.vip_ = c2301g.h();
                                    break;
                                case 96:
                                    this.status_ = c2301g.e();
                                    break;
                                case 104:
                                    this.sex_ = c2301g.h();
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
                    synchronized (TeamMember.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public String getAppVersion() {
        return this.appVersion_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public ByteString getAppVersionBytes() {
        return ByteString.copyFromUtf8(this.appVersion_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public String getCountry() {
        return this.country_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public ByteString getCountryBytes() {
        return ByteString.copyFromUtf8(this.country_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public String getLang() {
        return this.lang_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public ByteString getLangBytes() {
        return ByteString.copyFromUtf8(this.lang_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public String getPackageName() {
        return this.packageName_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public ByteString getPackageNameBytes() {
        return ByteString.copyFromUtf8(this.packageName_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public String getPicurl() {
        return this.picurl_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public ByteString getPicurlBytes() {
        return ByteString.copyFromUtf8(this.picurl_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public int getPosition() {
        return this.position_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        long j = this.userid_;
        int iB = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        if (!this.username_.isEmpty()) {
            iB += CodedOutputStream.a(2, getUsername());
        }
        if (!this.picurl_.isEmpty()) {
            iB += CodedOutputStream.a(5, getPicurl());
        }
        int i2 = this.position_;
        if (i2 != 0) {
            iB += CodedOutputStream.b(6, i2);
        }
        if (!this.packageName_.isEmpty()) {
            iB += CodedOutputStream.a(7, getPackageName());
        }
        if (!this.appVersion_.isEmpty()) {
            iB += CodedOutputStream.a(8, getAppVersion());
        }
        if (!this.country_.isEmpty()) {
            iB += CodedOutputStream.a(9, getCountry());
        }
        if (!this.lang_.isEmpty()) {
            iB += CodedOutputStream.a(10, getLang());
        }
        int i3 = this.vip_;
        if (i3 != 0) {
            iB += CodedOutputStream.b(11, i3);
        }
        if (this.status_ != MemberStatusType.MEMBER_STATUS_PREPARING.getNumber()) {
            iB += CodedOutputStream.a(12, this.status_);
        }
        int i4 = this.sex_;
        if (i4 != 0) {
            iB += CodedOutputStream.b(13, i4);
        }
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public int getSex() {
        return this.sex_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public MemberStatusType getStatus() {
        MemberStatusType memberStatusTypeForNumber = MemberStatusType.forNumber(this.status_);
        return memberStatusTypeForNumber == null ? MemberStatusType.UNRECOGNIZED : memberStatusTypeForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public int getStatusValue() {
        return this.status_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public long getUserid() {
        return this.userid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public String getUsername() {
        return this.username_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public ByteString getUsernameBytes() {
        return ByteString.copyFromUtf8(this.username_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMemberOrBuilder
    public int getVip() {
        return this.vip_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.userid_;
        if (j != 0) {
            codedOutputStream.d(1, j);
        }
        if (!this.username_.isEmpty()) {
            codedOutputStream.b(2, getUsername());
        }
        if (!this.picurl_.isEmpty()) {
            codedOutputStream.b(5, getPicurl());
        }
        int i = this.position_;
        if (i != 0) {
            codedOutputStream.d(6, i);
        }
        if (!this.packageName_.isEmpty()) {
            codedOutputStream.b(7, getPackageName());
        }
        if (!this.appVersion_.isEmpty()) {
            codedOutputStream.b(8, getAppVersion());
        }
        if (!this.country_.isEmpty()) {
            codedOutputStream.b(9, getCountry());
        }
        if (!this.lang_.isEmpty()) {
            codedOutputStream.b(10, getLang());
        }
        int i2 = this.vip_;
        if (i2 != 0) {
            codedOutputStream.d(11, i2);
        }
        if (this.status_ != MemberStatusType.MEMBER_STATUS_PREPARING.getNumber()) {
            codedOutputStream.c(12, this.status_);
        }
        int i3 = this.sex_;
        if (i3 != 0) {
            codedOutputStream.d(13, i3);
        }
    }

    public static Builder newBuilder(TeamMember teamMember) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamMember);
    }

    public static TeamMember parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamMember) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamMember parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamMember parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamMember parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamMember parseFrom(InputStream inputStream) throws IOException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamMember parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamMember parseFrom(C2301g c2301g) throws IOException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamMember parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
