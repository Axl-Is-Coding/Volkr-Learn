package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public interface Interceptor {

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        H proceed(C c2) throws IOException;

        int readTimeoutMillis();

        C request();

        Chain withConnectTimeout(int i, TimeUnit timeUnit);

        Chain withReadTimeout(int i, TimeUnit timeUnit);

        Chain withWriteTimeout(int i, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    H intercept(Chain chain) throws IOException;
}
