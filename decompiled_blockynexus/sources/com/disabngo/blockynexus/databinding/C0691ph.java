package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.CareerPentagonView;
import com.sandboxol.greendao.entity.UserGameCareerInfo;
import java.util.HashMap;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ph, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemFriendMatchCareerBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0691ph extends AbstractC0680oh {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8696b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8697c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f8699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CareerPentagonView f8700f;
    private final LinearLayout g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final LinearLayout m;
    private long n;

    public C0691ph(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, f8696b, f8697c));
    }

    public void a(com.disabngo.blockynexus.view.activity.friends.N n) {
        updateRegistration(0, n);
        this.f8667a = n;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(482);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String victoryRateText;
        String str;
        String str2;
        String averageTimeText;
        String completeRateText;
        int i;
        int i2;
        HashMap<String, Long> gameTimeMap;
        int totalTime;
        int killCount;
        long j2;
        long j3;
        synchronized (this) {
            j = this.n;
            this.n = 0L;
        }
        com.disabngo.blockynexus.view.activity.friends.N n = this.f8667a;
        long j4 = j & 3;
        HashMap<String, Long> map = null;
        String totalTimeText = null;
        if (j4 != 0) {
            UserGameCareerInfo userGameCareerInfo = n != null ? n.f10659a : null;
            if (userGameCareerInfo != null) {
                totalTimeText = userGameCareerInfo.getTotalTimeText();
                gameTimeMap = userGameCareerInfo.getGameTimeMap();
                averageTimeText = userGameCareerInfo.getAverageTimeText();
                completeRateText = userGameCareerInfo.getCompleteRateText();
                totalTime = userGameCareerInfo.getTotalTime();
                killCount = userGameCareerInfo.getKillCount();
                victoryRateText = userGameCareerInfo.getVictoryRateText();
            } else {
                victoryRateText = null;
                gameTimeMap = null;
                averageTimeText = null;
                completeRateText = null;
                totalTime = 0;
                killCount = 0;
            }
            boolean z = totalTime == 0;
            String strValueOf = String.valueOf(killCount);
            if (j4 != 0) {
                if (z) {
                    j2 = j | 8;
                    j3 = 32;
                } else {
                    j2 = j | 4;
                    j3 = 16;
                }
                j = j2 | j3;
            }
            i = z ? 8 : 0;
            str = strValueOf;
            str2 = totalTimeText;
            map = gameTimeMap;
            i2 = z ? 0 : 8;
        } else {
            victoryRateText = null;
            str = null;
            str2 = null;
            averageTimeText = null;
            completeRateText = null;
            i = 0;
            i2 = 0;
        }
        if ((j & 3) != 0) {
            this.f8699e.setVisibility(i);
            com.disabngo.blockynexus.binding.adapter.h.a(this.f8700f, map);
            this.g.setVisibility(i);
            androidx.databinding.a.e.a(this.h, completeRateText);
            androidx.databinding.a.e.a(this.i, victoryRateText);
            androidx.databinding.a.e.a(this.j, str);
            androidx.databinding.a.e.a(this.k, averageTimeText);
            androidx.databinding.a.e.a(this.l, str2);
            this.m.setVisibility(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.friends.N) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (482 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.friends.N) obj);
        return true;
    }

    private C0691ph(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.n = -1L;
        this.f8698d = (LinearLayout) objArr[0];
        this.f8698d.setTag(null);
        this.f8699e = (LinearLayout) objArr[1];
        this.f8699e.setTag(null);
        this.f8700f = (CareerPentagonView) objArr[2];
        this.f8700f.setTag(null);
        this.g = (LinearLayout) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (TextView) objArr[6];
        this.j.setTag(null);
        this.k = (TextView) objArr[7];
        this.k.setTag(null);
        this.l = (TextView) objArr[8];
        this.l.setTag(null);
        this.m = (LinearLayout) objArr[9];
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.friends.N n, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }
}
