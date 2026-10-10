package com.tencent.tp;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class TssInfoPublisher implements Runnable {
    public static final int TSS_INFO_TYPE_DETECT_RESULT = 1;
    public static final int TSS_INFO_TYPE_HEARTBEAT = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile TssInfoPublisher f19680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Thread f19681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f19682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f19683d = new ArrayList();

    public interface TssInfoReceiver {
        void onReceive(int i, String str);
    }

    private TssInfoPublisher() {
    }

    public static TssInfoPublisher a() {
        if (f19680a == null) {
            synchronized (TssInfoPublisher.class) {
                if (f19680a == null) {
                    f19680a = new TssInfoPublisher();
                }
            }
        }
        return f19680a;
    }

    private void a(int i, String str) {
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (TssInfoPublisher.class) {
            arrayList.addAll(this.f19683d);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((TssInfoReceiver) it.next()).onReceive(i, str);
        }
    }

    private static int b() {
        try {
            return Integer.parseInt(r.d(q.a("dgx_jkzi_kdkz")));
        } catch (Exception unused) {
            return -1;
        }
    }

    private static void c() {
        try {
            r.d(q.a("dgx_xgjnz_kdkz"));
        } catch (Exception unused) {
        }
    }

    private static String d() {
        try {
            return r.d(q.a("dgx_mzxq_kdkz"));
        } catch (Exception unused) {
            return "-1";
        }
    }

    public void a(TssInfoReceiver tssInfoReceiver) {
        if (tssInfoReceiver == null) {
            return;
        }
        synchronized (TssInfoPublisher.class) {
            this.f19683d.add(tssInfoReceiver);
        }
        if (f19682c) {
            return;
        }
        synchronized (TssSdk.class) {
            if (!f19682c) {
                f19682c = true;
                f19681b = new Thread(a());
                f19681b.start();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int iIndexOf;
        if (b() == -1) {
            f19682c = false;
            return;
        }
        while (true) {
            try {
                try {
                    String strD = d();
                    if (strD == null || strD.equals("-1") || (iIndexOf = strD.indexOf(124)) == -1) {
                        break;
                    }
                    int i = Integer.parseInt(strD.substring(0, iIndexOf));
                    if (i > 0) {
                        a(i, strD.substring(iIndexOf + 1));
                    } else {
                        try {
                            Thread.sleep(1000L);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
            } finally {
                c();
                f19682c = false;
            }
        }
    }
}
