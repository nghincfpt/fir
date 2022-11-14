package poly.store.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;


import poly.store.DAO.ProductDao;
import poly.store.entity.Order;
import poly.store.entity.Product;
import poly.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
   @Autowired
   private ProductDao dao;

@Override
public <S extends Product> S save(S entity) {
	return dao.save(entity);
}

@Override
public <S extends Product> Optional<S> findOne(Example<S> example) {
	return dao.findOne(example);
}

@Override
public List<Product> findAll() {
	return dao.findAll();
}

@Override
public Page<Product> findAll(Pageable pageable) {
	return dao.findAll(pageable);
}

@Override
public List<Product> findAll(Sort sort) {
	return dao.findAll(sort);
}

@Override
public List<Product> findAllById(Iterable<Integer> ids) {
	return dao.findAllById(ids);
}

@Override
public Optional<Product> findById(Integer id) {
	return dao.findById(id);
}


@Override
 public Product findByid(Integer id) {
	return dao.findById(id).get();
}
@Override
public <S extends Product> List<S> saveAll(Iterable<S> entities) {
	return dao.saveAll(entities);
}

@Override
public void flush() {
	dao.flush();
}

@Override
public boolean existsById(Integer id) {
	return dao.existsById(id);
}

@Override
public <S extends Product> S saveAndFlush(S entity) {
	return dao.saveAndFlush(entity);
}

@Override
public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
	return dao.saveAllAndFlush(entities);
}

@Override
public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
	return dao.findAll(example, pageable);
}

@Override
public void deleteInBatch(Iterable<Product> entities) {
	dao.deleteInBatch(entities);
}

@Override
public <S extends Product> long count(Example<S> example) {
	return dao.count(example);
}

@Override
public void deleteAllInBatch(Iterable<Product> entities) {
	dao.deleteAllInBatch(entities);
}

@Override
public long count() {
	return dao.count();
}

@Override
public <S extends Product> boolean exists(Example<S> example) {
	return dao.exists(example);
}

@Override
public void deleteById(Integer id) {
	dao.deleteById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	dao.deleteAllByIdInBatch(ids);
}


@Override
public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return dao.findBy(example, queryFunction);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
	dao.deleteAllById(ids);
}

@Override
public void deleteAllInBatch() {
	dao.deleteAllInBatch();
}

@Override
public Product getOne(Integer id) {
	return dao.getOne(id);
}

@Override
public void deleteAll(Iterable<? extends Product> entities) {
	dao.deleteAll(entities);
}

@Override
public void deleteAll() {
	dao.deleteAll();
}

@Override
public Product getById(Integer id) {
	return dao.getById(id);
}

@Override
public Product getReferenceById(Integer id) {
	return dao.getReferenceById(id);
}

@Override
public <S extends Product> List<S> findAll(Example<S> example) {
	return dao.findAll(example);
}

@Override
public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
	return dao.findAll(example, sort);
}
   @Override
   public List<Product> findByCategoryId(String cid){
	   return dao.findByCategoryId(cid);
   }

@Override
public Product create(Product product) {
	// TODO Auto-generated method stub
	return dao.save(product);
}

@Override
public Product update(Product product) {
	// TODO Auto-generated method stub
	return dao.save(product);
}

@Override
public void delete(Integer id) {
	// TODO Auto-generated method stub
	 dao.deleteById(id);
	
}
@Override
public List<Product> findByNameContaining(String name) {
	return dao.findByNameContaining(name);
}


@Override
public Page<Product> findByNameContaining(String name, Pageable pageable) {
	return dao.findByNameContainingIgnoreCase(name, pageable);
}

@Override
public Page<Product> findAllpage(Pageable pageable) {
	return dao.findAll(pageable);
}
@Override
public List<Product> listAllByID(){
	   return dao.findAll(Sort.by("Address").ascending());
  }

}
