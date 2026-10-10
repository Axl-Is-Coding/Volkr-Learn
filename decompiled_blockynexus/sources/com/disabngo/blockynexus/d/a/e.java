package com.disabngo.blockynexus.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.download.client.DownloadClient;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.entity.DecorationResourcesResponse;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.decorate.web.t;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.UnzipInfo;
import com.sandboxol.file.entity.VerifyInfo;

/* JADX INFO: compiled from: DressDownloadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f7213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.disabngo.blockynexus.interfaces.a f7215c = new d(this);

    public static e b() {
        if (f7213a == null) {
            f7213a = new e();
        }
        return f7213a;
    }

    public e a(Context context) {
        this.f7214b = context;
        return this;
    }

    public void a() {
        a(SharedUtils.getLong(this.f7214b, SharedConstant.CLOTHES_RES_VERSION_CODE), (com.disabngo.blockynexus.interfaces.a) null);
    }

    @SuppressLint({"CheckResult"})
    public void a(long j) {
        a(j, (com.disabngo.blockynexus.interfaces.a) null);
    }

    public void a(long j, com.disabngo.blockynexus.interfaces.a aVar) {
        com.disabngo.blockynexus.interfaces.a aVar2;
        if (ChannelManager.isBeta()) {
            return;
        }
        if (aVar == null) {
            com.disabngo.blockynexus.interfaces.a aVar3 = this.f7215c;
            ReportDataAdapter.onEvent(this.f7214b, EventConstant.SILENT_DOWNLOAD);
            aVar2 = aVar3;
        } else {
            ReportDataAdapter.onEvent(this.f7214b, EventConstant.ACT_DOWNLOAD);
            aVar2 = aVar;
        }
        Log.d("DressDownload&Unzip", "****Dress Download****");
        Log.d("DressDownload&Unzip", "--------------------------------------------------");
        Log.d("DressDownload&Unzip", "start check dress res");
        t.a(this.f7214b, j, new b(this, aVar, aVar2, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, DecorationResourcesResponse decorationResourcesResponse, boolean z, com.disabngo.blockynexus.interfaces.a aVar) {
        Log.d("DressDownload&Unzip", "Start download dress res");
        String strSubstring = decorationResourcesResponse.getUrl().substring(decorationResourcesResponse.getUrl().lastIndexOf("/") + 1);
        String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(context);
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.setUrl(decorationResourcesResponse.getUrl());
        downloadInfo.setSaveName(strSubstring);
        downloadInfo.setSavePath(apkOrSoDownloadPath);
        downloadInfo.setSize(decorationResourcesResponse.getFileSize());
        downloadInfo.setCdns(decorationResourcesResponse.getCdns());
        VerifyInfo verifyInfo = new VerifyInfo();
        verifyInfo.setFileName(strSubstring);
        verifyInfo.setFileDir(apkOrSoDownloadPath + "/");
        verifyInfo.setCode(decorationResourcesResponse.getHash());
        UnzipInfo unzipInfo = new UnzipInfo();
        unzipInfo.setZipName(strSubstring);
        unzipInfo.setResultDir("app_download");
        unzipInfo.setFromDir(apkOrSoDownloadPath + "/");
        unzipInfo.setCheckMd5(false);
        unzipInfo.setFileSize(decorationResourcesResponse.getFileSize());
        com.sandboxol.file.b.a aVar2 = new com.sandboxol.file.b.a();
        aVar2.a(downloadInfo);
        com.sandboxol.file.b.c cVar = new com.sandboxol.file.b.c();
        cVar.a(verifyInfo);
        com.sandboxol.file.b.b bVar = new com.sandboxol.file.b.b();
        bVar.a(unzipInfo);
        DownloadClient downloadClient = DownloadClient.getInstance();
        MergeBuilder verifyBuilder = new MergeBuilder().setDownloadBuilder(aVar2).setVerifyBuilder(cVar);
        bVar.a(new c(this, context, decorationResourcesResponse, aVar));
        downloadClient.process(1, verifyBuilder.setUnzipBuilder(bVar));
    }
}
