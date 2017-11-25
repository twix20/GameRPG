package Models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Player")
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class AppUser {
	
	@Id
	@Column(name ="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="Type")
	private String type;
	
	@Column(name ="Nickname")
	private String nickname;
	
	@Column(name ="Password")
	private String password;
	
	@Column(name ="CreatedAt")
	private Date registerDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}
