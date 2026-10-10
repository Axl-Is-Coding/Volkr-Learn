package zlc.season.rxdownload4.download.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.i;
import kotlin.l;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ void a(File file, long j, kotlin.jvm.a.a aVar, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            aVar = new kotlin.jvm.a.a<l>() { // from class: zlc.season.rxdownload4.download.utils.FileUtilsKt$recreate$1
                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ l invoke() {
                    invoke2();
                    return l.f22855a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        a(file, j, aVar);
    }

    public static final void b(File file) {
        i.b(file, "$this$clear");
        File fileC = c(file);
        File fileD = d(file);
        fileC.delete();
        fileD.delete();
        file.delete();
    }

    public static final File c(File file) {
        i.b(file, "$this$shadow");
        return new File(file.getCanonicalPath() + ".download");
    }

    public static final File d(File file) {
        i.b(file, "$this$tmp");
        return new File(file.getCanonicalPath() + ".tmp");
    }

    public static final void a(File file, long j, kotlin.jvm.a.a<l> aVar) throws IOException {
        i.b(file, "$this$recreate");
        i.b(aVar, "block");
        file.delete();
        if (!file.createNewFile()) {
            throw new IllegalStateException("File create failed!");
        }
        a(file, j);
        aVar.invoke();
    }

    public static final File b(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "$this$getFile");
        return new File(aVar.b(), aVar.a());
    }

    public static final void a(File file, long j) throws IOException {
        i.b(file, "$this$setLength");
        new RandomAccessFile(file, "rw").setLength(j);
    }

    public static final FileChannel a(File file) {
        i.b(file, "$this$channel");
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        i.a((Object) channel, "RandomAccessFile(this, \"rw\").channel");
        return channel;
    }

    public static final File a(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "$this$getDir");
        return new File(aVar.b());
    }
}
