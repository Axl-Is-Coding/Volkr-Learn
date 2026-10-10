package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import c.t.m.g.C0470ub;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: c.t.m.g.tb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0467tb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ C0470ub f3402a;

    RunnableC0467tb(C0470ub c0470ub) {
        this.f3402a = c0470ub;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        C0470ub.a aVarTake;
        String str2 = "result";
        this.f3402a.f3414a.clear();
        C0470ub c0470ub = this.f3402a;
        LinkedBlockingQueue<C0470ub.a> linkedBlockingQueue = c0470ub.f3414a;
        C0470ub.a aVar = null;
        while (c0470ub.g) {
            try {
                aVarTake = linkedBlockingQueue.take();
                try {
                } catch (IOException unused) {
                    str = str2;
                } catch (InterruptedException unused2) {
                    str = str2;
                } catch (Throwable unused3) {
                    str = str2;
                }
            } catch (IOException unused4) {
                str = str2;
            } catch (Throwable unused5) {
                str = str2;
            }
            if (C0470ub.a.f3420a == aVarTake) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0423eb c0423eb = c0470ub.f3415b;
            String str3 = aVarTake.f3423d;
            byte[] bArr = aVarTake.f3422c;
            System.currentTimeMillis();
            Bundle bundleA = c0423eb.k.a(str3, bArr);
            System.currentTimeMillis();
            byte[] bArrB = Wb.b(bundleA.getByteArray("data_bytes"));
            String str4 = bArrB != null ? new String(bArrB, bundleA.getString("data_charset")) : "{}";
            bundleA.remove("data_charset");
            bundleA.remove("data_bytes");
            bundleA.putString(str2, str4);
            String string = bundleA.getString(str2);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (string == null) {
                string = "";
            }
            c0470ub.f3416c++;
            c0470ub.f3417d += (long) aVarTake.f3422c.length;
            byte[] bArrA = Wb.a(string.getBytes("UTF-8"));
            str = str2;
            try {
                c0470ub.f3418e += (long) (bArrA != null ? bArrA.length : 0);
                Handler handler = c0470ub.i;
                aVarTake.h = jCurrentTimeMillis;
                if (!c0470ub.h && c0470ub.g && handler != null && handler.getLooper().getThread().isAlive()) {
                    Message messageObtainMessage = handler.obtainMessage();
                    messageObtainMessage.arg1 = (int) jCurrentTimeMillis2;
                    if (1 == aVarTake.f3421b) {
                        messageObtainMessage.obj = Pair.create(string, aVarTake);
                        messageObtainMessage.what = 4999;
                        messageObtainMessage.sendToTarget();
                    }
                }
                if (aVarTake.f3421b == 1 && c0470ub.f3415b.f3148d.p == 0) {
                    c0470ub.f3415b.f3148d.p = jCurrentTimeMillis2;
                    c0470ub.f3415b.f3148d.q = bundleA.getString("req_key");
                }
                str2 = str;
                aVar = aVarTake;
            } catch (IOException unused6) {
                aVar = aVarTake;
                System.currentTimeMillis();
                c0470ub.b(aVar);
                Handler handler2 = c0470ub.i;
                Looper looper = handler2 == null ? null : handler2.getLooper();
                if (looper != null && looper.getThread().isAlive()) {
                    handler2.sendEmptyMessageDelayed(4998, 0L);
                }
                str2 = str;
            } catch (Throwable unused7) {
                aVar = aVarTake;
                str2 = str;
            }
        }
    }
}
