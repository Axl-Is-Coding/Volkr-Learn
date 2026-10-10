package zlc.season.rxdownload3.http;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.i;
import okhttp3.z;

/* JADX INFO: compiled from: OkHttpClientFactoryImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class OkHttpClientFactoryImpl implements OkHttpClientFactory {
    @Override // zlc.season.rxdownload3.http.OkHttpClientFactory
    public z build() {
        z.a aVarR = new z().r();
        aVarR.b(10L, TimeUnit.SECONDS);
        aVarR.c(15L, TimeUnit.SECONDS);
        aVarR.d(15L, TimeUnit.SECONDS);
        z zVarA = aVarR.a();
        i.a((Object) zVarA, "builder.build()");
        return zVarA;
    }
}
