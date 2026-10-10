package zlc.season.rxdownload3.core;

import f.b.b;
import io.reactivex.b.o;
import io.reactivex.e;
import io.reactivex.m;
import java.io.File;
import kotlin.jvm.internal.i;
import okhttp3.J;
import retrofit2.Response;
import zlc.season.rxdownload3.helper.UtilsKt;
import zlc.season.rxdownload3.http.HttpCore;

/* JADX INFO: compiled from: NormalDownload.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NormalDownload extends DownloadType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NormalTargetFile f23693b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalDownload(RealMission realMission) {
        super(realMission);
        i.b(realMission, "mission");
        this.f23693b = new NormalTargetFile(realMission);
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public e<? extends Status> b() {
        if (this.f23693b.d()) {
            e<? extends Status> eVarB = e.b();
            i.a((Object) eVarB, "Flowable.empty()");
            return eVarB;
        }
        this.f23693b.a();
        e<? extends Status> eVarB2 = io.reactivex.i.a(UtilsKt.a()).a((o) new o<T, m<? extends R>>() { // from class: zlc.season.rxdownload3.core.NormalDownload$download$1
            @Override // io.reactivex.b.o
            public final io.reactivex.i<Response<J>> apply(Object obj) {
                i.b(obj, "it");
                return HttpCore.a(HttpCore.f23837b, this.f23694a.d(), null, 2, null);
            }
        }).b((o) new o<T, b<? extends R>>() { // from class: zlc.season.rxdownload3.core.NormalDownload$download$2
            @Override // io.reactivex.b.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e<Status> apply(Response<J> response) {
                i.b(response, "it");
                return this.f23695a.f23693b.a(response);
            }
        });
        i.a((Object) eVarB2, "Maybe.just(ANY)\n        …ave(it)\n                }");
        return eVarB2;
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public File c() {
        if (this.f23693b.d()) {
            return this.f23693b.e();
        }
        return null;
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public void e() {
        Status statusC = this.f23693b.c();
        d().c(this.f23693b.d() ? new Succeed(statusC) : new Normal(statusC));
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public void a() {
        this.f23693b.b();
    }
}
