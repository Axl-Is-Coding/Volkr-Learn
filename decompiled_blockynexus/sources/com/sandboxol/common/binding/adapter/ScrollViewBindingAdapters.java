package com.sandboxol.common.binding.adapter;

import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class ScrollViewBindingAdapters {

    public static class NestScrollDataWrapper {
        public int oldScrollX;
        public int oldScrollY;
        public int scrollX;
        public int scrollY;

        public NestScrollDataWrapper(int i, int i2, int i3, int i4) {
            this.scrollX = i;
            this.scrollY = i2;
            this.oldScrollX = i3;
            this.oldScrollY = i4;
        }
    }

    public static class ScrollDataWrapper {
        public float scrollX;
        public float scrollY;

        public ScrollDataWrapper(float f2, float f3) {
            this.scrollX = f2;
            this.scrollY = f3;
        }
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, ScrollView scrollView) {
        if (replyCommand != null) {
            replyCommand.execute(new ScrollDataWrapper(scrollView.getScaleX(), scrollView.getScrollY()));
        }
    }

    public static void onScrollChangeCommand(NestedScrollView nestedScrollView, final ReplyCommand<NestScrollDataWrapper> replyCommand) {
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b() { // from class: com.sandboxol.common.binding.adapter.ScrollViewBindingAdapters.1
            @Override // androidx.core.widget.NestedScrollView.b
            public void onScrollChange(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
                ReplyCommand replyCommand2 = replyCommand;
                if (replyCommand2 != null) {
                    replyCommand2.execute(new NestScrollDataWrapper(i, i2, i3, i4));
                }
            }
        });
    }

    public static void onScrollChangeCommand(final ScrollView scrollView, final ReplyCommand<ScrollDataWrapper> replyCommand) {
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.sandboxol.common.binding.adapter.h
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                ScrollViewBindingAdapters.a(replyCommand, scrollView);
            }
        });
    }
}
