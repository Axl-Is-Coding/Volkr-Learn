package kotlin.io;

import io.rong.common.LibStorageUtils;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, f fVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    public final File getFile() {
        return this.file;
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file, File file2, String str) {
        super(b.b(file, file2, str));
        i.b(file, LibStorageUtils.FILE);
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
