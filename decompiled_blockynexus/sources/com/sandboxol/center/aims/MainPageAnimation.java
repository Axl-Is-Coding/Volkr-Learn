package com.sandboxol.center.aims;

import com.sandboxol.center.router.manager.MainManager;
import com.sandboxol.common.anim.HorizontalMoveAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class MainPageAnimation extends HorizontalMoveAnimation {
    public MainPageAnimation(boolean z, int i) {
        super(MainManager.getPageAnimDirection(), z, 100L);
        MainManager.setPageIndex(z, i);
    }
}
