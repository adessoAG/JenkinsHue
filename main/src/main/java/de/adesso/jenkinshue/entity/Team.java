package de.adesso.jenkinshue.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import de.adesso.jenkinshue.common.enumeration.Scenario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author wennier
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable {
	
	private static final long serialVersionUID = 2757216557245227462L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank
	@Column(unique = true)
	private String name;
	
	@NotNull
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Scenario> scenarioPriority;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Lamp> lamps;
	
	@OneToMany(mappedBy = "team")
	private List<User> users;

}
