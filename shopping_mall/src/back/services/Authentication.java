package back.services;
import back.bean.MemberBean;
import config.config;
public class Authentication {
	
	public String[][] members = {{"a", "원빈", "1234", "p"}}; 
	
	public Authentication() {
		
		
	}
	public boolean control(int serviceCode, MemberBean userInfo) {
		boolean service = false;
		switch(serviceCode) {
			case config.USER_DUP_CHECK:
				service = this.duplicateCheck(userInfo);
				break;
			case config.USER_JOIN:
				service = this.regUser(userInfo);
				break;
			default:
		}
		
		return service;
	}
	
	/*
	 * @author			wbkim91
	 * @name			private duplicateCheck
	 * @param			MemberBean member
	 * @return 			boolean isCheck
	 * 
	 * : True if duplicated else false
	 * 
	 */
	private boolean duplicateCheck(MemberBean member) {
		for(int idx = 0; idx<this.members.length; idx++) {
			if(member.getMemberId().equals(this.members[idx][config.ID_IDX])) {
				return config.B_DUPLICATED; // "1"
			}
		}
		return config.B_NONDUPLICATED;
		
	}
	
	/*
	 * @name 		private		searchMemberInfo
	 * @param		MemberBean	member
	 * @return		String[]	memberInfo
	 * @serviceCode	3
	 * 
	 * 
	 * */
	private String[] searchMemberInfo(MemberBean member) {
		String[] memberInfo = new String[config.MEMBER_INFO_ENTRY];
		
		memberInfo[config.ID_IDX] = member.getMemberId();
		memberInfo[config.NAME_IDX] = member.getMemberName();
		memberInfo[config.PW_IDX] = member.getMemberPWD();
		memberInfo[config.BUSINESS_TYPE_IDX] = member.getMemberType();
		memberInfo[config.AGE_IDX] = member.getMemberAge()+"";
		
		return memberInfo;
		
		
	}
	/*
	 * @author			wbkim91
	 * @name			private regUser
	 * @param			MemberBean member
	 * @return			boolean
	 * 
	 * True if successfully a user is registered.
	 * 
	 * */
	private boolean regUser(MemberBean member) {
		boolean isCheck = false;
		
		return isCheck;		
	}

	/*
	 * @author			wbkim91
	 * @name			private registrationMember
	 * @param			MemberBean member
	 * @return			void
	 * 
	 * From member data, register member
	 * 1. finally check id duplication 
	 * 2. DB gets member's data
	 * 3. display input data to User.
	 * */
	private void registrationMember(MemberBean member) {
		
		this.duplicateCheck(member);
		
		this.regUser(member);
		
		this.searchMemberInfo(member);
		
	}
	
	
	
	
	
	
	public void SignIn() {}
	public void SignUp() {}
	public void LogOut() {}
	public void Update() {}
	public void LogIn() {}
}
