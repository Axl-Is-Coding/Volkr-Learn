package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Si, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1929Si extends C4A {
    public static String[] A01;
    public boolean A00 = true;

    static {
        A08();
    }

    public static void A08() {
        A01 = new String[]{"ufm8s7LRmOM7", "sIBwdoM05ajejE", "0NxvrnR7UZDHrBy4xVhLU5lsqzWJ5R3x", "FsILnIqpIa8iE3wffvJrO4tNlZdDmpUd", "wKnqjXSh8f61FKWyknAGi8xlXXoDdiLA", "lpMPMGmveEx5YZPPZgDkriuB4nzdouJK", "fQPzW90JHWOApVaaQbndX59CGXgCnXlm", "Pp9SKBa6RS3IfLIGXA9e4oeVKGHa5CsE"};
    }

    public abstract boolean A0U(C4W c4w);

    public abstract boolean A0V(C4W c4w);

    public abstract boolean A0W(C4W c4w, int i, int i2, int i3, int i4);

    public abstract boolean A0X(C4W c4w, C4W c4w2, int i, int i2, int i3, int i4);

    @Override // com.facebook.ads.redexgen.X.C4A
    public final boolean A0H(@NonNull C4W c4w) {
        return !this.A00 || c4w.A0c();
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final boolean A0I(@NonNull C4W c4w, @Nullable AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492) {
        if (anonymousClass49 != null && (anonymousClass49.A01 != anonymousClass492.A01 || anonymousClass49.A03 != anonymousClass492.A03)) {
            return A0W(c4w, anonymousClass49.A01, anonymousClass49.A03, anonymousClass492.A01, anonymousClass492.A03);
        }
        return A0U(c4w);
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final boolean A0J(@NonNull C4W c4w, @NonNull AnonymousClass49 anonymousClass49, @Nullable AnonymousClass49 anonymousClass492) {
        int i = anonymousClass49.A01;
        int i2 = anonymousClass49.A03;
        View view = c4w.A0H;
        int left = anonymousClass492 == null ? view.getLeft() : anonymousClass492.A01;
        int newLeft = anonymousClass492 == null ? view.getTop() : anonymousClass492.A03;
        if (!c4w.A0d() && (i != left || i2 != newLeft)) {
            view.layout(left, newLeft, view.getWidth() + left, view.getHeight() + newLeft);
            return A0W(c4w, i, i2, left, newLeft);
        }
        return A0V(c4w);
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final boolean A0K(@NonNull C4W c4w, @NonNull AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492) {
        if (anonymousClass49.A01 != anonymousClass492.A01 || anonymousClass49.A03 != anonymousClass492.A03) {
            return A0W(c4w, anonymousClass49.A01, anonymousClass49.A03, anonymousClass492.A01, anonymousClass492.A03);
        }
        A0O(c4w);
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final boolean A0L(@NonNull C4W c4w, @NonNull C4W c4w2, @NonNull AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492) {
        int fromTop;
        int toLeft;
        int i = anonymousClass49.A01;
        int i2 = anonymousClass49.A03;
        if (c4w2.A0i()) {
            fromTop = anonymousClass49.A01;
            toLeft = anonymousClass49.A03;
        } else {
            fromTop = anonymousClass492.A01;
            toLeft = anonymousClass492.A03;
        }
        if (A01[1].length() != 14) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "7F8ns227Orjao7";
        strArr[1] = "7F8ns227Orjao7";
        return A0X(c4w, c4w2, i, i2, fromTop, toLeft);
    }

    public final void A0M(C4W c4w) {
        A0B(c4w);
    }

    public final void A0N(C4W c4w) {
    }

    public final void A0O(C4W c4w) {
        A0B(c4w);
    }

    public final void A0P(C4W c4w) {
    }

    public final void A0Q(C4W c4w) {
        A0B(c4w);
    }

    public final void A0R(C4W c4w) {
    }

    public final void A0S(C4W c4w, boolean z) {
        A0B(c4w);
    }

    public final void A0T(C4W c4w, boolean z) {
    }
}
