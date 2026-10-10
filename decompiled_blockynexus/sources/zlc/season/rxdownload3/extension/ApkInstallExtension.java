package zlc.season.rxdownload3.extension;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import com.facebook.internal.AnalyticsEvents;
import com.umeng.analytics.pro.b;
import io.reactivex.b.g;
import io.reactivex.j;
import io.reactivex.l;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.processors.a;
import java.io.File;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.DownloadConfig;
import zlc.season.rxdownload3.core.Failed;
import zlc.season.rxdownload3.core.RealMission;
import zlc.season.rxdownload3.core.Status;
import zlc.season.rxdownload3.core.Succeed;
import zlc.season.rxdownload3.extension.ApkInstallExtension;
import zlc.season.rxdownload3.helper.LoggerKt;
import zlc.season.rxdownload3.helper.UtilsKt;

/* JADX INFO: compiled from: ApkInstallExtension.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ApkInstallExtension implements Extension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RealMission f23816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f23817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f23818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23819d = "";

    /* JADX INFO: compiled from: ApkInstallExtension.kt */
    public static final class ApkFileNotExistsException extends RuntimeException {
        public ApkFileNotExistsException() {
            super("Apk file not exists");
        }
    }

    /* JADX INFO: compiled from: ApkInstallExtension.kt */
    public static final class ApkInstallActivity extends Activity {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private File f23824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f23825f;
        private String g = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f23823d = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f23820a = "application/vnd.android.package-archive";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f23821b = "argsInPath";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f23822c = 100;

        /* JADX INFO: compiled from: ApkInstallExtension.kt */
        public static final class Companion {
            private Companion() {
            }

            public final void a(Context context, String str) {
                i.b(context, b.Q);
                i.b(str, "apkPath");
                Intent intent = new Intent(context, (Class<?>) ApkInstallActivity.class);
                intent.addFlags(268435456);
                intent.putExtra(ApkInstallActivity.f23821b, str);
                context.startActivity(intent);
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        private final void b() {
            try {
                if (new File(getPackageManager().getApplicationInfo(this.g, 0).sourceDir).lastModified() > this.f23825f) {
                    ApkInstallService.f23827b.a(true, this.g);
                } else {
                    ApkInstallService.f23827b.a(false, this.g);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                ApkInstallService.f23827b.a(false, this.g);
            }
        }

        private final Intent c() {
            Uri uriFromFile;
            Intent intent = new Intent("android.intent.action.VIEW");
            String str = getPackageName() + ".rxdownload.provider";
            if (Build.VERSION.SDK_INT >= 24) {
                File file = this.f23824e;
                if (file == null) {
                    i.c("apkFile");
                    throw null;
                }
                uriFromFile = FileProvider.getUriForFile(this, str, file);
            } else {
                File file2 = this.f23824e;
                if (file2 == null) {
                    i.c("apkFile");
                    throw null;
                }
                uriFromFile = Uri.fromFile(file2);
            }
            intent.setDataAndType(uriFromFile, f23820a);
            intent.addFlags(1);
            return intent;
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i == f23822c) {
                b();
            }
            finish();
        }

        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f23824e = new File(getIntent().getStringExtra(f23821b));
            File file = this.f23824e;
            if (file == null) {
                i.c("apkFile");
                throw null;
            }
            this.g = UtilsKt.a(this, file);
            this.f23825f = System.currentTimeMillis();
            startActivityForResult(c(), f23822c);
        }
    }

    /* JADX INFO: compiled from: ApkInstallExtension.kt */
    public static final class ApkInstallService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a<Pair<Boolean, String>> f23826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ApkInstallService f23827b = new ApkInstallService();

        static {
            PublishProcessor publishProcessorI = PublishProcessor.i();
            i.a((Object) publishProcessorI, "PublishProcessor.create()");
            f23826a = publishProcessorI;
        }

        private ApkInstallService() {
        }

        public final void a(boolean z, String str) {
            i.b(str, "packageName");
            f23826a.onNext(new Pair<>(Boolean.valueOf(z), str));
        }

        public final a<Pair<Boolean, String>> a() {
            return f23826a;
        }
    }

    /* JADX INFO: compiled from: ApkInstallExtension.kt */
    public static final class Installed extends Status {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Installed(Status status) {
            super(status);
            i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        }
    }

    /* JADX INFO: compiled from: ApkInstallExtension.kt */
    public static final class Installing extends Status {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Installing(Status status) {
            super(status);
            i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        ApkInstallService.f23827b.a().d(new g<Pair<? extends Boolean, ? extends String>>() { // from class: zlc.season.rxdownload3.extension.ApkInstallExtension$registerService$1
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(Pair<Boolean, String> pair) {
                if (i.a((Object) pair.getSecond(), (Object) this.f23829a.f23819d)) {
                    if (pair.getFirst().booleanValue()) {
                        this.f23829a.c().b(new ApkInstallExtension.Installed(this.f23829a.c().e()));
                    } else {
                        this.f23829a.c().b(new Succeed(this.f23829a.c().e()));
                    }
                }
            }
        });
    }

    public final Context b() {
        Context context = this.f23817b;
        if (context != null) {
            return context;
        }
        i.c(b.Q);
        throw null;
    }

    public final RealMission c() {
        RealMission realMission = this.f23816a;
        if (realMission != null) {
            return realMission;
        }
        i.c("mission");
        throw null;
    }

    @Override // zlc.season.rxdownload3.extension.Extension
    public void a(RealMission realMission) {
        i.b(realMission, "mission");
        this.f23816a = realMission;
        if (DownloadConfig.r.b() == null) {
            LoggerKt.a("No context, you should set context first");
            return;
        }
        Context contextB = DownloadConfig.r.b();
        if (contextB != null) {
            this.f23817b = contextB;
        } else {
            i.a();
            throw null;
        }
    }

    @Override // zlc.season.rxdownload3.extension.Extension
    public io.reactivex.i<Object> a() {
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.extension.ApkInstallExtension$action$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                i.b(jVar, "it");
                ApkInstallExtension apkInstallExtension = this.f23828a;
                apkInstallExtension.f23818c = apkInstallExtension.c().c();
                if (this.f23828a.f23818c == null) {
                    this.f23828a.c().b(new Failed(new Status(0L, 0L, false, null, 15, null), new ApkInstallExtension.ApkFileNotExistsException()));
                    jVar.onError(new ApkInstallExtension.ApkFileNotExistsException());
                    return;
                }
                ApkInstallExtension apkInstallExtension2 = this.f23828a;
                Context contextB = apkInstallExtension2.b();
                File file = this.f23828a.f23818c;
                if (file == null) {
                    i.a();
                    throw null;
                }
                apkInstallExtension2.f23819d = UtilsKt.a(contextB, file);
                this.f23828a.c().b(new ApkInstallExtension.Installing(this.f23828a.c().e()));
                this.f23828a.d();
                ApkInstallExtension.ApkInstallActivity.Companion companion = ApkInstallExtension.ApkInstallActivity.f23823d;
                Context contextB2 = this.f23828a.b();
                File file2 = this.f23828a.f23818c;
                if (file2 == null) {
                    i.a();
                    throw null;
                }
                String path = file2.getPath();
                i.a((Object) path, "apkFile!!.path");
                companion.a(contextB2, path);
                jVar.onSuccess(1);
            }
        });
        i.a((Object) iVarA, "Maybe.create<Any> {\n    …it.onSuccess(1)\n        }");
        return iVarA;
    }
}
