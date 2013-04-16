/**
 * 
 */
package es.home.almacen.bbdd.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import es.home.almacen.bbdd.bean.Libro;
import es.home.almacen.bbdd.repository.BookRepositoryCustom;

/**
 * @author xe29197
 * 
 */
@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<Libro> findSearchBooks(final String nombre, final String autor, final String serie,
			final Pageable pagina) {
		// int param = 1;
		// String[] aParam = new String[3];
		// StringBuilder sql = new
		// StringBuilder("select l from Libro l where 1=1");
		// StringBuilder sqlCount = new
		// StringBuilder("select count(l) from Libro l where 1=1");
		// if (StringUtils.hasText(nombre)) {
		// sql.append(" and l.nombre like ?").append(param);
		// sqlCount.append(" and l.nombre like ?").append(param);
		// aParam[param - 1] = nombre;
		// param++;
		// } else if (StringUtils.hasText(autor)) {
		// sql.append(" and l.autor like ?").append(param);
		// sqlCount.append(" and l.autor like ?").append(param);
		// aParam[param - 1] = autor;
		// param++;
		// } else if (StringUtils.hasText(serie)) {
		// sql.append(" and l.serie like ?").append(param);
		// sqlCount.append(" and l.serie like ?").append(param);
		// aParam[param - 1] = serie;
		// param++;
		// }
		//
		// TypedQuery<Libro> query = em.createQuery(sql.toString(),
		// Libro.class);
		// TypedQuery<Long> queryCount = em.createQuery(sqlCount.toString(),
		// Long.class);
		// for (int index = 0; index < 3; index++) {
		// if (aParam[index] != null) {
		// query.setParameter(index + 1, aParam[index]);
		// queryCount.setParameter(index + 1, aParam[index]);
		// }
		// }
		// long total = queryCount.getSingleResult();
		// Page<Libro> exit = readPage(query, pagina, total);
		Page<Libro> exit = method1(nombre, autor, serie, pagina);
		return exit;

	}

	public Long getQueryForCount(final CriteriaBuilder builder, final Predicate whereClause) {
		CriteriaQuery<Long> cq = builder.createQuery(Long.class);
		cq.select(builder.count(cq.from(Libro.class)));
		cq.where(whereClause);
		Long count = em.createQuery(cq).getSingleResult();
		return count;
	}

	public Page<Libro> method1(final String nombre, final String autor, final String serie,
			final Pageable pagina) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Libro> query = builder.createQuery(Libro.class);
		Root<Libro> root = query.from(Libro.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (StringUtils.hasText(nombre)) {
			predicates.add(builder.equal(root.get("nombre"), nombre));
		} else if (StringUtils.hasText(autor)) {
			predicates.add(builder.equal(root.get("autor"), autor));
		} else if (StringUtils.hasText(serie)) {
			predicates.add(builder.equal(root.get("serie"), serie));
		}

		Predicate whereClause = builder.and(predicates.toArray(new Predicate[predicates.size()]));
		query.where(whereClause);

		if (pagina != null) {
			query.orderBy(QueryUtils.toOrders(pagina.getSort(), root, builder));
		}

		Long total = getQueryForCount(builder, whereClause);

		return readPage(em.createQuery(query.select(root)), pagina, total);
	}

	private Page<Libro> readPage(final TypedQuery<Libro> query, final Pageable pageable,
			final Long total) {

		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());

		List<Libro> content = total > pageable.getOffset() ? query.getResultList() : Collections
				.<Libro> emptyList();

		return new PageImpl<Libro>(content, pageable, total);
	}

}
