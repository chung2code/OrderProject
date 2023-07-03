package Domain.Service.Auth;

public class ssesion {
	
	private String u_id; //회원 id
	private String id;		//res id
	private String role;	//회원 관리자 역할구분
	
	
	public ssesion(String u_id, String id, String role) {
		super();
		this.u_id = u_id;
		this.id = id;
		this.role = role;
	}


	@Override
	public String toString() {
		return "ssesion [u_id=" + u_id + ", id=" + id + ", role=" + role + "]";
	}


	public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
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
