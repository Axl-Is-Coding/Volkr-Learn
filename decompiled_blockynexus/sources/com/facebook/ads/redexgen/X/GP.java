package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import android.util.SparseArray;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GP {
    public static byte[] A07;
    public static String[] A08;
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02 = new Paint();
    public final Paint A03;
    public final GH A04;
    public final GI A05;
    public final GO A06;

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] - i3) - 74);
            String[] strArr = A08;
            if (strArr[4].charAt(19) != strArr[0].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[1] = "o838eL9fL";
            strArr2[5] = "J6qCpr7RcsAqb79Ub3PrHCSZxMucifP";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{-109, -80, -61, -80, 111, -75, -72, -76, -69, -77, 111, -69, -76, -67, -74, -61, -73, 111, -76, -57, -78, -76, -76, -77, -62, 111, -69, -72, -68, -72, -61, -16, 34, ci.l, -4, ci.k, 30, 31, 17, 30};
    }

    public static void A0B() {
        A08 = new String[]{"0rGqU9QbqgRhw9xCYiy2ikjdJF0tZxW0", "O5zJjRmwn", "Zuwvbdj2tlT5lxRkpa9deVxz18dZQdtj", "3cu9YvSu9oYTgNu7SXt0BZa9RO8c3dJe", "fSpgVoQESo9i788g3Yt2BRpnP7rxN0lE", "PNJ5rPmEA0nUP9bGeJM8wQu7KuAYrDy", "AGqKR696jXLUBqkrCQSQW886irj6NtRI", "IRr9cxFu4Mtz1eOchhtcqFpk7Zjv6sDY"};
    }

    static {
        A0B();
        A0A();
        A09 = new byte[]{0, 7, 8, ci.m};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public GP(int i, int i2) {
        this.A02.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A02.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.A02.setPathEffect(null);
        this.A03 = new Paint();
        this.A03.setStyle(Paint.Style.FILL);
        this.A03.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.A03.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new GI(719, 575, 0, 719, 0, 575);
        this.A04 = new GH(0, A0G(), A0H(), A0I());
        this.A06 = new GO(i, i2);
    }

    public static int A00(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int A01(IF r15, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3 = i;
        int column = 0;
        do {
            int runLength = 0;
            int iA05 = r15.A05(2);
            if (iA05 != 0) {
                runLength = 1;
            } else {
                boolean zA0G = r15.A0G();
                String[] strArr = A08;
                if (strArr[6].charAt(3) == strArr[3].charAt(3)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[1] = "NWJ2j8DR8";
                strArr2[5] = "tuFwEgjWv5QsbV2rgY7O01mW2P3xd0b";
                if (zA0G) {
                    runLength = r15.A05(3) + 3;
                    iA05 = r15.A05(2);
                } else if (r15.A0G()) {
                    runLength = 1;
                    iA05 = 0;
                } else {
                    int iA052 = r15.A05(2);
                    if (iA052 == 0) {
                        column = 1;
                        iA05 = 0;
                    } else if (iA052 != 1) {
                        if (iA052 == 2) {
                            runLength = r15.A05(4) + 12;
                            iA05 = r15.A05(2);
                        } else if (iA052 != 3) {
                            iA05 = 0;
                        } else {
                            int iA053 = r15.A05(8);
                            String[] strArr3 = A08;
                            if (strArr3[1].length() == strArr3[5].length()) {
                                String[] strArr4 = A08;
                                strArr4[1] = "EWrEb5ztJ";
                                strArr4[5] = "osfW1bR5YMm4TxT0YESgxQn9EHcmZGy";
                                runLength = iA053 + 12;
                                iA05 = r15.A05(2);
                            } else {
                                String[] strArr5 = A08;
                                strArr5[7] = "aK1SAaExMssx18Id1roywrSfe1Et1yGa";
                                strArr5[7] = "aK1SAaExMssx18Id1roywrSfe1Et1yGa";
                                runLength = iA053 + 29;
                                iA05 = r15.A05(2);
                            }
                        }
                    } else {
                        runLength = 2;
                        iA05 = 0;
                    }
                }
            }
            if (runLength != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                canvas.drawRect(i3, i2, i3 + runLength, i2 + 1, paint);
            }
            i3 += runLength;
        } while (column == 0);
        return i3;
    }

    public static int A02(IF r15, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int runLength = i;
        int column = 0;
        do {
            int clutIndex = 0;
            int iA05 = r15.A05(4);
            if (iA05 != 0) {
                clutIndex = 1;
            } else if (!r15.A0G()) {
                int iA052 = r15.A05(3);
                if (iA052 != 0) {
                    clutIndex = iA052 + 2;
                    iA05 = 0;
                } else {
                    column = 1;
                    iA05 = 0;
                }
            } else if (!r15.A0G()) {
                clutIndex = r15.A05(2) + 4;
                iA05 = r15.A05(4);
            } else {
                int iA053 = r15.A05(2);
                if (iA053 == 0) {
                    clutIndex = 1;
                    iA05 = 0;
                } else if (iA053 == 1) {
                    clutIndex = 2;
                    iA05 = 0;
                } else if (iA053 == 2) {
                    clutIndex = r15.A05(4) + 9;
                    iA05 = r15.A05(4);
                } else if (iA053 != 3) {
                    iA05 = 0;
                } else {
                    clutIndex = r15.A05(8) + 25;
                    iA05 = r15.A05(4);
                }
            }
            if (clutIndex != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                canvas.drawRect(runLength, i2, runLength + clutIndex, i2 + 1, paint);
            }
            runLength += clutIndex;
        } while (column == 0);
        return runLength;
    }

    public static int A03(IF r15, int[] iArr, byte[] bArr, int i, int peek, Paint paint, Canvas canvas) {
        int iA05;
        int runLength = i;
        int column = 0;
        do {
            int iA052 = r15.A05(8);
            if (iA052 != 0) {
                iA05 = 1;
            } else if (!r15.A0G()) {
                iA05 = r15.A05(7);
                if (iA05 != 0) {
                    iA052 = 0;
                } else {
                    column = 1;
                    iA05 = 0;
                    iA052 = 0;
                }
            } else {
                iA05 = r15.A05(7);
                iA052 = r15.A05(8);
                String[] strArr = A08;
                if (strArr[4].charAt(19) != strArr[0].charAt(19)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[7] = "oE62i0kU0YacGkvCLxgFzKdMfiudOn3o";
                strArr2[7] = "oE62i0kU0YacGkvCLxgFzKdMfiudOn3o";
            }
            if (iA05 != 0 && paint != null) {
                if (bArr != null) {
                    iA052 = bArr[iA052];
                }
                paint.setColor(iArr[iA052]);
                canvas.drawRect(runLength, peek, runLength + iA05, peek + 1, paint);
            }
            runLength += iA05;
            String[] strArr3 = A08;
            if (strArr3[1].length() == strArr3[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr4 = A08;
            strArr4[6] = "jmdilAXdKLha38CDbN17xGIpmuplWnFc";
            strArr4[3] = "1PNl1axnrexK2c7Nxi5CJrHaXY90XFpd";
        } while (column == 0);
        return runLength;
    }

    public static GH A04(IF r17, int i) {
        int[] iArr;
        int iA05;
        int clutId;
        int iA052;
        int cb;
        int b2 = 8;
        int iA053 = r17.A05(8);
        r17.A09(8);
        int i2 = i - 2;
        int[] clutEntries8Bit = A0G();
        int[] iArrA0H = A0H();
        int[] iArrA0I = A0I();
        while (i2 > 0) {
            int r = r17.A05(b2);
            int t = r17.A05(b2);
            int y = i2 - 2;
            if ((t & 128) != 0) {
                iArr = clutEntries8Bit;
            } else {
                int cr = t & 64;
                if (cr != 0) {
                    iArr = iArrA0H;
                } else {
                    iArr = iArrA0I;
                }
            }
            if ((t & 1) != 0) {
                iA05 = r17.A05(b2);
                clutId = r17.A05(b2);
                iA052 = r17.A05(b2);
                cb = r17.A05(b2);
                i2 = y - 4;
            } else {
                iA05 = r17.A05(6) << 2;
                int remainingLength = r17.A05(4);
                clutId = remainingLength << 4;
                int cr2 = r17.A05(4);
                iA052 = cr2 << 4;
                int cr3 = r17.A05(2);
                cb = cr3 << 6;
                i2 = y - 2;
            }
            if (iA05 == 0) {
                clutId = 0;
                iA052 = 0;
                cb = 255;
            }
            byte b3 = (byte) (255 - (cb & 255));
            int a2 = clutId - 128;
            int i3 = (int) (((double) iA05) + (((double) a2) * 1.402d));
            int cb2 = iA052 - 128;
            double d2 = ((double) iA05) - (((double) cb2) * 0.34414d);
            int cb3 = clutId - 128;
            int i4 = (int) (d2 - (((double) cb3) * 0.71414d));
            int cb4 = iA052 - 128;
            int a3 = IW.A06(i3, 0, 255);
            int b4 = IW.A06(i4, 0, 255);
            iArr[r] = A00(b3, a3, b4, IW.A06((int) (((double) iA05) + (((double) cb4) * 1.772d)), 0, 255));
            b2 = 8;
        }
        return new GH(iA053, clutEntries8Bit, iArrA0H, iArrA0I);
    }

    public static GI A05(IF r7) {
        int verticalPositionMinimum;
        int width;
        int verticalPositionMaximum;
        int height;
        r7.A09(4);
        boolean zA0G = r7.A0G();
        r7.A09(3);
        int iA05 = r7.A05(16);
        int iA052 = r7.A05(16);
        if (zA0G) {
            verticalPositionMinimum = r7.A05(16);
            verticalPositionMaximum = r7.A05(16);
            width = r7.A05(16);
            height = r7.A05(16);
        } else {
            verticalPositionMinimum = 0;
            width = 0;
            verticalPositionMaximum = iA05;
            height = iA052;
        }
        return new GI(iA05, iA052, verticalPositionMinimum, verticalPositionMaximum, width, height);
    }

    public static GJ A06(IF r8) {
        int objectCodingMethod = r8.A05(16);
        r8.A09(4);
        int iA05 = r8.A05(2);
        boolean zA0G = r8.A0G();
        r8.A09(1);
        byte[] bArr = null;
        byte[] bArr2 = null;
        if (iA05 == 1) {
            r8.A09(r8.A05(8) * 16);
        } else if (iA05 == 0) {
            int iA052 = r8.A05(16);
            int objectId = r8.A05(16);
            String[] strArr = A08;
            String str = strArr[4];
            String str2 = strArr[0];
            int iCharAt = str.charAt(19);
            int topFieldDataLength = str2.charAt(19);
            if (iCharAt != topFieldDataLength) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[2] = "pcqe5F2CDJi5oBWvBkq2zbdYSROcg8Hm";
            strArr2[2] = "pcqe5F2CDJi5oBWvBkq2zbdYSROcg8Hm";
            if (iA052 > 0) {
                bArr = new byte[iA052];
                r8.A0F(bArr, 0, iA052);
            }
            if (objectId > 0) {
                bArr2 = new byte[objectId];
                r8.A0F(bArr2, 0, objectId);
            } else {
                bArr2 = bArr;
            }
        }
        return new GJ(objectCodingMethod, zA0G, bArr, bArr2);
    }

    public static GK A07(IF r10, int timeoutSecs) {
        int remainingLength = r10.A05(8);
        int iA05 = r10.A05(4);
        int iA052 = r10.A05(2);
        r10.A09(2);
        int regionHorizontalAddress = timeoutSecs - 2;
        SparseArray sparseArray = new SparseArray();
        while (regionHorizontalAddress > 0) {
            int iA053 = r10.A05(8);
            r10.A09(8);
            regionHorizontalAddress -= 6;
            sparseArray.put(iA053, new GL(r10.A05(16), r10.A05(16)));
        }
        return new GK(remainingLength, iA05, iA052, sparseArray);
    }

    public static GM A08(IF r26, int i) {
        int i2 = 8;
        int iA05 = r26.A05(8);
        r26.A09(4);
        boolean zA0G = r26.A0G();
        r26.A09(3);
        int iA052 = r26.A05(16);
        int iA053 = r26.A05(16);
        int iA054 = r26.A05(3);
        int iA055 = r26.A05(3);
        r26.A09(2);
        int id = r26.A05(8);
        int iA056 = r26.A05(8);
        int width = r26.A05(4);
        int height = r26.A05(2);
        r26.A09(2);
        int pixelCode8Bit = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (pixelCode8Bit > 0) {
            int pixelCode4Bit = r26.A05(16);
            int pixelCode2Bit = r26.A05(2);
            int remainingLength = r26.A05(2);
            int objectHorizontalPosition = r26.A05(12);
            r26.A09(4);
            int objectVerticalPosition = r26.A05(12);
            pixelCode8Bit -= 6;
            int remainingLength2 = 0;
            int objectType = 0;
            if (pixelCode2Bit == 1 || pixelCode2Bit == 2) {
                remainingLength2 = r26.A05(i2);
                objectType = r26.A05(i2);
                pixelCode8Bit -= 2;
                int objectProvider = A08[2].charAt(23);
                if (objectProvider == 111) {
                    throw new RuntimeException();
                }
                String[] strArr = A08;
                strArr[4] = "2juIiSC4ZxHJWLrTtxN2ANki5argYjtZ";
                strArr[0] = "MWq7TNsVs7aXK0A5Gh22llfb9AkLnJo6";
            }
            sparseArray.put(pixelCode4Bit, new GN(pixelCode2Bit, remainingLength, objectHorizontalPosition, objectVerticalPosition, remainingLength2, objectType));
            i2 = 8;
        }
        return new GM(iA05, zA0G, iA052, iA053, iA054, iA055, id, iA056, width, height, sparseArray);
    }

    public static void A0C(GJ gj, GH gh, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = gh.A03;
        } else if (i == 2) {
            iArr = gh.A02;
        } else {
            iArr = gh.A01;
        }
        A0E(gj.A03, iArr, i, i2, i3, paint, canvas);
        A0E(gj.A02, iArr, i, i2, i3 + 1, paint, canvas);
    }

    public static void A0D(IF r6, GO go) {
        int dataFieldLimit = r6.A05(8);
        int iA05 = r6.A05(16);
        int iA052 = r6.A05(16);
        int iA03 = r6.A03() + iA052;
        int i = iA052 * 8;
        int pageId = r6.A02();
        if (i > pageId) {
            Log.w(A09(31, 9, 98), A09(0, 31, 5));
            int pageId2 = r6.A02();
            r6.A09(pageId2);
            return;
        }
        switch (dataFieldLimit) {
            case 16:
                if (iA05 == go.A03) {
                    GK gk = go.A01;
                    GK gkA07 = A07(r6, iA052);
                    if (gkA07.A00 != 0) {
                        go.A01 = gkA07;
                        go.A08.clear();
                        go.A06.clear();
                        go.A07.clear();
                    } else if (gk != null && gk.A02 != gkA07.A02) {
                        go.A01 = gkA07;
                    }
                }
                break;
            case 17:
                GK gk2 = go.A01;
                if (iA05 == go.A03 && gk2 != null) {
                    GM gmA08 = A08(r6, iA052);
                    if (gk2.A00 == 0) {
                        gmA08.A00(go.A08.get(gmA08.A03));
                    }
                    go.A08.put(gmA08.A03, gmA08);
                }
                break;
            case 18:
                if (iA05 == go.A03) {
                    GH ghA04 = A04(r6, iA052);
                    go.A06.put(ghA04.A00, ghA04);
                } else if (iA05 == go.A02) {
                    GH ghA042 = A04(r6, iA052);
                    go.A04.put(ghA042.A00, ghA042);
                }
                break;
            case 19:
                if (iA05 == go.A03) {
                    GJ gjA06 = A06(r6);
                    go.A07.put(gjA06.A00, gjA06);
                } else if (iA05 == go.A02) {
                    GJ gjA062 = A06(r6);
                    go.A05.put(gjA062.A00, gjA062);
                }
                break;
            case 20:
                if (iA05 == go.A03) {
                    go.A00 = A05(r6);
                }
                break;
        }
        int pageId3 = r6.A03();
        r6.A0A(iA03 - pageId3);
    }

    public static void A0E(byte[] bArr, int[] iArr, int i, int column, int i2, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int line = i2;
        IF r9 = new IF(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] bArrA0F = null;
        int dataType = column;
        while (r9.A02() != 0) {
            int iA05 = r9.A05(8);
            if (iA05 != 240) {
                switch (iA05) {
                    case 16:
                        if (i == 3) {
                            bArr3 = bArrA0F == null ? A0A : bArrA0F;
                        } else if (i == 2) {
                            bArr3 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                        } else {
                            bArr3 = null;
                        }
                        dataType = A01(r9, iArr, bArr3, dataType, line, paint, canvas);
                        r9.A06();
                        break;
                    case 17:
                        if (i == 3) {
                            bArr2 = 0 == 0 ? A0B : null;
                        } else {
                            bArr2 = null;
                            String[] strArr = A08;
                            if (strArr[4].charAt(19) != strArr[0].charAt(19)) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A08;
                            strArr2[2] = "ywEr7H1ZkU3fUIk8F5vLu65dTGZjfu1h";
                            strArr2[2] = "ywEr7H1ZkU3fUIk8F5vLu65dTGZjfu1h";
                        }
                        dataType = A02(r9, iArr, bArr2, dataType, line, paint, canvas);
                        r9.A06();
                        break;
                    case 18:
                        dataType = A03(r9, iArr, null, dataType, line, paint, canvas);
                        break;
                    default:
                        String[] strArr3 = A08;
                        if (strArr3[1].length() == strArr3[5].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr4 = A08;
                        strArr4[6] = "nnJuFIsGV5CjoI7UJHQ2Bk6wbONoIcvD";
                        strArr4[3] = "B7N9QxouVzPbBX96zhiMkNdTz6ghfWa9";
                        switch (iA05) {
                            case 32:
                                clutMapTable2To8 = A0F(4, 4, r9);
                                break;
                            case 33:
                                bArrA0F = A0F(4, 8, r9);
                                break;
                            case 34:
                                bArrA0F = A0F(16, 8, r9);
                                break;
                        }
                        break;
                }
            } else {
                dataType = column;
                if (A08[2].charAt(23) != 'o') {
                    String[] strArr5 = A08;
                    strArr5[6] = "9tyozG4lbSXUGnB14yX0PwlmOZMu8mKn";
                    strArr5[3] = "zB65tdLGIFDHc3IIcHjCnZN0WwQ6SUlQ";
                    line += 2;
                } else {
                    line += 2;
                }
            }
        }
    }

    public static byte[] A0F(int i, int i2, IF r5) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) r5.A05(i2);
        }
        return bArr;
    }

    public static int[] A0G() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0009 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] A0H() {
        /*
            r0 = 16
            int[] r5 = new int[r0]
            r0 = 0
            r5[r0] = r0
            r4 = 1
        L8:
            int r0 = r5.length
            if (r4 >= r0) goto L51
            r0 = 8
            r6 = 255(0xff, float:3.57E-43)
            if (r4 >= r0) goto L32
            r0 = r4 & 1
            if (r0 == 0) goto L30
            r2 = 255(0xff, float:3.57E-43)
        L17:
            r0 = r4 & 2
            if (r0 == 0) goto L2e
            r1 = 255(0xff, float:3.57E-43)
        L1d:
            r0 = r4 & 4
            if (r0 == 0) goto L2c
            r0 = 255(0xff, float:3.57E-43)
        L23:
            int r0 = A00(r6, r2, r1, r0)
            r5[r4] = r0
        L29:
            int r4 = r4 + 1
            goto L8
        L2c:
            r0 = 0
            goto L23
        L2e:
            r1 = 0
            goto L1d
        L30:
            r2 = 0
            goto L17
        L32:
            r0 = r4 & 1
            r3 = 127(0x7f, float:1.78E-43)
            if (r0 == 0) goto L4f
            r2 = 127(0x7f, float:1.78E-43)
        L3a:
            r0 = r4 & 2
            if (r0 == 0) goto L4d
            r1 = 127(0x7f, float:1.78E-43)
        L40:
            r0 = r4 & 4
            if (r0 == 0) goto L4b
        L44:
            int r0 = A00(r6, r2, r1, r3)
            r5[r4] = r0
            goto L29
        L4b:
            r3 = 0
            goto L44
        L4d:
            r1 = 0
            goto L40
        L4f:
            r2 = 0
            goto L3a
        L51:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GP.A0H():int[]");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0009 */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] A0I() {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GP.A0I():int[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b8, code lost:
    
        if (r1.A0A == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01bd, code lost:
    
        if (r1.A01 != 3) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01bf, code lost:
    
        r9 = r14.A03[r1.A07];
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c5, code lost:
    
        r20.A03.setColor(r9);
        r20.A01.drawRect(r4, r3, r1.A08 + r4, r1.A02 + r3, r20.A03);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0218, code lost:
    
        if (r1.A01 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x021a, code lost:
    
        r9 = r14.A02[r1.A06];
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0221, code lost:
    
        r11 = r14.A01;
        r10 = com.facebook.ads.redexgen.X.GP.A08;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0235, code lost:
    
        if (r10[4].charAt(19) == r10[0].charAt(19)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0237, code lost:
    
        r9 = r11[r1.A05];
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x023c, code lost:
    
        r10 = com.facebook.ads.redexgen.X.GP.A08;
        r10[1] = "SK7qwpqeD";
        r10[5] = "H8yQ2FZGH97VM0iLZGupvWVfM60nEcr";
        r9 = r11[r1.A05];
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123 A[PHI: r3
      0x0123: PHI (r3v26 int) = (r3v16 int), (r3v30 int) binds: [B:71:0x0296, B:32:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02a3 A[EDGE_INSN: B:83:0x02a3->B:77:0x02a3 BREAK  A[LOOP:1: B:25:0x0095->B:59:0x01db, LOOP_LABEL: LOOP:1: B:25:0x0095->B:59:0x01db], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.facebook.ads.redexgen.X.G5> A0J(byte[] r21, int r22) {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GP.A0J(byte[], int):java.util.List");
    }

    public final void A0K() {
        this.A06.A00();
    }
}
