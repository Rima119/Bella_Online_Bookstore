package rm.entity;


public class authorDB {
	private String fullName;
	private String birthDate;
	private String description;
	private String photo;
	

	public authorDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public authorDB(String fullName, String birthDate, String description, String photo) {
		super();
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.photo = photo;
		this.description = description;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "authorDB [Full name=" + fullName + ", BirthDate=" + birthDate
				+ ", description=" + description + "photo=" + photo + "]";
	}

}
