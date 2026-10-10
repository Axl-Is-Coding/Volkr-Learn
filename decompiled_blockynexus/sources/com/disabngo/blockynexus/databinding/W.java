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

/* JADX INFO: compiled from: CategoryPageListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class W extends V {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7985c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7986d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SmartRefreshLayout f7988f;
    private long g;

    public W(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7985c, f7986d));
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.g     // Catch: java.lang.Throwable -> Lb7
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> Lb7
            monitor-exit(r26)     // Catch: java.lang.Throwable -> Lb7
            com.sandboxol.common.widget.rv.pagerv.PageListViewModel r0 = r1.f7950b
            r6 = 63
            long r6 = r6 & r2
            r8 = 38
            r10 = 51
            r12 = 43
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L86
            r6 = 59
            long r6 = r6 & r2
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L47
            if (r0 == 0) goto L26
            com.sandboxol.common.widget.rv.ListViewStyle r6 = r0.viewStyle
            goto L27
        L26:
            r6 = 0
        L27:
            r1.updateRegistration(r14, r6)
            long r16 = r2 & r12
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L37
            if (r6 == 0) goto L37
            boolean r7 = r6.isLoadingMore()
            goto L38
        L37:
            r7 = 0
        L38:
            long r16 = r2 & r10
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L46
            if (r6 == 0) goto L46
            boolean r6 = r6.isRefreshing()
            r14 = r7
            goto L48
        L46:
            r14 = r7
        L47:
            r6 = 0
        L48:
            long r16 = r2 & r8
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L63
            if (r0 == 0) goto L57
            androidx.databinding.ObservableList r7 = r0.getItemViewModel()
            me.tatarka.bindingcollectionadapter2.g<com.sandboxol.common.base.viewmodel.ListItemViewModel<T>> r15 = r0.itemBinding
            goto L59
        L57:
            r7 = 0
            r15 = 0
        L59:
            r8 = 2
            r1.updateRegistration(r8, r7)
            r25 = r15
            r15 = r7
            r7 = r25
            goto L65
        L63:
            r7 = 0
            r15 = 0
        L65:
            long r8 = r2 & r12
            int r19 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r19 == 0) goto L70
            if (r0 == 0) goto L70
            com.sandboxol.common.command.ReplyCommand<java.lang.Integer> r8 = r0.onLoadMoreCommand
            goto L71
        L70:
            r8 = 0
        L71:
            long r19 = r2 & r10
            int r9 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r9 == 0) goto L80
            if (r0 == 0) goto L80
            com.sandboxol.common.command.ReplyCommand r0 = r0.onRefreshCommand
            r20 = r7
            r21 = r15
            goto L8d
        L80:
            r20 = r7
            r21 = r15
            r0 = 0
            goto L8d
        L86:
            r0 = 0
            r6 = 0
            r8 = 0
            r20 = 0
            r21 = 0
        L8d:
            long r12 = r12 & r2
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 == 0) goto L97
            com.scwang.smartrefresh.layout.SmartRefreshLayout r7 = r1.f7988f
            com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters.onLoadMoreCommand(r7, r8, r14)
        L97:
            long r7 = r2 & r10
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto La2
            com.scwang.smartrefresh.layout.SmartRefreshLayout r7 = r1.f7988f
            com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters.onRefreshCommand(r7, r0, r6)
        La2:
            r6 = 38
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lb6
            androidx.recyclerview.widget.RecyclerView r0 = r1.f7949a
            r22 = 0
            r23 = 0
            r24 = 0
            r19 = r0
            me.tatarka.bindingcollectionadapter2.e.a(r19, r20, r21, r22, r23, r24)
        Lb6:
            return
        Lb7:
            r0 = move-exception
            monitor-exit(r26)     // Catch: java.lang.Throwable -> Lb7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.W.executeBindings():void");
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
        this.f7950b = pageListViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private W(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[2]);
        this.g = -1L;
        this.f7987e = (RelativeLayout) objArr[0];
        this.f7987e.setTag(null);
        this.f7988f = (SmartRefreshLayout) objArr[1];
        this.f7988f.setTag(null);
        this.f7949a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
