package com.sandboxol.vip.c;

import android.content.Context;
import android.content.res.TypedArray;
import com.sandboxol.center.entity.SubscribeInfo;
import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.vip.R;
import com.sandboxol.vip.entity.PrivilegeInfo;
import com.sandboxol.vip.entity.VipDiamond;
import com.sandboxol.vip.entity.VipProductType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DataReturnUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static List<PrivilegeInfo> a(int i) {
        int i2;
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList();
        Context context = BaseApplication.getContext();
        String[] stringArray = context.getResources().getStringArray(R.array.vip_privilege_detail_list_item_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.vip_privilege_detail_list_item_desc);
        String[] stringArray3 = context.getResources().getStringArray(R.array.vip_privilege_detail_list_item_detail_desc);
        int[] intArray = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_list_item_detail_res);
        int[] intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_list_item_thumbnail_res);
        int i5 = 1;
        if (i != 1) {
            if (i == 2) {
                intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_plus_list_item_thumbnail_res);
            } else if (i == 3) {
                intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_mvp_list_item_thumbnail_res);
            } else if (i != 4) {
                i2 = 0;
            } else {
                intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_mvp_plus_list_item_thumbnail_res);
            }
            i2 = 10;
        } else {
            intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_list_item_thumbnail_res);
            i2 = 8;
        }
        if (stringArray.length == 10 && stringArray2.length == 10 && stringArray3.length == 10 && intArray.length == 10 && intArray2.length == 10) {
            if (i == 1) {
                i3 = R.array.vip_privilege_detail_vip_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_vip_list_item_detail_res;
            } else if (i == 2) {
                i3 = R.array.vip_privilege_detail_vip_plus_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_vip_plus_list_item_detail_res;
            } else if (i == 3) {
                i3 = R.array.vip_privilege_detail_mvp_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_mvp_list_item_detail_res;
            } else if (i != 4) {
                i3 = 0;
                i4 = 0;
            } else {
                i3 = R.array.vip_privilege_detail_mvp_plus_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_mvp_plus_list_item_detail_res;
            }
            TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(i3);
            TypedArray typedArrayObtainTypedArray2 = context.getResources().obtainTypedArray(i4);
            int i6 = 0;
            while (i6 < i2) {
                String string = stringArray3[i6];
                if (i != i5) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                if (i6 == 0) {
                                    Object[] objArr = new Object[i5];
                                    objArr[0] = 2000;
                                    string = String.format(string, objArr);
                                } else if (i6 == 5) {
                                    Object[] objArr2 = new Object[i5];
                                    objArr2[0] = "3";
                                    string = String.format(string, objArr2);
                                } else if (i6 == 6) {
                                    Object[] objArr3 = new Object[i5];
                                    objArr3[0] = "2";
                                    string = String.format(string, objArr3);
                                } else if (i6 == 8) {
                                    string = context.getString(R.string.vip_privilege_list_item_detail_desc_9_1);
                                }
                            }
                        } else if (i6 == 0) {
                            Object[] objArr4 = new Object[i5];
                            objArr4[0] = Integer.valueOf(VipDiamond.MVP);
                            string = String.format(string, objArr4);
                        } else if (i6 == 5) {
                            Object[] objArr5 = new Object[i5];
                            objArr5[0] = "3";
                            string = String.format(string, objArr5);
                        } else if (i6 == 6) {
                            Object[] objArr6 = new Object[i5];
                            objArr6[0] = "2";
                            string = String.format(string, objArr6);
                        } else if (i6 == 8) {
                            string = context.getString(R.string.vip_privilege_list_item_detail_desc_9_1);
                        }
                    } else if (i6 == 0) {
                        Object[] objArr7 = new Object[i5];
                        objArr7[0] = 360;
                        string = String.format(string, objArr7);
                    } else if (i6 == 5) {
                        Object[] objArr8 = new Object[i5];
                        objArr8[0] = "2";
                        string = String.format(string, objArr8);
                    } else if (i6 == 6) {
                        Object[] objArr9 = new Object[i5];
                        objArr9[0] = "1.5";
                        string = String.format(string, objArr9);
                    } else if (i6 == 8) {
                        string = context.getString(R.string.vip_privilege_list_item_detail_desc_9);
                    }
                } else if (i6 == 0) {
                    Object[] objArr10 = new Object[i5];
                    objArr10[0] = 66;
                    string = String.format(string, objArr10);
                } else if (i6 == 5) {
                    Object[] objArr11 = new Object[i5];
                    objArr11[0] = "1.5";
                    string = String.format(string, objArr11);
                } else if (i6 == 6) {
                    Object[] objArr12 = new Object[i5];
                    objArr12[0] = "1.2";
                    string = String.format(string, objArr12);
                }
                PrivilegeInfo privilegeInfo = new PrivilegeInfo();
                privilegeInfo.setVipType(i);
                privilegeInfo.setTitle(stringArray[i6]);
                privilegeInfo.setDesc(stringArray2[i6]);
                privilegeInfo.setDetailDesc(string);
                privilegeInfo.setThumbnailRes(typedArrayObtainTypedArray.getResourceId(i6, 0));
                privilegeInfo.setDetailRes(typedArrayObtainTypedArray2.getResourceId(i6, 0));
                arrayList.add(privilegeInfo);
                i6++;
                i5 = 1;
            }
            typedArrayObtainTypedArray.recycle();
            typedArrayObtainTypedArray2.recycle();
            if (i == 2 || i == 3 || i == 4) {
                arrayList.add(3, (PrivilegeInfo) arrayList.remove(arrayList.size() - 1));
                arrayList.add(3, (PrivilegeInfo) arrayList.remove(arrayList.size() - 1));
            }
        }
        return arrayList;
    }

    public static List<PrivilegeInfo> b(int i) {
        int i2;
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList();
        Context context = BaseApplication.getContext();
        String[] stringArray = context.getResources().getStringArray(R.array.vip_privilege_detail_list_item_title);
        String[] stringArray2 = context.getResources().getStringArray(R.array.vip_privilege_detail_list_item_desc);
        String[] stringArray3 = context.getResources().getStringArray(R.array.vip_privilege_detail_list_item_detail_desc);
        int[] intArray = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_list_item_detail_res);
        int[] intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_list_item_thumbnail_res);
        if (i != 1) {
            if (i == 2) {
                intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_plus_list_item_thumbnail_res);
            } else if (i == 3) {
                intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_mvp_list_item_thumbnail_res);
            } else if (i != 4) {
                i2 = 0;
            } else {
                intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_mvp_plus_list_item_thumbnail_res);
            }
            i2 = 10;
        } else {
            intArray2 = context.getResources().getIntArray(R.array.vip_privilege_detail_vip_list_item_thumbnail_res);
            i2 = 8;
        }
        if (stringArray.length == 10 && stringArray2.length == 10 && stringArray3.length == 10 && intArray.length == 10 && intArray2.length == 10) {
            if (i == 1) {
                i3 = R.array.vip_privilege_detail_vip_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_vip_list_item_detail_res;
            } else if (i == 2) {
                i3 = R.array.vip_privilege_detail_vip_plus_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_vip_plus_list_item_detail_res;
            } else if (i == 3) {
                i3 = R.array.vip_privilege_detail_mvp_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_mvp_list_item_detail_res;
            } else if (i != 4) {
                i3 = 0;
                i4 = 0;
            } else {
                i3 = R.array.vip_privilege_detail_mvp_plus_list_item_thumbnail_res;
                i4 = R.array.vip_privilege_detail_mvp_plus_list_item_detail_res;
            }
            TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(i3);
            TypedArray typedArrayObtainTypedArray2 = context.getResources().obtainTypedArray(i4);
            for (int i5 = 3; i5 < i2; i5++) {
                PrivilegeInfo privilegeInfo = new PrivilegeInfo();
                privilegeInfo.setVipType(i);
                privilegeInfo.setTitle(stringArray[i5]);
                privilegeInfo.setDesc(stringArray2[i5]);
                privilegeInfo.setDetailDesc(stringArray3[i5]);
                privilegeInfo.setThumbnailRes(typedArrayObtainTypedArray.getResourceId(i5, 0));
                privilegeInfo.setDetailRes(typedArrayObtainTypedArray2.getResourceId(i5, 0));
                arrayList.add(privilegeInfo);
            }
            typedArrayObtainTypedArray.recycle();
            typedArrayObtainTypedArray2.recycle();
            if (i == 2 || i == 3 || i == 4) {
                arrayList.add(0, (PrivilegeInfo) arrayList.remove(arrayList.size() - 1));
                arrayList.remove(arrayList.size() - 1);
            }
        }
        return arrayList;
    }

    public static String c(int i) {
        VipSubInfo vipSubInfo = VipDataManager.getInstance().getVipSubInfo();
        if (vipSubInfo == null || vipSubInfo.getSubInfo() == null || vipSubInfo.getSubInfo().size() <= 0) {
            return null;
        }
        for (SubscribeInfo subscribeInfo : vipSubInfo.getSubInfo()) {
            if (subscribeInfo != null && subscribeInfo.getVipType() == i) {
                return subscribeInfo.getSubOverDateStr();
            }
        }
        return null;
    }

    public static boolean d(int i) {
        VipSubInfo vipSubInfo = VipDataManager.getInstance().getVipSubInfo();
        if (vipSubInfo == null || vipSubInfo.getSubInfo() == null || vipSubInfo.getSubInfo().size() <= 0) {
            return false;
        }
        for (SubscribeInfo subscribeInfo : vipSubInfo.getSubInfo()) {
            if (subscribeInfo != null && subscribeInfo.getVipType() == i) {
                return subscribeInfo.isSubscribe();
            }
        }
        return false;
    }

    public static VipProductEntity a(boolean z, int i) {
        String str = !z ? VipProductType.SUB : "vip";
        ArrayList<VipProductEntity> arrayList = new ArrayList();
        VipProductResponse vipProductResponse = VipDataManager.getInstance().getVipProductResponse();
        if (vipProductResponse != null && vipProductResponse.getProducts() != null && vipProductResponse.getProducts().size() > 0) {
            Iterator<List<VipProductEntity>> it = vipProductResponse.getProducts().values().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next());
            }
        }
        for (VipProductEntity vipProductEntity : arrayList) {
            if (vipProductEntity != null && str.equals(vipProductEntity.getType()) && vipProductEntity.getMonth() == 1 && i == vipProductEntity.getLevel()) {
                return vipProductEntity;
            }
        }
        return new VipProductEntity();
    }

    public static VipProductEntity a(boolean z, int i, boolean z2) {
        return a(z, i);
    }
}
