package com.suifeng.decode.data

import java.lang.RuntimeException

/**
 *
 *@author suifengczc
 *@date 2020/10/16
 */
class AllType {
    companion object {
        fun nextType(unitData: AbstractUnitData): UnitType {
            return when (unitData) {
                is TypeData -> {
                    when (unitData.wireType) {
                        0, 1, 5 -> UnitType.ValueUnit
                        2 -> UnitType.LengthUnit
                        else -> {
                            throw RuntimeException("unsupport type = ${unitData.wireType}")
                        }
                    }
                }
                is LengthData -> {
                    UnitType.ValueUnit
                }
                is ValueData -> {
                    UnitType.TypeUnit
                }
                else -> {
                    throw RuntimeException("unsupport type UnitData = ${unitData.javaClass}")
                }
            }

        }
    }

}

enum class UnitType {
    TypeUnit,
    LengthUnit,
    ValueUnit
}

enum class ValueType {
    //默认类型
    DefaultValue,

    //WireType == 0时的sint32类型数据
    SintValue,

    //WireType == 0时的sint64类型数据
    SlongValue,

    //WireType == 0时的bool类型数据
    BooleanValue,

    //WireType == 1时的fixed64和sfixed64类型数据
    FixedLongValue,

    //WireType == 1时的Double类型数据
    DoubleValue,

    //WireType == 2时的embedded messages类型数据
    EmbeddedValue,

    //WireType == 2时的sint64类型数据
    BytesValue,

    //WireType == 2时的string类型数据
    StringValue,

    //WireType == 2时的packed repeated fields类型数据
    RepeatValue,

    //WireType == 5时的Float类型数据
    FloatValue,

    //WireType == 5时的fixed32和sfixed32类型数据
    FixedIntValue;

    companion object {
        var valueMap = hashMapOf<Int, List<ValueType>>(
            -1 to arrayListOf(DefaultValue),
            0 to arrayListOf(DefaultValue, SintValue, SlongValue, BooleanValue),
            1 to arrayListOf(FixedLongValue, DoubleValue),
            2 to arrayListOf(StringValue, BytesValue, EmbeddedValue, RepeatValue),
            5 to arrayListOf(FixedIntValue, FloatValue)
        )

        fun getValueType(wireType: Int): ValueType {
            return if (valueMap.containsKey(wireType)) {
                valueMap[wireType]!![0]
            } else {
                throw RuntimeException("unsupport WireType:$wireType")
            }
        }

    }
}

