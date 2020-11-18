package back.controller;

import back.services.Authentication;
import back.services.Goods;
import back.services.GoodsManagement;
import back.services.Purchase;
import back.bean.MemberBean;
import config.config;


public class FrontController {
	

	public Authentication auth;
	public Goods goods;
	public GoodsManagement manage;
	public Purchase purchase;
	
	
	public FrontController() {
		
		this.auth = new Authentication();
		this.goods = new Goods();
		this.manage = new GoodsManagement();
		this.purchase = new Purchase();
		
	}
	public void Control() {}
	
	
	/*
	 * @name 		public	 	duplicatedID
	 * @param		String[] 	userInfo
	 * @return  	boolean
	 * @serviceCode 1
	 * true if two IDs from memberInfo and idCheck duplicated.
	 * "1" if duplicated else "0"
	 * */
	public String [] duplicatedID(String [] userInfo) {
		String[] idCheck = new String[1];
		MemberBean member = new MemberBean();
		
		member.setMemberId(userInfo[config.ID_IDX]);
		idCheck[0] = (auth.control(config.USER_DUP_CHECK, member) ?
				config.S_DUPLICATED : config.S_NONDUPLICATED); 
		return idCheck;
	}
	

	/*
	 * @name 		public	 	joinMember
	 * @param		String[]	userInfo
	 * @return		String[] 	memberInfo
	 * @serviceCode 2
	 * @reference	Authentication
	 * */
	public String[] joinMember(String[] userInfo) {
		String[] memberInfo = new String[config.MEMBER_INFO_ENTRY+1];
		MemberBean member = new MemberBean();
		
		member.setMemberId(userInfo[config.ID_IDX]);
		member.setMemberName(userInfo[config.NAME_IDX]);
		member.setMemberPWD(userInfo[config.PW_IDX]);
		member.setMemberType(userInfo[config.BUSINESS_TYPE_IDX]);
		member.setMemberAge(Integer.parseInt(userInfo[config.AGE_IDX]));
			
		auth.control(config.USER_JOIN, member);
		return memberInfo;
	}
	
}
