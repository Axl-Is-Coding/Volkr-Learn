package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7Y extends AbstractC1716Jx {
    public static byte[] A04;
    public static String[] A05;
    public WeakReference<AudioManager.OnAudioFocusChangeListener> A00;
    public final AbstractC1714Jv A01;
    public final AbstractC1708Jp A02;
    public final AbstractC1696Jb A03;

    static {
        A06();
        A05();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{69, 81, 64, 77, 75};
    }

    public static void A06() {
        A05 = new String[]{"1cdJmqZo5JmjBSz3V6iIBc", "b5mtsG63LfUTmVo", "v7pUKp70YLsspQnihAQa", "8RT4D0PvYsYuyNKYG0J", "LG3ePim6beoWq", "NyBn7Ghd81GFryl", "6ZzG2MB7DBeQL6nfhWDwO", "j693JmATHJpRsHF"};
    }

    public C7Y(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A00 = null;
        this.A01 = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.7c
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 66);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{-26, -6, -23, -18, -12};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                ((AudioManager) this.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 67))).abandonAudioFocus(this.A00.A00 == null ? null : (AudioManager.OnAudioFocusChangeListener) this.A00.A00.get());
            }
        };
        this.A02 = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.7b
            public static byte[] A01;
            public static String[] A02;

            static {
                A02();
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 90);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                byte[] bArr = {74, 94, 79, 66, 68};
                if (A02[4].length() != 16) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[0] = "gxAB8m8awSLzC5VQ45NFPzppUrTsIZFp";
                strArr[0] = "gxAB8m8awSLzC5VQ45NFPzppUrTsIZFp";
                A01 = bArr;
            }

            public static void A02() {
                A02 = new String[]{"3T8L8cxvDKNdHoEU8ndZ6FAxHol6AQmj", "T9d9jeRvA6TPkjlyE6ANkunwJ", "ZZYtC1qzWr9Z64iPtzSxbZEtAt5IIjlM", "LskUfs4Yi749bFjDIqQWoA2BC0G", "rATJhvtsPzynSvx3", "X5OC7Y9E", "WElhmvPz", "o0UdQ4xy8VrknzG9L7EyZnB"};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                ((AudioManager) this.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 113))).abandonAudioFocus(this.A00.A00 == null ? null : (AudioManager.OnAudioFocusChangeListener) this.A00.A00.get());
                String[] strArr = A02;
                if (strArr[5].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[7] = "auSH";
                strArr2[7] = "auSH";
            }
        };
        this.A03 = new C14177a(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A03, this.A01, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A02, this.A01, this.A03);
        }
        super.A08();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        AudioManager audioManager = (AudioManager) getContext().getApplicationContext().getSystemService(A02(0, 5, 68));
        WeakReference<AudioManager.OnAudioFocusChangeListener> weakReference = this.A00;
        audioManager.abandonAudioFocus(weakReference == null ? null : weakReference.get());
        super.onDetachedFromWindow();
        if (A05[4].length() != 13) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[3] = "22FJBjB3Y4dWSYUEkMs";
        strArr[3] = "22FJBjB3Y4dWSYUEkMs";
    }
}
