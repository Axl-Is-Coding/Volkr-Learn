package b.h.b.a;

import android.content.Context;
import android.os.Vibrator;

/* JADX INFO: compiled from: VibratorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {
    public static void a(Context context, int i) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(i);
    }
}
