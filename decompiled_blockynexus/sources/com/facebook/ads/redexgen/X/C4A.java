package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import io.rong.common.dlog.DLog;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4A {
    public static String[] A06;
    public AnonymousClass48 A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    static {
        A02();
    }

    public static void A02() {
        A06 = new String[]{"wCFFy4v0UHolBGzubHhtaTK0KlaK5TU8", "WXL", "veTi", "n3", "rW28yUWMMTgiQlEcIz6smwE3e87Fn5Ax", "QU5acghFPGL2KQJts4swUt9W5A9MK8iM", "qIZlYUWuFA6tmX766BSANKSPkXlWbMWT", "RhPzJuizv3JTUr3AZhw4zLdz5ZpO"};
    }

    public abstract void A0C();

    public abstract void A0D();

    public abstract void A0E(C4W c4w);

    public abstract boolean A0F();

    public abstract boolean A0I(@NonNull C4W c4w, @Nullable AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492);

    public abstract boolean A0J(@NonNull C4W c4w, @NonNull AnonymousClass49 anonymousClass49, @Nullable AnonymousClass49 anonymousClass492);

    public abstract boolean A0K(@NonNull C4W c4w, @NonNull AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492);

    public abstract boolean A0L(@NonNull C4W c4w, @NonNull C4W c4w2, @NonNull AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492);

    public static int A00(C4W c4w) {
        int pos = c4w.A0C & 14;
        if (c4w.A0c()) {
            return 4;
        }
        if ((pos & 4) == 0) {
            int iA0K = c4w.A0K();
            int iA0H = c4w.A0H();
            String[] strArr = A06;
            String str = strArr[3];
            String str2 = strArr[1];
            int length = str.length();
            int oldPos = str2.length();
            if (length == oldPos) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[0] = "z6mPnscAmNwlAliMzxZ9cFQDVALsWjfG";
            strArr2[0] = "z6mPnscAmNwlAliMzxZ9cFQDVALsWjfG";
            if (iA0K != -1 && iA0H != -1 && iA0K != iA0H) {
                return pos | DLog.CRS;
            }
            return pos;
        }
        return pos;
    }

    private final AnonymousClass49 A01() {
        return new AnonymousClass49();
    }

    public final long A03() {
        return this.A00;
    }

    public final long A04() {
        return this.A01;
    }

    public final long A05() {
        return this.A02;
    }

    public final long A06() {
        return this.A03;
    }

    @NonNull
    public final AnonymousClass49 A07(@NonNull C4T c4t, @NonNull C4W c4w) {
        return A01().A01(c4w);
    }

    @NonNull
    public final AnonymousClass49 A08(@NonNull C4T c4t, @NonNull C4W c4w, int i, @NonNull List<Object> list) {
        return A01().A01(c4w);
    }

    public final void A09() {
        int i = this.A05.size();
        if (0 < i) {
            this.A05.get(0);
            throw null;
        }
        this.A05.clear();
    }

    public final void A0A(AnonymousClass48 anonymousClass48) {
        this.A04 = anonymousClass48;
    }

    public final void A0B(C4W c4w) {
        AnonymousClass48 anonymousClass48 = this.A04;
        if (anonymousClass48 != null) {
            anonymousClass48.A98(c4w);
        }
    }

    public boolean A0G(@NonNull C4W c4w, @NonNull List<Object> list) {
        return A0H(c4w);
    }

    public boolean A0H(@NonNull C4W c4w) {
        return true;
    }
}
