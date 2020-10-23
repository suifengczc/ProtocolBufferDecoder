package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * 默认数据块解析类
 *@author suifengczc
 *@date 2020/10/22
 */
class ValueParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        var valueData = abstractUnitData as ValueData
        var value = valueData.getLongValue()
        valueData.rawString = value.toString()
        valueData.showValue = value.toString()
    }
}