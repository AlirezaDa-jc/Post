/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.domains;

import ir.ac.kntu.base.domains.BaseEntity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity<Long> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "nationalCode", nullable = false, unique = true)
    private long nationalCode;
    @Column(name = "discount", nullable = false)
    private boolean discount = false;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> postsFrom = new LinkedList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> postsTo = new LinkedList<>();

    public Customer() {
    }

    public Customer(String name, long nationalCode, List<Post> postsFrom, List<Post> postsTo) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.postsFrom = postsFrom;
        this.postsTo = postsTo;
    }

    public Customer(String name, long nationalCode) {
        this.name = name;
        this.nationalCode = nationalCode;
    }

    public boolean getDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }


    public List<Post> getPostsFrom() {
        return postsFrom;
    }

    public void setPostsFrom(List<Post> postsFrom) {
        this.postsFrom = postsFrom;
    }

    public void addPostsFrom(Post post) {
        postsFrom.add(post);
    }

    public void addPostsTo(Post post) {
        postsTo.add(post);
    }

    public List<Post> getPostsTo() {
        return postsTo;
    }

    public void setPostsTo(List<Post> postsTo) {
        this.postsTo = postsTo;
    }

    public void deleteReceivedPost(Post post) {
        postsTo.remove(post);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(nationalCode, customer.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationalCode);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", discount=" + discount +
                '}';
    }
}
