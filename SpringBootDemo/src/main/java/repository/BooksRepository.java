package repository;

import model.Books;
import java.util.*;
//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Books, Integer>
{
    List<Books> findAll();

    Map<Object, Object> findById(int id);

    void save(Books books);

    void deleteById(int id);
}