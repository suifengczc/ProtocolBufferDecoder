package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData

/**
 * 抽象解析类
 *@author suifengczc
 *@date 2020/10/15
 */
public abstract class AbstractParser {

    /**
     * 子类实现具体的解析方法
     */
    abstract fun parseData(abstractUnitData: AbstractUnitData)


}