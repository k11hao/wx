package cn.oyjg.base.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.oyjg.base.dao.BaseDao;
import cn.oyjg.base.util.PageUtil;

@Service("baseService")
public class BaseService<T> {
	
	@Autowired
	@Qualifier("baseDao")
	protected BaseDao<T> dao;

	protected BaseDao<T> getDao() {
		return dao;
	}

	protected void setBaseDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public T get(Class<T> c, Serializable id) {
		T o = dao.get(c, id);
		return o;
	}

	public T add(T obj) {
		dao.saveOrUpdate(obj);
		return obj;
	}

	public T update(T obj) throws Exception {
		dao.update(obj);
		return obj;
	}

	public void delete(T obj) throws Exception {
		dao.delete(obj);
	}
	public Map<String,Object> init(Integer total,List data){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", data);
		return map;		
	}
	/**
	 * 将得到的数据转换为json格式
	 */
	protected Map<String,Object> JsonSwap(List lst,PageUtil page){
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("total", page.getRecordTotal());
		data.put("rows", lst);
		return data;
	}
	/**
	 * 将得到的数据转换为json格式
	 */
	protected Map<String,Object> JsonSwap(List lst){
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("total", lst.size());
		data.put("rows", lst);
		return data;
	}
}
