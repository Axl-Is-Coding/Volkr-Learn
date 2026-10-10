package com.sandboxol.common.binding.adapter;

import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayoutBindingAdapters {
    public static void onCheckedChangeListener(TabLayout tabLayout, final ReplyCommand<Integer> replyCommand) {
        if (replyCommand != null) {
            tabLayout.addOnTabSelectedListener(new TabLayout.c() { // from class: com.sandboxol.common.binding.adapter.TabLayoutBindingAdapters.1
                @Override // com.google.android.material.tabs.TabLayout.b
                public void onTabReselected(TabLayout.f fVar) {
                }

                @Override // com.google.android.material.tabs.TabLayout.b
                public void onTabSelected(TabLayout.f fVar) {
                    replyCommand.execute(Integer.valueOf(fVar.c()));
                }

                @Override // com.google.android.material.tabs.TabLayout.b
                public void onTabUnselected(TabLayout.f fVar) {
                }
            });
        }
    }

    public static void setDivider(TabLayout tabLayout, int i, int i2, int i3) {
        if (i != 0) {
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            linearLayout.setShowDividers(2);
            linearLayout.setDividerPadding(i2);
            linearLayout.setDividerDrawable(androidx.core.content.b.c(tabLayout.getContext(), i));
            if (i3 != 0) {
                linearLayout.setBackgroundColor(tabLayout.getContext().getResources().getColor(i3));
            }
        }
    }
}
