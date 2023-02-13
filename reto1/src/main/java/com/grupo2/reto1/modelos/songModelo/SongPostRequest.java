package com.grupo2.reto1.modelos.songModelo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SongPostRequest {

	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	private String titulo;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	private String autor;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	private String url;
	
	public SongPostRequest() {
		
	}

	public SongPostRequest(
			@NotNull(message = "No puede ser nulo") @NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String titulo,
			@NotNull(message = "No puede ser nulo") @NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String autor,
			@NotNull(message = "No puede ser nulo") @NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String url) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SongPostRequest [titulo=" + titulo + ", autor=" + autor + ", url=" + url + "]";
	}
	
}
