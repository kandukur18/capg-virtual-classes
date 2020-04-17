package in.tp.jpa.hib.demo.models.groupcontact;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Groups")
public class Group {
	@Id
	private int gId;
	private String gName;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="group")
	private Set<Contact> contacts;
	
	

	public Group(int gId, String gName, Set<Contact> contacts) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.contacts = contacts;
	}

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

}
