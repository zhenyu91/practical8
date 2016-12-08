package model;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;
/**
 * Created by 150436P on 12/8/2016.
 */
public class BookDAO {
    private Random random = new Random();
    private EntityManager em;

    public BookDAO() {
        em = EMF.get().createEntityManager();
    }
    public BooksEntity getBook() {
        List<BooksEntity> list = getAllBook();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
    public List<BooksEntity> getAllBook() {
        List<BooksEntity> list = null;
        try {
            Query query = em.createQuery("select b from BooksEntity b");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}