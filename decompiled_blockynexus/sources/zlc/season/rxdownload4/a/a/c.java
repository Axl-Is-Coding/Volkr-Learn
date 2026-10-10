package zlc.season.rxdownload4.a.a;

import io.reactivex.b.o;
import kotlin.jvm.internal.i;
import okhttp3.J;
import retrofit2.Response;

/* JADX INFO: compiled from: TaskInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
final class c<T, R> implements o<T, f.b.b<? extends R>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f23856a;

    c(e eVar) {
        this.f23856a = eVar;
    }

    @Override // io.reactivex.b.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final io.reactivex.e<zlc.season.rxdownload4.a.a> apply(Response<J> response) {
        i.b(response, "it");
        return this.f23856a.a().a(response).a(this.f23856a, response);
    }
}
