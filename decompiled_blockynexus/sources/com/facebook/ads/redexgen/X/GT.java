package com.facebook.ads.redexgen.X;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GT {
    public static byte[] A0B;
    public static String[] A0C;
    public List<GT> A00;
    public final long A01;
    public final long A02;
    public final GZ A03;
    public final String A04;
    public final String A05;
    public final String A06;
    public final boolean A07;
    public final HashMap<String, Integer> A08;
    public final HashMap<String, Integer> A09;
    public final String[] A0A;

    static {
        A08();
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        byte[] bArr = {54, 38, 101, 109, 124, 105, 108, 105, 124, 105, 46};
        if (A0C[4].charAt(11) == 'K') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[1] = "AmdkI9Q8sE";
        strArr[1] = "AmdkI9Q8sE";
        A0B = bArr;
    }

    public static void A08() {
        A0C = new String[]{"tlVw39Ohl0PVI8fV0YPCcQegL80HNmMX", "3PVmbccCk3TYNa4naZfa0", "qupmPShVTMJhVfYkOYpITScBpcljJSOb", "vJlbAlf6aMAaV2lo2oeuySGVP617mKUN", "wib00gU5k9UeC7KFMR3e95wgyYt7DknS", "DUfNRVSmHsUyVjEYzj4oHSrvl1jpEWvG", "VaOanHTtNfMSjEnVOScoKyOAyIQNDQyO", "uu1yNZ48dLzKD2dAjoiHYwXYoxLcRzCz"};
    }

    public GT(String str, String str2, long j, long j2, GZ gz, String[] strArr, String str3) {
        this.A05 = str;
        this.A06 = str2;
        this.A03 = gz;
        this.A0A = strArr;
        this.A07 = str2 != null;
        this.A02 = j;
        this.A01 = j2;
        this.A04 = (String) C1662Hr.A01(str3);
        this.A09 = new HashMap<>();
        this.A08 = new HashMap<>();
    }

    private final int A00() {
        List<GT> list = this.A00;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private SpannableStringBuilder A01(SpannableStringBuilder spannableStringBuilder) {
        int spacesToDelete = spannableStringBuilder.length();
        for (int j = 0; j < spacesToDelete; j++) {
            if (spannableStringBuilder.charAt(j) == ' ') {
                int i = j + 1;
                while (i < spannableStringBuilder.length() && spannableStringBuilder.charAt(i) == ' ') {
                    i++;
                }
                int i2 = i - (j + 1);
                if (i2 > 0) {
                    spannableStringBuilder.delete(j, j + i2);
                    spacesToDelete -= i2;
                }
            }
        }
        if (spacesToDelete > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            spacesToDelete--;
        }
        for (int i3 = 0; i3 < spacesToDelete - 1; i3++) {
            if (spannableStringBuilder.charAt(i3) == '\n' && spannableStringBuilder.charAt(i3 + 1) == ' ') {
                spannableStringBuilder.delete(i3 + 1, i3 + 2);
                spacesToDelete--;
            }
        }
        if (spacesToDelete > 0 && spannableStringBuilder.charAt(spacesToDelete - 1) == ' ') {
            spannableStringBuilder.delete(spacesToDelete - 1, spacesToDelete);
            if (A0C[4].charAt(11) == 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[7] = "6UN1wY1Jt9AyUvakQ5bJnJbUcnBDq6Nx";
            strArr[7] = "6UN1wY1Jt9AyUvakQ5bJnJbUcnBDq6Nx";
            spacesToDelete--;
        }
        for (int i4 = 0; i4 < spacesToDelete - 1; i4++) {
            if (spannableStringBuilder.charAt(i4) == ' ' && spannableStringBuilder.charAt(i4 + 1) == '\n') {
                spannableStringBuilder.delete(i4, i4 + 1);
                spacesToDelete--;
            }
        }
        if (spacesToDelete > 0 && spannableStringBuilder.charAt(spacesToDelete - 1) == '\n') {
            spannableStringBuilder.delete(spacesToDelete - 1, spacesToDelete);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder A02(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        SpannableStringBuilder spannableStringBuilder = map.get(str);
        String[] strArr = A0C;
        if (strArr[3].charAt(21) != strArr[2].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[7] = "hg6ickUmYbVaq8iUWn6QMVEg4prIKgzg";
        strArr2[7] = "hg6ickUmYbVaq8iUWn6QMVEg4prIKgzg";
        return spannableStringBuilder;
    }

    private final GT A03(int i) {
        List<GT> list = this.A00;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public static GT A04(String str) {
        return new GT(null, GV.A02(str), -9223372036854775807L, -9223372036854775807L, null, null, A06(0, 0, 104));
    }

    public static GT A05(String str, long j, long j2, GZ gz, String[] strArr, String str2) {
        return new GT(str, null, j, j2, gz, strArr, str2);
    }

    private void A09(long j, Map<String, GZ> map, Map<String, SpannableStringBuilder> map2) {
        if (!A0D(j)) {
            return;
        }
        for (Map.Entry<String, Integer> entry : this.A08.entrySet()) {
            String key = entry.getKey();
            int iIntValue = this.A09.containsKey(key) ? this.A09.get(key).intValue() : 0;
            int iIntValue2 = entry.getValue().intValue();
            if (iIntValue != iIntValue2) {
                SpannableStringBuilder regionOutput = map2.get(key);
                A0B(map, regionOutput, iIntValue, iIntValue2);
            }
        }
        for (int i = 0; i < A00(); i++) {
            A03(i).A09(j, map, map2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:39:0x00fb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0A(long r10, boolean r12, java.lang.String r13, java.util.Map<java.lang.String, android.text.SpannableStringBuilder> r14) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GT.A0A(long, boolean, java.lang.String, java.util.Map):void");
    }

    private void A0B(Map<String, GZ> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        GZ gzA00 = GV.A00(this.A03, this.A0A, map);
        if (gzA00 != null) {
            GV.A06(spannableStringBuilder, i, i2, gzA00);
        }
    }

    private void A0C(TreeSet<Long> treeSet, boolean z) {
        boolean zEquals = A06(10, 1, 102).equals(this.A05);
        if (z || zEquals) {
            long j = this.A02;
            if (A0C[1].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[1] = "LOAziX4ZrknWSY3Fjl";
            strArr[1] = "LOAziX4ZrknWSY3Fjl";
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.A01;
            if (j2 != -9223372036854775807L) {
                Long lValueOf = Long.valueOf(j2);
                if (A0C[0].charAt(29) != 'm') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0C;
                strArr2[1] = "dzTKJn1Q9f1wWrnlDp9SVW8wMEk";
                strArr2[1] = "dzTKJn1Q9f1wWrnlDp9SVW8wMEk";
                treeSet.add(lValueOf);
            }
        }
        if (this.A00 == null) {
            return;
        }
        for (int i = 0; i < this.A00.size(); i++) {
            this.A00.get(i).A0C(treeSet, z || zEquals);
        }
    }

    private final boolean A0D(long j) {
        return (this.A02 == -9223372036854775807L && this.A01 == -9223372036854775807L) || (this.A02 <= j && this.A01 == -9223372036854775807L) || ((this.A02 == -9223372036854775807L && j < this.A01) || (this.A02 <= j && j < this.A01));
    }

    public final List<G5> A0E(long j, Map<String, GZ> map, Map<String, GU> map2) {
        TreeMap<String, SpannableStringBuilder> regionOutputs = new TreeMap<>();
        A0A(j, false, this.A04, regionOutputs);
        A09(j, map, regionOutputs);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, SpannableStringBuilder> entry : regionOutputs.entrySet()) {
            GU gu = map2.get(entry.getKey());
            arrayList.add(new G5(A01(entry.getValue()), (Layout.Alignment) null, gu.A00, gu.A05, gu.A04, gu.A01, Integer.MIN_VALUE, gu.A03, gu.A06, gu.A02));
        }
        return arrayList;
    }

    public final void A0F(GT gt) {
        if (this.A00 == null) {
            this.A00 = new ArrayList();
        }
        this.A00.add(gt);
    }

    public final long[] A0G() {
        TreeSet<Long> treeSet = new TreeSet<>();
        A0C(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        int i = 0;
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            jArr[i] = it.next().longValue();
            i = i2;
        }
        return jArr;
    }
}
