package in.tp.jpa.hib.demo.models.groupcontact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="Contacts")
public class Contact implements Comparable<Contact>{
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int cID;
	private String firstName;
	private String lastname;
	private String mobileNo;
	private String mailID;
	private String dof;
	private String address;
	
	@ManyToOne
    @JoinColumn(name="groupid")
	private Group group;

	public Contact() {
	
		
	}

	public Contact(int cID, String firstName, String lastname, String mobileNo,
			String mailID, String dof,
			String address, Group group) {
		super();
		this.cID = cID;
		this.firstName = firstName;
		this.lastname = lastname;
		this.mobileNo = mobileNo;
		this.mailID = mailID;
		this.dof = dof;
		this.address = address;
		this.group = group;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	public String getDof() {
		return dof;
	}

	public void setDof(String dof) {
		this.dof = dof;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int compareTo(Contact o) {
	
		return (this.cID<o.cID?-1:(this.cID>o.cID?1:0));
	}

	
	
}
