def solution(n,arr1,arr2) :
    answer =[]
    #내장함수zip ()
    for i, j in zip(arr1,arr2):
        #비트연산 : 각자릿수를 비교항 둘 중 하나만 1이면 1 #0b를 떼어내기
        a12 = str(bin(i|j)[2:])
        print(a12)
        #rjust : 오른쪽 정렬 + (문자열을 채울 자리숫자, 공백에 채워넣을 것) 
        a12 = a12.rjust(n,'0') # n자리로 하고 없는 자리는 0으로 채우기
        a12 = a12.replace('1','#') #1을 #으로 바꾸기
        a12 = a12.replace('0',' ') #0을 공백으로 하기
        answer.append(a12)
    return answer


numbers=[1,2,3]
letters =["a","b","c"]
for pair in zip(numbers,letters):
    print(pair)

# (1, 'a')
# (2, 'b')
# (3, 'c')

bin(13)
print(bin(13)) #0b1101



n = 5
arr1 = [9, 20, 28, 18, 11]
arr2 = [30, 1, 21, 17, 28]
print(solution(5,arr1,arr2))