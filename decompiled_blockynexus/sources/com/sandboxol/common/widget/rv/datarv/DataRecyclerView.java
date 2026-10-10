package com.sandboxol.common.widget.rv.datarv;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.BR;
import com.sandboxol.common.R;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.IListLayout;
import java.util.concurrent.TimeUnit;
import me.tatarka.bindingcollectionadapter2.k;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: loaded from: classes3.dex */
public class DataRecyclerView extends FrameLayout {
    private ViewDataBinding binding;
    private Context context;
    private DataListViewModel viewModel;

    public DataRecyclerView(Context context) {
        this(context, null);
    }

    public void disableSetItem(boolean z) {
        DataListViewModel dataListViewModel = this.viewModel;
        if (dataListViewModel != null) {
            dataListViewModel.setEnableSetItem(!z);
        }
    }

    public void lastVisibleListener(final ReplyCommand<Integer> replyCommand) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            final PublishSubject publishSubjectCreate = PublishSubject.create();
            Observable<T> observableThrottleFirst = publishSubjectCreate.throttleFirst(300L, TimeUnit.MILLISECONDS);
            replyCommand.getClass();
            observableThrottleFirst.subscribe(new Action1() { // from class: com.sandboxol.common.widget.rv.datarv.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    replyCommand.execute((Integer) obj);
                }
            }, new Action1() { // from class: com.sandboxol.common.widget.rv.datarv.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.m() { // from class: com.sandboxol.common.widget.rv.datarv.DataRecyclerView.1
                @Override // androidx.recyclerview.widget.RecyclerView.m
                public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                    super.onScrolled(recyclerView2, i, i2);
                    publishSubjectCreate.onNext(Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()));
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DataListViewModel dataListViewModel = this.viewModel;
        if (dataListViewModel != null) {
            dataListViewModel.onDestroy();
            this.viewModel = null;
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.scrollBy(i, i2);
        }
    }

    public void scrollToPosition(int i) {
        RecyclerView recyclerView;
        ViewDataBinding viewDataBinding = this.binding;
        if (viewDataBinding == null || viewDataBinding.getRoot() == null || (recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData)) == null) {
            return;
        }
        try {
            recyclerView.scrollToPosition(i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setItemViewCacheSize(int i) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(100);
        }
    }

    public void setLayoutFactory(k.a aVar) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(aVar.a(recyclerView));
        }
    }

    public void setListLayout(IListLayout iListLayout) {
        this.binding = iListLayout.bind(this.context, this, true);
    }

    public void setModel(DataListModel dataListModel) {
        if (this.viewModel == null) {
            this.viewModel = new DataListViewModel(this.context, dataListModel);
            this.binding.setVariable(BR.ViewModel, this.viewModel);
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(!z);
        }
    }

    public DataRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DataRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public void setModel(DataListModel dataListModel, boolean z) {
        if (this.viewModel == null) {
            this.viewModel = new DataListViewModel(this.context, dataListModel, z);
            this.binding.setVariable(BR.ViewModel, this.viewModel);
        }
    }
}
