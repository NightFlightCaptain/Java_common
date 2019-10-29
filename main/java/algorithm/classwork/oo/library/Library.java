package algorithm.classwork.oo.library;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/24 11:31
 */
public class Library {
    private List<Publication> publications;

    public Library(List<Publication> publications) {
        this.publications = publications;
    }

    public void addPublication(Publication publication) {
        this.publications.add(publication);
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public List<Publication> searchByAuthor(String authorName) {
        List<Publication> result = new LinkedList<>();
        for (Publication publication : publications) {
            List<Author> authors = publication.getAuthors();
            for (int i =0 ;i<authors.size();i++){
                if (authorName.equals(authors.get(i).getFirstName())
                        || authorName.equals(authors.get(i).getLastName())) {
                    result.add(publication);
                    break;
                }
            }
        }
        return result;
    }

    public boolean isSamePublication(Author author,Author another){
        for (Publication publication : publications) {
            List<Author> authors = publication.getAuthors();
            if (authors.contains(author) && authors.contains(another)){
                return true;
            }
        }
        return false;
    }
}
