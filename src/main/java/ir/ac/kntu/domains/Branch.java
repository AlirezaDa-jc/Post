/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.domains;

import ir.ac.kntu.base.domains.BaseEntity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity<Long> {


    @Column(name = "employees", nullable = false)
    private int employees;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Post> posts = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "city")
    private City city;

    public Branch() {
    }

    public Branch(int employees, City city) {
        this.employees = employees;
        this.city = city;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setPosts(Post post) {
        posts.add(post);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void addPosts(Post post) {
        posts.add(post);
    }
}
