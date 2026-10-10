package com.google.firebase.encoders;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ObjectEncoder<T> extends Encoder<T, ObjectEncoderContext> {
    @Override // com.google.firebase.encoders.Encoder
    /* synthetic */ void encode(TValue tvalue, TContext tcontext) throws IOException;
}
