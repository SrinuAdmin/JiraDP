package in.nit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="hib_prod_tab")
public class Product {
	
	@Id
	private Integer prodId;
	private String prodName;
	private Double prodCost; 
	
	@OneToMany
	private List<Address> addr;

}
