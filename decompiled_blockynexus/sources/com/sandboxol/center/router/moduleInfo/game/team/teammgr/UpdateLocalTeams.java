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
public final class UpdateLocalTeams extends GeneratedMessageLite<UpdateLocalTeams, Builder> implements UpdateLocalTeamsOrBuilder {
    private static final UpdateLocalTeams DEFAULT_INSTANCE = new UpdateLocalTeams();
    private static volatile A<UpdateLocalTeams> PARSER = null;
    public static final int TEAMS_FIELD_NUMBER = 1;
    private r.h<Team> teams_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeams$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<UpdateLocalTeams, Builder> implements UpdateLocalTeamsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTeams(Iterable<? extends Team> iterable) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).addAllTeams(iterable);
            return this;
        }

        public Builder addTeams(Team team) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).addTeams(team);
            return this;
        }

        public Builder clearTeams() {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).clearTeams();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeamsOrBuilder
        public Team getTeams(int i) {
            return ((UpdateLocalTeams) this.instance).getTeams(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeamsOrBuilder
        public int getTeamsCount() {
            return ((UpdateLocalTeams) this.instance).getTeamsCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeamsOrBuilder
        public List<Team> getTeamsList() {
            return Collections.unmodifiableList(((UpdateLocalTeams) this.instance).getTeamsList());
        }

        public Builder removeTeams(int i) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).removeTeams(i);
            return this;
        }

        public Builder setTeams(int i, Team team) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).setTeams(i, team);
            return this;
        }

        private Builder() {
            super(UpdateLocalTeams.DEFAULT_INSTANCE);
        }

        public Builder addTeams(int i, Team team) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).addTeams(i, team);
            return this;
        }

        public Builder setTeams(int i, Team.Builder builder) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).setTeams(i, builder);
            return this;
        }

        public Builder addTeams(Team.Builder builder) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).addTeams(builder);
            return this;
        }

        public Builder addTeams(int i, Team.Builder builder) {
            copyOnWrite();
            ((UpdateLocalTeams) this.instance).addTeams(i, builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private UpdateLocalTeams() {
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

    public static UpdateLocalTeams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static UpdateLocalTeams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateLocalTeams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<UpdateLocalTeams> parser() {
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
                return new UpdateLocalTeams();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.teams_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.teams_ = ((GeneratedMessageLite.i) obj).a(this.teams_, ((UpdateLocalTeams) obj2).teams_);
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
                    synchronized (UpdateLocalTeams.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeamsOrBuilder
    public Team getTeams(int i) {
        return this.teams_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeamsOrBuilder
    public int getTeamsCount() {
        return this.teams_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdateLocalTeamsOrBuilder
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

    public static Builder newBuilder(UpdateLocalTeams updateLocalTeams) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(updateLocalTeams);
    }

    public static UpdateLocalTeams parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static UpdateLocalTeams parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static UpdateLocalTeams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
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

    public static UpdateLocalTeams parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeams(int i, Team.Builder builder) {
        ensureTeamsIsMutable();
        this.teams_.set(i, builder.build());
    }

    public static UpdateLocalTeams parseFrom(InputStream inputStream) throws IOException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateLocalTeams parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeams(Team.Builder builder) {
        ensureTeamsIsMutable();
        this.teams_.add(builder.build());
    }

    public static UpdateLocalTeams parseFrom(C2301g c2301g) throws IOException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static UpdateLocalTeams parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (UpdateLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeams(int i, Team.Builder builder) {
        ensureTeamsIsMutable();
        this.teams_.add(i, builder.build());
    }
}
