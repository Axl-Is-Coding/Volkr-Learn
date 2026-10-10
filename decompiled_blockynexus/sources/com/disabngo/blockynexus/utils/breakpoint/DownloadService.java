package com.disabngo.blockynexus.utils.breakpoint;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f10504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.disabngo.blockynexus.utils.breakpoint.a f10506c = new b(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f10507d = new a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f10507d;
    }

    public class a extends Binder {
        public a() {
        }

        public void a(String str, String str2) {
            if (DownloadService.this.f10504a == null) {
                DownloadService.this.f10505b = str;
                DownloadService downloadService = DownloadService.this;
                downloadService.f10504a = new c(downloadService.f10506c, str2);
                DownloadService.this.f10504a.execute(DownloadService.this.f10505b);
            }
        }

        public void a() {
            if (DownloadService.this.f10504a != null) {
                DownloadService.this.f10504a.a();
            }
        }
    }
}
