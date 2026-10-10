package com.google.protobuf;

import com.google.protobuf.x;

/* JADX INFO: renamed from: com.google.protobuf.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractParser.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2296b<MessageType extends x> implements A<MessageType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C2306l f14341a = C2306l.a();

    private UninitializedMessageException b(MessageType messagetype) {
        return messagetype instanceof AbstractC2295a ? ((AbstractC2295a) messagetype).newUninitializedMessageException() : new UninitializedMessageException(messagetype);
    }

    private MessageType a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw b(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    public MessageType b(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        try {
            C2301g c2301gNewCodedInput = byteString.newCodedInput();
            MessageType messagetypeB = b(c2301gNewCodedInput, c2306l);
            try {
                c2301gNewCodedInput.a(0);
                return messagetypeB;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(messagetypeB);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    @Override // com.google.protobuf.A
    public MessageType a(C2301g c2301g, C2306l c2306l) throws InvalidProtocolBufferException {
        MessageType messagetypeB = b(c2301g, c2306l);
        a(messagetypeB);
        return messagetypeB;
    }

    public MessageType b(byte[] bArr, int i, int i2, C2306l c2306l) throws InvalidProtocolBufferException {
        try {
            C2301g c2301gA = C2301g.a(bArr, i, i2);
            MessageType messagetypeB = b(c2301gA, c2306l);
            try {
                c2301gA.a(0);
                return messagetypeB;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(messagetypeB);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    @Override // com.google.protobuf.A
    public MessageType a(ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) b(byteString, c2306l);
        a(messagetype);
        return messagetype;
    }

    public MessageType a(byte[] bArr, int i, int i2, C2306l c2306l) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) b(bArr, i, i2, c2306l);
        a(messagetype);
        return messagetype;
    }

    @Override // com.google.protobuf.A
    public MessageType a(byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        return (MessageType) a(bArr, 0, bArr.length, c2306l);
    }
}
