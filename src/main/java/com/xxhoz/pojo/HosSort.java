package com.xxhoz.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  hos_sort: table
 * @Author  Sunk
 * @Date 2020-12-30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosSort  implements Serializable {

	private static final long serialVersionUID =  5362485509930119839L;

	/** 分类ID */
	private Integer sortId;

	/** 分类名称 */
	private String sortName;

	/** 分类描述 */
	private String sortDescription;

	/** 父分类ID */
	private Integer parentSortId;

	/** 分类别名 */
	private String sortAlias;

}
