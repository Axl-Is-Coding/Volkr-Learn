package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* JADX INFO: compiled from: UserManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
        return true;
    }
}
