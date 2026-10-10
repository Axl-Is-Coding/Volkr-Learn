package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.entity.TribeDonationHistory;
import com.sandboxol.center.utils.ViewReturnTextUtils;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.fj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeContributionHistoryBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0584fj extends AbstractC0573ej {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8346b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8347c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f8349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8350f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private long j;

    public C0584fj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8346b, f8347c));
    }

    public void a(com.disabngo.blockynexus.e.b.ka.i iVar) {
        updateRegistration(0, iVar);
        this.f8312a = iVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String donationHistoryText;
        String str;
        String str2;
        String str3;
        Drawable newDonationHistoryDrawable;
        int quantity;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.disabngo.blockynexus.e.b.ka.i iVar = this.f8312a;
        long j2 = j & 7;
        String nickName = null;
        if (j2 != 0) {
            TribeDonationHistory item = iVar != null ? iVar.getItem() : null;
            int i = 0;
            if (item != null) {
                nickName = item.getNickName();
                String date = item.getDate();
                String experienceGot = item.getExperienceGot();
                String tribeCurrencyGot = item.getTribeCurrencyGot();
                int type = item.getType();
                quantity = item.getQuantity();
                str = date;
                i = type;
                str3 = tribeCurrencyGot;
                str2 = experienceGot;
            } else {
                str = null;
                str2 = null;
                str3 = null;
                quantity = 0;
            }
            newDonationHistoryDrawable = ViewReturnTextUtils.getNewDonationHistoryDrawable(i);
            donationHistoryText = ViewReturnTextUtils.getDonationHistoryText(i, quantity);
        } else {
            donationHistoryText = null;
            str = null;
            str2 = null;
            str3 = null;
            newDonationHistoryDrawable = null;
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8349e, nickName);
            androidx.databinding.a.e.a(this.f8350f, str);
            androidx.databinding.a.e.b(this.g, newDonationHistoryDrawable);
            androidx.databinding.a.e.a(this.g, donationHistoryText);
            androidx.databinding.a.e.d(this.g, newDonationHistoryDrawable);
            androidx.databinding.a.e.a(this.h, str2);
            androidx.databinding.a.e.a(this.i, str3);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ka.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ka.i) obj);
        return true;
    }

    private C0584fj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.j = -1L;
        this.f8348d = (LinearLayout) objArr[0];
        this.f8348d.setTag(null);
        this.f8349e = (TextView) objArr[1];
        this.f8349e.setTag(null);
        this.f8350f = (TextView) objArr[2];
        this.f8350f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ka.i iVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.j |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }
}
