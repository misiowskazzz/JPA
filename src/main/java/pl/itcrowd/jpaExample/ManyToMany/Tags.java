package pl.itcrowd.jpaExample.ManyToMany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Tags: misiek
 * Date: 2/11/13
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "TAGS")
public class Tags implements Serializable {
    @Id
    @SequenceGenerator(name = "TAGS_ID_SEQUENCE", sequenceName = "TAGS_ID_SEQUENCE", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TAGS_ID_SEQUENCE")
    private Long id;

    @Column(name="CONTENT")
    private String content;

    @Column(name="BLOGENTRYLIST")
    @ManyToMany(mappedBy = "tagsList")
    private List<BlogEntry> blogEntryList;

    public Tags() {
    }

    public Tags(String content, List<BlogEntry> blogEntryList) {
        this.content = content;
        this.blogEntryList = blogEntryList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BlogEntry> getBlogEntryList() {
        return blogEntryList;
    }

    public void setBlogEntryList(List<BlogEntry> blogEntryList) {
        this.blogEntryList = blogEntryList;
    }
}
