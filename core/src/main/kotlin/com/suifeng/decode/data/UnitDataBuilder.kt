package com.suifeng.decode.data

import com.suifeng.decode.parser.ParserManager
import java.util.ArrayList

/**
 * 数据块生成类
 * 根据指定的数据块类型创建对应的数据块
 *@author suifengczc
 *@date 2020/10/21
 */
object UnitDataBuilder {

    private val value: MutableList<BitData> = ArrayList()

    fun add(bitData: BitData) {
        value.add(bitData)
    }

    private fun clear() {
        value.clear()
    }

    fun build(unitType: UnitType, valueType: ValueType): AbstractUnitData {
        var abstractUnitData = when (unitType) {
            UnitType.TypeUnit -> TypeData(value, ParserManager.getParser(unitType))
            UnitType.LengthUnit -> LengthData(value, ParserManager.getParser(unitType))
            UnitType.ValueUnit -> ValueData(value, ParserManager.getParser(valueType))
        }
        clear()
        return abstractUnitData
    }
}