package io.rong.imlib.filetransfer.upload;

import io.rong.imlib.filetransfer.CallDispatcher;
import io.rong.imlib.filetransfer.CancelCallback;
import io.rong.imlib.filetransfer.Configuration;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMediaFileService {
    private String mediaPath;
    private CallDispatcher DEFAULT_DISPATCHER = new CallDispatcher();
    private Configuration DEFAULT_CONFIGURATION = new Configuration.Builder().connectTimeout(30).readTimeout(60).build();

    public void cancel(int i, CancelCallback cancelCallback) {
        if (i > 0) {
            dispatcher().cancel(Integer.valueOf(i), cancelCallback);
        }
    }

    protected CallDispatcher dispatcher() {
        return this.DEFAULT_DISPATCHER;
    }

    protected Configuration getConfiguration() {
        return this.DEFAULT_CONFIGURATION;
    }

    public String getMediaPath() {
        return this.mediaPath;
    }

    public void setMediaPath(String str) {
        this.mediaPath = str;
    }
}
