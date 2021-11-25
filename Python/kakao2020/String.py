# 2020 카카오 블라인드 채용 : 문자열 압축 

def solution(s):
    results = []
    # // : 나누기 후 소수점 버림
    for i in range(1, (len(s) //2) +1):
        cnt = 0
        answer =""

        for j in range(0, len(s), i) :
            if s[j:j+i] != s[j+i:j+i+i] :
                if cnt > 0:
                    answer += str(cnt+1) +s[j:j+i]
                    cnt =0
                else:
                    answer += s[j :j+i]

            else :
                cnt +=1 
        results.append(answer)

    minimum = len(s)
    for el in results :
        if len(el) < minimum and len(s)!= 0 :
            minimum = len(el)
    return minimum

print(solution("aabbaccc"))