package com.disabngo.blockynexus.binding.adapter;

import com.google.android.material.appbar.AppBarLayout;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: AppBarLayoutAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(AppBarLayout appBarLayout, final ReplyCommand<Float> replyCommand, final ReplyCommand<Float> replyCommand2, final ReplyCommand<Float> replyCommand3) {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.b() { // from class: com.disabngo.blockynexus.binding.adapter.a
            @Override // com.google.android.material.appbar.AppBarLayout.a
            public final void a(AppBarLayout appBarLayout2, int i) {
                e.a(replyCommand, replyCommand2, replyCommand3, appBarLayout2, i);
            }
        });
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, ReplyCommand replyCommand2, ReplyCommand replyCommand3, AppBarLayout appBarLayout, int i) {
        int iAbs = Math.abs(i);
        int totalScrollRange = appBarLayout.getTotalScrollRange();
        int i2 = totalScrollRange / 3;
        if (iAbs <= i2) {
            float f2 = (i2 - iAbs) / i2;
            if (replyCommand != null) {
                replyCommand.execute(Float.valueOf(f2));
            }
        } else {
            float f3 = (iAbs - i2) / i2;
            if (replyCommand2 != null) {
                replyCommand2.execute(Float.valueOf(f3));
            }
        }
        float f4 = iAbs / totalScrollRange;
        if (replyCommand3 != null) {
            replyCommand3.execute(Float.valueOf(1.0f - f4));
        }
    }
}
