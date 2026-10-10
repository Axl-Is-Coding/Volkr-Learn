package zlc.season.rxdownload3.core;

import android.support.v4.media.session.PlaybackStateCompat;
import io.reactivex.BackpressureStrategy;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.g;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.io.a;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.i;
import kotlin.l;
import okhttp3.J;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Response;
import zlc.season.rxdownload3.helper.HttpUtilKt;

/* JADX INFO: compiled from: NormalTargetFile.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NormalTargetFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f23698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f23699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RealMission f23700e;

    public NormalTargetFile(RealMission realMission) {
        i.b(realMission, "mission");
        this.f23700e = realMission;
        this.f23696a = this.f23700e.b().c() + File.separator + this.f23700e.b().b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23696a);
        sb.append(".download");
        this.f23697b = sb.toString();
        this.f23698c = new File(this.f23696a);
        this.f23699d = new File(this.f23697b);
        File file = new File(this.f23700e.b().c());
        if (file.exists() && file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    public final Status c() {
        return d() ? new Status(this.f23698c.length(), this.f23698c.length(), false, null, 12, null) : new Status(0L, 0L, false, null, 15, null);
    }

    public final boolean d() {
        return this.f23698c.exists();
    }

    public final File e() {
        return this.f23698c;
    }

    public final void a() {
        if (this.f23699d.exists()) {
            this.f23699d.delete();
        }
        this.f23699d.createNewFile();
    }

    public final void b() {
        if (this.f23698c.exists()) {
            this.f23698c.delete();
        }
        if (this.f23699d.exists()) {
            this.f23699d.delete();
        }
    }

    public final e<Status> a(Response<J> response) {
        i.b(response, "response");
        final J jBody = response.body();
        if (jBody != null) {
            i.a((Object) jBody, "response.body() ?: throw…(\"Response body is NULL\")");
            long jI = 1000 / DownloadConfig.r.i();
            final Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 0L;
            final long j = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            final Downloading downloading = new Downloading(new Status(ref$LongRef.element, jBody.contentLength(), HttpUtilKt.c(response), null, 8, null));
            e<Status> eVarA = e.a(new g<T>() { // from class: zlc.season.rxdownload3.core.NormalTargetFile$save$1
                @Override // io.reactivex.g
                public final void a(f<Status> fVar) throws IOException {
                    Throwable th;
                    i.b(fVar, "it");
                    BufferedSource bufferedSourceSource = jBody.source();
                    try {
                        BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(this.f23701a.f23699d));
                        try {
                            Buffer buffer = bufferedSinkBuffer.buffer();
                            long j2 = bufferedSourceSource.read(buffer, j);
                            while (j2 != -1 && !fVar.isCancelled()) {
                                ref$LongRef.element += j2;
                                downloading.a(ref$LongRef.element);
                                fVar.onNext(downloading);
                                j2 = bufferedSourceSource.read(buffer, j);
                            }
                            if (!fVar.isCancelled()) {
                                this.f23701a.f23699d.renameTo(this.f23701a.f23698c);
                                fVar.onComplete();
                            }
                            l lVar = l.f22855a;
                            a.a(bufferedSinkBuffer, null);
                            l lVar2 = l.f22855a;
                        } catch (Throwable th2) {
                            th = th2;
                            th = null;
                            a.a(bufferedSinkBuffer, th);
                            throw th;
                        }
                    } finally {
                        a.a(bufferedSourceSource, null);
                    }
                }
            }, BackpressureStrategy.BUFFER).a(jI, TimeUnit.MILLISECONDS, true);
            i.a((Object) eVarA, "Flowable.create<Status>(…riod, MILLISECONDS, true)");
            return eVarA;
        }
        throw new RuntimeException("Response body is NULL");
    }
}
