package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyList;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemovedParties;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.UpdatedParties;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class PartyListResponse extends GeneratedMessageLite<PartyListResponse, Builder> implements PartyListResponseOrBuilder {
    private static final PartyListResponse DEFAULT_INSTANCE = new PartyListResponse();
    private static volatile A<PartyListResponse> PARSER = null;
    public static final int PARTIES_FIELD_NUMBER = 1;
    public static final int REMOVES_FIELD_NUMBER = 3;
    public static final int UPDATES_FIELD_NUMBER = 2;
    private int dataCase_ = 0;
    private Object data_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$PartyListResponse$DataCase;

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
            $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$PartyListResponse$DataCase = new int[DataCase.values().length];
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$PartyListResponse$DataCase[DataCase.PARTIES.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$PartyListResponse$DataCase[DataCase.UPDATES.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$PartyListResponse$DataCase[DataCase.REMOVES.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$PartyListResponse$DataCase[DataCase.DATA_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<PartyListResponse, Builder> implements PartyListResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearData() {
            copyOnWrite();
            ((PartyListResponse) this.instance).clearData();
            return this;
        }

        public Builder clearParties() {
            copyOnWrite();
            ((PartyListResponse) this.instance).clearParties();
            return this;
        }

        public Builder clearRemoves() {
            copyOnWrite();
            ((PartyListResponse) this.instance).clearRemoves();
            return this;
        }

        public Builder clearUpdates() {
            copyOnWrite();
            ((PartyListResponse) this.instance).clearUpdates();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
        public DataCase getDataCase() {
            return ((PartyListResponse) this.instance).getDataCase();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
        public PartyList getParties() {
            return ((PartyListResponse) this.instance).getParties();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
        public RemovedParties getRemoves() {
            return ((PartyListResponse) this.instance).getRemoves();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
        public UpdatedParties getUpdates() {
            return ((PartyListResponse) this.instance).getUpdates();
        }

        public Builder mergeParties(PartyList partyList) {
            copyOnWrite();
            ((PartyListResponse) this.instance).mergeParties(partyList);
            return this;
        }

        public Builder mergeRemoves(RemovedParties removedParties) {
            copyOnWrite();
            ((PartyListResponse) this.instance).mergeRemoves(removedParties);
            return this;
        }

        public Builder mergeUpdates(UpdatedParties updatedParties) {
            copyOnWrite();
            ((PartyListResponse) this.instance).mergeUpdates(updatedParties);
            return this;
        }

        public Builder setParties(PartyList partyList) {
            copyOnWrite();
            ((PartyListResponse) this.instance).setParties(partyList);
            return this;
        }

        public Builder setRemoves(RemovedParties removedParties) {
            copyOnWrite();
            ((PartyListResponse) this.instance).setRemoves(removedParties);
            return this;
        }

        public Builder setUpdates(UpdatedParties updatedParties) {
            copyOnWrite();
            ((PartyListResponse) this.instance).setUpdates(updatedParties);
            return this;
        }

        private Builder() {
            super(PartyListResponse.DEFAULT_INSTANCE);
        }

        public Builder setParties(PartyList.Builder builder) {
            copyOnWrite();
            ((PartyListResponse) this.instance).setParties(builder);
            return this;
        }

        public Builder setRemoves(RemovedParties.Builder builder) {
            copyOnWrite();
            ((PartyListResponse) this.instance).setRemoves(builder);
            return this;
        }

        public Builder setUpdates(UpdatedParties.Builder builder) {
            copyOnWrite();
            ((PartyListResponse) this.instance).setUpdates(builder);
            return this;
        }
    }

    public enum DataCase implements r.c {
        PARTIES(1),
        UPDATES(2),
        REMOVES(3),
        DATA_NOT_SET(0);

        private final int value;

        DataCase(int i) {
            this.value = i;
        }

        public static DataCase forNumber(int i) {
            if (i == 0) {
                return DATA_NOT_SET;
            }
            if (i == 1) {
                return PARTIES;
            }
            if (i == 2) {
                return UPDATES;
            }
            if (i != 3) {
                return null;
            }
            return REMOVES;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DataCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private PartyListResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.dataCase_ = 0;
        this.data_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParties() {
        if (this.dataCase_ == 1) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemoves() {
        if (this.dataCase_ == 3) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdates() {
        if (this.dataCase_ == 2) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    public static PartyListResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParties(PartyList partyList) {
        if (this.dataCase_ != 1 || this.data_ == PartyList.getDefaultInstance()) {
            this.data_ = partyList;
        } else {
            this.data_ = PartyList.newBuilder((PartyList) this.data_).mergeFrom(partyList).m64buildPartial();
        }
        this.dataCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRemoves(RemovedParties removedParties) {
        if (this.dataCase_ != 3 || this.data_ == RemovedParties.getDefaultInstance()) {
            this.data_ = removedParties;
        } else {
            this.data_ = RemovedParties.newBuilder((RemovedParties) this.data_).mergeFrom(removedParties).m64buildPartial();
        }
        this.dataCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdates(UpdatedParties updatedParties) {
        if (this.dataCase_ != 2 || this.data_ == UpdatedParties.getDefaultInstance()) {
            this.data_ = updatedParties;
        } else {
            this.data_ = UpdatedParties.newBuilder((UpdatedParties) this.data_).mergeFrom(updatedParties).m64buildPartial();
        }
        this.dataCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PartyListResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PartyListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PartyListResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<PartyListResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParties(PartyList partyList) {
        if (partyList == null) {
            throw new NullPointerException();
        }
        this.data_ = partyList;
        this.dataCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoves(RemovedParties removedParties) {
        if (removedParties == null) {
            throw new NullPointerException();
        }
        this.data_ = removedParties;
        this.dataCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdates(UpdatedParties updatedParties) {
        if (updatedParties == null) {
            throw new NullPointerException();
        }
        this.data_ = updatedParties;
        this.dataCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PartyListResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                PartyListResponse partyListResponse = (PartyListResponse) obj2;
                int i2 = AnonymousClass1.$SwitchMap$com$sandboxol$center$router$moduleInfo$game$team$teammgr$PartyListResponse$DataCase[partyListResponse.getDataCase().ordinal()];
                if (i2 == 1) {
                    this.data_ = iVar.b(this.dataCase_ == 1, this.data_, partyListResponse.data_);
                } else if (i2 == 2) {
                    this.data_ = iVar.b(this.dataCase_ == 2, this.data_, partyListResponse.data_);
                } else if (i2 == 3) {
                    this.data_ = iVar.b(this.dataCase_ == 3, this.data_, partyListResponse.data_);
                } else if (i2 == 4) {
                    iVar.a(this.dataCase_ != 0);
                }
                if (iVar == GeneratedMessageLite.h.f14297a && (i = partyListResponse.dataCase_) != 0) {
                    this.dataCase_ = i;
                }
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                C2306l c2306l = (C2306l) obj2;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 10) {
                                PartyList.Builder builder = this.dataCase_ == 1 ? ((PartyList) this.data_).toBuilder() : null;
                                this.data_ = c2301g.a(PartyList.parser(), c2306l);
                                if (builder != null) {
                                    builder.mergeFrom((PartyList) this.data_);
                                    this.data_ = builder.m64buildPartial();
                                }
                                this.dataCase_ = 1;
                            } else if (iQ == 18) {
                                UpdatedParties.Builder builder2 = this.dataCase_ == 2 ? ((UpdatedParties) this.data_).toBuilder() : null;
                                this.data_ = c2301g.a(UpdatedParties.parser(), c2306l);
                                if (builder2 != null) {
                                    builder2.mergeFrom((UpdatedParties) this.data_);
                                    this.data_ = builder2.m64buildPartial();
                                }
                                this.dataCase_ = 2;
                            } else if (iQ == 26) {
                                RemovedParties.Builder builder3 = this.dataCase_ == 3 ? ((RemovedParties) this.data_).toBuilder() : null;
                                this.data_ = c2301g.a(RemovedParties.parser(), c2306l);
                                if (builder3 != null) {
                                    builder3.mergeFrom((RemovedParties) this.data_);
                                    this.data_ = builder3.m64buildPartial();
                                }
                                this.dataCase_ = 3;
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
                    synchronized (PartyListResponse.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
    public DataCase getDataCase() {
        return DataCase.forNumber(this.dataCase_);
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
    public PartyList getParties() {
        return this.dataCase_ == 1 ? (PartyList) this.data_ : PartyList.getDefaultInstance();
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
    public RemovedParties getRemoves() {
        return this.dataCase_ == 3 ? (RemovedParties) this.data_ : RemovedParties.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iA = this.dataCase_ == 1 ? 0 + CodedOutputStream.a(1, (PartyList) this.data_) : 0;
        if (this.dataCase_ == 2) {
            iA += CodedOutputStream.a(2, (UpdatedParties) this.data_);
        }
        if (this.dataCase_ == 3) {
            iA += CodedOutputStream.a(3, (RemovedParties) this.data_);
        }
        this.memoizedSerializedSize = iA;
        return iA;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponseOrBuilder
    public UpdatedParties getUpdates() {
        return this.dataCase_ == 2 ? (UpdatedParties) this.data_ : UpdatedParties.getDefaultInstance();
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.dataCase_ == 1) {
            codedOutputStream.b(1, (PartyList) this.data_);
        }
        if (this.dataCase_ == 2) {
            codedOutputStream.b(2, (UpdatedParties) this.data_);
        }
        if (this.dataCase_ == 3) {
            codedOutputStream.b(3, (RemovedParties) this.data_);
        }
    }

    public static Builder newBuilder(PartyListResponse partyListResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(partyListResponse);
    }

    public static PartyListResponse parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (PartyListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static PartyListResponse parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static PartyListResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PartyListResponse parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParties(PartyList.Builder builder) {
        this.data_ = builder.build();
        this.dataCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoves(RemovedParties.Builder builder) {
        this.data_ = builder.build();
        this.dataCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdates(UpdatedParties.Builder builder) {
        this.data_ = builder.build();
        this.dataCase_ = 2;
    }

    public static PartyListResponse parseFrom(InputStream inputStream) throws IOException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PartyListResponse parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static PartyListResponse parseFrom(C2301g c2301g) throws IOException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static PartyListResponse parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (PartyListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
