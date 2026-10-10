package com.sandboxol.imchat.center;

import androidx.databinding.ObservableField;

/* JADX INFO: loaded from: classes4.dex */
public class PartyCenter {
    private static PartyCenter instance;
    public ObservableField<String> teamId = new ObservableField<>("");

    public static PartyCenter newInstance() {
        if (instance == null) {
            instance = new PartyCenter();
        }
        return instance;
    }
}
