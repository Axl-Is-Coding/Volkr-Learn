package zlc.season.rxdownload4.a;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Progress.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f23846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f23847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23849d;

    public a() {
        this(0L, 0L, false, null, 15, null);
    }

    public a(long j, long j2, boolean z, String str) {
        i.b(str, "downloadUrl");
        this.f23847b = j;
        this.f23848c = z;
        this.f23849d = str;
        this.f23846a = j2;
    }

    public final long a() {
        return this.f23847b;
    }

    public final String b() {
        return this.f23849d;
    }

    public final long c() {
        if (!this.f23848c) {
            return this.f23846a;
        }
        throw new IllegalStateException("Chunked can not get totalSize!");
    }

    public final boolean d() {
        return this.f23848c;
    }

    public final void a(long j) {
        this.f23847b = j;
    }

    public /* synthetic */ a(long j, long j2, boolean z, String str, int i, f fVar) {
        this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str);
    }
}
