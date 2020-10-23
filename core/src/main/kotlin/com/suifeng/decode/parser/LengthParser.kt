package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.LengthData

/**
 * 长度数据块解析类
 *@author suifengczc
 *@date 2020/10/22
 */
class LengthParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        var lengthData = abstractUnitData as LengthData
        var value = lengthData.getIntValue()
        lengthData.rawString = Integer.toBinaryString(value)
        lengthData.showValue = value.toString()
        lengthData.length = value
    }
}