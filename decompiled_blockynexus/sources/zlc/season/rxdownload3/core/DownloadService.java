package zlc.season.rxdownload3.core;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.extension.Extension;
import zlc.season.rxdownload3.helper.LoggerKt;

/* JADX INFO: compiled from: DownloadService.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class DownloadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalMissionBox f23669a = new LocalMissionBox();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DownloadBinder f23670b = new DownloadBinder();

    /* JADX INFO: compiled from: DownloadService.kt */
    public interface BoolCallback {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: DownloadService.kt */
    public final class DownloadBinder extends Binder {
        public DownloadBinder() {
        }

        public final void a(Mission mission, BoolCallback boolCallback, ErrorCallback errorCallback) {
            i.b(mission, "mission");
            i.b(boolCallback, "boolCallback");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.d(mission).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$isExists$1(boolCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$isExists$2(errorCallback)));
        }

        public final void b(Mission mission, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(mission, "mission");
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.a(mission).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$start$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$start$2(errorCallback)));
        }

        public final void c(Mission mission, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(mission, "mission");
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.e(mission).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$stop$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$stop$2(errorCallback)));
        }

        public final void d(Mission mission, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(mission, "newMission");
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.f(mission).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$update$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$update$2(errorCallback)));
        }

        public final void b(SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.b().a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$startAll$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$startAll$2(errorCallback)));
        }

        public final void c(SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.c().a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$stopAll$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$stopAll$2(errorCallback)));
        }

        public final void a(Mission mission, boolean z, StatusCallback statusCallback) {
            i.b(mission, "mission");
            i.b(statusCallback, "statusCallback");
            DownloadService.this.f23669a.b(mission, z).d(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$create$1(statusCallback)));
        }

        public final void a(Mission mission, boolean z, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(mission, "mission");
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.a(mission, z).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$delete$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$delete$2(errorCallback)));
        }

        public final void a(List<? extends Mission> list, boolean z, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(list, "missions");
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.a(list, z).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$createAll$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$createAll$2(errorCallback)));
        }

        public final void a(boolean z, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(successCallback, "successCallback");
            i.b(errorCallback, "errorCallback");
            DownloadService.this.f23669a.a(z).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$deleteAll$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$deleteAll$2(errorCallback)));
        }

        public final void a(Mission mission, FileCallback fileCallback, ErrorCallback errorCallback) {
            i.b(mission, "mission");
            i.b(fileCallback, "fileCallback");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.c(mission).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$file$1(fileCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$file$2(errorCallback)));
        }

        public final void a(Mission mission, Class<? extends Extension> cls, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(mission, "mission");
            i.b(cls, "type");
            i.b(successCallback, "successCallback");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.a(mission, cls).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$extension$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$extension$2(errorCallback)));
        }

        public final void a(Mission mission, SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(mission, "mission");
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.b(mission).a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$clear$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$clear$2(errorCallback)));
        }

        public final void a(SuccessCallback successCallback, ErrorCallback errorCallback) {
            i.b(successCallback, "successCb");
            i.b(errorCallback, "errorCb");
            DownloadService.this.f23669a.a().a(new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$clearAll$1(successCallback)), new DownloadService$sam$io_reactivex_functions_Consumer$0(new DownloadService$DownloadBinder$clearAll$2(errorCallback)));
        }
    }

    /* JADX INFO: compiled from: DownloadService.kt */
    public interface ErrorCallback {
        void a(Throwable th);
    }

    /* JADX INFO: compiled from: DownloadService.kt */
    public interface FileCallback {
        void a(File file);
    }

    /* JADX INFO: compiled from: DownloadService.kt */
    public interface StatusCallback {
        void a(Status status);
    }

    /* JADX INFO: compiled from: DownloadService.kt */
    public interface SuccessCallback {
        void apply(Object obj);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LoggerKt.a("bind");
        return this.f23670b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LoggerKt.a("create");
    }

    @Override // android.app.Service
    public void onDestroy() {
        LoggerKt.a("destroy");
        this.f23669a.c();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        LoggerKt.a("start");
        return super.onStartCommand(intent, i, i2);
    }
}
