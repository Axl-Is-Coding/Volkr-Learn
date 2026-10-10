package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.umeng.analytics.pro.ci;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.TreeSet;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.av, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2181av implements InterfaceC1646Hb {
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08;
    public static final HashSet<File> A09;
    public long A00;
    public boolean A01;
    public final InterfaceC2178as A02;
    public final C1654Hj A03;
    public final File A04;
    public final HashMap<String, ArrayList<InterfaceC1645Ha>> A05;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{106, 69, 68, 95, 67, 78, 89, 11, 120, 66, 70, 91, 71, 78, 104, 74, 72, 67, 78, 11, 66, 69, 88, 95, 74, 69, 72, 78, 11, 94, 88, 78, 88, 11, 95, 67, 78, 11, 77, 68, 71, 79, 78, 89, 17, 11, 82, 104, 108, 113, 109, 100, 66, 96, 98, 105, 100, 94, 100, 96, 125, 97, 104, 78, 108, 110, 101, 104, 35, 100, 99, 100, 121, 100, 108, 97, 100, 119, 104, 37, 36, 0, 39, 60, 33, 58, 61, 52, 115, 58, 61, 55, 54, 43, 115, 53, 58, Utf8.REPLACEMENT_BYTE, 54, 115, 53, 50, 58, Utf8.REPLACEMENT_BYTE, 54, 55, 28, 30, 28, 23, 26, 27, 32, 28, ci.n, 17, 11, 26, 17, 11, 32, 22, 17, 27, 26, 7, 81, 26, 7, 22};
    }

    public static void A07() {
        A08 = new String[]{"eH4syubUz2tR66H4aXOA", "1d5DSBS1mhWRL66KnLBZBpyHNgki7Rvu", "v9uLJ4dIwyz0Tb4FaO07wTfk2F9lBV8v", "E1Se3PKWItYNl2w7Z0lUvGDZb88eKAvD", "3tvSVqejLSP4DWhBG1hRQ7meIfhtlUpf", "obkGL38LbEEikSiwJ4pDHOfB9GOmWii2", "dwvV", "8LO"};
    }

    static {
        A07();
        A06();
        A09 = new HashSet<>();
    }

    public C2181av(File file, InterfaceC2178as interfaceC2178as) {
        this(file, interfaceC2178as, null, false);
    }

    public C2181av(File file, InterfaceC2178as interfaceC2178as, C1654Hj c1654Hj) {
        if (A0E(file)) {
            this.A04 = file;
            this.A02 = interfaceC2178as;
            this.A03 = c1654Hj;
            this.A05 = new HashMap<>();
            ConditionVariable conditionVariable = new ConditionVariable();
            new C1659Ho(this, A03(57, 24, 74), conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException(A03(0, 46, 108) + file);
    }

    public C2181av(File file, InterfaceC2178as interfaceC2178as, byte[] bArr, boolean z) {
        this(file, interfaceC2178as, new C1654Hj(file, bArr, z));
    }

    private C2182aw A00(String str, long j) throws HZ {
        C2182aw c2182awA07;
        C1653Hi c1653HiA0A = this.A03.A0A(str);
        if (c1653HiA0A == null) {
            return C2182aw.A02(str, j);
        }
        while (true) {
            c2182awA07 = c1653HiA0A.A07(j);
            if (!c2182awA07.A05 || c2182awA07.A03.exists()) {
                break;
            }
            A05();
        }
        return c2182awA07;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final synchronized C2182aw ADe(String str, long j) throws HZ, InterruptedException {
        C2182aw c2182awADf;
        while (true) {
            c2182awADf = ADf(str, j);
            if (c2182awADf == null) {
                wait();
            }
        }
        return c2182awADf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final synchronized C2182aw ADf(String str, long j) throws HZ {
        boolean z = this.A01;
        if (A08[0].length() != 10) {
            String[] strArr = A08;
            strArr[3] = "i1JHZi6uUAd1FxW2ulRZEzuIvuRnbT2M";
            strArr[3] = "i1JHZi6uUAd1FxW2ulRZEzuIvuRnbT2M";
            C1662Hr.A04(!z);
            C2182aw c2182awA00 = A00(str, j);
            if (c2182awA00.A05) {
                C2182aw c2182awA08 = this.A03.A0A(str).A08(c2182awA00);
                A0D(c2182awA00, c2182awA08);
                return c2182awA08;
            }
            C1653Hi c1653HiA0B = this.A03.A0B(str);
            if (!c1653HiA0B.A0E()) {
                c1653HiA0B.A0C(true);
                return c2182awA00;
            }
            return null;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            return;
        }
        this.A03.A0F();
        File[] fileArrListFiles = this.A04.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (!file.getName().equals(A03(106, 24, 56))) {
                C2182aw span = file.length() > 0 ? C2182aw.A00(file, this.A03) : null;
                if (span != null) {
                    A0B(span);
                } else {
                    file.delete();
                }
            }
        }
        this.A03.A0G();
        try {
            this.A03.A0H();
        } catch (HZ e2) {
            Log.e(A03(46, 11, 70), A03(81, 25, 20), e2);
        }
    }

    private void A05() throws HZ {
        ArrayList arrayList = new ArrayList();
        for (C1653Hi cachedContent : this.A03.A0E()) {
            for (C2182aw c2182aw : cachedContent.A09()) {
                if (!c2182aw.A03.exists()) {
                    arrayList.add(c2182aw);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            A09((C1650Hf) arrayList.get(i), false);
        }
        this.A03.A0G();
        this.A03.A0H();
    }

    private void A08(C1650Hf c1650Hf) {
        ArrayList<InterfaceC1645Ha> arrayList = this.A05.get(c1650Hf.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).ABI(this, c1650Hf);
            }
        }
        this.A02.ABI(this, c1650Hf);
    }

    private void A09(C1650Hf c1650Hf, boolean z) throws HZ {
        C1653Hi c1653HiA0A = this.A03.A0A(c1650Hf.A04);
        if (c1653HiA0A == null || !c1653HiA0A.A0F(c1650Hf)) {
            return;
        }
        this.A00 -= c1650Hf.A01;
        if (z) {
            try {
                this.A03.A0I(c1653HiA0A.A03);
                this.A03.A0H();
            } finally {
                A08(c1650Hf);
            }
        }
    }

    private void A0B(C2182aw c2182aw) {
        this.A03.A0B(c2182aw.A04).A0A(c2182aw);
        this.A00 += c2182aw.A01;
        A0C(c2182aw);
    }

    private void A0C(C2182aw c2182aw) {
        ArrayList<InterfaceC1645Ha> arrayList = this.A05.get(c2182aw.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).ABH(this, c2182aw);
            }
        }
        this.A02.ABH(this, c2182aw);
    }

    private void A0D(C2182aw c2182aw, C1650Hf c1650Hf) {
        ArrayList<InterfaceC1645Ha> arrayList = this.A05.get(c2182aw.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).ABJ(this, c2182aw, c1650Hf);
            }
        }
        this.A02.ABJ(this, c2182aw, c1650Hf);
    }

    public static synchronized boolean A0E(File file) {
        if (A06) {
            return true;
        }
        boolean zAdd = A09.add(file.getAbsoluteFile());
        if (A08[3].charAt(1) != '1') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[4] = "IKpjWyjLYfQpiBWntIG6MWMycmL9Fi0T";
        strArr[1] = "4yvCWPfRVkN5zdYzJ7yblhOZllwt9yTn";
        return zAdd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized void A3Q(String str, C1658Hn c1658Hn) throws HZ {
        C1662Hr.A04(!this.A01);
        this.A03.A0J(str, c1658Hn);
        this.A03.A0H();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized void A44(File file) throws HZ {
        C1662Hr.A04(!this.A01);
        C2182aw c2182awA00 = C2182aw.A00(file, this.A03);
        C1662Hr.A04(c2182awA00 != null);
        C1653Hi c1653HiA0A = this.A03.A0A(c2182awA00.A04);
        C1662Hr.A01(c1653HiA0A);
        C1662Hr.A04(c1653HiA0A.A0E());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long jA00 = C1657Hm.A00(c1653HiA0A.A06());
            if (jA00 != -1) {
                long j = c2182awA00.A02;
                long length = c2182awA00.A01;
                C1662Hr.A04(j + length <= jA00);
            }
            A0B(c2182awA00);
            this.A03.A0H();
            notifyAll();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized long A5g() {
        C1662Hr.A04(!this.A01);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized long A5h(String str, long j, long j2) {
        C1653Hi c1653HiA0A;
        C1662Hr.A04(!this.A01);
        c1653HiA0A = this.A03.A0A(str);
        return c1653HiA0A != null ? c1653HiA0A.A05(j, j2) : -j2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    @NonNull
    public final synchronized NavigableSet<C1650Hf> A5i(String str) {
        TreeSet treeSet;
        C1662Hr.A04(!this.A01);
        C1653Hi c1653HiA0A = this.A03.A0A(str);
        if (c1653HiA0A == null || c1653HiA0A.A0D()) {
            treeSet = new TreeSet();
        } else {
            treeSet = new TreeSet((Collection) c1653HiA0A.A09());
        }
        return treeSet;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized long A5t(String str) {
        return C1657Hm.A00(A5u(str));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized InterfaceC1656Hl A5u(String str) {
        C1662Hr.A04(!this.A01);
        return this.A03.A0C(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized void ACa(C1650Hf c1650Hf) {
        C1662Hr.A04(!this.A01);
        C1653Hi c1653HiA0A = this.A03.A0A(c1650Hf.A04);
        C1662Hr.A01(c1653HiA0A);
        C1662Hr.A04(c1653HiA0A.A0E());
        c1653HiA0A.A0C(false);
        this.A03.A0I(c1653HiA0A.A03);
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized void ACh(C1650Hf c1650Hf) throws HZ {
        C1662Hr.A04(!this.A01);
        A09(c1650Hf, true);
        if (A08[0].length() == 10) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[2] = "mDPrx6EC7JunlTiRZIITWuDkOY6RMx2Q";
        strArr[2] = "mDPrx6EC7JunlTiRZIITWuDkOY6RMx2Q";
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized void ADD(String str, long j) throws HZ {
        C1658Hn c1658Hn = new C1658Hn();
        C1657Hm.A05(c1658Hn, j);
        A3Q(str, c1658Hn);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1646Hb
    public final synchronized File ADc(String str, long j, long j2) throws HZ {
        C1653Hi c1653HiA0A;
        C1662Hr.A04(!this.A01);
        c1653HiA0A = this.A03.A0A(str);
        C1662Hr.A01(c1653HiA0A);
        C1662Hr.A04(c1653HiA0A.A0E());
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            A05();
        }
        this.A02.ABK(this, str, j, j2);
        return C2182aw.A04(this.A04, c1653HiA0A.A02, j, System.currentTimeMillis());
    }
}
