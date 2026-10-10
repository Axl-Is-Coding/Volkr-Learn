package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.FollowFriendRecyclerView;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ca, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentCategoryFollowFriendsBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0541ca extends AbstractC0529ba {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8215d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8216e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8217f;
    private final RelativeLayout g;
    private final TextView h;
    private final FollowFriendRecyclerView i;
    private final TextView j;
    private long k;

    static {
        f8216e.put(R.id.img, 5);
        f8216e.put(R.id.img1, 6);
    }

    public C0541ca(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8215d, f8216e));
    }

    public void a(com.disabngo.blockynexus.view.fragment.main.U u) {
        updateRegistration(0, u);
        this.f8187c = u;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(265);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.view.fragment.main.S s;
        int i;
        ReplyCommand replyCommand2;
        int i2;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.view.fragment.main.U u = this.f8187c;
        long j2 = j & 7;
        if (j2 != 0) {
            if ((j & 5) == 0 || u == null) {
                replyCommand = null;
                s = null;
                replyCommand2 = null;
            } else {
                com.disabngo.blockynexus.view.fragment.main.S s2 = u.f11798a;
                replyCommand = u.f11802e;
                replyCommand2 = u.f11801d;
                s = s2;
            }
            ObservableField<Boolean> observableField = u != null ? u.f11800c : null;
            updateRegistration(1, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j2 != 0) {
                j |= zSafeUnbox ? 16L : 8L;
            }
            i = zSafeUnbox ? 0 : 8;
        } else {
            replyCommand = null;
            s = null;
            i = 0;
            replyCommand2 = null;
        }
        long j3 = j & 4;
        if (j3 != 0) {
            boolean zIsBeta = ChannelManager.isBeta();
            if (j3 != 0) {
                j |= zIsBeta ? 64L : 32L;
            }
            i2 = zIsBeta ? 8 : 0;
        } else {
            i2 = 0;
        }
        if ((4 & j) != 0) {
            this.f8217f.setVisibility(i2);
        }
        if ((7 & j) != 0) {
            this.g.setVisibility(i);
            this.i.setVisibility(i);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
            com.disabngo.blockynexus.adapter.c.a(this.i, s);
            ViewBindingAdapters.clickCommand(this.j, replyCommand2, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.fragment.main.U) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (265 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.main.U) obj);
        return true;
    }

    private C0541ca(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[5], (ImageView) objArr[6]);
        this.k = -1L;
        this.f8217f = (LinearLayout) objArr[0];
        this.f8217f.setTag(null);
        this.g = (RelativeLayout) objArr[1];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (FollowFriendRecyclerView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.main.U u, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
