package io.rong.imkit.fragment;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DispatchResultFragment extends UriFragment {
    private int getFragmentOffset(int i, Fragment fragment, Fragment fragment2) {
        if (fragment2 != null && fragment2.getChildFragmentManager().e() != null) {
            Iterator<Fragment> it = fragment2.getChildFragmentManager().e().iterator();
            if (it.hasNext()) {
                Fragment next = it.next();
                int i2 = i + 1;
                return fragment == next ? i2 : getFragmentOffset(i2, fragment, next);
            }
        }
        return 0;
    }

    private Fragment getOffsetFragment(int i, Fragment fragment) {
        if (i == 0) {
            return fragment;
        }
        for (Fragment fragment2 : getChildFragmentManager().e()) {
            i--;
            if (i == 0) {
                return fragment2;
            }
            if (fragment2.getChildFragmentManager().e() != null && fragment2.getChildFragmentManager().e().size() > 0) {
                return getOffsetFragment(i, fragment2);
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i >> 12;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        Fragment offsetFragment = getOffsetFragment(i3 - 1, this);
        if (offsetFragment != null) {
            offsetFragment.onActivityResult(i & 4095, i2, intent);
        }
    }

    public void startActivityForResult(Fragment fragment, Intent intent, int i) {
        int fragmentOffset = getFragmentOffset(0, fragment, this);
        if (fragmentOffset > 15) {
            throw new RuntimeException("DispatchFragment only support 16 fragments。");
        }
        if (i == -1) {
            startActivityForResult(intent, -1);
        } else {
            if ((i & (-4096)) != 0) {
                throw new IllegalArgumentException("Can only use lower 12 bits for requestCode");
            }
            startActivityForResult(intent, ((fragmentOffset + 1) << 12) + (i & 4095));
        }
    }
}
