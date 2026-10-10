package zlc.season.rxdownload4.a.b;

import io.rong.common.LibStorageUtils;
import java.io.File;
import kotlin.jvm.internal.i;
import okhttp3.J;
import retrofit2.Response;

/* JADX INFO: compiled from: SimpleValidator.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23867a = new a();

    private a() {
    }

    @Override // zlc.season.rxdownload4.a.b.b
    public boolean a(File file, Response<J> response) {
        i.b(file, LibStorageUtils.FILE);
        i.b(response, "response");
        return file.length() == zlc.season.rxdownload4.download.utils.b.a(response);
    }
}
