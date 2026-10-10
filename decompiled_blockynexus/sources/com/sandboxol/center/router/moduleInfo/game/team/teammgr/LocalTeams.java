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
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.Team;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalTeams extends GeneratedMessageLite<LocalTeams, Builder> implements LocalTeamsOrBuilder {
    private static final LocalTeams DEFAULT_INSTANCE = new LocalTeams();
    private static volatile A<LocalTeams> PARSER = null;
    public static final int TEAMS_FIELD_NUMBER = 1;
    private r.h<Team> teams_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeams$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<LocalTeams, Builder> implements LocalTeamsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTeams(Iterable<? extends Team> iterable) {
            copyOnWrite();
            ((LocalTeams) this.instance).addAllTeams(iterable);
            return this;
        }

        public Builder addTeams(Team team) {
            copyOnWrite();
            ((LocalTeams) this.instance).addTeams(team);
            return this;
        }

        public Builder clearTeams() {
            copyOnWrite();
            ((LocalTeams) this.instance).clearTeams();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsOrBuilder
        public Team getTeams(int i) {
            return ((LocalTeams) this.instance).getTeams(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsOrBuilder
        public int getTeamsCount() {
            return ((LocalTeams) this.instance).getTeamsCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsOrBuilder
        public List<Team> getTeamsList() {
            return Collections.unmodifiableList(((LocalTeams) this.instance).getTeamsList());
        }

        public Builder removeTeams(int i) {
            copyOnWrite();
            ((LocalTeams) this.instance).removeTeams(i);
            return this;
        }

        public Builder setTeams(int i, Team team) {
            copyOnWrite();
            ((LocalTeams) this.instance).setTeams(i, team);
            return this;
        }

        private Builder() {
            super(LocalTeams.DEFAULT_INSTANCE);
        }

        public Builder addTeams(int i, Team team) {
            copyOnWrite();
            ((LocalTeams) this.instance).addTeams(i, team);
            return this;
        }

        public Builder setTeams(int i, Team.Builder builder) {
            copyOnWrite();
            ((LocalTeams) this.instance).setTeams(i, builder);
            return this;
        }

        public Builder addTeams(Team.Builder builder) {
            copyOnWrite();
            ((LocalTeams) this.instance).addTeams(builder);
            return this;
        }

        public Builder addTeams(int i, Team.Builder builder) {
            copyOnWrite();
            ((LocalTeams) this.instance).addTeams(i, builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private LocalTeams() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTeams(Iterable<? extends Team> iterable) {
        ensureTeamsIsMutable();
        AbstractC2295a.addAll(iterable, this.teams_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeams(Team team) {
        if (team == null) {
            throw new NullPointerException();
        }
        ensureTeamsIsMutable();
        this.teams_.add(team);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeams() {
        this.teams_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTeamsIsMutable() {
        if (this.teams_.d()) {
            return;
        }
        this.teams_ = GeneratedMessageLite.mutableCopy(this.teams_);
    }

    public static LocalTeams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static LocalTeams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LocalTeams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalTeams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<LocalTeams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTeams(int i) {
        ensureTeamsIsMutable();
        this.teams_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeams(int i, Team team) {
        if (team == null) {
            throw new NullPointerException();
        }
        ensureTeamsIsMutable();
        this.teams_.set(i, team);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new LocalTeams();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.teams_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.teams_ = ((GeneratedMessageLite.i) obj).a(this.teams_, ((LocalTeams) obj2).teams_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                C2306l c2306l = (C2306l) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 10) {
                                if (!this.teams_.d()) {
                                    this.teams_ = GeneratedMessageLite.mutableCopy(this.teams_);
                                }
                                this.teams_.add((Team) c2301g.a(Team.parser(), c2306l));
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
                    synchronized (LocalTeams.class) {
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

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < this.teams_.size(); i2++) {
            iA += CodedOutputStream.a(1, this.teams_.get(i2));
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsOrBuilder
    public Team getTeams(int i) {
        return this.teams_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsOrBuilder
    public int getTeamsCount() {
        return this.teams_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsOrBuilder
    public List<Team> getTeamsList() {
        return this.teams_;
    }

    public TeamOrBuilder getTeamsOrBuilder(int i) {
        return this.teams_.get(i);
    }

    public List<? extends TeamOrBuilder> getTeamsOrBuilderList() {
        return this.teams_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.teams_.size(); i++) {
            codedOutputStream.b(1, this.teams_.get(i));
        }
    }

    public static Builder newBuilder(LocalTeams localTeams) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(localTeams);
    }

    public static LocalTeams parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (LocalTeams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static LocalTeams parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static LocalTeams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeams(int i, Team team) {
        if (team != null) {
            ensureTeamsIsMutable();
            this.teams_.add(i, team);
            return;
        }
        throw new NullPointerException();
    }

    public static LocalTeams parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeams(int i, Team.Builder builder) {
        ensureTeamsIsMutable();
        this.teams_.set(i, builder.build());
    }

    public static LocalTeams parseFrom(InputStream inputStream) throws IOException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalTeams parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeams(Team.Builder builder) {
        ensureTeamsIsMutable();
        this.teams_.add(builder.build());
    }

    public static LocalTeams parseFrom(C2301g c2301g) throws IOException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static LocalTeams parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (LocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeams(int i, Team.Builder builder) {
        ensureTeamsIsMutable();
        this.teams_.add(i, builder.build());
    }
}
