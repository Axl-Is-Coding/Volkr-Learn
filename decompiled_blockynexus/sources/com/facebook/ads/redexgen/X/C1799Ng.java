package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ng, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1799Ng extends C4W {
    public static String[] A0A;

    @DoNotStrip
    public AbstractC1848Pd A00;
    public C1849Pe A01;

    @Nullable
    public C1849Pe A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final SparseBooleanArray A07;
    public final C2026Wb A08;
    public final AbstractC1878Qh A09;

    static {
        A08();
    }

    public static void A08() {
        A0A = new String[]{"av2tITPhYKbVn20ukUfJR25ELbcgjHbj", "MLeLe181lhP7dC21QqjxU1VDKV9lNkzJ", "XUmY4VBJ2tlJWKlPJ7YkBdCsKtcC", "bK6oHsXedskfaWsjnVeS6YyvP0sRA20b", "BhCeFQN4dHt9z3MLE3p7bnIzhrf86Cw8", "mLW9T0fP2Q5Hob07hRXsv0QUH1fN4", "pNzPXZ5fcby2PvmlRsfUzns43oHDF5Mi", "3YktW7BrcDIc4Xw2f2zdWv5xFETbHIAE"};
    }

    public C1799Ng(AbstractC1878Qh abstractC1878Qh, SparseBooleanArray sparseBooleanArray, C1849Pe c1849Pe, int i, int i2, int i3, int i4, C2026Wb c2026Wb) {
        super(abstractC1878Qh);
        this.A08 = c2026Wb;
        this.A09 = abstractC1878Qh;
        this.A07 = sparseBooleanArray;
        this.A01 = c1849Pe;
        this.A03 = i;
        this.A04 = i2;
        this.A05 = i3;
        this.A06 = i4;
    }

    private void A09(J5 j5, LQ lq, String str, ON on) {
        if (this.A07.get(on.A02())) {
            return;
        }
        C1849Pe c1849Pe = this.A02;
        if (c1849Pe != null) {
            c1849Pe.A0X();
            if (A0A[4].charAt(16) != 'E') {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[4] = "iteeE4SnfkkyQnEAEqI0za4snrHpWaXy";
            strArr[4] = "iteeE4SnfkkyQnEAEqI0za4snrHpWaXy";
            this.A02 = null;
        }
        this.A00 = new OI(this, str, on, j5, on.A04(), lq);
        this.A02 = new C1849Pe(this.A09, 10, new WeakReference(this.A00), this.A08);
        this.A02.A0a(false);
        this.A02.A0Y(100);
        this.A02.A0Z(100);
        this.A09.setOnAssetsLoadedListener(new C1815Nw(this, on));
    }

    public final void A0m(ON on, J5 j5, AnonymousClass77 anonymousClass77, LQ lq, String videoUrl) {
        int iA02 = on.A02();
        this.A09.setTag(-1593835536, Integer.valueOf(iA02));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.A03, -2);
        marginLayoutParams.setMargins(iA02 == 0 ? this.A04 : this.A05, 0, iA02 >= this.A06 + (-1) ? this.A04 : this.A05, 0);
        String strA07 = on.A03().A0E().A07();
        String strA08 = on.A03().A0E().A08();
        this.A09.setIsVideo(!TextUtils.isEmpty(strA08));
        if (this.A09.A0j()) {
            this.A09.setVideoPlaceholderUrl(strA07);
            this.A09.setVideoUrl(anonymousClass77.A0M(strA08));
        } else {
            this.A09.setImageUrl(strA07);
        }
        this.A09.setLayoutParams(marginLayoutParams);
        this.A09.setAdTitleAndDescription(on.A03().A0F().A06(), on.A03().A0F().A01());
        this.A09.setCTAInfo(on.A03().A0G(), on.A04());
        this.A09.A0h(on.A04());
        A09(j5, lq, videoUrl, on);
    }
}
