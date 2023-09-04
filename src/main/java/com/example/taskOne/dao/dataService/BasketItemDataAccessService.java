package com.example.taskOne.dao.dataService;

import com.example.taskOne.dao.BasketItemDao;
import com.example.taskOne.model.BasketItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BasketItemDataAccessService implements BasketItemDao {

    @Override
    public Optional<BasketItem> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<BasketItem> findByBasketId(long basketId) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends BasketItem> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends BasketItem> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<BasketItem> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public BasketItem getOne(Long aLong) {
        return null;
    }

    @Override
    public BasketItem getById(Long aLong) {
        return null;
    }

    @Override
    public BasketItem getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends BasketItem> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends BasketItem> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends BasketItem> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends BasketItem> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BasketItem> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends BasketItem> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends BasketItem, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends BasketItem> S save(S entity) {
        return null;
    }

    @Override
    public <S extends BasketItem> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<BasketItem> findAll() {
        return null;
    }

    @Override
    public List<BasketItem> findAllById(Iterable<Long> longs) {
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
    public void delete(BasketItem entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends BasketItem> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<BasketItem> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<BasketItem> findAll(Pageable pageable) {
        return null;
    }
}
