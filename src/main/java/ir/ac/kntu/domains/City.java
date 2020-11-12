/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.domains;

import ir.ac.kntu.base.domains.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City extends BaseEntity<Long> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "coordination", nullable = false)
    private String coordination;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Branch> branches = new HashSet<>();

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL)
    private List<Post> postsFrom = new LinkedList<>();

    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL)
    private List<Post> postsTo = new LinkedList<>();

    public City() {
    }

    public City(String name, String coordination) {
        this.name = name;
        this.coordination = coordination;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }

    public List<Post> getPostsFrom() {
        return postsFrom;
    }

    public void setPostsFrom(List<Post> postsFrom) {
        this.postsFrom = postsFrom;
    }

    public List<Post> getPostsTo() {
        return postsTo;
    }

    public void setPostsTo(List<Post> postsTo) {
        this.postsTo = postsTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String city) {
        this.name = city;
    }

    public String getCoordination() {
        return coordination;
    }

    public void setCoordination(String coordination) {
        this.coordination = coordination;
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public void addPostsTo(Post post) {
        postsTo.add(post);
    }

    public void addPostsFrom(Post post) {
        postsFrom.add(post);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", coordination='" + coordination + '\'' +
                '}';
    }
}
