package com.suifeng.decode.parser

import com.suifeng.decode.data.UnitType
import com.suifeng.decode.data.ValueType
import java.lang.RuntimeException

/**
 * 解析类的管理者，指定什么类型使用什么解析类
 *@author suifengczc
 *@date 2020/10/16
 */
class ParserManager {

    companion object {

        private val parserMap: Map<Any, AbstractParser> = hashMapOf(
            UnitType.TypeUnit to TypeParser(),
            UnitType.LengthUnit to LengthParser(),
            UnitType.ValueUnit to StringParser(),
            ValueType.DefaultValue to ValueParser(),
            ValueType.SintValue to SintParser(),
            ValueType.SlongValue to SLongParser(),
            ValueType.BooleanValue to BooleanParser(),
            ValueType.FixedIntValue to FixedIntParser(),
            ValueType.FixedLongValue to FixedLongParser(),
            ValueType.DoubleValue to DoubleParser(),
            ValueType.FloatValue to FloatParser(),
            ValueType.EmbeddedValue to EmbeddedParser(),
            ValueType.StringValue to StringParser(),
            ValueType.RepeatValue to RepeatParser(),
            ValueType.BytesValue to BytesParser(),

            )

        public fun getParser(unitType: UnitType): AbstractParser {
            return parserMap.getOrElse(unitType) { throw RuntimeException("unsupport UnitType: $unitType") }
        }

        public fun getParser(valueType: ValueType): AbstractParser {
            return parserMap.getOrElse(valueType) { throw RuntimeException("unsupport ValueType: $valueType") }
        }

    }


}