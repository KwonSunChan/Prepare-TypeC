A형 대비
===============


## 기본 팁 

### 1. cin/cout 대신에 scanf/printf 사용

입출력 함수의 성능차이가 많이 나기 때문에 scanf/printf를 사용하자  
Java의 경우 BufferedReader/BufferedWriter 를 사용해 보자

### 2. C로 풀더라도 CPP 컴파일러를 사용하자

CPP 컴파일러가 보다 자세한 오류 사유를 리턴해주는 경우가 많다


### 3. 난이도가 올라갈수록 문제를 바로 푸는 것보다 어떻게 풀 것인지를 오래 고민하자

B형 이상의 난이도의 경우에는 30분 ~ 1시간 이상을 생각하고 완전한 풀이 전략을 세우고 시작해야 한다


### 4. Segmentation fault가 뜬다면 올바른 참조를 하고 있는지 확인하자

Visual studio의 경우에는 올바르지 않은 메모리를 write 하더라도 넘어가는 경우가 많지만, 채점 컴파일러는 read만 하더라도 오류가 발생한다

### 5. Big-O와 시간 복잡도에 대한 이해를 해보자

C는 1초에 10억번, java는 1초에 1억번, Python은 1초에 1백만번의 연산 가능

### 6. 자료구조에 대한 이해를 해보자.

같은 알고리즘이라도 선택한 자료구조에 따라서 결과가 달라진다.


## A형 돌파 전략

### 1. A형에 나오는 문제들?

Intermediate에서 Advanced 사이의 2문제 출제

2문제를 모두 풀면 A+(Advanced) 등급 획득

A : 경우의 수 or 상태 관리

A+ : 경우의 수 and 상태 관리

A 문제 예시 : https://www.acmicpc.net/problem/14503

A+ 문제 예시 : https://www.acmicpc.net/problem/17472


### 2. A형 돌파를 위해 학습해야 하는 것들

경우의 수를 만드는 것과 상태 관리를 학습한다

전체 경우의 수를 만들지 못하는 사람은 A+ 등급을 획득할 수 없다 


### 3. 경우의 수(재귀)

전체 경우의 수를 만드는 가장 쉬운 방법은 재귀함수를 이용하는 것이다

재귀를 이용한 방법은 매우 느리고 메모리를 많이 사용하지만

정답을 얻을 수 있는 가장 확정적인 방법이다

따라서 모든 학습자는 반드시 재귀 함수를 만드는 방법을 알아야 하며

재귀 함수를 이용한 완전 검색에서 출발하여 가지치기를 이용한 백트래킹의 기법으로

나아가는 것이 바람직하다

재귀 함수의 경우 가지치기나 메모이제이션을 추가하기 매우 쉽기 때문에

Advanced 난이도에서 필요한 최적화를 추가하기에 적합하다

***

재귀함수의 기본적인 구조, 자기 자신을 호출하기 전에 반드시 종료 조건이 있어야 한다

<pre><code>
void recursive(int n){
    //종료조건
    if(n == 10){
        return;
    }
    //자기 자신을 호출
    recursive(n + 1);
}

int main(){
    recursive(0);
    return 0;
}
</code></pre>


### 4. 상태 관리 ( 시뮬레이션 )

문제 풀이에 있어서 상태란 진행 상황을 특정 시점에서 바라본 모습이다

예를 들어, 2개의 주사위를 차례로 던지는데 1개를 던졌을 때라거나

2개의 파란공과 2개의 빨간공이 들어있는 주머니에서 1개의 빨간공을 꺼냈을 때와 같은 것들이다

이처럼 특정한 상태를 기록하고 기억하는 것을 상태 관리라고 한다

상태 관리만 존재하는 문제들은 여러 가지 유형이 있는데, 가장 대표적인 것이

원자 충돌과 같은 문제이다

***
상태 관리 문제 예시)

4방향으로 움직이고 있는 원자들이 있다

이 원자들은 서로 충돌하면 사라지게 된다

원자들의 움직임을 무한히 진행한다고 했을 때 최종적으로 남는 원자의 개수를 구하시오
***

위와 같은 문제는 별도로 경우의 수를 생성할 필요가 없으며

상태 관리만 처리하게 되면 정답에 도달할 수 있다

A형의 경우 상태 관리만 존재하는 문제가 자주 출제되며, 상태 관리는 각 문제마다 다르기 때문에 

여러 문제를 접하면 접할수록 상태 관리에 대한 실력이 늘게 된다


### 5. 완전 검색

완전 검색은 그래프 문제를 풀 수 있는 가장 느린 방법이며, 주로 재귀를 이용하게 된다

재귀를 이용한 완전 검색은 매우 느리고 비효율적인 방법이지만, 단 몇 라인 수준의

최적화 코드만 삽입하더라도 상당한 수준의 최적화가 가능하기 때문에 다음 단계로 나아가기 위한

징검다리로서 활용하는 것이 바람직하다

전체 경우의 수를 만들어낼 줄 알아야 하는 것은 B형 응시자에게도 공통적인 사항인데,

역설적으로 전체 경우의 수를 볼 수 없다면 최적화된 풀이도 불가능하기 때문이다

A형 풀이를 위해서는 완전 검색을 위한 순열, 조합 등에도 익숙해져야 한다


### 6. DFS(깊이우선탐색)

깊이우선탐색은 최소값 혹은 최단거리 문제에서 자주 사용되는 풀이 방법이다

한 지점에서 출발해서 도착지(혹은 그래프의 마지막 정점)에 도달할 때까지 이동하며,

재귀를 이용한 구현을 주로 사용한다

재귀를 이용해서 전체 경우의 수를 만드는 것이 쉽기 때문에 A형에서는 자주 사용되는 방법이다.

| ![dfs](./image/dfs.png) |
|:---------:|



### 7. BFS(너비우선탐색)

너비 우선 탐색은 우선순위 큐 등을 응용할 때 가끔 사용되지만 A형에서는 자주 쓰지 않는다

for문과 큐를 이용하는 방법이 자주 사용된다

| ![bfs](./image/bfs.png) |
|:---------:|


### 8. backtracking(백트래킹)

백트래킹은 완전 검색에서 나아가 상당한 수준의 최적화를 이루는 방법이다

주로 가지치기(pruning)나 메모이제이션(memoization) 등의 방법을 활용하고

두 가지 모두 활용하는 경우가 많다

이 때문에 그래프 문제의 경우 많은 경우에서 BFS보다 DFS가 성능면에서 우수한 경우가 많다

잘 짠 백트래킹은 다이나믹 프로그래밍(DP)보다 빠르다.

| ![backtracking](./image/backtracking.png) |
|:---------:|


### 9. memoization(메모이제이션)

문제를 풀어나가면서 도출한 중간 값을 메모하면서 푸는 방법이다

중복 연산을 줄일 수 있기 때문에 모든 경우의 수를 봐야하는 문제에서 매우 높은 성능 향상이 있으며,

몇 줄의 코드 만으로도 엄청난 성능 향상을 가져올 수 있다

메모리의 한계로 모든 경우의 수를 다 저장하지 못하는 경우에도 일부만 메모이제이션을 하더라도

상당한 수준의 성능 향상이 가능하다


### 10. DP(다이나믹 프로그래밍)

잘 짠 백트래킹은 다이나믹 프로그래밍(DP)보다 빠르다

### 11. 네트워크 플로우  
 
정해진 조건이 없이 데이터가 들어올 경우 풀이 하는 방법이다.  
  
데이터의 크기가 적고 제한적이면 배열로 쉽게 풀이가 가능하나, 메모리 손해가 크다.  
  
그 이상의 많은 데이터가 들어오거나 어느 정도가 들어오는지 모르는 경우 리스트로 풀어야 한다.  
  
리스트로 풀이는 매우 복잡하고 신경 써줘야 하는 부분이 많다.  

| ![network flow](./image/networkFlow.png) |
|:---------:|





## 자료구조
### 1. Stack
> 먼저 들어간 데이터가 나중에 나오는 자료구조
> 1. 장점  
>	 - 구현이 쉽다.  
>	 - 원하는 데이터의 접근 속도가 빠르다. ex) arr[2]를 사용하여 3번째 데이터에 바로 접근 가능  
>	 - 최근 생성된 데이터 순으로 처리할 때 좋다.  
> 1. 단점  
>	 - 데이터의 최대 개수를 미리 정해야 한다.  
>	 - 데이터의 삽입과 삭제에 있어서 비효율적이다.  
> 1. 추천 알고리즘 문제
>	 - https://www.acmicpc.net/problem/2504  괄호의 값

| ![스택](./image/stack.png) |
|:---------:|

#### 예시코드
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

--------------------

### 2. Queue  
> 먼저 들어간 데이터가 먼저 나오는 구조
> 1. 장점  
>	 - 데이터가 입력된 시간 순서대로 처리해야 할 필요가 있는 상황에 유리하다. 
> 1. 단점  
>	 - 크기가 제한적이다.
>	 - 큐의 앞 부분이 비어도 데이터를 삽입할 수 없다. => 메모리 낭비, 관리의 어려움
>	 - 큐가 Empty여도 Not Empty라 판단할 수 있다. => 추가적인 조치사항이 필요하다. 구현의 어려움
> 1. 추천 알고리즘 문제
>	 - https://www.acmicpc.net/problem/2905  홍준이와 울타리  

| ![큐](./image/Queue.png) |
|:---------:|

#### 예시코드
```c++
class Queue {
private:
	int front;
	int rear;
	int arr[100000];
	int size;

public:
	Queue() {
		size = 100000;
		front = 0;
		rear = 1;
	}
	bool isEmpty() {
		return ((size + rear) - front) % size == 1;
	}
	bool isFull() {
		return front == rear;
	}
	void add(int i) {
		if (!isFull()) {
			arr[rear] = i;
			rear = (rear + 1) % size;
		}
	}
	int remove() {
		int value = -11111111;
		if (!isEmpty()) {
			front = (front + 1) % size;
			value = arr[front];
		}
		return value;
	}
	int peek() {
		int value = -11111111;
		if (!isEmpty()) {
			value = arr[(front + 1) % size];
		}
		return value;
	}
};

```
--------------------

### 3. Linked List
> 리스트의 자료를 순차적으로 정리해 놓은 것을 말한다. 
> 1. 장점  
>	 - 자료가 입력 될 때마다 동적할당으로 새로운 메모리를 할당하므로 메모리 관리 용이 
>	 - 삽입과 삭제에 대한 오버헤드가 적다.  
>	 - 대부분의 상황에서 배열보다 삽입과 삭제가 빠르다.  
> 1. 단점  
>	 - 포인터 부분을 모든 데이터마다 가지고 있어야 해서 같은 크기의 배열보다 메모리 낭비가 있다.
>	 - 원하는 데이터의 검색이 느리다.
>	 - 구현의 어려움. 
> 1. 추천 알고리즘 문제
>	 - https://www.acmicpc.net/problem/1158  요세푸스 문제  
>	 - https://www.acmicpc.net/problem/2983  개구리 공주  

| ![단순 연결 리스트](./image/SimpleLinkedList.png) |
|:---------:|
| ![이중 연결 리스트](./image/doublyLinkedList.png) |

#### 예시코드
```c++
class Link {
public:
	int item;

	Link* next;
	Link* prev;
};

class Linked_List {
private:
	Link* head;
	Link* idx;
public:
	Linked_List() {
		head = new Link();
		idx = head;
	}

	void add(int val) {
		Link* item = new Link();
		item->item = val;
		idx->next = item;
		item->prev = idx;
		idx = idx->next;

	}

	void inserEnd() {
		idx->next = head->next;
		head->next->prev = idx;
		head->prev = idx;
		idx = head;
	}

	Link* getIdx() {
		return idx;
	}

};

```


--------------------



# 마지막으로..


| ![링컨](./image/링컨.png) |
|:---------:|


> 나무를 베는데 한 시간이 주어진다면, 도끼를 가는데 45분을 쓰겠다.  
  
  
> *난이도가 올라갈수록 문제를 바로 푸는 것보다 어떻게 풀 것인지를 오래 고민하자*  
  
   
> 기능 별로 함수로 구현을 하면 디버깅이 쉽다.  
  
  
> 예외 상황을 늘 생각해 보자. ex) 데이터가 없는 경우, 배열 인덱스 관리, 무한 루프에 빠지는지 
  
  
> 디버깅하는 법을 숙지하면 에러관리에 도움이 된다.   






