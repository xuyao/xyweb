package cn.nb.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseController {
	
	protected Log log = LogFactory.getLog(getClass());
	
	/**
	 * 分页计算：计算当前查询起始index
	 * @param count 查询的总记录数
	 * @return 查询起始数
	 */
	protected int pageCount(int count , int pageNo ,int pageSize){		
		int currentPage = pageNo == 0 ? 1 : pageNo; //得到当前页
		int beginIndex = (currentPage - 1) * pageSize; //查询起始数
		int pagecount = count%pageSize == 0 ? count/pageSize : count/pageSize + 1;
		if (pageNo > pagecount) {
			pageNo = pagecount;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		return beginIndex;
	}
	
}
