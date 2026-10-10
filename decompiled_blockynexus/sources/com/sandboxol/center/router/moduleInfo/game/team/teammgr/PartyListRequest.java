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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PartyListRequest extends GeneratedMessageLite<PartyListRequest, Builder> implements PartyListRequestOrBuilder {
    private static final PartyListRequest DEFAULT_INSTANCE = new PartyListRequest();
    public static final int ENGINEVERSIONS_FIELD_NUMBER = 2;
    public static final int GAMETYPE_FIELD_NUMBER = 1;
    public static final int LANG_FIELD_NUMBER = 6;
    public static final int NOJOIN_FIELD_NUMBER = 11;
    private static volatile A<PartyListRequest> PARSER = null;
    public static final int REGIONID_FIELD_NUMBER = 4;
    public static final int REQUESTTYPE_FIELD_NUMBER = 9;
    public static final int SELECTGAMETYPE_FIELD_NUMBER = 10;
    public static final int SELECTLANG_FIELD_NUMBER = 7;
    public static final int SIZE_FIELD_NUMBER = 3;
    public static final int TEAMTYPE_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 8;
    private int bitField0_;
    private int regionId_;
    private int requestType_;
    private int size_;
    private int teamType_;
    private int version_;
    private String gameType_ = "";
    private r.f engineVersions_ = GeneratedMessageLite.emptyIntList();
    private String lang_ = "";
    private String selectLang_ = "";
    private String selectGameType_ = "";
    private r.h<String> noJoin_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<PartyListRequest, Builder> implements PartyListRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllEngineVersions(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((PartyListRequest) this.instance).addAllEngineVersions(iterable);
            return this;
        }

        public Builder addAllNoJoin(Iterable<String> iterable) {
            copyOnWrite();
            ((PartyListRequest) this.instance).addAllNoJoin(iterable);
            return this;
        }

        public Builder addEngineVersions(int i) {
            copyOnWrite();
            ((PartyListRequest) this.instance).addEngineVersions(i);
            return this;
        }

        public Builder addNoJoin(String str) {
            copyOnWrite();
            ((PartyListRequest) this.instance).addNoJoin(str);
            return this;
        }

        public Builder addNoJoinBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyListRequest) this.instance).addNoJoinBytes(byteString);
            return this;
        }

        public Builder clearEngineVersions() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearEngineVersions();
            return this;
        }

        public Builder clearGameType() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearGameType();
            return this;
        }

        public Builder clearLang() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearLang();
            return this;
        }

        public Builder clearNoJoin() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearNoJoin();
            return this;
        }

        public Builder clearRegionId() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearRegionId();
            return this;
        }

        public Builder clearRequestType() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearRequestType();
            return this;
        }

        public Builder clearSelectGameType() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearSelectGameType();
            return this;
        }

        public Builder clearSelectLang() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearSelectLang();
            return this;
        }

        public Builder clearSize() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearSize();
            return this;
        }

        public Builder clearTeamType() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearTeamType();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((PartyListRequest) this.instance).clearVersion();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getEngineVersions(int i) {
            return ((PartyListRequest) this.instance).getEngineVersions(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getEngineVersionsCount() {
            return ((PartyListRequest) this.instance).getEngineVersionsCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public List<Integer> getEngineVersionsList() {
            return Collections.unmodifiableList(((PartyListRequest) this.instance).getEngineVersionsList());
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public String getGameType() {
            return ((PartyListRequest) this.instance).getGameType();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public ByteString getGameTypeBytes() {
            return ((PartyListRequest) this.instance).getGameTypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public String getLang() {
            return ((PartyListRequest) this.instance).getLang();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public ByteString getLangBytes() {
            return ((PartyListRequest) this.instance).getLangBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public String getNoJoin(int i) {
            return ((PartyListRequest) this.instance).getNoJoin(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public ByteString getNoJoinBytes(int i) {
            return ((PartyListRequest) this.instance).getNoJoinBytes(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getNoJoinCount() {
            return ((PartyListRequest) this.instance).getNoJoinCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public List<String> getNoJoinList() {
            return Collections.unmodifiableList(((PartyListRequest) this.instance).getNoJoinList());
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getRegionId() {
            return ((PartyListRequest) this.instance).getRegionId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public RequestType getRequestType() {
            return ((PartyListRequest) this.instance).getRequestType();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getRequestTypeValue() {
            return ((PartyListRequest) this.instance).getRequestTypeValue();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public String getSelectGameType() {
            return ((PartyListRequest) this.instance).getSelectGameType();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public ByteString getSelectGameTypeBytes() {
            return ((PartyListRequest) this.instance).getSelectGameTypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public String getSelectLang() {
            return ((PartyListRequest) this.instance).getSelectLang();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public ByteString getSelectLangBytes() {
            return ((PartyListRequest) this.instance).getSelectLangBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getSize() {
            return ((PartyListRequest) this.instance).getSize();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public TeamType getTeamType() {
            return ((PartyListRequest) this.instance).getTeamType();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getTeamTypeValue() {
            return ((PartyListRequest) this.instance).getTeamTypeValue();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public VersionType getVersion() {
            return ((PartyListRequest) this.instance).getVersion();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
        public int getVersionValue() {
            return ((PartyListRequest) this.instance).getVersionValue();
        }

        public Builder setEngineVersions(int i, int i2) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setEngineVersions(i, i2);
            return this;
        }

        public Builder setGameType(String str) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setGameType(str);
            return this;
        }

        public Builder setGameTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setGameTypeBytes(byteString);
            return this;
        }

        public Builder setLang(String str) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setLang(str);
            return this;
        }

        public Builder setLangBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setLangBytes(byteString);
            return this;
        }

        public Builder setNoJoin(int i, String str) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setNoJoin(i, str);
            return this;
        }

        public Builder setRegionId(int i) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setRegionId(i);
            return this;
        }

        public Builder setRequestType(RequestType requestType) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setRequestType(requestType);
            return this;
        }

        public Builder setRequestTypeValue(int i) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setRequestTypeValue(i);
            return this;
        }

        public Builder setSelectGameType(String str) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setSelectGameType(str);
            return this;
        }

        public Builder setSelectGameTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setSelectGameTypeBytes(byteString);
            return this;
        }

        public Builder setSelectLang(String str) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setSelectLang(str);
            return this;
        }

        public Builder setSelectLangBytes(ByteString byteString) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setSelectLangBytes(byteString);
            return this;
        }

        public Builder setSize(int i) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setSize(i);
            return this;
        }

        public Builder setTeamType(TeamType teamType) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setTeamType(teamType);
            return this;
        }

        public Builder setTeamTypeValue(int i) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setTeamTypeValue(i);
            return this;
        }

        public Builder setVersion(VersionType versionType) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setVersion(versionType);
            return this;
        }

        public Builder setVersionValue(int i) {
            copyOnWrite();
            ((PartyListRequest) this.instance).setVersionValue(i);
            return this;
        }

        private Builder() {
            super(PartyListRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private PartyListRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEngineVersions(Iterable<? extends Integer> iterable) {
        ensureEngineVersionsIsMutable();
        AbstractC2295a.addAll(iterable, this.engineVersions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllNoJoin(Iterable<String> iterable) {
        ensureNoJoinIsMutable();
        AbstractC2295a.addAll(iterable, this.noJoin_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEngineVersions(int i) {
        ensureEngineVersionsIsMutable();
        this.engineVersions_.b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNoJoin(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureNoJoinIsMutable();
        this.noJoin_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNoJoinBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        ensureNoJoinIsMutable();
        this.noJoin_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEngineVersions() {
        this.engineVersions_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGameType() {
        this.gameType_ = getDefaultInstance().getGameType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLang() {
        this.lang_ = getDefaultInstance().getLang();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNoJoin() {
        this.noJoin_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegionId() {
        this.regionId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestType() {
        this.requestType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelectGameType() {
        this.selectGameType_ = getDefaultInstance().getSelectGameType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelectLang() {
        this.selectLang_ = getDefaultInstance().getSelectLang();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSize() {
        this.size_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamType() {
        this.teamType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    private void ensureEngineVersionsIsMutable() {
        if (this.engineVersions_.d()) {
            return;
        }
        this.engineVersions_ = GeneratedMessageLite.mutableCopy(this.engineVersions_);
    }

    private void ensureNoJoinIsMutable() {
        if (this.noJoin_.d()) {
            return;
        }
        this.noJoin_ = GeneratedMessageLite.mutableCopy(this.noJoin_);
    }

    public static PartyListRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PartyListRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PartyListRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PartyListRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<PartyListRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEngineVersions(int i, int i2) {
        ensureEngineVersionsIsMutable();
        this.engineVersions_.setInt(i, i2);
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
    public void setNoJoin(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureNoJoinIsMutable();
        this.noJoin_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionId(int i) {
        this.regionId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestType(RequestType requestType) {
        if (requestType == null) {
            throw new NullPointerException();
        }
        this.requestType_ = requestType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestTypeValue(int i) {
        this.requestType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectGameType(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.selectGameType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectGameTypeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.selectGameType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectLang(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.selectLang_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectLangBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.selectLang_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(int i) {
        this.size_ = i;
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
                return new PartyListRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.engineVersions_.b();
                this.noJoin_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                PartyListRequest partyListRequest = (PartyListRequest) obj2;
                this.gameType_ = iVar.a(!this.gameType_.isEmpty(), this.gameType_, !partyListRequest.gameType_.isEmpty(), partyListRequest.gameType_);
                this.engineVersions_ = iVar.a(this.engineVersions_, partyListRequest.engineVersions_);
                this.size_ = iVar.a(this.size_ != 0, this.size_, partyListRequest.size_ != 0, partyListRequest.size_);
                this.regionId_ = iVar.a(this.regionId_ != 0, this.regionId_, partyListRequest.regionId_ != 0, partyListRequest.regionId_);
                this.teamType_ = iVar.a(this.teamType_ != 0, this.teamType_, partyListRequest.teamType_ != 0, partyListRequest.teamType_);
                this.lang_ = iVar.a(!this.lang_.isEmpty(), this.lang_, !partyListRequest.lang_.isEmpty(), partyListRequest.lang_);
                this.selectLang_ = iVar.a(!this.selectLang_.isEmpty(), this.selectLang_, !partyListRequest.selectLang_.isEmpty(), partyListRequest.selectLang_);
                this.version_ = iVar.a(this.version_ != 0, this.version_, partyListRequest.version_ != 0, partyListRequest.version_);
                this.requestType_ = iVar.a(this.requestType_ != 0, this.requestType_, partyListRequest.requestType_ != 0, partyListRequest.requestType_);
                this.selectGameType_ = iVar.a(!this.selectGameType_.isEmpty(), this.selectGameType_, !partyListRequest.selectGameType_.isEmpty(), partyListRequest.selectGameType_);
                this.noJoin_ = iVar.a(this.noJoin_, partyListRequest.noJoin_);
                if (iVar == GeneratedMessageLite.h.f14297a) {
                    this.bitField0_ |= partyListRequest.bitField0_;
                }
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
                                case 10:
                                    this.gameType_ = c2301g.p();
                                    break;
                                case 16:
                                    if (!this.engineVersions_.d()) {
                                        this.engineVersions_ = GeneratedMessageLite.mutableCopy(this.engineVersions_);
                                    }
                                    this.engineVersions_.b(c2301g.h());
                                    break;
                                case 18:
                                    int iC = c2301g.c(c2301g.m());
                                    if (!this.engineVersions_.d() && c2301g.a() > 0) {
                                        this.engineVersions_ = GeneratedMessageLite.mutableCopy(this.engineVersions_);
                                    }
                                    while (c2301g.a() > 0) {
                                        this.engineVersions_.b(c2301g.h());
                                    }
                                    c2301g.b(iC);
                                    break;
                                case 24:
                                    this.size_ = c2301g.h();
                                    break;
                                case 32:
                                    this.regionId_ = c2301g.h();
                                    break;
                                case 40:
                                    this.teamType_ = c2301g.e();
                                    break;
                                case 50:
                                    this.lang_ = c2301g.p();
                                    break;
                                case 58:
                                    this.selectLang_ = c2301g.p();
                                    break;
                                case 64:
                                    this.version_ = c2301g.e();
                                    break;
                                case 72:
                                    this.requestType_ = c2301g.e();
                                    break;
                                case 82:
                                    this.selectGameType_ = c2301g.p();
                                    break;
                                case 90:
                                    String strP = c2301g.p();
                                    if (!this.noJoin_.d()) {
                                        this.noJoin_ = GeneratedMessageLite.mutableCopy(this.noJoin_);
                                    }
                                    this.noJoin_.add(strP);
                                    break;
                                default:
                                    if (!c2301g.e(iQ)) {
                                        z = true;
                                    }
                                    break;
                            }
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
                    synchronized (PartyListRequest.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getEngineVersions(int i) {
        return this.engineVersions_.getInt(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getEngineVersionsCount() {
        return this.engineVersions_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public List<Integer> getEngineVersionsList() {
        return this.engineVersions_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public String getGameType() {
        return this.gameType_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public ByteString getGameTypeBytes() {
        return ByteString.copyFromUtf8(this.gameType_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public String getLang() {
        return this.lang_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public ByteString getLangBytes() {
        return ByteString.copyFromUtf8(this.lang_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public String getNoJoin(int i) {
        return this.noJoin_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public ByteString getNoJoinBytes(int i) {
        return ByteString.copyFromUtf8(this.noJoin_.get(i));
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getNoJoinCount() {
        return this.noJoin_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public List<String> getNoJoinList() {
        return this.noJoin_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getRegionId() {
        return this.regionId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public RequestType getRequestType() {
        RequestType requestTypeForNumber = RequestType.forNumber(this.requestType_);
        return requestTypeForNumber == null ? RequestType.UNRECOGNIZED : requestTypeForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getRequestTypeValue() {
        return this.requestType_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public String getSelectGameType() {
        return this.selectGameType_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public ByteString getSelectGameTypeBytes() {
        return ByteString.copyFromUtf8(this.selectGameType_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public String getSelectLang() {
        return this.selectLang_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public ByteString getSelectLangBytes() {
        return ByteString.copyFromUtf8(this.selectLang_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = !this.gameType_.isEmpty() ? CodedOutputStream.a(1, getGameType()) + 0 : 0;
        int iB = 0;
        for (int i2 = 0; i2 < this.engineVersions_.size(); i2++) {
            iB += CodedOutputStream.b(this.engineVersions_.getInt(i2));
        }
        int size = iA + iB + (getEngineVersionsList().size() * 1);
        int i3 = this.size_;
        if (i3 != 0) {
            size += CodedOutputStream.b(3, i3);
        }
        int i4 = this.regionId_;
        if (i4 != 0) {
            size += CodedOutputStream.b(4, i4);
        }
        if (this.teamType_ != TeamType.NONE.getNumber()) {
            size += CodedOutputStream.a(5, this.teamType_);
        }
        if (!this.lang_.isEmpty()) {
            size += CodedOutputStream.a(6, getLang());
        }
        if (!this.selectLang_.isEmpty()) {
            size += CodedOutputStream.a(7, getSelectLang());
        }
        if (this.version_ != VersionType.VERSION_ZERO.getNumber()) {
            size += CodedOutputStream.a(8, this.version_);
        }
        if (this.requestType_ != RequestType.LIST.getNumber()) {
            size += CodedOutputStream.a(9, this.requestType_);
        }
        if (!this.selectGameType_.isEmpty()) {
            size += CodedOutputStream.a(10, getSelectGameType());
        }
        int iA2 = 0;
        for (int i5 = 0; i5 < this.noJoin_.size(); i5++) {
            iA2 += CodedOutputStream.a(this.noJoin_.get(i5));
        }
        int size2 = size + iA2 + (getNoJoinList().size() * 1);
        this.memoizedSerializedSize = size2;
        return size2;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getSize() {
        return this.size_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public TeamType getTeamType() {
        TeamType teamTypeForNumber = TeamType.forNumber(this.teamType_);
        return teamTypeForNumber == null ? TeamType.UNRECOGNIZED : teamTypeForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getTeamTypeValue() {
        return this.teamType_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public VersionType getVersion() {
        VersionType versionTypeForNumber = VersionType.forNumber(this.version_);
        return versionTypeForNumber == null ? VersionType.UNRECOGNIZED : versionTypeForNumber;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequestOrBuilder
    public int getVersionValue() {
        return this.version_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if (!this.gameType_.isEmpty()) {
            codedOutputStream.b(1, getGameType());
        }
        for (int i = 0; i < this.engineVersions_.size(); i++) {
            codedOutputStream.d(2, this.engineVersions_.getInt(i));
        }
        int i2 = this.size_;
        if (i2 != 0) {
            codedOutputStream.d(3, i2);
        }
        int i3 = this.regionId_;
        if (i3 != 0) {
            codedOutputStream.d(4, i3);
        }
        if (this.teamType_ != TeamType.NONE.getNumber()) {
            codedOutputStream.c(5, this.teamType_);
        }
        if (!this.lang_.isEmpty()) {
            codedOutputStream.b(6, getLang());
        }
        if (!this.selectLang_.isEmpty()) {
            codedOutputStream.b(7, getSelectLang());
        }
        if (this.version_ != VersionType.VERSION_ZERO.getNumber()) {
            codedOutputStream.c(8, this.version_);
        }
        if (this.requestType_ != RequestType.LIST.getNumber()) {
            codedOutputStream.c(9, this.requestType_);
        }
        if (!this.selectGameType_.isEmpty()) {
            codedOutputStream.b(10, getSelectGameType());
        }
        for (int i4 = 0; i4 < this.noJoin_.size(); i4++) {
            codedOutputStream.b(11, this.noJoin_.get(i4));
        }
    }

    public static Builder newBuilder(PartyListRequest partyListRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(partyListRequest);
    }

    public static PartyListRequest parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (PartyListRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static PartyListRequest parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static PartyListRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PartyListRequest parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static PartyListRequest parseFrom(InputStream inputStream) throws IOException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PartyListRequest parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static PartyListRequest parseFrom(C2301g c2301g) throws IOException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static PartyListRequest parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (PartyListRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
