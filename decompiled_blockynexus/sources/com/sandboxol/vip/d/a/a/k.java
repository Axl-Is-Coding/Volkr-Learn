package com.sandboxol.vip.d.a.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: SubscribeBottomItemModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class k extends ListItemViewModel<VipProductEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<VipProductEntity> f19059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f19060b;

    public k(Context context, VipProductEntity vipProductEntity, ObservableField<VipProductEntity> observableField) {
        super(context, vipProductEntity);
        this.f19060b = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.a.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f19049a.f();
            }
        });
        this.f19059a = observableField;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public void f() {
        this.f19059a.set(this.item);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public VipProductEntity getItem() {
        return (VipProductEntity) super.getItem();
    }
}
