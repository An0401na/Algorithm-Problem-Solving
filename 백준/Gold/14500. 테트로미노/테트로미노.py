import sys ; input = lambda:sys.stdin.readline().rstrip()
import copy

def flip_lr(paper):
    res = []
    for row in paper:
        res.append(list(reversed(row)))
    return res

n, m = map(int,input().split())
paper = [list(map(int,input().split())) for _ in range(n)]
max_sum = 4

# ㅁ 모양
for row_idx in range(n-1):
    for col_idx in range(m-1):
        sum = (paper[row_idx][col_idx]
               + paper[row_idx][col_idx+1]
               + paper[row_idx+1][col_idx]
               + paper[row_idx+1][col_idx+1])
        if sum > max_sum:
            max_sum = sum
            
# ㅡ 모양
for _ in range(2):
    for row_idx in range(len(paper)):
        for col_idx in range(len(paper[0])-3):
            sum = (paper[row_idx][col_idx]
                   + paper[row_idx][col_idx+1]
                   + paper[row_idx][col_idx+2]
                   + paper[row_idx][col_idx+3])
            if sum > max_sum:
                max_sum = sum
    paper = list(zip(*paper[::-1]))

# ㅜ 모양
for _ in range(4):
    for row_idx in range(len(paper)-1):
        for col_idx in range(len(paper[0])-2):
            sum = (paper[row_idx][col_idx]
                   + paper[row_idx][col_idx+1]
                   + paper[row_idx][col_idx+2]
                   + paper[row_idx+1][col_idx+1])
            if sum > max_sum:
                max_sum = sum
    paper = list(zip(*paper[::-1]))

# ㄴ 모양
for _ in range(2):
    for _ in range(4):
        for row_idx in range(len(paper)-2):
            for col_idx in range(len(paper[0])-1):
                sum = (paper[row_idx][col_idx]
                       + paper[row_idx+1][col_idx]
                       + paper[row_idx+2][col_idx]
                       + paper[row_idx+2][col_idx+1])
                if sum > max_sum:
                    max_sum = sum
        paper = list(zip(*paper[::-1]))
    paper = flip_lr(paper)
    
# ㄴㄱ 모양
for _ in range(2):
    for _ in range(2):
        for row_idx in range(len(paper)-2):
            for col_idx in range(len(paper[0])-1):
                sum = (paper[row_idx][col_idx]
                       + paper[row_idx+1][col_idx]
                       + paper[row_idx+1][col_idx+1]
                       + paper[row_idx+2][col_idx+1])
                if sum > max_sum:
                    max_sum = sum
        paper = list(zip(*paper[::-1]))
    paper = flip_lr(list(paper))

print(max_sum)