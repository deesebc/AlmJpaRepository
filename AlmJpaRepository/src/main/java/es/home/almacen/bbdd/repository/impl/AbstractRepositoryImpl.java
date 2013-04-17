/**
 * 
 */
package es.home.almacen.bbdd.repository.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * @author xe29197
 * 
 */
@Repository
public abstract class AbstractRepositoryImpl<T> {

	@PersistenceContext
	private EntityManager em;

	protected Class<T> genericClass;

	@SuppressWarnings("unchecked")
	public AbstractRepositoryImpl() {
		this.genericClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),
				AbstractRepositoryImpl.class);
	}

	private Class<T> getGenericClass() {
		return genericClass;
	}

	protected Long getQueryForCount(final CriteriaBuilder builder, final Predicate whereClause) {
		CriteriaQuery<Long> cq = builder.createQuery(Long.class);
		cq.select(builder.count(cq.from(getGenericClass())));
		// Following line if commented causes
		// [org.hibernate.hql.ast.QuerySyntaxException: Invalid path:
		// 'generatedAlias1.xxxx'
		em.createQuery(cq);
		cq.where(whereClause);
		return em.createQuery(cq).getSingleResult();
	}

	protected Page<T> readPage(final TypedQuery<T> query, final Pageable pageable, final Long total) {

		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());

		List<T> content = total > pageable.getOffset() ? query.getResultList() : Collections
				.<T> emptyList();

		return new PageImpl<T>(content, pageable, total);
	}
}
