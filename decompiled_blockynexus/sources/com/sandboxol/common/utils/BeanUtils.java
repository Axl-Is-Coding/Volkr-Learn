package com.sandboxol.common.utils;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public class BeanUtils {
    public static Fragment getFragment(Class cls) {
        try {
            return (Fragment) cls.newInstance();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new Fragment();
        }
    }
}
