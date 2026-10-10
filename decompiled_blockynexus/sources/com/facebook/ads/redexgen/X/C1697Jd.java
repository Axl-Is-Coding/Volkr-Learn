package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1697Jd {
    public final AdErrorType A00;
    public final String A01;

    public C1697Jd(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C1697Jd(AdErrorType adErrorType, @Nullable String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static AdError A00(C1697Jd c1697Jd) {
        if (c1697Jd.A04().isPublicError()) {
            return new AdError(c1697Jd.A04().getErrorCode(), c1697Jd.A05());
        }
        return new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }

    public static C1697Jd A01(AdErrorType adErrorType) {
        return new C1697Jd(adErrorType, (String) null);
    }

    public static C1697Jd A02(AdErrorType adErrorType, @Nullable String str) {
        return new C1697Jd(adErrorType, str);
    }

    public static C1697Jd A03(C1698Je c1698Je) {
        return new C1697Jd(c1698Je.A00(), c1698Je.A01());
    }

    public final AdErrorType A04() {
        return this.A00;
    }

    public final String A05() {
        return this.A01;
    }
}
