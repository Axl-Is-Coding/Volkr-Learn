package com.tencent.mapsdk.rastercore;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.rastercore.d.f;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19410a = a.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuffer f19411b = new StringBuffer(300);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19412c = false;

    public a() {
        String string;
        try {
            String strEncode = URLEncoder.encode(com.tencent.mapsdk.rastercore.f.b.a(f.a()), "UTF-8");
            this.f19411b.append("key=");
            this.f19411b.append(strEncode);
        } catch (Exception unused) {
        }
        this.f19411b.append("&output=json");
        this.f19411b.append("&pf=and_2Dmap");
        this.f19411b.append("&ver=");
        try {
            this.f19411b.append(URLEncoder.encode("1.3.2", "UTF-8"));
        } catch (Exception unused2) {
        }
        try {
            this.f19411b.append("&hm=");
            this.f19411b.append(URLEncoder.encode(Build.MODEL, "UTF-8"));
            this.f19411b.append("&os=A");
            this.f19411b.append(Build.VERSION.SDK_INT);
            this.f19411b.append("&pid=");
            this.f19411b.append(URLEncoder.encode(f.a().getPackageName(), "UTF-8"));
            this.f19411b.append("&nt=");
            this.f19411b.append(com.tencent.mapsdk.rastercore.f.b.b(c.b(f.a())));
        } catch (Exception unused3) {
        }
        this.f19411b.append("&suid=");
        this.f19411b.append(com.tencent.mapsdk.rastercore.f.b.a());
        String str = null;
        try {
            PackageManager packageManager = f.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(f.a().getPackageName(), 0);
            string = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            try {
                String str2 = packageInfo.versionName;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            } catch (Exception unused4) {
            }
        } catch (Exception unused5) {
            string = null;
        }
        if (string != null) {
            this.f19411b.append("&ref=");
            try {
                this.f19411b.append(URLEncoder.encode(string, "UTF-8"));
            } catch (Exception unused6) {
            }
        }
        if (str != null) {
            this.f19411b.append("&psv=");
            try {
                this.f19411b.append(URLEncoder.encode(str, "UTF-8"));
            } catch (Exception unused7) {
            }
        }
        try {
            DisplayMetrics displayMetrics = f.a().getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            this.f19411b.append("&dpi=");
            this.f19411b.append(i);
            this.f19411b.append("&scrn=");
            this.f19411b.append(i2);
            this.f19411b.append("*");
            this.f19411b.append(i3);
        } catch (Exception unused8) {
        }
        StringBuffer stringBuffer = this.f19411b;
    }

    static /* synthetic */ void a(a aVar, String str) {
        try {
            if (new JSONObject(str).getJSONObject("info").getInt("error") != 0) {
                f.e(false);
            }
        } catch (Exception e2) {
            String str2 = aVar.f19410a;
            new StringBuilder("checkJsonResult gets error:").append(e2.getMessage());
        }
    }

    public final void a() {
        if (this.f19412c) {
            return;
        }
        new Thread() { // from class: com.tencent.mapsdk.rastercore.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                a.this.f19412c = true;
                for (int i = 0; i < 2; i++) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://apikey.map.qq.com/mkey/index.php/mkey/check?" + a.this.f19411b.toString()).openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        if (httpURLConnection.getResponseCode() == 200) {
                            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            a.a(a.this, new String(c.a((InputStream) (headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip") ? new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())) : new BufferedInputStream(httpURLConnection.getInputStream())))));
                            break;
                        }
                        continue;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                a.this.f19412c = false;
            }
        }.start();
    }
}
