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
public final class SyncMembers extends GeneratedMessageLite<SyncMembers, Builder> implements SyncMembersOrBuilder {
    private static final SyncMembers DEFAULT_INSTANCE = new SyncMembers();
    private static volatile A<SyncMembers> PARSER = null;
    public static final int TEAMMEMBERS_FIELD_NUMBER = 1;
    private r.h<TeamMember> teammembers_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembers$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<SyncMembers, Builder> implements SyncMembersOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTeammembers(Iterable<? extends TeamMember> iterable) {
            copyOnWrite();
            ((SyncMembers) this.instance).addAllTeammembers(iterable);
            return this;
        }

        public Builder addTeammembers(TeamMember teamMember) {
            copyOnWrite();
            ((SyncMembers) this.instance).addTeammembers(teamMember);
            return this;
        }

        public Builder clearTeammembers() {
            copyOnWrite();
            ((SyncMembers) this.instance).clearTeammembers();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembersOrBuilder
        public TeamMember getTeammembers(int i) {
            return ((SyncMembers) this.instance).getTeammembers(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembersOrBuilder
        public int getTeammembersCount() {
            return ((SyncMembers) this.instance).getTeammembersCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembersOrBuilder
        public List<TeamMember> getTeammembersList() {
            return Collections.unmodifiableList(((SyncMembers) this.instance).getTeammembersList());
        }

        public Builder removeTeammembers(int i) {
            copyOnWrite();
            ((SyncMembers) this.instance).removeTeammembers(i);
            return this;
        }

        public Builder setTeammembers(int i, TeamMember teamMember) {
            copyOnWrite();
            ((SyncMembers) this.instance).setTeammembers(i, teamMember);
            return this;
        }

        private Builder() {
            super(SyncMembers.DEFAULT_INSTANCE);
        }

        public Builder addTeammembers(int i, TeamMember teamMember) {
            copyOnWrite();
            ((SyncMembers) this.instance).addTeammembers(i, teamMember);
            return this;
        }

        public Builder setTeammembers(int i, TeamMember.Builder builder) {
            copyOnWrite();
            ((SyncMembers) this.instance).setTeammembers(i, builder);
            return this;
        }

        public Builder addTeammembers(TeamMember.Builder builder) {
            copyOnWrite();
            ((SyncMembers) this.instance).addTeammembers(builder);
            return this;
        }

        public Builder addTeammembers(int i, TeamMember.Builder builder) {
            copyOnWrite();
            ((SyncMembers) this.instance).addTeammembers(i, builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private SyncMembers() {
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
    public void clearTeammembers() {
        this.teammembers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTeammembersIsMutable() {
        if (this.teammembers_.d()) {
            return;
        }
        this.teammembers_ = GeneratedMessageLite.mutableCopy(this.teammembers_);
    }

    public static SyncMembers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SyncMembers parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SyncMembers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SyncMembers parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<SyncMembers> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTeammembers(int i) {
        ensureTeammembersIsMutable();
        this.teammembers_.remove(i);
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
                return new SyncMembers();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.teammembers_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.teammembers_ = ((GeneratedMessageLite.i) obj).a(this.teammembers_, ((SyncMembers) obj2).teammembers_);
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
                                if (!this.teammembers_.d()) {
                                    this.teammembers_ = GeneratedMessageLite.mutableCopy(this.teammembers_);
                                }
                                this.teammembers_.add((TeamMember) c2301g.a(TeamMember.parser(), c2306l));
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
                    synchronized (SyncMembers.class) {
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
        for (int i2 = 0; i2 < this.teammembers_.size(); i2++) {
            iA += CodedOutputStream.a(1, this.teammembers_.get(i2));
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembersOrBuilder
    public TeamMember getTeammembers(int i) {
        return this.teammembers_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembersOrBuilder
    public int getTeammembersCount() {
        return this.teammembers_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembersOrBuilder
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
        for (int i = 0; i < this.teammembers_.size(); i++) {
            codedOutputStream.b(1, this.teammembers_.get(i));
        }
    }

    public static Builder newBuilder(SyncMembers syncMembers) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(syncMembers);
    }

    public static SyncMembers parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (SyncMembers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static SyncMembers parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static SyncMembers parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
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

    public static SyncMembers parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeammembers(int i, TeamMember.Builder builder) {
        ensureTeammembersIsMutable();
        this.teammembers_.set(i, builder.build());
    }

    public static SyncMembers parseFrom(InputStream inputStream) throws IOException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SyncMembers parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeammembers(TeamMember.Builder builder) {
        ensureTeammembersIsMutable();
        this.teammembers_.add(builder.build());
    }

    public static SyncMembers parseFrom(C2301g c2301g) throws IOException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static SyncMembers parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (SyncMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeammembers(int i, TeamMember.Builder builder) {
        ensureTeammembersIsMutable();
        this.teammembers_.add(i, builder.build());
    }
}
