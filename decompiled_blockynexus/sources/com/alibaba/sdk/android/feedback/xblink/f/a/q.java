package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.util.Base64;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class q implements IWxCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f3819a;

    q(p pVar) {
        this.f3819a = pVar;
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onError(int i, String str) {
        this.f3819a.h.post(new s(this));
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onProgress(int i) {
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onSuccess(Object... objArr) throws Throwable {
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaRecorder", "mRecordCallback onSuccess");
        if (objArr != null && objArr.length == 2 && (objArr[0] instanceof String)) {
            String str = (String) objArr[0];
            int iIntValue = ((Integer) objArr[1]).intValue();
            try {
                byte[] bArrA = this.f3819a.a(new File(str));
                com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
                String strReplaceAll = new String(Base64.encode(bArrA, 0)).replaceAll("[\r|\n]", "");
                mVar.a("audioData", strReplaceAll);
                mVar.a("duration", String.valueOf(iIntValue));
                mVar.a("audioFile", str);
                this.f3819a.h.post(new r(this, strReplaceAll, iIntValue, str, mVar));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
