package zlc.season.rxdownload4.download.downloader;

import com.facebook.share.internal.ShareConstants;
import io.rong.common.LibStorageUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import kotlin.Pair;
import okhttp3.J;
import retrofit2.Response;
import zlc.season.rxdownload4.download.downloader.q;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f23892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f23893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f23894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private q f23895e;

    /* JADX INFO: compiled from: RangeDownloader.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q.c f23897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final File f23898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File f23899d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final zlc.season.rxdownload4.download.request.a f23900e;

        public a(String str, q.c cVar, File file, File file2, zlc.season.rxdownload4.download.request.a aVar) {
            kotlin.jvm.internal.i.b(str, "url");
            kotlin.jvm.internal.i.b(cVar, "segment");
            kotlin.jvm.internal.i.b(file, "shadowFile");
            kotlin.jvm.internal.i.b(file2, "tmpFile");
            kotlin.jvm.internal.i.b(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            this.f23896a = str;
            this.f23897b = cVar;
            this.f23898c = file;
            this.f23899d = file2;
            this.f23900e = aVar;
        }

        public final io.reactivex.e<Long> a() {
            io.reactivex.e<Long> eVarB = io.reactivex.e.a(this.f23897b).b(io.reactivex.f.b.b()).c(h.f23883a).b(new i(this)).b(new j(this));
            kotlin.jvm.internal.i.a((Object) eVarB, "Flowable.just(segment)\n … rangeSave(segment, it) }");
            return eVarB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final io.reactivex.e<Long> a(q.c cVar, Response<J> response) {
            J jBody = response.body();
            if (jBody != null) {
                kotlin.jvm.internal.i.a((Object) jBody, "response.body() ?: throw…(\"Response body is NULL\")");
                io.reactivex.e<Long> eVarA = io.reactivex.e.a(new k(this, jBody, cVar), l.f23889a, m.f23890a);
                kotlin.jvm.internal.i.a((Object) eVarA, "Flowable.generate(\n     …()\n                    })");
                return eVarA;
            }
            throw new RuntimeException("Response body is NULL");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b a(J j, q.c cVar) throws IOException {
            InputStream inputStreamByteStream = j.byteStream();
            FileChannel fileChannelA = zlc.season.rxdownload4.download.utils.a.a(this.f23898c);
            FileChannel fileChannelA2 = zlc.season.rxdownload4.download.utils.a.a(this.f23899d);
            MappedByteBuffer map = fileChannelA2.map(FileChannel.MapMode.READ_WRITE, cVar.f(), 32L);
            MappedByteBuffer map2 = fileChannelA.map(FileChannel.MapMode.READ_WRITE, cVar.b(), cVar.e());
            kotlin.jvm.internal.i.a((Object) inputStreamByteStream, "source");
            kotlin.jvm.internal.i.a((Object) map, "tmpFileBuffer");
            kotlin.jvm.internal.i.a((Object) map2, "shadowFileBuffer");
            return new b(inputStreamByteStream, fileChannelA, fileChannelA2, map, map2, cVar.b());
        }
    }

    /* JADX INFO: compiled from: RangeDownloader.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f23901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FileChannel f23902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FileChannel f23903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MappedByteBuffer f23904d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private MappedByteBuffer f23905e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f23906f;

        public b(InputStream inputStream, FileChannel fileChannel, FileChannel fileChannel2, MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, long j) {
            kotlin.jvm.internal.i.b(inputStream, "source");
            kotlin.jvm.internal.i.b(fileChannel, "shadowChannel");
            kotlin.jvm.internal.i.b(fileChannel2, "tmpFileChannel");
            kotlin.jvm.internal.i.b(mappedByteBuffer, "tmpFileBuffer");
            kotlin.jvm.internal.i.b(mappedByteBuffer2, "shadowFileBuffer");
            this.f23901a = inputStream;
            this.f23902b = fileChannel;
            this.f23903c = fileChannel2;
            this.f23904d = mappedByteBuffer;
            this.f23905e = mappedByteBuffer2;
            this.f23906f = j;
        }

        public final long a() {
            return this.f23906f;
        }

        public final FileChannel b() {
            return this.f23902b;
        }

        public final MappedByteBuffer c() {
            return this.f23905e;
        }

        public final InputStream d() {
            return this.f23901a;
        }

        public final MappedByteBuffer e() {
            return this.f23904d;
        }

        public final FileChannel f() {
            return this.f23903c;
        }

        public final void a(long j) {
            this.f23906f = j;
        }
    }

    public static final /* synthetic */ File a(n nVar) {
        File file = nVar.f23892b;
        if (file != null) {
            return file;
        }
        kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
        throw null;
    }

    public static final /* synthetic */ q b(n nVar) {
        q qVar = nVar.f23895e;
        if (qVar != null) {
            return qVar;
        }
        kotlin.jvm.internal.i.c("rangeTmpFile");
        throw null;
    }

    public static final /* synthetic */ File c(n nVar) {
        File file = nVar.f23893c;
        if (file != null) {
            return file;
        }
        kotlin.jvm.internal.i.c("shadowFile");
        throw null;
    }

    public static final /* synthetic */ File d(n nVar) {
        File file = nVar.f23894d;
        if (file != null) {
            return file;
        }
        kotlin.jvm.internal.i.c("tmpFile");
        throw null;
    }

    private final void b(zlc.season.rxdownload4.a.a.e eVar, Response<J> response) throws IOException {
        File fileA = zlc.season.rxdownload4.download.utils.a.a(eVar.f());
        if (!fileA.exists() || !fileA.isDirectory()) {
            fileA.mkdirs();
        }
        File file = this.f23892b;
        if (file == null) {
            kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
            throw null;
        }
        if (file.exists()) {
            zlc.season.rxdownload4.a.b.b bVarG = eVar.g();
            File file2 = this.f23892b;
            if (file2 == null) {
                kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
                throw null;
            }
            if (bVarG.a(file2, response)) {
                this.f23891a = true;
                return;
            }
            File file3 = this.f23892b;
            if (file3 == null) {
                kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
                throw null;
            }
            file3.delete();
            a(response, eVar);
            return;
        }
        File file4 = this.f23893c;
        if (file4 == null) {
            kotlin.jvm.internal.i.c("shadowFile");
            throw null;
        }
        if (file4.exists()) {
            File file5 = this.f23894d;
            if (file5 == null) {
                kotlin.jvm.internal.i.c("tmpFile");
                throw null;
            }
            if (file5.exists()) {
                File file6 = this.f23894d;
                if (file6 == null) {
                    kotlin.jvm.internal.i.c("tmpFile");
                    throw null;
                }
                this.f23895e = new q(file6);
                q qVar = this.f23895e;
                if (qVar == null) {
                    kotlin.jvm.internal.i.c("rangeTmpFile");
                    throw null;
                }
                if (qVar.a(response, eVar)) {
                    return;
                }
                a(response, eVar);
                return;
            }
        }
        a(response, eVar);
    }

    private final io.reactivex.e<zlc.season.rxdownload4.a.a> c(zlc.season.rxdownload4.a.a.e eVar, Response<J> response) {
        String strE = zlc.season.rxdownload4.download.utils.b.e(response);
        q qVar = this.f23895e;
        if (qVar == null) {
            kotlin.jvm.internal.i.c("rangeTmpFile");
            throw null;
        }
        Pair<Long, Long> pairA = qVar.a();
        zlc.season.rxdownload4.a.a aVar = new zlc.season.rxdownload4.a.a(pairA.component1().longValue(), pairA.component2().longValue(), false, eVar.f().d(), 4, null);
        ArrayList arrayList = new ArrayList();
        q qVar2 = this.f23895e;
        if (qVar2 == null) {
            kotlin.jvm.internal.i.c("rangeTmpFile");
            throw null;
        }
        for (q.c cVar : qVar2.b()) {
            File file = this.f23893c;
            if (file == null) {
                kotlin.jvm.internal.i.c("shadowFile");
                throw null;
            }
            File file2 = this.f23894d;
            if (file2 == null) {
                kotlin.jvm.internal.i.c("tmpFile");
                throw null;
            }
            arrayList.add(new a(strE, cVar, file, file2, eVar.d()).a());
            aVar = aVar;
        }
        io.reactivex.e<zlc.season.rxdownload4.a.a> eVarC = io.reactivex.e.a(arrayList, eVar.b()).c(new o(aVar)).c(new p(this, response));
        kotlin.jvm.internal.i.a((Object) eVarC, "Flowable.mergeDelayError…ietly()\n                }");
        return eVarC;
    }

    @Override // zlc.season.rxdownload4.download.downloader.c
    public io.reactivex.e<zlc.season.rxdownload4.a.a> a(zlc.season.rxdownload4.a.a.e eVar, Response<J> response) throws IOException {
        kotlin.jvm.internal.i.b(eVar, "taskInfo");
        kotlin.jvm.internal.i.b(response, "response");
        this.f23892b = zlc.season.rxdownload4.download.utils.a.b(eVar.f());
        File file = this.f23892b;
        if (file != null) {
            this.f23893c = zlc.season.rxdownload4.download.utils.a.c(file);
            File file2 = this.f23892b;
            if (file2 != null) {
                this.f23894d = zlc.season.rxdownload4.download.utils.a.d(file2);
                b(eVar, response);
                if (this.f23891a) {
                    io.reactivex.e<zlc.season.rxdownload4.a.a> eVarA = io.reactivex.e.a(new zlc.season.rxdownload4.a.a(zlc.season.rxdownload4.download.utils.b.a(response), zlc.season.rxdownload4.download.utils.b.a(response), false, eVar.f().d(), 4, null));
                    kotlin.jvm.internal.i.a((Object) eVarA, "Flowable.just(Progress(\n…o.task.url\n            ))");
                    return eVarA;
                }
                return c(eVar, response);
            }
            kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
            throw null;
        }
        kotlin.jvm.internal.i.c(LibStorageUtils.FILE);
        throw null;
    }

    private final void a(final Response<J> response, final zlc.season.rxdownload4.a.a.e eVar) throws IOException {
        File file = this.f23894d;
        if (file != null) {
            zlc.season.rxdownload4.download.utils.a.a(file, 0L, new kotlin.jvm.a.a<kotlin.l>() { // from class: zlc.season.rxdownload4.download.downloader.RangeDownloader$createFiles$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ kotlin.l invoke() throws IOException {
                    invoke2();
                    return kotlin.l.f22855a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws IOException {
                    zlc.season.rxdownload4.download.utils.a.a(n.c(this.this$0), zlc.season.rxdownload4.download.utils.b.a((Response<?>) response), new kotlin.jvm.a.a<kotlin.l>() { // from class: zlc.season.rxdownload4.download.downloader.RangeDownloader$createFiles$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.a.a
                        public /* bridge */ /* synthetic */ kotlin.l invoke() throws IOException {
                            invoke2();
                            return kotlin.l.f22855a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() throws IOException {
                            n nVar = RangeDownloader$createFiles$1.this.this$0;
                            nVar.f23895e = new q(n.d(nVar));
                            q qVarB = n.b(RangeDownloader$createFiles$1.this.this$0);
                            RangeDownloader$createFiles$1 rangeDownloader$createFiles$1 = RangeDownloader$createFiles$1.this;
                            qVarB.b(response, eVar);
                        }
                    });
                }
            }, 1, null);
        } else {
            kotlin.jvm.internal.i.c("tmpFile");
            throw null;
        }
    }
}
