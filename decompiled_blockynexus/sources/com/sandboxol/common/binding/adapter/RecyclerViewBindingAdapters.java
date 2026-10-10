package com.sandboxol.common.binding.adapter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.R;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.SizeUtil;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerViewBindingAdapters {

    public static class OnScrollListener extends RecyclerView.m {
        private PublishSubject<Integer> methodInvoke = PublishSubject.create();
        private ReplyCommand<Integer> onLoadMoreCommand;

        public OnScrollListener(final ReplyCommand<Integer> replyCommand) {
            this.onLoadMoreCommand = replyCommand;
            Observable<Integer> observableThrottleFirst = this.methodInvoke.throttleFirst(1L, TimeUnit.SECONDS);
            replyCommand.getClass();
            observableThrottleFirst.subscribe(new Action1() { // from class: com.sandboxol.common.binding.adapter.i
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    replyCommand.execute((Integer) obj);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int childCount = linearLayoutManager.getChildCount();
            if (childCount + linearLayoutManager.findFirstVisibleItemPosition() < linearLayoutManager.getItemCount() || this.onLoadMoreCommand == null) {
                return;
            }
            this.methodInvoke.onNext(Integer.valueOf(recyclerView.getAdapter().getItemCount()));
        }
    }

    public static class ScrollDataWrapper {
        public float scrollX;
        public float scrollY;
        public int state;

        public ScrollDataWrapper(float f2, float f3, int i) {
            this.scrollX = f2;
            this.scrollY = f3;
            this.state = i;
        }
    }

    public static void nestedScrollingEnabled(RecyclerView recyclerView, boolean z) {
        recyclerView.setNestedScrollingEnabled(z);
    }

    public static void onLoadMoreCommand(RecyclerView recyclerView, ReplyCommand<Integer> replyCommand) {
        OnScrollListener onScrollListener = new OnScrollListener(replyCommand);
        recyclerView.clearOnScrollListeners();
        recyclerView.addOnScrollListener(onScrollListener);
    }

    public static void onScrollChangeCommand(RecyclerView recyclerView, final ReplyCommand<ScrollDataWrapper> replyCommand, final ReplyCommand<Integer> replyCommand2) {
        recyclerView.addOnScrollListener(new RecyclerView.m() { // from class: com.sandboxol.common.binding.adapter.RecyclerViewBindingAdapters.1
            private int state;

            @Override // androidx.recyclerview.widget.RecyclerView.m
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                super.onScrollStateChanged(recyclerView2, i);
                this.state = i;
                ReplyCommand replyCommand3 = replyCommand2;
                if (replyCommand3 != null) {
                    replyCommand3.execute(Integer.valueOf(this.state));
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.m
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                ReplyCommand replyCommand3 = replyCommand;
                if (replyCommand3 != null) {
                    replyCommand3.execute(new ScrollDataWrapper(i, i2, this.state));
                }
            }
        });
    }

    public static void setItemDecoration(final RecyclerView recyclerView, int i, final int i2, final int i3, final int i4) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (i == 0) {
            paint.setColor(recyclerView.getContext().getResources().getColor(R.color.mainBgColor));
        } else {
            paint.setColor(recyclerView.getContext().getResources().getColor(i));
        }
        recyclerView.addItemDecoration(new RecyclerView.h() { // from class: com.sandboxol.common.binding.adapter.RecyclerViewBindingAdapters.2
            @Override // androidx.recyclerview.widget.RecyclerView.h
            public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.t tVar) {
                super.onDrawOver(canvas, recyclerView2, tVar);
                int childCount = recyclerView2.getChildCount();
                for (int i5 = 0; i5 < childCount - 1; i5++) {
                    View childAt = recyclerView2.getChildAt(i5);
                    canvas.drawRect(childAt.getLeft() + SizeUtil.dp2px(recyclerView.getContext(), i3), childAt.getBottom() - SizeUtil.dp2px(recyclerView.getContext(), i2), childAt.getRight() - SizeUtil.dp2px(recyclerView.getContext(), i4), childAt.getBottom(), paint);
                }
            }
        });
    }

    public static void setLayoutManager(RecyclerView recyclerView, int i) {
        if (i == 0 || i == 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), i, false));
        }
    }
}
