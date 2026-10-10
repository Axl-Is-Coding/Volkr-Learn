package com.sandboxol.gamedetail.b;

import java.util.List;

/* JADX INFO: compiled from: ViewModelUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (String str : list) {
                if (!"".equals(sb.toString()) || str == null || "".equals(str)) {
                    sb.append(" | ");
                    sb.append(str);
                } else {
                    sb = new StringBuilder(str);
                }
            }
        }
        return sb.toString();
    }
}
