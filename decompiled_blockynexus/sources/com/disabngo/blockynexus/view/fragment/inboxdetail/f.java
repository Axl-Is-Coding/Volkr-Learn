package com.disabngo.blockynexus.view.fragment.inboxdetail;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.Attachment;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;

/* JADX INFO: compiled from: InboxDetailAttachmentViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends ListItemViewModel<Attachment> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Integer> f11744a;

    public f(Context context, Attachment attachment, ObservableField<Integer> observableField) {
        super(context, attachment);
        this.f11744a = new ObservableField<>();
        this.f11744a = observableField;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Attachment getItem() {
        return (Attachment) super.getItem();
    }
}
