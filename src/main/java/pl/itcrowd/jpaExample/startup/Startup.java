package pl.itcrowd.jpaExample.startup;

import pl.itcrowd.jpaExample.ElementCollection.Users;
import pl.itcrowd.jpaExample.ManyToMany.BlogEntry;
import pl.itcrowd.jpaExample.ManyToMany.Tags;
import pl.itcrowd.jpaExample.OneToMany.Invoice;
import pl.itcrowd.jpaExample.OneToMany.LineItem;
import pl.itcrowd.jpaExample.OneToOne.Employee;
import pl.itcrowd.jpaExample.OneToOne.EmployeeDetail;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Tags: misiek
 * Date: 2/11/13
 * Time: 11:48 AM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
@javax.ejb.Startup
public class Startup {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void startup() {
        addOneToManyEntry();
        addOneToOneEntry();
        ArrayList<Tags> tagList =new ArrayList<Tags>();
        tagList= (ArrayList<Tags>) entityManager.createQuery("Select t from Tags t").getResultList();
        //can get TagList instant from Base
        addElementCollection();
    }

    public void addOneToManyEntry() {
        LineItem lineItem1 = new LineItem();
        lineItem1.setItemName("Telekompunikacja PL");
        lineItem1.setItemPrice(BigDecimal.TEN);
        LineItem lineItem2 = new LineItem();
        lineItem2.setItemName("ENION");
        lineItem2.setItemPrice(BigDecimal.ONE);

        Invoice invoice = new Invoice();
        invoice.setName("Moja faktura");
        invoice.setLineItems(new ArrayList<LineItem>());
        invoice.getLineItems().add(lineItem1);
        invoice.getLineItems().add(lineItem2);
        entityManager.persist(invoice);
    }

    public void addManyToManyEntry() {
        BlogEntry blogEntry1=new BlogEntry();
        BlogEntry blogEntry2=new BlogEntry();
        Tags tags1=new Tags();
        Tags tags2=new Tags();

        blogEntry1.setTitle("Tytul1");
        blogEntry2.setTitle("Tytul2");
        blogEntry1.setContext("context1");
        blogEntry2.setContext("context2");

        ArrayList<BlogEntry> blogEntryList=new ArrayList<BlogEntry>();
        blogEntryList.add(blogEntry1);
        blogEntryList.add(blogEntry2);

        tags1.setContent("TagsContent1");
        tags2.setContent("TagsContent2");

        ArrayList<Tags> tagsList=new ArrayList<Tags>();
        tagsList.add(tags1);
        tagsList.add(tags2);

        blogEntry1.setTagsList(tagsList);
        blogEntry2.setTagsList(tagsList);
        tags1.setBlogEntryList(blogEntryList);
        tags2.setBlogEntryList(blogEntryList);

        entityManager.persist(blogEntry1);
        entityManager.persist(blogEntry2);
        //do not have to explicite persist couse there is cascade in BlogEntry.TagList
    }

    public void addOneToOneEntry() {
        Employee employee = new Employee();
        EmployeeDetail employeeDetail = new EmployeeDetail();

        employee.setFirstname("Frank");
        employee.setCellphone("0 601840788");

        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setCity("California");
        employeeDetail.setStreet("Ponny st.");
        employeeDetail.setEmployee(employee);

        entityManager.persist(employee);
        entityManager.persist(employeeDetail);
    }

    public void addElementCollection(){
           ArrayList<String> certList=new ArrayList<String>();
        certList.add("010110001");
        certList.add("110110201");
        certList.add("010111001");
        certList.add("010110031");

        Users user=new Users();
        user.setName("Bobby");
        user.setCertifications(certList);

        entityManager.persist(user);
    }
}
