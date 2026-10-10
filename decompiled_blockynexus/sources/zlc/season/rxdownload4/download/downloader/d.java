package zlc.season.rxdownload4.download.downloader;

import io.rong.common.LibStorageUtils;
import java.io.File;
import java.io.IOException;
import okhttp3.J;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import retrofit2.Response;

/* JADX INFO: compiled from: NormalDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f23873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f23874c;

    /* JADX INFO: compiled from: NormalDownloader.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f23875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferedSink f23876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Buffer f23877c;

        public a(BufferedSource bufferedSource, BufferedSink bufferedSink, Buffer buffer) {
            kotlin.jvm.internal.i.b(bufferedSource, "source");
            kotlin.jvm.internal.i.b(bufferedSink, "sink");
            kotlin.jvm.internal.i.b(buffer, "buffer");
            this.f23875a = bufferedSource;
            this.f23876b = bufferedSink;
            this.f23877c = buffer;
        }

        public final Buffer a() {
            return this.f23877c;
        }

        public final BufferedSink b() {
            return this.f23876b;
        }

        public final BufferedSource c() {
            return this.f23875a;
        }

        public /* synthetic */ a(BufferedSource bufferedSource, BufferedSink bufferedSink, Buffer buffer, int i, kotlin.jvm.internal.f fVar) {
            this(bufferedSource, bufferedSink, (i & 4) != 0 ? bufferedSink.getBuffer() : buffer);
        }
    }

    public static final /* synthetic */ File a(d dVar) {
        File file = dVar.f23873b;
        if (file != null) {
            return file;
        }
        kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
        throw null;
    }

    public static final /* synthetic */ File b(d dVar) {
        File file = dVar.f23874c;
        if (file != null) {
            return file;
        }
        kotlin.jvm.internal.i.c("shadowFile");
        throw null;
    }

    private final void b(zlc.season.rxdownload4.a.a.e eVar, Response<J> response) throws IOException {
        File fileA = zlc.season.rxdownload4.download.utils.a.a(eVar.f());
        if (!fileA.exists() || !fileA.isDirectory()) {
            fileA.mkdirs();
        }
        File file = this.f23873b;
        if (file == null) {
            kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
            throw null;
        }
        if (!file.exists()) {
            File file2 = this.f23874c;
            if (file2 != null) {
                zlc.season.rxdownload4.download.utils.a.a(file2, 0L, null, 3, null);
                return;
            } else {
                kotlin.jvm.internal.i.c("shadowFile");
                throw null;
            }
        }
        zlc.season.rxdownload4.a.b.b bVarG = eVar.g();
        File file3 = this.f23873b;
        if (file3 == null) {
            kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
            throw null;
        }
        if (bVarG.a(file3, response)) {
            this.f23872a = true;
            return;
        }
        File file4 = this.f23873b;
        if (file4 == null) {
            kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
            throw null;
        }
        file4.delete();
        File file5 = this.f23874c;
        if (file5 != null) {
            zlc.season.rxdownload4.download.utils.a.a(file5, 0L, null, 3, null);
        } else {
            kotlin.jvm.internal.i.c("shadowFile");
            throw null;
        }
    }

    @Override // zlc.season.rxdownload4.download.downloader.c
    public io.reactivex.e<zlc.season.rxdownload4.a.a> a(zlc.season.rxdownload4.a.a.e eVar, Response<J> response) throws IOException {
        kotlin.jvm.internal.i.b(eVar, "taskInfo");
        kotlin.jvm.internal.i.b(response, "response");
        J jBody = response.body();
        if (jBody == null) {
            throw new RuntimeException("Response body is NULL");
        }
        kotlin.jvm.internal.i.a((Object) jBody, "response.body() ?: throw…(\"Response body is NULL\")");
        this.f23873b = zlc.season.rxdownload4.download.utils.a.b(eVar.f());
        File file = this.f23873b;
        if (file == null) {
            kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
            throw null;
        }
        this.f23874c = zlc.season.rxdownload4.download.utils.a.c(file);
        b(eVar, response);
        if (!this.f23872a) {
            return a(jBody, new zlc.season.rxdownload4.a.a(0L, zlc.season.rxdownload4.download.utils.b.a(response), zlc.season.rxdownload4.download.utils.b.c(response), eVar.f().d(), 1, null));
        }
        io.reactivex.e<zlc.season.rxdownload4.a.a> eVarA = io.reactivex.e.a(new zlc.season.rxdownload4.a.a(zlc.season.rxdownload4.download.utils.b.a(response), zlc.season.rxdownload4.download.utils.b.a(response), false, eVar.f().d(), 4, null));
        kotlin.jvm.internal.i.a((Object) eVarA, "Flowable.just(Progress(\n…o.task.url\n            ))");
        return eVarA;
    }

    private final io.reactivex.e<zlc.season.rxdownload4.a.a> a(J j, zlc.season.rxdownload4.a.a aVar) {
        io.reactivex.e<zlc.season.rxdownload4.a.a> eVarA = io.reactivex.e.a(new e(this, j), new f(this, aVar), g.f23882a);
        kotlin.jvm.internal.i.a((Object) eVarA, "generate(\n              …     }\n                })");
        return eVarA;
    }
}
