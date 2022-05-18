package com.annushkaproject.programmerscalculator.utils

import com.annushkaproject.programmerscalculator.model.Operator
import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel
import com.annushkaproject.programmerscalculator.model.int_size_enum
import java.math.BigDecimal

object ProgrammerOperationsUtil {
    @JvmStatic
    fun calculateWithData(data: ProgrammerCalcModel): Long {
        return when (data.operator) {
            Operator.ADD -> addSubtract(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.SUBTRACT -> addSubtract(data.bytelengthenum, data.firstValue, data.secondValue.negate())
            Operator.MULTIPLY -> multiply(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.remainder_divide -> divide(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.LSH -> lsh(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.RSH -> rsh(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.OR -> or(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.XOR -> xor(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.AND -> and(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.get_remainder -> mod(data.bytelengthenum, data.firstValue, data.secondValue)
            Operator.CHANGE_SIGN -> changeSign(data.bytelengthenum, data.firstValue)
            Operator.NOT -> not(data.bytelengthenum, data.firstValue)
            else -> 0
        }
    }

    private fun addSubtract(mode: int_size_enum, value1: BigDecimal, value2: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value1.toLong() + value2.toLong()
            int_size_enum.l4 -> (value1.toInt() + value2.toInt()).toLong()
            int_size_enum.l2 -> (value1.toShort() + value2.toShort()).toShort()
            int_size_enum.l1 -> (value1.toByte() + value2.toByte()).toByte()
            else -> 0
        }
    }

    private fun changeSign(mode: int_size_enum, value: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value.negate().toLong()
            int_size_enum.l4 -> value.negate().toInt().toLong()
            int_size_enum.l2 -> value.negate().toShort().toLong()
            int_size_enum.l1 -> value.negate().toByte().toLong()
            else -> 0
        }
    }

    private fun lsh(mode: int_size_enum, value: BigDecimal, shift: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value.toLong() shl shift.toInt()
            int_size_enum.l4 -> (value.toInt() shl shift.toInt()).toLong()
            int_size_enum.l2 -> ((value.toShort() shl shift.toInt()) as Short).toLong()
            int_size_enum.l1 -> ((value.toByte() shl shift.toInt()) as Byte).toLong()
            else -> 0
        }
    }

    private fun rsh(mode: int_size_enum, value: BigDecimal, shift: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value.toLong() shr shift.toInt()
            int_size_enum.l4 -> (value.toInt() shr shift.toInt()).toLong()
            int_size_enum.l2 -> ((value.toShort() shr shift.toInt()) as Short).toLong()
            int_size_enum.l1 -> ((value.toByte() shr shift.toInt()) as Byte).toLong()
            else -> 0
        }
    }

    private fun not(mode: int_size_enum, value: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value.toLong().inv()
            int_size_enum.l4 -> value.toInt().inv().toLong()
            int_size_enum.l2 -> (value.toShort().inv() as Short).toLong()
            int_size_enum.l1 -> (value.toByte().inv() as Byte).toLong()
            else -> 0
        }
    }

    private fun or(mode: int_size_enum, value1: BigDecimal, value2: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value1.toLong() or value2.toLong()
            int_size_enum.l4 -> (value1.toInt() or value2.toInt()).toLong()
            int_size_enum.l2 -> ((value1.toShort() or value2.toShort()) as Short).toLong()
            int_size_enum.l1 -> ((value1.toByte() or value2.toByte()) as Byte).toLong()
            else -> 0
        }
    }

    private fun xor(mode: int_size_enum, value1: BigDecimal, value2: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value1.toLong() xor value2.toLong()
            int_size_enum.l4 -> (value1.toInt() xor value2.toInt()).toLong()
            int_size_enum.l2 -> ((value1.toShort() xor value2.toShort()) as Short).toLong()
            int_size_enum.l1 -> ((value1.toByte() xor value2.toByte()) as Byte).toLong()
            else -> 0
        }
    }

    private fun and(mode: int_size_enum, value1: BigDecimal, value2: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value1.toLong() and value2.toLong()
            int_size_enum.l4 -> (value1.toInt() and value2.toInt()).toLong()
            int_size_enum.l2 -> ((value1.toShort() and value2.toShort()) as Short).toLong()
            int_size_enum.l1 -> ((value1.toByte() and value2.toByte()) as Byte).toLong()
            else -> 0
        }
    }

    private fun mod(mode: int_size_enum, dividend: BigDecimal, divider: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> dividend.toLong() % divider.toLong()
            int_size_enum.l4 -> (dividend.toInt() % divider.toInt()).toLong()
            int_size_enum.l2 -> (dividend.toShort() % divider.toShort()).toShort()
            int_size_enum.l1 -> (dividend.toByte() % divider.toByte()).toByte()
            else -> 0
        }
    }

    private fun multiply(mode: int_size_enum, value1: BigDecimal, value2: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> value1.toLong() * value2.toLong()
            int_size_enum.l4 -> (value1.toInt() * value2.toInt()).toLong()
            int_size_enum.l2 -> (value1.toShort() * value2.toShort()).toShort()
            int_size_enum.l1 -> (value1.toByte() * value2.toByte()).toByte()
            else -> 0
        }
    }

    private fun divide(mode: int_size_enum, dividend: BigDecimal, divider: BigDecimal): Long {
        return when (mode) {
            int_size_enum.l8 -> dividend.toLong() / divider.toLong()
            int_size_enum.l4 -> (dividend.toInt() / divider.toInt()).toLong()
            int_size_enum.l2 -> (dividend.toShort() / divider.toShort()).toShort()
            int_size_enum.l1 -> (dividend.toByte() / divider.toByte()).toByte()
            else -> 0
        }
    }
}