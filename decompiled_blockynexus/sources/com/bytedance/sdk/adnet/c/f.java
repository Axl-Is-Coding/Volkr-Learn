package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.tendcloud.tenddata.aa;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: TNCManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f f5449c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f5453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f5454f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5451b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5452d = false;
    private int g = 0;
    private long h = 19700101000L;
    private int i = 0;
    private HashMap<String, Integer> j = new HashMap<>();
    private HashMap<String, Integer> k = new HashMap<>();
    private int l = 0;
    private HashMap<String, Integer> m = new HashMap<>();
    private HashMap<String, Integer> n = new HashMap<>();
    private boolean o = true;
    private Map<String, Integer> p = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f5450a = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.adnet.c.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            f.this.a(message.arg1 != 0);
        }
    };

    private f() {
    }

    private boolean a(int i) {
        return i >= 200 && i < 400;
    }

    private void f() {
        SharedPreferences sharedPreferences = this.f5453e.getSharedPreferences("ttnet_tnc_config", 0);
        this.g = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.h = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void g() {
        com.bytedance.sdk.adnet.d.c.b("TNCManager", "resetTNCControlState");
        this.i = 0;
        this.j.clear();
        this.k.clear();
        this.l = 0;
        this.m.clear();
        this.n.clear();
    }

    public void b() {
        this.p.clear();
    }

    public d c() {
        e eVar = this.f5454f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public Map<String, String> d() {
        d dVarC = c();
        if (dVarC != null) {
            return dVarC.f5442d;
        }
        return null;
    }

    public e e() {
        return this.f5454f;
    }

    public static synchronized f a() {
        if (f5449c == null) {
            f5449c = new f();
        }
        return f5449c;
    }

    private void b(String str) {
        Map<String, String> mapD;
        if (TextUtils.isEmpty(str) || (mapD = d()) == null || !mapD.containsValue(str)) {
            return;
        }
        if (this.p.get(str) == null) {
            this.p.put(str, 1);
        } else {
            this.p.put(str, Integer.valueOf(this.p.get(str).intValue() + 1));
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.p.containsKey(str)) {
            this.p.put(str, 0);
        }
    }

    private boolean d(String str) {
        Map<String, String> mapD = d();
        if (mapD == null) {
            return false;
        }
        String str2 = mapD.get(str);
        if (TextUtils.isEmpty(str2) || this.p.get(str2) == null || this.p.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    public synchronized void a(Context context, boolean z) {
        if (!this.f5452d) {
            this.f5453e = context;
            this.o = z;
            this.f5454f = new e(context, z);
            if (z) {
                f();
            }
            com.bytedance.sdk.adnet.d.c.b("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.g + " probeVersion: " + this.h);
            this.f5452d = true;
        }
    }

    private boolean b(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        d dVarC = c();
        if (dVarC == null || TextUtils.isEmpty(dVarC.m)) {
            return false;
        }
        String str = dVarC.m;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return str.contains(sb.toString());
    }

    public String a(String str) {
        String protocol;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String host = null;
            try {
                URL url = new URL(str);
                protocol = url.getProtocol();
                try {
                    host = url.getHost();
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                protocol = null;
            }
            if (!TextUtils.isEmpty(protocol) && (("http".equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(host))) {
                if (d(host)) {
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + host);
                    return str;
                }
                Map<String, String> mapD = d();
                if (mapD != null && mapD.containsKey(host)) {
                    String str2 = mapD.get(host);
                    if (TextUtils.isEmpty(str2)) {
                        return str;
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleHostMapping, match, origin: " + str);
                    String str3 = protocol + aa.f19741a + host;
                    String str4 = protocol + aa.f19741a + str2;
                    if (str.startsWith(str3)) {
                        str = str.replaceFirst(str3, str4);
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleHostMapping, target: " + str);
                    return str;
                }
                com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleHostMapping, nomatch: " + host);
            }
        }
        return str;
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, m mVar) {
        if (request == null || mVar == null) {
            return;
        }
        if (this.o) {
            if (com.bytedance.sdk.adnet.d.e.a(this.f5453e)) {
                URL url = null;
                try {
                    url = new URL(request.getUrl());
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String ipAddrStr = request.getIpAddrStr();
                int i = (int) mVar.h;
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(ipAddrStr)) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "onResponse, url: " + protocol + aa.f19741a + host + "#" + ipAddrStr + "#" + i);
                    d dVarC = c();
                    if (dVarC != null && dVarC.f5440b) {
                        a(mVar, host);
                    }
                    if (dVarC == null) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "onResponse, url matched: " + protocol + aa.f19741a + host + "#" + ipAddrStr + "#" + i + " " + this.i + "#" + this.j.size() + "#" + this.k.size() + " " + this.l + "#" + this.m.size() + "#" + this.n.size());
                    if (i > 0) {
                        if (a(i)) {
                            if (this.i > 0 || this.l > 0) {
                                g();
                            }
                            c(host);
                        } else if (!b(i)) {
                            this.l++;
                            this.m.put(path, 0);
                            this.n.put(ipAddrStr, 0);
                            if (this.l >= dVarC.h && this.m.size() >= dVarC.i && this.n.size() >= dVarC.j) {
                                com.bytedance.sdk.adnet.d.c.b("TNCManager", "onResponse, url doUpdate: " + protocol + aa.f19741a + host + "#" + ipAddrStr + "#" + i);
                                a(false, 0L);
                                g();
                            }
                            b(host);
                        }
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, Exception exc) {
        if (request == null || exc == null) {
            return;
        }
        if (this.o) {
            if (com.bytedance.sdk.adnet.d.e.a(this.f5453e)) {
                URL url = null;
                try {
                    url = new URL(request.getUrl());
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String ipAddrStr = request.getIpAddrStr();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    d dVarC = c();
                    if (dVarC == null) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "onError, url matched: " + protocol + aa.f19741a + host + "#" + ipAddrStr + "# " + this.i + "#" + this.j.size() + "#" + this.k.size() + " " + this.l + "#" + this.m.size() + "#" + this.n.size());
                    this.i = this.i + 1;
                    this.j.put(path, 0);
                    this.k.put(ipAddrStr, 0);
                    if (this.i >= dVarC.f5443e && this.j.size() >= dVarC.f5444f && this.k.size() >= dVarC.g) {
                        com.bytedance.sdk.adnet.d.c.b("TNCManager", "onError, url doUpate: " + protocol + aa.f19741a + host + "#" + ipAddrStr);
                        a(false, 0L);
                        g();
                    }
                    b(host);
                }
            }
        }
    }

    private void a(m mVar, String str) {
        int i;
        long j;
        d dVarC;
        if (mVar != null && this.o) {
            String strA = mVar.a("tnc-cmd", (String) null);
            if (TextUtils.isEmpty(strA)) {
                com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleTncProbe, no probeProto, " + str);
                return;
            }
            String[] strArrSplit = strA.split("@");
            if (strArrSplit != null && strArrSplit.length == 2) {
                try {
                    i = Integer.parseInt(strArrSplit[0]);
                    try {
                        j = Long.parseLong(strArrSplit[1]);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleTncProbe, probeProto except, " + str);
                        j = 0L;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 0;
                }
                com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleTncProbe, local: " + this.g + "@" + this.h + " svr: " + i + "@" + j + " " + str);
                if (j <= this.h) {
                    return;
                }
                this.g = i;
                this.h = j;
                this.f5453e.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
                if (this.g != 10000 || (dVarC = c()) == null) {
                    return;
                }
                Random random = new Random(System.currentTimeMillis());
                int i2 = dVarC.l;
                long jNextInt = i2 > 0 ? ((long) random.nextInt(i2)) * 1000 : 0L;
                com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleTncProbe, updateConfig delay: " + jNextInt + " " + str);
                a(true, jNextInt);
                return;
            }
            com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleTncProbe, probeProto err, " + str);
        }
    }

    private void a(boolean z, long j) {
        if (this.f5450a.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.f5450a.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.f5450a.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.f5450a.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        d dVarC = c();
        if (dVarC == null) {
            return;
        }
        com.bytedance.sdk.adnet.d.c.b("TNCManager", "doUpdateRemote, " + z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.f5451b + (((long) dVarC.k) * 1000) > jElapsedRealtime) {
            com.bytedance.sdk.adnet.d.c.b("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.f5451b = jElapsedRealtime;
            com.bytedance.sdk.adnet.a.a.a(this.f5453e).b(com.bytedance.sdk.adnet.d.e.a(this.f5453e));
        }
    }
}
