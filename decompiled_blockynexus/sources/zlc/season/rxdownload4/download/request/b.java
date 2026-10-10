package zlc.season.rxdownload4.download.request;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.i;
import okhttp3.z;

/* JADX INFO: compiled from: Retrofiter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final z f23924a;

    static {
        z.a aVarR = new z().r();
        aVarR.b(15L, TimeUnit.SECONDS);
        aVarR.c(30L, TimeUnit.SECONDS);
        aVarR.d(30L, TimeUnit.SECONDS);
        z zVarA = aVarR.a();
        i.a((Object) zVarA, "OkHttpClient().newBuilde…SECONDS)\n        .build()");
        f23924a = zVarA;
    }

    public static final z a() {
        return f23924a;
    }
}
