package study.w62

class StringCompression {

    // 문자열 길이: n
// 압출 범위: 1 ~ n/2(n/2 초과 부터 압출할 수 없기 떄문이다.)
// 1,000^2 = 1,000,000
// 결과: 압축 결과(길이)가 가장 짧은 방식

    fun solution(s: String): Int {
        if (s.length == 1) return 1
        val compressions: ArrayList<String> = ArrayList<String>()
        for (unit: Int in 1..s.length / 2) {
            val compression = StringBuilder()
            var pre = s.substring(0, unit)
            var count = 1
            for (i in unit until s.length step unit) {
                val now = if (i + unit > s.length) s.substring(i) else s.substring(i, i + unit)
                if (pre == now) {
                    count++
                } else {
                    compression.append(if (count > 1) "$count$pre" else pre)
                    count = 1
                    pre = now
                }
            }
            compression.append(if (count > 1) "$count$pre" else pre)
            compressions.add(compression.toString())
        }
        return compressions.sortedBy { it.length }[0].length
    }
}

fun main() {
    val solution = StringCompression().solution("aabbaccc")
    print(solution)
}
