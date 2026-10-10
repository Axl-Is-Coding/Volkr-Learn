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
public final class TeamDone extends GeneratedMessageLite<TeamDone, Builder> implements TeamDoneOrBuilder {
    private static final TeamDone DEFAULT_INSTANCE = new TeamDone();
    public static final int DONE_FIELD_NUMBER = 1;
    public static final int DOWNURL_FIELD_NUMBER = 5;
    public static final int GAMEADDR_FIELD_NUMBER = 2;
    public static final int ISNEWENGINE_FIELD_NUMBER = 9;
    public static final int MID_FIELD_NUMBER = 6;
    public static final int MNAME_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile A<TeamDone> PARSER = null;
    public static final int REGION_FIELD_NUMBER = 7;
    public static final int REQUESTID_FIELD_NUMBER = 10;
    public static final int RESVERSION_FIELD_NUMBER = 8;
    private int done_;
    private boolean isNewEngine_;
    private int region_;
    private int resVersion_;
    private String gameaddr_ = "";
    private String name_ = "";
    private String mname_ = "";
    private String downurl_ = "";
    private String mid_ = "";
    private String requestId_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDone$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamDone, Builder> implements TeamDoneOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDone() {
            copyOnWrite();
            ((TeamDone) this.instance).clearDone();
            return this;
        }

        public Builder clearDownurl() {
            copyOnWrite();
            ((TeamDone) this.instance).clearDownurl();
            return this;
        }

        public Builder clearGameaddr() {
            copyOnWrite();
            ((TeamDone) this.instance).clearGameaddr();
            return this;
        }

        public Builder clearIsNewEngine() {
            copyOnWrite();
            ((TeamDone) this.instance).clearIsNewEngine();
            return this;
        }

        public Builder clearMid() {
            copyOnWrite();
            ((TeamDone) this.instance).clearMid();
            return this;
        }

        public Builder clearMname() {
            copyOnWrite();
            ((TeamDone) this.instance).clearMname();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((TeamDone) this.instance).clearName();
            return this;
        }

        public Builder clearRegion() {
            copyOnWrite();
            ((TeamDone) this.instance).clearRegion();
            return this;
        }

        public Builder clearRequestId() {
            copyOnWrite();
            ((TeamDone) this.instance).clearRequestId();
            return this;
        }

        public Builder clearResVersion() {
            copyOnWrite();
            ((TeamDone) this.instance).clearResVersion();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public int getDone() {
            return ((TeamDone) this.instance).getDone();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public String getDownurl() {
            return ((TeamDone) this.instance).getDownurl();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public ByteString getDownurlBytes() {
            return ((TeamDone) this.instance).getDownurlBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public String getGameaddr() {
            return ((TeamDone) this.instance).getGameaddr();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public ByteString getGameaddrBytes() {
            return ((TeamDone) this.instance).getGameaddrBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public boolean getIsNewEngine() {
            return ((TeamDone) this.instance).getIsNewEngine();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public String getMid() {
            return ((TeamDone) this.instance).getMid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public ByteString getMidBytes() {
            return ((TeamDone) this.instance).getMidBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public String getMname() {
            return ((TeamDone) this.instance).getMname();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public ByteString getMnameBytes() {
            return ((TeamDone) this.instance).getMnameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public String getName() {
            return ((TeamDone) this.instance).getName();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public ByteString getNameBytes() {
            return ((TeamDone) this.instance).getNameBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public int getRegion() {
            return ((TeamDone) this.instance).getRegion();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public String getRequestId() {
            return ((TeamDone) this.instance).getRequestId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public ByteString getRequestIdBytes() {
            return ((TeamDone) this.instance).getRequestIdBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
        public int getResVersion() {
            return ((TeamDone) this.instance).getResVersion();
        }

        public Builder setDone(int i) {
            copyOnWrite();
            ((TeamDone) this.instance).setDone(i);
            return this;
        }

        public Builder setDownurl(String str) {
            copyOnWrite();
            ((TeamDone) this.instance).setDownurl(str);
            return this;
        }

        public Builder setDownurlBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamDone) this.instance).setDownurlBytes(byteString);
            return this;
        }

        public Builder setGameaddr(String str) {
            copyOnWrite();
            ((TeamDone) this.instance).setGameaddr(str);
            return this;
        }

        public Builder setGameaddrBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamDone) this.instance).setGameaddrBytes(byteString);
            return this;
        }

        public Builder setIsNewEngine(boolean z) {
            copyOnWrite();
            ((TeamDone) this.instance).setIsNewEngine(z);
            return this;
        }

        public Builder setMid(String str) {
            copyOnWrite();
            ((TeamDone) this.instance).setMid(str);
            return this;
        }

        public Builder setMidBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamDone) this.instance).setMidBytes(byteString);
            return this;
        }

        public Builder setMname(String str) {
            copyOnWrite();
            ((TeamDone) this.instance).setMname(str);
            return this;
        }

        public Builder setMnameBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamDone) this.instance).setMnameBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((TeamDone) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamDone) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setRegion(int i) {
            copyOnWrite();
            ((TeamDone) this.instance).setRegion(i);
            return this;
        }

        public Builder setRequestId(String str) {
            copyOnWrite();
            ((TeamDone) this.instance).setRequestId(str);
            return this;
        }

        public Builder setRequestIdBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamDone) this.instance).setRequestIdBytes(byteString);
            return this;
        }

        public Builder setResVersion(int i) {
            copyOnWrite();
            ((TeamDone) this.instance).setResVersion(i);
            return this;
        }

        private Builder() {
            super(TeamDone.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamDone() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDone() {
        this.done_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDownurl() {
        this.downurl_ = getDefaultInstance().getDownurl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGameaddr() {
        this.gameaddr_ = getDefaultInstance().getGameaddr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsNewEngine() {
        this.isNewEngine_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMid() {
        this.mid_ = getDefaultInstance().getMid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMname() {
        this.mname_ = getDefaultInstance().getMname();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResVersion() {
        this.resVersion_ = 0;
    }

    public static TeamDone getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamDone parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamDone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamDone parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamDone> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(int i) {
        this.done_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownurl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.downurl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownurlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.downurl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGameaddr(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.gameaddr_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGameaddrBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.gameaddr_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsNewEngine(boolean z) {
        this.isNewEngine_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMid(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.mid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMidBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.mid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMname(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.mname_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMnameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.mname_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegion(int i) {
        this.region_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.requestId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.requestId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResVersion(int i) {
        this.resVersion_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamDone();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamDone teamDone = (TeamDone) obj2;
                this.done_ = iVar.a(this.done_ != 0, this.done_, teamDone.done_ != 0, teamDone.done_);
                this.gameaddr_ = iVar.a(!this.gameaddr_.isEmpty(), this.gameaddr_, !teamDone.gameaddr_.isEmpty(), teamDone.gameaddr_);
                this.name_ = iVar.a(!this.name_.isEmpty(), this.name_, !teamDone.name_.isEmpty(), teamDone.name_);
                this.mname_ = iVar.a(!this.mname_.isEmpty(), this.mname_, !teamDone.mname_.isEmpty(), teamDone.mname_);
                this.downurl_ = iVar.a(!this.downurl_.isEmpty(), this.downurl_, !teamDone.downurl_.isEmpty(), teamDone.downurl_);
                this.mid_ = iVar.a(!this.mid_.isEmpty(), this.mid_, !teamDone.mid_.isEmpty(), teamDone.mid_);
                this.region_ = iVar.a(this.region_ != 0, this.region_, teamDone.region_ != 0, teamDone.region_);
                this.resVersion_ = iVar.a(this.resVersion_ != 0, this.resVersion_, teamDone.resVersion_ != 0, teamDone.resVersion_);
                boolean z = this.isNewEngine_;
                boolean z2 = teamDone.isNewEngine_;
                this.isNewEngine_ = iVar.a(z, z, z2, z2);
                this.requestId_ = iVar.a(!this.requestId_.isEmpty(), this.requestId_, !teamDone.requestId_.isEmpty(), teamDone.requestId_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        switch (iQ) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.done_ = c2301g.h();
                                break;
                            case 18:
                                this.gameaddr_ = c2301g.p();
                                break;
                            case 26:
                                this.name_ = c2301g.p();
                                break;
                            case 34:
                                this.mname_ = c2301g.p();
                                break;
                            case 42:
                                this.downurl_ = c2301g.p();
                                break;
                            case 50:
                                this.mid_ = c2301g.p();
                                break;
                            case 56:
                                this.region_ = c2301g.h();
                                break;
                            case 64:
                                this.resVersion_ = c2301g.h();
                                break;
                            case 72:
                                this.isNewEngine_ = c2301g.c();
                                break;
                            case 82:
                                this.requestId_ = c2301g.p();
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
                    synchronized (TeamDone.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public int getDone() {
        return this.done_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public String getDownurl() {
        return this.downurl_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public ByteString getDownurlBytes() {
        return ByteString.copyFromUtf8(this.downurl_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public String getGameaddr() {
        return this.gameaddr_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public ByteString getGameaddrBytes() {
        return ByteString.copyFromUtf8(this.gameaddr_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public boolean getIsNewEngine() {
        return this.isNewEngine_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public String getMid() {
        return this.mid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public ByteString getMidBytes() {
        return ByteString.copyFromUtf8(this.mid_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public String getMname() {
        return this.mname_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public ByteString getMnameBytes() {
        return ByteString.copyFromUtf8(this.mname_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public int getRegion() {
        return this.region_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public String getRequestId() {
        return this.requestId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public ByteString getRequestIdBytes() {
        return ByteString.copyFromUtf8(this.requestId_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamDoneOrBuilder
    public int getResVersion() {
        return this.resVersion_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.done_;
        int iB = i2 != 0 ? 0 + CodedOutputStream.b(1, i2) : 0;
        if (!this.gameaddr_.isEmpty()) {
            iB += CodedOutputStream.a(2, getGameaddr());
        }
        if (!this.name_.isEmpty()) {
            iB += CodedOutputStream.a(3, getName());
        }
        if (!this.mname_.isEmpty()) {
            iB += CodedOutputStream.a(4, getMname());
        }
        if (!this.downurl_.isEmpty()) {
            iB += CodedOutputStream.a(5, getDownurl());
        }
        if (!this.mid_.isEmpty()) {
            iB += CodedOutputStream.a(6, getMid());
        }
        int i3 = this.region_;
        if (i3 != 0) {
            iB += CodedOutputStream.b(7, i3);
        }
        int i4 = this.resVersion_;
        if (i4 != 0) {
            iB += CodedOutputStream.b(8, i4);
        }
        boolean z = this.isNewEngine_;
        if (z) {
            iB += CodedOutputStream.a(9, z);
        }
        if (!this.requestId_.isEmpty()) {
            iB += CodedOutputStream.a(10, getRequestId());
        }
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.done_;
        if (i != 0) {
            codedOutputStream.d(1, i);
        }
        if (!this.gameaddr_.isEmpty()) {
            codedOutputStream.b(2, getGameaddr());
        }
        if (!this.name_.isEmpty()) {
            codedOutputStream.b(3, getName());
        }
        if (!this.mname_.isEmpty()) {
            codedOutputStream.b(4, getMname());
        }
        if (!this.downurl_.isEmpty()) {
            codedOutputStream.b(5, getDownurl());
        }
        if (!this.mid_.isEmpty()) {
            codedOutputStream.b(6, getMid());
        }
        int i2 = this.region_;
        if (i2 != 0) {
            codedOutputStream.d(7, i2);
        }
        int i3 = this.resVersion_;
        if (i3 != 0) {
            codedOutputStream.d(8, i3);
        }
        boolean z = this.isNewEngine_;
        if (z) {
            codedOutputStream.b(9, z);
        }
        if (this.requestId_.isEmpty()) {
            return;
        }
        codedOutputStream.b(10, getRequestId());
    }

    public static Builder newBuilder(TeamDone teamDone) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamDone);
    }

    public static TeamDone parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamDone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamDone parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamDone parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamDone parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamDone parseFrom(InputStream inputStream) throws IOException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamDone parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamDone parseFrom(C2301g c2301g) throws IOException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamDone parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamDone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
