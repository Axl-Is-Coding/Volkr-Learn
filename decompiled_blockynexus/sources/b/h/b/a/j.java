package b.h.b.a;

import android.content.Context;
import com.sandboxol.blockmango.config.GameEventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: GameEventUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public static void a(Context context, String str) {
        if (((str.hashCode() == 96659917 && str.equals("g2019")) ? (byte) 0 : (byte) -1) != 0) {
            return;
        }
        ReportDataAdapter.onEvent(context, GameEventConstant.CLICK_MARIO_ENTER);
    }
}
