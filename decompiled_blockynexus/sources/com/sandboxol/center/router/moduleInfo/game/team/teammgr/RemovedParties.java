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
public final class RemovedParties extends GeneratedMessageLite<RemovedParties, Builder> implements RemovedPartiesOrBuilder {
    private static final RemovedParties DEFAULT_INSTANCE = new RemovedParties();
    private static volatile A<RemovedParties> PARSER = null;
    public static final int TEAMIDS_FIELD_NUMBER = 1;
    private r.h<String> teamIds_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedParties$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<RemovedParties, Builder> implements RemovedPartiesOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTeamIds(Iterable<String> iterable) {
            copyOnWrite();
            ((RemovedParties) this.instance).addAllTeamIds(iterable);
            return this;
        }

        public Builder addTeamIds(String str) {
            copyOnWrite();
            ((RemovedParties) this.instance).addTeamIds(str);
            return this;
        }

        public Builder addTeamIdsBytes(ByteString byteString) {
            copyOnWrite();
            ((RemovedParties) this.instance).addTeamIdsBytes(byteString);
            return this;
        }

        public Builder clearTeamIds() {
            copyOnWrite();
            ((RemovedParties) this.instance).clearTeamIds();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
        public String getTeamIds(int i) {
            return ((RemovedParties) this.instance).getTeamIds(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
        public ByteString getTeamIdsBytes(int i) {
            return ((RemovedParties) this.instance).getTeamIdsBytes(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
        public int getTeamIdsCount() {
            return ((RemovedParties) this.instance).getTeamIdsCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
        public List<String> getTeamIdsList() {
            return Collections.unmodifiableList(((RemovedParties) this.instance).getTeamIdsList());
        }

        public Builder setTeamIds(int i, String str) {
            copyOnWrite();
            ((RemovedParties) this.instance).setTeamIds(i, str);
            return this;
        }

        private Builder() {
            super(RemovedParties.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private RemovedParties() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTeamIds(Iterable<String> iterable) {
        ensureTeamIdsIsMutable();
        AbstractC2295a.addAll(iterable, this.teamIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeamIds(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureTeamIdsIsMutable();
        this.teamIds_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTeamIdsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractC2295a.checkByteStringIsUtf8(byteString);
        ensureTeamIdsIsMutable();
        this.teamIds_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTeamIds() {
        this.teamIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTeamIdsIsMutable() {
        if (this.teamIds_.d()) {
            return;
        }
        this.teamIds_ = GeneratedMessageLite.mutableCopy(this.teamIds_);
    }

    public static RemovedParties getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RemovedParties parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RemovedParties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemovedParties parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<RemovedParties> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTeamIds(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureTeamIdsIsMutable();
        this.teamIds_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemovedParties();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.teamIds_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.teamIds_ = ((GeneratedMessageLite.i) obj).a(this.teamIds_, ((RemovedParties) obj2).teamIds_);
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
                                    if (!this.teamIds_.d()) {
                                        this.teamIds_ = GeneratedMessageLite.mutableCopy(this.teamIds_);
                                    }
                                    this.teamIds_.add(strP);
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
                    synchronized (RemovedParties.class) {
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
        for (int i2 = 0; i2 < this.teamIds_.size(); i2++) {
            iA += CodedOutputStream.a(this.teamIds_.get(i2));
        }
        int size = 0 + iA + (getTeamIdsList().size() * 1);
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
    public String getTeamIds(int i) {
        return this.teamIds_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
    public ByteString getTeamIdsBytes(int i) {
        return ByteString.copyFromUtf8(this.teamIds_.get(i));
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
    public int getTeamIdsCount() {
        return this.teamIds_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedPartiesOrBuilder
    public List<String> getTeamIdsList() {
        return this.teamIds_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.teamIds_.size(); i++) {
            codedOutputStream.b(1, this.teamIds_.get(i));
        }
    }

    public static Builder newBuilder(RemovedParties removedParties) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(removedParties);
    }

    public static RemovedParties parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemovedParties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemovedParties parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static RemovedParties parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RemovedParties parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static RemovedParties parseFrom(InputStream inputStream) throws IOException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemovedParties parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemovedParties parseFrom(C2301g c2301g) throws IOException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static RemovedParties parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (RemovedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
