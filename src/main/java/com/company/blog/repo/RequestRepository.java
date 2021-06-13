package com.company.blog.repo;



import com.company.blog.models.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {

//    List<Request> findAllByOrderByIdDesc();

    List<Request> findAllByOrderByIdDesc();

    List<Request> findAllByStatusOrderByIdDesc(String status);
    List<Request> findAllByRoomOrderByIdDesc(String room);

//    default Collection<Request> findElectro() {
//        return findByToWhomOrderByIdDesc("Электромонтер");
//    }
    //Collection<Request> findByToWhomOrderByIdDesc(String электромонтер);



    @Query("SELECT u FROM Request u WHERE u.toWhom = 'Электромонтер' AND u.status = 'Не выполнено' OR u.toWhom = 'Электромонтер' AND u.status = 'На выполнении'  ORDER BY u.id DESC")
    Collection<Request> findElectroByOrderByIdDesc();

    @Query("SELECT u FROM Request u WHERE u.toWhom = 'Сантехник' AND u.status = 'Не выполнено' OR u.toWhom = 'Сантехник' AND u.status = 'На выполнении'  ORDER BY u.id DESC")
    Collection<Request> findSantechnikByOrderByIdDesc();

    @Query("SELECT u FROM Request u WHERE u.toWhom = 'Комплексный_рабочий' AND u.status = 'Не выполнено' OR u.toWhom = 'Комплексный_рабочий' AND u.status = 'На выполнении'  ORDER BY u.id DESC")
    Collection<Request> findKomplByOrderByIdDesc();

    @Query("SELECT u FROM Request u WHERE u.toWhom = 'Горничная' AND u.status = 'Не выполнено' OR u.toWhom = 'Горничная' AND u.status = 'На выполнении'  ORDER BY u.id DESC")
    Collection<Request> findGornichnayaByOrderByIdDesc();

   // Iterable<Request> findByStatusAndToWhom(String filter, String электромонтер);
//    Iterable<Request> findByStatusAndToWhom(String filter, String toWhom);

    List<Request> findByStatusAndToWhom(String filter, String toWhom);





}
