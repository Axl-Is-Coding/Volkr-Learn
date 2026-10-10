package zlc.season.rxdownload4.a.a;

import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: TaskInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f23859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f23860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f23862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zlc.season.rxdownload4.download.downloader.b f23863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zlc.season.rxdownload4.a.b.b f23864f;
    private final zlc.season.rxdownload4.download.storage.c g;
    private final zlc.season.rxdownload4.download.request.a h;
    private final zlc.season.rxdownload4.a.c.a i;

    public e(a aVar, Map<String, String> map, int i, long j, zlc.season.rxdownload4.download.downloader.b bVar, zlc.season.rxdownload4.a.b.b bVar2, zlc.season.rxdownload4.download.storage.c cVar, zlc.season.rxdownload4.download.request.a aVar2, zlc.season.rxdownload4.a.c.a aVar3) {
        i.b(aVar, "task");
        i.b(map, "header");
        i.b(bVar, "dispatcher");
        i.b(bVar2, "validator");
        i.b(cVar, "storage");
        i.b(aVar2, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        i.b(aVar3, "watcher");
        this.f23859a = aVar;
        this.f23860b = map;
        this.f23861c = i;
        this.f23862d = j;
        this.f23863e = bVar;
        this.f23864f = bVar2;
        this.g = cVar;
        this.h = aVar2;
        this.i = aVar3;
    }

    public final zlc.season.rxdownload4.download.downloader.b a() {
        return this.f23863e;
    }

    public final int b() {
        return this.f23861c;
    }

    public final long c() {
        return this.f23862d;
    }

    public final zlc.season.rxdownload4.download.request.a d() {
        return this.h;
    }

    public final zlc.season.rxdownload4.download.storage.c e() {
        return this.g;
    }

    public final a f() {
        return this.f23859a;
    }

    public final zlc.season.rxdownload4.a.b.b g() {
        return this.f23864f;
    }

    public final zlc.season.rxdownload4.a.c.a h() {
        return this.i;
    }

    public final io.reactivex.e<zlc.season.rxdownload4.a.a> i() {
        this.g.c(this.f23859a);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        io.reactivex.e<zlc.season.rxdownload4.a.a> eVarA = this.h.get(this.f23859a.d(), this.f23860b).b(new b(this, ref$BooleanRef)).b(new c(this)).a(new d(this, ref$BooleanRef));
        i.a((Object) eVarA, "request.get(task.url, he…      }\n                }");
        return eVarA;
    }
}
