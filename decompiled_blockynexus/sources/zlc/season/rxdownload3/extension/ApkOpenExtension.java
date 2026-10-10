package zlc.season.rxdownload3.extension;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.umeng.analytics.pro.b;
import io.reactivex.j;
import io.reactivex.l;
import java.io.File;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.DownloadConfig;
import zlc.season.rxdownload3.core.RealMission;
import zlc.season.rxdownload3.helper.LoggerKt;
import zlc.season.rxdownload3.helper.UtilsKt;

/* JADX INFO: compiled from: ApkOpenExtension.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ApkOpenExtension implements Extension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RealMission f23830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f23831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f23832c;

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        Context context = this.f23831b;
        if (context == null) {
            i.c(b.Q);
            throw null;
        }
        PackageManager packageManager = context.getPackageManager();
        Context context2 = this.f23831b;
        if (context2 == null) {
            i.c(b.Q);
            throw null;
        }
        File file = this.f23832c;
        if (file == null) {
            i.a();
            throw null;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(UtilsKt.a(context2, file));
        launchIntentForPackage.addFlags(268435456);
        Context context3 = this.f23831b;
        if (context3 != null) {
            context3.startActivity(launchIntentForPackage);
        } else {
            i.c(b.Q);
            throw null;
        }
    }

    public final RealMission b() {
        RealMission realMission = this.f23830a;
        if (realMission != null) {
            return realMission;
        }
        i.c("mission");
        throw null;
    }

    @Override // zlc.season.rxdownload3.extension.Extension
    public void a(RealMission realMission) {
        i.b(realMission, "mission");
        this.f23830a = realMission;
        if (DownloadConfig.r.b() == null) {
            LoggerKt.a("No context, you should set context first");
            return;
        }
        Context contextB = DownloadConfig.r.b();
        if (contextB != null) {
            this.f23831b = contextB;
        } else {
            i.a();
            throw null;
        }
    }

    @Override // zlc.season.rxdownload3.extension.Extension
    public io.reactivex.i<Object> a() {
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.extension.ApkOpenExtension$action$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                i.b(jVar, "it");
                ApkOpenExtension apkOpenExtension = this.f23833a;
                apkOpenExtension.f23832c = apkOpenExtension.b().c();
                if (this.f23833a.f23832c == null) {
                    return;
                }
                this.f23833a.c();
                jVar.onSuccess(1);
            }
        });
        i.a((Object) iVarA, "Maybe.create<Any> {\n    …it.onSuccess(1)\n        }");
        return iVarA;
    }
}
