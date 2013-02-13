package pl.itcrowd.jpaExample.ManyToMany;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Tags: misiek
 * Date: 2/11/13
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "BLOGENTRY")
public class BlogEntry {

    @Id
    @SequenceGenerator(name = "BLOGENTRY_ID_SEQUENCE", sequenceName = "BLOGENTRY_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BLOGENTRY_ID_SEQUENCE")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTEXT")
    private String context;

    @Column(name = "TAGLIST")
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Tags> tagsList;

    public BlogEntry() {
    }

    public BlogEntry(String title, String context, List<Tags> tagsList) {
        this.title = title;
        this.context = context;
        this.tagsList = tagsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
