package object;

public class User {
    private String login;
    private String password;
    private String confinrmPassword;
    private String email;
    private String rights;
	
    public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfinrmPassword() {
		return confinrmPassword;
	}
	public void setConfinrmPassword(String confinrmPassword) {
		this.confinrmPassword = confinrmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", confinrmPassword=" + confinrmPassword + ", email="
				+ email + ", rights=" + rights + "]";
	}
    
}
