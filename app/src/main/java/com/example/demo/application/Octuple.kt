@file:kotlin.jvm.JvmName("TuplesKt")

package com.example.demo.application

import java.io.Serializable
import kotlin.Triple

public data class Octuple<out A, out B, out C, out D, out E, out F, out G, out H>(
    public val first: A,
    public val second: B,
    public val third: C,
    public val fourth: D,
    public val fifth: E,
    public val sixth: F,
    public val seventh: G,
    public val eighth: H
) : Serializable {

    /**
     * Returns string representation of the [Triple] including its [first], [second] and [third] values.
     */
    public override fun toString(): String = "($first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth)"
}

/**
 * Converts this triple into a list.
 * @sample samples.misc.Tuples.tripleToList
 */
public fun <T> Octuple<T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth)