package com.bbm.testspringdata.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;
	private String email;
	private int idade;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Telefone> telefone;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_proj",
				joinColumns={@JoinColumn(name = "usuario_id")},
				inverseJoinColumns= {@JoinColumn(name = "projecto_id")})
	private List<Projecto> projectos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public List<Projecto> getProjectos() {
		return projectos;
	}

	public void setProjectos(List<Projecto> projectos) {
		this.projectos = projectos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", idade=" + idade + ",\n" + telefone + "]";
	}

}
