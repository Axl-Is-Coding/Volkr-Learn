package com.sandboxol.common.widget.rv.pagerv;

import android.content.Context;
import com.sandboxol.common.R;
import com.sandboxol.common.base.viewmodel.ListViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.HttpUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public class PageListViewModel<T> extends ListViewModel<T> {
    private int defaultPage;
    public me.tatarka.bindingcollectionadapter2.d<T> factory;
    private IChangePosition iChangePosition;
    private boolean isMore;
    private boolean isReplace;
    private int maxPage;
    private int page;
    private Map<Integer, List<T>> pageDatas;
    private int size;

    /* JADX INFO: renamed from: com.sandboxol.common.widget.rv.pagerv.PageListViewModel$1, reason: invalid class name */
    class AnonymousClass1 extends OnResponseListener<PageData<T>> {
        final /* synthetic */ boolean val$isRefresh;

        AnonymousClass1(boolean z) {
            this.val$isRefresh = z;
        }

        public /* synthetic */ void b(PageData pageData) {
            PageListViewModel.this.onAddOrReplace(pageData, true);
        }

        public /* synthetic */ void d(PageData pageData) {
            PageListViewModel.this.onAddOrReplace(pageData, false);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onError(int i, String str) {
            PageListViewModel.this.onError(null);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onServerError(int i) {
            PageListViewModel pageListViewModel = PageListViewModel.this;
            pageListViewModel.onError(HttpUtils.getHttpErrorMsg(((ListViewModel) pageListViewModel).context, i));
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onSuccess(PageData<T> pageData) {
            if (pageData != null) {
                if (PageListViewModel.this.isMore && pageData.getTotalPage() > 0) {
                    PageListViewModel.this.isMore = pageData.getPageNo() < pageData.getTotalPage() - 1;
                }
                PageListViewModel pageListViewModel = PageListViewModel.this;
                pageListViewModel.setLoadingMore(pageListViewModel.isMore);
                if (this.val$isRefresh) {
                    Observable.just(pageData).filter(new Func1() { // from class: com.sandboxol.common.widget.rv.pagerv.c
                        @Override // rx.functions.Func1
                        public final Object call(Object obj) {
                            return Boolean.valueOf(((PageData) obj).getData() != null);
                        }
                    }).subscribe(new Action1() { // from class: com.sandboxol.common.widget.rv.pagerv.d
                        @Override // rx.functions.Action1
                        public final void call(Object obj) {
                            this.f16949a.b((PageData) obj);
                        }
                    }, new Action1() { // from class: com.sandboxol.common.widget.rv.pagerv.e
                        @Override // rx.functions.Action1
                        public final void call(Object obj) {
                            ((Throwable) obj).printStackTrace();
                        }
                    });
                } else {
                    Observable.just(pageData).filter(new Func1() { // from class: com.sandboxol.common.widget.rv.pagerv.b
                        @Override // rx.functions.Func1
                        public final Object call(Object obj) {
                            return Boolean.valueOf(((PageData) obj).getData() != null);
                        }
                    }).subscribe(new Action1() { // from class: com.sandboxol.common.widget.rv.pagerv.a
                        @Override // rx.functions.Action1
                        public final void call(Object obj) {
                            this.f16946a.d((PageData) obj);
                        }
                    }, new Action1() { // from class: com.sandboxol.common.widget.rv.pagerv.e
                        @Override // rx.functions.Action1
                        public final void call(Object obj) {
                            ((Throwable) obj).printStackTrace();
                        }
                    });
                }
            }
            PageListViewModel.this.onSuccess();
        }
    }

    interface IChangePosition {
        void onMoveToHead();
    }

    public PageListViewModel(Context context, PageListModel pageListModel, int i, int i2, int i3) {
        super(context, pageListModel);
        this.page = 0;
        this.size = 10;
        this.maxPage = Integer.MAX_VALUE;
        this.defaultPage = 0;
        this.pageDatas = new HashMap();
        this.defaultPage = i;
        this.size = i2;
        this.maxPage = i3;
        onRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAddOrReplace(PageData<T> pageData, boolean z) {
        IChangePosition iChangePosition;
        if (z) {
            this.pageDatas.clear();
        }
        this.pageDatas.put(Integer.valueOf(pageData.getPageNo()), pageData.getData());
        this.page = pageData.getPageNo();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.pageDatas.size(); i++) {
            List<T> list = this.pageDatas.get(Integer.valueOf(i));
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        replaceData(arrayList);
        if (!z || (iChangePosition = this.iChangePosition) == null) {
            return;
        }
        iChangePosition.onMoveToHead();
    }

    protected void loadData(int i, boolean z) {
        if (this.model != null) {
            showEmptyView(this.context.getResources().getString(R.string.data_loading));
            ((PageListModel) this.model).onLoad(i, this.size, new AnonymousClass1(z));
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void onLoadMore() {
        if (this.isMore) {
            this.page++;
            int i = this.page;
            if (i < this.maxPage) {
                loadData(i, false);
            } else {
                this.isMore = false;
                setLoadingMore(this.isMore);
            }
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void onRefresh() {
        this.isMore = true;
        this.page = this.defaultPage;
        setRefreshing(true);
        setLoadingMore(this.isMore);
        loadData(this.page, true);
    }

    public void setiChangePosition(IChangePosition iChangePosition) {
        this.iChangePosition = iChangePosition;
    }

    public PageListViewModel(Context context, PageListModel pageListModel, int i, int i2, int i3, boolean z) {
        super(context, pageListModel);
        this.page = 0;
        this.size = 10;
        this.maxPage = Integer.MAX_VALUE;
        this.defaultPage = 0;
        this.pageDatas = new HashMap();
        this.defaultPage = i;
        this.size = i2;
        this.maxPage = i3;
        this.isReplace = z;
        onRefresh();
    }

    public PageListViewModel(Context context, PageListModel pageListModel, int i, int i2, int i3, boolean z, int i4) {
        super(context, pageListModel);
        this.page = 0;
        this.size = 10;
        this.maxPage = Integer.MAX_VALUE;
        this.defaultPage = 0;
        this.pageDatas = new HashMap();
        this.defaultPage = i;
        this.size = i2;
        this.isReplace = z;
        this.maxPage = i3;
        if (i4 != 0) {
            this.factory = new TopCountAdapter(context, i4);
        }
        onRefresh();
    }
}
