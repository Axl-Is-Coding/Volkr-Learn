package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ShopPopupWindow;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: loaded from: classes.dex */
public class TribeDressRadioGroup extends FrameLayout {
    private CheckBox cbMoney;
    private CheckBox cbShowAll;
    private Context context;
    private a fullScreenListener;
    private ImageView ivCurrent;
    private ImageView ivMoney;
    private b listener;
    private RadioGroup rgDress;
    private RelativeLayout rlMoneyType;
    private ShopPopupWindow window;

    public enum Tab {
        CURRENT(0),
        CLOTH(1),
        HAIR(2),
        ORNAMENTS(3),
        EMOTICON(4),
        COLOR(5),
        ACTION(6),
        BACKGROUND(7);

        public int position;

        Tab(int i) {
            this.position = i;
        }

        public static Tab getTabByPosition(int i) {
            switch (i) {
                case 0:
                    return CURRENT;
                case 1:
                    return CLOTH;
                case 2:
                    return HAIR;
                case 3:
                    return ORNAMENTS;
                case 4:
                    return EMOTICON;
                case 5:
                    return COLOR;
                case 6:
                    return ACTION;
                case 7:
                    return BACKGROUND;
                default:
                    return CURRENT;
            }
        }
    }

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void a(Tab tab);
    }

    public TribeDressRadioGroup(Context context) {
        this(context, null);
    }

    private void init() {
        View.inflate(this.context, R.layout.view_tribe_dress_radio_group, this);
        this.rgDress = (RadioGroup) findViewById(R.id.rgDress);
        this.ivCurrent = (ImageView) findViewById(R.id.ivCurrent);
        this.ivMoney = (ImageView) findViewById(R.id.ivMoney);
        this.rlMoneyType = (RelativeLayout) findViewById(R.id.rlMoneyType);
        this.cbMoney = (CheckBox) findViewById(R.id.cbMoney);
        this.cbShowAll = (CheckBox) findViewById(R.id.cbShowAll);
        this.rgDress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.disabngo.blockynexus.view.widget.l
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f12104a.a(radioGroup, i);
            }
        });
        this.cbShowAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.disabngo.blockynexus.view.widget.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f12107a.a(compoundButton, z);
            }
        });
        this.ivCurrent.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.widget.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12105a.a(view);
            }
        });
        this.rlMoneyType.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.widget.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12106a.b(view);
            }
        });
    }

    private void selectCurrentTab() {
        this.rgDress.clearCheck();
        this.ivCurrent.setEnabled(false);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.a(Tab.CURRENT);
        }
    }

    private void showMoneyTypeList() {
        if (this.window == null) {
            this.window = new ShopPopupWindow(this.context);
        }
        if (this.window.isShowing()) {
            this.window.dismiss();
            return;
        }
        this.window.showLocation(this.rlMoneyType);
        this.cbMoney.setChecked(true);
        this.window.setOnMoreItemClickListener(new ShopPopupWindow.OnMoreItemClickListener() { // from class: com.disabngo.blockynexus.view.widget.TribeDressRadioGroup.1
            @Override // com.disabngo.blockynexus.view.widget.ShopPopupWindow.OnMoreItemClickListener
            public void a() {
                TribeDressRadioGroup.this.cbMoney.setChecked(false);
            }

            @Override // com.disabngo.blockynexus.view.widget.ShopPopupWindow.OnMoreItemClickListener
            public void onClick(View view, int i) {
                if (i == R.id.ivDiamond) {
                    TribeDressRadioGroup.this.ivMoney.setImageResource(R.mipmap.ic_shop_diamond);
                    Messenger.getDefault().send(1, MessageToken.TOKEN_MONEY_TYPE);
                } else if (i == R.id.ivGold) {
                    TribeDressRadioGroup.this.ivMoney.setImageResource(R.mipmap.ic_shop_gold);
                    Messenger.getDefault().send(2, MessageToken.TOKEN_MONEY_TYPE);
                }
                TribeDressRadioGroup.this.cbMoney.setChecked(false);
            }
        });
    }

    public /* synthetic */ void a(RadioGroup radioGroup, int i) {
        if (i == -1) {
        }
        this.ivCurrent.setEnabled(true);
        b bVar = this.listener;
        if (bVar != null) {
            switch (i) {
                case R.id.rbAction /* 2131297288 */:
                    bVar.a(Tab.ACTION);
                    break;
                case R.id.rbBackground /* 2131297290 */:
                    bVar.a(Tab.BACKGROUND);
                    break;
                case R.id.rbCloth /* 2131297293 */:
                    bVar.a(Tab.CLOTH);
                    break;
                case R.id.rbColor /* 2131297294 */:
                    bVar.a(Tab.COLOR);
                    break;
                case R.id.rbEmoticon /* 2131297296 */:
                    bVar.a(Tab.EMOTICON);
                    break;
                case R.id.rbHair /* 2131297302 */:
                    bVar.a(Tab.HAIR);
                    break;
                case R.id.rbOrnaments /* 2131297310 */:
                    bVar.a(Tab.ORNAMENTS);
                    break;
            }
        }
    }

    public /* synthetic */ void b(View view) {
        showMoneyTypeList();
    }

    public void hideCbShowAll() {
        this.cbShowAll.setVisibility(8);
    }

    public void hideCurrent() {
        this.ivCurrent.setVisibility(8);
    }

    public void hideMoneyType() {
        this.rlMoneyType.setVisibility(8);
    }

    public void selectTab(Tab tab) {
        switch (u.f12112a[tab.ordinal()]) {
            case 1:
                selectCurrentTab();
                break;
            case 2:
                this.rgDress.check(R.id.rbCloth);
                break;
            case 3:
                this.rgDress.check(R.id.rbHair);
                break;
            case 4:
                this.rgDress.check(R.id.rbOrnaments);
                break;
            case 5:
                this.rgDress.check(R.id.rbEmoticon);
                break;
            case 6:
                this.rgDress.check(R.id.rbColor);
                break;
            case 7:
                this.rgDress.check(R.id.rbAction);
                break;
            case 8:
                this.rgDress.check(R.id.rbBackground);
                break;
        }
    }

    public void setFullScreenCheck(boolean z) {
        this.cbShowAll.setChecked(z);
    }

    public void setFullScreenListener(a aVar) {
        this.fullScreenListener = aVar;
    }

    public void setTabChangeListener(b bVar) {
        this.listener = bVar;
        selectCurrentTab();
    }

    public void showCbShowAll() {
        this.cbShowAll.setVisibility(0);
    }

    public void showCurrent() {
        this.ivCurrent.setVisibility(0);
    }

    public void showMoneyType() {
        this.rlMoneyType.setVisibility(0);
    }

    public TribeDressRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        a aVar = this.fullScreenListener;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public /* synthetic */ void a(View view) {
        selectCurrentTab();
    }
}
