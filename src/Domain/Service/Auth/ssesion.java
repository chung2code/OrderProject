package Domain.Service.Auth;

public class ssesion {
	
	private String s_id; 	//세션id
	private String id;		//유저 id
	private String role;	//회원 관리자 역할구분
	
	
	public ssesion(String s_id, String id, String role) {
		super();
		this.s_id = s_id;
		this.id = id;
		this.role = role;
	}


	@Override
	public String toString() {
		return "ssesion [s_id=" + s_id + ", id=" + id + ", role=" + role + "]";
	}


	public String gets_id() {
		return s_id;
	}


	public void sets_id(String s_id) {
		this.s_id = s_id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
		
	}
	
	
	
	

}
