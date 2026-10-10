package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.au, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2180au implements InterfaceC1656Hl {
    public static byte[] A02;
    public static String[] A03;
    public static final C2180au A04;
    public int A00;
    public final Map<String, byte[]> A01;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[7].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[3] = "rKK8X5tVBBDKhSudhE31wx";
            strArr2[3] = "rKK8X5tVBBDKhSudhE31wx";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 62);
            if (A03[2].length() != 16) {
                String[] strArr3 = A03;
                strArr3[7] = "FSEtti";
                strArr3[0] = "";
                i4 += 0;
            } else {
                String[] strArr4 = A03;
                strArr4[5] = "3tkzovd4FYEmOrd3uFeQsH7k2lQqNCGR";
                strArr4[4] = "QPp8yxf18vRmRgJoVMCalcriT9AA2Yst";
                i4++;
            }
        }
    }

    public static void A03() {
        byte[] bArr = {-121, -84, -76, -97, -86, -89, -94, 94, -76, -97, -86, -77, -93, 94, -79, -89, -72, -93, 120, 94, 11, 31, 28, -41, 42, 32, 49, 28, -41, 38, 29, -41, -36, 42, -41, -33, -36, 27, -32, -41, 32, 42, -41, 30, 41, 28, 24, 43, 28, 41, -41, 43, 31, 24, 37, -41, 36, 24, 47, 32, 36, 44, 36, -41, 24, 35, 35, 38, 46, 28, 27, -15, -41, -36, 27, -31, -32, -46, -71, -60};
        if (A03[3].length() != 22) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "Wq4xFI36yK0vrvDqIYZkxKx0C2M1IMKh";
        strArr[1] = "Wq4xFI36yK0vrvDqIYZkxKx0C2M1IMKh";
        A02 = bArr;
    }

    public static void A04() {
        A03 = new String[]{"", "E0qfI7DZu8nkzGv3MH4nJgqlD44FCDGV", "PylumRpOhcOqV8SE", "Pn3Or3lb8D1PR4hBSIJHER", "QrYBpEt5fxgmrBLneQSlInRulpYQYEG6", "kBYBv8gRMrLmplmIT6dDUsqqwhnWF3zw", "1HLCV5Ojolr5GVwArEzJLOO78iGdJHxw", "UyANx1"};
    }

    static {
        A04();
        A03();
        A04 = new C2180au(Collections.emptyMap());
    }

    public C2180au(Map<String, byte[]> map) {
        Map<String, byte[]> metadata = Collections.unmodifiableMap(map);
        this.A01 = metadata;
    }

    public static C2180au A00(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (A03[6].charAt(12) != 'G') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "zQpUPHnv7TxzcbRfe6tZ6j";
            strArr[3] = "zQpUPHnv7TxzcbRfe6tZ6j";
            if (i3 >= 0 && i3 <= 10485760) {
                byte[] bArr = new byte[i3];
                dataInputStream.readFully(bArr);
                map.put(utf, bArr);
            } else {
                throw new IOException(A01(0, 20, 0) + i3);
            }
        }
        return new C2180au(map);
    }

    public static Map<String, byte[]> A02(Map<String, byte[]> map, C1658Hn c1658Hn) {
        HashMap map2 = new HashMap(map);
        A05(map2, c1658Hn.A05());
        A06(map2, c1658Hn.A06());
        return map2;
    }

    public static void A05(HashMap<String, byte[]> map, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
        }
    }

    public static void A06(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (String str : map2.keySet()) {
            Object value = map2.get(str);
            byte[] bArrA08 = A08(value);
            if (bArrA08.length <= 10485760) {
                map.put(str, bArrA08);
            } else {
                Object value2 = Integer.valueOf(bArrA08.length);
                throw new IllegalArgumentException(String.format(A01(20, 55, 121), str, value2, 10485760));
            }
        }
    }

    private boolean A07(Map<String, byte[]> map) {
        Map<String, byte[]> otherMetadata = this.A01;
        if (otherMetadata.size() != map.size()) {
            return false;
        }
        Map<String, byte[]> otherMetadata2 = this.A01;
        for (Map.Entry<String, byte[]> entry : otherMetadata2.entrySet()) {
            byte[] value = entry.getValue();
            byte[] otherValue = map.get(entry.getKey());
            if (!Arrays.equals(value, otherValue)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] A08(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName(A01(75, 5, 78)));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public final C2180au A09(C1658Hn c1658Hn) {
        Map<String, byte[]> mapA02 = A02(this.A01, c1658Hn);
        if (A07(mapA02)) {
            return this;
        }
        return new C2180au(mapA02);
    }

    public final void A0A(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A01.size());
        for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1656Hl
    public final long A5K(String str, long j) {
        if (this.A01.containsKey(str)) {
            return ByteBuffer.wrap(this.A01.get(str)).getLong();
        }
        return j;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1656Hl
    public final String A5L(String str, String str2) {
        if (this.A01.containsKey(str)) {
            return new String(this.A01.get(str), Charset.forName(A01(75, 5, 78)));
        }
        return str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return A07(((C2180au) obj).A01);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int iHashCode = 0;
            Iterator<Map.Entry<String, byte[]>> it = this.A01.entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                String[] strArr = A03;
                if (strArr[7].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[3] = "oFmiTb5ocNjXgy8itQp3Jt";
                strArr2[3] = "oFmiTb5ocNjXgy8itQp3Jt";
                if (zHasNext) {
                    Map.Entry<String, byte[]> next = it.next();
                    iHashCode += next.getKey().hashCode() ^ Arrays.hashCode(next.getValue());
                } else {
                    this.A00 = iHashCode;
                    break;
                }
            }
        }
        return this.A00;
    }
}
