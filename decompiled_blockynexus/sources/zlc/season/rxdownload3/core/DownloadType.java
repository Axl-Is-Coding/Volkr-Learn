package zlc.season.rxdownload3.core;

import io.reactivex.e;
import java.io.File;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: DownloadType.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class DownloadType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealMission f23673a;

    public DownloadType(RealMission realMission) {
        i.b(realMission, "mission");
        this.f23673a = realMission;
    }

    public abstract void a();

    public abstract e<? extends Status> b();

    public abstract File c();

    public final RealMission d() {
        return this.f23673a;
    }

    public abstract void e();
}
