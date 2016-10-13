package com.huihuan.gmp.cst;

public class SYS_PROPERTY {
	//系统属性
	
	public static String PRDT_LNGTH="PRDT_LNGTH";//产品序数位
	public static String SM_CTGRY_LNGTH="SM_CTGRY_LNGTH";//同名编码位数
	public static String MATERIAL_LNGTH="MATERIAL_LNGTH";//原辅料序数位长度
	public static String WARPPERS_LNGTH="WARPPERS_LNGTH";//包装材料序数位长度
	public static String PRODUCT_CODE_TYPE="PRODUCT_CODE_TYPE";//0：机器编码 ，1：分类编码，3：自定义编码
	public static String MATERIAL_CODE_TYPE="MATERIAL_CODE_TYPE";//0：机器编码 ，1：分类编码，3：自定义编码
	public static String PACKAGE_CODE_TYPE="PACKAGE_CODE_TYPE";//0：机器编码 ，1：分类编码，3：自定义编码
	public static String MACHINE_CODE="MACHINE_CODE";//机器编码，每次加1
	public static String DEFAULT_PASSWD="DEFAULT_PASSWD";//默认密码
	public static String IS_PRODUCT_EDIT_CHECK="IS_PRODUCT_EDIT_CHECK";//产品编码编辑时是否需要审核（0不需要，1需要）
	public static String IS_MATERIAL_EDIT_CHECK="IS_MATERIAL_EDIT_CHECK";//原辅料编码编辑时是否需要审核（0不需要，1需要）
	public static String IS_MATERIAL_NAME_SECRET="IS_MATERIAL_NAME_SECRET";//原辅料名称是否保密管理（0不需要，1需要）
	public static String IS_PACKAGE_EDIT_CHECK="IS_PACKAGE_EDIT_CHECK";//包装材料编码编辑时是否需要审核（0不需要，1需要）
	public static String PWD_MIN_LENGTH="PWD_MIN_LENGTH";//密码最小长度
	public static String PWD_VALID_DAY="PWD_VALID_DAY";//密码有效天数
	public static String PWD_ERROR_MAX_COUNT="PWD_ERROR_MAX_COUNT";//密码输入最大错误次数
	public static String PWD_MIN_INTENSITY="PWD_MIN_INTENSITY";//密码最小强度（1弱，2中，3强）
	public static String DISPLAY_IDENTY_CODE="DISPLAY_IDENTY_CODE";//登陆时是否显示验证码（0显示，1不显示）
	public static String IS_MATERIAL_NAME_SAVE="IS_MATERIAL_NAME_SAVE";//是否启用原辅料名称保密管理（0不需要，1需要）
	public static String IS_MATERIAL_CODING_EDIT_CHECKED="IS_MATERIAL_CODING_EDIT_CHECKED";//原辅料编码编辑时是否需要审核。（0不需要，1需要）
	public static String IS_PRODUCT_EDIT_CHECKED="IS_PRODUCT_EDIT_CHECKED";//产品编码编辑时是否需要审核（0不需要，1需要）
	public static String IS_INTERMEDIA_PRODUCT_E_CARD="IS_INTERMEDIA_PRODUCT_E_CARD";//是否启用中间品电子标签管理（0不启用，1启用）
	public static String WORKSHOP_NUM="WORKSHOP_NUM";//用户生产车间可设置数
	public static String IS_WAREHOUSE_E_CARD="IS_WAREHOUSE_E_CARD";//是否启用仓位电子卡片管理（0不启用，1启用）
	public static String IS_TRAY_E_CARD="IS_TRAY_E_CARD";//是否启用托盘电子卡片管理（0不启用，1启用）
	public static String PRODUCT_WAREHOUSE_NUM="PRODUCT_WAREHOUSE_NUM";//用户成品仓库可设置数
	public static String PACKING_WAREHOUSE_NUM="PACKING_WAREHOUSE_NUM";//用户包装材料仓库可设置数
	public static String MATERIAL_WAREHOUSE_NUM="MATERIAL_WAREHOUSE_NUM";//用户原辅料仓库可设置数
	public static String IS_EMPLOYEE_E_CARD="IS_EMPLOYEE_E_CARD";//是否启用员工电子卡（0不启用，1启用）
	public static String PACKING_DEFINE2="PACKING_DEFINE2";//包装规格自定义项2
	public static String PACKING_DEFINE1="PACKING_DEFINE1";//包装规格自定义项1
	public static String IS_PACKING_DEFINE2="IS_PACKING_DEFINE2";//包装规格是否使用自定义项2（0不使用，1使用）
	public static String IS_PACKING_DEFINE1="IS_PACKING_DEFINE1";//包装规格是否使用自定义项1（0不使用，1使用）
	public static String IS_MATERIAL_EDIT_CHECKED="IS_MATERIAL_EDIT_CHECKED";//包装材料配套编辑时是否需要审核（0不需要，1需要）
	public static String EDIT_RECIPE2="EDIT_RECIPE2";//产品配方编辑时自定义项2
	public static String EDIT_RECIPE1="EDIT_RECIPE1";//产品配方编辑时自定义项1
	public static String IS_EDIT_RECIPE2="IS_EDIT_RECIPE2";//产品配方编辑时是否需要自定义项2（0不需要，1需要）
	public static String IS_EDIT_RECIPE1="IS_EDIT_RECIPE1";//产品配方编辑时是否需要自定义项1（0不需要，1需要）
	public static String FEED_DIFFERENCE="FEED_DIFFERENCE";//投料差异(±%) 
	public static String IS_FEED_DIFFERENCE_CONTROL="IS_FEED_DIFFERENCE_CONTROL";//是否启用投料差异控制（0不启用，1启用）
	public static String WAREHOUSE_TYPE_7="WAREHOUSE_TYPE_7";//是否启用类型为7的仓库（0不启用，1启用）留样仓库
	public static String WAREHOUSE_TYPE_6="WAREHOUSE_TYPE_6";//是否启用类型为6的仓库（0不启用，1启用）试剂仓库
	public static String WAREHOUSE_TYPE_5="WAREHOUSE_TYPE_5";//是否启用类型为5的仓库（0不启用，1启用）回收仓库
	public static String WAREHOUSE_TYPE_4="WAREHOUSE_TYPE_4";//是否启用类型为4的仓库（0不启用，1启用）中间产品仓库
	public static String WAREHOUSE_TYPE_3="WAREHOUSE_TYPE_3";//是否启用类型为3的仓库（0不启用，1启用）产品仓库
	public static String WAREHOUSE_TYPE_2="WAREHOUSE_TYPE_2";//是否启用类型为2的仓库（0不启用，1启用）包装材料仓库
	public static String WAREHOUSE_TYPE_1="WAREHOUSE_TYPE_1";//是否启用类型为1的仓库（0不启用，1启用）原辅料仓库
}
