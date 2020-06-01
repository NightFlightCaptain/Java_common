package classwork.oo.library;

import java.util.Objects;

/**
 * @author: 小栗旬
 * @Date: 2019/10/24 11:29
 */
public class Author {
    private String lastName;
    private String firstName;
    private String email;
    private String department;


    public Author(String lastName, String firstName, String email, String department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(lastName, author.lastName) &&
                Objects.equals(firstName, author.firstName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lastName, firstName);
    }
}
