package com.google.android.ads.mediationtestsuite.dataobjects;

import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.utils.AdManager;
import com.google.android.ads.mediationtestsuite.utils.d;
import com.google.android.ads.mediationtestsuite.utils.e;
import com.google.android.ads.mediationtestsuite.utils.h;
import com.google.android.ads.mediationtestsuite.utils.o;
import com.google.android.ads.mediationtestsuite.utils.q;

/* JADX INFO: loaded from: classes.dex */
public enum AdFormat {
    BANNER("banner", R.string.gmts_format_banner) { // from class: com.google.android.ads.mediationtestsuite.dataobjects.AdFormat.1
        @Override // com.google.android.ads.mediationtestsuite.dataobjects.AdFormat
        public AdManager createAdLoader(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
            return new e(networkConfig, adLoadCallback);
        }
    },
    INTERSTITIAL("interstitial", R.string.gmts_format_interstitial) { // from class: com.google.android.ads.mediationtestsuite.dataobjects.AdFormat.2
        @Override // com.google.android.ads.mediationtestsuite.dataobjects.AdFormat
        public AdManager createAdLoader(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
            return new h(networkConfig, adLoadCallback);
        }
    },
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, R.string.gmts_format_native) { // from class: com.google.android.ads.mediationtestsuite.dataobjects.AdFormat.3
        @Override // com.google.android.ads.mediationtestsuite.dataobjects.AdFormat
        public AdManager createAdLoader(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
            return new o(networkConfig, adLoadCallback);
        }
    },
    REWARDED("rewarded", R.string.gmts_format_rewarded) { // from class: com.google.android.ads.mediationtestsuite.dataobjects.AdFormat.4
        @Override // com.google.android.ads.mediationtestsuite.dataobjects.AdFormat
        public AdManager createAdLoader(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
            return new q(networkConfig, adLoadCallback);
        }
    },
    BANNER_INTERSTITIAL("banner,interstitial", R.string.gmts_format_banner_interstitial) { // from class: com.google.android.ads.mediationtestsuite.dataobjects.AdFormat.5
        @Override // com.google.android.ads.mediationtestsuite.dataobjects.AdFormat
        public AdManager createAdLoader(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
            int i = AnonymousClass7.$SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$AdFormat[networkConfig.getAdapter().getFormat().ordinal()];
            if (i == 1) {
                return AdFormat.BANNER.createAdLoader(networkConfig, adLoadCallback);
            }
            if (i == 2) {
                return AdFormat.INTERSTITIAL.createAdLoader(networkConfig, adLoadCallback);
            }
            String string = DataStore.getContext().getString(R.string.gmts_error_unsupported_ad_load_format, networkConfig.getAdapter().getFormat().getFormatString());
            if (d.b(DataStore.getContext())) {
                throw new AssertionError(string);
            }
            Log.d("gma_test", string);
            return AdFormat.BANNER.createAdLoader(networkConfig, adLoadCallback);
        }
    },
    UNKNOWN("unknown", -1) { // from class: com.google.android.ads.mediationtestsuite.dataobjects.AdFormat.6
        @Override // com.google.android.ads.mediationtestsuite.dataobjects.AdFormat
        public AdManager createAdLoader(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
            return null;
        }
    };

    private final int displayResId;
    private final String formatString;

    /* JADX INFO: renamed from: com.google.android.ads.mediationtestsuite.dataobjects.AdFormat$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$AdFormat = new int[AdFormat.values().length];

        static {
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$AdFormat[AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$AdFormat[AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static AdFormat from(String str) {
        for (AdFormat adFormat : values()) {
            if (str.equals(adFormat.getFormatString())) {
                return adFormat;
            }
        }
        return UNKNOWN;
    }

    public abstract AdManager createAdLoader(NetworkConfig networkConfig, AdLoadCallback adLoadCallback);

    public String getDisplayString() {
        return DataStore.getContext().getString(this.displayResId);
    }

    public String getFormatString() {
        return this.formatString;
    }

    AdFormat(String str, int i) {
        this.formatString = str;
        this.displayResId = i;
    }
}
