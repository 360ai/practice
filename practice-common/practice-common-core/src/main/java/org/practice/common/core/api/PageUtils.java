package org.practice.common.core.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class PageUtils<T> implements Serializable {

	private static final long serialVersionUID = -2419461766241588799L;
	@ApiModelProperty(value = "响应内容", required = true)
	@JsonProperty("content")
	private T content;

	@ApiModelProperty(value = "总记录数", required = true)
	@JsonProperty("total")
	private long total;

	@ApiModelProperty(value = "总页数", required = true)
	@JsonProperty("totalPages")
	private int totalPages;

	/**
	 * 分页
	 *
	 * @param list
	 *            列表数据

	 * @param total
	 *            记录数
	 * @param list
	 *            每页多少个
	 */
	public PageUtils(T list, long total, int pageSize) {
		this.content = list;
		this.total = total;
		this.totalPages = (int)(total +  pageSize - 1)/ pageSize;
	}

	public PageUtils(T list, long total, int pageSize, int totalPages) {
		this.content = list;
		this.total = total;
		this.totalPages = totalPages;
	}

	public PageUtils(){}

	/**
	 * 代码分页
	 * @param page  已有当前页+每页记录数
	 * @param result
	 * @return
	 */
	public static IPage pageResult(IPage page, List result) {
		if( CollectionUtils.isEmpty(result) ){
			page.setTotal(0);
			page.setPages(0);
			return page;
		}
		int total = result.size();
		long pageSize = page.getSize();
		long pageNum = page.getCurrent();
		long pages = (total+pageSize-1)/pageSize;
		page.setTotal(total);
		page.setPages(pages);
		//跳转页比总页数大
		if( pageNum > pages ){
			return page;
		}
		List temp = new ArrayList<>();
		long max = pageNum*pageSize ;
		if( max > result.size() ){
			max = result.size();
		}
		for (long i = (pageNum-1)*pageSize ; i < max ; i++) {
			temp.add(result.get(Long.valueOf(i).intValue()));
		}
		page.setRecords(temp);
		return page;
	}
}
