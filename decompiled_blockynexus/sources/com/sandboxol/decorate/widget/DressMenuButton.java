package com.sandboxol.decorate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.sandboxol.decorate.R;

/* JADX INFO: loaded from: classes3.dex */
public class DressMenuButton extends LinearLayout {
    private Context context;
    private int currentIndex;
    private a listener;
    private RadioGroup rgFirstLevelMenuDress;

    public enum MenuItem {
        CLOSE(0),
        CLOTH(1),
        DEC(2),
        MAN(3),
        FUN(4);

        public int position;

        MenuItem(int i) {
            this.position = i;
        }

        public static MenuItem getMenuItemByPosition(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? CLOTH : FUN : MAN : DEC : CLOTH : CLOSE;
        }
    }

    public interface a {
        void a(MenuItem menuItem);
    }

    public DressMenuButton(Context context) {
        this(context, null);
    }

    private void initClickEvent() {
        this.rgFirstLevelMenuDress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.sandboxol.decorate.widget.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f17523a.a(radioGroup, i);
            }
        });
    }

    private void initView() {
        this.rgFirstLevelMenuDress = (RadioGroup) findViewById(R.id.rg_first_level_menu_dress);
    }

    public /* synthetic */ void a(RadioGroup radioGroup, int i) {
        if (i == R.id.rb_clothes) {
            MenuItem menuItem = MenuItem.CLOTH;
            this.currentIndex = menuItem.position;
            a aVar = this.listener;
            if (aVar != null) {
                aVar.a(menuItem);
                return;
            }
            return;
        }
        if (i == R.id.rb_accessories) {
            MenuItem menuItem2 = MenuItem.DEC;
            this.currentIndex = menuItem2.position;
            a aVar2 = this.listener;
            if (aVar2 != null) {
                aVar2.a(menuItem2);
                return;
            }
            return;
        }
        if (i == R.id.rb_character) {
            MenuItem menuItem3 = MenuItem.MAN;
            this.currentIndex = menuItem3.position;
            a aVar3 = this.listener;
            if (aVar3 != null) {
                aVar3.a(menuItem3);
                return;
            }
            return;
        }
        if (i == R.id.rb_function) {
            MenuItem menuItem4 = MenuItem.FUN;
            this.currentIndex = menuItem4.position;
            a aVar4 = this.listener;
            if (aVar4 != null) {
                aVar4.a(menuItem4);
            }
        }
    }

    public void setInitView(MenuItem menuItem) {
        this.currentIndex = menuItem.position;
    }

    public void setListener(a aVar) {
        this.listener = aVar;
    }

    public DressMenuButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DressMenuButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = MenuItem.CLOTH.position;
        this.context = context;
        LinearLayout.inflate(context, R.layout.view_dress_first_level_menu_radio_group, this);
        initView();
        initClickEvent();
    }
}
