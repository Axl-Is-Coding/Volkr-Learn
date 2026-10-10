package com.disabngo.blockynexus.e.b.ua;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.DateUtils;
import java.util.TimerTask;

/* JADX INFO: compiled from: TribeTaskPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class q extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f10229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f10230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ r f10231d;

    q(r rVar, int i, ObservableField observableField, Context context) {
        this.f10231d = rVar;
        this.f10228a = i;
        this.f10229b = observableField;
        this.f10230c = context;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f10228a == 1 && this.f10231d.g.get().intValue() > 0) {
            ObservableField<Integer> observableField = this.f10231d.g;
            observableField.set(Integer.valueOf(observableField.get().intValue() - 1));
        }
        if (this.f10228a == 1 && this.f10231d.g.get().intValue() == 0) {
            this.f10231d.f10237f.set(0);
        }
        if (((Long) this.f10231d.f10233b.get()).longValue() > 0) {
            this.f10231d.f10233b.set(Long.valueOf(((Long) this.f10231d.f10233b.get()).longValue() - 1000));
            ObservableField observableField2 = this.f10229b;
            if (observableField2 != null) {
                observableField2.set(this.f10230c.getString(R.string.tribe_task_time, DateUtils.HoursFormatDuring(((Long) this.f10231d.f10233b.get()).longValue())));
            }
        }
    }
}
