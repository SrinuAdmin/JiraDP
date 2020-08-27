package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hib_addr")
public class Address {

	@Id
	private Integer hno;
	private String area;
	private Integer pinCode;

}
