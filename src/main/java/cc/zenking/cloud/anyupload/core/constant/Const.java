package cc.zenking.cloud.anyupload.core.constant;

/**
 * 需要用到的枚举值 固定的  不需要在properties中配置的
 * Created by cjc on 2016/12/29.
 */
public class Const {

	public static String ADD = "add";
	
	public static String UPDATE = "update";
	
	public static String SYSTEM_NAME = "anyupload";
	
	public static String SYSTEM_LOGIN = "login";
	
	public static final String LOGIN_GATE = "login:gate:session:";

	public static final String GATE_TOKEN = "gateToken";
	
	//待审核
	public static final String TOAUDIT_COUNT = "menu_anyupload_prolem_manage_audit";
	
	//待上报
	public static final String TOREPORTED_COUNT = "menu_anyupload_prolem_manage_reported";
	
	//待再次审核
	public static final String TOTWOREPORTED_COUNT = "menu_anyupload_prolem_manage_two_audit";
	
	//待提交成果
	public static final String TOSUBMITSUBJECT_COUNT = "menu_anyupload_myprolem_add";
	
	//待修改课题
	public static final String TOUPDATESUBJECT_COUNT = "menu_anyupload_myprolem_add";

    /**
     * 轮播图
     */
    public static class PicturePlay {
        public static final Integer ON_LINE = 1;
        public static final Integer OFF_LINE = 0;
        //允许上线数量
        public static final Integer ON_LINE_NUM = 5;
    }

    /**
     * 应用
     */
    public static class Application {
        public static final Integer RECOMMENDED = 1;
        public static final Integer NO_RECOMMENDED = 0;
    }

    /**
     * 友情链接
     */
    public static class FriendshipLink {
        public static final Integer ON_LINE = 1;
        public static final Integer OFF_LINE = 0;
    }
}
