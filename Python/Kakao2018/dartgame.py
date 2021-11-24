#다트 게임 파이썬 풀이
import re

def solution(dartResult) :
    bonus = {'S' : 1, 'D' :2 ,'T': 3}
    option = {'' :1, '*' :2, '#' :-1}

    p = re.compile('(\d+)([SDT])([*#]?)')
    dart = p.findall(dartResult)
    print(dart) #[('1', 'D', ''), ('2', 'S', '#'), ('10', 'S', '')]
    print(len(dart)) #3
    for i in range(len(dart)) :
        # 첫번째가 아니고 *가 나오면 앞에 점수도 2배시키기
        if dart[i][2] == '*' and i >0:
            dart[i-1] *=2
        dart[i] = int(dart[i][0]) ** bonus[dart[i][1]] * option[dart[i][2]] #dart에 다시 넣기
    print(dart) #[1, -2, 10]
    answer = sum(dart)
    return answer

print(solution('1D2S#10S'))
