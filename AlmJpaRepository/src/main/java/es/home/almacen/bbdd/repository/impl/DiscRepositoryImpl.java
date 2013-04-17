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
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import es.home.almacen.bbdd.bean.Disco;
import es.home.almacen.bbdd.repository.DiscRepositoryCustom;

/**
 * @author xe29197
 * 
 */
@Repository
public class DiscRepositoryImpl extends AbstractRepositoryImpl<Disco> implements
		DiscRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<Disco> findSearchDiscs(final String nombre, final String grupo,
			final Pageable pagina) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Disco> query = builder.createQuery(Disco.class);
		Root<Disco> root = query.from(Disco.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (StringUtils.hasText(nombre)) {
			predicates.add(builder.like(root.<String> get("nombre"), nombre));
		} else if (StringUtils.hasText(grupo)) {
			predicates.add(builder.like(root.<String> get("grupo"), grupo));
		}

		Predicate whereClause = builder.and(predicates.toArray(new Predicate[predicates.size()]));
		query.where(whereClause);

		if (pagina != null) {
			query.orderBy(QueryUtils.toOrders(pagina.getSort(), root, builder));
		}

		Long total = getQueryForCount(builder, whereClause);

		Path<Integer> identPath = root.get("ident");
		Path<String> nombrePath = root.get("nombre");
		Path<String> grupoPath = root.get("grupo");
		CriteriaQuery<Disco> cqd = query.multiselect(identPath, nombrePath, grupoPath);

		return readPage(em.createQuery(cqd), pagina, total);
	}

}
