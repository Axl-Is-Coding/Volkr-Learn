package okhttp3;

import java.io.IOException;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface Call extends Cloneable {

    public interface Factory {
        Call newCall(C c2);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    H execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    C request();

    Timeout timeout();
}
