package com.google.firebase.encoders;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
interface Encoder<TValue, TContext> {
    void encode(TValue tvalue, TContext tcontext) throws IOException;
}
