package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import com.umeng.analytics.pro.ci;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1654Hj {
    public static byte[] A08;
    public static String[] A09;
    public IN A00;
    public boolean A01;
    public final SparseArray<String> A02;
    public final C1664Ht A03;
    public final HashMap<String, C1653Hi> A04;
    public final Cipher A05;
    public final SecretKeySpec A06;
    public final boolean A07;

    static {
        A06();
        A05();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        String[] strArr = A09;
        if (strArr[6].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[7] = "3hiG2MwLP1vY28w2jyIZHTbcKAlMPBPZ";
        strArr2[2] = "9NEv2gVVsGFA2BwX54IQqGQXEg3TAXQS";
        A08 = new byte[]{26, 30, 44, 32, 36, 50, ci.l, 34, 33, 34, ci.l, 47, 42, 34, 50, 20, 47, 32, 35, 35, 40, 45, 38, -48, -47, 26, 24, 26, 31, 28, 27, 22, 26, 38, 37, 43, 28, 37, 43, 22, 32, 37, 27, 28, 47, -27, 28, 47, 32};
    }

    public static void A06() {
        A09 = new String[]{"XONorMmEkuhCG9piVxKUh1vkXNNJ", "9nfZq9rsOYHCIqBCRPzuDpg7UYzPD2Yl", "Yz44fu3QSKzu2i5DyXETxtSOt38Z3WJk", "HOY3mHCHBdW1ht", "XI2xTZ9JkVa2GEn", "4OCnssyPGh2MUqheTrzmDcc0Epkw2MIq", "4Z9FwJdzaIh4z0baUKFOBcRAp1yx", "rZsSxCWfylE928lHlC5xkXC43RMRLxAb"};
    }

    public C1654Hj(File file, byte[] bArr, boolean z) {
        this.A07 = z;
        if (bArr != null) {
            C1662Hr.A03(bArr.length == 16);
            try {
                this.A05 = A03();
                this.A06 = new SecretKeySpec(bArr, A02(0, 3, 101));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            C1662Hr.A04(!z);
            this.A05 = null;
            this.A06 = null;
        }
        this.A04 = new HashMap<>();
        this.A02 = new SparseArray<>();
        this.A03 = new C1664Ht(new File(file, A02(25, 24, 67)));
    }

    public static int A00(SparseArray<String> sparseArray) {
        int iKeyAt;
        int id = sparseArray.size();
        if (id == 0) {
            iKeyAt = 0;
        } else {
            int i = id - 1;
            String[] strArr = A09;
            if (strArr[7].charAt(12) != strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[6] = "GpSMRVwbmVnvoZI5Ggc91zVjP9Ti";
            strArr2[0] = "f9953PfVQawIaiCUJ4cnumBLGdw9";
            iKeyAt = sparseArray.keyAt(i) + 1;
        }
        if (iKeyAt < 0) {
            iKeyAt = 0;
            while (iKeyAt < id && iKeyAt == sparseArray.keyAt(iKeyAt)) {
                iKeyAt++;
            }
        }
        return iKeyAt;
    }

    private C1653Hi A01(String str) {
        C1653Hi c1653Hi = new C1653Hi(A00(this.A02), str);
        A07(c1653Hi);
        this.A01 = true;
        return c1653Hi;
    }

    public static Cipher A03() throws NoSuchPaddingException, NoSuchAlgorithmException {
        int i = IW.A02;
        String strA02 = A02(3, 20, 107);
        if (i == 18) {
            try {
                return Cipher.getInstance(strA02, A02(23, 2, 26));
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance(strA02);
    }

    private void A04() throws HZ {
        try {
            try {
                OutputStream outputStreamA05 = this.A03.A05();
                if (this.A00 == null) {
                    this.A00 = new IN(outputStreamA05);
                } else {
                    this.A00.A00(outputStreamA05);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(this.A00);
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(this.A07 ? 1 : 0);
                if (this.A07) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.A05.init(1, this.A06, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(this.A00, this.A05));
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                        throw new IllegalStateException(e2);
                    }
                }
                dataOutputStream.writeInt(this.A04.size());
                int i = 0;
                for (C1653Hi c1653Hi : this.A04.values()) {
                    c1653Hi.A0B(dataOutputStream);
                    int hashCode = c1653Hi.A04(2);
                    i += hashCode;
                }
                dataOutputStream.writeInt(i);
                this.A03.A07(dataOutputStream);
                IW.A0Y(null);
            } catch (IOException e3) {
                throw new HZ(e3);
            }
        } catch (Throwable th) {
            IW.A0Y(null);
            throw th;
        }
    }

    private void A07(C1653Hi c1653Hi) {
        this.A04.put(c1653Hi.A03, c1653Hi);
        this.A02.put(c1653Hi.A02, c1653Hi.A03);
    }

    private boolean A08() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.A03.A04());
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int i = dataInputStream.readInt();
            if (i < 0 || i > 2) {
                IW.A0Y(dataInputStream);
                return false;
            }
            int flags = dataInputStream.readInt();
            if ((flags & 1) != 0) {
                if (this.A05 == null) {
                    IW.A0Y(dataInputStream);
                    return false;
                }
                byte[] initializationVector = new byte[16];
                dataInputStream.readFully(initializationVector);
                try {
                    this.A05.init(2, this.A06, new IvParameterSpec(initializationVector));
                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.A05));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                    throw new IllegalStateException(e2);
                }
            } else if (this.A07) {
                this.A01 = true;
            }
            int i2 = dataInputStream.readInt();
            int version = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                C1653Hi cachedContent = C1653Hi.A00(i, dataInputStream);
                A07(cachedContent);
                version += cachedContent.A04(i);
            }
            int i4 = dataInputStream.readInt();
            boolean isEOF = dataInputStream.read() == -1;
            if (i4 != version || !isEOF) {
                IW.A0Y(dataInputStream);
                return false;
            }
            IW.A0Y(dataInputStream);
            return true;
        } catch (IOException unused) {
            if (0 != 0) {
                IW.A0Y(null);
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                IW.A0Y(null);
            }
            throw th;
        }
    }

    public final int A09(String str) {
        return A0B(str).A02;
    }

    public final C1653Hi A0A(String str) {
        return this.A04.get(str);
    }

    public final C1653Hi A0B(String str) {
        C1653Hi c1653Hi = this.A04.get(str);
        return c1653Hi == null ? A01(str) : c1653Hi;
    }

    public final InterfaceC1656Hl A0C(String str) {
        C1653Hi c1653HiA0A = A0A(str);
        return c1653HiA0A != null ? c1653HiA0A.A06() : C2180au.A04;
    }

    public final String A0D(int i) {
        return this.A02.get(i);
    }

    public final Collection<C1653Hi> A0E() {
        return this.A04.values();
    }

    public final void A0F() {
        C1662Hr.A04(!this.A01);
        if (!A08()) {
            this.A03.A06();
            this.A04.clear();
            this.A02.clear();
        }
    }

    public final void A0G() {
        String[] strArr = new String[this.A04.size()];
        this.A04.keySet().toArray(strArr);
        for (String str : strArr) {
            A0I(str);
        }
    }

    public final void A0H() throws HZ {
        if (!this.A01) {
            return;
        }
        A04();
        this.A01 = false;
    }

    public final void A0I(String str) {
        C1653Hi c1653Hi = this.A04.get(str);
        if (c1653Hi != null && c1653Hi.A0D() && !c1653Hi.A0E()) {
            this.A04.remove(str);
            this.A02.remove(c1653Hi.A02);
            this.A01 = true;
        }
    }

    public final void A0J(String str, C1658Hn c1658Hn) {
        if (A0B(str).A0G(c1658Hn)) {
            this.A01 = true;
        }
    }
}
