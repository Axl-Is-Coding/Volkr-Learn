package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

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
public final class RemoveMember extends GeneratedMessageLite<RemoveMember, Builder> implements RemoveMemberOrBuilder {
    private static final RemoveMember DEFAULT_INSTANCE = new RemoveMember();
    private static volatile A<RemoveMember> PARSER = null;
    public static final int USERID_FIELD_NUMBER = 1;
    private long userid_;

    /* JADX INFO: renamed from: com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveMember$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.a<RemoveMember, Builder> implements RemoveMemberOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearUserid() {
            copyOnWrite();
            ((RemoveMember) this.instance).clearUserid();
            return this;
        }

        @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveMemberOrBuilder
        public long getUserid() {
            return ((RemoveMember) this.instance).getUserid();
        }

        public Builder setUserid(long j) {
            copyOnWrite();
            ((RemoveMember) this.instance).setUserid(j);
            return this;
        }

        private Builder() {
            super(RemoveMember.DEFAULT_INSTANCE);
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    private RemoveMember() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserid() {
        this.userid_ = 0L;
    }

    public static RemoveMember getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RemoveMember parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RemoveMember) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoveMember parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static A<RemoveMember> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserid(long j) {
        this.userid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoveMember();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                RemoveMember removeMember = (RemoveMember) obj2;
                this.userid_ = ((GeneratedMessageLite.i) obj).a(this.userid_ != 0, this.userid_, removeMember.userid_ != 0, removeMember.userid_);
                GeneratedMessageLite.h hVar = GeneratedMessageLite.h.f14297a;
                return this;
            case 6:
                C2301g c2301g = (C2301g) obj;
                while (!z) {
                    try {
                        int iQ = c2301g.q();
                        if (iQ != 0) {
                            if (iQ == 8) {
                                this.userid_ = c2301g.r();
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
                    synchronized (RemoveMember.class) {
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
        long j = this.userid_;
        int iB = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        this.memoizedSerializedSize = iB;
        return iB;
    }

    @Override // com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveMemberOrBuilder
    public long getUserid() {
        return this.userid_;
    }

    @Override // com.google.protobuf.x
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.userid_;
        if (j != 0) {
            codedOutputStream.d(1, j);
        }
    }

    public static Builder newBuilder(RemoveMember removeMember) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(removeMember);
    }

    public static RemoveMember parseDelimitedFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemoveMember) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemoveMember parseFrom(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, c2306l);
    }

    public static RemoveMember parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RemoveMember parseFrom(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2306l);
    }

    public static RemoveMember parseFrom(InputStream inputStream) throws IOException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoveMember parseFrom(InputStream inputStream, C2306l c2306l) throws IOException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2306l);
    }

    public static RemoveMember parseFrom(C2301g c2301g) throws IOException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g);
    }

    public static RemoveMember parseFrom(C2301g c2301g, C2306l c2306l) throws IOException {
        return (RemoveMember) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, c2301g, c2306l);
    }
}
