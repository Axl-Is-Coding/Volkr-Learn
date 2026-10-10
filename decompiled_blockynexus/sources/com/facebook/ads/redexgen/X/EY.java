package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import com.umeng.analytics.pro.ci;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EY {
    public static byte[] A0F;
    public static String[] A0G;
    public int A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public final int A04;
    public final int A05;
    public final Handler A06;
    public final Handler A07;
    public final HandlerThread A08;
    public final EE A09;
    public final C1576Ed A0A;
    public final ArrayList<EV> A0B;
    public final ArrayList<EV> A0C;
    public final CopyOnWriteArraySet<ER> A0D;
    public final DownloadAction.Deserializer[] A0E;

    static {
        A0D();
        A0C();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0G[7].charAt(18) == 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[5] = "QeXCOK5E1pPej2TxlzyNK8QEELc16ejC";
            strArr[5] = "QeXCOK5E1pPej2TxlzyNK8QEELc16ejC";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 103);
            i4++;
        }
    }

    public static void A0C() {
        A0F = new byte[]{40, 107, 100, 105, 123, 96, 109, 123, 40, 127, 97, 124, 96, 40, ci.k, 23, 101, 80, 4, 72, 65, 69, 87, 80, 4, 75, 74, 65, 4, 96, 65, 87, 65, 86, 77, 69, 72, 77, 94, 65, 86, 4, 77, 87, 4, 86, 65, 85, 81, 77, 86, 65, 64, 10, 82, 121, 97, 120, 122, 121, 119, 114, 91, 119, 120, 119, 113, 115, 100, 54, 112, 127, 122, 115, 54, 127, 57, 121, 37, ci.n, 2, 26, 81, 24, 2, 81, ci.n, 21, 21, 20, 21, 21, 32, 50, 42, 97, 50, 53, 32, 53, 36, 97, 40, 50, 97, 34, 41, 32, 47, 38, 36, 37};
    }

    public static void A0D() {
        A0G = new String[]{"8avf0Jibg", "29lNoiTUBE2uYEjX9VQOmTXDz5OY", "iVCyimFGxTrkRtFibV9levDJM5ZeLgZu", "gsRFpTOWHqJbEx7", "Kz1bOIham", "JnXM2eLoSoNer4vADvBB94foIijHhZU8", "txozpLaaBXvdIU5pC59NuAEDTSpBHfjF", "fwU5WNlYuxW7JC9kmXc8msxXEM9ymJ0s"};
    }

    public EY(C1576Ed c1576Ed, int i, int i2, File file, DownloadAction.Deserializer... deserializerArr) {
        C1662Hr.A05(deserializerArr.length > 0, A05(16, 38, 67));
        this.A0A = c1576Ed;
        this.A04 = i;
        this.A05 = i2;
        this.A09 = new EE(file);
        this.A0E = deserializerArr;
        this.A01 = true;
        this.A0C = new ArrayList<>();
        this.A0B = new ArrayList<>();
        Looper looperMyLooper = Looper.myLooper();
        this.A07 = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        this.A08 = new HandlerThread(A05(54, 24, 113));
        this.A08.start();
        this.A06 = new Handler(this.A08.getLooper());
        this.A0D = new CopyOnWriteArraySet<>();
        A08();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EV A02(DownloadAction downloadAction) {
        int i = this.A00;
        this.A00 = i + 1;
        EV ev = new EV(i, this, downloadAction, this.A05, null);
        this.A0C.add(ev);
        A0K(A05(78, 13, 22), ev);
        return ev;
    }

    private void A08() {
        this.A06.post(new EP(this));
    }

    private void A09() {
        if (!A0S()) {
            return;
        }
        for (ER listener : this.A0D) {
            listener.A9y(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        DownloadAction downloadAction;
        boolean z;
        if (!this.A02 || this.A03) {
            return;
        }
        int i = (this.A01 || this.A0B.size() == this.A04) ? 1 : 0;
        for (int j = 0; j < this.A0C.size(); j++) {
            EV ev = this.A0C.get(j);
            if (ev.A0F() && ((z = (downloadAction = ev.A04).A03) || i == 0)) {
                boolean z2 = true;
                int i2 = 0;
                while (true) {
                    if (i2 >= j) {
                        break;
                    }
                    EV ev2 = this.A0C.get(i2);
                    DownloadAction action = ev2.A04;
                    if (action.A0A(downloadAction)) {
                        if (!z) {
                            if (ev2.A04.A03) {
                                z2 = false;
                                i = 1;
                                break;
                            }
                        } else {
                            z2 = false;
                            String str = ev + A05(0, 14, 111) + ev2;
                            ev2.A08();
                        }
                    }
                    i2++;
                }
                if (z2) {
                    ev.A0A();
                    if (!z) {
                        this.A0B.add(ev);
                        i = this.A0B.size() == this.A04 ? 1 : 0;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0014 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0B() {
        /*
            r3 = this;
            boolean r0 = r3.A03
            if (r0 == 0) goto L5
            return
        L5:
            java.util.ArrayList<com.facebook.ads.redexgen.X.EV> r0 = r3.A0C
            int r0 = r0.size()
            com.facebook.ads.internal.exoplayer2.offline.DownloadAction[] r2 = new com.facebook.ads.internal.exoplayer2.offline.DownloadAction[r0]
            r1 = 0
        Le:
            java.util.ArrayList<com.facebook.ads.redexgen.X.EV> r0 = r3.A0C
            int r0 = r0.size()
            if (r1 >= r0) goto L27
            java.util.ArrayList<com.facebook.ads.redexgen.X.EV> r0 = r3.A0C
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.EV r0 = (com.facebook.ads.redexgen.X.EV) r0
            com.facebook.ads.internal.exoplayer2.offline.DownloadAction r0 = com.facebook.ads.redexgen.X.EV.A06(r0)
            r2[r1] = r0
            int r1 = r1 + 1
            goto Le
        L27:
            android.os.Handler r1 = r3.A06
            com.facebook.ads.redexgen.X.EQ r0 = new com.facebook.ads.redexgen.X.EQ
            r0.<init>(r3, r2)
            r1.post(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EY.A0B():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(EV ev) {
        A0K(A05(91, 21, 38), ev);
        EX exA0L = ev.A0L();
        Iterator<ER> it = this.A0D.iterator();
        while (it.hasNext()) {
            it.next().ABO(this, exA0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(EV ev) {
        if (this.A03) {
            return;
        }
        boolean zA0M = ev.A0M();
        String[] strArr = A0G;
        if (strArr[2].charAt(18) != strArr[6].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[5] = "MuXE9yewg4GnYpwcSobAkjsL3VeJsTJN";
        strArr2[5] = "MuXE9yewg4GnYpwcSobAkjsL3VeJsTJN";
        boolean z = !zA0M;
        if (z) {
            this.A0B.remove(ev);
        }
        A0E(ev);
        if (ev.A0N()) {
            this.A0C.remove(ev);
            A0B();
        }
        if (z) {
            A0A();
            A09();
        }
    }

    public static void A0K(String str, EV ev) {
        String str2 = str + A05(14, 2, 80) + ev;
    }

    public final int A0P(DownloadAction downloadAction) {
        C1662Hr.A04(!this.A03);
        EV evA02 = A02(downloadAction);
        if (this.A02) {
            A0B();
            A0A();
            if (evA02.A06 == 0) {
                A0E(evA02);
            }
        }
        return evA02.A02;
    }

    public final void A0Q() {
        C1662Hr.A04(!this.A03);
        if (this.A01) {
            this.A01 = false;
            A0A();
        }
    }

    public final void A0R(ER er) {
        this.A0D.add(er);
    }

    public final boolean A0S() {
        C1662Hr.A04(!this.A03);
        if (!this.A02) {
            return false;
        }
        for (int i = 0; i < this.A0C.size(); i++) {
            if (this.A0C.get(i).A0M()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0011 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.EX[] A0T() {
        /*
            r3 = this;
            boolean r0 = r3.A03
            r0 = r0 ^ 1
            com.facebook.ads.redexgen.X.C1662Hr.A04(r0)
            java.util.ArrayList<com.facebook.ads.redexgen.X.EV> r0 = r3.A0C
            int r0 = r0.size()
            com.facebook.ads.redexgen.X.EX[] r2 = new com.facebook.ads.redexgen.X.EX[r0]
            r1 = 0
        L10:
            int r0 = r2.length
            if (r1 >= r0) goto L24
            java.util.ArrayList<com.facebook.ads.redexgen.X.EV> r0 = r3.A0C
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.EV r0 = (com.facebook.ads.redexgen.X.EV) r0
            com.facebook.ads.redexgen.X.EX r0 = r0.A0L()
            r2[r1] = r0
            int r1 = r1 + 1
            goto L10
        L24:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EY.A0T():com.facebook.ads.redexgen.X.EX[]");
    }
}
