package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.store.entity.Order;
import poly.store.entity.Product;

public interface ProductService {

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	

	Product getReferenceById(Integer id);

	Product getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Product> entities);

	Product getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	<S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Integer id);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	<S extends Product> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Product> entities);

	<S extends Product> long count(Example<S> example);

	void deleteInBatch(Iterable<Product> entities);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Product> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void flush();

	<S extends Product> List<S> saveAll(Iterable<S> entities);

	Optional<Product> findById(Integer id);

	List<Product> findAllById(Iterable<Integer> ids);

	List<Product> findAll(Sort sort);

	Page<Product> findAll(Pageable pageable);

	List<Product> findAll();

	<S extends Product> Optional<S> findOne(Example<S> example);

	<S extends Product> S save(S entity);

	Product findByid(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	<S extends Product> List<S> findAll(Example<S> example);
	
	Page<Product> findByNameContaining(String name, Pageable pageable);



	List<Product> findByNameContaining(String name);



	Page<Product> findAllpage(Pageable pageable);
	
	List<Product> listAllByID();

}
