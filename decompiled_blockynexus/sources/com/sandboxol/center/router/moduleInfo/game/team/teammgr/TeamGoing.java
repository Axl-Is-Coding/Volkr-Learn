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
public final class TeamGoing extends GeneratedMessageLite<TeamGoing, Builder> implements TeamGoingOrBuilder {
    public static final int CAPTAINID_FIELD_NUMBER = 2;
    private static final TeamGoing DEFAULT_INSTANCE = new TeamGoing();
    public static final int LANG_FIELD_NUMBER = 5;
    private static volatile A<TeamGoing> PARSER = null;
    public static final int PSID_FIELD_NUMBER = 4;
    public static final int TEAMID_FIELD_NUMBER = 1;
    public static final int TEAMMEMBERS_FIELD_NUMBER = 3;
    private int bitField0_;
    private long captainId_;
    private String teamId_ = "";
    private r.h<TeamMember> teammembers_ = GeneratedMessageLite.emptyProtobufList();
    private String psid_ = "";
    private String lang_ = "";

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoing$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamGoing, Builder> implements TeamGoingOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTeammembers(Iterable<? extends TeamMember> iterable) {
            copyOnWrite();
            ((TeamGoing) this.instance).addAllTeammembers(iterable);
            return this;
        }

        public Builder addTeammembers(TeamMember teamMember) {
            copyOnWrite();
            ((TeamGoing) this.instance).addTeammembers(teamMember);
            return this;
        }

        public Builder clearCaptainId() {
            copyOnWrite();
            ((TeamGoing) this.instance).clearCaptainId();
            return this;
        }

        public Builder clearLang() {
            copyOnWrite();
            ((TeamGoing) this.instance).clearLang();
            return this;
        }

        public Builder clearPsid() {
            copyOnWrite();
            ((TeamGoing) this.instance).clearPsid();
            return this;
        }

        public Builder clearTeamId() {
            copyOnWrite();
            ((TeamGoing) this.instance).clearTeamId();
            return this;
        }

        public Builder clearTeammembers() {
            copyOnWrite();
            ((TeamGoing) this.instance).clearTeammembers();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public long getCaptainId() {
            return ((TeamGoing) this.instance).getCaptainId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public String getLang() {
            return ((TeamGoing) this.instance).getLang();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public ByteString getLangBytes() {
            return ((TeamGoing) this.instance).getLangBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public String getPsid() {
            return ((TeamGoing) this.instance).getPsid();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public ByteString getPsidBytes() {
            return ((TeamGoing) this.instance).getPsidBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public String getTeamId() {
            return ((TeamGoing) this.instance).getTeamId();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public ByteString getTeamIdBytes() {
            return ((TeamGoing) this.instance).getTeamIdBytes();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public TeamMember getTeammembers(int i) {
            return ((TeamGoing) this.instance).getTeammembers(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public int getTeammembersCount() {
            return ((TeamGoing) this.instance).getTeammembersCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
        public List<TeamMember> getTeammembersList() {
            return Collections.unmodifiableList(((TeamGoing) this.instance).getTeammembersList());
        }

        public Builder removeTeammembers(int i) {
            copyOnWrite();
            ((TeamGoing) this.instance).removeTeammembers(i);
            return this;
        }

        public Builder setCaptainId(long j) {
            copyOnWrite();
            ((TeamGoing) this.instance).setCaptainId(j);
            return this;
        }

        public Builder setLang(String str) {
            copyOnWrite();
            ((TeamGoing) this.instance).setLang(str);
            return this;
        }

        public Builder setLangBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamGoing) this.instance).setLangBytes(byteString);
            return this;
        }

        public Builder setPsid(String str) {
            copyOnWrite();
            ((TeamGoing) this.instance).setPsid(str);
            return this;
        }

        public Builder setPsidBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamGoing) this.instance).setPsidBytes(byteString);
            return this;
        }

        public Builder setTeamId(String str) {
            copyOnWrite();
            ((TeamGoing) this.instance).setTeamId(str);
            return this;
        }

        public Builder setTeamIdBytes(ByteString byteString) {
            copyOnWrite();
            ((TeamGoing) this.instance).setTeamIdBytes(byteString);
            return this;
        }

        public Builder setTeammembers(int i, TeamMember teamMember) {
            copyOnWrite();
            ((TeamGoing) this.instance).setTeammembers(i, teamMember);
            return this;
        }

        private Builder() {
            super(TeamGoing.DEFAULT_INSTANCE);
        }

        public Builder addTeammembers(int i, TeamMember teamMember) {
            copyOnWrite();
            ((TeamGoing) this.instance).addTeammembers(i, teamMember);
            return this;
        }

        public Builder setTeammembers(int i, TeamMember.Builder builder) {
            copyOnWrite();
            ((TeamGoing) this.instance).setTeammembers(i, builder);
            return this;
        }

        public Builder addTeammembers(TeamMember.Builder builder) {
            copyOnWrite();
            ((TeamGoing) this.instance).addTeammembers(builder);
            return this;
        }

        public Builder addTeammembers(int i, TeamMember.Builder builder) {
            copyOnWrite();
            ((TeamGoing) this.instance).addTeammembers(i, builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamGoing() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTeammembers(Iterable<? extends TeamMember> iterable) {
        ensureTeammembersIsMutable();
        AbstractC2295a.addAll(iterable, this.teammembers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeammembers(TeamMember teamMember) {
        if (teamMember == null) {
            throw new NullPointerException();
        }
        ensureTeammembersIsMutable();
        this.teammembers_.add(teamMember);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptainId() {
        this.captainId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLang() {
        this.lang_ = getDefaultInstance().getLang();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPsid() {
        this.psid_ = getDefaultInstance().getPsid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamId() {
        this.teamId_ = getDefaultInstance().getTeamId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeammembers() {
        this.teammembers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTeammembersIsMutable() {
        if (this.teammembers_.d()) {
            return;
        }
        this.teammembers_ = GeneratedMessageLite.mutableCopy(this.teammembers_);
    }

    public static TeamGoing getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamGoing parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamGoing) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamGoing parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamGoing> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTeammembers(int i) {
        ensureTeammembersIsMutable();
        this.teammembers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptainId(long j) {
        this.captainId_ = j;
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
    public void setTeammembers(int i, TeamMember teamMember) {
        if (teamMember == null) {
            throw new NullPointerException();
        }
        ensureTeammembersIsMutable();
        this.teammembers_.set(i, teamMember);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamGoing();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.teammembers_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamGoing teamGoing = (TeamGoing) obj2;
                this.teamId_ = iVar.a(!this.teamId_.isEmpty(), this.teamId_, !teamGoing.teamId_.isEmpty(), teamGoing.teamId_);
                this.captainId_ = iVar.a(this.captainId_ != 0, this.captainId_, teamGoing.captainId_ != 0, teamGoing.captainId_);
                this.teammembers_ = iVar.a(this.teammembers_, teamGoing.teammembers_);
                this.psid_ = iVar.a(!this.psid_.isEmpty(), this.psid_, !teamGoing.psid_.isEmpty(), teamGoing.psid_);
                this.lang_ = iVar.a(!this.lang_.isEmpty(), this.lang_, !teamGoing.lang_.isEmpty(), teamGoing.lang_);
                if (iVar == GeneratedMessageLite.h.f14297a) {
                    this.bitField0_ |= teamGoing.bitField0_;
                }
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
                                    this.teamId_ = c2301g.p();
                                } else if (iQ == 16) {
                                    this.captainId_ = c2301g.r();
                                } else if (iQ == 26) {
                                    if (!this.teammembers_.d()) {
                                        this.teammembers_ = GeneratedMessageLite.mutableCopy(this.teammembers_);
                                    }
                                    this.teammembers_.add((TeamMember) c2301g.a(TeamMember.parser(), c2306l));
                                } else if (iQ == 34) {
                                    this.psid_ = c2301g.p();
                                } else if (iQ == 42) {
                                    this.lang_ = c2301g.p();
                                } else if (!c2301g.e(iQ)) {
                                }
                            }
                            z = true;
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
                    synchronized (TeamGoing.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public long getCaptainId() {
        return this.captainId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public String getLang() {
        return this.lang_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public ByteString getLangBytes() {
        return ByteString.copyFromUtf8(this.lang_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public String getPsid() {
        return this.psid_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public ByteString getPsidBytes() {
        return ByteString.copyFromUtf8(this.psid_);
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = !this.teamId_.isEmpty() ? CodedOutputStream.a(1, getTeamId()) + 0 : 0;
        long j = this.captainId_;
        if (j != 0) {
            iA += CodedOutputStream.b(2, j);
        }
        for (int i2 = 0; i2 < this.teammembers_.size(); i2++) {
            iA += CodedOutputStream.a(3, this.teammembers_.get(i2));
        }
        if (!this.psid_.isEmpty()) {
            iA += CodedOutputStream.a(4, getPsid());
        }
        if (!this.lang_.isEmpty()) {
            iA += CodedOutputStream.a(5, getLang());
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public String getTeamId() {
        return this.teamId_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public ByteString getTeamIdBytes() {
        return ByteString.copyFromUtf8(this.teamId_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public TeamMember getTeammembers(int i) {
        return this.teammembers_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public int getTeammembersCount() {
        return this.teammembers_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamGoingOrBuilder
    public List<TeamMember> getTeammembersList() {
        return this.teammembers_;
    }

    public TeamMemberOrBuilder getTeammembersOrBuilder(int i) {
        return this.teammembers_.get(i);
    }

    public List<? extends TeamMemberOrBuilder> getTeammembersOrBuilderList() {
        return this.teammembers_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.teamId_.isEmpty()) {
            codedOutputStream.b(1, getTeamId());
        }
        long j = this.captainId_;
        if (j != 0) {
            codedOutputStream.d(2, j);
        }
        for (int i = 0; i < this.teammembers_.size(); i++) {
            codedOutputStream.b(3, this.teammembers_.get(i));
        }
        if (!this.psid_.isEmpty()) {
            codedOutputStream.b(4, getPsid());
        }
        if (this.lang_.isEmpty()) {
            return;
        }
        codedOutputStream.b(5, getLang());
    }

    public static Builder newBuilder(TeamGoing teamGoing) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamGoing);
    }

    public static TeamGoing parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamGoing) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamGoing parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamGoing parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeammembers(int i, TeamMember teamMember) {
        if (teamMember != null) {
            ensureTeammembersIsMutable();
            this.teammembers_.add(i, teamMember);
            return;
        }
        throw new NullPointerException();
    }

    public static TeamGoing parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeammembers(int i, TeamMember.Builder builder) {
        ensureTeammembersIsMutable();
        this.teammembers_.set(i, builder.build());
    }

    public static TeamGoing parseFrom(InputStream inputStream) throws IOException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamGoing parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeammembers(TeamMember.Builder builder) {
        ensureTeammembersIsMutable();
        this.teammembers_.add(builder.build());
    }

    public static TeamGoing parseFrom(C2301g c2301g) throws IOException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamGoing parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeammembers(int i, TeamMember.Builder builder) {
        ensureTeammembersIsMutable();
        this.teammembers_.add(i, builder.build());
    }
}
