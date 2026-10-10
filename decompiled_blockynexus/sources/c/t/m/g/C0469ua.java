package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.sandboxol.center.utils.TimeUtil;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

/* JADX INFO: renamed from: c.t.m.g.ua, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public class C0469ua extends AbstractC0432hb {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3406d = C0481ya.a() + Ba.b(C0469ua.class.getName()).substring(0, 8);
    private long A;
    private BroadcastReceiver B;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f3407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f3408f;
    private boolean g;
    public Da h;
    private volatile Handler i;
    public long j;
    public long k;
    public int l;
    public int m;
    public long n;
    public long o;
    public long p;
    public long q;
    public boolean r;
    public int s;
    public long t;
    public long u;
    private long v;
    private volatile List<cp> w;
    private volatile List<ScanResult> x;
    private volatile Location y;
    public RunnableC0475wa z;

    public C0469ua(Context context, String str) {
        this(context, new File(str + "/f_c"));
    }

    @Override // c.t.m.g.AbstractC0432hb
    public final String a() {
        return "DC_Pro";
    }

    public final void c() {
        try {
            this.f3407e.unregisterReceiver(this.B);
        } catch (Throwable unused) {
        }
        RunnableC0475wa runnableC0475wa = this.z;
        if (runnableC0475wa != null) {
            runnableC0475wa.e();
            this.z = null;
        }
        if (this.g) {
            C0458qa.a(this.i, 104, 0L);
            C0458qa.a(this.i, 106, 0L);
            this.v = 0L;
            C0458qa.a(this.i, 107, 0L);
            C0458qa.a(this.i, 105, 200L);
            this.i = null;
        }
    }

    /* JADX INFO: renamed from: c.t.m.g.ua$a */
    /* JADX INFO: compiled from: TL */
    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f3409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private BufferedOutputStream f3410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private StringBuffer f3411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f3412d;

        public a(Looper looper) {
            super(looper);
            this.f3412d = "";
        }

        private long a() {
            long j = C0481ya.f3451f ? 51200L : 512000L;
            return C0469ua.this.j > j ? j : C0469ua.this.j;
        }

        private void b() {
            StringBuffer stringBuffer = this.f3411c;
            if (stringBuffer == null || stringBuffer.length() == 0 || this.f3410b == null) {
                return;
            }
            byte[] bArrA = Ba.a(this.f3411c.toString());
            StringBuilder sb = new StringBuilder("write buf to file:buf:");
            sb.append(this.f3411c.length());
            sb.append(",enc:");
            sb.append(bArrA == null ? 0 : bArrA.length);
            this.f3411c.setLength(0);
            if (bArrA == null || bArrA.length == 0) {
                return;
            }
            try {
                this.f3410b.write(bArrA);
                this.f3410b.write(36);
                this.f3410b.flush();
            } catch (Throwable th) {
                C0458qa.a("write file failed.", th);
                this.f3409a = null;
                C0458qa.a(this.f3410b);
            }
        }

        private void c() {
            try {
                if (this.f3410b != null) {
                    this.f3410b.flush();
                }
            } catch (Throwable unused) {
                this.f3409a = null;
                C0458qa.a(this.f3410b);
            }
        }

        private void d() {
            File file = this.f3409a;
            if (file == null || !file.exists() || this.f3410b == null || !C0469ua.f3406d.equals(this.f3409a.getName())) {
                this.f3409a = e();
                try {
                    boolean zExists = this.f3409a.exists();
                    this.f3410b = new BufferedOutputStream(new FileOutputStream(this.f3409a, true), 1024);
                    if (zExists) {
                        return;
                    }
                    _a.a("LocationSDK", "log_fc_create", Long.valueOf(System.currentTimeMillis()));
                } catch (Throwable th) {
                    C0458qa.a("open file error", th);
                }
            }
        }

        private File e() {
            File file = C0469ua.this.f3408f;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, C0469ua.f3406d);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            long j;
            long j2;
            try {
                new StringBuilder("handleMessage:").append(message.what);
                switch (message.what) {
                    case 101:
                    case 102:
                        try {
                            int i = message.what;
                            d();
                            String strA = "";
                            if (i == 102) {
                                strA = Aa.a(C0469ua.this.h, C0469ua.this.y, null, C0469ua.this.w);
                            } else if (i == 101) {
                                List list = C0469ua.this.x;
                                if (!C0458qa.a(list)) {
                                    strA = Aa.a(C0469ua.this.h, C0469ua.this.y, list, C0469ua.this.w);
                                }
                            }
                            if (this.f3410b != null && !TextUtils.isEmpty(strA) && strA.length() >= 25) {
                                String strA2 = C0458qa.a(strA.substring(22).getBytes());
                                if (this.f3412d.equals(strA2)) {
                                    return;
                                }
                                this.f3412d = strA2;
                                if (this.f3411c == null) {
                                    this.f3411c = new StringBuffer(C0469ua.this.m);
                                }
                                StringBuffer stringBuffer = this.f3411c;
                                stringBuffer.append(strA);
                                stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                                if (this.f3411c.length() > C0469ua.this.m || (this.f3409a != null && this.f3409a.length() == 0)) {
                                    b();
                                    if (this.f3409a.length() > a()) {
                                        C0458qa.a(C0469ua.this.i, 106, 0L);
                                    }
                                }
                                StringBuilder sb = new StringBuilder("write:");
                                sb.append(strA.substring(0, 60));
                                sb.append("***,len=");
                                sb.append(strA.length());
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            C0458qa.a("write data error!", th);
                            return;
                        }
                    case 103:
                        if (C0469ua.this.g) {
                            String absolutePath = C0469ua.this.f3408f.getAbsolutePath();
                            if (a(absolutePath)) {
                                return;
                            }
                            a(absolutePath.replaceAll("f_c", "d_c"));
                            return;
                        }
                        return;
                    case 104:
                        c();
                        return;
                    case 105:
                        try {
                            try {
                                b();
                                if (this.f3411c != null) {
                                    this.f3411c.setLength(0);
                                }
                                this.f3409a = null;
                                C0458qa.a(this.f3410b);
                                j = C0469ua.this.q;
                                j2 = C0469ua.this.n;
                                break;
                            } catch (Throwable unused) {
                                this.f3409a = null;
                                C0458qa.a(this.f3410b);
                                j = C0469ua.this.q;
                                j2 = C0469ua.this.n;
                            }
                            a(j, j2);
                            removeCallbacksAndMessages(null);
                            return;
                        } catch (Throwable th2) {
                            this.f3409a = null;
                            C0458qa.a(this.f3410b);
                            a(C0469ua.this.q, C0469ua.this.n);
                            throw th2;
                        }
                    case 106:
                        d();
                        if (C0469ua.this.f3408f != null && this.f3409a != null && this.f3409a.exists()) {
                            b();
                            long jLongValue = ((Long) _a.b("LocationSDK", "log_fc_create", (Object) 0L)).longValue();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            StringBuilder sb2 = new StringBuilder("desFileLen=");
                            sb2.append(this.f3409a.length());
                            sb2.append(",maxFileSize=");
                            sb2.append(a());
                            sb2.append(",curT=");
                            sb2.append(jCurrentTimeMillis);
                            sb2.append(",createT=");
                            sb2.append(jLongValue);
                            sb2.append(",maxTimeRename:");
                            sb2.append(C0469ua.this.p);
                            if (this.f3409a.length() > a() || jCurrentTimeMillis - jLongValue > C0469ua.this.p) {
                                c();
                                if (this.f3409a != null && this.f3409a.length() >= 1024) {
                                    C0458qa.a(this.f3410b);
                                    this.f3410b = null;
                                    a(4, this.f3409a);
                                    this.f3409a = null;
                                    _a.a("LocationSDK", "log_fc_create", (Object) 0L);
                                }
                                a(C0469ua.this.q, C0469ua.this.n);
                                if (C0481ya.f3451f) {
                                    sendEmptyMessage(107);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 107:
                        removeMessages(107);
                        C0469ua.a(C0469ua.this, C0469ua.this.i);
                        C0458qa.a(C0469ua.this.i, 107, C0469ua.this.k);
                        return;
                    case 108:
                        removeMessages(108);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th3) {
                C0458qa.a("handler msg error!", th3);
            }
            C0458qa.a("handler msg error!", th3);
        }

        private boolean a(String str) {
            File[] fileArrListFiles = null;
            File file = TextUtils.isEmpty(str) ? null : new File(str);
            if (file != null && file.exists() && file.isDirectory()) {
                fileArrListFiles = file.listFiles();
            }
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i = C0469ua.this.l;
                for (int i2 = 0; i2 < fileArrListFiles.length && i > 0; i2++) {
                    File file2 = fileArrListFiles[i2];
                    String name = (file2 != null && file2.exists() && file2.isFile()) ? file2.getName() : "";
                    if (name.startsWith("dc") || name.startsWith("fc")) {
                        if (str.endsWith("d_c") && (file2.length() == 0 || jCurrentTimeMillis - file2.lastModified() > C0469ua.this.q)) {
                            file2.delete();
                        } else {
                            boolean z = (name.startsWith(C0481ya.a()) && name.endsWith(".enc")) || (name.startsWith("fc2") || name.startsWith("fc3"));
                            if (!z) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                sb.append(",has no ");
                                sb.append(C0481ya.a());
                                sb.append("***.enc files!!!");
                                z = name.startsWith("dc") && System.currentTimeMillis() - file2.lastModified() > 172800000;
                            }
                            if (z && a(file2.length())) {
                                StringBuilder sb2 = new StringBuilder("upload:");
                                sb2.append(file2.getName());
                                sb2.append(",len=");
                                sb2.append(file2.length());
                                int iA = C0481ya.a(name);
                                if (iA > 0) {
                                    String strA = C0481ya.a(iA);
                                    if (!TextUtils.isEmpty(strA)) {
                                        if (!C0481ya.f3450e) {
                                            strA = strA.replace("https:", "http:");
                                        }
                                        C0469ua.a(C0469ua.this, file2, strA);
                                        i--;
                                    }
                                }
                            }
                        }
                    }
                }
                return i != C0469ua.this.l;
            }
            if (fileArrListFiles != null && str.endsWith("d_c")) {
                file.delete();
            }
            return false;
        }

        private boolean a(long j) {
            try {
                SharedPreferences sharedPreferencesA = _a.a("LocationSDK");
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                String string = sharedPreferencesA.getString("log_up_fc_date", "");
                long j2 = sharedPreferencesA.getLong("log_up_fc_size", 0L);
                String str = Ua.a(TimeUtil.DEFAULT_DAY_NO_SEPRATOR_FORMAT).format(new Date());
                if (!str.equals(string)) {
                    editorEdit.putString("log_up_fc_date", str);
                    editorEdit.putLong("log_up_fc_size", j);
                } else {
                    if (j2 > C0469ua.this.o) {
                        return false;
                    }
                    editorEdit.putLong("log_up_fc_size", j + j2);
                }
                editorEdit.apply();
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }

        private static void a(int i, File file) {
            try {
                if (file.isFile()) {
                    File file2 = new File(file.getAbsolutePath() + Consts.DOT + System.currentTimeMillis() + ".enc");
                    if (i == 4) {
                        byte[] bArrA = C0458qa.a(file);
                        if (!C0458qa.c(bArrA)) {
                            byte[] bArrB = C0458qa.b(bArrA);
                            if (!C0458qa.c(bArrB)) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                                fileOutputStream.write(bArrB);
                                fileOutputStream.close();
                                file.delete();
                            }
                        }
                    } else {
                        file.renameTo(file2);
                    }
                    StringBuilder sb = new StringBuilder("rename:");
                    sb.append(file.getName());
                    sb.append(" to ");
                    sb.append(file2.getName());
                }
            } catch (Throwable th) {
                C0458qa.a("rename:" + file.getName() + " error.", th);
            }
        }

        private void a(long j, long j2) {
            File file = null;
            File[] fileArrListFiles = C0469ua.this.f3408f == null ? null : C0469ua.this.f3408f.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long length = 0;
            for (File file2 : fileArrListFiles) {
                if (file2.exists() && file2.isFile() && !C0469ua.f3406d.equals(file2.getName())) {
                    if (jCurrentTimeMillis - file2.lastModified() <= j && file2.length() != 0) {
                        String name = file2.getName();
                        if (jCurrentTimeMillis - file2.lastModified() > 172800000 && !name.endsWith(".enc") && name.startsWith(C0481ya.a())) {
                            a(C0481ya.a(name), file2);
                        } else {
                            length += file2.length();
                            if (file == null || file.lastModified() > file2.lastModified()) {
                                file = file2;
                            }
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("delete expired file:");
                        sb.append(file2.getName());
                        sb.append(",len:");
                        sb.append(file2.length());
                        file2.delete();
                    }
                }
            }
            if (length < j2 || file == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder("too big folder size:");
            sb2.append(length);
            sb2.append(", delete ");
            sb2.append(file.getName());
            sb2.append(",size:");
            sb2.append(file.length());
            file.delete();
        }
    }

    private C0469ua(Context context, File file) {
        this.f3407e = null;
        this.h = null;
        this.j = 102400L;
        this.k = 3600000L;
        this.l = 1;
        this.m = 25600;
        this.n = 104857600L;
        this.o = 10485760L;
        this.p = 259200000L;
        this.q = 2592000000L;
        this.r = true;
        this.s = 0;
        this.t = 60000L;
        this.u = 3000L;
        this.v = 0L;
        this.A = 0L;
        this.B = new C0460ra(this);
        this.f3407e = context;
        this.f3408f = file;
        this.g = false;
    }

    public static long a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public final synchronized void a(Location location, List<ScanResult> list, List<cp> list2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (location != null && jCurrentTimeMillis - location.getTime() <= 10000) {
            this.y = location;
            this.x = list;
            this.w = list2;
            if (this.g) {
                if (list == null) {
                    if (!C0458qa.a(list2)) {
                        C0458qa.a(this.i, 102, 0L);
                    }
                } else if (!C0458qa.a(list)) {
                    C0458qa.a(this.i, 101, 0L);
                }
            }
        }
    }

    @Override // c.t.m.g.AbstractC0432hb
    public final int a(Looper looper) {
        this.w = null;
        this.x = null;
        this.y = null;
        this.v = 0L;
        File file = this.f3408f;
        this.g = file != null && (file.exists() || this.f3408f.mkdirs());
        new StringBuilder("startup! prepared:").append(this.g);
        if (this.g) {
            this.i = new a(looper);
            this.v = System.currentTimeMillis() - 40000;
            C0458qa.a(this.i, 107, 300000L);
            try {
                this.f3407e.registerReceiver(this.B, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Throwable th) {
                C0458qa.a("listenNetworkState: failed", th);
            }
        }
        if (this.g && this.r) {
            this.z = new RunnableC0475wa(this.f3408f);
            this.z.a(looper);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(c.t.m.g.C0469ua r18, android.os.Handler r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "log_fc_up_in_m"
            java.lang.String r3 = "LocationSDK"
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r0.v
            long r6 = r4 - r6
            r8 = 60000(0xea60, double:2.9644E-319)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L18
            return
        L18:
            r6 = 106(0x6a, float:1.49E-43)
            r7 = 0
            c.t.m.g.C0458qa.a(r1, r6, r7)
            android.content.Context r6 = c.t.m.g.C0458qa.d()     // Catch: java.lang.Throwable -> L9a
            c.t.m.g.dn$a r6 = c.t.m.g.dn.a(r6)     // Catch: java.lang.Throwable -> L9a
            c.t.m.g.dn$a r9 = c.t.m.g.dn.a.f3124a     // Catch: java.lang.Throwable -> L9a
            r10 = 1
            if (r6 != r9) goto L2e
            r10 = 0
            goto L6e
        L2e:
            c.t.m.g.dn$a r9 = c.t.m.g.dn.a.f3125b     // Catch: java.lang.Throwable -> L9a
            if (r6 != r9) goto L6e
            boolean r9 = c.t.m.g.C0481ya.f3451f     // Catch: java.lang.Throwable -> L9a
            boolean r11 = c.t.m.g.C0481ya.f3451f     // Catch: java.lang.Throwable -> L9a
            if (r11 != 0) goto L6d
            boolean r11 = c.t.m.g.C0481ya.g     // Catch: java.lang.Throwable -> L9a
            if (r11 == 0) goto L6d
            java.lang.Long r11 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r11 = c.t.m.g._a.b(r3, r2, r11)     // Catch: java.lang.Throwable -> L9a
            java.lang.Long r11 = (java.lang.Long) r11     // Catch: java.lang.Throwable -> L9a
            long r11 = r11.longValue()     // Catch: java.lang.Throwable -> L9a
            long r13 = r4 - r11
            r15 = 86400000(0x5265c00, double:4.2687272E-316)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 <= 0) goto L6d
            java.lang.Long r9 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L9a
            c.t.m.g._a.a(r3, r2, r9)     // Catch: java.lang.Throwable -> L9a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = "upload in mobile once today. lastUpT="
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L9a
            r2.append(r11)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = ",curT="
            r2.append(r3)     // Catch: java.lang.Throwable -> L9a
            r2.append(r4)     // Catch: java.lang.Throwable -> L9a
            goto L6e
        L6d:
            r10 = r9
        L6e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = "network status:"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L9a
            r2.append(r6)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = ",isUpload:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L9a
            r2.append(r10)     // Catch: java.lang.Throwable -> L9a
            if (r10 == 0) goto L99
            boolean r2 = r0.g     // Catch: java.lang.Throwable -> L9a
            if (r2 == 0) goto L99
            r2 = 103(0x67, float:1.44E-43)
            c.t.m.g.C0458qa.a(r1, r2, r7)     // Catch: java.lang.Throwable -> L9a
            r0.v = r4     // Catch: java.lang.Throwable -> L9a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            java.lang.String r2 = "send upload msg, last upload time:"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L9a
            long r2 = r0.v     // Catch: java.lang.Throwable -> L9a
            r1.append(r2)     // Catch: java.lang.Throwable -> L9a
        L99:
            return
        L9a:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            c.t.m.g.C0458qa.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0469ua.a(c.t.m.g.ua, android.os.Handler):void");
    }

    static /* synthetic */ void a(C0469ua c0469ua, File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new Thread(new RunnableC0466ta(c0469ua, file, str), "th_upload_fc").start();
    }
}
