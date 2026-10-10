package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.xblink.f.b f3807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.util.a f3808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MediaPlayer.OnCompletionListener f3809f = new o(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(String str, String str2, byte[] bArr) throws Throwable {
        IOException e2;
        FileNotFoundException e3;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str, (String) str2);
        if (file2.exists()) {
            file2.delete();
        }
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                str2 = new FileOutputStream(file2);
            } catch (IOException e4) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", e4);
            }
            try {
                str2.write(bArr);
                str2.flush();
                str2.close();
                str2 = str2;
            } catch (FileNotFoundException e5) {
                e3 = e5;
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", e3);
                if (str2 != 0) {
                    str2.close();
                    str2 = str2;
                }
            } catch (IOException e6) {
                e2 = e6;
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", e2);
                if (str2 != 0) {
                    str2.close();
                    str2 = str2;
                }
            }
        } catch (FileNotFoundException e7) {
            str2 = 0;
            e3 = e7;
        } catch (IOException e8) {
            str2 = 0;
            e2 = e8;
        } catch (Throwable th2) {
            str2 = 0;
            th = th2;
            if (str2 != 0) {
                try {
                    str2.close();
                } catch (IOException e9) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", e9);
                }
            }
            throw th;
        }
    }

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        File file;
        this.f3807d = bVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            String strOptString2 = jSONObject.optString("audioFile");
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", "params=" + str);
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", "url=" + strOptString);
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", "filePath=" + strOptString2);
            if (TextUtils.isEmpty(strOptString2)) {
                file = new File(com.alibaba.sdk.android.feedback.util.j.f3723b + File.separator + com.alibaba.sdk.android.feedback.xblink.i.b.a(strOptString));
            } else {
                file = new File(strOptString2);
            }
            if (file.exists()) {
                if (this.f3808e == null) {
                    this.f3808e = new com.alibaba.sdk.android.feedback.util.a();
                }
                if (this.f3808e.b()) {
                    this.f3808e.a();
                }
                this.f3808e.a(file.getAbsolutePath(), this.f3809f);
                com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
                if (this.f3807d != null) {
                    this.f3807d.a(mVar);
                }
            } else {
                new Thread(new l(this, strOptString, com.alibaba.sdk.android.feedback.xblink.i.b.a(strOptString))).start();
            }
        } catch (JSONException unused) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("WXMediaPlayer", "startPlay fail, params: " + str);
            com.alibaba.sdk.android.feedback.xblink.f.m mVar2 = new com.alibaba.sdk.android.feedback.xblink.f.m();
            mVar2.a("HY_PARAM_ERR");
            bVar.b(mVar2);
        }
    }

    public void a(XBHybridWebView xBHybridWebView, String str) {
        String str2 = String.format("javascript:window.WindVane.fireEvent('%s', '%s');", "WXCommunication.onBroadcast", str);
        if (xBHybridWebView != null) {
            try {
                xBHybridWebView.loadUrl(str2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if ("start".equals(str)) {
            a(bVar, str2);
            return true;
        }
        if (!"stop".equals(str)) {
            return false;
        }
        b(bVar, str2);
        return true;
    }

    public synchronized void b(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        this.f3807d = bVar;
        if (this.f3808e != null) {
            this.f3808e.a();
            com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
            if (this.f3807d != null) {
                this.f3807d.a(mVar);
            }
        } else {
            com.alibaba.sdk.android.feedback.xblink.f.m mVar2 = new com.alibaba.sdk.android.feedback.xblink.f.m();
            if (this.f3807d != null) {
                this.f3807d.b(mVar2);
            }
        }
    }
}
