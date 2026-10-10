package zlc.season.rxdownload3.core;

import io.reactivex.BackpressureStrategy;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.io.a;
import kotlin.jvm.internal.i;
import kotlin.l;
import okhttp3.J;
import retrofit2.Response;
import zlc.season.rxdownload3.core.RangeTmpFile;
import zlc.season.rxdownload3.helper.UtilsKt;

/* JADX INFO: compiled from: RangeTargetFile.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RangeTargetFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f23718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f23719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23720f;
    private final int g;
    private final int h;
    private final RealMission i;

    public RangeTargetFile(RealMission realMission) {
        i.b(realMission, "mission");
        this.i = realMission;
        this.f23715a = this.i.b().c();
        this.f23716b = this.f23715a + File.separator + this.i.b().b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23716b);
        sb.append(".download");
        this.f23717c = sb.toString();
        this.f23718d = new File(this.f23716b);
        this.f23719e = new File(this.f23717c);
        this.f23720f = "rw";
        this.g = 8192;
        this.h = this.g * 20;
        File file = new File(this.f23715a);
        if (file.exists() && file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    public final File e() {
        return this.f23718d;
    }

    public final void f() {
        this.f23719e.renameTo(this.f23718d);
    }

    public final void a() {
        new RandomAccessFile(this.f23719e, this.f23720f).setLength(this.i.f());
    }

    public final void b() {
        if (this.f23719e.exists()) {
            this.f23719e.delete();
        }
        if (this.f23718d.exists()) {
            this.f23718d.delete();
        }
    }

    public final boolean c() {
        return this.f23718d.exists();
    }

    public final boolean d() {
        return this.f23719e.exists();
    }

    public final e<Object> a(Response<J> response, final RangeTmpFile.Segment segment, final RangeTmpFile rangeTmpFile) {
        i.b(response, "response");
        i.b(segment, "segment");
        i.b(rangeTmpFile, "tmpFile");
        final J jBody = response.body();
        if (jBody != null) {
            i.a((Object) jBody, "response.body() ?: throw…(\"Response body is NULL\")");
            e<Object> eVarA = e.a(new g<T>() { // from class: zlc.season.rxdownload3.core.RangeTargetFile$save$1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v3, types: [byte[]] */
                /* JADX WARN: Type inference failed for: r2v4 */
                /* JADX WARN: Type inference failed for: r2v5 */
                /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable, java.io.InputStream] */
                /* JADX WARN: Type inference failed for: r9v6, types: [java.nio.MappedByteBuffer] */
                @Override // io.reactivex.g
                public final void a(f<Object> fVar) throws Throwable {
                    Throwable th;
                    Throwable th2;
                    RandomAccessFile randomAccessFile;
                    Throwable th3;
                    Throwable th4;
                    Throwable th5;
                    RandomAccessFile randomAccessFile2;
                    RandomAccessFile randomAccessFile3;
                    i.b(fVar, "it");
                    ?? r2 = new byte[this.f23721a.g];
                    ?? ByteStream = jBody.byteStream();
                    try {
                        try {
                            try {
                                RandomAccessFile randomAccessFile4 = new RandomAccessFile(this.f23721a.f23719e, this.f23721a.f23720f);
                                try {
                                    RandomAccessFile randomAccessFile5 = new RandomAccessFile(rangeTmpFile.d(), this.f23721a.f23720f);
                                    try {
                                        FileChannel channel = randomAccessFile4.getChannel();
                                        try {
                                            FileChannel channel2 = randomAccessFile5.getChannel();
                                            try {
                                                try {
                                                    MappedByteBuffer map = channel2.map(FileChannel.MapMode.READ_WRITE, rangeTmpFile.a(segment), 32L);
                                                    int i = ByteStream.read(r2);
                                                    int i2 = i;
                                                    while (i != -1) {
                                                        try {
                                                            if (fVar.isCancelled()) {
                                                                break;
                                                            }
                                                            RandomAccessFile randomAccessFile6 = randomAccessFile4;
                                                            long j = i;
                                                            RandomAccessFile randomAccessFile7 = randomAccessFile5;
                                                            int i3 = i;
                                                            try {
                                                                ?? map2 = channel.map(FileChannel.MapMode.READ_WRITE, segment.a(), j);
                                                                RangeTmpFile.Segment segment2 = segment;
                                                                segment2.a(segment2.a() + j);
                                                                map2.put(r2, 0, i3);
                                                                map.putLong(16, segment.a());
                                                                i = ByteStream.read(r2);
                                                                int i4 = i2 + i;
                                                                if (i4 >= this.f23721a.h) {
                                                                    fVar.onNext(UtilsKt.a());
                                                                    i2 = 0;
                                                                } else {
                                                                    i2 = i4;
                                                                }
                                                                randomAccessFile4 = randomAccessFile6;
                                                                randomAccessFile5 = randomAccessFile7;
                                                            } catch (Throwable th6) {
                                                                th5 = th6;
                                                                randomAccessFile4 = randomAccessFile6;
                                                                randomAccessFile = randomAccessFile7;
                                                                th = null;
                                                                try {
                                                                    throw th5;
                                                                } catch (Throwable th7) {
                                                                    th = th7;
                                                                    a.a(channel2, th5);
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            randomAccessFile = randomAccessFile5;
                                                        }
                                                    }
                                                    randomAccessFile2 = randomAccessFile4;
                                                    randomAccessFile3 = randomAccessFile5;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    randomAccessFile = randomAccessFile5;
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                randomAccessFile = randomAccessFile5;
                                            }
                                            try {
                                                fVar.onNext(UtilsKt.a());
                                                fVar.onComplete();
                                                l lVar = l.f22855a;
                                                th = null;
                                                try {
                                                    a.a(channel2, null);
                                                    l lVar2 = l.f22855a;
                                                    try {
                                                        a.a(channel, null);
                                                        l lVar3 = l.f22855a;
                                                        try {
                                                            a.a(randomAccessFile3, null);
                                                            l lVar4 = l.f22855a;
                                                            a.a(randomAccessFile2, null);
                                                            l lVar5 = l.f22855a;
                                                            a.a(ByteStream, null);
                                                        } catch (Throwable th11) {
                                                            th = th11;
                                                            randomAccessFile4 = randomAccessFile2;
                                                            th2 = th;
                                                            throw th2;
                                                        }
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        randomAccessFile4 = randomAccessFile2;
                                                        randomAccessFile = randomAccessFile3;
                                                        th3 = th;
                                                        throw th3;
                                                    }
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    randomAccessFile4 = randomAccessFile2;
                                                    randomAccessFile = randomAccessFile3;
                                                    th4 = th;
                                                    a.a(channel, th4);
                                                    throw th;
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                randomAccessFile4 = randomAccessFile2;
                                                randomAccessFile = randomAccessFile3;
                                                th = null;
                                                th5 = null;
                                                a.a(channel2, th5);
                                                throw th;
                                            }
                                        } catch (Throwable th15) {
                                            th = th15;
                                            randomAccessFile = randomAccessFile5;
                                            th = null;
                                        }
                                    } catch (Throwable th16) {
                                        th = th16;
                                        randomAccessFile = randomAccessFile5;
                                        th = null;
                                    }
                                } catch (Throwable th17) {
                                    th = th17;
                                    th = null;
                                }
                            } catch (Throwable th18) {
                                th = th18;
                                a.a(ByteStream, r2);
                                throw th;
                            }
                        } catch (Throwable th19) {
                            th = th19;
                            r2 = 0;
                            a.a(ByteStream, r2);
                            throw th;
                        }
                    } catch (Throwable th20) {
                        try {
                            throw th20;
                        } catch (Throwable th21) {
                            th = th21;
                            r2 = th20;
                            a.a(ByteStream, r2);
                            throw th;
                        }
                    }
                }
            }, BackpressureStrategy.LATEST);
            i.a((Object) eVarA, "Flowable.create<Any>({\n …     }\n        }, LATEST)");
            return eVarA;
        }
        throw new RuntimeException("Response body is NULL");
    }
}
