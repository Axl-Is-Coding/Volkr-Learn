package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C14177a extends AbstractC1696Jb {
    public static byte[] A01;
    public final /* synthetic */ C7Y A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-7, ci.k, -4, 1, 7};
    }

    public C14177a(C7Y c7y) {
        this.A00 = c7y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A04(C1703Jk c1703Jk) {
        if (this.A00.A00 == null || this.A00.A00.get() == null) {
            this.A00.A00 = new WeakReference(new C1843Oy(this));
        }
        ((AudioManager) this.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 34))).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) this.A00.A00.get(), 3, 1);
    }
}
