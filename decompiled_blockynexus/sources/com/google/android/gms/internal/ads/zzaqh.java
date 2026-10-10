package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqh implements DialogInterface.OnClickListener {
    private final /* synthetic */ String zzdns;
    private final /* synthetic */ String zzdnt;
    private final /* synthetic */ zzaqi zzdnu;

    zzaqh(zzaqi zzaqiVar, String str, String str2) {
        this.zzdnu = zzaqiVar;
        this.zzdns = str;
        this.zzdnt = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzdnu.zzvr.getSystemService("download");
        try {
            String str = this.zzdns;
            String str2 = this.zzdnt;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.zzp.zzkt();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdnu.zzdx("Could not store picture.");
        }
    }
}
