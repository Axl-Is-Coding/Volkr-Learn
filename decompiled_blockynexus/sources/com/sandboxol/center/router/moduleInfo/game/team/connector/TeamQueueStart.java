package com.sandboxol.center.router.moduleInfo.game.team.connector;

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
public final class TeamQueueStart extends GeneratedMessageLite<TeamQueueStart, Builder> implements TeamQueueStartOrBuilder {
    public static final int ATTRIBUTES_FIELD_NUMBER = 2;
    public static final int CAMPID_FIELD_NUMBER = 5;
    public static final int CAPTAINID_FIELD_NUMBER = 6;
    private static final TeamQueueStart DEFAULT_INSTANCE = new TeamQueueStart();
    public static final int GAMETYPE_FIELD_NUMBER = 3;
    public static final int GAMEXOPT_FIELD_NUMBER = 7;
    public static final int MAPID_FIELD_NUMBER = 4;
    private static volatile A<TeamQueueStart> PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 1;
    private long captainid_;
    private long priority_;
    private String attributes_ = "";
    private String gametype_ = "";
    private String mapid_ = "";
    private String campid_ = "";
    private String gamexopt_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStart$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamQueueStart, Builder> implements TeamQueueStartOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAttributes() {
            copyOnWrite();
            ((TeamQueueStart) this.instance).clearAttributes();
            return this;
        }

        public Builder clearCampid() {
            copyOnWrite();
            ((TeamQueueStart) this.instance).clearCampid();
            return this;
        }

        public Builder clearCaptainid() {
            copyOnWrite();
            ((TeamQueueStart) this.instance).clearCaptainid();
            return this;
        }

        public Builder clearGametype() {
            copyOnWrite();
            ((TeamQueueStart) this.instance).clearGametype();
            return this;
        }

        public Builder clearGamexopt() {
            copyOnWrite();
            ((TeamQueueStart) this.instance).clearGamexopt();
            return this;
        }

        public Builder clearMapid() {
            copyOnWrite();
            ((TeamQueueStart) this.instance).clearMapid();
            return this;
        }

        public Builder clearPriority() {
            copyOnWrite();
            ((TeamQueueStart) this.instance).clearPriority();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public String getAttributes() {
            return ((TeamQueueStart) this.instance).getAttributes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public ByteString getAttributesBytes() {
            return ((TeamQueueStart) this.instance).getAttributesBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public String getCampid() {
            return ((TeamQueueStart) this.instance).getCampid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public ByteString getCampidBytes() {
            return ((TeamQueueStart) this.instance).getCampidBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public long getCaptainid() {
            return ((TeamQueueStart) this.instance).getCaptainid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public String getGametype() {
            return ((TeamQueueStart) this.instance).getGametype();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public ByteString getGametypeBytes() {
            return ((TeamQueueStart) this.instance).getGametypeBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public String getGamexopt() {
            return ((TeamQueueStart) this.instance).getGamexopt();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public ByteString getGamexoptBytes() {
            return ((TeamQueueStart) this.instance).getGamexoptBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public String getMapid() {
            return ((TeamQueueStart) this.instance).getMapid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public ByteString getMapidBytes() {
            return ((TeamQueueStart) this.instance).getMapidBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
        public long getPriority() {
            return ((TeamQueueStart) this.instance).getPriority();
        }

        public Builder setAttributes(String str) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setAttributes(str);
            return this;
        }

        public Builder setAttributesBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setAttributesBytes(byteString);
            return this;
        }

        public Builder setCampid(String str) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setCampid(str);
            return this;
        }

        public Builder setCampidBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setCampidBytes(byteString);
            return this;
        }

        public Builder setCaptainid(long j) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setCaptainid(j);
            return this;
        }

        public Builder setGametype(String str) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setGametype(str);
            return this;
        }

        public Builder setGametypeBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setGametypeBytes(byteString);
            return this;
        }

        public Builder setGamexopt(String str) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setGamexopt(str);
            return this;
        }

        public Builder setGamexoptBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setGamexoptBytes(byteString);
            return this;
        }

        public Builder setMapid(String str) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setMapid(str);
            return this;
        }

        public Builder setMapidBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setMapidBytes(byteString);
            return this;
        }

        public Builder setPriority(long j) {
            copyOnWrite();
            ((TeamQueueStart) this.instance).setPriority(j);
            return this;
        }

        private Builder() {
            super(TeamQueueStart.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamQueueStart() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAttributes() {
        this.attributes_ = getDefaultInstance().getAttributes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCampid() {
        this.campid_ = getDefaultInstance().getCampid();
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
    public void clearGamexopt() {
        this.gamexopt_ = getDefaultInstance().getGamexopt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMapid() {
        this.mapid_ = getDefaultInstance().getMapid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPriority() {
        this.priority_ = 0L;
    }

    public static TeamQueueStart getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamQueueStart parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamQueueStart) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueStart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamQueueStart> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttributes(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.attributes_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttributesBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.attributes_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampid(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.campid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampidBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.campid_ = byteString.toStringUtf8();
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
    public void setGamexopt(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.gamexopt_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGamexoptBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.gamexopt_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapid(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.mapid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapidBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        this.mapid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPriority(long j) {
        this.priority_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamQueueStart();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamQueueStart teamQueueStart = (TeamQueueStart) obj2;
                this.priority_ = iVar.a(this.priority_ != 0, this.priority_, teamQueueStart.priority_ != 0, teamQueueStart.priority_);
                this.attributes_ = iVar.a(!this.attributes_.isEmpty(), this.attributes_, !teamQueueStart.attributes_.isEmpty(), teamQueueStart.attributes_);
                this.gametype_ = iVar.a(!this.gametype_.isEmpty(), this.gametype_, !teamQueueStart.gametype_.isEmpty(), teamQueueStart.gametype_);
                this.mapid_ = iVar.a(!this.mapid_.isEmpty(), this.mapid_, !teamQueueStart.mapid_.isEmpty(), teamQueueStart.mapid_);
                this.campid_ = iVar.a(!this.campid_.isEmpty(), this.campid_, !teamQueueStart.campid_.isEmpty(), teamQueueStart.campid_);
                this.captainid_ = iVar.a(this.captainid_ != 0, this.captainid_, teamQueueStart.captainid_ != 0, teamQueueStart.captainid_);
                this.gamexopt_ = iVar.a(!this.gamexopt_.isEmpty(), this.gamexopt_, !teamQueueStart.gamexopt_.isEmpty(), teamQueueStart.gamexopt_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 8) {
                                this.priority_ = c2301g.i();
                            } else if (iQ == 18) {
                                this.attributes_ = c2301g.p();
                            } else if (iQ == 26) {
                                this.gametype_ = c2301g.p();
                            } else if (iQ == 34) {
                                this.mapid_ = c2301g.p();
                            } else if (iQ == 42) {
                                this.campid_ = c2301g.p();
                            } else if (iQ == 48) {
                                this.captainid_ = c2301g.r();
                            } else if (iQ == 58) {
                                this.gamexopt_ = c2301g.p();
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
                    synchronized (TeamQueueStart.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public String getAttributes() {
        return this.attributes_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public ByteString getAttributesBytes() {
        return ByteString.copyFromUtf8(this.attributes_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public String getCampid() {
        return this.campid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public ByteString getCampidBytes() {
        return ByteString.copyFromUtf8(this.campid_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public long getCaptainid() {
        return this.captainid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public String getGametype() {
        return this.gametype_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public ByteString getGametypeBytes() {
        return ByteString.copyFromUtf8(this.gametype_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public String getGamexopt() {
        return this.gamexopt_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public ByteString getGamexoptBytes() {
        return ByteString.copyFromUtf8(this.gamexopt_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public String getMapid() {
        return this.mapid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public ByteString getMapidBytes() {
        return ByteString.copyFromUtf8(this.mapid_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueStartOrBuilder
    public long getPriority() {
        return this.priority_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        long j = this.priority_;
        int iA = j != 0 ? 0 + CodedOutputStream.a(1, j) : 0;
        if (!this.attributes_.isEmpty()) {
            iA += CodedOutputStream.a(2, getAttributes());
        }
        if (!this.gametype_.isEmpty()) {
            iA += CodedOutputStream.a(3, getGametype());
        }
        if (!this.mapid_.isEmpty()) {
            iA += CodedOutputStream.a(4, getMapid());
        }
        if (!this.campid_.isEmpty()) {
            iA += CodedOutputStream.a(5, getCampid());
        }
        long j2 = this.captainid_;
        if (j2 != 0) {
            iA += CodedOutputStream.b(6, j2);
        }
        if (!this.gamexopt_.isEmpty()) {
            iA += CodedOutputStream.a(7, getGamexopt());
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.priority_;
        if (j != 0) {
            codedOutputStream.c(1, j);
        }
        if (!this.attributes_.isEmpty()) {
            codedOutputStream.b(2, getAttributes());
        }
        if (!this.gametype_.isEmpty()) {
            codedOutputStream.b(3, getGametype());
        }
        if (!this.mapid_.isEmpty()) {
            codedOutputStream.b(4, getMapid());
        }
        if (!this.campid_.isEmpty()) {
            codedOutputStream.b(5, getCampid());
        }
        long j2 = this.captainid_;
        if (j2 != 0) {
            codedOutputStream.d(6, j2);
        }
        if (this.gamexopt_.isEmpty()) {
            return;
        }
        codedOutputStream.b(7, getGamexopt());
    }

    public static Builder newBuilder(TeamQueueStart teamQueueStart) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamQueueStart);
    }

    public static TeamQueueStart parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueStart) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueStart parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamQueueStart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamQueueStart parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamQueueStart parseFrom(InputStream inputStream) throws IOException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueStart parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueStart parseFrom(C2301g c2301g) throws IOException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamQueueStart parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamQueueStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
