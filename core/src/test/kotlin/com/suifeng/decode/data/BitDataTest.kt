package com.suifeng.decode.data

import com.google.protobuf.ByteString
import com.suifeng.decode.ProtoReader
import com.suifeng.decode.parser.*
import com.suifeng.decode.proto.ProtoDemo
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 *@author suifengczc
 *@date 2020/10/19
 */
class BitDataTest {

    @Test
    fun hasNext1Test() {
        var hasNext1 = BitData(1).hasNext()
        assertEquals(false, hasNext1)
        var hasNext11 = BitData(-5).hasNext()
        assertEquals(true, hasNext11)
    }

    @Test
    fun getIntVauleTest() {
        assertEquals(1, BitData(1).getValue())
        assertEquals(118, BitData(-10).getValue())
    }

    @Test
    fun testIndex() {
        var list = arrayListOf<String>("a", "b", "c", "d")
        for ((index, i) in (list.size - 1 downTo 0).withIndex()) {
            println("index = $index , i = $i , value = ${list[i]}")
        }
    }

    @Test
    fun testGeneral() {
        var newBuilder = ProtoDemo.Test1.newBuilder()
        newBuilder.a = -128
        newBuilder.b = 1000000458600000000
//        newBuilder.c = 15
//        newBuilder.d = 5000000458600000000
//        newBuilder.e = -11
//        newBuilder.f = -2345482346
//        newBuilder.g = true
//        newBuilder.h = ProtoDemo.Test1.PhoneType.WORK
//        newBuilder.i = -1235
//        newBuilder.j = -1239
//        newBuilder.k = 50.11
//        newBuilder.l = "alkgjean354"
//        newBuilder.m = ByteString.copyFrom(byteArrayOf(-99, 2, 3))
        val embedded = ProtoDemo.Test1.Test2.newBuilder()
        embedded.a = 11
        newBuilder.n = embedded.build()
        newBuilder.addO(0)
        newBuilder.addO(1)
        newBuilder.addO(2)
//        newBuilder.p = 13
//        newBuilder.q = -14
//        newBuilder.r = 3.14F
        var build = newBuilder.build()
        var byteArray = build.toByteArray()
//        byteArray.let {
//            for (byte in it) {
//                println("$byte - ${BitData(byte)}")
//            }
//        }
        var read = ProtoReader.read(byteArray)
//        for (bitData in read) {
//            println("bitdata = ${bitData.getString()} - ${bitData.hasNext()}")
//        }
        var read1 = ProtoReader.read(read)
        read1[read1.size - 4].changeParser(EmbeddedParser())
        read1[read1.size - 1].changeParser(RepeatParser())
        for (unitData in read1) {
            println("${unitData.toString()}")
        }

    }
}