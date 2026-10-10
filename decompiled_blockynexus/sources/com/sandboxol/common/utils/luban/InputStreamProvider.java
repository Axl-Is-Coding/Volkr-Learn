package com.sandboxol.common.utils.luban;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface InputStreamProvider {
    void close();

    String getPath();

    InputStream open() throws IOException;
}
