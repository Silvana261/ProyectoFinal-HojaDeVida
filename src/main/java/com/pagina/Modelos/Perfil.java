package com.pagina.Modelos;
import java.util.List;

/**
 * Modelo que representa al perfil con los datos de la persona de la hoja de vida
 */
public class Perfil {
    private List<Habilidad> habilidades;
    private String nombre;
    private String bio;
    private String experiencia;
    private String email;
    private String foto;
    private String banner;

    /**
     * Constructor vacío por defecto
     */
    public Perfil (){

    }

    /**
     * Constructor para la instancia de un perfil
     * @param nombre nombre del perfil
     * @param bio bio del perfil
     * @param experiencia experiencia del perfil (hoja de vida)
     * @param email email del perfil
     * @param foto ruta de la foto del perfil
     * @param banner banner de la foto del perfil
     * @param habilidades lista de habilidades del perfil
     */
    public Perfil (String nombre, String bio, String experiencia, String email, String foto, String banner, List<Habilidad> habilidades){
        this.nombre = nombre;
        this.bio = bio;
        this.experiencia = experiencia;
        this.email = email;
        this.foto = foto;
        this.banner = banner;
        this.habilidades = habilidades;
    }

    // Getters y setters
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}

