package com.sandboxol.decorate.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.widget.DressMenuButton;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class DressRadioGroup extends FrameLayout {
    private CheckBox cbShowAll;
    private Context context;
    private DressMenuButton dressMenuButton;
    private a fullScreenListener;
    private b listener;
    private RadioGroup rgDress;
    private DressMenuButton.a selectedListener;

    public enum Tab {
        RECOMMEND(0),
        ALL(0),
        SUIT(1),
        ONESIES(2),
        CLOTH(3),
        PANT(4),
        SHOES(5),
        HAIR(6),
        EMOTICON(7),
        FACEDEC(0),
        HEADWEAR(1),
        NECK(2),
        BACKPACK(3),
        CROWN(4),
        ACTION(0),
        COLOR(1),
        BACKGROUND(2),
        HISTORY(0);

        public int position;

        Tab(int i) {
            this.position = i;
        }

        public static Tab getTabByPosition(int i, DressMenuButton.MenuItem menuItem, int i2) {
            int i3 = k.f17535b[menuItem.ordinal()];
            if (i3 == 1) {
                switch (i) {
                    case 0:
                        if (i2 == 0) {
                            return SUIT;
                        }
                        if (i2 == 1) {
                            return RECOMMEND;
                        }
                        if (i2 == 2) {
                            return ALL;
                        }
                    case 1:
                        if (i2 == 0) {
                            return ONESIES;
                        }
                        if (i2 == 1 || i2 == 2) {
                            return SUIT;
                        }
                    case 2:
                        if (i2 == 0) {
                            return CLOTH;
                        }
                        if (i2 == 1 || i2 == 2) {
                            return ONESIES;
                        }
                    case 3:
                        if (i2 == 0) {
                            return PANT;
                        }
                        if (i2 == 1 || i2 == 2) {
                            return CLOTH;
                        }
                    case 4:
                        if (i2 == 0) {
                            return SHOES;
                        }
                        if (i2 == 1 || i2 == 2) {
                            return PANT;
                        }
                    case 5:
                        if (i2 == 0) {
                            return HAIR;
                        }
                        if (i2 == 1 || i2 == 2) {
                            return SHOES;
                        }
                    case 6:
                        return i2 != 0 ? (i2 == 1 || i2 == 2) ? HAIR : HAIR : EMOTICON;
                    case 7:
                        if (i2 == 1 || i2 == 2) {
                            return EMOTICON;
                        }
                    default:
                        return ALL;
                }
            } else if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && i == 0) {
                        return HISTORY;
                    }
                } else {
                    if (i == 0) {
                        return ACTION;
                    }
                    if (i == 1) {
                        return COLOR;
                    }
                    if (i == 2) {
                        return BACKGROUND;
                    }
                }
            } else {
                if (i == 0) {
                    return FACEDEC;
                }
                if (i == 1) {
                    return HEADWEAR;
                }
                if (i == 2) {
                    return NECK;
                }
                if (i == 3) {
                    return BACKPACK;
                }
                if (i == 4) {
                    return CROWN;
                }
            }
            return ALL;
        }
    }

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void a(Tab tab);
    }

    public DressRadioGroup(Context context) {
        this(context, null);
    }

    private void init() {
        View.inflate(this.context, R.layout.view_dress_radio_group, this);
        this.rgDress = (RadioGroup) findViewById(R.id.rgDress);
        this.cbShowAll = (CheckBox) findViewById(R.id.cbFull);
        this.dressMenuButton = (DressMenuButton) findViewById(R.id.dressMenuButton);
        this.rgDress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.sandboxol.decorate.widget.d
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f17526a.a(radioGroup, i);
            }
        });
        this.cbShowAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sandboxol.decorate.widget.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f17525a.a(compoundButton, z);
            }
        });
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL, SingleDressInfo.class, new Action1() { // from class: com.sandboxol.decorate.widget.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17524a.a((SingleDressInfo) obj);
            }
        });
    }

    public /* synthetic */ void a(RadioGroup radioGroup, int i) {
        b bVar;
        if (i == -1 || (bVar = this.listener) == null) {
            return;
        }
        if (i == R.id.rbRecommend) {
            bVar.a(Tab.RECOMMEND);
            return;
        }
        if (i == R.id.rbAll) {
            bVar.a(Tab.ALL);
            return;
        }
        if (i == R.id.rbSuit) {
            bVar.a(Tab.SUIT);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_CUSTOM);
            return;
        }
        if (i == R.id.rbOnesies) {
            bVar.a(Tab.ONESIES);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_SUIT);
            return;
        }
        if (i == R.id.rbCloth) {
            bVar.a(Tab.CLOTH);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_TRUNK);
            return;
        }
        if (i == R.id.rbPants) {
            bVar.a(Tab.PANT);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_PANTS);
            return;
        }
        if (i == R.id.rbShoes) {
            bVar.a(Tab.SHOES);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_SHOES);
            return;
        }
        if (i == R.id.rbHair) {
            bVar.a(Tab.HAIR);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_FACE);
            return;
        }
        if (i == R.id.rbEmoticon) {
            bVar.a(Tab.EMOTICON);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_FACE);
            return;
        }
        if (i == R.id.rbHeadWear) {
            bVar.a(Tab.HEADWEAR);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_HAT);
            return;
        }
        if (i == R.id.rbFaceDec) {
            bVar.a(Tab.FACEDEC);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_GLASSES);
            return;
        }
        if (i == R.id.rbNeck) {
            bVar.a(Tab.NECK);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_SCARF);
            return;
        }
        if (i == R.id.rbBackpack) {
            bVar.a(Tab.BACKPACK);
            return;
        }
        if (i == R.id.rbCrown) {
            bVar.a(Tab.CROWN);
            return;
        }
        if (i == R.id.rbAction) {
            bVar.a(Tab.ACTION);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_ACTION);
        } else {
            if (i == R.id.rbColor) {
                bVar.a(Tab.COLOR);
                return;
            }
            if (i == R.id.rbBackground) {
                bVar.a(Tab.BACKGROUND);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_BACKGROUND);
            } else if (i == R.id.rbHistory) {
                bVar.a(Tab.HISTORY);
            }
        }
    }

    public RadioGroup getRgDress() {
        return this.rgDress;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Messenger.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }

    public void selectTab(Tab tab) {
        switch (k.f17534a[tab.ordinal()]) {
            case 1:
                this.rgDress.check(R.id.rbRecommend);
                break;
            case 2:
                this.rgDress.check(R.id.rbAll);
                break;
            case 3:
                this.rgDress.check(R.id.rbSuit);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_CUSTOM);
                break;
            case 4:
                this.rgDress.check(R.id.rbOnesies);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_SUIT);
                break;
            case 5:
                this.rgDress.check(R.id.rbCloth);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_TRUNK);
                break;
            case 6:
                this.rgDress.check(R.id.rbPants);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_PANTS);
                break;
            case 7:
                this.rgDress.check(R.id.rbShoes);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_SHOES);
                break;
            case 8:
                this.rgDress.check(R.id.rbHair);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_HAIR);
                break;
            case 9:
                this.rgDress.check(R.id.rbEmoticon);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_FACE);
                break;
            case 10:
                this.rgDress.check(R.id.rbHeadWear);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_HAT);
                break;
            case 11:
                this.rgDress.check(R.id.rbFaceDec);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_GLASSES);
                break;
            case 12:
                this.rgDress.check(R.id.rbNeck);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_SCARF);
                break;
            case 13:
                this.rgDress.check(R.id.rbBackpack);
                break;
            case 14:
                this.rgDress.check(R.id.rbCrown);
                break;
            case 15:
                this.rgDress.check(R.id.rbAction);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_ACTION);
                break;
            case 16:
                this.rgDress.check(R.id.rbColor);
                break;
            case 17:
                this.rgDress.check(R.id.rbBackground);
                ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_CLASS_BACKGROUND);
                break;
            case 18:
                this.rgDress.check(R.id.rbHistory);
                break;
        }
    }

    public void setChildStatus(int i, boolean z) {
        this.rgDress.getChildAt(i).setVisibility(z ? 0 : 8);
    }

    public void setFirstMenuSelectedListener(DressMenuButton.a aVar) {
        this.selectedListener = aVar;
        this.dressMenuButton.setListener(this.selectedListener);
    }

    public void setFullScreenCheck(boolean z) {
        this.cbShowAll.setChecked(z);
    }

    public void setFullScreenListener(a aVar) {
        this.fullScreenListener = aVar;
    }

    public void setTabChangeListener(b bVar) {
        this.listener = bVar;
        bVar.a(Tab.ALL);
    }

    public DressRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
        initMessenger();
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        a aVar = this.fullScreenListener;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public /* synthetic */ void a(SingleDressInfo singleDressInfo) {
        ImageRadioButton imageRadioButton;
        int i;
        switch ((int) singleDressInfo.getTypeId()) {
            case 2:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbHair);
                i = R.drawable.ic_dress_hair_selector;
                break;
            case 3:
            default:
                i = 0;
                imageRadioButton = null;
                break;
            case 4:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbEmoticon);
                i = R.drawable.ic_dress_emoticon_selector;
                break;
            case 5:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbAction);
                i = R.drawable.ic_dress_action_selector;
                break;
            case 6:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbColor);
                i = R.drawable.ic_dress_color_selector;
                break;
            case 7:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbBackground);
                i = R.drawable.id_dress_background_selector;
                break;
            case 8:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbCloth);
                i = R.drawable.ic_dress_cloth_selector;
                break;
            case 9:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbPants);
                i = R.drawable.ic_new_dress_pants_selector;
                break;
            case 10:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbShoes);
                i = R.drawable.ic_new_dress_shoes_selector;
                break;
            case 11:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbHeadWear);
                i = R.drawable.ic_new_dress_headwear_selector;
                break;
            case 12:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbFaceDec);
                i = R.drawable.ic_new_dress_face_dec_selector;
                break;
            case 13:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbNeck);
                i = R.drawable.ic_new_dress_neck_selector;
                break;
            case 14:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbBackpack);
                i = R.drawable.ic_new_dress_backpack_selector;
                break;
            case 15:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbCrown);
                i = R.drawable.ic_new_dress_crown_selector;
                break;
            case 16:
                imageRadioButton = (ImageRadioButton) this.rgDress.findViewById(R.id.rbOnesies);
                i = R.drawable.ic_new_dress_onesies_selector;
                break;
        }
        if (imageRadioButton != null) {
            if (TextUtils.isEmpty(singleDressInfo.getIconUrl())) {
                imageRadioButton.setUrlBitmap(null);
                imageRadioButton.setBackgroundResource(i);
            } else {
                try {
                    com.bumptech.glide.c.c(BaseApplication.getContext()).asBitmap().mo46load(singleDressInfo.getIconUrl()).into(new j(this, imageRadioButton));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
