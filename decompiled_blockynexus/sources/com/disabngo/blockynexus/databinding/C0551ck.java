package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ck, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ScrapHistoryListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0551ck extends AbstractC0539bk {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8243c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8244d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SmartRefreshLayout f8246f;
    private long g;

    public C0551ck(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8243c, f8244d));
    }

    private boolean onChangeViewModel(PageListViewModel pageListViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i == 247) {
            synchronized (this) {
                this.g |= 8;
            }
            return true;
        }
        if (i != 245) {
            return false;
        }
        synchronized (this) {
            this.g |= 16;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.g     // Catch: java.lang.Throwable -> Lc0
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> Lc0
            monitor-exit(r24)     // Catch: java.lang.Throwable -> Lc0
            com.sandboxol.common.widget.rv.pagerv.PageListViewModel r0 = r1.f8211b
            r6 = 63
            long r6 = r6 & r2
            r8 = 38
            r10 = 51
            r12 = 43
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L8e
            long r6 = r2 & r8
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L38
            if (r0 == 0) goto L2b
            me.tatarka.bindingcollectionadapter2.d<T> r6 = r0.factory
            androidx.databinding.ObservableList r7 = r0.getItemViewModel()
            me.tatarka.bindingcollectionadapter2.g<com.sandboxol.common.base.viewmodel.ListItemViewModel<T>> r15 = r0.itemBinding
            goto L2e
        L2b:
            r6 = 0
            r7 = 0
            r15 = 0
        L2e:
            r8 = 2
            r1.updateRegistration(r8, r7)
            r23 = r15
            r15 = r6
            r6 = r23
            goto L3b
        L38:
            r6 = 0
            r7 = 0
            r15 = 0
        L3b:
            r8 = 59
            long r8 = r8 & r2
            int r17 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r17 == 0) goto L68
            if (r0 == 0) goto L47
            com.sandboxol.common.widget.rv.ListViewStyle r8 = r0.viewStyle
            goto L48
        L47:
            r8 = 0
        L48:
            r1.updateRegistration(r14, r8)
            long r17 = r2 & r12
            int r9 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r9 == 0) goto L58
            if (r8 == 0) goto L58
            boolean r9 = r8.isLoadingMore()
            goto L59
        L58:
            r9 = 0
        L59:
            long r17 = r2 & r10
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L67
            if (r8 == 0) goto L67
            boolean r8 = r8.isRefreshing()
            r14 = r9
            goto L69
        L67:
            r14 = r9
        L68:
            r8 = 0
        L69:
            long r17 = r2 & r12
            int r9 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r9 == 0) goto L74
            if (r0 == 0) goto L74
            com.sandboxol.common.command.ReplyCommand<java.lang.Integer> r9 = r0.onLoadMoreCommand
            goto L75
        L74:
            r9 = 0
        L75:
            long r17 = r2 & r10
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L86
            if (r0 == 0) goto L86
            com.sandboxol.common.command.ReplyCommand r0 = r0.onRefreshCommand
            r18 = r6
            r19 = r7
            r20 = r15
            goto L97
        L86:
            r18 = r6
            r19 = r7
            r20 = r15
            r0 = 0
            goto L97
        L8e:
            r0 = 0
            r8 = 0
            r9 = 0
            r18 = 0
            r19 = 0
            r20 = 0
        L97:
            long r6 = r2 & r12
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto La2
            com.scwang.smartrefresh.layout.SmartRefreshLayout r6 = r1.f8246f
            com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters.onLoadMoreCommand(r6, r9, r14)
        La2:
            long r6 = r2 & r10
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto Lad
            com.scwang.smartrefresh.layout.SmartRefreshLayout r6 = r1.f8246f
            com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters.onRefreshCommand(r6, r0, r8)
        Lad:
            r6 = 38
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lbf
            androidx.recyclerview.widget.RecyclerView r0 = r1.f8210a
            r21 = 0
            r22 = 0
            r17 = r0
            me.tatarka.bindingcollectionadapter2.e.a(r17, r18, r19, r20, r21, r22)
        Lbf:
            return
        Lc0:
            r0 = move-exception
            monitor-exit(r24)     // Catch: java.lang.Throwable -> Lc0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0551ck.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 32L;
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
        if (i != 2) {
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
        this.f8211b = pageListViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private C0551ck(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[2]);
        this.g = -1L;
        this.f8245e = (RelativeLayout) objArr[0];
        this.f8245e.setTag(null);
        this.f8246f = (SmartRefreshLayout) objArr[1];
        this.f8246f.setTag(null);
        this.f8210a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
