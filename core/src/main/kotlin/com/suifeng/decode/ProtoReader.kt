package com.suifeng.decode

import com.suifeng.decode.data.*

/**
 *@author suifengczc
 *@date 2020/10/16
 */
class ProtoReader {
    companion object {
        /**
         * 读取ByteArray为BitData List
         * @return List<BitData>
         */
        fun read(datas: ByteArray): List<BitData> {
            val rst = ArrayList<BitData>()
            for (data in datas) {
                var bitData = BitData(data)
                rst.add(bitData)
            }
            return rst
        }

        /**
         * 遍历List<BitData>，解析为T-L-V格式的List<UnitData>
         * @return List<UnitData>
         */
        fun read(bitList: List<BitData>, indent: Int = 0): List<AbstractUnitData> {
            val rst = ArrayList<AbstractUnitData>()
            var type = UnitType.TypeUnit
            var lastType: UnitType
            var lastWireType: Int = -1
            var index = 0
            //遍历BitData
            while (index < bitList.size) {
                var bitData = bitList[index]
                UnitDataBuilder.add(bitData)
                index++
                if (!bitData.hasNext()) {
                    val unitData =
                        UnitDataBuilder.build(type, ValueType.getValueType(lastWireType)).apply { this.indent = indent }
                    rst.add(unitData)
                    lastType = type
                    type = AllType.nextType(unitData)
                    //当上一个数据块是LengthData且当前是ValueData时，按LengthData的长度读取BitData
                    if (UnitType.ValueUnit == type && UnitType.LengthUnit == lastType) {
                        val length = (unitData as LengthData).length
                        for (i in 0 until length) {
                            UnitDataBuilder.add(bitList[index + i])
                        }
                        val valueData = UnitDataBuilder.build(type, ValueType.getValueType(lastWireType))
                            .apply { this.indent = indent }
                        rst.add(valueData)
                        type = AllType.nextType(valueData)
                        index += length
                    } else if (UnitType.TypeUnit == lastType) {
                        lastWireType = (unitData as TypeData).wireType
                        println("lastWireType = $lastWireType")
                        var length = when (lastWireType) {
                            1 -> {
                                8
                            }
                            5 -> {
                                4
                            }
                            else -> {
                                continue
                            }
                        }
                        for (i in 0 until length) {
                            UnitDataBuilder.add(bitList[index + i])
                        }
                        val valueData = UnitDataBuilder.build(type, ValueType.getValueType(lastWireType))
                            .apply { this.indent = indent }
                        rst.add(valueData)
                        type = AllType.nextType(valueData)
                        index += length
                    }
                }
            }
            return rst
        }

        fun readRepeatData(bitList: List<BitData>, indent: Int = 0): List<AbstractUnitData> {
            var index = 0
            val rst = ArrayList<AbstractUnitData>()
            while (index < bitList.size) {
                var bitdata = bitList[index]
                UnitDataBuilder.add(bitdata)
                index++
                if (!bitdata.hasNext()) {
                    val unitData =
                        UnitDataBuilder.build(UnitType.ValueUnit, ValueType.DefaultValue).apply { this.indent = indent }
                    rst.add(unitData)
                }
            }
            return rst
        }
    }
}