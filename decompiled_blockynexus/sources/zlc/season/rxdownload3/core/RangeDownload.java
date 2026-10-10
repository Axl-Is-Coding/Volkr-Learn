package zlc.season.rxdownload3.core;

import io.reactivex.b.a;
import io.reactivex.b.g;
import io.reactivex.b.o;
import io.reactivex.e;
import io.reactivex.f.b;
import io.reactivex.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.i;
import okhttp3.J;
import retrofit2.Response;
import zlc.season.rxdownload3.core.RangeTmpFile;
import zlc.season.rxdownload3.helper.LoggerKt;
import zlc.season.rxdownload3.http.HttpCore;

/* JADX INFO: compiled from: RangeDownload.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RangeDownload extends DownloadType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RangeTargetFile f23706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RangeTmpFile f23707c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeDownload(RealMission realMission) {
        super(realMission);
        i.b(realMission, "mission");
        this.f23706b = new RangeTargetFile(realMission);
        this.f23707c = new RangeTmpFile(realMission);
    }

    private final boolean f() {
        return this.f23707c.g() && this.f23706b.c();
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public File c() {
        if (f()) {
            return this.f23706b.e();
        }
        return null;
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public void e() {
        Status statusB = this.f23707c.b();
        d().c(f() ? new Succeed(statusB) : new Normal(statusB));
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public void a() {
        this.f23706b.b();
        this.f23707c.c();
    }

    @Override // zlc.season.rxdownload3.core.DownloadType
    public e<? extends Status> b() {
        if (f()) {
            e<? extends Status> eVarB = e.b();
            i.a((Object) eVarB, "Flowable.empty()");
            return eVarB;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f23706b.d()) {
            this.f23707c.a();
        } else {
            this.f23706b.a();
            this.f23707c.h();
        }
        List<RangeTmpFile.Segment> listF = this.f23707c.f();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listF) {
            if (!((RangeTmpFile.Segment) obj).e()) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(a((RangeTmpFile.Segment) it.next()));
        }
        e<? extends Status> eVarC = e.a(arrayList, DownloadConfig.r.k()).c((o) new o<T, R>() { // from class: zlc.season.rxdownload3.core.RangeDownload$download$3
            @Override // io.reactivex.b.o
            public final Downloading apply(Object obj2) {
                i.b(obj2, "it");
                return new Downloading(this.f23708a.f23707c.b());
            }
        }).c(new a() { // from class: zlc.season.rxdownload3.core.RangeDownload$download$4
            @Override // io.reactivex.b.a
            public final void run() {
                this.f23709a.f23706b.f();
            }
        });
        i.a((Object) eVarC, "Flowable.mergeDelayError…e { targetFile.rename() }");
        return eVarC;
    }

    private final e<Object> a(final RangeTmpFile.Segment segment) {
        e<Object> eVarB = io.reactivex.i.a(segment).a(b.b()).c(new o<T, R>() { // from class: zlc.season.rxdownload3.core.RangeDownload$rangeDownload$1
            @Override // io.reactivex.b.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String apply(RangeTmpFile.Segment segment2) {
                i.b(segment2, "it");
                return "bytes=" + segment2.a() + '-' + segment2.b();
            }
        }).b(new g<String>() { // from class: zlc.season.rxdownload3.core.RangeDownload$rangeDownload$2
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(String str) {
                LoggerKt.a("Range: " + str);
            }
        }).a((o) new o<T, m<? extends R>>() { // from class: zlc.season.rxdownload3.core.RangeDownload$rangeDownload$3
            @Override // io.reactivex.b.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final io.reactivex.i<Response<J>> apply(String str) {
                i.b(str, "it");
                return HttpCore.f23837b.a(this.f23712a.d(), str);
            }
        }).b((o) new o<T, f.b.b<? extends R>>() { // from class: zlc.season.rxdownload3.core.RangeDownload$rangeDownload$4
            @Override // io.reactivex.b.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e<Object> apply(Response<J> response) {
                i.b(response, "it");
                return this.f23713a.f23706b.a(response, segment, this.f23713a.f23707c);
            }
        });
        i.a((Object) eVarB, "Maybe.just(segment)\n    …e(it, segment, tmpFile) }");
        return eVarB;
    }
}
