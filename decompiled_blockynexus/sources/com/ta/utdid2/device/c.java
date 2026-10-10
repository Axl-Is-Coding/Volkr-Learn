package com.ta.utdid2.device;

import android.content.Context;
import android.provider.Settings;
import com.ta.utdid2.b.a.g;
import com.ta.utdid2.b.a.i;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: UTUtdid.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.ta.utdid2.c.a.c f116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private d f117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ta.utdid2.c.a.c f19377b;
    private String m;
    private Context mContext;
    private String n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f19376f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f19375a = null;
    private static final String o = ".UTSystemConfig" + File.separator + "Global";
    private String l = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Pattern f118a = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public c(Context context) {
        this.mContext = null;
        this.f117a = null;
        this.m = "xx_utdid_key";
        this.n = "xx_utdid_domain";
        this.f116a = null;
        this.f19377b = null;
        this.mContext = context;
        this.f19377b = new com.ta.utdid2.c.a.c(context, o, "Alvin2", false, true);
        this.f116a = new com.ta.utdid2.c.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f117a = new d();
        this.m = String.format("K_%d", Integer.valueOf(i.a(this.m)));
        this.n = String.format("D_%d", Integer.valueOf(i.a(this.n)));
    }

    public static c a(Context context) {
        if (context != null && f19375a == null) {
            synchronized (f19376f) {
                if (f19375a == null) {
                    f19375a = new c(context);
                    f19375a.d();
                }
            }
        }
        return f19375a;
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f118a.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        com.ta.utdid2.c.a.c cVar = this.f19377b;
        if (cVar != null) {
            if (i.m95a(cVar.getString("UTDID2"))) {
                String string = this.f19377b.getString("UTDID");
                if (!i.m95a(string)) {
                    f(string);
                }
            }
            boolean z = false;
            if (!i.m95a(this.f19377b.getString("DID"))) {
                this.f19377b.remove("DID");
                z = true;
            }
            if (!i.m95a(this.f19377b.getString("EI"))) {
                this.f19377b.remove("EI");
                z = true;
            }
            if (!i.m95a(this.f19377b.getString("SI"))) {
                this.f19377b.remove("SI");
                z = true;
            }
            if (z) {
                this.f19377b.commit();
            }
        }
    }

    private void f(String str) {
        com.ta.utdid2.c.a.c cVar;
        if (b(str)) {
            if (str.endsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (cVar = this.f19377b) == null) {
                return;
            }
            cVar.putString("UTDID2", str);
            this.f19377b.commit();
        }
    }

    private void g(String str) {
        com.ta.utdid2.c.a.c cVar;
        if (str == null || (cVar = this.f116a) == null || str.equals(cVar.getString(this.m))) {
            return;
        }
        this.f116a.putString(this.m, str);
        this.f116a.commit();
    }

    private void h(String str) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && b(str)) {
            if (str.endsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String string = null;
                try {
                    string = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (b(string)) {
                    return;
                }
                try {
                    Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void i(String str) {
        String string;
        try {
            string = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            string = null;
        }
        if (str.equals(string)) {
            return;
        }
        try {
            Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        } catch (Exception unused2) {
        }
    }

    private void j(String str) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") != 0 || str == null) {
            return;
        }
        i(str);
    }

    public synchronized String getValue() {
        if (this.l != null) {
            return this.l;
        }
        return h();
    }

    private static String b(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        return com.ta.utdid2.b.a.b.encodeToString(mac.doFinal(bArr), 2);
    }

    private String g() {
        com.ta.utdid2.c.a.c cVar = this.f19377b;
        if (cVar == null) {
            return null;
        }
        String string = cVar.getString("UTDID2");
        if (i.m95a(string) || this.f117a.a(string) == null) {
            return null;
        }
        return string;
    }

    private final byte[] a() throws Exception {
        String string;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bytes = com.ta.utdid2.b.a.e.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = com.ta.utdid2.b.a.e.getBytes(iNextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            string = g.a(this.mContext);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(new Random().nextInt());
            string = sb.toString();
        }
        byteArrayOutputStream.write(com.ta.utdid2.b.a.e.getBytes(i.a(string)), 0, 4);
        byteArrayOutputStream.write(com.ta.utdid2.b.a.e.getBytes(i.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public synchronized String h() {
        String string;
        String string2 = "";
        try {
            string2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
        } catch (Exception unused) {
        }
        if (b(string2)) {
            return string2;
        }
        e eVar = new e();
        boolean z = false;
        try {
            string = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused2) {
            string = null;
        }
        if (i.m95a(string)) {
            z = true;
        } else {
            String strC = eVar.c(string);
            if (b(strC)) {
                h(strC);
                return strC;
            }
            String strB = eVar.b(string);
            if (b(strB)) {
                String strA = this.f117a.a(strB);
                if (!i.m95a(strA)) {
                    j(strA);
                    try {
                        string = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                    } catch (Exception unused3) {
                    }
                }
            }
            String strB2 = this.f117a.b(string);
            if (b(strB2)) {
                this.l = strB2;
                f(strB2);
                g(string);
                h(this.l);
                return this.l;
            }
        }
        String strG = g();
        if (b(strG)) {
            String strA2 = this.f117a.a(strG);
            if (z) {
                j(strA2);
            }
            h(strG);
            g(strA2);
            this.l = strG;
            return strG;
        }
        String string3 = this.f116a.getString(this.m);
        if (!i.m95a(string3)) {
            String strB3 = eVar.b(string3);
            if (!b(strB3)) {
                strB3 = this.f117a.b(string3);
            }
            if (b(strB3)) {
                String strA3 = this.f117a.a(strB3);
                if (!i.m95a(strB3)) {
                    this.l = strB3;
                    if (z) {
                        j(strA3);
                    }
                    f(this.l);
                    return this.l;
                }
            }
        }
        try {
            byte[] bArrA = a();
            if (bArrA != null) {
                this.l = com.ta.utdid2.b.a.b.encodeToString(bArrA, 2);
                f(this.l);
                String strC2 = this.f117a.c(bArrA);
                if (strC2 != null) {
                    if (z) {
                        j(strC2);
                    }
                    g(strC2);
                }
                return this.l;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
