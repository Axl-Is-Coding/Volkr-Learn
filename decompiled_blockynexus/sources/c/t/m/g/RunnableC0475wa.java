package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Message;
import android.util.Base64;
import c.t.m.g.Ya;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: c.t.m.g.wa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0475wa extends Pa implements Ya.a, Runnable {
    private volatile Xa h;
    private File i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f3439e = false;
    private String j = "wf4_bf";
    private String k = "wf4";
    private StringBuilder l = new StringBuilder(100);
    private Ka g = new Ka((byte) 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f3440f = new ArrayList();

    public RunnableC0475wa(File file) {
        this.i = file;
        new StringBuilder("data dir:").append(this.i.getAbsolutePath());
    }

    @Override // c.t.m.g.Qa
    public final int a() {
        a(100, 0L);
        return 0;
    }

    @Override // c.t.m.g.Qa
    public final void b() {
        a(101, 0L);
    }

    @Override // c.t.m.g.Qa
    public final String c() {
        return "WifiInfoPro";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3439e = true;
            if (this.h != null) {
                this.h.a();
                this.h = null;
            }
            File file = new File(this.i, this.k);
            StringBuilder sb = new StringBuilder("upload:");
            sb.append(file.getName());
            sb.append(",");
            sb.append(file.length());
            byte[] bArrB = C0458qa.b(C0458qa.a(file));
            boolean z = C0481ya.h;
            C0481ya.i.a(C0481ya.f3450e ? "https://analytics.map.qq.com/?wf4" : "https://analytics.map.qq.com/?wf4".replace("https:", "http:"), bArrB, new C0472va(this, file));
            if (d()) {
                this.h = new Xa(new File(this.i, this.k));
                this.h.a(this);
            }
        } catch (Throwable th) {
            C0458qa.a("upload error.", th);
        } finally {
            this.f3439e = false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.os.Message r13) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.RunnableC0475wa.b(android.os.Message):void");
    }

    @Override // c.t.m.g.Pa
    public final void a(Message message) {
        try {
            if (this.i == null) {
                return;
            }
            new StringBuilder("msg ").append(message.what);
            b(message);
        } catch (Throwable th) {
            C0458qa.a("handler msg error:" + message.what, th);
        }
    }

    private void a(List<String> list) throws IOException {
        if (this.f3439e || C0458qa.a(list)) {
            return;
        }
        if (this.h == null) {
            return;
        }
        long length = this.h.b().length();
        "wf file len:".concat(String.valueOf(length));
        if (length <= 51200) {
            StringBuilder sb = new StringBuilder(500);
            sb.append("1|");
            sb.append(list.size());
            for (String str : list) {
                sb.append('|');
                sb.append(str);
            }
            Xa xa = this.h;
            String string = sb.toString();
            synchronized (xa.f3047a) {
                if (xa.f3049c != null) {
                    byte[] bytes = string.getBytes("UTF-8");
                    if (xa.f3050d != null) {
                        bytes = xa.f3050d.a(bytes);
                    }
                    xa.f3049c.write(bytes);
                }
            }
        }
        list.clear();
    }

    private String a(ScanResult scanResult) {
        this.l.setLength(0);
        try {
            StringBuilder sb = this.l;
            sb.append(scanResult.BSSID);
            sb.append(',');
            StringBuilder sb2 = this.l;
            sb2.append(Base64.encodeToString(scanResult.SSID.getBytes("UTF-8"), 2));
            sb2.append(',');
            StringBuilder sb3 = this.l;
            sb3.append(scanResult.frequency);
            sb3.append(',');
            this.l.append(Base64.encodeToString(scanResult.capabilities.getBytes("UTF-8"), 2));
        } catch (Throwable unused) {
            this.l.setLength(0);
        }
        return this.l.toString();
    }

    @Override // c.t.m.g.Ya.a
    public final byte[] a(byte[] bArr) {
        byte[] bArrA = Va.a(C0458qa.b(bArr), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
        if (!C0458qa.c(bArrA)) {
            byte[] bArrEncode = Base64.encode(bArrA, 2);
            if (!C0458qa.c(bArrEncode)) {
                try {
                    return (new String(bArrEncode) + '$').getBytes("UTF-8");
                } catch (Throwable unused) {
                }
            }
        }
        return new byte[0];
    }
}
