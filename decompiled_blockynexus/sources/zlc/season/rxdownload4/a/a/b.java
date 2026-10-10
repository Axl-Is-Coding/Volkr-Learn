package zlc.season.rxdownload4.a.a;

import io.reactivex.b.g;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.i;
import okhttp3.J;
import retrofit2.Response;

/* JADX INFO: compiled from: TaskInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
final class b<T> implements g<Response<J>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f23854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f23855b;

    b(e eVar, Ref$BooleanRef ref$BooleanRef) {
        this.f23854a = eVar;
        this.f23855b = ref$BooleanRef;
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Response<J> response) {
        i.a((Object) response, "it");
        if (!response.isSuccessful()) {
            throw new IllegalStateException("Request failed!");
        }
        double dA = zlc.season.rxdownload4.download.utils.b.a(response);
        Double.isNaN(dA);
        if (!(dA * 1.5d < ((double) zlc.season.rxdownload4.download.utils.d.a()))) {
            throw new IllegalStateException("no space left on device");
        }
        if (this.f23854a.f().a().length() == 0) {
            this.f23854a.f().a(zlc.season.rxdownload4.download.utils.b.b(response));
        }
        if (this.f23854a.f().b().length() == 0) {
            this.f23854a.f().b(zlc.season.rxdownload4.a.b.a());
        }
        this.f23854a.h().a(this.f23854a.f());
        this.f23855b.element = true;
        this.f23854a.e().b(this.f23854a.f());
    }
}
