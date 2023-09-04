package com.example.taskOne.dao.dataService;

import com.example.taskOne.dao.BasketDao;
import com.example.taskOne.model.Basket;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BasketDataAccessService implements BasketDao {
    @Override
    public Optional<Basket> findOneByBasketId(long basketId) {
        return Optional.empty();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Basket> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Basket> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Basket> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Basket getOne(Long aLong) {
        return null;
    }

    @Override
    public Basket getById(Long aLong) {
        return null;
    }

    @Override
    public Basket getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Basket> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Basket> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Basket> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Basket> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Basket> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Basket> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Basket, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Basket> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Basket> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Basket> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Basket> findAll() {
        return null;
    }

    @Override
    public List<Basket> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Basket entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Basket> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Basket> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Basket> findAll(Pageable pageable) {
        return null;
    }
}
