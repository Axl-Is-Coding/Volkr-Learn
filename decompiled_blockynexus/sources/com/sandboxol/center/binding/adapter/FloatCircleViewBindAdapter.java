package com.sandboxol.center.binding.adapter;

import com.sandboxol.center.view.widget.CircleProgressView;
import com.sandboxol.center.view.widget.FloatCircleView;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class FloatCircleViewBindAdapter {
    static /* synthetic */ void a(ReplyCommand replyCommand) {
        if (replyCommand != null) {
            replyCommand.execute();
        }
    }

    public static void onClickCommand(FloatCircleView floatCircleView, final ReplyCommand replyCommand) {
        floatCircleView.setListener(new FloatCircleView.FloatCircleListener() { // from class: com.sandboxol.center.binding.adapter.b
            @Override // com.sandboxol.center.view.widget.FloatCircleView.FloatCircleListener
            public final void onClick() {
                FloatCircleViewBindAdapter.a(replyCommand);
            }
        });
    }

    public static void setProgress(CircleProgressView circleProgressView, int i) {
        circleProgressView.setProgress(i);
    }
}
