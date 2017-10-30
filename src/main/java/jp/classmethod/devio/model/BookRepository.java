package jp.classmethod.devio.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mochizukimasao on 2017/10/26.
 *
 * @author mochizukimasao
 * @since version
 */
public interface BookRepository extends CrudRepository<Book, String> {

	List<Book> findByUserId(String userId);
}
