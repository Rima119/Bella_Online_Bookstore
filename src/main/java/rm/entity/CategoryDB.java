package rm.entity;

public class CategoryDB {

	private String name;
	private String description;

	public CategoryDB() {
		super();
	}

	public CategoryDB(String name, String description, String photo) {
		super();
		this.name = name;
		this.description = description;
		this.photo = photo;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private String photo;

	@Override
	public String toString() {
		return "CategoryDB [name=" + name + ", description=" + description + "photo=" + photo
				+ "]";
	}

}
