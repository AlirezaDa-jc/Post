/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.domains;

import ir.ac.kntu.base.JalaliDate;
import ir.ac.kntu.base.domains.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "senddate")
    private String sendDate;

    @Column(name = "receivedate")
    private String receiveDate;

    @Column(name = "transportation")
    private String transportation;

    @Column(name = "situation", nullable = false)
    private String situation;

    @ManyToOne
    @JoinColumn(name = "senderid")
    private Customer sender;

    @ManyToOne
    @JoinColumn(name = "receiverid")
    private Customer receiver;

    @ManyToOne
    @JoinColumn(name = "branchid")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "cityfrom")
    private City from;

    @ManyToOne
    @JoinColumn(name = "cityto")
    private City to;

    public Post() {
    }

    public Post(String name, String type, double weight, String sendDate, String receiveDate, String transportation,
                String situation, Customer sender, Customer receiver, Branch branch, City to) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.sendDate = sendDate;
        this.receiveDate = receiveDate;
        this.transportation = transportation;
        this.situation = situation;
        this.branch = branch;
        setFrom(branch.getCity());
        setSender(sender);
        setReceiver(receiver);
        setTo(to);
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(JalaliDate sendDateJalali) {
        sendDate = sendDateJalali.toString();
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(JalaliDate receiveDateJalali) {
        receiveDate = receiveDateJalali.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer customerFrom) {
        this.sender = customerFrom;
        sender.addPostsFrom(this);
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer customerTo) {
        this.receiver = customerTo;
        receiver.addPostsTo(this);
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
        branch.addPosts(this);
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
        from.addPostsFrom(this);
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
        to.addPostsTo(this);
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", sendDate='" + sendDate + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                ", transportation='" + transportation + '\'' +
                ", situation='" + situation + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", branch=" + branch +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}


