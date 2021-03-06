package intellij.education.olympiads

import java.io.*
import java.lang.*
import java.math.*
import java.util.*
import kotlin.math.sqrt


fun main(args: Array<String>) {
    MainKotlin().run()
}

private class MainKotlin {

    private fun solve() {
        out!!.println("Hello world!")
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private fun sqrtLong(x: Long): Long {
        var root = sqrt(x.toDouble()).toLong()
        while (root * root > x) --root
        while ((root + 1) * (root + 1) <= x) ++root
        return root
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private fun readLong(): Long {
        return readString()!!.toLong()
    }

    private fun readInt(): Int {
        return readString()!!.toInt()
    }

    private fun readChar(): Char {
        return readString()!!.single()
    }

    private fun readShort(): Short {
        return readString()!!.toShort()
    }

    private fun readDouble(): Double {
        return readString()!!.toDouble()
    }

    private fun readBigInteger(): BigInteger {
        return BigInteger.valueOf(readLong())
    }

    private fun readIntArray(size: Int): IntArray {
        val result: IntArray = IntArray(size)
        for (index in 0 until size) { result[index] = readInt() }
        return result
    }

    private fun readLongArray(size: Int): LongArray {
        val result: LongArray = LongArray(size)
        for (index in 0 until size) { result[index] = readLong() }
        return result
    }

    private fun readString(): String? {
        while (!tok!!.hasMoreTokens()) {
            val nextLine = readLine()
            tok = StringTokenizer(nextLine)
        }
        return tok!!.nextToken()
    }

    private fun readLine(): String {
        return try {
            `in`!!.readLine()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private var `in`: BufferedReader? = null
    private var tok: StringTokenizer? = null
    private var out: PrintWriter? = null

    @Throws(FileNotFoundException::class)
    private fun initFileIO(inputFileName: String, outputFileName: String) {
        `in` = BufferedReader(FileReader(inputFileName))
        out = PrintWriter(outputFileName)
    }

    @Throws(IOException::class)
    private fun initConsoleIO() {
        `in` = BufferedReader(InputStreamReader(System.`in`))
        out = PrintWriter(System.out)
    }

    @Throws(IOException::class)
    private fun initIO() {
        Locale.setDefault(Locale.US)
        val fileName = ""
        if (fileName.isNotEmpty()) {
            initFileIO("$fileName.in", "$fileName.out")
        } else {
            if (File("input.txt").exists()) {
                initFileIO("input.txt", "output.txt")
            } else {
                initConsoleIO()
            }
        }
        tok = StringTokenizer("")
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    fun run() {
        try {
            initIO(); solve()
            out!!.close()
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }
}