package com.sandboxol.imchat.ui.widget;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class PartyMembersView extends LinearLayout implements View.OnDragListener, View.OnLongClickListener {
    private Context context;
    private LinearLayout llTeam;

    public PartyMembersView(Context context) {
        this(context, null);
    }

    private void addView(Context context, int i, int i2, int i3) {
        int i4 = (i2 / i3) + 1;
        int i5 = i2 % i3;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = i2;
            for (int i8 = 0; i8 < i4; i8++) {
                LinearLayout linearLayoutCreateFatherLinearLayout = createFatherLinearLayout(context);
                boolean z = i7 < i3;
                int i9 = 0;
                int i10 = 0;
                while (i10 < i3) {
                    int i11 = i9 + 1;
                    linearLayoutCreateFatherLinearLayout.addView(createChildLinearLayout(context, i10, z ? i5 : i3, z, i11));
                    i10++;
                    i9 = i11;
                }
                this.llTeam.addView(linearLayoutCreateFatherLinearLayout);
                i7 -= i3;
            }
        }
    }

    private LinearLayout createChildLinearLayout(Context context, int i, int i2, boolean z, int i3) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 120);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        if (i2 >= i3) {
            linearLayout.setOnDragListener(this);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(context.getResources().getColor(R.color.browser_actions_bg_grey));
            textView.setText(String.valueOf(i));
            textView.setGravity(17);
            textView.setBackgroundColor(context.getResources().getColor(R.color.browser_actions_text_color));
            textView.setOnLongClickListener(this);
            linearLayout.addView(textView);
        }
        return linearLayout;
    }

    private LinearLayout createFatherLinearLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 120));
        linearLayout.setOrientation(0);
        return linearLayout;
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_party_member, this);
        this.llTeam = (LinearLayout) findViewById(R.id.llTeam);
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        View view2 = (View) dragEvent.getLocalState();
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        ViewGroup viewGroup2 = (ViewGroup) view;
        View childAt = viewGroup2.getChildAt(0);
        int action = dragEvent.getAction();
        if (action != 1) {
            if (action == 3) {
                view2.setAlpha(1.0f);
                childAt.setAlpha(1.0f);
                if (viewGroup != viewGroup2) {
                    viewGroup2.removeView(childAt);
                    viewGroup.removeView(view2);
                    viewGroup.addView(childAt);
                    ((LinearLayout) view).addView(view2);
                }
            } else if (action == 4) {
                view.setAlpha(1.0f);
                childAt.setAlpha(1.0f);
            } else if (action == 5) {
                view.setAlpha(0.7f);
                view.setScaleX(1.1f);
                view.setScaleY(1.1f);
            } else if (action == 6) {
                view.setAlpha(1.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }
        }
        return true;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        view.startDrag(ClipData.newPlainText("", ""), new View.DragShadowBuilder(view), view, 0);
        view.setAlpha(0.5f);
        return true;
    }

    public void viewBindingAddView(Context context, int i, int i2, int i3) {
        addView(context, i, i2, i3);
    }

    public PartyMembersView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartyMembersView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
