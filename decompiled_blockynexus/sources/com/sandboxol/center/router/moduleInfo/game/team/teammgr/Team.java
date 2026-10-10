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
public final class Team extends GeneratedMessageLite<Team, Builder> implements TeamOrBuilder {
    public static final int CAPTAINID_FIELD_NUMBER = 1;
    public static final int CAPTAINNAME_FIELD_NUMBER = 2;
    private static final Team DEFAULT_INSTANCE = new Team();
    public static final int LV_FIELD_NUMBER = 3;
    public static final int MAX_FIELD_NUMBER = 4;
    public static final int NUM_FIELD_NUMBER = 5;
    private static volatile A<Team> PARSER = null;
    public static final int PICURL_FIELD_NUMBER = 6;
    public static final int TEAMID_FIELD_NUMBER = 7;
    private long captainid_;
    private int lv_;
    private int max_;
    private int num_;
    private String captainname_ = "";
    private String picurl_ = "";
    private String teamId_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.Team$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<Team, Builder> implements TeamOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCaptainid() {
            copyOnWrite();
            ((Team) this.instance).clearCaptainid();
            return this;
        }

        public Builder clearCaptainname() {
            copyOnWrite();
            ((Team) this.instance).clearCaptainname();
            return this;
        }

        public Builder clearLv() {
            copyOnWrite();
            ((Team) this.instance).clearLv();
            return this;
        }

        public Builder clearMax() {
            copyOnWrite();
            ((Team) this.instance).clearMax();
            return this;
        }

        public Builder clearNum() {
            copyOnWrite();
            ((Team) this.instance).clearNum();
            return this;
        }

        public Builder clearPicurl() {
            copyOnWrite();
            ((Team) this.instance).clearPicurl();
            return this;
        }

        public Builder clearTeamId() {
            copyOnWrite();
            ((Team) this.instance).clearTeamId();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public long getCaptainid() {
            return ((Team) this.instance).getCaptainid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public String getCaptainname() {
            return ((Team) this.instance).getCaptainname();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public ByteString getCaptainnameBytes() {
            return ((Team) this.instance).getCaptainnameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public int getLv() {
            return ((Team) this.instance).getLv();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public int getMax() {
            return ((Team) this.instance).getMax();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public int getNum() {
            return ((Team) this.instance).getNum();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public String getPicurl() {
            return ((Team) this.instance).getPicurl();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public ByteString getPicurlBytes() {
            return ((Team) this.instance).getPicurlBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public String getTeamId() {
            return ((Team) this.instance).getTeamId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
        public ByteString getTeamIdBytes() {
            return ((Team) this.instance).getTeamIdBytes();
        }

        public Builder setCaptainid(long j) {
            copyOnWrite();
            ((Team) this.instance).setCaptainid(j);
            return this;
        }

        public Builder setCaptainname(String str) {
            copyOnWrite();
            ((Team) this.instance).setCaptainname(str);
            return this;
        }

        public Builder setCaptainnameBytes(ByteString byteString) {
            copyOnWrite();
            ((Team) this.instance).setCaptainnameBytes(byteString);
            return this;
        }

        public Builder setLv(int i) {
            copyOnWrite();
            ((Team) this.instance).setLv(i);
            return this;
        }

        public Builder setMax(int i) {
            copyOnWrite();
            ((Team) this.instance).setMax(i);
            return this;
        }

        public Builder setNum(int i) {
            copyOnWrite();
            ((Team) this.instance).setNum(i);
            return this;
        }

        public Builder setPicurl(String str) {
            copyOnWrite();
            ((Team) this.instance).setPicurl(str);
            return this;
        }

        public Builder setPicurlBytes(ByteString byteString) {
            copyOnWrite();
            ((Team) this.instance).setPicurlBytes(byteString);
            return this;
        }

        public Builder setTeamId(String str) {
            copyOnWrite();
            ((Team) this.instance).setTeamId(str);
            return this;
        }

        public Builder setTeamIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Team) this.instance).setTeamIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(Team.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private Team() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainid() {
        this.captainid_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainname() {
        this.captainname_ = getDefaultInstance().getCaptainname();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLv() {
        this.lv_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMax() {
        this.max_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNum() {
        this.num_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPicurl() {
        this.picurl_ = getDefaultInstance().getPicurl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamId() {
        this.teamId_ = getDefaultInstance().getTeamId();
    }

    public static Team getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Team parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Team) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Team parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<Team> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainid(long j) {
        this.captainid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainname(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.captainname_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainnameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.captainname_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLv(int i) {
        this.lv_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMax(int i) {
        this.max_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNum(int i) {
        this.num_ = i;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Team();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                Team team = (Team) obj2;
                this.captainid_ = iVar.a(this.captainid_ != 0, this.captainid_, team.captainid_ != 0, team.captainid_);
                this.captainname_ = iVar.a(!this.captainname_.isEmpty(), this.captainname_, !team.captainname_.isEmpty(), team.captainname_);
                this.lv_ = iVar.a(this.lv_ != 0, this.lv_, team.lv_ != 0, team.lv_);
                this.max_ = iVar.a(this.max_ != 0, this.max_, team.max_ != 0, team.max_);
                this.num_ = iVar.a(this.num_ != 0, this.num_, team.num_ != 0, team.num_);
                this.picurl_ = iVar.a(!this.picurl_.isEmpty(), this.picurl_, !team.picurl_.isEmpty(), team.picurl_);
                this.teamId_ = iVar.a(!this.teamId_.isEmpty(), this.teamId_, !team.teamId_.isEmpty(), team.teamId_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 8) {
                                this.captainid_ = c2301g.r();
                            } else if (iQ == 18) {
                                this.captainname_ = c2301g.p();
                            } else if (iQ == 24) {
                                this.lv_ = c2301g.h();
                            } else if (iQ == 32) {
                                this.max_ = c2301g.h();
                            } else if (iQ == 40) {
                                this.num_ = c2301g.h();
                            } else if (iQ == 50) {
                                this.picurl_ = c2301g.p();
                            } else if (iQ == 58) {
                                this.teamId_ = c2301g.p();
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
                    synchronized (Team.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public long getCaptainid() {
        return this.captainid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public String getCaptainname() {
        return this.captainname_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public ByteString getCaptainnameBytes() {
        return ByteString.copyFromUtf8(this.captainname_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public int getLv() {
        return this.lv_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public int getMax() {
        return this.max_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public int getNum() {
        return this.num_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public String getPicurl() {
        return this.picurl_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public ByteString getPicurlBytes() {
        return ByteString.copyFromUtf8(this.picurl_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        long j = this.captainid_;
        int iB = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        if (!this.captainname_.isEmpty()) {
            iB += CodedOutputStream.a(2, getCaptainname());
        }
        int i2 = this.lv_;
        if (i2 != 0) {
            iB += CodedOutputStream.b(3, i2);
        }
        int i3 = this.max_;
        if (i3 != 0) {
            iB += CodedOutputStream.b(4, i3);
        }
        int i4 = this.num_;
        if (i4 != 0) {
            iB += CodedOutputStream.b(5, i4);
        }
        if (!this.picurl_.isEmpty()) {
            iB += CodedOutputStream.a(6, getPicurl());
        }
        if (!this.teamId_.isEmpty()) {
            iB += CodedOutputStream.a(7, getTeamId());
        }
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public String getTeamId() {
        return this.teamId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamOrBuilder
    public ByteString getTeamIdBytes() {
        return ByteString.copyFromUtf8(this.teamId_);
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.captainid_;
        if (j != 0) {
            codedOutputStream.d(1, j);
        }
        if (!this.captainname_.isEmpty()) {
            codedOutputStream.b(2, getCaptainname());
        }
        int i = this.lv_;
        if (i != 0) {
            codedOutputStream.d(3, i);
        }
        int i2 = this.max_;
        if (i2 != 0) {
            codedOutputStream.d(4, i2);
        }
        int i3 = this.num_;
        if (i3 != 0) {
            codedOutputStream.d(5, i3);
        }
        if (!this.picurl_.isEmpty()) {
            codedOutputStream.b(6, getPicurl());
        }
        if (this.teamId_.isEmpty()) {
            return;
        }
        codedOutputStream.b(7, getTeamId());
    }

    public static Builder newBuilder(Team team) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(team);
    }

    public static Team parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (Team) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static Team parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static Team parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Team parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static Team parseFrom(InputStream inputStream) throws IOException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Team parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static Team parseFrom(C2301g c2301g) throws IOException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static Team parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
