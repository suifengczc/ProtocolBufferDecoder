package com.suifeng.decode.parser

import com.suifeng.decode.ProtoReader
import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 2时，嵌套结构的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class EmbeddedParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        val valueData = abstractUnitData as ValueData
        valueData.rawString = java.lang.Long.toBinaryString(valueData.getSignedLongValueTotal())
        var read = ProtoReader.read(valueData.value, valueData.indent + 1)
        valueData.subValue = read
    }
}