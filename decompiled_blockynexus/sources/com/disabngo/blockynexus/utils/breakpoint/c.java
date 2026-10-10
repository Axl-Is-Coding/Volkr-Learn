package com.disabngo.blockynexus.utils.breakpoint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import java.io.IOException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.z;

/* JADX INFO: compiled from: DownloadTask.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends AsyncTask<String, Integer, Integer> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f10513d;
    private int g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10510a = "updateRes.tar.gz";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10514e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10515f = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f10511b = BaseApplication.getContext();

    public c(a aVar, String str) {
        this.f10513d = aVar;
        this.f10512c = str;
    }

    @SuppressLint({"WorldWriteableFiles"})
    private String b() {
        return CommonHelper.getApkOrSoDownloadPath(this.f10511b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0232 A[Catch: Exception -> 0x022e, TryCatch #0 {Exception -> 0x022e, blocks: (B:145:0x022a, B:149:0x0232, B:150:0x0235, B:152:0x0239), top: B:158:0x022a }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0239 A[Catch: Exception -> 0x022e, TRY_LEAVE, TryCatch #0 {Exception -> 0x022e, blocks: (B:145:0x022a, B:149:0x0232, B:150:0x0235, B:152:0x0239), top: B:158:0x022a }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x022a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Integer doInBackground(java.lang.String... r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 579
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.utils.breakpoint.c.doInBackground(java.lang.String[]):java.lang.Integer");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        int iIntValue = numArr[0].intValue();
        if (iIntValue > this.g) {
            this.f10513d.onProgress(iIntValue);
            this.g = iIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SO_DOWNLOAD_SUCCESS);
            this.f10513d.onSuccess();
        } else if (iIntValue == 1) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SO_DOWNLOAD_FAILED);
            this.f10513d.onFailed();
        } else if (iIntValue == 2) {
            this.f10513d.onPaused();
        } else {
            if (iIntValue != 3) {
                return;
            }
            this.f10513d.onCanceled();
        }
    }

    public void a() {
        this.f10515f = true;
    }

    private long a(String str) {
        z zVar = new z();
        C.a aVar = new C.a();
        aVar.b(str);
        try {
            H hExecute = zVar.newCall(aVar.a()).execute();
            if (hExecute == null || !hExecute.q()) {
                return 0L;
            }
            long jContentLength = hExecute.b().contentLength();
            hExecute.b().close();
            return jContentLength;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }
}
