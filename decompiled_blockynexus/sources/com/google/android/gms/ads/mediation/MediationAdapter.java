package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static class zza {
        private int zzere;

        public final Bundle zzadg() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzere);
            return bundle;
        }

        public final zza zzdv(int i) {
            this.zzere = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
