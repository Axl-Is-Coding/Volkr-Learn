package com.sandboxol.common.binding.adapter;

import androidx.viewpager.widget.ViewPager;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class ViewPagerBindingAdapters {

    public static class ViewPagerDataWrapper {
        public float position;
        public float positionOffset;
        public int positionOffsetPixels;
        public int state;

        public ViewPagerDataWrapper(float f2, float f3, int i, int i2) {
            this.positionOffset = f3;
            this.position = f2;
            this.positionOffsetPixels = i;
            this.state = i2;
        }
    }

    public static void onScrollChangeCommand(ViewPager viewPager, final ReplyCommand<ViewPagerDataWrapper> replyCommand, final ReplyCommand<Integer> replyCommand2, final ReplyCommand<Integer> replyCommand3) {
        viewPager.addOnPageChangeListener(new ViewPager.e() { // from class: com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters.1
            private int state;

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrollStateChanged(int i) {
                this.state = i;
                ReplyCommand replyCommand4 = replyCommand3;
                if (replyCommand4 != null) {
                    replyCommand4.execute(Integer.valueOf(i));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrolled(int i, float f2, int i2) {
                ReplyCommand replyCommand4 = replyCommand;
                if (replyCommand4 != null) {
                    replyCommand4.execute(new ViewPagerDataWrapper(i, f2, i2, this.state));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageSelected(int i) {
                ReplyCommand replyCommand4 = replyCommand2;
                if (replyCommand4 != null) {
                    replyCommand4.execute(Integer.valueOf(i));
                }
            }
        });
    }

    public static void setCurrentItem(ViewPager viewPager, int i, boolean z) {
        viewPager.setCurrentItem(i, z);
    }

    public static void setOffscreenPageLimit(ViewPager viewPager, int i) {
        if (i == 0) {
            i = 1;
        }
        viewPager.setOffscreenPageLimit(i);
    }
}
