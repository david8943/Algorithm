def solution(s):
    answer = len(s)

    for i in range(1, len(s) // 2 + 1):  # 문자열 단위의 개수
        result = ''
        temp = 1
        prev = s[0:i]
        for j in range(i, len(s), i):
            if prev == s[j:j + i]:
                temp += 1
            else:
                result += str(temp) + prev if temp > 1 else prev
                prev = s[j:j + i]
                temp=1

        result += str(temp) + prev if temp > 1 else prev

        if len(result)<answer:
            answer=len(result)
    
    return answer