package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.l.C0868d;
import com.disabngo.blockynexus.view.fragment.main.MainFragmentViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: FragmentMainBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ee extends De {
    private static final ViewDataBinding.b i = new ViewDataBinding.b(8);
    private static final SparseIntArray j;
    private final CoordinatorLayout k;
    private final PageRecyclerView l;
    private long m;

    static {
        i.a(2, new String[]{"content_header1"}, new int[]{5}, new int[]{R.layout.content_header1});
        i.a(3, new String[]{"content_header", "content_header2"}, new int[]{6, 7}, new int[]{R.layout.content_header, R.layout.content_header2});
        j = null;
    }

    public Ee(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, i, j));
    }

    @Override // com.disabngo.blockynexus.databinding.De
    public void a(MainFragmentViewModel mainFragmentViewModel) {
        updateRegistration(3, mainFragmentViewModel);
        this.g = mainFragmentViewModel;
        synchronized (this) {
            this.m |= 8;
        }
        notifyPropertyChanged(370);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        int i2;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        com.disabngo.blockynexus.view.fragment.main.G g;
        C0868d c0868d;
        ItemEnterOrExitVisibleHelper.OnScrollStatusListener onScrollStatusListener;
        com.disabngo.blockynexus.view.fragment.main.G g2;
        ItemEnterOrExitVisibleHelper.OnScrollStatusListener onScrollStatusListener2;
        C0868d c0868d2;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.m;
            this.m = 0L;
        }
        MainFragmentViewModel mainFragmentViewModel = this.g;
        com.disabngo.blockynexus.view.activity.main.nc ncVar = this.h;
        long j5 = j2 & 73;
        if (j5 != 0) {
            if ((j2 & 72) == 0 || mainFragmentViewModel == null) {
                g2 = null;
                onScrollStatusListener2 = null;
                c0868d2 = null;
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
            } else {
                ReplyCommand replyCommand4 = mainFragmentViewModel.closeHeaderCommand;
                com.disabngo.blockynexus.view.fragment.main.G g3 = mainFragmentViewModel.moreGameListLayout;
                ItemEnterOrExitVisibleHelper.OnScrollStatusListener onScrollStatusListener3 = mainFragmentViewModel.itemListener;
                C0868d c0868d3 = mainFragmentViewModel.moreGameModel;
                ReplyCommand replyCommand5 = mainFragmentViewModel.openHeaderCommand;
                onScrollStatusListener2 = onScrollStatusListener3;
                g2 = g3;
                replyCommand2 = replyCommand4;
                replyCommand3 = mainFragmentViewModel.contentChangeCommand;
                replyCommand = replyCommand5;
                c0868d2 = c0868d3;
            }
            ObservableField<Boolean> observableField = mainFragmentViewModel != null ? mainFragmentViewModel.isOpenHeader : null;
            updateRegistration(0, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j5 != 0) {
                if (zSafeUnbox) {
                    j3 = j2 | 256;
                    j4 = 1024;
                } else {
                    j3 = j2 | 128;
                    j4 = 512;
                }
                j2 = j3 | j4;
            }
            i2 = zSafeUnbox ? 8 : 0;
            i = zSafeUnbox ? 0 : 8;
            g = g2;
            onScrollStatusListener = onScrollStatusListener2;
            c0868d = c0868d2;
        } else {
            i2 = 0;
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            g = null;
            c0868d = null;
            onScrollStatusListener = null;
        }
        long j6 = 96 & j2;
        if ((72 & j2) != 0) {
            com.disabngo.blockynexus.binding.adapter.e.a(this.f7380a, replyCommand, replyCommand2, replyCommand3);
            this.f7381b.a(mainFragmentViewModel);
            this.f7382c.a(mainFragmentViewModel);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.l, g, c0868d, null, true, false, false, 3, 3, false, onScrollStatusListener);
        }
        if ((j2 & 73) != 0) {
            this.f7382c.getRoot().setVisibility(i2);
            this.f7383d.getRoot().setVisibility(i);
        }
        if (j6 != 0) {
            this.f7382c.a(ncVar);
            this.f7383d.a(ncVar);
        }
        ViewDataBinding.executeBindingsOn(this.f7381b);
        ViewDataBinding.executeBindingsOn(this.f7383d);
        ViewDataBinding.executeBindingsOn(this.f7382c);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return this.f7381b.hasPendingBindings() || this.f7383d.hasPendingBindings() || this.f7382c.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 64L;
        }
        this.f7381b.invalidateAll();
        this.f7383d.invalidateAll();
        this.f7382c.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a((ObservableField<Boolean>) obj, i3);
        }
        if (i2 == 1) {
            return a((AbstractC0640la) obj, i3);
        }
        if (i2 == 2) {
            return a((AbstractC0662na) obj, i3);
        }
        if (i2 == 3) {
            return a((MainFragmentViewModel) obj, i3);
        }
        if (i2 == 4) {
            return a((AbstractC0618ja) obj, i3);
        }
        if (i2 != 5) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.f7381b.setLifecycleOwner(gVar);
        this.f7383d.setLifecycleOwner(gVar);
        this.f7382c.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (370 == i2) {
            a((MainFragmentViewModel) obj);
        } else {
            if (301 != i2) {
                return false;
            }
            a((com.disabngo.blockynexus.view.activity.main.nc) obj);
        }
        return true;
    }

    private Ee(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (AppBarLayout) objArr[1], (AbstractC0618ja) objArr[5], (AbstractC0640la) objArr[7], (AbstractC0662na) objArr[6], (Toolbar) objArr[3], (CollapsingToolbarLayout) objArr[2]);
        this.m = -1L;
        this.f7380a.setTag(null);
        this.k = (CoordinatorLayout) objArr[0];
        this.k.setTag(null);
        this.l = (PageRecyclerView) objArr[4];
        this.l.setTag(null);
        this.f7384e.setTag(null);
        this.f7385f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // com.disabngo.blockynexus.databinding.De
    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        updateRegistration(5, ncVar);
        this.h = ncVar;
        synchronized (this) {
            this.m |= 32;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    private boolean a(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(AbstractC0640la abstractC0640la, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean a(AbstractC0662na abstractC0662na, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean a(MainFragmentViewModel mainFragmentViewModel, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean a(AbstractC0618ja abstractC0618ja, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }
}
