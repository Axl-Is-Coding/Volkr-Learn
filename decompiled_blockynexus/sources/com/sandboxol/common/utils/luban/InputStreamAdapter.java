package com.sandboxol.common.utils.luban;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InputStreamAdapter implements InputStreamProvider {
    private InputStream inputStream;

    @Override // com.sandboxol.common.utils.luban.InputStreamProvider
    public void close() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.inputStream = null;
                throw th;
            }
            this.inputStream = null;
        }
    }

    @Override // com.sandboxol.common.utils.luban.InputStreamProvider
    public InputStream open() throws IOException {
        close();
        this.inputStream = openInternal();
        return this.inputStream;
    }

    public abstract InputStream openInternal() throws IOException;
}
