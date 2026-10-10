package com.sandboxol.center.download.service;

import android.content.Context;
import android.os.RemoteException;
import androidx.databinding.ObservableField;
import com.apkfuns.logutils.c;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.entity.ProgressInfo;
import com.sandboxol.center.download.interfaces.Action;
import com.sandboxol.center.download.interfaces.IServiceProcess;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.download.utils.ProcessUtils;
import com.sandboxol.center.download.utils.ProgressUtils;
import com.sandboxol.center.entity.DownloadAnalyseData;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.file.a.b;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.file.entity.VerifyInfo;
import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
public class BaseServiceProcess implements IServiceProcess {
    public b baseFileHandler;
    public Context context = BaseApplication.getContext();
    public ObservableField<Integer> retryDownloadTimes = new ObservableField<>(0);

    public void downloadOnComplete(int i, Progress progress, MergeBuilder mergeBuilder, DownloadInfo[] downloadInfoArr, VerifyInfo[] verifyInfoArr, IDownloadListener iDownloadListener) {
        DownloadInfoCenter.getInstance().updateDownloadTotalProgress();
        try {
            ProgressUtils.downloadSpeedUpload(this.context, i, progress.getDownloadRate());
        } catch (Exception unused) {
        }
        ReportUtils.resDownloadReport(i, this.context, EventConstant.DOWNLOAD_GAME_SUCCESS, "", mergeBuilder.isSilent());
        if (downloadInfoArr != null && downloadInfoArr[0] != null) {
            ReportUtils.cdnDownloadNumReport(new DownloadAnalyseData(GameDownloadUtils.getCdnId(downloadInfoArr[0]), CommonHelper.getCountry(), 1));
            if (progress != null && progress.getDownloadRate() != 0.0d) {
                ReportUtils.cdnDownloadSpeedReport(new DownloadAnalyseData(GameDownloadUtils.getCdnId(downloadInfoArr[0]), CommonHelper.getCountry(), progress.getDownloadRate()));
            }
        }
        if (5 != i) {
            for (VerifyInfo verifyInfo : verifyInfoArr) {
                if (verifyInfo.getCode() == null) {
                    this.baseFileHandler.e();
                }
            }
        }
        if (iDownloadListener != null) {
            try {
                iDownloadListener.onComplete(progress);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        c.a(getTypeTitle(i) + "Download&Unzip").d(getTypeTitle(i) + " Download Success");
    }

    public void downloadOnError(int i, Throwable th, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener, ProgressInfo progressInfo, MergeBuilder mergeBuilder) {
        downloadOnError(i, th, str, iDownloadListener, iVerifyListener, iUnzipListener, progressInfo, mergeBuilder, 0, 0, false, null);
    }

    public void downloadOnNext(Context context, Progress progress, ProgressInfo progressInfo, IDownloadListener iDownloadListener) {
        progressInfo.getProgress().set(progress);
        progressInfo.getIsDownload().set(true);
        if (progress.getTotalSize().longValue() == progress.getDownloadSize().longValue()) {
            progressInfo.getIsDownload().set(false);
        }
        if (progress.getTotalSize().longValue() != 0) {
            progressInfo.getProgressValue().set(Integer.valueOf((int) ((progress.getDownloadSize().longValue() * 100) / progress.getTotalSize().longValue())));
            progressInfo.getProgressText().set(context.getString(R.string.base_res_downloading, progress.formatString()));
        }
        DownloadInfoCenter.getInstance().updateDownloadTotalProgress();
        if (iDownloadListener != null) {
            try {
                iDownloadListener.onNext(progress);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void downloadOnSubscribe(DownloadInfo[] downloadInfoArr, Throwable th) {
        boolean zContains = ((th == null || th.getMessage() == null) ? "errorMsg is null" : th.getMessage()).toLowerCase().contains("is exists");
        if (downloadInfoArr == null || downloadInfoArr[0] == null || zContains) {
            return;
        }
        ReportUtils.cdnDownloadNumReport(new DownloadAnalyseData(GameDownloadUtils.getCdnId(downloadInfoArr[0]), CommonHelper.getCountry(), 0));
    }

    public String getTypeTitle(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "map" : "common" : "alone" : "common game" : "dress";
    }

    public void mapDownloadOnError(Throwable th, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener, ProgressInfo progressInfo, MergeBuilder mergeBuilder, Action action) {
        downloadOnError(5, th, str, iDownloadListener, iVerifyListener, iUnzipListener, progressInfo, mergeBuilder, 0, 0, false, action);
    }

    @Override // com.sandboxol.center.download.interfaces.IServiceProcess
    public /* synthetic */ void process(int i, int i2, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException {
        com.sandboxol.center.download.interfaces.b.a(this, i, i2, str, iDownloadListener, iVerifyListener, iUnzipListener);
    }

    @Override // com.sandboxol.center.download.interfaces.IServiceProcess
    public /* synthetic */ void process(String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException {
        com.sandboxol.center.download.interfaces.b.a(this, str, iDownloadListener, iVerifyListener, iUnzipListener);
    }

    public void unzipOnError(int i, Throwable th, ProgressInfo progressInfo, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener, MergeBuilder mergeBuilder) {
        unzipOnError(i, th, progressInfo, str, iDownloadListener, iVerifyListener, iUnzipListener, mergeBuilder, 0, 0, false);
    }

    public void unzipOnProgress(Context context, Progress progress, ProgressInfo progressInfo, IUnzipListener iUnzipListener) {
        progressInfo.getIsDownload().set(true);
        progressInfo.getProgressText().set(context.getString(R.string.base_game_detail_game_unzip));
        DownloadInfoCenter.getInstance().updateUnzipTotalProgress();
        if (iUnzipListener != null) {
            try {
                iUnzipListener.onNext(progress);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void unzipOnSuccess(int i, Context context, MergeBuilder mergeBuilder, ProgressInfo progressInfo, IUnzipListener iUnzipListener) {
        this.retryDownloadTimes.set(0);
        progressInfo.getIsDownload().set(false);
        progressInfo.getIsError().set(false);
        progressInfo.getIsFinish().set(true);
        DownloadInfoCenter.getInstance().updateUnzipTotalProgress();
        if (1 == i) {
            ReportUtils.resDownloadReport(i, context, mergeBuilder.isSilent() ? EventConstant.SILENT_DOWNLOAD_SUC : EventConstant.ACT_DOWNLOAD_SUC, "unzip success:", false);
        } else {
            ReportUtils.resDownloadReport(i, context, EventConstant.UNZIP_GAME_SUCCESS, "", mergeBuilder.isSilent());
        }
        if (iUnzipListener != null) {
            try {
                iUnzipListener.onComplete(null);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        c.a(getTypeTitle(i) + "Download&Unzip").d(getTypeTitle(i) + " Unzip Success");
    }

    public void verifyOnError(int i, Throwable th, ProgressInfo progressInfo, IVerifyListener iVerifyListener, String str, IDownloadListener iDownloadListener, IUnzipListener iUnzipListener, MergeBuilder mergeBuilder) {
        verifyOnError(i, th, progressInfo, iVerifyListener, str, iDownloadListener, iUnzipListener, mergeBuilder, 0, 0, false);
    }

    public void verifyOnSuccess(int i, Context context, MergeBuilder mergeBuilder, IVerifyListener iVerifyListener) {
        ReportUtils.resDownloadReport(i, context, EventConstant.CHECK_MD_5_SUCCESS, "", mergeBuilder.isSilent());
        if (iVerifyListener != null) {
            try {
                iVerifyListener.onComplete(null);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        c.a(getTypeTitle(i) + "Download&Unzip").d("Verify Success");
    }

    public void downloadOnError(int i, Throwable th, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener, ProgressInfo progressInfo, MergeBuilder mergeBuilder, int i2, int i3, boolean z, Action action) {
        String str2;
        boolean z2;
        String message = th.getMessage() != null ? th.getMessage() : "errorMsg is null";
        boolean zIsRetry = GameDownloadUtils.isRetry(th);
        boolean z3 = message.toLowerCase().contains("not a tmp file") || (th instanceof EOFException);
        boolean zContains = message.toLowerCase().contains("is exists");
        try {
            boolean z4 = message.toLowerCase().contains("no space left on device") || message.toLowerCase().contains("disk space overflow");
            if (progressInfo.getProgress().get().getDownloadRate() == 0.0d || zContains) {
                str2 = "errorMsg is null";
                z2 = z3;
            } else {
                str2 = "errorMsg is null";
                z2 = z3;
                ReportUtils.cdnDownloadSpeedReport(new DownloadAnalyseData(GameDownloadUtils.getCdnId(mergeBuilder.getDownloadBuilder().e()[0]), CommonHelper.getCountry(), progressInfo.getProgress().get().getDownloadRate()));
            }
            progressInfo.getProgress().get().setDownloadRate(0.0d);
            if (zIsRetry && this.retryDownloadTimes.get().intValue() < 3) {
                this.retryDownloadTimes.set(Integer.valueOf(this.retryDownloadTimes.get().intValue() + 1));
                if (z) {
                    process(i2, i3, str, iDownloadListener, iVerifyListener, iUnzipListener);
                } else {
                    process(str, iDownloadListener, iVerifyListener, iUnzipListener);
                }
            } else if (zContains) {
                c.a(getTypeTitle(i) + "Download onError").c("isDoNothing");
            } else if (!z2 || this.retryDownloadTimes.get().intValue() >= 3) {
                int i4 = 1;
                if (1 != i) {
                    ProcessUtils.toast(this.context, z4 ? R.string.base_memory_not_enough : R.string.base_update_so_failed_text);
                    i4 = 1;
                }
                if (i4 == i) {
                    ReportUtils.resDownloadReport(i, this.context, mergeBuilder.isSilent() ? EventConstant.SILENT_DOWNLOAD_FAIL : EventConstant.ACT_DOWNLOAD_FAIL, "Download Error:" + message, false);
                } else {
                    ReportUtils.resDownloadReport(i, this.context, EventConstant.DOWNLOAD_GAME_ERROR, th.getMessage(), mergeBuilder.isSilent());
                }
                if (message.toLowerCase().contains("exceptions occurred") || str2.equals(message)) {
                    ReportUtils.downloadErrorReport(this.context, new Throwable(getTypeTitle(i) + message, th));
                }
                progressInfo.getIsDownload().set(false);
                progressInfo.getIsError().set(true);
                DownloadInfoCenter.getInstance().updateDownloadTotalProgress();
                if (iDownloadListener != null) {
                    iDownloadListener.onError(message);
                }
                if (action != null) {
                    action.call();
                }
            } else {
                this.baseFileHandler.a();
                progressInfo.getProgressValue().set(0);
                progressInfo.getProgress().set(new Progress());
                DownloadInfoCenter.getInstance().updateDownloadTotalProgress();
                this.retryDownloadTimes.set(Integer.valueOf(this.retryDownloadTimes.get().intValue() + 1));
                if (z) {
                    process(i2, i3, str, iDownloadListener, iVerifyListener, iUnzipListener);
                } else {
                    process(str, iDownloadListener, iVerifyListener, iUnzipListener);
                }
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
            c.a(getTypeTitle(i) + "Download onError").c("RemoteException");
        }
        c.a(getTypeTitle(i) + "Download onError").a("Download Failed: " + message);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091 A[Catch: RemoteException -> 0x008c, TryCatch #0 {RemoteException -> 0x008c, blocks: (B:15:0x004c, B:16:0x0051, B:35:0x0083, B:36:0x0086, B:37:0x0089, B:18:0x0055, B:21:0x005f, B:24:0x0069, B:27:0x0071, B:41:0x0091, B:42:0x0096, B:44:0x00cc, B:46:0x00da, B:48:0x010f, B:49:0x0121, B:51:0x012e, B:55:0x013b, B:61:0x0198, B:63:0x019c, B:64:0x019e, B:66:0x01a3, B:59:0x0157, B:60:0x0180), top: B:71:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012e A[Catch: RemoteException -> 0x008c, TryCatch #0 {RemoteException -> 0x008c, blocks: (B:15:0x004c, B:16:0x0051, B:35:0x0083, B:36:0x0086, B:37:0x0089, B:18:0x0055, B:21:0x005f, B:24:0x0069, B:27:0x0071, B:41:0x0091, B:42:0x0096, B:44:0x00cc, B:46:0x00da, B:48:0x010f, B:49:0x0121, B:51:0x012e, B:55:0x013b, B:61:0x0198, B:63:0x019c, B:64:0x019e, B:66:0x01a3, B:59:0x0157, B:60:0x0180), top: B:71:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019c A[Catch: RemoteException -> 0x008c, TryCatch #0 {RemoteException -> 0x008c, blocks: (B:15:0x004c, B:16:0x0051, B:35:0x0083, B:36:0x0086, B:37:0x0089, B:18:0x0055, B:21:0x005f, B:24:0x0069, B:27:0x0071, B:41:0x0091, B:42:0x0096, B:44:0x00cc, B:46:0x00da, B:48:0x010f, B:49:0x0121, B:51:0x012e, B:55:0x013b, B:61:0x0198, B:63:0x019c, B:64:0x019e, B:66:0x01a3, B:59:0x0157, B:60:0x0180), top: B:71:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a3 A[Catch: RemoteException -> 0x008c, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x008c, blocks: (B:15:0x004c, B:16:0x0051, B:35:0x0083, B:36:0x0086, B:37:0x0089, B:18:0x0055, B:21:0x005f, B:24:0x0069, B:27:0x0071, B:41:0x0091, B:42:0x0096, B:44:0x00cc, B:46:0x00da, B:48:0x010f, B:49:0x0121, B:51:0x012e, B:55:0x013b, B:61:0x0198, B:63:0x019c, B:64:0x019e, B:66:0x01a3, B:59:0x0157, B:60:0x0180), top: B:71:0x004c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unzipOnError(int r15, java.lang.Throwable r16, com.sandboxol.center.download.entity.ProgressInfo r17, java.lang.String r18, com.sandboxol.center.download.service.IDownloadListener r19, com.sandboxol.center.download.service.IVerifyListener r20, com.sandboxol.center.download.service.IUnzipListener r21, com.sandboxol.center.download.entity.MergeBuilder r22, int r23, int r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.service.BaseServiceProcess.unzipOnError(int, java.lang.Throwable, com.sandboxol.center.download.entity.ProgressInfo, java.lang.String, com.sandboxol.center.download.service.IDownloadListener, com.sandboxol.center.download.service.IVerifyListener, com.sandboxol.center.download.service.IUnzipListener, com.sandboxol.center.download.entity.MergeBuilder, int, int, boolean):void");
    }

    public void verifyOnError(int i, Throwable th, ProgressInfo progressInfo, IVerifyListener iVerifyListener, String str, IDownloadListener iDownloadListener, IUnzipListener iUnzipListener, MergeBuilder mergeBuilder, int i2, int i3, boolean z) {
        try {
            this.baseFileHandler.a();
            progressInfo.getIsDownload().set(false);
            progressInfo.getIsError().set(true);
            progressInfo.getProgressValue().set(0);
            progressInfo.getProgress().set(new Progress());
            DownloadInfoCenter.getInstance().updateDownloadTotalProgress();
            c.a(getTypeTitle(i) + "Download&Unzip").a(getTypeTitle(i) + "Download&Unzip", "Verify Failed:" + th.getMessage());
            if (this.retryDownloadTimes.get().intValue() < 3) {
                progressInfo.getIsDownload().set(true);
                progressInfo.getIsError().set(false);
                DownloadInfoCenter.getInstance().updateDownloadTotalProgress();
                this.retryDownloadTimes.set(Integer.valueOf(this.retryDownloadTimes.get().intValue() + 1));
                if (z) {
                    process(i2, i3, str, iDownloadListener, iVerifyListener, iUnzipListener);
                    return;
                } else {
                    process(str, iDownloadListener, iVerifyListener, iUnzipListener);
                    return;
                }
            }
            if (1 == i) {
                ReportUtils.resDownloadReport(i, this.context, mergeBuilder.isSilent() ? EventConstant.SILENT_DOWNLOAD_FAIL : EventConstant.ACT_DOWNLOAD_FAIL, "Verify Error:" + th.getMessage(), false);
            } else {
                ReportUtils.resDownloadReport(i, this.context, EventConstant.CHECK_MD_5_ERROR, th.getMessage(), mergeBuilder.isSilent());
            }
            if (1 != i) {
                ProcessUtils.toast(this.context, R.string.base_md5_check_failed);
            }
            if (iVerifyListener != null) {
                iVerifyListener.onError(th.getMessage() != null ? th.getMessage() : "unknown throwable");
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
