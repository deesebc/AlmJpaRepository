/**
 * 
 */
package es.home.almacen.bbdd.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
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
public class BookRepositoryImpl extends AbstractRepositoryImpl<Libro> implements
		BookRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<Libro> findSearchBooks(final String nombre, final String autor, final String serie,
			final Pageable pagina) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Libro> query = builder.createQuery(Libro.class);
		Root<Libro> root = query.from(Libro.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (StringUtils.hasText(nombre)) {
			// predicates.add(builder.equal(root.get("nombre"), nombre));
			predicates.add(builder.like(root.<String> get("nombre"), nombre));
		} else if (StringUtils.hasText(autor)) {
			// predicates.add(builder.equal(root.get("autor"), autor));
			predicates.add(builder.like(root.<String> get("autor"), autor));
		} else if (StringUtils.hasText(serie)) {
			predicates.add(builder.like(root.<String> get("serie"), serie));
			// predicates.add(builder.equal(root.get("serie"), serie));
		}

		Predicate whereClause = builder.and(predicates.toArray(new Predicate[predicates.size()]));
		query.where(whereClause);

		if (pagina != null) {
			query.orderBy(QueryUtils.toOrders(pagina.getSort(), root, builder));
		}

		Long total = getQueryForCount(builder, whereClause);

		return readPage(em.createQuery(query.select(root)), pagina, total);

	}

}
