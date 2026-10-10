package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.util.c f3818f;
    private com.alibaba.sdk.android.feedback.xblink.f.b g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3817e = 0;
    private Handler h = new Handler(Looper.getMainLooper());
    private boolean i = false;
    private String j = "stop";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    IWxCallback f3816d = new q(this);

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        if (this.f3804c) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.f3817e;
            this.f3817e = jCurrentTimeMillis;
            if (j < 1000) {
                com.alibaba.sdk.android.feedback.xblink.i.g.e("WXMediaRecorder", "record, call this method too frequent,  " + j);
                com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
                mVar.a("HY_FAILED");
                bVar.b(mVar);
                return;
            }
            if (this.i) {
                com.alibaba.sdk.android.feedback.xblink.i.g.e("WXMediaRecorder", "mIsStarted is true ");
                com.alibaba.sdk.android.feedback.xblink.f.m mVar2 = new com.alibaba.sdk.android.feedback.xblink.f.m();
                mVar2.a("HY_FAILED");
                bVar.b(mVar2);
                return;
            }
            this.g = bVar;
            try {
                JSONObject jSONObject = new JSONObject(str);
                long jOptLong = jSONObject.optLong("maxTime");
                long jOptLong2 = jSONObject.optLong("miniTime");
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaRecorder", "maxTime=" + jOptLong);
                this.f3818f = new com.alibaba.sdk.android.feedback.util.c(this.f3816d, jOptLong, jOptLong2);
                this.f3818f.a();
                this.i = true;
                com.alibaba.sdk.android.feedback.xblink.f.m mVar3 = new com.alibaba.sdk.android.feedback.xblink.f.m();
                if (this.g != null) {
                    this.g.a(mVar3);
                }
            } catch (JSONException unused) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WXMediaRecorder", "record fail, params: " + str);
                com.alibaba.sdk.android.feedback.xblink.f.m mVar4 = new com.alibaba.sdk.android.feedback.xblink.f.m();
                mVar4.a("HY_PARAM_ERR");
                bVar.b(mVar4);
            }
        }
    }

    public void a(XBHybridWebView xBHybridWebView, String str) {
        String str2 = String.format("javascript:window.WindVane.fireEvent('%s', '%s');", "WXCommunication.onBroadcast", str);
        if (xBHybridWebView != null) {
            try {
                xBHybridWebView.loadUrl(str2);
            } catch (Exception e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WXMediaRecorder", e2.getMessage());
            }
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if ("start".equals(str)) {
            this.j = "start";
            a(bVar, str2);
            return true;
        }
        if ("stop".equals(str)) {
            this.j = "stop";
            b(bVar, str2);
            return true;
        }
        if (!"cancel".equals(str)) {
            return false;
        }
        c(bVar, str2);
        return true;
    }

    public byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.read(bArr) == -1) {
                    throw new IOException("EOF reached while trying to read the whole file");
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return bArr;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public synchronized void b(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        this.g = bVar;
        this.i = false;
        if (this.f3818f != null) {
            this.f3818f.b();
        }
    }

    public synchronized void c(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        this.g = bVar;
        this.i = false;
        if (this.f3818f != null) {
            this.f3818f.c();
            com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
            if (this.g != null) {
                this.g.a(mVar);
            }
        }
    }
}
