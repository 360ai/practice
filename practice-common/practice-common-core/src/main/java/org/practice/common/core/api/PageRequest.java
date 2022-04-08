package org.practice.common.core.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "换页参数")
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 5791002527831580919L;

    @NotNull(message = "当前页数不能为空")
    @Min(0)
    @ApiModelProperty(value = "[必填,当前页数]", name = "pageNum", example = "1", required = true)
    private Integer pageNum;

    @NotNull(message = "每页显示条数不能为空")
    @Range(min = 1, max = 100, message = "pageSize must be range between 1 and 100")
    @ApiModelProperty(value = "[必填,每页条数]", name = "pageSize", example = "10", required = true)
    private Integer pageSize;
}
