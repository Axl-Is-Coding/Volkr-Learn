package com.disabngo.blockynexus.e.b.X;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: ReGameItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends ListItemViewModel<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f9579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableList<String> f9580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9581c;

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Game getItem() {
        return (Game) super.getItem();
    }
}
