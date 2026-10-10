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
public final class RemoveLocalTeams extends GeneratedMessageLite<RemoveLocalTeams, Builder> implements RemoveLocalTeamsOrBuilder {
    private static final RemoveLocalTeams DEFAULT_INSTANCE = new RemoveLocalTeams();
    private static volatile A<RemoveLocalTeams> PARSER = null;
    public static final int TEAMS_FIELD_NUMBER = 1;
    private r.h<String> teams_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeams$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<RemoveLocalTeams, Builder> implements RemoveLocalTeamsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTeams(Iterable<String> iterable) {
            copyOnWrite();
            ((RemoveLocalTeams) this.instance).addAllTeams(iterable);
            return this;
        }

        public Builder addTeams(String str) {
            copyOnWrite();
            ((RemoveLocalTeams) this.instance).addTeams(str);
            return this;
        }

        public Builder addTeamsBytes(ByteString byteString) {
            copyOnWrite();
            ((RemoveLocalTeams) this.instance).addTeamsBytes(byteString);
            return this;
        }

        public Builder clearTeams() {
            copyOnWrite();
            ((RemoveLocalTeams) this.instance).clearTeams();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
        public String getTeams(int i) {
            return ((RemoveLocalTeams) this.instance).getTeams(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
        public ByteString getTeamsBytes(int i) {
            return ((RemoveLocalTeams) this.instance).getTeamsBytes(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
        public int getTeamsCount() {
            return ((RemoveLocalTeams) this.instance).getTeamsCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
        public List<String> getTeamsList() {
            return Collections.unmodifiableList(((RemoveLocalTeams) this.instance).getTeamsList());
        }

        public Builder setTeams(int i, String str) {
            copyOnWrite();
            ((RemoveLocalTeams) this.instance).setTeams(i, str);
            return this;
        }

        private Builder() {
            super(RemoveLocalTeams.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private RemoveLocalTeams() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTeams(Iterable<String> iterable) {
        ensureTeamsIsMutable();
        AbstractC2295a.addAll(iterable, this.teams_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeams(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureTeamsIsMutable();
        this.teams_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeamsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        ensureTeamsIsMutable();
        this.teams_.add(byteString.toStringUtf8());
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

    public static RemoveLocalTeams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RemoveLocalTeams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoveLocalTeams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<RemoveLocalTeams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeams(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureTeamsIsMutable();
        this.teams_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoveLocalTeams();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.teams_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.teams_ = ((GeneratedMessageLite.i) obj).a(this.teams_, ((RemoveLocalTeams) obj2).teams_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int iQ = c2301g.q();
                            if (iQ != 0) {
                                if (iQ == 10) {
                                    String strP = c2301g.p();
                                    if (!this.teams_.d()) {
                                        this.teams_ = GeneratedMessageLite.mutableCopy(this.teams_);
                                    }
                                    this.teams_.add(strP);
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
                    synchronized (RemoveLocalTeams.class) {
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
            iA += CodedOutputStream.a(this.teams_.get(i2));
        }
        int size = 0 + iA + (getTeamsList().size() * 1);
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
    public String getTeams(int i) {
        return this.teams_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
    public ByteString getTeamsBytes(int i) {
        return ByteString.copyFromUtf8(this.teams_.get(i));
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
    public int getTeamsCount() {
        return this.teams_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveLocalTeamsOrBuilder
    public List<String> getTeamsList() {
        return this.teams_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.teams_.size(); i++) {
            codedOutputStream.b(1, this.teams_.get(i));
        }
    }

    public static Builder newBuilder(RemoveLocalTeams removeLocalTeams) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(removeLocalTeams);
    }

    public static RemoveLocalTeams parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemoveLocalTeams parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static RemoveLocalTeams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RemoveLocalTeams parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static RemoveLocalTeams parseFrom(InputStream inputStream) throws IOException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoveLocalTeams parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemoveLocalTeams parseFrom(C2301g c2301g) throws IOException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static RemoveLocalTeams parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (RemoveLocalTeams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
