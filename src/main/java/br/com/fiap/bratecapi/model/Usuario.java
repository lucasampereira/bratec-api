package br.com.fiap.bratecapi.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "TB_Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@SequenceGenerator(name = "Usuario", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class Usuario implements UserDetails{

    @Id 
    @Column(name="cd_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuario")
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
	private String name;

    @Column(name = "email", nullable = false, length = 50)
	private String email;
    
	@JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "senha", nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

	public Usuario() {
		super();
	}

    public Usuario(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String getPassword() {
		return this.password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
