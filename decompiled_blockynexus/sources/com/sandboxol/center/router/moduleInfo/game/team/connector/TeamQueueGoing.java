package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.A;
import com.google.protobuf.ByteString;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class TeamQueueGoing extends GeneratedMessageLite<TeamQueueGoing, Builder> implements TeamQueueGoingOrBuilder {
    private static final TeamQueueGoing DEFAULT_INSTANCE = new TeamQueueGoing();
    public static final int LENGTH_FIELD_NUMBER = 2;
    private static volatile A<TeamQueueGoing> PARSER = null;
    public static final int RANK_FIELD_NUMBER = 1;
    private int length_;
    private int rank_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueGoing$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<TeamQueueGoing, Builder> implements TeamQueueGoingOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearLength() {
            copyOnWrite();
            ((TeamQueueGoing) this.instance).clearLength();
            return this;
        }

        public Builder clearRank() {
            copyOnWrite();
            ((TeamQueueGoing) this.instance).clearRank();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueGoingOrBuilder
        public int getLength() {
            return ((TeamQueueGoing) this.instance).getLength();
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueGoingOrBuilder
        public int getRank() {
            return ((TeamQueueGoing) this.instance).getRank();
        }

        public Builder setLength(int i) {
            copyOnWrite();
            ((TeamQueueGoing) this.instance).setLength(i);
            return this;
        }

        public Builder setRank(int i) {
            copyOnWrite();
            ((TeamQueueGoing) this.instance).setRank(i);
            return this;
        }

        private Builder() {
            super(TeamQueueGoing.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private TeamQueueGoing() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLength() {
        this.length_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRank() {
        this.rank_ = 0;
    }

    public static TeamQueueGoing getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static TeamQueueGoing parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TeamQueueGoing) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueGoing parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<TeamQueueGoing> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLength(int i) {
        this.length_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRank(int i) {
        this.rank_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TeamQueueGoing();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.i iVar = (GeneratedMessageLite.i) obj;
                TeamQueueGoing teamQueueGoing = (TeamQueueGoing) obj2;
                this.rank_ = iVar.a(this.rank_ != 0, this.rank_, teamQueueGoing.rank_ != 0, teamQueueGoing.rank_);
                this.length_ = iVar.a(this.length_ != 0, this.length_, teamQueueGoing.length_ != 0, teamQueueGoing.length_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 8) {
                                this.rank_ = c2301g.h();
                            } else if (iQ == 16) {
                                this.length_ = c2301g.h();
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
                    synchronized (TeamQueueGoing.class) {
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

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueGoingOrBuilder
    public int getLength() {
        return this.length_;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueGoingOrBuilder
    public int getRank() {
        return this.rank_;
    }

    @Override // com.google.protobuf.x
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.rank_;
        int iB = i2 != 0 ? 0 + CodedOutputStream.b(1, i2) : 0;
        int i3 = this.length_;
        if (i3 != 0) {
            iB += CodedOutputStream.b(2, i3);
        }
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.rank_;
        if (i != 0) {
            codedOutputStream.d(1, i);
        }
        int i2 = this.length_;
        if (i2 != 0) {
            codedOutputStream.d(2, i2);
        }
    }

    public static Builder newBuilder(TeamQueueGoing teamQueueGoing) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(teamQueueGoing);
    }

    public static TeamQueueGoing parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueGoing) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueGoing parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static TeamQueueGoing parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TeamQueueGoing parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static TeamQueueGoing parseFrom(InputStream inputStream) throws IOException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TeamQueueGoing parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static TeamQueueGoing parseFrom(C2301g c2301g) throws IOException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static TeamQueueGoing parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (TeamQueueGoing) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
