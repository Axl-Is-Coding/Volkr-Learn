package bolts;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: AppLinks.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static Bundle a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle b(Intent intent) {
        Bundle bundleA = a(intent);
        if (bundleA == null) {
            return null;
        }
        return bundleA.getBundle("extras");
    }
}
