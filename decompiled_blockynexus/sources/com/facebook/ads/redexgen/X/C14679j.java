package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Arrays;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14679j extends LU {
    public static byte[] A0E;
    public static final String A0F;

    @Nullable
    public Uri A00;

    @Nullable
    public NativeAd A01;
    public J5 A02;

    @Nullable
    public M7 A03;

    @Nullable
    public C7m A04;

    @Nullable
    public String A05;

    @Nullable
    public String A06;

    @Nullable
    public String A07;
    public final AnonymousClass13 A08;
    public final C2026Wb A09;
    public final AbstractC1714Jv A0A;
    public final AbstractC1708Jp A0B;
    public final AbstractC1696Jb A0C;
    public final String A0D;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0E = new byte[]{122, -104, -91, 94, -85, 87, -86, -85, -104, -87, -85, 87, 120, -84, -101, -96, -100, -91, -102, -100, -123, -100, -85, -82, -90, -87, -94, 120, -102, -85, -96, -83, -96, -85, -80, 101, 87, -124, -104, -94, -100, 87, -86, -84, -87, -100, 87, -85, -97, -104, -85, 87, -96, -85, 94, -86, 87, -96, -91, 87, -80, -90, -84, -87, 87, 120, -91, -101, -87, -90, -96, -101, -124, -104, -91, -96, -99, -100, -86, -85, 101, -81, -92, -93, 87, -99, -96, -93, -100, 101, -77, -32, -32, -35, -32, -88, -114, 109, 105, 104, -100, -117, -112, -116, -107, -118, -116, 117, -116, -101, -98, -106, -103, -110, 113, -103, -105, -104, 68, -105, -119, -104, 103, -112, -115, -119, -110, -104, 120, -109, -113, -119, -110, 68, -118, -115, -106, -105, -104, 113, -103, -105, -104, 68, -105, -119, -104, 122, -115, -120, -119, -109, 121, 118, 109, 68, -109, -106, 68, -105, -119, -104, 122, -115, -120, -119, -109, 113, 116, 104, 68, -118, -115, -106, -105, -104, -16, -3, -18, -16, -14, 3, -8, 5, -8, 3, 8, -80, -71, -74, -78, -69, -63, -95, -68, -72, -78, -69, -7, -22, -5, -4, -14, -9, -16, -107, -105, -118, -119, -118, -117, -114, -109, -118, -119, 116, -105, -114, -118, -109, -103, -122, -103, -114, -108, -109, 112, -118, -98, -48, -55, -60, -52, -48, -64, -92, -65, -39, -41, -55, -78, -59, -40, -51, -38, -55, -89, -40, -59, -90, -39, -40, -40, -45, -46, -41, -54, -59, -58, -48, -83, -48, -56, -56, -58, -45, -22, -35, -40, -39, -29, -63, -60, -72, -120, 123, 118, 119, -127, 101, 119, 119, 125, 102, 123, 127, 119, -40, -53, -58, -57, -47, -73, -76, -82, -3, -16, -21, -20, -10, -26, -5, -16, -12, -20, -26, -9, -10, -13, -13, -16, -11, -18, -26, -16, -11, -5, -20, -7, -3, -24, -13, -87, -100, -104, -86, -121, -84, -93, -104};
    }

    static {
        A03();
        A0F = C14679j.class.getSimpleName();
    }

    public C14679j(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.9m
            public static String[] A01;

            static {
                A00();
            }

            public static void A00() {
                A01 = new String[]{"3HJrVJ73tbjG2wlGP0Bv3sg114RWReqh", "KjbZJ14", "byIXsJDFT4cdH01hLIEiCoP3oVFxRmF5", "CAUeU9lKsEQJQ8oJs88JTqk7GAcDU2io", "xLviaKB4KZIhZN1GU0dHl8c6bwXdm9iC", "IMgVgO", "Wh2MWpRo7VbT5p9HRfne6LI8Uh8KJseH", "ItjfoHp0lrctiWkbEjfK3EyEN624ZUfA"};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                if (this.A00.A03 != null) {
                    this.A00.A03.AAj();
                    if (A01[1].length() != 7) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[4] = "hS5VQsWNORhrf4LLsxqD30oOzabUAqI4";
                    strArr[4] = "hS5VQsWNORhrf4LLsxqD30oOzabUAqI4";
                }
            }
        };
        this.A0B = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.9l
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                if (this.A00.A03 != null) {
                    this.A00.A03.onPause();
                }
            }
        };
        this.A0A = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.9k
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                if (this.A00.A03 != null) {
                    this.A00.A03.A9T();
                }
            }
        };
        this.A08 = new AnonymousClass13(this, c2026Wb);
        this.A09 = c2026Wb;
        A02();
    }

    public C14679j(C2026Wb c2026Wb, AttributeSet attributeSet) {
        super(c2026Wb, attributeSet);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.9m
            public static String[] A01;

            static {
                A00();
            }

            public static void A00() {
                A01 = new String[]{"3HJrVJ73tbjG2wlGP0Bv3sg114RWReqh", "KjbZJ14", "byIXsJDFT4cdH01hLIEiCoP3oVFxRmF5", "CAUeU9lKsEQJQ8oJs88JTqk7GAcDU2io", "xLviaKB4KZIhZN1GU0dHl8c6bwXdm9iC", "IMgVgO", "Wh2MWpRo7VbT5p9HRfne6LI8Uh8KJseH", "ItjfoHp0lrctiWkbEjfK3EyEN624ZUfA"};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                if (this.A00.A03 != null) {
                    this.A00.A03.AAj();
                    if (A01[1].length() != 7) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[4] = "hS5VQsWNORhrf4LLsxqD30oOzabUAqI4";
                    strArr[4] = "hS5VQsWNORhrf4LLsxqD30oOzabUAqI4";
                }
            }
        };
        this.A0B = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.9l
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                if (this.A00.A03 != null) {
                    this.A00.A03.onPause();
                }
            }
        };
        this.A0A = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.9k
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                if (this.A00.A03 != null) {
                    this.A00.A03.A9T();
                }
            }
        };
        this.A08 = new AnonymousClass13(this, c2026Wb);
        this.A09 = c2026Wb;
        A02();
    }

    public C14679j(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.9m
            public static String[] A01;

            static {
                A00();
            }

            public static void A00() {
                A01 = new String[]{"3HJrVJ73tbjG2wlGP0Bv3sg114RWReqh", "KjbZJ14", "byIXsJDFT4cdH01hLIEiCoP3oVFxRmF5", "CAUeU9lKsEQJQ8oJs88JTqk7GAcDU2io", "xLviaKB4KZIhZN1GU0dHl8c6bwXdm9iC", "IMgVgO", "Wh2MWpRo7VbT5p9HRfne6LI8Uh8KJseH", "ItjfoHp0lrctiWkbEjfK3EyEN624ZUfA"};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                if (this.A00.A03 != null) {
                    this.A00.A03.AAj();
                    if (A01[1].length() != 7) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[4] = "hS5VQsWNORhrf4LLsxqD30oOzabUAqI4";
                    strArr[4] = "hS5VQsWNORhrf4LLsxqD30oOzabUAqI4";
                }
            }
        };
        this.A0B = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.9l
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                if (this.A00.A03 != null) {
                    this.A00.A03.onPause();
                }
            }
        };
        this.A0A = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.9k
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                if (this.A00.A03 != null) {
                    this.A00.A03.A9T();
                }
            }
        };
        this.A08 = new AnonymousClass13(this, c2026Wb);
        this.A09 = c2026Wb;
        A02();
    }

    private void A02() {
        getEventBus().A04(this.A0C, this.A0B, this.A0A);
    }

    private void A04(Intent intent) {
        if (this.A04 == null) {
            A05(A01(114, 25, 19));
            return;
        }
        if (this.A00 == null && this.A07 == null) {
            A05(A01(139, 37, 19));
            return;
        }
        intent.putExtra(A01(237, 18, 83), this.A06);
        intent.putExtra(A01(322, 8, 34), KC.A05);
        intent.putExtra(A01(287, 8, 81), this.A00.toString());
        String strA01 = this.A05;
        if (strA01 == null) {
            strA01 = A01(0, 0, 39);
        }
        intent.putExtra(A01(187, 11, 60), strA01);
        intent.putExtra(A01(266, 8, 99), this.A07);
        intent.putExtra(A01(205, 24, 20), 13);
        intent.putExtra(A01(274, 13, 1), getCurrentPositionInMillis());
        intent.putExtra(A01(229, 8, 74), this.A0D);
        intent.putExtra(A01(255, 11, 80), this.A04.A0W());
        intent.putExtra(A01(295, 27, 118), getVideoProgressReportIntervalMs());
        intent.addFlags(268435456);
    }

    private void A05(String str) {
        this.A09.A04().A8H(A01(198, 7, 120), C8Y.A1o, new C8Z(AdErrorType.PARSER_FAILURE.getDefaultErrorMessage(), A01(90, 7, 93) + str));
        if (AdInternalSettings.isDebugBuild()) {
            Log.w(A0F, str);
        }
    }

    public final void A0i() {
        NativeAd nativeAd = this.A01;
        if (nativeAd != null) {
            nativeAd.onCtaBroadcast();
        }
    }

    public final void A0j() {
        AdActivityIntent adActivityIntentA04 = C1725Kh.A04(this.A09);
        A04(adActivityIntentA04);
        try {
            A0b(false, 6);
            setVisibility(8);
            C1725Kh.A0A(this.A09, adActivityIntentA04);
        } catch (Exception e2) {
            this.A09.A04().A8H(A01(176, 11, 126), C8Y.A05, new C8Z(e2));
            Log.e(A01(97, 17, 22), A01(0, 90, 38), e2);
        }
    }

    @Nullable
    public M7 getListener() {
        return this.A03;
    }

    public String getUniqueId() {
        return this.A0D;
    }

    @Override // com.facebook.ads.redexgen.X.LU, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A08.A03();
    }

    @Override // com.facebook.ads.redexgen.X.LU, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.A08.A04();
        super.onDetachedFromWindow();
    }

    public void setAdEventManager(J5 j5) {
        this.A02 = j5;
    }

    public void setClientToken(@Nullable String str) {
        C7m c7m;
        C7m c7m2 = this.A04;
        if (c7m2 != null) {
            c7m2.A0h();
        }
        this.A05 = str;
        if (str != null) {
            c7m = new C7m(this.A09, this.A02, this, str);
        } else {
            c7m = null;
        }
        this.A04 = c7m;
    }

    public void setEnableBackgroundVideo(boolean z) {
        super.A0C.setBackgroundPlaybackEnabled(z);
    }

    public void setListener(@Nullable M7 m7) {
        this.A03 = m7;
    }

    public void setNativeAd(@Nullable NativeAd nativeAd) {
        this.A01 = nativeAd;
    }

    public void setVideoCTA(@Nullable String str) {
        this.A06 = str;
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public void setVideoMPD(@Nullable String str) {
        if (str != null && this.A04 == null) {
            A05(A01(114, 25, 19));
        } else {
            this.A07 = str;
            super.setVideoMPD(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public void setVideoURI(@Nullable Uri uri) {
        if (uri != null && this.A04 == null) {
            A05(A01(114, 25, 19));
        } else {
            this.A00 = uri;
            super.setVideoURI(uri);
        }
    }
}
