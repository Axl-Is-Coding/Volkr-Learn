package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tendcloud.tenddata.bw;
import io.rong.common.dlog.DLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f19946a = "utf-8";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19948c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f19949d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f19950e = 30000;
    private static final boolean h = true;
    private static final int i = 65536;
    private static HandlerThread k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19951f = 0;
    private boolean g = true;
    private Handler l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CRC32 f19947b = new CRC32();
    private static volatile cn j = null;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private cn() {
        this.l = null;
        k = new HandlerThread("ModuleDataForward", 10);
        k.start();
        this.l = new Handler(k.getLooper()) { // from class: com.tendcloud.tenddata.cn.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    if (message.obj != null && (message.obj instanceof a)) {
                        cn.this.a((a) message.obj);
                    }
                    cn.this.b();
                } catch (Throwable th) {
                    bp.postSDKError(th);
                }
            }
        };
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i2;
        int i3;
        int iNextInt;
        if (this.l.hasMessages(5)) {
            return;
        }
        try {
            SecureRandom secureRandomB = af.b();
            int[] iArrA = ab.a();
            if (u.j(ab.g)) {
                if (this.g) {
                    i2 = iArrA[1];
                } else {
                    i3 = iArrA[1] * 1;
                    iNextInt = secureRandomB.nextInt(f19950e);
                    i2 = i3 + iNextInt;
                }
            } else if (this.g) {
                i2 = iArrA[0];
            } else {
                i3 = iArrA[0] * 1;
                iNextInt = secureRandomB.nextInt(60000) - f19950e;
                i2 = i3 + iNextInt;
            }
            int i4 = ab.P;
            if (i2 <= 1800000) {
                i4 = i2;
            }
            Iterator<a> it = a.getFeaturesList().iterator();
            while (it.hasNext()) {
                this.l.sendMessageDelayed(Message.obtain(this.l, 5, it.next()), i4);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public final void onTDEBEventForwardRequest(bw bwVar) {
        if (bwVar == null || ab.g == null) {
            return;
        }
        if (bwVar.f19904b.equals(bw.a.IMMEDIATELY)) {
            if (this.l.hasMessages(5, bwVar.f19903a)) {
                this.l.removeMessages(5);
            }
            Message.obtain(this.l, 5, bwVar.f19903a).sendToTarget();
        } else if (bwVar.f19904b.equals(bw.a.HIGH)) {
            if (this.l.hasMessages(5)) {
                this.l.removeMessages(5);
            }
            long jAbs = Math.abs((SystemClock.elapsedRealtime() - this.f19951f) - ab.R);
            if (jAbs > ab.R) {
                jAbs = 30000;
            }
            this.l.sendMessageDelayed(Message.obtain(this.l, 5, bwVar.f19903a), jAbs);
        }
    }

    private void a(String str, a aVar, boolean z) {
        String str2 = "[" + aVar.name() + "] " + str;
        int iIndex = aVar.index();
        if (iIndex != 0 && iIndex != 1 && iIndex != 3) {
            if (iIndex == 4) {
                if (z) {
                    m.iForDeveloper("[Push] " + str);
                    return;
                }
                return;
            }
            if (iIndex != 7 && iIndex != 8) {
                m.iForInternal(str2);
                return;
            }
        }
        if (z) {
            m.iForDeveloper(str2);
        } else {
            m.dForInternal(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.tendcloud.tenddata.a r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.cn.a(com.tendcloud.tenddata.a):void");
    }

    private static String a(TreeSet<cp> treeSet) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (cp cpVar : treeSet) {
            if (cpVar.c() != null && cpVar.c().length > 0) {
                sb.append(new String(cpVar.c()));
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private static byte[] a(TreeSet<cp> treeSet, byte[] bArr) {
        try {
            if (bArr.length < 65536) {
                return bArr;
            }
            int size = treeSet.size();
            for (int i2 = 0; i2 < size / 2; i2++) {
                treeSet.pollLast();
            }
            return a(treeSet, af.f(a(treeSet)));
        } catch (Throwable unused) {
            return bArr;
        }
    }

    public static byte[] a(byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        byte[] bArr2 = new byte[DLog.CRS];
        try {
            bufferedInputStream = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(bArr), new Inflater(false)));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i2 = bufferedInputStream.read(bArr2);
                    if (i2 != -1) {
                        byteArrayOutputStream.write(bArr2, 0, i2);
                    } else {
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    }
                }
            } catch (Exception unused) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Exception unused2) {
            bufferedInputStream = null;
        }
    }

    public static cn a() {
        if (j == null) {
            synchronized (cn.class) {
                if (j == null) {
                    j = new cn();
                }
            }
        }
        return j;
    }
}
