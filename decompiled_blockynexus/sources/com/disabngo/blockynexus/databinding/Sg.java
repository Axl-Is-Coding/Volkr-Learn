package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.entity.ActivityTaskTitle;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemActivityTaskTitleBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Sg extends Rg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7877b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7878c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f7879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Button f7880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f7881f;
    private final View g;
    private long h;

    public Sg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f7877b, f7878c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.activity.y yVar) {
        updateRegistration(0, yVar);
        this.f7844a = yVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        int i;
        ReplyCommand replyCommand;
        int i2;
        ObservableMap observableMap;
        ActivityTaskTitle item;
        int i3;
        boolean zIsEnable;
        String titleName;
        boolean zIsShowDivider;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.disabngo.blockynexus.view.dialog.activity.y yVar = this.f7844a;
        if ((j & 15) != 0) {
            if (yVar != null) {
                observableMap = yVar.f11517b;
                item = yVar.getItem();
            } else {
                observableMap = null;
                item = null;
            }
            updateRegistration(1, observableMap);
            updateRegistration(2, item);
            long j2 = j & 13;
            if (j2 != 0) {
                if (item != null) {
                    zIsEnable = item.isEnable();
                    titleName = item.getTitleName();
                    zIsShowDivider = item.isShowDivider();
                } else {
                    zIsEnable = false;
                    titleName = null;
                    zIsShowDivider = false;
                }
                if (j2 != 0) {
                    j |= zIsShowDivider ? 32L : 16L;
                }
                i3 = zIsShowDivider ? 0 : 8;
            } else {
                i3 = 0;
                zIsEnable = false;
                titleName = null;
            }
            boolean z2 = ViewDataBinding.safeUnbox(observableMap != null ? observableMap.get(item != null ? item.getTitleType() : null) : null) > 0;
            if ((j & 15) != 0) {
                j |= z2 ? 128L : 64L;
            }
            int i4 = z2 ? 0 : 8;
            if ((j & 9) == 0 || yVar == null) {
                i2 = i4;
                i = i3;
                z = zIsEnable;
                str = titleName;
                replyCommand = null;
            } else {
                i2 = i4;
                i = i3;
                str = titleName;
                replyCommand = yVar.f11518c;
                z = zIsEnable;
            }
        } else {
            z = false;
            str = null;
            i = 0;
            replyCommand = null;
            i2 = 0;
        }
        if ((13 & j) != 0) {
            this.f7880e.setEnabled(z);
            androidx.databinding.a.e.a(this.f7880e, str);
            this.f7881f.setVisibility(i);
        }
        if ((j & 9) != 0) {
            ViewBindingAdapters.clickCommand(this.f7880e, replyCommand, true, 0);
        }
        if ((j & 15) != 0) {
            this.g.setVisibility(i2);
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
            this.h = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.dialog.activity.y) obj, i2);
        }
        if (i == 1) {
            return a((ObservableMap<String, Integer>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ActivityTaskTitle) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.activity.y) obj);
        return true;
    }

    private Sg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.h = -1L;
        this.f7879d = (RelativeLayout) objArr[0];
        this.f7879d.setTag(null);
        this.f7880e = (Button) objArr[1];
        this.f7880e.setTag(null);
        this.f7881f = (View) objArr[2];
        this.f7881f.setTag(null);
        this.g = (View) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.activity.y yVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    private boolean a(ObservableMap<String, Integer> observableMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }

    private boolean a(ActivityTaskTitle activityTaskTitle, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }
}
