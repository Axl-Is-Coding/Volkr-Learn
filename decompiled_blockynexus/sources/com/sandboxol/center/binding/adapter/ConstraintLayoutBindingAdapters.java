package com.sandboxol.center.binding.adapter;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintLayoutBindingAdapters {
    public static void LongClick(ConstraintLayout constraintLayout, final ReplyCommand replyCommand) {
        constraintLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sandboxol.center.binding.adapter.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ConstraintLayoutBindingAdapters.a(replyCommand, view);
            }
        });
    }

    static /* synthetic */ boolean a(ReplyCommand replyCommand, View view) {
        replyCommand.execute();
        return true;
    }
}
