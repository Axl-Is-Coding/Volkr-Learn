package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.view.fragment.main.MainFragmentViewModel;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.qg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GameMoreDataListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0701qg extends AbstractC0690pg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8731c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8732d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f8734f;
    private final SmartRefreshLayout g;
    private long h;

    public C0701qg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8731c, f8732d));
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    private boolean onChangeViewModel(PageListViewModel pageListViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i == 246) {
            synchronized (this) {
                this.h |= 16;
            }
            return true;
        }
        if (i == 245) {
            synchronized (this) {
                this.h |= 32;
            }
            return true;
        }
        if (i != 247) {
            return false;
        }
        synchronized (this) {
            this.h |= 64;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        boolean zIsRefreshing;
        String str;
        boolean z2;
        ReplyCommand<Integer> replyCommand;
        boolean z3;
        ReplyCommand replyCommand2;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        me.tatarka.bindingcollectionadapter2.d dVar;
        boolean zSafeUnbox;
        String emptyText;
        ObservableList observableList2;
        boolean z4;
        me.tatarka.bindingcollectionadapter2.g gVar2;
        me.tatarka.bindingcollectionadapter2.d dVar2;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        PageListViewModel pageListViewModel = this.f8695b;
        if ((251 & j) != 0) {
            ListViewStyle listViewStyle = pageListViewModel != null ? pageListViewModel.viewStyle : null;
            updateRegistration(0, listViewStyle);
            boolean zIsLoadingMore = ((j & 195) == 0 || listViewStyle == null) ? false : listViewStyle.isLoadingMore();
            long j2 = j & 187;
            if (j2 == 0 || listViewStyle == null) {
                zIsRefreshing = false;
                emptyText = null;
            } else {
                emptyText = listViewStyle.getEmptyText();
                zIsRefreshing = listViewStyle.isRefreshing();
            }
            if (j2 != 0) {
                ObservableList itemViewModel = pageListViewModel != null ? pageListViewModel.getItemViewModel() : null;
                updateRegistration(3, itemViewModel);
                boolean z5 = (itemViewModel != null ? itemViewModel.size() : 0) > 0;
                if (j2 != 0) {
                    j |= z5 ? 512L : 256L;
                }
                boolean z6 = !z5;
                boolean z7 = z5;
                observableList2 = itemViewModel;
                z2 = z6;
                z4 = z7;
            } else {
                z2 = false;
                observableList2 = null;
                z4 = false;
            }
            ReplyCommand replyCommand3 = ((j & 163) == 0 || pageListViewModel == null) ? null : pageListViewModel.onRefreshCommand;
            if ((j & 138) == 0 || pageListViewModel == null) {
                gVar2 = null;
                dVar2 = null;
            } else {
                gVar2 = pageListViewModel.itemBinding;
                dVar2 = pageListViewModel.factory;
            }
            if ((j & 195) == 0 || pageListViewModel == null) {
                observableList = observableList2;
                gVar = gVar2;
                dVar = dVar2;
                z = z4;
                replyCommand = null;
                replyCommand2 = replyCommand3;
            } else {
                observableList = observableList2;
                gVar = gVar2;
                dVar = dVar2;
                replyCommand = pageListViewModel.onLoadMoreCommand;
                replyCommand2 = replyCommand3;
                z = z4;
            }
            z3 = zIsLoadingMore;
            str = emptyText;
        } else {
            z = false;
            zIsRefreshing = false;
            str = null;
            z2 = false;
            replyCommand = null;
            z3 = false;
            replyCommand2 = null;
            gVar = null;
            observableList = null;
            dVar = null;
        }
        long j3 = 132 & j;
        if (j3 != 0) {
            ObservableField<Boolean> observableField = MainFragmentViewModel.isRefreshing;
            updateRegistration(2, observableField);
            zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
        } else {
            zSafeUnbox = false;
        }
        if ((j & 187) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f8734f, str, z, zIsRefreshing, z2);
        }
        if (j3 != 0) {
            SmartRefreshLayoutBindingAdapters.onEnableRefresh(this.g, zSafeUnbox);
        }
        if ((195 & j) != 0) {
            SmartRefreshLayoutBindingAdapters.onLoadMoreCommand(this.g, replyCommand, z3);
        }
        if ((163 & j) != 0) {
            SmartRefreshLayoutBindingAdapters.onRefreshCommand(this.g, replyCommand2, zIsRefreshing);
        }
        if ((j & 138) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f8694a, gVar, observableList, dVar, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelViewStyle((ListViewStyle) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModel((PageListViewModel) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeViewModelItemViewModel((ObservableList) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        setViewModel((PageListViewModel) obj);
        return true;
    }

    public void setViewModel(PageListViewModel pageListViewModel) {
        updateRegistration(1, pageListViewModel);
        this.f8695b = pageListViewModel;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private C0701qg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (RecyclerView) objArr[3]);
        this.h = -1L;
        this.f8733e = (RelativeLayout) objArr[0];
        this.f8733e.setTag(null);
        this.f8734f = (PageLoadingView) objArr[1];
        this.f8734f.setTag(null);
        this.g = (SmartRefreshLayout) objArr[2];
        this.g.setTag(null);
        this.f8694a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
