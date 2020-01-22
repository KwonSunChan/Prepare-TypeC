Prepare-TypeC
===============


### 1. 자료구조
#### 1-1. Stack
> 먼저 들어간 데이터가 나중에 나오는 자료구조

| ![스택](./image/stack.png) |
|:---------:|

##### 예시코드
```c++
class Stack {	
private:
	int top;
	int size;
	int arr[40];

public :
	Stack() {
		top = 0;
		size = 40;

	}

	void push(int c) {
		
		if (top < size) {
			arr[top++] = int(c);
		}
	}

	int pop() {
		int val = -1;
		if (!isEmpty()) {
			val = arr[--top];
		}
		return val;
	}

	bool isEmpty() {
		return top == 0;
	}
};

```










-------------------------

# 마지막으로..


| ![링컨](./image/링컨.png) |
|:---------:|


> 나무를 베는데 한 시간이 주어진다면, 도끼를 가는데 45분을 쓰겠다.


> *난이도가 올라갈수록 문제를 바로 푸는 것보다 어떻게 풀 것인지를 오래 고민하자*






