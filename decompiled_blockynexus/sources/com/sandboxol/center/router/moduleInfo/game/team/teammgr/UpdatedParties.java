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
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdatedParties extends GeneratedMessageLite<UpdatedParties, Builder> implements UpdatedPartiesOrBuilder {
    private static final UpdatedParties DEFAULT_INSTANCE = new UpdatedParties();
    private static volatile A<UpdatedParties> PARSER = null;
    public static final int PARTIES_FIELD_NUMBER = 1;
    private r.h<PartyItem> parties_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedParties$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<UpdatedParties, Builder> implements UpdatedPartiesOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllParties(Iterable<? extends PartyItem> iterable) {
            copyOnWrite();
            ((UpdatedParties) this.instance).addAllParties(iterable);
            return this;
        }

        public Builder addParties(PartyItem partyItem) {
            copyOnWrite();
            ((UpdatedParties) this.instance).addParties(partyItem);
            return this;
        }

        public Builder clearParties() {
            copyOnWrite();
            ((UpdatedParties) this.instance).clearParties();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedPartiesOrBuilder
        public PartyItem getParties(int i) {
            return ((UpdatedParties) this.instance).getParties(i);
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedPartiesOrBuilder
        public int getPartiesCount() {
            return ((UpdatedParties) this.instance).getPartiesCount();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedPartiesOrBuilder
        public List<PartyItem> getPartiesList() {
            return Collections.unmodifiableList(((UpdatedParties) this.instance).getPartiesList());
        }

        public Builder removeParties(int i) {
            copyOnWrite();
            ((UpdatedParties) this.instance).removeParties(i);
            return this;
        }

        public Builder setParties(int i, PartyItem partyItem) {
            copyOnWrite();
            ((UpdatedParties) this.instance).setParties(i, partyItem);
            return this;
        }

        private Builder() {
            super(UpdatedParties.DEFAULT_INSTANCE);
        }

        public Builder addParties(int i, PartyItem partyItem) {
            copyOnWrite();
            ((UpdatedParties) this.instance).addParties(i, partyItem);
            return this;
        }

        public Builder setParties(int i, PartyItem.Builder builder) {
            copyOnWrite();
            ((UpdatedParties) this.instance).setParties(i, builder);
            return this;
        }

        public Builder addParties(PartyItem.Builder builder) {
            copyOnWrite();
            ((UpdatedParties) this.instance).addParties(builder);
            return this;
        }

        public Builder addParties(int i, PartyItem.Builder builder) {
            copyOnWrite();
            ((UpdatedParties) this.instance).addParties(i, builder);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private UpdatedParties() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParties(Iterable<? extends PartyItem> iterable) {
        ensurePartiesIsMutable();
        AbstractC2295a.addAll(iterable, this.parties_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParties(PartyItem partyItem) {
        if (partyItem == null) {
            throw new NullPointerException();
        }
        ensurePartiesIsMutable();
        this.parties_.add(partyItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParties() {
        this.parties_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePartiesIsMutable() {
        if (this.parties_.d()) {
            return;
        }
        this.parties_ = GeneratedMessageLite.mutableCopy(this.parties_);
    }

    public static UpdatedParties getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static UpdatedParties parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UpdatedParties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdatedParties parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<UpdatedParties> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParties(int i) {
        ensurePartiesIsMutable();
        this.parties_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParties(int i, PartyItem partyItem) {
        if (partyItem == null) {
            throw new NullPointerException();
        }
        ensurePartiesIsMutable();
        this.parties_.set(i, partyItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UpdatedParties();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.parties_.b();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.parties_ = ((GeneratedMessageLite.i) obj).a(this.parties_, ((UpdatedParties) obj2).parties_);
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
                                if (!this.parties_.d()) {
                                    this.parties_ = GeneratedMessageLite.mutableCopy(this.parties_);
                                }
                                this.parties_.add((PartyItem) c2301g.a(PartyItem.parser(), c2306l));
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
                    synchronized (UpdatedParties.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedPartiesOrBuilder
    public PartyItem getParties(int i) {
        return this.parties_.get(i);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedPartiesOrBuilder
    public int getPartiesCount() {
        return this.parties_.size();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedPartiesOrBuilder
    public List<PartyItem> getPartiesList() {
        return this.parties_;
    }

    public PartyItemOrBuilder getPartiesOrBuilder(int i) {
        return this.parties_.get(i);
    }

    public List<? extends PartyItemOrBuilder> getPartiesOrBuilderList() {
        return this.parties_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < this.parties_.size(); i2++) {
            iA += CodedOutputStream.a(1, this.parties_.get(i2));
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.parties_.size(); i++) {
            codedOutputStream.b(1, this.parties_.get(i));
        }
    }

    public static Builder newBuilder(UpdatedParties updatedParties) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(updatedParties);
    }

    public static UpdatedParties parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (UpdatedParties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static UpdatedParties parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static UpdatedParties parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParties(int i, PartyItem partyItem) {
        if (partyItem != null) {
            ensurePartiesIsMutable();
            this.parties_.add(i, partyItem);
            return;
        }
        throw new NullPointerException();
    }

    public static UpdatedParties parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParties(int i, PartyItem.Builder builder) {
        ensurePartiesIsMutable();
        this.parties_.set(i, builder.build());
    }

    public static UpdatedParties parseFrom(InputStream inputStream) throws IOException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdatedParties parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParties(PartyItem.Builder builder) {
        ensurePartiesIsMutable();
        this.parties_.add(builder.build());
    }

    public static UpdatedParties parseFrom(C2301g c2301g) throws IOException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static UpdatedParties parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (UpdatedParties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParties(int i, PartyItem.Builder builder) {
        ensurePartiesIsMutable();
        this.parties_.add(i, builder.build());
    }
}
