package cn.sjzc.manageSystem.vo;

import java.util.List;

import com.github.pagehelper.Page;

/** @className 
 * @description 
 * @author szh
 * @date 2018年7月23日
 */

public class PageBaseVO<T> {
	
	private int count;
	
	private List<T> data;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	/** 需要返回包装类的list   
	 * ep：List<xxxxVO>
	 * @methodName 
	 * @description 
	 * @author szh
	 * @date 2018年7月23日
	 */ 
	@SuppressWarnings("rawtypes")
	public static<T,E> PageBaseVO<E> pageBack( List<T> source,List<E> target){
		long total = ( (Page) source).getTotal();
		PageBaseVO<E> vos = new PageBaseVO<E>();
		vos.setCount(Long.valueOf(total).intValue());
		vos.setData(target);
		return vos;
	}
	
	/** 需要返回model类list   
	 * @methodName 
	 * @description 
	 * @author szh
	 * @date 2018年7月23日
	 */
	@SuppressWarnings("rawtypes")
	public static<T> PageBaseVO<T> pageBack( List<T> source){
		long total = ( (Page) source).getTotal();
		PageBaseVO<T> vos = new PageBaseVO<T>();
		vos.setCount(Long.valueOf(total).intValue());
		vos.setData(source);
		return vos;
	}
}
