class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        val answer: String =my_string
        answer.substring(s..overwrite_string.length)
        return answer
    }
}