package com.disabngo.blockynexus.view.fragment.groupbannedtimelist;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class GroupBannedTimeItemViewModel extends ListItemViewModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f11718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11719b;

    public GroupBannedTimeItemViewModel(Context context, String str, ObservableField<String> observableField) {
        super(context, str);
        this.f11719b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.groupbannedtimelist.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11721a.onClick();
            }
        });
        this.f11718a = observableField;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onClick() {
        this.f11718a.set(this.item);
    }

    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public String getItem() {
        return (String) super.getItem();
    }
}
