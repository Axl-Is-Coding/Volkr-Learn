package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SessionIdManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile w f20945c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f20946a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20947b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<a> f20948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f20949e;

    /* JADX INFO: compiled from: SessionIdManager.java */
    public interface a {
        void a(String str, long j, long j2);

        void a(String str, String str2, long j, long j2);
    }

    private w() {
    }

    public static w a() {
        if (f20945c == null) {
            synchronized (w.class) {
                if (f20945c == null) {
                    f20945c = new w();
                }
            }
        }
        return f20945c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString(s.f20934d, d(context));
            editorEdit.commit();
        } catch (Exception unused) {
        }
        long jH = h(context);
        long jI = i(context);
        String str = this.f20947b;
        a(jI, jH, str, false);
        this.f20947b = this.f20946a.a(context);
        a(jI, jH, str, true);
        this.f20946a.a(context, this.f20947b);
        return this.f20947b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f20947b) && g.a(context).a(this.f20947b) > 0;
    }

    private long h(Context context) {
        return a(context, s.f20936f);
    }

    private long i(Context context) {
        return a(context, s.f20931a);
    }

    private boolean j(Context context) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext(context));
            long j = sharedPreferences.getLong(s.f20935e, 0L);
            long j2 = sharedPreferences.getLong(s.f20936f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.f20946a.a(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f20946a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f20947b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f20947b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f20947b)) {
            try {
                this.f20947b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f20947b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f20947b)) {
            this.f20947b = d(context);
        }
        return TextUtils.isEmpty(this.f20947b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f20947b = d(appContext);
        if (e(appContext)) {
            try {
                this.f20947b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f20947b;
    }

    public void a(long j) {
        this.f20946a.a(j);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String string = "";
        try {
            synchronized (w.class) {
                string = PreferenceWrapper.getDefault(appContext).getString(s.f20934d, "");
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f20948d) == null || list.size() == 0) {
            return;
        }
        this.f20948d.remove(aVar);
    }

    public String a(Context context, long j) {
        if (TextUtils.isEmpty(this.f20949e)) {
            String str = "SUB" + j;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + au.au, 0));
            this.f20949e = sb.toString();
        }
        return this.f20949e;
    }

    private long a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    private void a(long j, long j2, String str, boolean z) {
        List<a> list = this.f20948d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.f20947b, j, j2);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f20947b, j, j2);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f20948d == null) {
            this.f20948d = new ArrayList();
        }
        if (this.f20948d.contains(aVar)) {
            return;
        }
        this.f20948d.add(aVar);
    }
}
