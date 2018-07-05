package models;

import javax.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {

    private int id;
    private String name;
    private Game favourite;

    public Owner() {
    }

    public Owner(String name, Game favourite) {
        this.name = name;
        this.favourite = favourite;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    public Game getFavourite() {
        return favourite;
    }

    public void setFavourite(Game favourite) {
        this.favourite = favourite;
    }

}
