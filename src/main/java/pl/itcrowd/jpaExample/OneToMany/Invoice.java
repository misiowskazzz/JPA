package pl.itcrowd.jpaExample.OneToMany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Tags: misiek
 * Date: 2/11/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OrderColumn
    @OneToMany(cascade = CascadeType.ALL)
    private List<LineItem> lineItems;

    public Invoice() {
    }

    public Invoice(String name, List<LineItem> lineItems) {
        this.name = name;
        this.lineItems = lineItems;
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

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}