package org.practice.common.core.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@ApiModel(value = "通知结果")
public class BaseNotify<T> {

    @JsonIgnore
    public static long failedSaveTime = 1000 * 60 * 10L;
    @JsonIgnore
    protected int failedListSize;
    @ApiModelProperty(value = "成功记录数")
    protected int successCount;
    @ApiModelProperty(value = "通知id 导出失败信息时 使用此id, 保存时间为十分钟")
    private String notifyId;
    @ApiModelProperty(value = "失败数量")
    private int failedCount;
    @ApiModelProperty(value = "失败集合")
    private List<T> returnFailedList;
    @JsonIgnore
    private List<T> failedList;

    {
        this.failedCount = 0;
        this.successCount = 0;
        this.failedListSize = 100;
    }

    public final void addFailed(T t) {
        if (returnFailedList == null) {
            returnFailedList = new ArrayList<>(failedListSize);
        }
        if (failedList == null) {
            failedList = new ArrayList<>();
        }
        if (returnFailedList.size() < failedListSize) {
            returnFailedList.add(t);
        }
        failedList.add(t);
        this.failedCount++;
    }

    public final void success() {
        successCount++;
    }
}
