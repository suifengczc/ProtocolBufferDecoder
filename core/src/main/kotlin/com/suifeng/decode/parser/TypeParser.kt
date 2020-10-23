package com.suifeng.decode.parser

import com.suifeng.decode.data.TypeData
import com.suifeng.decode.data.AbstractUnitData

/**
 * 类型数据块解析类
 *@author suifengczc
 *@date 2020/10/16
 */
class TypeParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        var typeData = abstractUnitData as TypeData
        var value = typeData.getIntValue()
        typeData.wireType = value and 0b00000111
        typeData.id = value shr 3
        typeData.showValue = "${typeData.wireType} - ${typeData.id}"
        typeData.rawString = Integer.toBinaryString(value)
    }

}