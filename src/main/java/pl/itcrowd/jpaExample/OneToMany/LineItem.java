package pl.itcrowd.jpaExample.OneToMany;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Tags: misiek
 * Date: 2/11/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "INVOICE_ITEM")
public class LineItem implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_PRICE")
    private BigDecimal itemPrice;

    public LineItem() {
    }

    public LineItem(String itemName, BigDecimal itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}