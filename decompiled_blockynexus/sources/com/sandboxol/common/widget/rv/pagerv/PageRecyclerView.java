package com.sandboxol.common.widget.rv.pagerv;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.BR;
import com.sandboxol.common.R;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: loaded from: classes3.dex */
public class PageRecyclerView extends FrameLayout {
    private ViewDataBinding binding;
    private Context context;
    private int maxPage;
    private int page;
    private int size;
    private PageListViewModel viewModel;

    class PositionChangeImpl implements PageListViewModel.IChangePosition {
        PositionChangeImpl() {
        }

        @Override // com.sandboxol.common.widget.rv.pagerv.PageListViewModel.IChangePosition
        public void onMoveToHead() {
            RecyclerView recyclerView = (RecyclerView) PageRecyclerView.this.binding.getRoot().findViewById(R.id.rvData);
            if (recyclerView == null || recyclerView.getChildCount() <= 0) {
                return;
            }
            recyclerView.scrollToPosition(0);
        }
    }

    public PageRecyclerView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.context = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageRecyclerView);
        this.page = typedArrayObtainStyledAttributes.getInteger(R.styleable.PageRecyclerView_page, 0);
        this.size = typedArrayObtainStyledAttributes.getInteger(R.styleable.PageRecyclerView_size, 10);
        this.maxPage = typedArrayObtainStyledAttributes.getInteger(R.styleable.PageRecyclerView_maxPage, 10);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void disableSetItem(boolean z) {
        PageListViewModel pageListViewModel = this.viewModel;
        if (pageListViewModel != null) {
            pageListViewModel.setEnableSetItem(!z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PageListViewModel pageListViewModel = this.viewModel;
        if (pageListViewModel != null) {
            pageListViewModel.onDestroy();
            this.viewModel = null;
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        super.setFocusable(z);
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.setFocusable(z);
        }
    }

    public void setItemListener(ItemEnterOrExitVisibleHelper.OnScrollStatusListener onScrollStatusListener) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            ItemEnterOrExitVisibleHelper itemEnterOrExitVisibleHelper = new ItemEnterOrExitVisibleHelper();
            itemEnterOrExitVisibleHelper.setRecyclerScrollListener(recyclerView);
            itemEnterOrExitVisibleHelper.setOnScrollStatusListener(onScrollStatusListener);
        }
    }

    public void setLayoutFactory(k.a aVar) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(aVar.a(recyclerView));
        }
    }

    public void setLayoutManager(RecyclerView.i iVar) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(iVar);
        }
    }

    public void setListLayout(IListLayout iListLayout) {
        this.binding = iListLayout.bind(this.context, this, true);
    }

    public void setModel(PageListModel pageListModel) {
        if (this.viewModel == null) {
            this.viewModel = new PageListViewModel(this.context, pageListModel, this.page, this.size, this.maxPage);
            this.binding.setVariable(BR.ViewModel, this.viewModel);
            this.viewModel.setiChangePosition(new PositionChangeImpl());
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        RecyclerView recyclerView = (RecyclerView) this.binding.getRoot().findViewById(R.id.rvData);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(!z);
        }
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public void setModel(PageListModel pageListModel, boolean z) {
        if (this.viewModel == null) {
            this.viewModel = new PageListViewModel(this.context, pageListModel, this.page, this.size, this.maxPage, z);
            this.binding.setVariable(BR.ViewModel, this.viewModel);
            this.viewModel.setiChangePosition(new PositionChangeImpl());
        }
    }

    public void setModel(PageListModel pageListModel, boolean z, int i) {
        if (this.viewModel == null) {
            this.viewModel = new PageListViewModel(this.context, pageListModel, this.page, this.size, this.maxPage, z, i);
            this.binding.setVariable(BR.ViewModel, this.viewModel);
            this.viewModel.setiChangePosition(new PositionChangeImpl());
        }
    }
}
