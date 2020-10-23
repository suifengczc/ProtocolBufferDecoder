package com.suifeng.decode.parser

import com.suifeng.decode.ProtoReader
import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 2时，packed repeated fields的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class RepeatParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        val valueData = abstractUnitData as ValueData
        valueData.rawString = java.lang.Long.toBinaryString(valueData.getSignedLongValueTotal())
        var read = ProtoReader.readRepeatData(valueData.value, valueData.indent + 1)
        valueData.subValue = read
    }
}