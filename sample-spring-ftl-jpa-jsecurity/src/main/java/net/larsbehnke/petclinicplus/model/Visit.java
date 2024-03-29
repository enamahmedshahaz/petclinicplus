package net.larsbehnke.petclinicplus.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 * @author Lars Behnke
 */
public class Visit extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8355837672830445948L;

	/** Holds value of property date. */
	private Date date;

	/** Holds value of property description. */
	private String description;

	/** Holds value of property pet. */
	private Pet pet;


	/** Creates a new instance of Visit for the current date */
	public Visit() {
		this.date = new Date();
	}


	/** Getter for property date.
	 * @return Value of property date.
	 */
	public Date getDate() {
		return this.date;
	}

	/** Setter for property date.
	 * @param date New value of property date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** Getter for property description.
	 * @return Value of property description.
	 */
	public String getDescription() {
		return this.description;
	}

	/** Setter for property description.
	 * @param description New value of property description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Getter for property pet.
	 * @return Value of property pet.
	 */
	public Pet getPet() {
		return this.pet;
	}

	/** Setter for property pet.
	 * @param pet New value of property pet.
	 */
	protected void setPet(Pet pet) {
		this.pet = pet;
	}

}
