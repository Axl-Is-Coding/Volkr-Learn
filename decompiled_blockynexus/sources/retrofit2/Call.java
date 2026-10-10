package retrofit2;

import java.io.IOException;
import okhttp3.C;

/* JADX INFO: loaded from: classes5.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    Call<T> mo146clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    C request();
}
