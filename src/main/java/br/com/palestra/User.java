package br.com.palestra;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "User.findAll",
        query = "SELECT c FROM User c ORDER BY c.id")
public class User {
    @Id
	@SequenceGenerator(
		name = "userSequence",
		sequenceName = "userId_seq",
		allocationSize = 1,
		initialValue = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	private Long id;
	private String nome;
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
