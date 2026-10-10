package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: MessageLite.java */
/* JADX INFO: loaded from: classes2.dex */
public interface x extends y {

    /* JADX INFO: compiled from: MessageLite.java */
    public interface a extends y, Cloneable {
        x build();

        a mergeFrom(x xVar);
    }

    A<? extends x> getParserForType();

    int getSerializedSize();

    a toBuilder();

    byte[] toByteArray();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;

    void writeTo(OutputStream outputStream) throws IOException;
}
