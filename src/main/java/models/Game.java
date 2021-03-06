package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="games")
public class Game {

    private int id;
    private String name;
    private Genre genre;
    private List<Console> consoles;
    private List<Owner> favoritedBy;

    public Game() {
    }

    public Game(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
        this.consoles = new ArrayList<Console>();
        this.favoritedBy = new ArrayList<Owner>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ManyToMany
    @JoinTable(name = "game_console",
            joinColumns = {@JoinColumn(name="game_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="console_id", nullable = false, updatable = false)})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<Console> getConsoles() {
        return consoles;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
    }

    public void addConsole(Console console) {
        this.consoles.add(console);
    }

    @OneToMany(mappedBy="favourite", fetch = FetchType.LAZY)
    public List<Owner> getFavoritedBy() {
        return favoritedBy;
    }

    public void setFavoritedBy(List<Owner> favoritedBy) {
        this.favoritedBy = favoritedBy;
    }

    public void addOwnerWhoLovesIt(Owner owner) {
        this.favoritedBy.add(owner);
    }



}
