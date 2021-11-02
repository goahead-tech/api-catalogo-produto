package br.com.catalogo.repository.filter.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.catalogo.filter.ProdutoFilter;
import br.com.catalogo.model.Produto;
import br.com.catalogo.repository.ProdutoFilterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public class ProdutoFilterRepositoryImpl implements ProdutoFilterRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Produto> find(Pageable pageable, ProdutoFilter filter) {

        StringBuilder sql = new StringBuilder("from product c where 0 = 0 ");
        Map<String, Object> param = new HashMap<String, Object>();

        if (filter.getId() != null) {
            System.out.println(filter.getId());
            sql.append("and c.id = :id id");
            param.put("id id", filter.getId());
        }

        if (filter.getName() != null) {
            sql.append("and c.name = :name ");
            param.put("name", filter.getName());
        }
        if(filter.getMin_price() != null) {
            sql.append("and c.price >= :min_price ");
            param.put("min_price", filter.getMin_price());
        }
        if(filter.getMax_price() != null) {
            sql.append("and c.price <= :max_price ");
            param.put("max_price", filter.getMax_price());
        }

        TypedQuery<Produto> query = manager.createQuery(sql.toString(), Produto.class);
        param.forEach(query::setParameter);

        long size = (long) query.getResultList().size();

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        return new PageImpl<>(query.getResultList(), pageable, size);
    }
}
