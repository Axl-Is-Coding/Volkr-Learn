package io.grpc.internal;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface StreamListener {
    void messageRead(InputStream inputStream);

    void onReady();
}
