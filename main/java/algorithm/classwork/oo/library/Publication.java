package algorithm.classwork.oo.library;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/24 11:30
 */
public abstract class Publication implements Comparable<Publication> {
    String title;
    List<Author> authors;
    String publishTime;
    String pageCode;

    @Override
    public int compareTo(Publication o) {
        int diff =Integer.valueOf(publishTime) - Integer.valueOf(o.getPublishTime());
        if (diff != 0){
            return diff;
        }
        return authors.get(0).getLastName().compareTo(o.getAuthors().get(0).getLastName());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }


}
