package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.entity.MailInfo;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemInboxViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Rh extends Qh {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7845b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7846c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7849f;
    private final TextView g;
    private final TextView h;
    private long i;

    public Rh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f7845b, f7846c));
    }

    public void a(com.disabngo.blockynexus.e.b.L.d dVar) {
        updateRegistration(0, dVar);
        this.f7817a = dVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawableInboxMailIcon;
        String str;
        String title;
        int i;
        boolean zIsReadHasAttachmentEmail;
        int status;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.e.b.L.d dVar = this.f7817a;
        long j2 = j & 7;
        ReplyCommand replyCommand = null;
        String dataText = null;
        if (j2 != 0) {
            ReplyCommand replyCommand2 = ((j & 5) == 0 || dVar == null) ? null : dVar.f9335a;
            MailInfo item = dVar != null ? dVar.getItem() : null;
            if (item != null) {
                dataText = item.getDataText();
                title = item.getTitle();
                status = item.getStatus();
                zIsReadHasAttachmentEmail = item.isReadHasAttachmentEmail();
            } else {
                title = null;
                zIsReadHasAttachmentEmail = false;
                status = 0;
            }
            if (j2 != 0) {
                j |= zIsReadHasAttachmentEmail ? 16L : 8L;
            }
            drawableInboxMailIcon = ViewReturnTextUtils.inboxMailIcon(status);
            i = zIsReadHasAttachmentEmail ? 0 : 8;
            str = dataText;
            replyCommand = replyCommand2;
        } else {
            drawableInboxMailIcon = null;
            str = null;
            title = null;
            i = 0;
        }
        if ((5 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.f7847d, replyCommand, false, 0);
        }
        if ((j & 7) != 0) {
            androidx.databinding.a.b.a(this.f7848e, drawableInboxMailIcon);
            androidx.databinding.a.e.a(this.f7849f, title);
            this.g.setVisibility(i);
            androidx.databinding.a.e.a(this.h, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.L.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.L.d) obj);
        return true;
    }

    private Rh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.i = -1L;
        this.f7847d = (LinearLayout) objArr[0];
        this.f7847d.setTag(null);
        this.f7848e = (ImageView) objArr[1];
        this.f7848e.setTag(null);
        this.f7849f = (TextView) objArr[2];
        this.f7849f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.L.d dVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.i |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
