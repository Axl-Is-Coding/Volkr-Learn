package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Fc;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.entity.TribeLevelExchange;
import com.sandboxol.center.entity.TribeVipExchange;
import com.sandboxol.center.utils.LocalDataRequest;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class TribeContributionDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Fc f11386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f11387c;
    private Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f11388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f11389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<String> f11390f;

    public interface a {
        void a(int i);

        void onCancel();
    }

    public TribeContributionDialog(Context context) {
        super(context);
        this.f11387c = new ObservableField<>("0");
        this.f11388d = new ObservableField<>("0");
        this.f11389e = new ObservableField<>();
        this.f11390f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.dialog.ba
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11529a.a((String) obj);
            }
        });
        this.context = context;
    }

    private void c(String str) {
        try {
            TribeLevelExchange tribeLevelExchange = LocalDataRequest.getTribeLevelExchange(TribeCenter.newInstance().tribeLevel.get().intValue());
            TribeVipExchange tribeVipExChange = LocalDataRequest.getTribeVipExChange(AccountCenter.newInstance().vip.get().intValue());
            int iIntValue = this.f11389e.get().intValue();
            if (iIntValue == 1) {
                ObservableField<String> observableField = this.f11387c;
                double diamondExperienceRate = tribeLevelExchange.getDiamondExperienceRate();
                double diamondExperienceRate2 = tribeVipExChange.getDiamondExperienceRate();
                Double.isNaN(diamondExperienceRate);
                double d2 = diamondExperienceRate * diamondExperienceRate2;
                double dIntValue = Integer.valueOf(str).intValue();
                Double.isNaN(dIntValue);
                observableField.set(String.valueOf((int) (d2 * dIntValue)));
                this.f11388d.set(String.valueOf(tribeLevelExchange.getDiamondCurrencyRate() * tribeVipExChange.getDiamondCurrencyRate() * Integer.valueOf(str).intValue()));
            } else if (iIntValue == 2) {
                ObservableField<String> observableField2 = this.f11387c;
                double goldExperienceRate = tribeLevelExchange.getGoldExperienceRate() * tribeVipExChange.getGoldExperienceRate();
                double dIntValue2 = Integer.valueOf(str).intValue();
                Double.isNaN(dIntValue2);
                observableField2.set(String.valueOf((int) (goldExperienceRate * dIntValue2)));
                this.f11388d.set(String.valueOf(tribeLevelExchange.getGoldCurrencyRate() * tribeVipExChange.getGoldCurrencyRate() * Integer.valueOf(str).intValue()));
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f11389e.get().intValue() == 2 && Long.valueOf(str).longValue() > AccountCenter.newInstance().golds.get().longValue()) {
            this.f11386b.f7441c.setText(String.valueOf(AccountCenter.newInstance().golds.get()));
        } else if (this.f11389e.get().intValue() == 1 && Long.valueOf(str).longValue() > AccountCenter.newInstance().gDiamonds.get().longValue() + AccountCenter.newInstance().diamonds.get().longValue()) {
            this.f11386b.f7441c.setText(String.valueOf(AccountCenter.newInstance().gDiamonds.get().longValue() + AccountCenter.newInstance().diamonds.get().longValue()));
        }
        c(str);
    }

    public TribeContributionDialog b(String str) {
        this.f11386b.i.setText(str);
        return this;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        this.f11386b = (Fc) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_tribe_contribution, (ViewGroup) null, false);
        this.f11386b.a(this);
        setContentView(this.f11386b.getRoot());
        initView();
    }

    public void initView() {
        this.f11386b.f7440b.setOnClickListener(this);
        this.f11386b.f7439a.setOnClickListener(this);
        this.f11386b.f7443e.setOnClickListener(this);
        this.f11386b.f7442d.setOnClickListener(this);
        this.f11386b.f7444f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strTrim = this.f11386b.f7441c.getText().toString().trim();
        int iIntValue = TextUtils.isEmpty(strTrim) ? 0 : Integer.valueOf(strTrim).intValue();
        switch (view.getId()) {
            case R.id.btnCancel /* 2131296463 */:
                a aVar = this.f11385a;
                if (aVar != null) {
                    aVar.onCancel();
                }
                cancel();
                break;
            case R.id.btnConfirm /* 2131296465 */:
                a aVar2 = this.f11385a;
                if (aVar2 != null) {
                    aVar2.a(iIntValue);
                }
                cancel();
                break;
            case R.id.ivAdd /* 2131296849 */:
                this.f11386b.f7441c.setText(String.valueOf(iIntValue + 1));
                break;
            case R.id.ivReduce /* 2131296900 */:
                if (iIntValue > 0) {
                    this.f11386b.f7441c.setText(String.valueOf(iIntValue - 1));
                    break;
                }
                break;
            case R.id.llFull /* 2131297103 */:
                com.disabngo.blockynexus.d.A.a(this.context, this.f11386b.f7441c);
                break;
        }
    }

    public TribeContributionDialog a(int i) {
        this.f11389e.set(Integer.valueOf(i));
        return this;
    }

    public TribeContributionDialog a(a aVar) {
        this.f11385a = aVar;
        return this;
    }
}
