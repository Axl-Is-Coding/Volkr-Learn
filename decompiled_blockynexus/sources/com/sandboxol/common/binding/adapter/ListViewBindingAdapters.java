package com.sandboxol.common.binding.adapter;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.sandboxol.common.command.ReplyCommand;
import java.util.concurrent.TimeUnit;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: loaded from: classes3.dex */
public class ListViewBindingAdapters {

    public static class ListViewScrollDataWrapper {
        public int firstVisibleItem;
        public int scrollState;
        public int totalItemCount;
        public int visibleItemCount;

        public ListViewScrollDataWrapper(int i, int i2, int i3, int i4) {
            this.firstVisibleItem = i2;
            this.visibleItemCount = i3;
            this.totalItemCount = i4;
            this.scrollState = i;
        }
    }

    public static class OnScrollListener implements AbsListView.OnScrollListener {
        private ListView listView;
        private PublishSubject<Integer> methodInvoke = PublishSubject.create();
        private ReplyCommand<Integer> onLoadMoreCommand;

        public OnScrollListener(ListView listView, ReplyCommand<Integer> replyCommand) {
            this.onLoadMoreCommand = replyCommand;
            this.listView = listView;
            this.methodInvoke.throttleFirst(1L, TimeUnit.SECONDS).subscribe(new Action1() { // from class: com.sandboxol.common.binding.adapter.e
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f16883a.a((Integer) obj);
                }
            });
        }

        public /* synthetic */ void a(Integer num) {
            this.onLoadMoreCommand.execute(num);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 < i3 || i3 == 0 || i3 == this.listView.getHeaderViewsCount() + this.listView.getFooterViewsCount() || this.onLoadMoreCommand == null) {
                return;
            }
            this.methodInvoke.onNext(Integer.valueOf(i3));
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, AdapterView adapterView, View view, int i, long j) {
        if (replyCommand != null) {
            replyCommand.execute(Integer.valueOf(i));
        }
    }

    public static void onItemClickCommand(ListView listView, final ReplyCommand<Integer> replyCommand) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sandboxol.common.binding.adapter.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ListViewBindingAdapters.a(replyCommand, adapterView, view, i, j);
            }
        });
    }

    public static void onLoadMoreCommand(ListView listView, ReplyCommand<Integer> replyCommand) {
        listView.setOnScrollListener(new OnScrollListener(listView, replyCommand));
    }

    public static void onScrollChangeCommand(ListView listView, final ReplyCommand<ListViewScrollDataWrapper> replyCommand, final ReplyCommand<Integer> replyCommand2) {
        listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.sandboxol.common.binding.adapter.ListViewBindingAdapters.1
            private int scrollState;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ReplyCommand replyCommand3 = replyCommand;
                if (replyCommand3 != null) {
                    replyCommand3.execute(new ListViewScrollDataWrapper(this.scrollState, i, i2, i3));
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                this.scrollState = i;
                ReplyCommand replyCommand3 = replyCommand2;
                if (replyCommand3 != null) {
                    replyCommand3.execute(Integer.valueOf(i));
                }
            }
        });
    }
}
