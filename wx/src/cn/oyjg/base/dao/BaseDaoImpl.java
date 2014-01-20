package cn.oyjg.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.oyjg.base.util.PageUtil;

/**
 * 
 * @author
 * 
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public T save(T o) throws Exception {
		try {
			this.getCurrentSession().save(o);
		} catch (Exception err) {
			err.printStackTrace();
			throw err;
		}		
		return o;
	}

	@Transactional
	public T update(T o) throws Exception {
		try {
			this.getCurrentSession().update(o);
		} catch (Exception err) {
			err.printStackTrace();
			throw err;
		}
		return o;
	}

	@Transactional
	public T saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
		return o;
	}

	public T merge(T o) {
		this.getCurrentSession().merge(o);
		return o;
	}

	@Transactional
	public void delete(T o) throws Exception {
		try {
			this.getCurrentSession().delete(o);
		} catch (Exception err) {
			err.printStackTrace();
			throw err;
		}		
	}

	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	public List<T> find(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	public List<T> find(String hql, PageUtil page, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}

		// 设置记录数
		if(hql.indexOf("group")!=-1){
			page.setRecordTotal(q.list().size());
		}else{
			page.setRecordTotal(count(hql, param).intValue());
		}
		//page.setRecordTotal(count(hql, param).intValue());
		return q.setFirstResult((page.getPageindex()-1)*page.getPagesize()).setMaxResults(page.getPagesize()).list();
	}

	public List<T> find(String hql, PageUtil page, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		// 设置记录数
		if(hql.indexOf("group")!=-1){
			page.setRecordTotal(q.list().size());
		}else{
			page.setRecordTotal(count(hql, param).intValue());
		}
		return q.setFirstResult((page.getPageindex()-1)*page.getPagesize()).setMaxResults(page.getPagesize()).list();
	}

	@Transactional
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql, Object... param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;
	}

	public T get(String hql, List<Object> param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;
	}

	public T load(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().load(c, id);
	}

	public Long count(String hql, Object... param) {
		hql = "select count(*) " + hql.substring(hql.indexOf("from"));
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}

		return (Long) q.list().get(0);
	}

	public Long count(String hql, List<Object> param) {
		hql = "select count(*) " + hql.substring(hql.indexOf("from"));
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.list().get(0);
	}

	public Integer executeHql(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

}
